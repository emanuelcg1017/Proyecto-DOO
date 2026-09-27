package com.ketra.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PreliquidacionDominio {

	private UUID id;
	private String numeroPreliquidacion;
	private TerceroDominio tercero;
	private CostoRecorridoDominio valorCosto;
	private LocalDate fechaPreliquidacion;
	private String estado;

	PreliquidacionDominio(Builder builder) {
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

	public TerceroDominio getTercero() {
		return tercero;
	}

	public CostoRecorridoDominio getValorCosto() {
		return valorCosto;
	}

	public LocalDate getFechaPreliquidacion() {
		return fechaPreliquidacion;
	}

	public String getEstado() {
		return estado;
	}

	public static class Builder {
		private UUID id;
		private String numeroPreliquidacion;
		private TerceroDominio tercero;
		private CostoRecorridoDominio valorCosto;
		private LocalDate fechaPreliquidacion;
		private String estado;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroPreliquidacion = UtilTexto.VACIO;
			tercero = new TerceroDominio.Builder().build();
			valorCosto = new CostoRecorridoDominio.Builder().build();
			fechaPreliquidacion = UtilFecha.FECHA_DEFECTO;
			estado = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroPreliquidacion(String numeroPreliquidacion) {
			this.numeroPreliquidacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPreliquidacion);
			return this;
		}

		public Builder tercero(TerceroDominio tercero) {
			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDominio.Builder().build());
			return this;
		}

		public Builder valorCosto(CostoRecorridoDominio valorCosto) {
			this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoDominio.Builder().build());
			return this;
		}

		public Builder fechaPreliquidacion(LocalDate fechaPreliquidacion) {
			this.fechaPreliquidacion = UtilFecha.obtenerFechaDefecto(fechaPreliquidacion);
			return this;
		}

		public Builder estado(String estado) {
			this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);
			return this;
		}

		public PreliquidacionDominio build() {
			return new PreliquidacionDominio(this);
		}
	}
}
