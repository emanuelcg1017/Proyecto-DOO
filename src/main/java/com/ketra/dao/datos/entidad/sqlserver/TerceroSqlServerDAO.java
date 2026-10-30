package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.TerceroDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.TerceroEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;

public class TerceroSqlServerDAO extends SqlDAO implements TerceroDAO {

	public TerceroSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TerceroEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    ter.id AS id,
                    ter.nombre AS nombre,
                    ter.nit AS nit,
                    ter.numeroContacto AS numeroContacto,
                    ter.correoContacto AS correoContacto
                FROM Tercero ter

                WHERE ter.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirTerceroEntidad(resultado);
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

		return new TerceroEntidad.Builder().build();
	}

	@Override
	public List<TerceroEntidad> consultarPorFiltro(TerceroEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    ter.id AS id,
                    ter.nombre AS nombre,
                    ter.nit AS nit,
                    ter.numeroContacto AS numeroContacto,
                    ter.correoContacto AS correoContacto
                FROM Tercero ter
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ter.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("ter.nombre = ?");
			parametros.add(filtro.getNombre());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNit())) {
			condiciones.add("ter.nit = ?");
			parametros.add(filtro.getNit());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroContacto())) {
			condiciones.add("ter.numeroContacto = ?");
			parametros.add(filtro.getNumeroContacto());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCorreoContacto())) {
			condiciones.add("ter.correoContacto = ?");
			parametros.add(filtro.getCorreoContacto());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<TerceroEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirTerceroEntidad(resultado));
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
	public List<TerceroEntidad> consultarTodos() {
		return consultarPorFiltro(new TerceroEntidad.Builder().build());
	}

	@Override
	public void crear(TerceroEntidad entidad) {

		final String sql = """
                INSERT INTO Tercero (
                    id,
                    nombre,
                    nit,
                    numeroContacto,
                    correoContacto
                )
                VALUES (?, ?, ?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNombre());
			sentencia.setString(3, entidad.getNit());
			sentencia.setString(4, entidad.getNumeroContacto());
			sentencia.setString(5, entidad.getCorreoContacto());

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
	public void actualizar(UUID id, TerceroEntidad entidad) {

		final String sql = """
                UPDATE Tercero
                SET
                    nombre = ?,
                    nit = ?,
                    numeroContacto = ?,
                    correoContacto = ?
                WHERE id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNombre());
			sentencia.setString(2, entidad.getNit());
			sentencia.setString(3, entidad.getNumeroContacto());
			sentencia.setString(4, entidad.getCorreoContacto());
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

	@Override
	public void eliminar(UUID id) {

		final String sql = """
                DELETE FROM Tercero
                WHERE id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {


			sentencia.setObject(1, id);

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ELIMINAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ELIMINAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ELIMINAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ELIMINAR, excepcion.getMessage()),
					excepcion);
		}
	}

	private TerceroEntidad construirTerceroEntidad(final ResultSet resultado) throws SQLException {

		return new TerceroEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.nit(resultado.getString("nit"))
				.numeroContacto(resultado.getString("numeroContacto"))
				.correoContacto(resultado.getString("correoContacto"))
				.build();
	}
}
