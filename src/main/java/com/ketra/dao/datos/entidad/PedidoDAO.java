package com.ketra.dao.datos.entidad;


import java.util.UUID;

import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

public interface PedidoDAO extends CrearDAO<PedidoDAO>,ConsultarDAO<PedidoDAO, UUID> {

}
