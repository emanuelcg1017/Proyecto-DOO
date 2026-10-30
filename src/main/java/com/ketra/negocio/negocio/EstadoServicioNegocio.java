package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.EstadoServicioDominio;

public interface EstadoServicioNegocio {

	EstadoServicioDominio consultarPorId(UUID id);

	List<EstadoServicioDominio> consultarPorFiltro(EstadoServicioDominio filtro);

}
