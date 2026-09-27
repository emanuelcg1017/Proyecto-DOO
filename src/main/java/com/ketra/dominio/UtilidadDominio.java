package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadDominio {

	private UUID id;
	private ServicioDominio servicio;
	private Double valorIngresos;
	private Double valorCostos;
	private Double valorUtilidad;

	UtilidadDominio(Builder builder) {
		this.id = builder.id;
		this.servicio = builder.servicio;
		this.valorIngresos = builder.valorIngresos;
		this.valorCostos = builder.valorCostos;
		this.valorUtilidad = builder.valorUtilidad;
	}

	public UUID getId() {
		return id;
	}

	public ServicioDominio getServicio() {
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
		private ServicioDominio servicio;
		private Double valorIngresos;
		private Double valorCostos;
		private Double valorUtilidad;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			valorIngresos = UtilNumero.CERO_DECIMAL;
			valorCostos = UtilNumero.CERO_DECIMAL;
			valorUtilidad = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			return this;
		}

		public Builder valorIngresos(Double valorIngresos) {
			this.valorIngresos = valorIngresos;
			return this;
		}

		public Builder valorCostos(Double valorCostos) {
			this.valorCostos = valorCostos;
			return this;
		}

		public Builder valorUtilidad(Double valorUtilidad) {
			this.valorUtilidad = valorUtilidad;
			return this;
		}

		public UtilidadDominio build() {
			return new UtilidadDominio(this);
		}
	}
}
