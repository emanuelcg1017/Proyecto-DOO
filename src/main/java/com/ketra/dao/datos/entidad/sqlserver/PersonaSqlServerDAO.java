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

public class PersonaSqlServerDAO extends SqlDAO implements PersonaDAO {

	public PersonaSqlServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PersonaEntidad entidad) {

		final String sql = """
				INSERT INTO Persona (
					ID,
					IDTipoDocumento,
					NumeroIdentificacion,
					PrimerNombre,
					SegundoNombre,
					PrimerApellido,
					SegundoApellido,
					NumeroTelefonico,
					CorreoElectronico
				)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia =getConexion().prepareStatement(sql)) {

			sentencia.setString(1,entidad.getId().toString());
			sentencia.setString(2,entidad.getTipoDocumento().getId().toString());
			sentencia.setString(3,entidad.getNumeroIdentificacion());
			sentencia.setString(4,entidad.getPrimerNombre());
			sentencia.setString(5,entidad.getSegundoNombre());
			sentencia.setString(6,entidad.getPrimerApellido());
			sentencia.setString(7,entidad.getSegundoApellido());
			sentencia.setString(8,entidad.getNumeroTelefonico());
			sentencia.setString(9,entidad.getCorreoElectronico());
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR + excepcion.getMessage(),
					excepcion);
		}
	}

	@Override
	public PersonaEntidad consultarPorId(final UUID id) {

		final String sql = """
				SELECT
					ID,
					IDTipoDocumento,
					NumeroIdentificacion,
					PrimerNombre,
					SegundoNombre,
					PrimerApellido,
					SegundoApellido,
					NumeroTelefonico,
					CorreoElectronico
				FROM Persona
				WHERE ID = ?
				""";

		try (PreparedStatement sentencia =getConexion().prepareStatement(sql)) {

			sentencia.setString(1,id.toString());
			
			try (ResultSet resultado =sentencia.executeQuery()) {

				if (resultado.next()) {
					return construirPersonaEntidad(resultado);
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return new PersonaEntidad.Builder().build();
	}

	@Override
	public List<PersonaEntidad> consultarTodos() {

		return consultarPorFiltro(new PersonaEntidad.Builder().build());
	}

	@Override
	public List<PersonaEntidad> consultarPorFiltro(
			final PersonaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
						SELECT
							ID,
							IDTipoDocumento,
							NumeroIdentificacion,
							PrimerNombre,
							SegundoNombre,
							PrimerApellido,
							SegundoApellido,
							NumeroTelefonico,
							CorreoElectronico
						FROM Persona
						WHERE 1 = 1
						""");

		final List<Object> parametros = new ArrayList<>();

		if (filtro != null) {
			
			if (filtro.getNumeroIdentificacion() != null && !filtro.getNumeroIdentificacion().isBlank()) {sql.append(" AND NumeroIdentificacion = ?");

				parametros.add(filtro.getNumeroIdentificacion());
			}

			if (filtro.getPrimerNombre() != null && !filtro.getPrimerNombre().isBlank()) {

				sql.append(" AND PrimerNombre = ?");
				parametros.add(filtro.getPrimerNombre());
			}

			if (filtro.getPrimerApellido() != null && !filtro.getPrimerApellido().isBlank()) {

				sql.append(" AND PrimerApellido = ?");
				parametros.add(filtro.getPrimerApellido());
			}

			if (filtro.getCorreoElectronico() != null && !filtro.getCorreoElectronico().isBlank()) {

				sql.append(" AND CorreoElectronico = ?");
				parametros.add(filtro.getCorreoElectronico());
			}
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

			throw KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return resultados;
	}

	@Override
	public void eliminar(final UUID id) {

		final String sql = """
				DELETE FROM Persona
				WHERE ID = ?
				""";

		try (PreparedStatement sentencia =
				getConexion().prepareStatement(sql)) {

			sentencia.setString(1,id.toString());
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ELIMINAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ELIMINAR + excepcion.getMessage(),
					excepcion);
		}
	}

	@Override
	public void actualizar(
			final UUID id,
			final PersonaEntidad entidad) {

		final String sql = """
				UPDATE Persona
				SET
					IDTipoDocumento = ?,
					NumeroIdentificacion = ?,
					PrimerNombre = ?,
					SegundoNombre = ?,
					PrimerApellido = ?,
					SegundoApellido = ?,
					NumeroTelefonico = ?,
					CorreoElectronico = ?
				WHERE ID = ?
				""";

		try (PreparedStatement sentencia =
				getConexion().prepareStatement(sql)) {

			sentencia.setString(1,entidad.getTipoDocumento().getId().toString());
			sentencia.setString(2,entidad.getNumeroIdentificacion());
			sentencia.setString(3,entidad.getPrimerNombre());
			sentencia.setString(4,entidad.getSegundoNombre());
			sentencia.setString(5,entidad.getPrimerApellido());
			sentencia.setString(6,entidad.getSegundoApellido());
			sentencia.setString(7,entidad.getNumeroTelefonico());
			sentencia.setString(8,entidad.getCorreoElectronico());
			sentencia.setString(9,id.toString());
			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ACTUALIZAR + excepcion.getMessage(),
					excepcion);
		}
	}

	private PersonaEntidad construirPersonaEntidad(
			final ResultSet resultado)
			throws SQLException {

		final TipoDocumentoEntidad tipoDocumento = new TipoDocumentoEntidad.Builder()
						.id(UUID.fromString(resultado.getString("IDTipoDocumento")))
						.build();

		return new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ID")))
				.tipoDocumento(tipoDocumento)
				.numeroIdentificacion(resultado.getString("NumeroIdentificacion"))
				.primerNombre(resultado.getString("PrimerNombre"))
				.segundoNombre(resultado.getString("SegundoNombre"))
				.primerApellido(resultado.getString("PrimerApellido"))
				.segundoApellido(resultado.getString("SegundoApellido"))
				.numeroTelefonico(resultado.getString("NumeroTelefonico"))
				.correoElectronico(resultado.getString("CorreoElectronico"))
				.build();
	}
}