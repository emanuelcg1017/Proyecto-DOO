package com.ketra.dao.factoria.impl;

import java.sql.Connection;

import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import com.ketra.dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory{

	protected SqlServerDAOFactory(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void abrirConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO();
	}

}
