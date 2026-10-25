package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DireccionDTO {

	private UUID id;

	private String nombre;

	private BarrioDTO barrio;

	private TipoDireccionDTO direccion;

	public DireccionDTO() {

		this(new Builder());

	}

	private DireccionDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.barrio = builder.barrio;

		this.direccion = builder.direccion;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

	}

	public BarrioDTO getBarrio() {

		return barrio;

	}

	public void setBarrio(BarrioDTO barrio) {

		this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioDTO.Builder().build());

	}

	public TipoDireccionDTO getDireccion() {

		return direccion;

	}

	public void setDireccion(TipoDireccionDTO direccion) {

		this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new TipoDireccionDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private BarrioDTO barrio;

		private TipoDireccionDTO direccion;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			barrio = new BarrioDTO.Builder().build();

			direccion = new TipoDireccionDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder barrio(BarrioDTO barrio) {

			this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioDTO.Builder().build());

			return this;

		}

		public Builder direccion(TipoDireccionDTO direccion) {

			this.direccion = UtilObjeto.obtenerValorDefectoSiNulo(direccion, new TipoDireccionDTO.Builder().build());

			return this;

		}

		public DireccionDTO build() {

			return new DireccionDTO(this);

		}

	}

}
