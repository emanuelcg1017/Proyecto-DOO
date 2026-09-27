package com.ketra.dominio;

import java.util.UUID;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DireccionDominio {
	private UUID id;
	private String nombre;
	private BarrioDominio barrio;
	private TipoDireccionDominio tipoDireccion;

	DireccionDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.barrio = builder.barrio;
		this.tipoDireccion = builder.tipoDireccion;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public BarrioDominio getBarrio() {
		return barrio;
	}

	public TipoDireccionDominio getTipoDireccion() {
		return tipoDireccion;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		private BarrioDominio barrio;
		private TipoDireccionDominio tipoDireccion;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			barrio = new BarrioDominio.Builder().build();
			tipoDireccion = new TipoDireccionDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}

		public Builder barrio(BarrioDominio barrio) {
			this.barrio = UtilObjeto.obtenerValorDefectoSiNulo(barrio, new BarrioDominio.Builder().build());
			return this;
		}

		public Builder tipoDireccion(TipoDireccionDominio tipoDireccion) {
			this.tipoDireccion = UtilObjeto.obtenerValorDefectoSiNulo(tipoDireccion, new TipoDireccionDominio.Builder().build());
			return this;
		}

		public DireccionDominio build() {
			return new DireccionDominio(this);
		}
	}
}
