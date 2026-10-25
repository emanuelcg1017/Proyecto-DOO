package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.TipoDocumentoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class TipoDocumentoSqlServerDAO extends SqlDAO implements TipoDocumentoDAO {

	public TipoDocumentoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoDocumentoEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					tdo.id AS id,
					tdo.nombre AS nombre
				FROM TipoDocumento tdo

				WHERE tdo.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirTipoDocumentoEntidad(resultado);
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

		return new TipoDocumentoEntidad.Builder().build();
	}

	@Override
	public List<TipoDocumentoEntidad> consultarPorFiltro(TipoDocumentoEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					tdo.id AS id,
					tdo.nombre AS nombre
				FROM TipoDocumento tdo
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("tdo.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("tdo.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<TipoDocumentoEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirTipoDocumentoEntidad(resultado));
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
	public List<TipoDocumentoEntidad> consultarTodos() {
		return consultarPorFiltro(new TipoDocumentoEntidad.Builder().build());
	}

	private TipoDocumentoEntidad construirTipoDocumentoEntidad(final ResultSet resultado) throws SQLException {

		return new TipoDocumentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.build();
	}
}
