package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DepartamentoDTO {

	private UUID id;

	private String nombre;

	private PaisDTO pais;

	public DepartamentoDTO() {

		this(new Builder());

	}

	private DepartamentoDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.pais = builder.pais;

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

	public PaisDTO getPais() {

		return pais;

	}

	public void setPais(PaisDTO pais) {

		this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private PaisDTO pais;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			pais = new PaisDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder pais(PaisDTO pais) {

			this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisDTO.Builder().build());

			return this;

		}

		public DepartamentoDTO build() {

			return new DepartamentoDTO(this);

		}

	}

}
