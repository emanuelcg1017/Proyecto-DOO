package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoEntregaDTO {

	private UUID id;

	private EstadoEntregaDTO estadoOrigen;

	private EstadoEntregaDTO estadoDestino;

	public TransicionEstadoEntregaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setEstadoOrigen(new EstadoEntregaDTO());

		setEstadoDestino(new EstadoEntregaDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EstadoEntregaDTO getEstadoOrigen() {

		return estadoOrigen;

	}

	public void setEstadoOrigen(EstadoEntregaDTO estadoOrigen) {

		this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoEntregaDTO());

	}

	public EstadoEntregaDTO getEstadoDestino() {

		return estadoDestino;

	}

	public void setEstadoDestino(EstadoEntregaDTO estadoDestino) {

		this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoEntregaDTO());

	}

}
