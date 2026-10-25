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

	private UtilidadDTO(Builder builder) {

		this.id = builder.id;

		this.servicio = builder.servicio;

		this.valorIngresos = builder.valorIngresos;

		this.valorCostos = builder.valorCostos;

		this.valorUtilidad = builder.valorUtilidad;

		this.costosRecorrido = builder.costosRecorrido;

		this.detallesEntrega = builder.detallesEntrega;

		this.entregas = builder.entregas;

		this.facturas = builder.facturas;

	}

	public UUID getId() {

		return id;

	}

	public ServicioDTO getServicio() {

		return servicio;

	}

	public Double getValorIngresos() {

		return valorIngresos;

	}

	public Double getValorCostos() {

		return valorCostos;

	}

	public Double getValorUtilidad() {

		return valorUtilidad;

	}

	public List<FacturaDTO> getFacturas() {

		return facturas;

	}

	public List<EntregaDTO> getEntregas() {

		return entregas;

	}

	public List<DetalleEntregaDTO> getDetallesEntrega() {

		return detallesEntrega;

	}

	public List<CostoRecorridoDTO> getCostosRecorrido() {

		return costosRecorrido;

	}

	public static class Builder {

		private UUID id;

		private ServicioDTO servicio;

		private Double valorIngresos;

		private Double valorCostos;

		private Double valorUtilidad;

		private List<FacturaDTO> facturas;

		private List<EntregaDTO> entregas;

		private List<DetalleEntregaDTO> detallesEntrega;

		private List<CostoRecorridoDTO> costosRecorrido;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			servicio = new ServicioDTO.Builder().build();

			valorIngresos = UtilNumero.CERO_DECIMAL;

			valorCostos = UtilNumero.CERO_DECIMAL;

			valorUtilidad = UtilNumero.CERO_DECIMAL;

			costosRecorrido = List.of();

			detallesEntrega = List.of();

			entregas = List.of();

			facturas = List.of();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder servicio(ServicioDTO servicio) {

			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

			return this;

		}

		public Builder valorIngresos(Double valorIngresos) {

			this.valorIngresos = UtilNumero.obtenerValorDefecto(valorIngresos, UtilNumero.CERO_DECIMAL);

			return this;

		}

		public Builder valorCostos(Double valorCostos) {

			this.valorCostos = UtilNumero.obtenerValorDefecto(valorCostos, UtilNumero.CERO_DECIMAL);

			return this;

		}

		public Builder valorUtilidad(Double valorUtilidad) {

			this.valorUtilidad = UtilNumero.obtenerValorDefecto(valorUtilidad, UtilNumero.CERO_DECIMAL);

			return this;

		}

		public Builder facturas(List<FacturaDTO> facturas) {

			this.facturas = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(facturas, List.of()));

			return this;

		}

		public Builder entregas(List<EntregaDTO> entregas) {

			this.entregas = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(entregas, List.of()));

			return this;

		}

		public Builder detallesEntrega(List<DetalleEntregaDTO> detallesEntrega) {

			this.detallesEntrega = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(detallesEntrega, List.of()));

			return this;

		}

		public Builder costosRecorrido(List<CostoRecorridoDTO> costosRecorrido) {

			this.costosRecorrido = List.copyOf(UtilObjeto.obtenerValorDefectoSiNulo(costosRecorrido, List.of()));

			return this;

		}

		public UtilidadDTO build() {

			return new UtilidadDTO(this);

		}

	}

}
