package com.ketra.dao.datos.entidad;

import java.util.UUID;

import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

public interface EmpresaDAO  extends CrearDAO<EmpresaDAO>, ConsultarDAO<EmpresaDAO, UUID>, ActualizarDAO<EmpresaDAO, UUID>{

}
