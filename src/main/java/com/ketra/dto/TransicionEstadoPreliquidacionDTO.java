package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoPreliquidacionDTO {

	private UUID id;

	private EstadoPreliquidacionDTO estadoOrigen;

	private EstadoPreliquidacionDTO estadoDestino;

	public TransicionEstadoPreliquidacionDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setEstadoOrigen(new EstadoPreliquidacionDTO());

		setEstadoDestino(new EstadoPreliquidacionDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EstadoPreliquidacionDTO getEstadoOrigen() {

		return estadoOrigen;

	}

	public void setEstadoOrigen(EstadoPreliquidacionDTO estadoOrigen) {

		this.estadoOrigen = UtilObjeto.obtenerValorDefectoSiNulo(estadoOrigen, new EstadoPreliquidacionDTO());

	}

	public EstadoPreliquidacionDTO getEstadoDestino() {

		return estadoDestino;

	}

	public void setEstadoDestino(EstadoPreliquidacionDTO estadoDestino) {

		this.estadoDestino = UtilObjeto.obtenerValorDefectoSiNulo(estadoDestino, new EstadoPreliquidacionDTO());

	}

}
