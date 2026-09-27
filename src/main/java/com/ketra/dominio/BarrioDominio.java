package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class BarrioDominio {

	private UUID id;
	private String nombre;
	private MunicipioDominio municipio;
	

	BarrioDominio(Builder builder) {
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

	public MunicipioDominio getMunicipio() {
		return municipio;
	}
	
	public static class Builder{
		private UUID id;
		private String nombre;
		private MunicipioDominio municipio;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			municipio = new MunicipioDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}
		
		public Builder municipio(MunicipioDominio municipio) {
			this.municipio = UtilObjeto.obtenerValorDefectoSiNulo(municipio, new MunicipioDominio(null));
			return this;
		}
		
		public BarrioDominio build() {
			return new BarrioDominio(this);
		}
	}
}
