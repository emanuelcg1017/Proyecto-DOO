package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoFacturaDTO {

	private UUID id;

	private EstadoFacturaDTO estadoOrigen;

	private EstadoFacturaDTO estadoDestino;

	public TransicionEstadoFacturaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setEstadoOrigen(new EstadoFacturaDTO());

		setEstadoDestino(new EstadoFacturaDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EstadoFacturaDTO getEstadoOrigen() {

		return estadoOrigen;

	}

	public void setEstadoOrigen(EstadoFacturaDTO estadoOrigen) {

		this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoFacturaDTO());

	}

	public EstadoFacturaDTO getEstadoDestino() {

		return estadoDestino;

	}

	public void setEstadoDestino(EstadoFacturaDTO estadoDestino) {

		this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoFacturaDTO());

	}

}
