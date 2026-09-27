package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CostoRecorridoDominio {

	private UUID id;
	private String numeroCosto;
	private DetalleEntregaDominio detalleEntrega;
	private int valorPorKM;
	private Double valorCosto;

	CostoRecorridoDominio(Builder builder) {
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

	public DetalleEntregaDominio getDetalleEntrega() {
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
		private DetalleEntregaDominio detalleEntrega;
		private int valorPorKM;
		private Double valorCosto;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroCosto = UtilTexto.VACIO;
			detalleEntrega = new DetalleEntregaDominio.Builder().build();
			valorPorKM = 0;
			valorCosto = 0.0;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroCosto(String numeroCosto) {
			this.numeroCosto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroCosto);
			return this;
		}

		public Builder detalleEntrega(DetalleEntregaDominio detalleEntrega) {
			this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaDominio.Builder().build());
			return this;
		}

		public Builder valorPorKM(int valorPorKM) {
			this.valorPorKM = valorPorKM;
			return this;
		}

		public Builder valorCosto(Double valorCosto) {
			this.valorCosto = valorCosto;
			return this;
		}

		public CostoRecorridoDominio build() {
			return new CostoRecorridoDominio(this);
		}
	}
}
