package com.ketra.dao.datos.entidad;

import java.sql.Connection;

import com.ketra.transversal.utilitarios.UtilSQL;

public abstract class SqlDAO {

	private Connection conexion;

	protected SqlDAO(Connection conexion) {
		
		setConexion(conexion);
	}

	private void setConexion(Connection conexion) {
		
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
		
	}

	protected Connection getConexion() {
		
		return conexion;
		
	}

}
