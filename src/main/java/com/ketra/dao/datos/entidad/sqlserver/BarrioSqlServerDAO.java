package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.BarrioDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.DepartamentoEntidad;
import com.ketra.entidad.MunicipioEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class BarrioSqlServerDAO extends SqlDAO implements BarrioDAO {

	public BarrioSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public BarrioEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					bar.id AS id,
					bar.nombre AS nombre,
					mun.id AS mun_id,
					mun.nombre AS mun_nombre,
					mun.idDepartamento AS mun_idDepartamento
				FROM Barrio bar
				INNER JOIN Municipio mun ON bar.idMunicipio = mun.id
				WHERE bar.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirBarrioEntidad(resultado);
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

		return new BarrioEntidad.Builder().build();
	}

	@Override
	public List<BarrioEntidad> consultarPorFiltro(BarrioEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					bar.id AS id,
					bar.nombre AS nombre,
					mun.id AS mun_id,
					mun.nombre AS mun_nombre,
					mun.idDepartamento AS mun_idDepartamento
				FROM Barrio bar
				INNER JOIN Municipio mun ON bar.idMunicipio = mun.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("bar.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("bar.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getMunicipio().getId())) {
			condiciones.add("bar.idMunicipio = ?");
			parametros.add(filtro.getMunicipio().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<BarrioEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirBarrioEntidad(resultado));
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
	public List<BarrioEntidad> consultarTodos() {
		return consultarPorFiltro(new BarrioEntidad.Builder().build());
	}

	private BarrioEntidad construirBarrioEntidad(final ResultSet resultado) throws SQLException {

		final DepartamentoEntidad dep = new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("mun_idDepartamento")))
				.build();

		final MunicipioEntidad mun = new MunicipioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("mun_id")))
				.nombre(resultado.getString("mun_nombre"))
				.departamento(dep)
				.build();

		return new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.municipio(mun)
				.build();
	}
}
