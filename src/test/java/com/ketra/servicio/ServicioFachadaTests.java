package com.ketra.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ketra.dao.datos.entidad.*;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dto.ServicioDTO;
import com.ketra.entidad.*;
import com.ketra.negocio.fachada.impl.ServicioFachadaImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.excepciones.KETRATransversalException;

class ServicioFachadaTests {

	private final UUID id = UUID.randomUUID();

	private DAOFactory factoria;

	private ServicioDAO servicios;

	private UtilidadDAO utilidades;

	private ServicioFachadaImpl fachada;

	@BeforeEach
	void preparar() {

		factoria = mock(DAOFactory.class);

		servicios = mock(ServicioDAO.class);

		utilidades = mock(UtilidadDAO.class);

		var facturas = mock(FacturaDAO.class);

		var costos = mock(CostoRecorridoDAO.class);

		when(factoria.obtenerServicioDAO()).thenReturn(servicios);

		when(factoria.obtenerUtilidadDAO()).thenReturn(utilidades);

		when(factoria.obtenerFacturaDAO()).thenReturn(facturas);

		when(factoria.obtenerCostoRecorridoDAO()).thenReturn(costos);

		when(servicios.consultarPorId(id)).thenReturn(registro("En ejecución"), registro("Finalizado"));

		when(utilidades.consultarPorFiltro(any())).thenReturn(List.of());

		when(facturas.consultarTotalIngresosPorServicio(id)).thenReturn(1425000.0);

		when(costos.consultarTotalCostosPorServicio(id)).thenReturn(140100.0);

		var servicioEntregas = mock(ServicioEntregaDAO.class);

		when(factoria.obtenerServicioEntregaDAO()).thenReturn(servicioEntregas);

		when(servicioEntregas.consultarPorFiltro(any())).thenReturn(List.of());

		fachada = new ServicioFachadaImpl(factoria);

	}

	private ServicioEntidad registro(String estado) {

		return new ServicioEntidad.Builder().id(id).numeroServicio("SRV-001").fechaServicio(LocalDate.of(2026, 8, 1)).estado(estado).build();

	}

	@Test
	void finalizarActualizaYRegistraUtilidadEnUnaSolaTransaccion() {

		var respuesta = fachada.actualizarEstado(id, new ServicioDTO.Builder().estado("Finalizado").build());

		assertEquals("Finalizado", respuesta.getEstado());

		var orden = inOrder(factoria, servicios, utilidades);

		orden.verify(factoria).iniciarTransaccion();

		orden.verify(servicios).consultarPorId(id);

		orden.verify(servicios).actualizar(eq(id), any());

		orden.verify(servicios).consultarPorId(id);

		orden.verify(utilidades).crear(any());

		orden.verify(factoria).confirmarTransaccion();

		orden.verify(factoria).cerrarConexion();

		verify(factoria, never()).cancelarTransaccion();

	}

	@Test
	void errorAlRegistrarUtilidadRevierteTambienElEstado() {

		doThrow(new IllegalStateException("fallo de escritura")).when(utilidades).crear(any());

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				fachada.actualizarEstado(id, new ServicioDTO.Builder().estado("Finalizado").build());

			}

		});

		verify(servicios).actualizar(eq(id), any());

		verify(factoria).cancelarTransaccion();

		verify(factoria, never()).confirmarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void politicaInvalidaRevierteSinEscribir() {

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				fachada.actualizarEstado(id, new ServicioDTO.Builder().estado("Cancelado").build());

			}

		});

		verify(factoria).cancelarTransaccion();

		verify(servicios, never()).actualizar(any(), any());

		verify(factoria).cerrarConexion();

	}

	@Test
	void consultasNoInicianTransaccionesDeEscritura() {

		assertEquals(id, fachada.consultarPorId(id).getId());

		verify(factoria, never()).iniciarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void falloAlIniciarTransaccionCierraSinIntentarCancelar() {

		var original = KETRATransversalException.crear(CatalogoMensajes.UtilSQL.USUARIO_ERROR_INICIANDO_TRANSACCION_SQL);

		doThrow(original).when(factoria).iniciarTransaccion();

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.actualizarEstado(id, new ServicioDTO.Builder().estado("Finalizado").build());

			}

		});

		assertSame(original, resultado);

		verify(factoria, never()).cancelarTransaccion();

		verify(factoria).cerrarConexion();

		verifyNoInteractions(servicios, utilidades);

	}

	@Test
	void falloAlConfirmarCancelaYCierraLaConexion() {

		doThrow(new IllegalStateException("fallo de confirmación")).when(factoria).confirmarTransaccion();

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.actualizarEstado(id, new ServicioDTO.Builder().estado("Finalizado").build());

			}

		});

		var orden = inOrder(factoria);

		orden.verify(factoria).confirmarTransaccion();

		orden.verify(factoria).cancelarTransaccion();

		orden.verify(factoria).cerrarConexion();

	}

	@Test
	void dtoNuloSeRechazaConMensajeDeValidacionSinConsultarServicios() {

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.actualizarEstado(id, null);

			}

		});

		assertEquals(CatalogoMensajes.ServicioNegocioImpl.DATOS_ESTADO_INVALIDOS, resultado.getMensajeUsuario());

		verifyNoInteractions(servicios);

		verify(factoria).cancelarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void errorInesperadoDeConsultaSeEnvuelveYCierraSinTransaccion() {

		when(servicios.consultarPorId(id)).thenThrow(new IllegalStateException("fallo de lectura"));

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.consultarPorId(id);

			}

		});

		assertEquals(CatalogoMensajes.ServicioFachadaImpl.ERROR_CONSULTANDO, resultado.getMensajeUsuario());

		verify(factoria, never()).iniciarTransaccion();

		verify(factoria).cerrarConexion();

	}

}
