package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.FacturaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.FacturaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilNumero;

public class FacturaSqlServerDAO extends SqlDAO implements FacturaDAO {

	public FacturaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public FacturaEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					fac.id AS id,
					fac.numeroFactura AS numeroFactura,
					fac.fechaFactura AS fechaFactura,
					fac.ingresos AS ingresos,
					fac.estadoFactura AS estadoFactura
				FROM Factura fac

				WHERE fac.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirFacturaEntidad(resultado);
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

		return new FacturaEntidad.Builder().build();
	}

	@Override
	public List<FacturaEntidad> consultarPorFiltro(FacturaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					fac.id AS id,
					fac.numeroFactura AS numeroFactura,
					fac.fechaFactura AS fechaFactura,
					fac.ingresos AS ingresos,
					fac.estadoFactura AS estadoFactura
				FROM Factura fac
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("fac.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroFactura())) {
			condiciones.add("fac.numeroFactura = ?");
			parametros.add(filtro.getNumeroFactura());
		}

		if (!UtilFecha.FECHA_DEFECTO.equals(filtro.getFechaFactura())) {
			condiciones.add("fac.fechaFactura = ?");
			parametros.add(java.sql.Date.valueOf(filtro.getFechaFactura()));
		}

		if (filtro.getIngresos().doubleValue() != UtilNumero.CERO_DECIMAL) {
			condiciones.add("fac.ingresos = ?");
			parametros.add(filtro.getIngresos());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoFactura())) {
			condiciones.add("fac.estadoFactura = ?");
			parametros.add(filtro.getEstadoFactura());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<FacturaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirFacturaEntidad(resultado));
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
	public List<FacturaEntidad> consultarTodos() {
		return consultarPorFiltro(new FacturaEntidad.Builder().build());
	}

	@Override
	public Double consultarTotalIngresosPorServicio(UUID idServicio, String estadoFacturaExcluido) {

		final String sql = """
				SELECT COALESCE(SUM(fac.ingresos), 0) AS totalIngresos
				FROM ServicioFactura sfa
				INNER JOIN Factura fac ON sfa.idFactura = fac.id
				WHERE sfa.idServicio = ?
				AND fac.estadoFactura <> ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, idServicio);
			sentencia.setString(2, estadoFacturaExcluido);

			try (ResultSet resultado = sentencia.executeQuery()) {

				if (resultado.next()) {
					return resultado.getDouble("totalIngresos");
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

		return UtilNumero.CERO_DECIMAL;
	}

	@Override
	public void crear(FacturaEntidad entidad) {

		final String sql = """
				INSERT INTO Factura (
					id,
					numeroFactura,
					fechaFactura,
					ingresos,
					estadoFactura
				)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroFactura());
			sentencia.setDate(3, java.sql.Date.valueOf(entidad.getFechaFactura()));
			sentencia.setDouble(4, entidad.getIngresos());
			sentencia.setString(5, entidad.getEstadoFactura());

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
	public void actualizar(UUID id, FacturaEntidad entidad) {

		final String sql = """
				UPDATE Factura
				SET
					numeroFactura = ?,
					fechaFactura = ?,
					ingresos = ?,
					estadoFactura = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNumeroFactura());
			sentencia.setDate(2, java.sql.Date.valueOf(entidad.getFechaFactura()));
			sentencia.setDouble(3, entidad.getIngresos());
			sentencia.setString(4, entidad.getEstadoFactura());
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

	private FacturaEntidad construirFacturaEntidad(final ResultSet resultado) throws SQLException {

		return new FacturaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroFactura(resultado.getString("numeroFactura"))
				.fechaFactura(resultado.getDate("fechaFactura").toLocalDate())
				.ingresos(resultado.getDouble("ingresos"))
				.EstadoFactura(resultado.getString("estadoFactura"))
				.build();
	}
}
