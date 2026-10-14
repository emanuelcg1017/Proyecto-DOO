package com.ketra.dao.datos.entidad;

import java.util.UUID;

import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

import com.ketra.entidad.DireccionEntidad;

public interface DireccionDAO extends CrearDAO<DireccionEntidad>, ConsultarDAO<DireccionEntidad, UUID>, ActualizarDAO<DireccionEntidad, UUID>{

}
