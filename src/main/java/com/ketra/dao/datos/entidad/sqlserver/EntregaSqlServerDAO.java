package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.EntregaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilFecha;

public class EntregaSqlServerDAO extends SqlDAO implements EntregaDAO {

	public EntregaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public EntregaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					ent.id AS id,
					ent.codigoEntrega AS codigoEntrega,
					ent.fechaEntrega AS fechaEntrega,
					ent.estadoEntrega AS estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico
				FROM Entrega ent
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				WHERE ent.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirEntregaEntidad(resultado);
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return new EntregaEntidad.Builder().build();
	}

	@Override
	public List<EntregaEntidad> consultarPorFiltro(EntregaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					ent.id AS id,
					ent.codigoEntrega AS codigoEntrega,
					ent.fechaEntrega AS fechaEntrega,
					ent.estadoEntrega AS estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico
				FROM Entrega ent
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ent.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCodigoEntrega())) {
			condiciones.add("ent.codigoEntrega = ?");
			parametros.add(filtro.getCodigoEntrega());
		}

		if (!UtilFecha.FECHA_DEFECTO.equals(filtro.getFechaEntrega())) {
			condiciones.add("ent.fechaEntrega = ?");
			parametros.add(java.sql.Date.valueOf(filtro.getFechaEntrega()));
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoEntrega())) {
			condiciones.add("ent.estadoEntrega = ?");
			parametros.add(filtro.getEstadoEntrega());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getPersona().getId())) {
			condiciones.add("ent.idPersona = ?");
			parametros.add(filtro.getPersona().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<EntregaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirEntregaEntidad(resultado));
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return resultados;
	}

	@Override
	public List<EntregaEntidad> consultarTodos() {
		return consultarPorFiltro(new EntregaEntidad.Builder().build());
	}

	@Override
	public void crear(EntregaEntidad entidad) {

		final String sql = """
				INSERT INTO Entrega (
					id,
					codigoEntrega,
					fechaEntrega,
					estadoEntrega,
					idPersona
				)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getCodigoEntrega());
			sentencia.setDate(3, java.sql.Date.valueOf(entidad.getFechaEntrega()));
			sentencia.setString(4, entidad.getEstadoEntrega());
			sentencia.setObject(5, entidad.getPersona().getId());

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CREAR + excepcion.getMessage(),
					excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, EntregaEntidad entidad) {

		final String sql = """
				UPDATE Entrega
				SET
					codigoEntrega = ?,
					fechaEntrega = ?,
					estadoEntrega = ?,
					idPersona = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getCodigoEntrega());
			sentencia.setDate(2, java.sql.Date.valueOf(entidad.getFechaEntrega()));
			sentencia.setString(3, entidad.getEstadoEntrega());
			sentencia.setObject(4, entidad.getPersona().getId());
			sentencia.setObject(5, id);

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ACTUALIZAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ACTUALIZAR + excepcion.getMessage(),
					excepcion);
		}
	}

	private EntregaEntidad construirEntregaEntidad(final ResultSet resultado) throws SQLException {

		final TipoDocumentoEntidad tdo = new TipoDocumentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdo_id")))
				.nombre(resultado.getString("tdo_nombre"))
				.build();

		final PersonaEntidad per = new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("per_id")))
				.tipoDocumento(tdo)
				.numeroIdentificacion(resultado.getString("per_numeroIdentificacion"))
				.primerNombre(resultado.getString("per_primerNombre"))
				.segundoNombre(resultado.getString("per_segundoNombre"))
				.primerApellido(resultado.getString("per_primerApellido"))
				.segundoApellido(resultado.getString("per_segundoApellido"))
				.numeroTelefonico(resultado.getString("per_numeroTelefonico"))
				.correoElectronico(resultado.getString("per_correoElectronico"))
				.build();

		return new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.codigoEntrega(resultado.getString("codigoEntrega"))
				.fechaEntrega(resultado.getDate("fechaEntrega").toLocalDate())
				.estadoEntrega(resultado.getString("estadoEntrega"))
				.persona(per)
				.build();
	}
}
