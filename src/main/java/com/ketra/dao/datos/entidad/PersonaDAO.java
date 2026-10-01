package com.ketra.dao.datos.entidad;

import java.util.UUID;

import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;
import com.ketra.dao.datos.EliminarDAO;
import com.ketra.entidad.PersonaEntidad;

public interface PersonaDAO extends CrearDAO<PersonaEntidad>, ConsultarDAO<PersonaEntidad, UUID>, EliminarDAO<UUID>, ActualizarDAO<PersonaEntidad, UUID>{

}
