package com.ketra.dao.factoria;

import java.sql.Connection;


import com.ketra.dao.datos.entidad.CostoRecorridoDAO;
import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.FacturaDAO;
import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.dao.factoria.enums.FactoriaEnum;
import com.ketra.dao.factoria.impl.SqlServerDAOFactory;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAFachadaException;
import com.ketra.transversal.utilitarios.UtilSQL;


public abstract class DAOFactory {

	private Connection conexion;
	private static FactoriaEnum factoria = FactoriaEnum.SQLSERVER;
	
	public static DAOFactory obtenerFactoria() {
		switch (factoria) {
		
			case SQLSERVER: {
				return new SqlServerDAOFactory();
			}
			default:
				
				var mensajeUsuario = CatalogoMensajes.DAOFactory.FUENTE_DATOS_NO_HABILITADA;
				throw KETRAFachadaException.crear(mensajeUsuario);
			}
	}
	
	
	protected DAOFactory() {
		abrirConexion();
	}

	protected Connection getConexion() {
		
		return conexion;
		
	}

	protected void setConexion(Connection conexion) {
		
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
		
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		
		UtilSQL.cerrarConexion(conexion);
		
	}
	
	public void iniciarTransaccion() {
		
		UtilSQL.iniciarTransaccion(conexion);
		
	}
	
	public void confirmarTransaccion() {
		
		UtilSQL.confirmarTransaccion(conexion);
		
	}
	
	public void cancelarTransaccion() {
		
		UtilSQL.cancelarTransaccion(conexion);
		
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();

	public abstract UtilidadDAO obtenerUtilidadDAO();

	public abstract ServicioDAO obtenerServicioDAO();

	public abstract FacturaDAO obtenerFacturaDAO();

	public abstract CostoRecorridoDAO obtenerCostoRecorridoDAO();

}
