package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class MunicipioDTO {

	private UUID id;

	private String nombre;

	private DepartamentoDTO departamento;

	public MunicipioDTO() {

		this(new Builder());

	}

	private MunicipioDTO(Builder builder) {

		this.id = builder.id;

		this.nombre = builder.nombre;

		this.departamento = builder.departamento;

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

	public DepartamentoDTO getDepartamento() {

		return departamento;

	}

	public void setDepartamento(DepartamentoDTO departamento) {

		this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento, new DepartamentoDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private String nombre;

		private DepartamentoDTO departamento;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			nombre = UtilTexto.VACIO;

			departamento = new DepartamentoDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder nombre(String nombre) {

			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);

			return this;

		}

		public Builder departamento(DepartamentoDTO departamento) {

			this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento, new DepartamentoDTO.Builder().build());

			return this;

		}

		public MunicipioDTO build() {

			return new MunicipioDTO(this);

		}

	}

}
