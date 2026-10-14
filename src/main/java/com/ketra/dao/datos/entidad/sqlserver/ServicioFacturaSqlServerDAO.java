package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioFacturaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.FacturaEntidad;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.ServicioFacturaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioFacturaSqlServerDAO extends SqlDAO implements ServicioFacturaDAO {

	public ServicioFacturaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public ServicioFacturaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					sfa.id AS id,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado,
					fac.id AS fac_id,
					fac.numeroFactura AS fac_numeroFactura,
					fac.fechaFactura AS fac_fechaFactura,
					fac.ingresos AS fac_ingresos,
					fac.estadoFactura AS fac_estadoFactura
				FROM ServicioFactura sfa
				INNER JOIN Servicio ser ON sfa.idServicio = ser.id
				INNER JOIN Factura fac ON sfa.idFactura = fac.id
				WHERE sfa.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirServicioFacturaEntidad(resultado);
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

		return new ServicioFacturaEntidad.Builder().build();
	}

	@Override
	public List<ServicioFacturaEntidad> consultarPorFiltro(ServicioFacturaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					sfa.id AS id,
					ser.id AS ser_id,
					ser.numeroServicio AS ser_numeroServicio,
					ser.fechaServicio AS ser_fechaServicio,
					ser.estado AS ser_estado,
					fac.id AS fac_id,
					fac.numeroFactura AS fac_numeroFactura,
					fac.fechaFactura AS fac_fechaFactura,
					fac.ingresos AS fac_ingresos,
					fac.estadoFactura AS fac_estadoFactura
				FROM ServicioFactura sfa
				INNER JOIN Servicio ser ON sfa.idServicio = ser.id
				INNER JOIN Factura fac ON sfa.idFactura = fac.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("sfa.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("sfa.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getFactura().getId())) {
			condiciones.add("sfa.idFactura = ?");
			parametros.add(filtro.getFactura().getId());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<ServicioFacturaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirServicioFacturaEntidad(resultado));
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
	public List<ServicioFacturaEntidad> consultarTodos() {
		return consultarPorFiltro(new ServicioFacturaEntidad.Builder().build());
	}

	private ServicioFacturaEntidad construirServicioFacturaEntidad(final ResultSet resultado) throws SQLException {

		final ServicioEntidad ser = new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ser_id")))
				.numeroServicio(resultado.getString("ser_numeroServicio"))
				.fechaServicio(resultado.getDate("ser_fechaServicio").toLocalDate())
				.estado(resultado.getString("ser_estado"))
				.build();

		final FacturaEntidad fac = new FacturaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("fac_id")))
				.numeroFactura(resultado.getString("fac_numeroFactura"))
				.fechaFactura(resultado.getDate("fac_fechaFactura").toLocalDate())
				.ingresos(resultado.getDouble("fac_ingresos"))
				.EstadoFactura(resultado.getString("fac_estadoFactura"))
				.build();

		return new ServicioFacturaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.servicio(ser)
				.factura(fac)
				.build();
	}
}
