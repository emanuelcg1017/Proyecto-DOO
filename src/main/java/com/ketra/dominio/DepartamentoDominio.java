package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;


public class DepartamentoDominio {

	private UUID id;
	private String nombre;
	private PaisDominio pais;
	

	DepartamentoDominio(Builder builder) {
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

	public PaisDominio getPais() {
		return pais;
	}
	
	public static class Builder{
		private UUID id;
		private String nombre;
		private PaisDominio pais;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			pais = new PaisDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}
		
		public Builder pais(PaisDominio pais) {
			this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisDominio(null));
			return this;
		}
		
		public DepartamentoDominio build() {
			return new DepartamentoDominio(this);
		}
	}

}
