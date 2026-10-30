package com.ketra.negocio.fachada;

import java.util.UUID;

import com.ketra.dto.UtilidadDTO;

public interface UtilidadFachada {

	UtilidadDTO consultarUtilidadPorServicio(UUID idServicio);

}
