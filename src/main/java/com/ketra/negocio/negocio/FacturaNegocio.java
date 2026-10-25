package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.FacturaDominio;

public interface FacturaNegocio {

	List<FacturaDominio> consultarPorServicio(UUID idServicio);

}
