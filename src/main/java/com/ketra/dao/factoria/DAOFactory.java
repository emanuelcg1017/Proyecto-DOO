package com.ketra.dao.factoria;

import java.sql.Connection;
import com.ketra.dao.datos.entidad.PaisDAO;

public abstract class DAOFactory {

	private Connection conexion;
	
	protected DAOFactory(Connection conexion) {
		this.conexion = conexion;
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		
	}
	
	public void iniciarConexion() {
		
	}
	
	public void confirmarTransaccion() {
		
	}
	
	public void cancelarTransacion() {
		
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract com.ketra.dao.datos.entidad.DepartamentoDAO obtenerDepartamentoDAO();

}
