package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoEntregaEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.EntregaTerceroDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.EntregaTerceroEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.TerceroEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class EntregaTerceroSqlServerDAO extends SqlDAO implements EntregaTerceroDAO {

	public EntregaTerceroSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public EntregaTerceroEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    ete.id AS id,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona,
                    ter.id AS ter_id,
                    ter.nombre AS ter_nombre,
                    ter.nit AS ter_nit,
                    ter.numeroContacto AS ter_numeroContacto,
                    ter.correoContacto AS ter_correoContacto
                FROM EntregaTercero ete
                INNER JOIN Entrega ent ON ete.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                INNER JOIN Tercero ter ON ete.idTercero = ter.id
                WHERE ete.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirEntregaTerceroEntidad(resultado);
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR, excepcion.getMessage()),
					excepcion);
		}

		return new EntregaTerceroEntidad.Builder().build();
	}

	@Override
	public List<EntregaTerceroEntidad> consultarPorFiltro(EntregaTerceroEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    ete.id AS id,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona,
                    ter.id AS ter_id,
                    ter.nombre AS ter_nombre,
                    ter.nit AS ter_nit,
                    ter.numeroContacto AS ter_numeroContacto,
                    ter.correoContacto AS ter_correoContacto
                FROM EntregaTercero ete
                INNER JOIN Entrega ent ON ete.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                INNER JOIN Tercero ter ON ete.idTercero = ter.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ete.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEntrega().getId())) {
			condiciones.add("ete.idEntrega = ?");
			parametros.add(filtro.getEntrega().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getTercero().getId())) {
			condiciones.add("ete.idTercero = ?");
			parametros.add(filtro.getTercero().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<EntregaTerceroEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirEntregaTerceroEntidad(resultado));
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR, excepcion.getMessage()),
					excepcion);
		}

		return resultados;
	}

	@Override
	public List<EntregaTerceroEntidad> consultarTodos() {
		return consultarPorFiltro(new EntregaTerceroEntidad.Builder().build());
	}

	private EntregaTerceroEntidad construirEntregaTerceroEntidad(final ResultSet resultado) throws SQLException {

		final PersonaEntidad per = new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_idPersona")))
				.build();

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_id")))
				.codigoEntrega(resultado.getString("ent_codigoEntrega"))
				.fechaEntrega(resultado.getDate("ent_fechaEntrega").toLocalDate())
				.estadoEntrega(new EstadoEntregaEntidad.Builder()
						.id(UUID.fromString(resultado.getString("ent_estadoEntrega_id")))
						.codigo(resultado.getString("ent_estadoEntrega_codigo"))
						.nombre(resultado.getString("ent_estadoEntrega_nombre"))
						.build())
				.persona(per)
				.build();

		final TerceroEntidad ter = new TerceroEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ter_id")))
				.nombre(resultado.getString("ter_nombre"))
				.nit(resultado.getString("ter_nit"))
				.numeroContacto(resultado.getString("ter_numeroContacto"))
				.correoContacto(resultado.getString("ter_correoContacto"))
				.build();

		return new EntregaTerceroEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.entrega(ent)
				.tercero(ter)
				.build();
	}
}
