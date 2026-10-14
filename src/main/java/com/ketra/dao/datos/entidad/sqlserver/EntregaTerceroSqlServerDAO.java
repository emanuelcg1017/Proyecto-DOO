package com.ketra.dao.datos.entidad.sqlserver;

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
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;

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
					ent.estadoEntrega AS ent_estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto
				FROM EntregaTercero ete
				INNER JOIN Entrega ent ON ete.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
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
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
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
					ent.estadoEntrega AS ent_estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto
				FROM EntregaTercero ete
				INNER JOIN Entrega ent ON ete.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
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
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return resultados;
	}

	@Override
	public List<EntregaTerceroEntidad> consultarTodos() {
		return consultarPorFiltro(new EntregaTerceroEntidad.Builder().build());
	}

	private EntregaTerceroEntidad construirEntregaTerceroEntidad(final ResultSet resultado) throws SQLException {

		final TipoDocumentoEntidad tdo = new TipoDocumentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdo_id")))
				.nombre(resultado.getString("tdo_nombre"))
				.build();

		final PersonaEntidad per = new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("per_id")))
				.tipoDocumento(tdo)
				.numeroIdentificacion(resultado.getString("per_numeroIdentificacion"))
				.primerNombre(resultado.getString("per_primerNombre"))
				.segundoNombre(resultado.getString("per_segundoNombre"))
				.primerApellido(resultado.getString("per_primerApellido"))
				.segundoApellido(resultado.getString("per_segundoApellido"))
				.numeroTelefonico(resultado.getString("per_numeroTelefonico"))
				.correoElectronico(resultado.getString("per_correoElectronico"))
				.build();

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_id")))
				.codigoEntrega(resultado.getString("ent_codigoEntrega"))
				.fechaEntrega(resultado.getDate("ent_fechaEntrega").toLocalDate())
				.estadoEntrega(resultado.getString("ent_estadoEntrega"))
				.persona(per)
				.build();

		final TerceroEntidad ter = new TerceroEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ter_id")))
				.nombre(resultado.getString("ter_nombre"))
				.NIT(resultado.getString("ter_nit"))
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
