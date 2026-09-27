package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class MunicipioDominio {

	private UUID id;
	private String nombre;
	private DepartamentoDominio departamento;
	

	MunicipioDominio(Builder builder) {
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

	public DepartamentoDominio getDepartamento() {
		return departamento;
	}
	
	public static class Builder{
		private UUID id;
		private String nombre;
		private DepartamentoDominio departamento;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			departamento = new DepartamentoDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}
		
		public Builder departamento(DepartamentoDominio departamento) {
			this.departamento = UtilObjeto.obtenerValorDefectoSiNulo(departamento, new DepartamentoDominio(null));
			return this;
		}
		
		public MunicipioDominio build() {
			return new MunicipioDominio(this);
		}
	}
}
