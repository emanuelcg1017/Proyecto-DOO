package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private Double valorIngresos;
	private Double valorCostos;
	private Double valorUtilidad;

	private UtilidadEntidad(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.valorIngresos = builder.valorIngresos;
		this.valorCostos = builder.valorCostos;
		this.valorUtilidad = builder.valorUtilidad;
	}

	public UUID getId() {
		return id;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public Double getValorIngresos() {
		return valorIngresos;
	}

	public Double getValorCostos() {
		return valorCostos;
	}

	public Double getValorUtilidad() {
		return valorUtilidad;
	}

	public static class Builder {

		private UUID id;
		private ServicioEntidad servicio;
		private Double valorIngresos;
		private Double valorCostos;
		private Double valorUtilidad;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = new ServicioEntidad.Builder().build();
			valorIngresos = UtilNumero.CERO_DECIMAL;
			valorCostos = UtilNumero.CERO_DECIMAL;
			valorUtilidad = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioEntidad servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad.Builder().build());
			return this;
		}

		public Builder valorIngresos(Double valorIngresos) {
			this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public Builder valorCostos(Double valorCostos) {
			this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public Builder valorUtilidad(Double valorUtilidad) {
			this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public UtilidadEntidad build() {
			return new UtilidadEntidad(this);
		}
	}
}
