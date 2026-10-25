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

		this(new Builder());

	}

	private PreliquidacionDTO(Builder builder) {

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

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroPreliquidacion() {

		return numeroPreliquidacion;

	}

	public void setNumeroPreliquidacion(String numeroPreliquidacion) {

		this.numeroPreliquidacion = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPreliquidacion);

	}

	public TerceroDTO getTercero() {

		return tercero;

	}

	public void setTercero(TerceroDTO tercero) {

		this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO.Builder().build());

	}

	public CostoRecorridoDTO getValorCosto() {

		return valorCosto;

	}

	public void setValorCosto(CostoRecorridoDTO valorCosto) {

		this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoDTO.Builder().build());

	}

	public LocalDate getFechaPreliquidacion() {

		return fechaPreliquidacion;

	}

	public void setFechaPreliquidacion(LocalDate fechaPreliquidacion) {

		this.fechaPreliquidacion = UtilFecha.obtenerFechaDefecto(fechaPreliquidacion);

	}

	public String getEstado() {

		return estado;

	}

	public void setEstado(String estado) {

		this.estado = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estado);

	}

	public static class Builder {

		private UUID id;

		private String numeroPreliquidacion;

		private TerceroDTO tercero;

		private CostoRecorridoDTO valorCosto;

		private LocalDate fechaPreliquidacion;

		private String estado;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			numeroPreliquidacion = UtilTexto.VACIO;

			tercero = new TerceroDTO.Builder().build();

			valorCosto = new CostoRecorridoDTO.Builder().build();

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

		public Builder tercero(TerceroDTO tercero) {

			this.tercero = UtilObjeto.obtenerValorDefectoSiNulo(tercero, new TerceroDTO.Builder().build());

			return this;

		}

		public Builder valorCosto(CostoRecorridoDTO valorCosto) {

			this.valorCosto = UtilObjeto.obtenerValorDefectoSiNulo(valorCosto, new CostoRecorridoDTO.Builder().build());

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

		public PreliquidacionDTO build() {

			return new PreliquidacionDTO(this);

		}

	}

}
