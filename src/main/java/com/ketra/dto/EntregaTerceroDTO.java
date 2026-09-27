package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaTerceroDTO {

	private UUID id;
	private EntregaDTO entrega;
	private TerceroDTO tercero;

	public EntregaTerceroDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setEntrega(new EntregaDTO());
		setTercero(new TerceroDTO());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EntregaDTO getEntrega() {
		return entrega;
	}

	private void setEntrega(EntregaDTO entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO());
	}

	public TerceroDTO getTercero() {
		return tercero;
	}

	private void setTercero(TerceroDTO tercero) {
		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO());
	}

}
