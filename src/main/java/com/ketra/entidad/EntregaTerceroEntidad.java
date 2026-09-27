package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaTerceroEntidad {

	private UUID id;
	private EntregaEntidad entrega;
	private TerceroEntidad tercero;

	public EntregaTerceroEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setEntrega(new EntregaEntidad());
		setTercero(new TerceroEntidad());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	private void setEntrega(EntregaEntidad entrega) {
		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad());
	}

	public TerceroEntidad getTercero() {
		return tercero;
	}

	private void setTercero(TerceroEntidad tercero) {
		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroEntidad());
	}

}
