package com.ketra.dto;

import java.util.UUID;

import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilObjeto;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class DetalleEntregaDTO {

	private UUID id;

	private String numeroDetalleEntrega;

	private PedidoDTO pedido;

	private EntregaDTO entrega;

	private CEDIDTO CEDIOrigen;

	private DireccionDTO direccionDestino;

	private Double distanciaKM;

	public DetalleEntregaDTO() {

		this(new Builder());

	}

	private DetalleEntregaDTO(Builder builder) {

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

	public void setId(UUID id) {

		this.id = UtilUUID.obtenerValorDefecto(id);

	}

	public String getNumeroDetalleEntrega() {

		return numeroDetalleEntrega;

	}

	public void setNumeroDetalleEntrega(String numeroDetalleEntrega) {

		this.numeroDetalleEntrega = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroDetalleEntrega);

	}

	public PedidoDTO getPedido() {

		return pedido;

	}

	public void setPedido(PedidoDTO pedido) {

		this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO.Builder().build());

	}

	public EntregaDTO getEntrega() {

		return entrega;

	}

	public void setEntrega(EntregaDTO entrega) {

		this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

	}

	public CEDIDTO getCEDIOrigen() {

		return CEDIOrigen;

	}

	public void setCEDIOrigen(CEDIDTO CEDIOrigen) {

		this.CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(CEDIOrigen, new CEDIDTO.Builder().build());

	}

	public DireccionDTO getDireccionDestino() {

		return direccionDestino;

	}

	public void setDireccionDestino(DireccionDTO direccionDestino) {

		this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionDTO.Builder().build());

	}

	public Double getDistanciaKM() {

		return distanciaKM;

	}

	public void setDistanciaKM(Double distanciaKM) {

		this.distanciaKM = UtilNumero.obtenerValorDefecto(distanciaKM, UtilNumero.CERO_DECIMAL);

	}

	public static class Builder {

		private UUID id;

		private String numeroDetalleEntrega;

		private PedidoDTO pedido;

		private EntregaDTO entrega;

		private CEDIDTO CEDIOrigen;

		private DireccionDTO direccionDestino;

		private Double distanciaKM;

		public Builder() {

			id = UtilUUID.UUID_DEFECTO;

			numeroDetalleEntrega = UtilTexto.VACIO;

			pedido = new PedidoDTO.Builder().build();

			entrega = new EntregaDTO.Builder().build();

			CEDIOrigen = new CEDIDTO.Builder().build();

			direccionDestino = new DireccionDTO.Builder().build();

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

		public Builder pedido(PedidoDTO pedido) {

			this.pedido = UtilObjeto.obtenerValorDefectoSiNulo(pedido, new PedidoDTO.Builder().build());

			return this;

		}

		public Builder entrega(EntregaDTO entrega) {

			this.entrega = UtilObjeto.obtenerValorDefectoSiNulo(entrega, new EntregaDTO.Builder().build());

			return this;

		}

		public Builder CEDIOrigen(CEDIDTO CEDIOrigen) {

			this.CEDIOrigen = UtilObjeto.obtenerValorDefectoSiNulo(CEDIOrigen, new CEDIDTO.Builder().build());

			return this;

		}

		public Builder direccionDestino(DireccionDTO direccionDestino) {

			this.direccionDestino = UtilObjeto.obtenerValorDefectoSiNulo(direccionDestino, new DireccionDTO.Builder().build());

			return this;

		}

		public Builder distanciaKM(Double distanciaKM) {

			this.distanciaKM = UtilNumero.obtenerValorDefecto(distanciaKM, UtilNumero.CERO_DECIMAL);

			return this;

		}

		public DetalleEntregaDTO build() {

			return new DetalleEntregaDTO(this);

		}

	}

}
