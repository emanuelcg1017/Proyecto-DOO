package com.ketra.negocio.negocio;

import com.ketra.dominio.DetalleEntregaDominio;
import java.util.List;

import com.ketra.dominio.CostoRecorridoDominio;

public interface CostoRecorridoNegocio {

	List<CostoRecorridoDominio> consultarCostosRecorrido(List<DetalleEntregaDominio> detallesEntrega);

}
