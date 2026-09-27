package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadEntidad {

	private UUID id;
	private ServicioEntidad servicio;
	private Double valorIngresos;
	private Double valorCostos;
	private Double valorUtilidad;

	public UtilidadEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setServicio(new ServicioEntidad());
		setValorIngresos(UtilNumero.CERO_DECIMAL);
		setValorCostos(UtilNumero.CERO_DECIMAL);
		setValorUtilidad(UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	private void setServicio(ServicioEntidad servicio) {
		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad());
	}

	public Double getValorIngresos() {
		return valorIngresos;
	}

	private void setValorIngresos(Double valorIngresos) {
		this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);
	}

	public Double getValorCostos() {
		return valorCostos;
	}

	private void setValorCostos(Double valorCostos) {
		this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos, UtilNumero.CERO_DECIMAL);
	}

	public Double getValorUtilidad() {
		return valorUtilidad;
	}

	private void setValorUtilidad(Double valorUtilidad) {
		this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad, UtilNumero.CERO_DECIMAL);
	}

}
