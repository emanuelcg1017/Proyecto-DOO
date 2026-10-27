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

		setId(UtilUUID.UUID_DEFECTO);

		setNumeroPedido(UtilTexto.VACIO);

		setFechaPedido(UtilFecha.FECHA_DEFECTO);

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

}
