package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.CEDIDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class CEDISqlServerDAO extends SqlDAO implements CEDIDAO {

	public CEDISqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public CEDIEntidad consultarPorId(UUID id) {
		
		final String sql = """
				SELECT
					ced.id AS id,
					ced.nombre AS nombre,
					dir.id AS dir_id,
					dir.nombre AS dir_nombre,
					dir.idBarrio AS dir_idBarrio,
					dir.idTipoDireccion AS dir_idTipoDireccion
				FROM CEDI ced
				INNER JOIN Direccion dir ON ced.idDireccion = dir.id
				WHERE ced.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirCEDIEntidad(resultado);
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

		return new CEDIEntidad.Builder().build();
	}

	@Override
	public List<CEDIEntidad> consultarPorFiltro(CEDIEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					ced.id AS id,
					ced.nombre AS nombre,
					dir.id AS dir_id,
					dir.nombre AS dir_nombre,
					dir.idBarrio AS dir_idBarrio,
					dir.idTipoDireccion AS dir_idTipoDireccion
				FROM CEDI ced
				INNER JOIN Direccion dir ON ced.idDireccion = dir.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ced.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("ced.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getDireccion().getId())) {
			condiciones.add("ced.idDireccion = ?");
			parametros.add(filtro.getDireccion().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<CEDIEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirCEDIEntidad(resultado));
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
	public List<CEDIEntidad> consultarTodos() {
		return consultarPorFiltro(new CEDIEntidad.Builder().build());
	}

	@Override
	public void crear(CEDIEntidad entidad) {

		final String sql = """
				INSERT INTO CEDI (
					id,
					nombre,
					idDireccion
				)
				VALUES (?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNombre());
			sentencia.setObject(3, entidad.getDireccion().getId());

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
	public void actualizar(UUID id, CEDIEntidad entidad) {

		final String sql = """
				UPDATE CEDI
				SET
					nombre = ?,
					idDireccion = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNombre());
			sentencia.setObject(2, entidad.getDireccion().getId());
			sentencia.setObject(3, id);

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

	private CEDIEntidad construirCEDIEntidad(final ResultSet resultado) throws SQLException {

		final BarrioEntidad barrio = new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir_idBarrio")))
				.build();

		final TipoDireccionEntidad tipoDireccion = new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir_idTipoDireccion")))
				.build();

		final DireccionEntidad direccion = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir_id")))
				.nombre(resultado.getString("dir_nombre"))
				.barrio(barrio)
				.direccion(tipoDireccion)
				.build();

		return new CEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.direccion(direccion)
				.build();
	}
}
