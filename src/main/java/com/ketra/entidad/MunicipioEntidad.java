package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class MunicipioEntidad {

	private UUID id;
	private String nombre;
	private DepartamentoEntidad departamento;

	private MunicipioEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.departamento = builder.departamento;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DepartamentoEntidad getDepartamento() {
		return departamento;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private DepartamentoEntidad departamento;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			departamento = new DepartamentoEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder departamento(DepartamentoEntidad departamento) {
			this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento, new DepartamentoEntidad.Builder().build());
			return this;
		}

		public MunicipioEntidad build() {
			return new MunicipioEntidad(this);
		}
	}
}
