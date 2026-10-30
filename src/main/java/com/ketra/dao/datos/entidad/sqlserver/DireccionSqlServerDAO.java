package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.DireccionDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.MunicipioEntidad;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class DireccionSqlServerDAO extends SqlDAO implements DireccionDAO {

	public DireccionSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DireccionEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    dir.id AS id,
                    dir.nombre AS nombre,
                    bar.id AS bar_id,
                    bar.nombre AS bar_nombre,
                    bar.idMunicipio AS bar_idMunicipio,
                    tdi.id AS tdi_id,
                    tdi.nombre AS tdi_nombre
                FROM Direccion dir
                INNER JOIN Barrio bar ON dir.idBarrio = bar.id
                INNER JOIN TipoDireccion tdi ON dir.idTipoDireccion = tdi.id
                WHERE dir.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirDireccionEntidad(resultado);
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

		return new DireccionEntidad.Builder().build();
	}

	@Override
	public List<DireccionEntidad> consultarPorFiltro(DireccionEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    dir.id AS id,
                    dir.nombre AS nombre,
                    bar.id AS bar_id,
                    bar.nombre AS bar_nombre,
                    bar.idMunicipio AS bar_idMunicipio,
                    tdi.id AS tdi_id,
                    tdi.nombre AS tdi_nombre
                FROM Direccion dir
                INNER JOIN Barrio bar ON dir.idBarrio = bar.id
                INNER JOIN TipoDireccion tdi ON dir.idTipoDireccion = tdi.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("dir.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("dir.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getBarrio().getId())) {
			condiciones.add("dir.idBarrio = ?");
			parametros.add(filtro.getBarrio().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getDireccion().getId())) {
			condiciones.add("dir.idTipoDireccion = ?");
			parametros.add(filtro.getDireccion().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<DireccionEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirDireccionEntidad(resultado));
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
	public List<DireccionEntidad> consultarTodos() {
		return consultarPorFiltro(new DireccionEntidad.Builder().build());
	}

	@Override
	public void crear(DireccionEntidad entidad) {

		final String sql = """
                INSERT INTO Direccion (
                    id,
                    nombre,
                    idBarrio,
                    idTipoDireccion
                )
                VALUES (?, ?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNombre());
			sentencia.setObject(3, entidad.getBarrio().getId());
			sentencia.setObject(4, entidad.getDireccion().getId());

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
	public void actualizar(UUID id, DireccionEntidad entidad) {

		final String sql = """
                UPDATE Direccion
                SET
                    nombre = ?,
                    idBarrio = ?,
                    idTipoDireccion = ?
                WHERE id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNombre());
			sentencia.setObject(2, entidad.getBarrio().getId());
			sentencia.setObject(3, entidad.getDireccion().getId());
			sentencia.setObject(4, id);

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

	private DireccionEntidad construirDireccionEntidad(final ResultSet resultado) throws SQLException {

		final MunicipioEntidad mun = new MunicipioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("bar_idMunicipio")))
				.build();

		final BarrioEntidad bar = new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("bar_id")))
				.nombre(resultado.getString("bar_nombre"))
				.municipio(mun)
				.build();

		final TipoDireccionEntidad tdi = new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdi_id")))
				.nombre(resultado.getString("tdi_nombre"))
				.build();

		return new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.barrio(bar)
				.direccion(tdi)
				.build();
	}
}
