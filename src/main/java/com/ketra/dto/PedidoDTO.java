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
		setId(UtilUUID.obtenerValorDefecto(id));
		setNumeroPedido(UtilTexto.VACIO);
		setFechaPedido(UtilFecha.FECHA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	private void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(numeroPedido);
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	private void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = UtilFecha.obtenerFechaDefecto(fechaPedido);
	}

}
