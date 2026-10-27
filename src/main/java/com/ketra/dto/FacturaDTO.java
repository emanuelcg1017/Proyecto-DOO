package com.ketra.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class FacturaDTO {

	private UUID id;

	private String numeroFactura;

	private LocalDate fechaFactura;

	private Double ingresos;

	private String estadoFactura;

	public FacturaDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroFactura(UtilTexto.VACIO);

		setFechaFactura(UtilFecha.FECHA_DEFECTO);

		setIngresos(UtilNumero.CERO_DECIMAL);

		setEstadoFactura(UtilTexto.VACIO);

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroFactura() {

		return numeroFactura;

	}

	public void setNumeroFactura(String numeroFactura) {

		this.numeroFactura = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroFactura);

	}

	public LocalDate getFechaFactura() {

		return fechaFactura;

	}

	public void setFechaFactura(LocalDate fechaFactura) {

		this.fechaFactura = UtilFecha.obtenerFechaDefecto(fechaFactura);

	}

	public Double getIngresos() {

		return ingresos;

	}

	public void setIngresos(Double ingresos) {

		this.ingresos = UtilNumero.obtenerValorDefecto(ingresos, UtilNumero.CERO_DECIMAL);

	}

	public String getEstadoFactura() {

		return estadoFactura;

	}

	public void setEstadoFactura(String estadoFactura) {

		this.estadoFactura = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estadoFactura);

	}

}
