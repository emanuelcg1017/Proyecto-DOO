package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

public interface CEDIDAO extends CrearDAO<CEDIDAO>, ConsultarDAO<CEDIDAO, UUID>, ActualizarDAO<CEDIDAO, UUID> {

}
