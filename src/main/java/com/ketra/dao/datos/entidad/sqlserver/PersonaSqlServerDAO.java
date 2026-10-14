package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.PersonaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PersonaSqlServerDAO extends SqlDAO implements PersonaDAO {

	public PersonaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public PersonaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					per.id,
					per.idTipoDocumento,
					tdo.nombre AS nombreTipoDocumento,
					per.numeroIdentificacion,
					per.primerNombre,
					per.segundoNombre,
					per.primerApellido,
					per.segundoApellido,
					per.numeroTelefonico,
					per.correoElectronico
				FROM Persona per
				INNER JOIN TipoDocumento tdo
					ON per.idTipoDocumento = tdo.id
				WHERE per.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1,id);

			try (ResultSet resultado = sentencia.executeQuery()) {

				if (resultado.next()) {

					return construirPersonaEntidad(resultado);
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

		return new PersonaEntidad.Builder().build();
	}

	@Override
	public List<PersonaEntidad> consultarPorFiltro(PersonaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					per.id,
					per.idTipoDocumento,
					tdo.nombre AS nombreTipoDocumento,
					per.numeroIdentificacion,
					per.primerNombre,
					per.segundoNombre,
					per.primerApellido,
					per.segundoApellido,
					per.numeroTelefonico,
					per.correoElectronico
				FROM Persona per
				INNER JOIN TipoDocumento tdo
					ON per.idTipoDocumento = tdo.id
				""");

		final List<String> condiciones = new ArrayList<>();

		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
					
			condiciones.add("per.id = ?");

			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getTipoDocumento().getId())) {

			condiciones.add("per.idTipoDocumento = ?");

			parametros.add(filtro.getTipoDocumento().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroIdentificacion())) {

			condiciones.add("per.numeroIdentificacion = ?");

			parametros.add(filtro.getNumeroIdentificacion());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getPrimerNombre())) {

			condiciones.add("per.primerNombre = ?");

			parametros.add(filtro.getPrimerNombre());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getSegundoNombre())) {

			condiciones.add("per.segundoNombre = ?");

			parametros.add(filtro.getSegundoNombre());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getPrimerApellido())) {

			condiciones.add("per.primerApellido = ?");

			parametros.add(filtro.getPrimerApellido());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getSegundoApellido())) {

			condiciones.add("per.segundoApellido = ?");

			parametros.add(filtro.getSegundoApellido());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroTelefonico())) {

			condiciones.add("per.numeroTelefonico = ?");

			parametros.add(filtro.getNumeroTelefonico());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getCorreoElectronico())) {

			condiciones.add("per.correoElectronico = ?");

			parametros.add(filtro.getCorreoElectronico());
		}

		if (!condiciones.isEmpty()) {

			sql.append(" WHERE ");

			sql.append(String.join(" AND ", condiciones));
			
		}

		final List<PersonaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {

				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {

				while (resultado.next()) {

					resultados.add(construirPersonaEntidad(resultado));
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
	public List<PersonaEntidad> consultarTodos() {

		return consultarPorFiltro(new PersonaEntidad.Builder().build());
	}

	@Override
	public void crear(PersonaEntidad entidad) {

		final String sql = """
				INSERT INTO Persona (
					id,
					idTipoDocumento,
					numeroIdentificacion,
					primerNombre,
					segundoNombre,
					primerApellido,
					segundoApellido,
					numeroTelefonico,
					correoElectronico
				)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1,entidad.getId());
			sentencia.setObject(2,entidad.getTipoDocumento().getId());
			sentencia.setString(3,entidad.getNumeroIdentificacion());
			sentencia.setString(4,entidad.getPrimerNombre());
			sentencia.setString(5,entidad.getSegundoNombre());
			sentencia.setString(6,entidad.getPrimerApellido());
			sentencia.setString(7,entidad.getSegundoApellido());
			sentencia.setString(8,entidad.getNumeroTelefonico());
			sentencia.setString(9,entidad.getCorreoElectronico());

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
	public void actualizar(UUID id, PersonaEntidad entidad) {

		final String sql = """
				UPDATE Persona
				SET
					idTipoDocumento = ?,
					numeroIdentificacion = ?,
					primerNombre = ?,
					segundoNombre = ?,
					primerApellido = ?,
					segundoApellido = ?,
					numeroTelefonico = ?,
					correoElectronico = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1,entidad.getTipoDocumento().getId());
			sentencia.setString(2,entidad.getNumeroIdentificacion());
			sentencia.setString(3,entidad.getPrimerNombre());
			sentencia.setString(4,entidad.getSegundoNombre());
			sentencia.setString(5,entidad.getPrimerApellido());
			sentencia.setString(6,entidad.getSegundoApellido());
			sentencia.setString(7,entidad.getNumeroTelefonico());
			sentencia.setString(8,entidad.getCorreoElectronico());
			sentencia.setObject(9,id);

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

	@Override
	public void eliminar(UUID id) {

		final String sql = """
				DELETE FROM Persona
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1,id);

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ELIMINAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ELIMINAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ELIMINAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ELIMINAR + excepcion.getMessage(),
					excepcion);
		}
	}

	private PersonaEntidad construirPersonaEntidad(
			final ResultSet resultado)
			throws SQLException {

		final TipoDocumentoEntidad tipoDocumento = new TipoDocumentoEntidad.Builder()
						.id(UUID.fromString(resultado.getString("idTipoDocumento")))
						.nombre(resultado.getString("nombreTipoDocumento")).build();

		return new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.tipoDocumento(tipoDocumento)
				.numeroIdentificacion(resultado.getString("numeroIdentificacion"))
				.primerNombre(resultado.getString("primerNombre"))
				.segundoNombre(resultado.getString("segundoNombre"))
				.primerApellido(resultado.getString("primerApellido"))
				.segundoApellido(resultado.getString("segundoApellido"))
				.numeroTelefonico(resultado.getString("numeroTelefonico"))
				.correoElectronico(resultado.getString("correoElectronico")).build();
	}

}
