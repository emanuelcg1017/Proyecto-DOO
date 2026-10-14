package com.ketra.dao.datos.entidad;


import java.util.UUID;

import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

import com.ketra.entidad.PedidoEntidad;

public interface PedidoDAO extends CrearDAO<PedidoEntidad>,ConsultarDAO<PedidoEntidad, UUID> {

}
