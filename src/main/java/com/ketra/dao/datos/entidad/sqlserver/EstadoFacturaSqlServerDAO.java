package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.EstadoFacturaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EstadoFacturaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class EstadoFacturaSqlServerDAO extends SqlDAO implements EstadoFacturaDAO {

	public EstadoFacturaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public EstadoFacturaEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    est.id AS id,
                    est.codigo AS codigo,
                    est.nombre AS nombre
                FROM EstadoFactura est

                WHERE est.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirEstadoFacturaEntidad(resultado);
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

		return new EstadoFacturaEntidad.Builder().build();
	}

	@Override
	public List<EstadoFacturaEntidad> consultarPorFiltro(EstadoFacturaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    est.id AS id,
                    est.codigo AS codigo,
                    est.nombre AS nombre
                FROM EstadoFactura est
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("est.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCodigo())) {
			condiciones.add("est.codigo = ?");
			parametros.add(filtro.getCodigo());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("est.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<EstadoFacturaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirEstadoFacturaEntidad(resultado));
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
	public List<EstadoFacturaEntidad> consultarTodos() {
		return consultarPorFiltro(new EstadoFacturaEntidad.Builder().build());
	}

	private EstadoFacturaEntidad construirEstadoFacturaEntidad(final ResultSet resultado) throws SQLException {

		return new EstadoFacturaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.codigo(resultado.getString("codigo"))
				.nombre(resultado.getString("nombre"))
				.build();
	}
}
