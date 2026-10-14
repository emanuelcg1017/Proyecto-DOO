package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;
import com.ketra.dao.datos.EliminarDAO;

import com.ketra.entidad.TerceroEntidad;

public interface TerceroDAO extends CrearDAO<TerceroEntidad>, ConsultarDAO<TerceroEntidad, UUID> ,ActualizarDAO<TerceroEntidad, UUID>, EliminarDAO<UUID> {

}
