package com.ketra.entidad;

import java.util.UUID;
import java.time.LocalDate;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class FacturaEntidad {

	private UUID id;
	private String numeroFactura;
	private LocalDate fechaFactura;
	private Double ingresos;
	private String EstadoFactura;

	private FacturaEntidad(Builder builder) {
		this.id = builder.id;
		this.numeroFactura = builder.numeroFactura;
		this.fechaFactura = builder.fechaFactura;
		this.ingresos = builder.ingresos;
		this.EstadoFactura = builder.EstadoFactura;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public Double getIngresos() {
		return ingresos;
	}

	public String getEstadoFactura() {
		return EstadoFactura;
	}

	public static class Builder {

		private UUID id;
		private String numeroFactura;
		private LocalDate fechaFactura;
		private Double ingresos;
		private String EstadoFactura;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroFactura = UtilTexto.VACIO;
			fechaFactura = UtilFecha.FECHA_DEFECTO;
			ingresos = UtilNumero.CERO_DECIMAL;
			EstadoFactura = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroFactura(String numeroFactura) {
			this.numeroFactura = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroFactura);
			return this;
		}

		public Builder fechaFactura(LocalDate fechaFactura) {
			this.fechaFactura = UtilFecha.obtenerFechaDefecto(fechaFactura);
			return this;
		}

		public Builder ingresos(Double ingresos) {
			this.ingresos = UtilNumero.obtenerValorDefecto(ingresos, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public Builder EstadoFactura(String EstadoFactura) {
			this.EstadoFactura = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(EstadoFactura);
			return this;
		}

		public FacturaEntidad build() {
			return new FacturaEntidad(this);
		}
	}
}
