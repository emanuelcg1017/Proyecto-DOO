package com.ketra.entidad;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetalleEntregaEntidad {

	private UUID id;
	private String numeroDetalleEntrega;
	private PedidoEntidad pedido;
	private EntregaEntidad entrega;
	private CEDIEntidad CEDIOrigen;
	private DireccionEntidad direccionDestino;
	private Double distanciaKM;

	private DetalleEntregaEntidad(Builder builder) {
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

	public PedidoEntidad getPedido() {
		return pedido;
	}

	public EntregaEntidad getEntrega() {
		return entrega;
	}

	public CEDIEntidad getCEDIOrigen() {
		return CEDIOrigen;
	}

	public DireccionEntidad getDireccionDestino() {
		return direccionDestino;
	}

	public Double getDistanciaKM() {
		return distanciaKM;
	}

	public static class Builder {

		private UUID id;
		private String numeroDetalleEntrega;
		private PedidoEntidad pedido;
		private EntregaEntidad entrega;
		private CEDIEntidad CEDIOrigen;
		private DireccionEntidad direccionDestino;
		private Double distanciaKM;

		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			numeroDetalleEntrega = UtilTexto.VACIO;
			pedido = new PedidoEntidad.Builder().build();
			entrega = new EntregaEntidad.Builder().build();
			CEDIOrigen = new CEDIEntidad.Builder().build();
			direccionDestino = new DireccionEntidad.Builder().build();
			distanciaKM = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder numeroDetalleEntrega(String numeroDetalleEntrega) {
			this.numeroDetalleEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroDetalleEntrega);
			return this;
		}

		public Builder pedido(PedidoEntidad pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoEntidad.Builder().build());
			return this;
		}

		public Builder entrega(EntregaEntidad entrega) {
			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaEntidad.Builder().build());
			return this;
		}

		public Builder CEDIOrigen(CEDIEntidad CEDIOrigen) {
			this.CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(CEDIOrigen, new CEDIEntidad.Builder().build());
			return this;
		}

		public Builder direccionDestino(DireccionEntidad direccionDestino) {
			this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionEntidad.Builder().build());
			return this;
		}

		public Builder distanciaKM(Double distanciaKM) {
			this.distanciaKM = UtilNumero.obtenerValorDefecto(distanciaKM, UtilNumero.CERO_DECIMAL);
			return this;
		}

		public DetalleEntregaEntidad build() {
			return new DetalleEntregaEntidad(this);
		}
	}
}
