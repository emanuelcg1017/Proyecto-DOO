package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioFacturaDominio {

	private UUID id;
	private ServicioDominio servicio;
	private FacturaDominio factura;

	ServicioFacturaDominio(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.factura = builder.factura;
	}

	public UUID getId() {
		return id;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public FacturaDominio getFactura() {
		return factura;
	}

	public static class Builder {
		private UUID id;
		private ServicioDominio servicio;
		private FacturaDominio factura;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioDominio.Builder().build();
			factura = new FacturaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			return this;
		}

		public Builder factura(FacturaDominio factura) {
			this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaDominio.Builder().build());
			return this;
		}

		public ServicioFacturaDominio build() {
			return new ServicioFacturaDominio(this);
		}
	}
}
