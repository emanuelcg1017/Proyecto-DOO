package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.DepartamentoEntidad;
import com.ketra.entidad.PaisEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class DepartamentoSqlServerDAO extends SqlDAO implements DepartamentoDAO {

	public DepartamentoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					dep.id AS id,
					dep.nombre AS nombre,
					pai.id AS pai_id,
					pai.nombre AS pai_nombre
				FROM Departamento dep
				INNER JOIN Pais pai ON dep.idPais = pai.id
				WHERE dep.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirDepartamentoEntidad(resultado);
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

		return new DepartamentoEntidad.Builder().build();
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(DepartamentoEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					dep.id AS id,
					dep.nombre AS nombre,
					pai.id AS pai_id,
					pai.nombre AS pai_nombre
				FROM Departamento dep
				INNER JOIN Pais pai ON dep.idPais = pai.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("dep.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("dep.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getPais().getId())) {
			condiciones.add("dep.idPais = ?");
			parametros.add(filtro.getPais().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<DepartamentoEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirDepartamentoEntidad(resultado));
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
	public List<DepartamentoEntidad> consultarTodos() {
		return consultarPorFiltro(new DepartamentoEntidad.Builder().build());
	}

	private DepartamentoEntidad construirDepartamentoEntidad(final ResultSet resultado) throws SQLException {

		final PaisEntidad pai = new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("pai_id")))
				.nombre(resultado.getString("pai_nombre"))
				.build();

		return new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.pais(pai)
				.build();
	}
}
