package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class CostoRecorridoDTO {

	private UUID id;

	private String numeroCosto;

	private DetalleEntregaDTO detalleEntrega;

	private int valorPorKM;

	private Double valorCosto;

	public CostoRecorridoDTO() {

		this(new Builder());

	}

	private CostoRecorridoDTO(Builder builder) {

		this.id = builder.id;

		this.numeroCosto = builder.numeroCosto;

		this.detalleEntrega = builder.detalleEntrega;

		this.valorPorKM = builder.valorPorKM;

		this.valorCosto = builder.valorCosto;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroCosto() {

		return numeroCosto;

	}

	public void setNumeroCosto(String numeroCosto) {

		this.numeroCosto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroCosto);

	}

	public DetalleEntregaDTO getDetalleEntrega() {

		return detalleEntrega;

	}

	public void setDetalleEntrega(DetalleEntregaDTO detalleEntrega) {

		this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaDTO.Builder().build());

	}

	public int getValorPorKM() {

		return valorPorKM;

	}

	public void setValorPorKM(int valorPorKM) {

		this.valorPorKM = UtilNumero.obtenerValorDefecto(valorPorKM, UtilNumero.CERO);

	}

	public Double getValorCosto() {

		return valorCosto;

	}

	public void setValorCosto(Double valorCosto) {

		this.valorCosto = UtilNumero.obtenerValorDefecto(valorCosto, UtilNumero.CERO_DECIMAL);

	}

	public static class Builder {

		private UUID id;

		private String numeroCosto;

		private DetalleEntregaDTO detalleEntrega;

		private int valorPorKM;

		private Double valorCosto;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			numeroCosto = UtilTexto.VACIO;

			detalleEntrega = new DetalleEntregaDTO.Builder().build();

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

		public Builder detalleEntrega(DetalleEntregaDTO detalleEntrega) {

			this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaDTO.Builder().build());

			return this;

		}

		public Builder valorPorKM(int valorPorKM) {

			this.valorPorKM = UtilNumero.obtenerValorDefecto(valorPorKM, UtilNumero.CERO);

			return this;

		}

		public Builder valorCosto(Double valorCosto) {

			this.valorCosto = UtilNumero.obtenerValorDefecto(valorCosto, UtilNumero.CERO_DECIMAL);

			return this;

		}

		public CostoRecorridoDTO build() {

			return new CostoRecorridoDTO(this);

		}

	}

}
