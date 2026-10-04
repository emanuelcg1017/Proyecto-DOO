package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.entidad.UtilidadEntidad;

public class UtilidadSqlServerDAO extends SqlDAO implements UtilidadDAO{

	public UtilidadSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(UtilidadEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtilidadEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilidadEntidad> consultarPorFiltro(UtilidadEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilidadEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
