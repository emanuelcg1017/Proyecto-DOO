package com.ketra.negocio.fachada;

import java.util.List;
import java.util.UUID;

import com.ketra.dto.TransicionEstadoServicioDTO;

public interface TransicionEstadoServicioFachada {

	TransicionEstadoServicioDTO consultarPorId(UUID id);

	List<TransicionEstadoServicioDTO> consultarPorFiltro(TransicionEstadoServicioDTO filtro);

}
