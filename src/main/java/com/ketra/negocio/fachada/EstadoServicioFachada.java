package com.ketra.negocio.fachada;

import java.util.List;
import java.util.UUID;

import com.ketra.dto.EstadoServicioDTO;

public interface EstadoServicioFachada {

	EstadoServicioDTO consultarPorId(UUID id);

	List<EstadoServicioDTO> consultarPorFiltro(EstadoServicioDTO filtro);

}
