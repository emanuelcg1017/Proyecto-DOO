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
import com.ketra.transversal.utilitarios.UtilUUID;

public class PersonaSqlServerDAO extends SqlDAO implements PersonaDAO {

	public PersonaSqlServerDAO(Connection conexion) {
		super(conexion);
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
	public PersonaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					p.id,
					p.idTipoDocumento,
					td.nombre AS nombreTipoDocumento,
					p.numeroIdentificacion,
					p.primerNombre,
					p.segundoNombre,
					p.primerApellido,
					p.segundoApellido,
					p.numeroTelefonico,
					p.correoElectronico
				FROM Persona p
				INNER JOIN TipoDocumento td
					ON p.idTipoDocumento = td.id
				WHERE p.id = ?
				""";

		try (PreparedStatement sentencia =
				getConexion().prepareStatement(sql)) {

			sentencia.setObject(
					1,
					id);

			try (ResultSet resultado =
					sentencia.executeQuery()) {

				if (resultado.next()) {

					return construirPersonaEntidad(
							resultado);
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
	public List<PersonaEntidad> consultarTodos() {

		return consultarPorFiltro(null);
	}

	@Override
	public List<PersonaEntidad> consultarPorFiltro(PersonaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
						SELECT
							p.id,
							p.idTipoDocumento,
							td.nombre AS nombreTipoDocumento,
							p.numeroIdentificacion,
							p.primerNombre,
							p.segundoNombre,
							p.primerApellido,
							p.segundoApellido,
							p.numeroTelefonico,
							p.correoElectronico
						FROM Persona p
						INNER JOIN TipoDocumento td
							ON p.idTipoDocumento = td.id
						""");

		final List<String> condiciones = new ArrayList<>();

		final List<Object> parametros = new ArrayList<>();

		if (filtro != null) {

			final UUID idDefecto = UtilUUID.obtenerValorDefecto(null);

			if (filtro.getId() != null && !idDefecto.equals(filtro.getId())) {

				condiciones.add("p.id = ?");
				parametros.add(filtro.getId());
			}

			if (filtro.getTipoDocumento() != null && filtro.getTipoDocumento().getId() != null && !idDefecto.equals(filtro.getTipoDocumento().getId())) {

				condiciones.add("p.idTipoDocumento = ?");
				parametros.add(filtro.getTipoDocumento().getId());
			}

			if (tieneValor(filtro.getNumeroIdentificacion())) {

				condiciones.add("p.numeroIdentificacion = ?");
				parametros.add(filtro.getNumeroIdentificacion());
			}

			if (tieneValor(filtro.getPrimerNombre())) {

				condiciones.add("p.primerNombre = ?");
				parametros.add(filtro.getPrimerNombre());
			}

			if (tieneValor(filtro.getSegundoNombre())) {

				condiciones.add("p.segundoNombre = ?");
				parametros.add(filtro.getSegundoNombre());
			}

			if (tieneValor(filtro.getPrimerApellido())) {

				condiciones.add("p.primerApellido = ?");
				parametros.add(filtro.getPrimerApellido());
			}

			if (tieneValor(filtro.getSegundoApellido())) {

				condiciones.add("p.segundoApellido = ?");
				parametros.add(filtro.getSegundoApellido());
			}

			if (tieneValor(filtro.getNumeroTelefonico())) {

				condiciones.add("p.numeroTelefonico = ?");
				parametros.add(filtro.getNumeroTelefonico());
			}

			if (tieneValor(filtro.getCorreoElectronico())) {

				condiciones.add("p.correoElectronico = ?");
				parametros.add(filtro.getCorreoElectronico());
			}
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
	public void eliminar(UUID id) {

		final String sql = """
				DELETE FROM Persona
				WHERE id = ?
				""";

		try (PreparedStatement sentencia =getConexion().prepareStatement(sql)) {

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

	private boolean tieneValor(String valor) {

		return valor != null && !valor.isBlank();
	}
}