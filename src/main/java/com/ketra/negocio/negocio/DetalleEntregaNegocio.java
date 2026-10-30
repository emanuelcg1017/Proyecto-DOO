package com.ketra.negocio.negocio;

import com.ketra.dominio.EntregaDominio;
import java.util.List;

import com.ketra.dominio.DetalleEntregaDominio;

public interface DetalleEntregaNegocio {

	List<DetalleEntregaDominio> consultarDetallesEntrega(List<EntregaDominio> entregas);

}
