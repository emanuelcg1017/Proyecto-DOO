package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class BarrioDTO {

	private UUID id;

	private String nombre;

	private MunicipioDTO municipio;

	public BarrioDTO() {

		this(new Builder());

	}

	private BarrioDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.municipio = builder.municipio;

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

	public MunicipioDTO getMunicipio() {

		return municipio;

	}

	public void setMunicipio(MunicipioDTO municipio) {

		this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private MunicipioDTO municipio;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			municipio = new MunicipioDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder municipio(MunicipioDTO municipio) {

			this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioDTO.Builder().build());

			return this;

		}

		public BarrioDTO build() {

			return new BarrioDTO(this);

		}

	}

}
