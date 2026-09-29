package com.ketra.dao.factoria;

import java.sql.Connection;

import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.transversal.utilitarios.UtilSQL;


public abstract class DAOFactory {

	private Connection conexion;
	
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
	
	public void cancelarTransacion() {
		
		UtilSQL.cancelarTransaccion(conexion);
		
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();

}
