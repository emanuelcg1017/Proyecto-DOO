package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.TransicionEstadoServicioDominio;

public interface TransicionEstadoServicioNegocio {

	TransicionEstadoServicioDominio consultarPorId(UUID id);

	List<TransicionEstadoServicioDominio> consultarPorFiltro(TransicionEstadoServicioDominio filtro);

}
