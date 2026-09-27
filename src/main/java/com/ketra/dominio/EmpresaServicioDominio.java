package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaServicioDominio {

	private UUID id;
	private EmpresaDominio empresa;
	private ServicioDominio servicio;

	EmpresaServicioDominio(Builder builder) {
		this.id = builder.id;
		this.empresa = builder.empresa;
		this.servicio = builder.servicio;
	}

	public UUID getId() {
		return id;
	}

	public EmpresaDominio getEmpresa() {
		return empresa;
	}

	public ServicioDominio getServicio() {
		return servicio;
	}

	public static class Builder {
		private UUID id;
		private EmpresaDominio empresa;
		private ServicioDominio servicio;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			empresa = new EmpresaDominio.Builder().build();
			servicio = new ServicioDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder empresa(EmpresaDominio empresa) {
			this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaDominio.Builder().build());
			return this;
		}

		public Builder servicio(ServicioDominio servicio) {
			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDominio.Builder().build());
			return this;
		}

		public EmpresaServicioDominio build() {
			return new EmpresaServicioDominio(this);
		}
	}
}
