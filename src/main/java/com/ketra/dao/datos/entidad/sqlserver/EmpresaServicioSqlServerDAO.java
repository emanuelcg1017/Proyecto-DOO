package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.EmpresaServicioDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.EmpresaEntidad;
import com.ketra.entidad.EmpresaServicioEntidad;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaServicioSqlServerDAO extends SqlDAO implements EmpresaServicioDAO {

	public EmpresaServicioSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public EmpresaServicioEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					ese.id AS id,
					emp.id AS emp_id,
					emp.nombre AS emp_nombre,
					emp.nit AS emp_nit,
					emp.correoContacto AS emp_correoContacto,
					emp.telefonoContacto AS emp_telefonoContacto,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado
				FROM EmpresaServicio ese
				INNER JOIN Empresa emp ON ese.idEmpresa = emp.id
				INNER JOIN Servicio ser ON ese.idServicio = ser.id
				WHERE ese.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirEmpresaServicioEntidad(resultado);
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

		return new EmpresaServicioEntidad.Builder().build();
	}

	@Override
	public List<EmpresaServicioEntidad> consultarPorFiltro(EmpresaServicioEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					ese.id AS id,
					emp.id AS emp_id,
					emp.nombre AS emp_nombre,
					emp.nit AS emp_nit,
					emp.correoContacto AS emp_correoContacto,
					emp.telefonoContacto AS emp_telefonoContacto,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado
				FROM EmpresaServicio ese
				INNER JOIN Empresa emp ON ese.idEmpresa = emp.id
				INNER JOIN Servicio ser ON ese.idServicio = ser.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("ese.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEmpresa().getId())) {
			condiciones.add("ese.idEmpresa = ?");
			parametros.add(filtro.getEmpresa().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("ese.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<EmpresaServicioEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirEmpresaServicioEntidad(resultado));
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
	public List<EmpresaServicioEntidad> consultarTodos() {
		return consultarPorFiltro(new EmpresaServicioEntidad.Builder().build());
	}

	private EmpresaServicioEntidad construirEmpresaServicioEntidad(final ResultSet resultado) throws SQLException {

		final EmpresaEntidad emp = new EmpresaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("emp_id")))
				.nombre(resultado.getString("emp_nombre"))
				.NIT(resultado.getString("emp_nit"))
				.correoContacto(resultado.getString("emp_correoContacto"))
				.telefonoContacto(resultado.getString("emp_telefonoContacto"))
				.build();

		final ServicioEntidad ser = new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ser_id")))
				.numeroServicio(resultado.getString("ser_numeroServicio"))
				.fechaServicio(resultado.getDate("ser_fechaServicio").toLocalDate())
				.estado(resultado.getString("ser_estado"))
				.build();

		return new EmpresaServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.empresa(emp)
				.servicio(ser)
				.build();
	}
}
