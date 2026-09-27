package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioEntregaDominio {

	private UUID id;
	private ServicioDominio servicio;
	private EntregaDominio entrega;

	ServicioEntregaDominio(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.entrega = builder.entrega;
	}

	public UUID getId() {
		return id;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public EntregaDominio getEntrega() {
		return entrega;
	}

	public static class Builder {
		private UUID id;
		private ServicioDominio servicio;
		private EntregaDominio entrega;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioDominio.Builder().build();
			entrega = new EntregaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			return this;
		}

		public Builder entrega(EntregaDominio entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDominio.Builder().build());
			return this;
		}

		public ServicioEntregaDominio build() {
			return new ServicioEntregaDominio(this);
		}
	}
}
