package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.CostoRecorridoDominio;

public interface CostoRecorridoNegocio {

	List<CostoRecorridoDominio> consultarPorServicio(UUID idServicio);

}
