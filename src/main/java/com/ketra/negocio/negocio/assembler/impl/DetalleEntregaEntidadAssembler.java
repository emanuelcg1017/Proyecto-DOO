package com.ketra.negocio.negocio.assembler.impl;

import com.ketra.dominio.BarrioDominio;
import com.ketra.dominio.CEDIDominio;
import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.dominio.DireccionDominio;
import com.ketra.dominio.PedidoDominio;
import com.ketra.dominio.TipoDireccionDominio;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.negocio.negocio.assembler.EntidadAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class DetalleEntregaEntidadAssembler implements EntidadAssembler<DetalleEntregaDominio, DetalleEntregaEntidad> {

	private static final DetalleEntregaEntidadAssembler instancia = new DetalleEntregaEntidadAssembler();

	private DetalleEntregaEntidadAssembler() {

	}

	public static DetalleEntregaEntidadAssembler getInstance() {

		return instancia;

	}

	@Override
	public DetalleEntregaEntidad convertirAEntidad(DetalleEntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new DetalleEntregaDominio.Builder().build());

		var pedido = new PedidoEntidad.Builder()
				.id(datos.getPedido().getId())
				.numeroPedido(datos.getPedido().getNumeroPedido())
				.fechaPedido(datos.getPedido().getFechaPedido())
				.build();

		var cediOrigen = new CEDIEntidad.Builder()
				.id(datos.getCEDIOrigen().getId())
				.nombre(datos.getCEDIOrigen().getNombre())
				.direccion(new DireccionEntidad.Builder().id(datos.getCEDIOrigen().getDireccion().getId()).build())
				.build();

		var barrio = new BarrioEntidad.Builder()
				.id(datos.getDireccionDestino().getBarrio().getId())
				.build();

		var tipoDireccion = new TipoDireccionEntidad.Builder()
				.id(datos.getDireccionDestino().getTipoDireccion().getId())
				.build();

		var direccionDestino = new DireccionEntidad.Builder()
				.id(datos.getDireccionDestino().getId())
				.nombre(datos.getDireccionDestino().getNombre())
				.barrio(barrio)
				.direccion(tipoDireccion)
				.build();

		return new DetalleEntregaEntidad.Builder()
				.id(datos.getId())
				.numeroDetalleEntrega(datos.getNumeroDetalleEntrega())
				.pedido(pedido)
				.entrega(EntregaEntidadAssembler.getInstance().convertirAEntidad(datos.getEntrega()))
				.CEDIOrigen(cediOrigen)
				.direccionDestino(direccionDestino)
				.distanciaKM(datos.getDistanciaKM())
				.build();

	}

	@Override
	public DetalleEntregaDominio convertirADominio(DetalleEntregaEntidad entidad) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new DetalleEntregaEntidad.Builder().build());

		var pedido = new PedidoDominio.Builder()
				.id(datos.getPedido().getId())
				.numeroPedido(datos.getPedido().getNumeroPedido())
				.fechaPedido(datos.getPedido().getFechaPedido())
				.build();

		var cediOrigen = new CEDIDominio.Builder()
				.id(datos.getCEDIOrigen().getId())
				.nombre(datos.getCEDIOrigen().getNombre())
				.direccion(new DireccionDominio.Builder().id(datos.getCEDIOrigen().getDireccion().getId()).build())
				.build();

		var barrio = new BarrioDominio.Builder()
				.id(datos.getDireccionDestino().getBarrio().getId())
				.build();

		var tipoDireccion = new TipoDireccionDominio.Builder()
				.id(datos.getDireccionDestino().getDireccion().getId())
				.build();

		var direccionDestino = new DireccionDominio.Builder()
				.id(datos.getDireccionDestino().getId())
				.nombre(datos.getDireccionDestino().getNombre())
				.barrio(barrio)
				.tipoDireccion(tipoDireccion)
				.build();

		return new DetalleEntregaDominio.Builder()
				.id(datos.getId())
				.numeroDetalleEntrega(datos.getNumeroDetalleEntrega())
				.pedido(pedido)
				.entrega(EntregaEntidadAssembler.getInstance().convertirADominio(datos.getEntrega()))
				.CEDIOrigen(cediOrigen)
				.direccionDestino(direccionDestino)
				.distanciaKM(datos.getDistanciaKM())
				.build();

	}

}
