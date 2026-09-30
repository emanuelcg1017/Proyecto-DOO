package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;
import com.ketra.dao.datos.EliminarDAO;

public interface TerceroDAO extends CrearDAO<TerceroDAO>, ConsultarDAO<TerceroDAO, UUID> ,ActualizarDAO<TerceroDAO, UUID>, EliminarDAO<UUID> {

}
