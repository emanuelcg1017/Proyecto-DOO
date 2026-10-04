package com.ketra.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.ServicioSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.UtilidadSqlServerDAO;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilSQL;

public class SqlServerDAOFactory extends DAOFactory{

	protected SqlServerDAOFactory() {
		super();
	}

	@Override
	protected void abrirConexion() {

		if (UtilSQL.conexionEstaAbierta(getConexion())) {
			
			return;
			
		}

		try {

			String url = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=KETRA;"
					+ "integratedSecurity=true;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true";

			Connection conexion = DriverManager.getConnection(url);

			setConexion(conexion);

		} catch (SQLException excepcion) {


			var mensajeUsuario =CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_CONEXION_SQL_SERVER;
			var mensajeTecnico =CatalogoMensajes.SqlServerDAOFactory.TECNICO_ERROR_CONEXION_SQL_SERVER + excepcion.getMessage();
			throw KETRADatosException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		
		return new PaisSqlServerDAO(getConexion());
		
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		
		return new DepartamentoSqlServerDAO(getConexion());
		
	}

	@Override
	public UtilidadDAO obtenerUtilidadDAO() {
		return new UtilidadSqlServerDAO(getConexion());
	}

	@Override
	public ServicioDAO obtenerServicioDAO() {
		return new ServicioSqlServerDAO(getConexion());
	}
	
	

}
