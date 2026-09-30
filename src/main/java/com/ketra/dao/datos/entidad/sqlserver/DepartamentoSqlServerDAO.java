package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.SqlDAO;

public class DepartamentoSqlServerDAO extends SqlDAO implements DepartamentoDAO {

	
	public DepartamentoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoDAO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarPorFiltro(DepartamentoDAO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
