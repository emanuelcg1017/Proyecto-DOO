package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoServicioEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioCEDIDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioCEDIEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class ServicioCEDISqlServerDAO extends SqlDAO implements ServicioCEDIDAO {

	public ServicioCEDISqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public ServicioCEDIEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    sce.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    ced.id AS ced_id,
                    ced.nombre AS ced_nombre,
                    ced.idDireccion AS ced_idDireccion,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido
                FROM ServicioCEDI sce
                INNER JOIN Servicio ser ON sce.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                INNER JOIN CEDI ced ON sce.idCedi = ced.id
                INNER JOIN Pedido ped ON sce.idPedido = ped.id
                WHERE sce.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirServicioCEDIEntidad(resultado);
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

		return new ServicioCEDIEntidad.Builder().build();
	}

	@Override
	public List<ServicioCEDIEntidad> consultarPorFiltro(ServicioCEDIEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    sce.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    ced.id AS ced_id,
                    ced.nombre AS ced_nombre,
                    ced.idDireccion AS ced_idDireccion,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido
                FROM ServicioCEDI sce
                INNER JOIN Servicio ser ON sce.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                INNER JOIN CEDI ced ON sce.idCedi = ced.id
                INNER JOIN Pedido ped ON sce.idPedido = ped.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("sce.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("sce.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getCedi().getId())) {
			condiciones.add("sce.idCedi = ?");
			parametros.add(filtro.getCedi().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getPedido().getId())) {
			condiciones.add("sce.idPedido = ?");
			parametros.add(filtro.getPedido().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<ServicioCEDIEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirServicioCEDIEntidad(resultado));
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
	public List<ServicioCEDIEntidad> consultarTodos() {
		return consultarPorFiltro(new ServicioCEDIEntidad.Builder().build());
	}

	private ServicioCEDIEntidad construirServicioCEDIEntidad(final ResultSet resultado) throws SQLException {

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

		final DireccionEntidad dir = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ced_idDireccion")))
				.build();

		final CEDIEntidad ced = new CEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ced_id")))
				.nombre(resultado.getString("ced_nombre"))
				.direccion(dir)
				.build();

		final PedidoEntidad ped = new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ped_id")))
				.numeroPedido(resultado.getString("ped_numeroPedido"))
				.fechaPedido(resultado.getDate("ped_fechaPedido").toLocalDate())
				.build();

		return new ServicioCEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.servicio(ser)
				.cedi(ced)
				.pedido(ped)
				.build();
	}
}
