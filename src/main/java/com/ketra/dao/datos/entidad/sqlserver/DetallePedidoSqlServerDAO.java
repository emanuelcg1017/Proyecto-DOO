package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.DetallePedidoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.DetallePedidoEntidad;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class DetallePedidoSqlServerDAO extends SqlDAO implements DetallePedidoDAO {

	public DetallePedidoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DetallePedidoEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    dpe.id AS id,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido,
                    dpe.codigoBarras AS codigoBarras
                FROM DetallePedido dpe
                INNER JOIN Pedido ped ON dpe.idPedido = ped.id
                WHERE dpe.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirDetallePedidoEntidad(resultado);
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

		return new DetallePedidoEntidad.Builder().build();
	}

	@Override
	public List<DetallePedidoEntidad> consultarPorFiltro(DetallePedidoEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    dpe.id AS id,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido,
                    dpe.codigoBarras AS codigoBarras
                FROM DetallePedido dpe
                INNER JOIN Pedido ped ON dpe.idPedido = ped.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("dpe.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getNumeroPedido().getId())) {
			condiciones.add("dpe.idPedido = ?");
			parametros.add(filtro.getNumeroPedido().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCodigoBarras())) {
			condiciones.add("dpe.codigoBarras = ?");
			parametros.add(filtro.getCodigoBarras());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<DetallePedidoEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirDetallePedidoEntidad(resultado));
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
	public List<DetallePedidoEntidad> consultarTodos() {
		return consultarPorFiltro(new DetallePedidoEntidad.Builder().build());
	}

	@Override
	public void crear(DetallePedidoEntidad entidad) {

		final String sql = """
                INSERT INTO DetallePedido (
                    id,
                    idPedido,
                    codigoBarras
                )
                VALUES (?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setObject(2, entidad.getNumeroPedido().getId());
			sentencia.setString(3, entidad.getCodigoBarras());

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

	private DetallePedidoEntidad construirDetallePedidoEntidad(final ResultSet resultado) throws SQLException {

		final PedidoEntidad ped = new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ped_id")))
				.numeroPedido(resultado.getString("ped_numeroPedido"))
				.fechaPedido(resultado.getDate("ped_fechaPedido").toLocalDate())
				.build();

		return new DetallePedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroPedido(ped)
				.codigoBarras(resultado.getString("codigoBarras"))
				.build();
	}
}
