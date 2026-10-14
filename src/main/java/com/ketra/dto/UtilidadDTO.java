
package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadDTO {

	private UUID id;
	private ServicioDTO servicio;
	private Double valorIngresos;
	private Double valorCostos;
	private Double valorUtilidad;

	public UtilidadDTO() {
		this(new Builder());
	}

	private UtilidadDTO(Builder builder) {

		setId(builder.id);
		setServicio(builder.servicio);
		setValorIngresos(builder.valorIngresos);
		setValorCostos(builder.valorCostos);
		setValorUtilidad(builder.valorUtilidad);
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
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());
	}

	public Double getValorIngresos() {
		return valorIngresos;
	}

	public void setValorIngresos(Double valorIngresos) {
		this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);
	}

	public Double getValorCostos() {
		return valorCostos;
	}

	public void setValorCostos(Double valorCostos) {
		this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos, UtilNumero.CERO_DECIMAL);
	}

	public Double getValorUtilidad() {
		return valorUtilidad;
	}

	public void setValorUtilidad(Double valorUtilidad) {
		this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad, UtilNumero.CERO_DECIMAL);
	}

	public static class Builder {

		private UUID id;
		private ServicioDTO servicio;
		private Double valorIngresos;
		private Double valorCostos;
		private Double valorUtilidad;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;
			servicio = new ServicioDTO.Builder().build();
			valorIngresos = UtilNumero.CERO_DECIMAL;
			valorCostos = UtilNumero.CERO_DECIMAL;
			valorUtilidad = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder servicio(ServicioDTO servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());
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

		public UtilidadDTO build() {
			return new UtilidadDTO(this);
		}
	}
}
