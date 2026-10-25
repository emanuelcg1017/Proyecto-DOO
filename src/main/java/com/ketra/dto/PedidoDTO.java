package com.ketra.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class PedidoDTO {

	private UUID id;

	private String numeroPedido;

	private LocalDate fechaPedido;

	public PedidoDTO() {

		this(new Builder());

	}

	private PedidoDTO(Builder builder) {

		this.id = builder.id;

		this.numeroPedido = builder.numeroPedido;

		this.fechaPedido = builder.fechaPedido;

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroPedido() {

		return numeroPedido;

	}

	public void setNumeroPedido(String numeroPedido) {

		this.numeroPedido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPedido);

	}

	public LocalDate getFechaPedido() {

		return fechaPedido;

	}

	public void setFechaPedido(LocalDate fechaPedido) {

		this.fechaPedido = UtilFecha.obtenerFechaDefecto(fechaPedido);

	}

	public static class Builder {

		private UUID id;

		private String numeroPedido;

		private LocalDate fechaPedido;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			numeroPedido = UtilTexto.VACIO;

			fechaPedido = UtilFecha.FECHA_DEFECTO;

		}

		public Builder id(UUID id) {

			this.id = UtilUUID.obtenerValorDefecto(id);

			return this;

		}

		public Builder numeroPedido(String numeroPedido) {

			this.numeroPedido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPedido);

			return this;

		}

		public Builder fechaPedido(LocalDate fechaPedido) {

			this.fechaPedido = UtilFecha.obtenerFechaDefecto(fechaPedido);

			return this;

		}

		public PedidoDTO build() {

			return new PedidoDTO(this);

		}

	}

}
