package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.TipoDireccionDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class TipoDireccionSqlServerDAO extends SqlDAO implements TipoDireccionDAO {

	public TipoDireccionSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoDireccionEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					tdi.id AS id,
					tdi.nombre AS nombre
				FROM TipoDireccion tdi

				WHERE tdi.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirTipoDireccionEntidad(resultado);
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

		return new TipoDireccionEntidad.Builder().build();
	}

	@Override
	public List<TipoDireccionEntidad> consultarPorFiltro(TipoDireccionEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					tdi.id AS id,
					tdi.nombre AS nombre
				FROM TipoDireccion tdi
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("tdi.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("tdi.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<TipoDireccionEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirTipoDireccionEntidad(resultado));
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
	public List<TipoDireccionEntidad> consultarTodos() {
		return consultarPorFiltro(new TipoDireccionEntidad.Builder().build());
	}

	private TipoDireccionEntidad construirTipoDireccionEntidad(final ResultSet resultado) throws SQLException {

		return new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.build();
	}
}
