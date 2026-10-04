package com.ketra.negocio.negocio;

import java.util.UUID;

import com.ketra.dominio.UtilidadDominio;

public interface UtilidadNegocio {

	UtilidadDominio generarUtilidad(UUID idServicio);

	UtilidadDominio consultarUtilidadPorServicio(UUID idServicio);
}
