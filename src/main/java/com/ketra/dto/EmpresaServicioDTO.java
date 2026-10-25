package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class EmpresaServicioDTO {

	private UUID id;

	private EmpresaDTO empresa;

	private ServicioDTO servicio;

	public EmpresaServicioDTO() {

		this(new Builder());

	}

	private EmpresaServicioDTO(Builder builder) {

		this.id = builder.id;

		this.empresa = builder.empresa;

		this.servicio = builder.servicio;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public EmpresaDTO getEmpresa() {

		return empresa;

	}

	public void setEmpresa(EmpresaDTO empresa) {

		this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaDTO.Builder().build());

	}

	public ServicioDTO getServicio() {

		return servicio;

	}

	public void setServicio(ServicioDTO servicio) {

		this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

	}

	public static class Builder {

		private UUID id;

		private EmpresaDTO empresa;

		private ServicioDTO servicio;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			empresa = new EmpresaDTO.Builder().build();

			servicio = new ServicioDTO.Builder().build();

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder empresa(EmpresaDTO empresa) {

			this.empresa = UtilObjeto.obtenerValorDefectoSiNulo(empresa, new EmpresaDTO.Builder().build());

			return this;

		}

		public Builder servicio(ServicioDTO servicio) {

			this.servicio = UtilObjeto.obtenerValorDefectoSiNulo(servicio, new ServicioDTO.Builder().build());

			return this;

		}

		public EmpresaServicioDTO build() {

			return new EmpresaServicioDTO(this);

		}

	}

}
