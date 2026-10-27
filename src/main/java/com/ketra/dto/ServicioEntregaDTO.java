package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaDTO {

	private UUID id;

	private ServicioDTO servicio;

	private EntregaDTO entrega;

	public ServicioEntregaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setServicio(new ServicioDTO());

		setEntrega(new EntregaDTO());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public ServicioDTO getServicio() {

		return servicio;

	}

	public void setServicio(ServicioDTO servicio) {

		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO());

	}

	public EntregaDTO getEntrega() {

		return entrega;

	}

	public void setEntrega(EntregaDTO entrega) {

		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO());

	}

}
