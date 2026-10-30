package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoServicioEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilFecha;

public class ServicioSqlServerDAO extends SqlDAO implements ServicioDAO {

	public ServicioSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public ServicioEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    ser.id AS id,
                    ser.numeroServicio AS numeroServicio,
                    ser.fechaServicio AS fechaServicio,
                    ess.id AS estado_id,
                    ess.codigo AS estado_codigo,
                    ess.nombre AS estado_nombre
                FROM Servicio ser
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id

                WHERE ser.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirServicioEntidad(resultado);
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

		return new ServicioEntidad.Builder().build();
	}

	@Override
	public List<ServicioEntidad> consultarPorFiltro(ServicioEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    ser.id AS id,
                    ser.numeroServicio AS numeroServicio,
                    ser.fechaServicio AS fechaServicio,
                    ess.id AS estado_id,
                    ess.codigo AS estado_codigo,
                    ess.nombre AS estado_nombre
                FROM Servicio ser
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ser.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroServicio())) {
			condiciones.add("ser.numeroServicio = ?");
			parametros.add(filtro.getNumeroServicio());
		}

		if (!UtilFecha.FECHA_DEFECTO.equals(filtro.getFechaServicio())) {
			condiciones.add("ser.fechaServicio = ?");
			parametros.add(java.sql.Date.valueOf(filtro.getFechaServicio()));
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEstado().getId())) {
			condiciones.add("ser.idEstadoServicio = ?");
			parametros.add(filtro.getEstado().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstado().getCodigo())) {
			condiciones.add("ess.codigo = ?");
			parametros.add(filtro.getEstado().getCodigo());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstado().getNombre())) {
			condiciones.add("ess.nombre = ?");
			parametros.add(filtro.getEstado().getNombre());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<ServicioEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirServicioEntidad(resultado));
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
	public List<ServicioEntidad> consultarTodos() {
		return consultarPorFiltro(new ServicioEntidad.Builder().build());
	}

	@Override
	public void crear(ServicioEntidad entidad) {

		final String sql = """
                INSERT INTO Servicio (
                    id,
                    numeroServicio,
                    fechaServicio,
                    idEstadoServicio
                )
                VALUES (?, ?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroServicio());
			sentencia.setDate(3, java.sql.Date.valueOf(entidad.getFechaServicio()));
			sentencia.setObject(4, entidad.getEstado().getId());

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CREAR, excepcion.getMessage()),
					excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, ServicioEntidad entidad) {

		final String sql = """
                UPDATE Servicio
                SET idEstadoServicio = ?
                WHERE id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getEstado().getId());
			sentencia.setObject(2, id);

			if (sentencia.executeUpdate() != 1) {
				throw new SQLException(CatalogoMensajes.SqlServerDAO.TECNICO_REGISTRO_NO_ENCONTRADO);
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ACTUALIZAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ACTUALIZAR, excepcion.getMessage()),
					excepcion);
		}
	}

	private ServicioEntidad construirServicioEntidad(final ResultSet resultado) throws SQLException {

		return new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroServicio(resultado.getString("numeroServicio"))
				.fechaServicio(resultado.getDate("fechaServicio").toLocalDate())
				.estado(new EstadoServicioEntidad.Builder()
						.id(UUID.fromString(resultado.getString("estado_id")))
						.codigo(resultado.getString("estado_codigo"))
						.nombre(resultado.getString("estado_nombre"))
						.build())
				.build();
	}
}
