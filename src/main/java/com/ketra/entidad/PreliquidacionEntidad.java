package com.ketra.entidad;

import java.util.UUID;
import java.time.LocalDate;

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
	private EstadoPreliquidacionEntidad estado;

	private PreliquidacionEntidad(Builder builder) {
		this.id = builder.id;
		this.numeroPreliquidacion = builder.numeroPreliquidacion;
		this.tercero = builder.tercero;
		this.valorCosto = builder.valorCosto;
		this.fechaPreliquidacion = builder.fechaPreliquidacion;
		this.estado = builder.estado;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroPreliquidacion() {
		return numeroPreliquidacion;
	}

	public TerceroEntidad getTercero() {
		return tercero;
	}

	public CostoRecorridoEntidad getValorCosto() {
		return valorCosto;
	}

	public LocalDate getFechaPreliquidacion() {
		return fechaPreliquidacion;
	}

	public EstadoPreliquidacionEntidad getEstado() {
		return estado;
	}

	public static class Builder {

		private UUID id;
		private String numeroPreliquidacion;
		private TerceroEntidad tercero;
		private CostoRecorridoEntidad valorCosto;
		private LocalDate fechaPreliquidacion;
		private EstadoPreliquidacionEntidad estado;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroPreliquidacion = UtilTexto.VACIO;
			tercero = new TerceroEntidad.Builder().build();
			valorCosto = new CostoRecorridoEntidad.Builder().build();
			fechaPreliquidacion = UtilFecha.FECHA_DEFECTO;
			estado = new EstadoPreliquidacionEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroPreliquidacion(String numeroPreliquidacion) {
			this.numeroPreliquidacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPreliquidacion);
			return this;
		}

		public Builder tercero(TerceroEntidad tercero) {
			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroEntidad.Builder().build());
			return this;
		}

		public Builder valorCosto(CostoRecorridoEntidad valorCosto) {
			this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoEntidad.Builder().build());
			return this;
		}

		public Builder fechaPreliquidacion(LocalDate fechaPreliquidacion) {
			this.fechaPreliquidacion = UtilFecha.obtenerFechaDefecto(fechaPreliquidacion);
			return this;
		}

		public Builder estado(EstadoPreliquidacionEntidad estado) {
			this.estado = UtilObjeto.obtenerValorDefectoSiNulo(estado, new EstadoPreliquidacionEntidad.Builder().build());
			return this;
		}

		public PreliquidacionEntidad build() {
			return new PreliquidacionEntidad(this);
		}
	}
}
