package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class ServicioFacturaEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private FacturaEntidad factura;

	private ServicioFacturaEntidad(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.factura = builder.factura;
	}

	public UUID getId() {
		return id;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public FacturaEntidad getFactura() {
		return factura;
	}

	public static class Builder {

		private UUID id;
		private ServicioEntidad servicio;
		private FacturaEntidad factura;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioEntidad.Builder().build();
			factura = new FacturaEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioEntidad servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad.Builder().build());
			return this;
		}

		public Builder factura(FacturaEntidad factura) {
			this.factura = UtilObjeto.obtenerValorDefectoSiNulo(factura, new FacturaEntidad.Builder().build());
			return this;
		}

		public ServicioFacturaEntidad build() {
			return new ServicioFacturaEntidad(this);
		}
	}
}
