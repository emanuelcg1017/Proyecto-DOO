package com.ketra.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import com.ketra.dominio.BarrioDominio;
import com.ketra.dominio.CEDIDominio;
import com.ketra.dominio.DetalleEntregaDominio;
import com.ketra.dominio.DireccionDominio;
import com.ketra.dominio.PedidoDominio;
import com.ketra.dominio.TipoDireccionDominio;
import com.ketra.dto.BarrioDTO;
import com.ketra.dto.CEDIDTO;
import com.ketra.dto.DetalleEntregaDTO;
import com.ketra.dto.DireccionDTO;
import com.ketra.dto.PedidoDTO;
import com.ketra.dto.TipoDireccionDTO;
import com.ketra.negocio.fachada.assembler.DTOAssembler;
import com.ketra.transversal.utilitarios.UtilObjeto;

public class DetalleEntregaDTOAssembler implements DTOAssembler<DetalleEntregaDominio, DetalleEntregaDTO> {

	private static final DetalleEntregaDTOAssembler instancia = new DetalleEntregaDTOAssembler();

	private DetalleEntregaDTOAssembler() {

	}

	public static DetalleEntregaDTOAssembler getInstance() {

		return instancia;

	}

	@Override
	public DetalleEntregaDTO convertirADTO(DetalleEntregaDominio dominio) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new DetalleEntregaDominio.Builder().build());

		var pedido = new PedidoDTO();

		pedido.setId(datos.getPedido().getId());

		pedido.setNumeroPedido(datos.getPedido().getNumeroPedido());

		pedido.setFechaPedido(datos.getPedido().getFechaPedido());

		var direccionCedi = new DireccionDTO();

		direccionCedi.setId(datos.getCEDIOrigen().getDireccion().getId());

		var cediOrigen = new CEDIDTO();

		cediOrigen.setId(datos.getCEDIOrigen().getId());

		cediOrigen.setNombre(datos.getCEDIOrigen().getNombre());

		cediOrigen.setDireccion(direccionCedi);

		var barrio = new BarrioDTO();

		barrio.setId(datos.getDireccionDestino().getBarrio().getId());

		var tipoDireccion = new TipoDireccionDTO();

		tipoDireccion.setId(datos.getDireccionDestino().getTipoDireccion().getId());

		var direccionDestino = new DireccionDTO();

		direccionDestino.setId(datos.getDireccionDestino().getId());

		direccionDestino.setNombre(datos.getDireccionDestino().getNombre());

		direccionDestino.setBarrio(barrio);

		direccionDestino.setDireccion(tipoDireccion);

		var resultado = new DetalleEntregaDTO();

		resultado.setId(datos.getId());

		resultado.setNumeroDetalleEntrega(datos.getNumeroDetalleEntrega());

		resultado.setPedido(pedido);

		resultado.setEntrega(EntregaDTOAssembler.getInstance().convertirADTO(datos.getEntrega()));

		resultado.setCEDIOrigen(cediOrigen);

		resultado.setDireccionDestino(direccionDestino);

		resultado.setDistanciaKM(datos.getDistanciaKM());

		return resultado;

	}

	@Override
	public DetalleEntregaDominio convertirADominio(DetalleEntregaDTO dto) {

		var datos = UtilObjeto.obtenerValorDefectoSiNulo(dto, new DetalleEntregaDTO());

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
				.entrega(EntregaDTOAssembler.getInstance().convertirADominio(datos.getEntrega()))
				.CEDIOrigen(cediOrigen)
				.direccionDestino(direccionDestino)
				.distanciaKM(datos.getDistanciaKM())
				.build();

	}

	public List<DetalleEntregaDTO> convertirADTO(List<DetalleEntregaDominio> dominios) {

		final List<DetalleEntregaDTO> resultados = new ArrayList<>();

		for (DetalleEntregaDominio dominio : dominios) {

			resultados.add(convertirADTO(dominio));

		}

		return resultados;

	}

}
