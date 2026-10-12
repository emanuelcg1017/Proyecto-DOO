package com.ketra.negocio.fachada;

import java.util.UUID;

import com.ketra.dto.UtilidadDTO;

public interface UtilidadFachada {
	
	UtilidadDTO generarUtilidad(UUID idServicio);

	UtilidadDTO consultarUtilidadPorServicio(UUID idServicio);

}
