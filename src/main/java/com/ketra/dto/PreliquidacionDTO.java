package com.ketra.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PreliquidacionDTO {

	private UUID id;
	private String numeroPreliquidacion;
	private TerceroDTO tercero;
	private CostoRecorridoDTO valorCosto;
	private LocalDate fechaPreliquidacion;
	private String estado;

	public PreliquidacionDTO() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroPreliquidacion(UtilTexto.VACIO);
		setTercero(new TerceroDTO());
		setValorCosto(new CostoRecorridoDTO());
		setFechaPreliquidacion(UtilFecha.FECHA_DEFECTO);
		setEstado(UtilTexto.VACIO);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroPreliquidacion() {
		return numeroPreliquidacion;
	}

	private void setNumeroPreliquidacion(String numeroPreliquidacion) {
		this.numeroPreliquidacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPreliquidacion);
	}

	public TerceroDTO getTercero() {
		return tercero;
	}

	private void setTercero(TerceroDTO tercero) {
		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO());
	}

	public CostoRecorridoDTO getValorCosto() {
		return valorCosto;
	}

	private void setValorCosto(CostoRecorridoDTO valorCosto) {
		this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoDTO());
	}

	public LocalDate getFechaPreliquidacion() {
		return fechaPreliquidacion;
	}

	private void setFechaPreliquidacion(LocalDate fechaPreliquidacion) {
		this.fechaPreliquidacion = UtilFecha.obtenerFechaDefecto(fechaPreliquidacion);
	}

	public String getEstado() {
		return estado;
	}

	private void setEstado(String estado) {
		this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
	}

}
