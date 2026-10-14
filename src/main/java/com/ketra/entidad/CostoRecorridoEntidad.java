package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CostoRecorridoEntidad {

	private UUID id;
	private String numeroCosto;
	private DetalleEntregaEntidad detalleEntrega;
	private int valorPorKM;
	private Double valorCosto;

	private CostoRecorridoEntidad(Builder builder) {
		this.id = builder.id;
		this.numeroCosto = builder.numeroCosto;
		this.detalleEntrega = builder.detalleEntrega;
		this.valorPorKM = builder.valorPorKM;
		this.valorCosto = builder.valorCosto;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroCosto() {
		return numeroCosto;
	}

	public DetalleEntregaEntidad getDetalleEntrega() {
		return detalleEntrega;
	}

	public int getValorPorKM() {
		return valorPorKM;
	}

	public Double getValorCosto() {
		return valorCosto;
	}

	public static class Builder {

		private UUID id;
		private String numeroCosto;
		private DetalleEntregaEntidad detalleEntrega;
		private int valorPorKM;
		private Double valorCosto;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroCosto = UtilTexto.VACIO;
			detalleEntrega = new DetalleEntregaEntidad.Builder().build();
			valorPorKM = UtilNumero.CERO;
			valorCosto = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroCosto(String numeroCosto) {
			this.numeroCosto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroCosto);
			return this;
		}

		public Builder detalleEntrega(DetalleEntregaEntidad detalleEntrega) {
			this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaEntidad.Builder().build());
			return this;
		}

		public Builder valorPorKM(int valorPorKM) {
			this.valorPorKM = valorPorKM;
			return this;
		}

		public Builder valorCosto(Double valorCosto) {
			this.valorCosto = UtilNumero.obtenerValorDefecto(valorCosto, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public CostoRecorridoEntidad build() {
			return new CostoRecorridoEntidad(this);
		}
	}
}
