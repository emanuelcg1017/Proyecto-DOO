package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoServicioDTO {

	private UUID id;

	private EstadoServicioDTO estadoOrigen;

	private EstadoServicioDTO estadoDestino;

	public TransicionEstadoServicioDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setEstadoOrigen(new EstadoServicioDTO());

		setEstadoDestino(new EstadoServicioDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EstadoServicioDTO getEstadoOrigen() {

		return estadoOrigen;

	}

	public void setEstadoOrigen(EstadoServicioDTO estadoOrigen) {

		this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoServicioDTO());

	}

	public EstadoServicioDTO getEstadoDestino() {

		return estadoDestino;

	}

	public void setEstadoDestino(EstadoServicioDTO estadoDestino) {

		this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoServicioDTO());

	}

}
