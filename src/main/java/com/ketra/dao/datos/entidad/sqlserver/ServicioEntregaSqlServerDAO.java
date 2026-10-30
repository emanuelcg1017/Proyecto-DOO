package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoEntregaEntidad;

import com.ketra.entidad.EstadoServicioEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioEntregaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioEntregaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class ServicioEntregaSqlServerDAO extends SqlDAO implements ServicioEntregaDAO {

	public ServicioEntregaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public ServicioEntregaEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    sen.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona
                FROM ServicioEntrega sen
                INNER JOIN Servicio ser ON sen.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                INNER JOIN Entrega ent ON sen.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                WHERE sen.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirServicioEntregaEntidad(resultado);
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

		return new ServicioEntregaEntidad.Builder().build();
	}

	@Override
	public List<ServicioEntregaEntidad> consultarPorFiltro(ServicioEntregaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    sen.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona
                FROM ServicioEntrega sen
                INNER JOIN Servicio ser ON sen.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                INNER JOIN Entrega ent ON sen.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("sen.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("sen.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEntrega().getId())) {
			condiciones.add("sen.idEntrega = ?");
			parametros.add(filtro.getEntrega().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<ServicioEntregaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirServicioEntregaEntidad(resultado));
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
	public List<ServicioEntregaEntidad> consultarTodos() {
		return consultarPorFiltro(new ServicioEntregaEntidad.Builder().build());
	}

	private ServicioEntregaEntidad construirServicioEntregaEntidad(final ResultSet resultado) throws SQLException {

		final ServicioEntidad ser = new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ser_id")))
				.numeroServicio(resultado.getString("ser_numeroServicio"))
				.fechaServicio(resultado.getDate("ser_fechaServicio").toLocalDate())
				.estado(new EstadoServicioEntidad.Builder()
						.id(UUID.fromString(resultado.getString("ser_estado_id")))
						.codigo(resultado.getString("ser_estado_codigo"))
						.nombre(resultado.getString("ser_estado_nombre"))
						.build())
				.build();

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

		return new ServicioEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.servicio(ser)
				.entrega(ent)
				.build();
	}
}
