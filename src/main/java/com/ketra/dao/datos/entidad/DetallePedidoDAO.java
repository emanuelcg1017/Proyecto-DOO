package com.ketra.dao.datos.entidad;

import java.util.UUID;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;

import com.ketra.entidad.DetallePedidoEntidad;

public interface DetallePedidoDAO extends CrearDAO<DetallePedidoEntidad>, ConsultarDAO<DetallePedidoEntidad,UUID>{

}
