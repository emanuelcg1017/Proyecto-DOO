package com.ketra.negocio.negocio;

import java.util.UUID;

import com.ketra.dominio.UtilidadDominio;

public interface UtilidadNegocio {

	Double calcularValorIngresos(UUID idServicio);

	Double calcularValorCostos(UUID idServicio);

	UtilidadDominio generarUtilidad(UUID idServicio);

	UtilidadDominio consultarUtilidadPorServicio(UUID idServicio);
}
