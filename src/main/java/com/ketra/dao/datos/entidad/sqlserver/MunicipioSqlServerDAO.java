package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.MunicipioDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.DepartamentoEntidad;
import com.ketra.entidad.MunicipioEntidad;
import com.ketra.entidad.PaisEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class MunicipioSqlServerDAO extends SqlDAO implements MunicipioDAO {

	public MunicipioSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public MunicipioEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					mun.id AS id,
					mun.nombre AS nombre,
					dep.id AS dep_id,
					dep.nombre AS dep_nombre,
					dep.idPais AS dep_idPais
				FROM Municipio mun
				INNER JOIN Departamento dep ON mun.idDepartamento = dep.id
				WHERE mun.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirMunicipioEntidad(resultado);
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

		return new MunicipioEntidad.Builder().build();
	}

	@Override
	public List<MunicipioEntidad> consultarPorFiltro(MunicipioEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					mun.id AS id,
					mun.nombre AS nombre,
					dep.id AS dep_id,
					dep.nombre AS dep_nombre,
					dep.idPais AS dep_idPais
				FROM Municipio mun
				INNER JOIN Departamento dep ON mun.idDepartamento = dep.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("mun.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("mun.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getDepartamento().getId())) {
			condiciones.add("mun.idDepartamento = ?");
			parametros.add(filtro.getDepartamento().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<MunicipioEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirMunicipioEntidad(resultado));
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
	public List<MunicipioEntidad> consultarTodos() {
		return consultarPorFiltro(new MunicipioEntidad.Builder().build());
	}

	private MunicipioEntidad construirMunicipioEntidad(final ResultSet resultado) throws SQLException {

		final PaisEntidad pai = new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dep_idPais")))
				.build();

		final DepartamentoEntidad dep = new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dep_id")))
				.nombre(resultado.getString("dep_nombre"))
				.pais(pai)
				.build();

		return new MunicipioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.departamento(dep)
				.build();
	}
}
