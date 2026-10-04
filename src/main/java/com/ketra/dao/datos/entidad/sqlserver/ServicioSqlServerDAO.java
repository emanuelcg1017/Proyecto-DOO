package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.ServicioEntidad;

public class ServicioSqlServerDAO extends SqlDAO implements ServicioDAO{

	public ServicioSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(ServicioEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServicioEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicioEntidad> consultarPorFiltro(ServicioEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicioEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ServicioEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

}
