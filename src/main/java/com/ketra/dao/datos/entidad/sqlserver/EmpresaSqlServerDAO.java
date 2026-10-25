package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.EmpresaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EmpresaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class EmpresaSqlServerDAO extends SqlDAO implements EmpresaDAO {

	public EmpresaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public EmpresaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					emp.id AS id,
					emp.nombre AS nombre,
					emp.nit AS nit,
					emp.correoContacto AS correoContacto,
					emp.telefonoContacto AS telefonoContacto
				FROM Empresa emp

				WHERE emp.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirEmpresaEntidad(resultado);
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

		return new EmpresaEntidad.Builder().build();
	}

	@Override
	public List<EmpresaEntidad> consultarPorFiltro(EmpresaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					emp.id AS id,
					emp.nombre AS nombre,
					emp.nit AS nit,
					emp.correoContacto AS correoContacto,
					emp.telefonoContacto AS telefonoContacto
				FROM Empresa emp
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("emp.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("emp.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNIT())) {
			condiciones.add("emp.nit = ?");
			parametros.add(filtro.getNIT());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCorreoContacto())) {
			condiciones.add("emp.correoContacto = ?");
			parametros.add(filtro.getCorreoContacto());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getTelefonoContacto())) {
			condiciones.add("emp.telefonoContacto = ?");
			parametros.add(filtro.getTelefonoContacto());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<EmpresaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirEmpresaEntidad(resultado));
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
	public List<EmpresaEntidad> consultarTodos() {
		return consultarPorFiltro(new EmpresaEntidad.Builder().build());
	}

	@Override
	public void crear(EmpresaEntidad entidad) {

		final String sql = """
				INSERT INTO Empresa (
					id,
					nombre,
					nit,
					correoContacto,
					telefonoContacto
				)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNombre());
			sentencia.setString(3, entidad.getNIT());
			sentencia.setString(4, entidad.getCorreoContacto());
			sentencia.setString(5, entidad.getTelefonoContacto());

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
	public void actualizar(UUID id, EmpresaEntidad entidad) {

		final String sql = """
				UPDATE Empresa
				SET
					nombre = ?,
					nit = ?,
					correoContacto = ?,
					telefonoContacto = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNombre());
			sentencia.setString(2, entidad.getNIT());
			sentencia.setString(3, entidad.getCorreoContacto());
			sentencia.setString(4, entidad.getTelefonoContacto());
			sentencia.setObject(5, id);

			sentencia.executeUpdate();

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

	private EmpresaEntidad construirEmpresaEntidad(final ResultSet resultado) throws SQLException {

		return new EmpresaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.NIT(resultado.getString("nit"))
				.correoContacto(resultado.getString("correoContacto"))
				.telefonoContacto(resultado.getString("telefonoContacto"))
				.build();
	}
}
