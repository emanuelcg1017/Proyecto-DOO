package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaServicioEntidad {

	private UUID id;
	private EmpresaEntidad empresa;
	private ServicioEntidad servicio;

	private EmpresaServicioEntidad(Builder builder) {
		this.id = builder.id;
		this.empresa = builder.empresa;
		this.servicio = builder.servicio;
	}

	public UUID getId() {
		return id;
	}

	public EmpresaEntidad getEmpresa() {
		return empresa;
	}

	public ServicioEntidad getServicio() {
		return servicio;
	}

	public static class Builder {

		private UUID id;
		private EmpresaEntidad empresa;
		private ServicioEntidad servicio;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			empresa = new EmpresaEntidad.Builder().build();
			servicio = new ServicioEntidad.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder empresa(EmpresaEntidad empresa) {
			this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaEntidad.Builder().build());
			return this;
		}

		public Builder servicio(ServicioEntidad servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioEntidad.Builder().build());
			return this;
		}

		public EmpresaServicioEntidad build() {
			return new EmpresaServicioEntidad(this);
		}
	}
}
