package com.ketra.negocio.fachada.assembler;

public interface DTOAssembler <D, T> {

	T convertirADTO(D dominio);

	D convertirADominio(T dto);
}
