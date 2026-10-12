package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.CostoRecorridoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilNumero;

public class CostoRecorridoSqlServerDAO extends SqlDAO implements CostoRecorridoDAO{

	public CostoRecorridoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public CostoRecorridoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoRecorridoEntidad> consultarPorFiltro(CostoRecorridoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoRecorridoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(CostoRecorridoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double consultarTotalCostosPorServicio(UUID idServicio, String estadoEntregaRequerido) {

		final String sql = """
				SELECT COALESCE(SUM(cr.valorCosto), 0) AS totalCostos
				FROM ServicioEntrega se
				INNER JOIN Entrega e ON se.idEntrega = e.id
				INNER JOIN DetalleEntrega de ON de.idEntrega = e.id
				INNER JOIN CostoRecorrido cr ON cr.idDetalleEntrega = de.id
				WHERE se.idServicio = ?
				AND e.estadoEntrega = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, idServicio);
			sentencia.setString(2, estadoEntregaRequerido);

			try (ResultSet resultado = sentencia.executeQuery()) {

				if (resultado.next()) {
					return resultado.getDouble("totalCostos");
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
