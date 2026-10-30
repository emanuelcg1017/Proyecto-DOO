package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.PedidoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilFecha;

public class PedidoSqlServerDAO extends SqlDAO implements PedidoDAO {

	public PedidoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public PedidoEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    ped.id AS id,
                    ped.numeroPedido AS numeroPedido,
                    ped.fechaPedido AS fechaPedido
                FROM Pedido ped

                WHERE ped.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirPedidoEntidad(resultado);
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

		return new PedidoEntidad.Builder().build();
	}

	@Override
	public List<PedidoEntidad> consultarPorFiltro(PedidoEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    ped.id AS id,
                    ped.numeroPedido AS numeroPedido,
                    ped.fechaPedido AS fechaPedido
                FROM Pedido ped
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ped.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroPedido())) {
			condiciones.add("ped.numeroPedido = ?");
			parametros.add(filtro.getNumeroPedido());
		}

		if (!UtilFecha.FECHA_DEFECTO.equals(filtro.getFechaPedido())) {
			condiciones.add("ped.fechaPedido = ?");
			parametros.add(java.sql.Date.valueOf(filtro.getFechaPedido()));
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<PedidoEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirPedidoEntidad(resultado));
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
	public List<PedidoEntidad> consultarTodos() {
		return consultarPorFiltro(new PedidoEntidad.Builder().build());
	}

	@Override
	public void crear(PedidoEntidad entidad) {

		final String sql = """
                INSERT INTO Pedido (
                    id,
                    numeroPedido,
                    fechaPedido
                )
                VALUES (?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroPedido());
			sentencia.setDate(3, java.sql.Date.valueOf(entidad.getFechaPedido()));

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

	private PedidoEntidad construirPedidoEntidad(final ResultSet resultado) throws SQLException {

		return new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroPedido(resultado.getString("numeroPedido"))
				.fechaPedido(resultado.getDate("fechaPedido").toLocalDate())
				.build();
	}
}
