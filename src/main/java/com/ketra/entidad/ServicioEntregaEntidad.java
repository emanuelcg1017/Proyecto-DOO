package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private EntregaEntidad entrega;

	private ServicioEntregaEntidad(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.entrega = builder.entrega;
	}

	public UUID getId() {
		return id;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	public static class Builder {

		private UUID id;
		private ServicioEntidad servicio;
		private EntregaEntidad entrega;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioEntidad.Builder().build();
			entrega = new EntregaEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioEntidad servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad.Builder().build());
			return this;
		}

		public Builder entrega(EntregaEntidad entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad.Builder().build());
			return this;
		}

		public ServicioEntregaEntidad build() {
			return new ServicioEntregaEntidad(this);
		}
	}
}
