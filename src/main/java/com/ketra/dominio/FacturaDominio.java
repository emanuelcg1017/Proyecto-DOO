package com.ketra.dominio;

import com.ketra.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilNumero;

public class FacturaDominio {

	private UUID id;
	private String numeroFactura;
	private LocalDate fechaFactura;
	private Double ingresos;
	private EstadoFacturaDominio estadoFactura;

	FacturaDominio(Builder builder) {
		this.id = builder.id;
		this.numeroFactura = builder.numeroFactura;
		this.fechaFactura = builder.fechaFactura;
		this.ingresos = builder.ingresos;
		this.estadoFactura = builder.estadoFactura;
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

	public EstadoFacturaDominio getEstadoFactura() {
		return estadoFactura;
	}

	public static class Builder {
		private UUID id;
		private String numeroFactura;
		private LocalDate fechaFactura;
		private Double ingresos;
		private EstadoFacturaDominio estadoFactura;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroFactura = UtilTexto.VACIO;
			fechaFactura = UtilFecha.FECHA_DEFECTO;
			ingresos = UtilNumero.CERO_DECIMAL;
			estadoFactura = new EstadoFacturaDominio.Builder().build();
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

		public Builder estadoFactura(EstadoFacturaDominio estadoFactura) {
			this.estadoFactura = UtilObjeto.obtenerValorDefectoSiNulo(estadoFactura, new EstadoFacturaDominio.Builder().build());
			return this;
		}

		public FacturaDominio build() {
			return new FacturaDominio(this);
		}
	}
}
