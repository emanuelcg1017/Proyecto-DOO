package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.PaisEntidad;

public class PaisSqlServerDAO extends SqlDAO  implements PaisDAO{

	public PaisSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
