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

	public CostoRecorridoEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroCosto(UtilTexto.VACIO);
		setDetalleEntrega(new DetalleEntregaEntidad());
		setValorPorKM(UtilNumero.CERO);
		setValorCosto(UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroCosto() {
		return numeroCosto;
	}

	private void setNumeroCosto(String numeroCosto) {
		this.numeroCosto = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroCosto);
	}

	public DetalleEntregaEntidad getDetalleEntrega() {
		return detalleEntrega;
	}

	private void setDetalleEntrega(DetalleEntregaEntidad detalleEntrega) {
		this.detalleEntrega = UtilObjeto.obtenerValorDefectoSiNulo(detalleEntrega, new DetalleEntregaEntidad());
	}

	public int getValorPorKM() {
		return valorPorKM;
	}

	private void setValorPorKM(int valorPorKM) {
		this.valorPorKM = UtilNumero.obtenerValorDefecto(valorPorKM, UtilNumero.CERO);
	}

	public Double getValorCosto() {
		return valorCosto;
	}

	private void setValorCosto(Double valorCosto) {
		this.valorCosto = UtilNumero.obtenerValorDefecto(valorCosto, UtilNumero.CERO_DECIMAL);
	}

}
