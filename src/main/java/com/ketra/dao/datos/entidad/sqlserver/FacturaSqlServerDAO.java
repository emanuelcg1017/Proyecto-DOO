package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.FacturaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.FacturaEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilNumero;

public class FacturaSqlServerDAO extends SqlDAO implements FacturaDAO{

	public FacturaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(FacturaEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FacturaEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaEntidad> consultarPorFiltro(FacturaEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, FacturaEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double consultarTotalIngresosPorServicio(UUID idServicio, String estadoFacturaExcluido) {

		final String sql = """
				SELECT COALESCE(SUM(f.ingresos), 0) AS totalIngresos
				FROM ServicioFactura sf
				INNER JOIN Factura f ON sf.idFactura = f.id
				WHERE sf.idServicio = ?
				AND f.estadoFactura <> ?
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



}
