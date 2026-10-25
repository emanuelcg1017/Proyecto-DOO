package com.ketra.dao.datos.entidad;

import java.util.List;
import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

import com.ketra.entidad.EntregaEntidad;

public interface EntregaDAO extends CrearDAO<EntregaEntidad>, ConsultarDAO<EntregaEntidad, UUID>, ActualizarDAO<EntregaEntidad, UUID>{

	List<EntregaEntidad> consultarPorServicio(UUID idServicio);

}
