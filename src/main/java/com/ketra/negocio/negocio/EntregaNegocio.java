package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.EntregaDominio;

public interface EntregaNegocio {

	List<EntregaDominio> consultarPorServicio(UUID idServicio);

}
