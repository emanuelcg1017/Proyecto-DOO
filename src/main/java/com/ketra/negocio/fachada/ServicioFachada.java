package com.ketra.negocio.fachada;

import java.util.List;
import java.util.UUID;

import com.ketra.dto.ServicioDTO;

public interface ServicioFachada {

	ServicioDTO consultarPorId(UUID id);

	List<ServicioDTO> consultarPorFiltro(ServicioDTO filtro);

	List<ServicioDTO> consultarTodos();

	ServicioDTO actualizarEstado(UUID id, ServicioDTO servicio);

}
