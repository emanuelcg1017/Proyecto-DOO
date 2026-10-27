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

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroCosto(UtilTexto.VACIO);

		setDetalleEntrega(new DetalleEntregaDTO());

		setValorPorKM(UtilNumero.CERO);

		setValorCosto(UtilNumero.CERO_DECIMAL);

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

		this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaDTO());

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

}
