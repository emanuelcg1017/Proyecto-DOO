package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.DetalleEntregaDominio;

public interface DetalleEntregaNegocio {

	List<DetalleEntregaDominio> consultarPorServicio(UUID idServicio);

}
