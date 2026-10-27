package com.ketra.dto;

import java.util.List;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class UtilidadDTO {

	private UUID id;

	private ServicioDTO servicio;

	private Double valorIngresos;

	private Double valorCostos;

	private Double valorUtilidad;

	private List<CostoRecorridoDTO> costosRecorrido;

	private List<DetalleEntregaDTO> detallesEntrega;

	private List<EntregaDTO> entregas;

	private List<FacturaDTO> facturas;

	public UtilidadDTO() {

		setId(UtilUUID.UUID_DEFECTO);

		setServicio(new ServicioDTO());

		setValorIngresos(UtilNumero.CERO_DECIMAL);

		setValorCostos(UtilNumero.CERO_DECIMAL);

		setValorUtilidad(UtilNumero.CERO_DECIMAL);

		setCostosRecorrido(List.of());

		setDetallesEntrega(List.of());

		setEntregas(List.of());

		setFacturas(List.of());

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public ServicioDTO getServicio() {

		return servicio;

	}

	public void setServicio(ServicioDTO servicio) {

		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO());

	}

	public Double getValorIngresos() {

		return valorIngresos;

	}

	public void setValorIngresos(Double valorIngresos) {

		this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);

	}

	public Double getValorCostos() {

		return valorCostos;

	}

	public void setValorCostos(Double valorCostos) {

		this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos, UtilNumero.CERO_DECIMAL);

	}

	public Double getValorUtilidad() {

		return valorUtilidad;

	}

	public void setValorUtilidad(Double valorUtilidad) {

		this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad, UtilNumero.CERO_DECIMAL);

	}

	public List<CostoRecorridoDTO> getCostosRecorrido() {

		return costosRecorrido;

	}

	public void setCostosRecorrido(List<CostoRecorridoDTO> costosRecorrido) {

		this.costosRecorrido = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(costosRecorrido, List.of()));

	}

	public List<DetalleEntregaDTO> getDetallesEntrega() {

		return detallesEntrega;

	}

	public void setDetallesEntrega(List<DetalleEntregaDTO> detallesEntrega) {

		this.detallesEntrega = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(detallesEntrega, List.of()));

	}

	public List<EntregaDTO> getEntregas() {

		return entregas;

	}

	public void setEntregas(List<EntregaDTO> entregas) {

		this.entregas = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(entregas, List.of()));

	}

	public List<FacturaDTO> getFacturas() {

		return facturas;

	}

	public void setFacturas(List<FacturaDTO> facturas) {

		this.facturas = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(facturas, List.of()));

	}

}
