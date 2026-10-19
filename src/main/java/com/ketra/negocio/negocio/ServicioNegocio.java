package com.ketra.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.ketra.dominio.ServicioDominio;

public interface ServicioNegocio {

	ServicioDominio consultarPorId(UUID id);

	List<ServicioDominio> consultarPorFiltro(ServicioDominio filtro);

	List<ServicioDominio> consultarTodos();

	ServicioDominio actualizarEstado(UUID id, ServicioDominio servicio);

}
