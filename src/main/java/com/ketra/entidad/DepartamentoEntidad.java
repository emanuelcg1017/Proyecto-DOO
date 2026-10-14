package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

	private UUID id;
	private String nombre;
	private PaisEntidad pais;

	private DepartamentoEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.pais = builder.pais;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public PaisEntidad getPais() {
		return pais;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private PaisEntidad pais;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			pais = new PaisEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder pais(PaisEntidad pais) {
			this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisEntidad.Builder().build());
			return this;
		}

		public DepartamentoEntidad build() {
			return new DepartamentoEntidad(this);
		}
	}
}
