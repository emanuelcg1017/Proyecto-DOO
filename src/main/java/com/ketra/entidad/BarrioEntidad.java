package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class BarrioEntidad {

	private UUID id;
	private String nombre;
	private MunicipioEntidad municipio;

	private BarrioEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.municipio = builder.municipio;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public MunicipioEntidad getMunicipio() {
		return municipio;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private MunicipioEntidad municipio;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			municipio = new MunicipioEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder municipio(MunicipioEntidad municipio) {
			this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioEntidad.Builder().build());
			return this;
		}

		public BarrioEntidad build() {
			return new BarrioEntidad(this);
		}
	}
}
