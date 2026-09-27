package com.ketra.entidad;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PreliquidacionEntidad {

	private UUID id;
	private String numeroPreliquidacion;
	private TerceroEntidad tercero;
	private CostoRecorridoEntidad valorCosto;
	private LocalDate fechaPreliquidacion;
	private String Estado;

	public PreliquidacionEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroPreliquidacion(UtilTexto.VACIO);
		setTercero(new TerceroEntidad());
		setValorCosto(new CostoRecorridoEntidad());
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

	public TerceroEntidad getTercero() {
		return tercero;
	}

	private void setTercero(TerceroEntidad tercero) {
		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroEntidad());
	}

	public CostoRecorridoEntidad getValorCosto() {
		return valorCosto;
	}

	private void setValorCosto(CostoRecorridoEntidad valorCosto) {
		this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoEntidad());
	}

	public LocalDate getFechaPreliquidacion() {
		return fechaPreliquidacion;
	}

	private void setFechaPreliquidacion(LocalDate fechaPreliquidacion) {
		this.fechaPreliquidacion = UtilFecha.obtenerFechaDefecto(fechaPreliquidacion);
	}

	public String getEstado() {
		return Estado;
	}

	private void setEstado(String estado) {
		Estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
	}

}
