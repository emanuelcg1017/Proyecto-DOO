package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

import com.ketra.entidad.CEDIEntidad;

public interface CEDIDAO extends CrearDAO<CEDIEntidad>, ConsultarDAO<CEDIEntidad, UUID>, ActualizarDAO<CEDIEntidad, UUID> {

}
