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

	public UtilidadEntidad() {
		this(new Builder());
	}

	private UtilidadEntidad(Builder builder) {

		setId(builder.id);
		setServicio(builder.servicio);
		setValorIngresos(builder.valorIngresos);
		setValorCostos(builder.valorCostos);
		setValorUtilidad(builder.valorUtilidad);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	private void setServicio(
			final ServicioEntidad servicio) {

		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio,new ServicioEntidad.Builder().build());
	}

	public Double getValorIngresos() {
		return valorIngresos;
	}

	private void setValorIngresos(
			final Double valorIngresos) {

		this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);
	}

	public Double getValorCostos() {
		return valorCostos;
	}

	private void setValorCostos(Double valorCostos) {

		this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos,UtilNumero.CERO_DECIMAL);
	}

	public Double getValorUtilidad() {
		return valorUtilidad;
	}

	private void setValorUtilidad(Double valorUtilidad) {

		this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad,UtilNumero.CERO_DECIMAL);
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

			this.id = id;
			return this;
		}

		public Builder servicio(
				final ServicioEntidad servicio) {

			this.servicio = servicio;
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

		public UtilidadEntidad build() {

			return new UtilidadEntidad(this);
		}
	}
}