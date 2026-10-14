package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioEntregaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioEntregaEntidad;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaSqlServerDAO extends SqlDAO implements ServicioEntregaDAO {

	public ServicioEntregaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public ServicioEntregaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					sen.id AS id,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado,
					ent.id AS ent_id,
					ent.codigoEntrega AS ent_codigoEntrega,
					ent.fechaEntrega AS ent_fechaEntrega,
					ent.estadoEntrega AS ent_estadoEntrega,
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
				FROM ServicioEntrega sen
				INNER JOIN Servicio ser ON sen.idServicio = ser.id
				INNER JOIN Entrega ent ON sen.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				WHERE sen.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirServicioEntregaEntidad(resultado);
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

		return new ServicioEntregaEntidad.Builder().build();
	}

	@Override
	public List<ServicioEntregaEntidad> consultarPorFiltro(ServicioEntregaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					sen.id AS id,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado,
					ent.id AS ent_id,
					ent.codigoEntrega AS ent_codigoEntrega,
					ent.fechaEntrega AS ent_fechaEntrega,
					ent.estadoEntrega AS ent_estadoEntrega,
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
				FROM ServicioEntrega sen
				INNER JOIN Servicio ser ON sen.idServicio = ser.id
				INNER JOIN Entrega ent ON sen.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("sen.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("sen.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEntrega().getId())) {
			condiciones.add("sen.idEntrega = ?");
			parametros.add(filtro.getEntrega().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<ServicioEntregaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirServicioEntregaEntidad(resultado));
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
	public List<ServicioEntregaEntidad> consultarTodos() {
		return consultarPorFiltro(new ServicioEntregaEntidad.Builder().build());
	}

	private ServicioEntregaEntidad construirServicioEntregaEntidad(final ResultSet resultado) throws SQLException {

		final ServicioEntidad ser = new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ser_id")))
				.numeroServicio(resultado.getString("ser_numeroServicio"))
				.fechaServicio(resultado.getDate("ser_fechaServicio").toLocalDate())
				.estado(resultado.getString("ser_estado"))
				.build();

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

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_id")))
				.codigoEntrega(resultado.getString("ent_codigoEntrega"))
				.fechaEntrega(resultado.getDate("ent_fechaEntrega").toLocalDate())
				.estadoEntrega(resultado.getString("ent_estadoEntrega"))
				.persona(per)
				.build();

		return new ServicioEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.servicio(ser)
				.entrega(ent)
				.build();
	}
}
