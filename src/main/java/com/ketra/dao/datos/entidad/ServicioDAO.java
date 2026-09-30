package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

public interface ServicioDAO extends CrearDAO<ServicioDAO>, ConsultarDAO<ServicioDAO, UUID>, ActualizarDAO<ServicioDAO, UUID>{

}
