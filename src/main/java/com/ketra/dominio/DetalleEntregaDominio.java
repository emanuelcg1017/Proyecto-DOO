package com.ketra.dominio;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetalleEntregaDominio {


	private UUID id;
	private String numeroDetalleEntrega;
	private PedidoDominio pedido;
	private EntregaDominio entrega;
	private CEDIDominio CEDIOrigen;
	private DireccionDominio direccionDestino;
	private Double distanciaKM;

	DetalleEntregaDominio(Builder builder) {
		this.id = builder.id;
		this.numeroDetalleEntrega = builder.numeroDetalleEntrega;
		this.pedido = builder.pedido;
		this.entrega = builder.entrega;
		this.CEDIOrigen = builder.CEDIOrigen;
		this.direccionDestino = builder.direccionDestino;
		this.distanciaKM = builder.distanciaKM;
	}

	public UUID getId() {
		return id;
	}

	public String getNumeroDetalleEntrega() {
		return numeroDetalleEntrega;
	}

	public PedidoDominio getPedido() {
		return pedido;
	}

	public EntregaDominio getEntrega() {
		return entrega;
	}

	public CEDIDominio getCEDIOrigen() {
		return CEDIOrigen;
	}

	public DireccionDominio getDireccionDestino() {
		return direccionDestino;
	}

	public Double getDistanciaKM() {
		return distanciaKM;
	}

	public static class Builder {

		private UUID id;
		private String numeroDetalleEntrega;
		private PedidoDominio pedido;
		private EntregaDominio entrega;
		private CEDIDominio CEDIOrigen;
		private DireccionDominio direccionDestino;
		private Double distanciaKM;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroDetalleEntrega = UtilTexto.VACIO;
			pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDominio.Builder().build());
			entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDominio.Builder().build());
			CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(CEDIOrigen, new CEDIDominio.Builder().build());
			direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionDominio.Builder().build());
			distanciaKM = 0.0;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroDetalleEntrega(String numeroDetalleEntrega) {
			this.numeroDetalleEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroDetalleEntrega);
			return this;
		}

		public Builder pedido(PedidoDominio pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDominio.Builder().build());
			return this;
		}

		public Builder entrega(EntregaDominio entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDominio.Builder().build());
			return this;
		}

		public Builder CEDIOrigen(CEDIDominio CEDIOrigen) {
			this.CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(CEDIOrigen, new CEDIDominio.Builder().build());
			return this;
		}

		public Builder direccionDestino(DireccionDominio direccionDestino) {
			this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionDominio.Builder().build());
			return this;
		}

		public Builder distanciaKM(Double distanciaKM) {
			this.distanciaKM = distanciaKM;
			return this;
		}

		public DetalleEntregaDominio build() {
			return new DetalleEntregaDominio(this);
		}
	}
}
