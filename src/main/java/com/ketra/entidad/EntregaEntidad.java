package com.ketra.entidad;

import java.util.UUID;
import java.time.LocalDate;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EntregaEntidad {

	private UUID id;
	private String codigoEntrega;
	private LocalDate fechaEntrega;
	private String estadoEntrega;
	private PersonaEntidad persona;

	private EntregaEntidad(Builder builder) {
		this.id = builder.id;
		this.codigoEntrega = builder.codigoEntrega;
		this.fechaEntrega = builder.fechaEntrega;
		this.estadoEntrega = builder.estadoEntrega;
		this.persona = builder.persona;
	}

	public UUID getId() {
		return id;
	}

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public String getEstadoEntrega() {
		return estadoEntrega;
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public static class Builder {

		private UUID id;
		private String codigoEntrega;
		private LocalDate fechaEntrega;
		private String estadoEntrega;
		private PersonaEntidad persona;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			codigoEntrega = UtilTexto.VACIO;
			fechaEntrega = UtilFecha.FECHA_DEFECTO;
			estadoEntrega = UtilTexto.VACIO;
			persona = new PersonaEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder codigoEntrega(String codigoEntrega) {
			this.codigoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(codigoEntrega);
			return this;
		}

		public Builder fechaEntrega(LocalDate fechaEntrega) {
			this.fechaEntrega = UtilFecha.obtenerFechaDefecto(fechaEntrega);
			return this;
		}

		public Builder estadoEntrega(String estadoEntrega) {
			this.estadoEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(estadoEntrega);
			return this;
		}

		public Builder persona(PersonaEntidad persona) {
			this.persona = UtilObjeto.obtenerValorDefectoSiNulo(persona, new PersonaEntidad.Builder().build());
			return this;
		}

		public EntregaEntidad build() {
			return new EntregaEntidad(this);
		}
	}
}
