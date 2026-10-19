package com.ketra.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ketra.dao.datos.entidad.CostoRecorridoDAO;
import com.ketra.dao.datos.entidad.FacturaDAO;
import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.negocio.fachada.impl.UtilidadFachadaImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.utilitarios.UtilUUID;

class UtilidadFachadaTests {

	private final UUID idServicio = UUID.randomUUID();

	private DAOFactory factoria;

	private UtilidadDAO utilidades;

	private UtilidadFachadaImpl fachada;

	@BeforeEach
	void preparar() {

		factoria = mock(DAOFactory.class);

		utilidades = mock(UtilidadDAO.class);

		var servicios = mock(ServicioDAO.class);

		var facturas = mock(FacturaDAO.class);

		var costos = mock(CostoRecorridoDAO.class);

		when(factoria.obtenerUtilidadDAO()).thenReturn(utilidades);

		when(factoria.obtenerServicioDAO()).thenReturn(servicios);

		when(factoria.obtenerFacturaDAO()).thenReturn(facturas);

		when(factoria.obtenerCostoRecorridoDAO()).thenReturn(costos);

		when(servicios.consultarPorId(idServicio)).thenReturn(new ServicioEntidad.Builder()
				.id(idServicio)
				.estado("Finalizado")
				.build());

		when(utilidades.consultarPorFiltro(any())).thenReturn(List.of());

		when(facturas.consultarTotalIngresosPorServicio(idServicio)).thenReturn(1425000.0);

		when(costos.consultarTotalCostosPorServicio(idServicio)).thenReturn(140100.0);

		fachada = new UtilidadFachadaImpl(factoria);

	}

	@Test
	void generacionConfirmaYCierraConLaMismaFactoria() {

		var resultado = fachada.generarUtilidad(idServicio);

		assertEquals(idServicio, resultado.getServicio().getId());

		assertEquals(1284900.0, resultado.getValorUtilidad());

		assertEquals(7, resultado.getId().version());

		verify(utilidades, never()).consultarPorId(any());

		var orden = inOrder(factoria, utilidades);

		orden.verify(factoria).iniciarTransaccion();

		orden.verify(utilidades).crear(any());

		orden.verify(factoria).confirmarTransaccion();

		orden.verify(factoria).cerrarConexion();

		verify(factoria, never()).cancelarTransaccion();

	}

	@Test
	void servicioInexistenteSeRechazaAntesDeGenerarUtilidad() {

		var servicios = factoria.obtenerServicioDAO();

		when(servicios.consultarPorId(idServicio)).thenReturn(new ServicioEntidad.Builder().build());

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.generarUtilidad(idServicio);

			}

		});

		assertEquals(CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_NO_EXISTE, resultado.getMensajeUsuario());

		verifyNoInteractions(utilidades);

		verify(factoria).cancelarTransaccion();

		verify(factoria, never()).confirmarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void utilidadExistenteSeRechazaSinGenerarOtroRegistro() {

		when(utilidades.consultarPorFiltro(any())).thenReturn(List.of(new UtilidadEntidad.Builder().build()));

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.generarUtilidad(idServicio);

			}

		});

		assertEquals(CatalogoMensajes.UtilidadNegocioImpl.UTILIDAD_YA_GENERADA, resultado.getMensajeUsuario());

		verify(utilidades, never()).crear(any());

		verify(utilidades, never()).consultarPorId(any());

		verify(factoria).cancelarTransaccion();

		verify(factoria, never()).confirmarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void falloDeEscrituraCancelaYCierraConservandoLaExcepcionDeKETRA() {

		var original = KETRADatosException.crear(CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR);

		doThrow(original).when(utilidades).crear(any());

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.generarUtilidad(idServicio);

			}

		});

		assertSame(original, resultado);

		verify(factoria).cancelarTransaccion();

		verify(factoria, never()).confirmarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void falloAlIniciarCierraSinCancelarUnaTransaccionNoIniciada() {

		doThrow(new IllegalStateException("fallo al iniciar")).when(factoria).iniciarTransaccion();

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				fachada.generarUtilidad(idServicio);

			}

		});

		assertEquals(CatalogoMensajes.UtilidadFachadaImpl.ERROR_GENERANDO_UTILIDAD, resultado.getMensajeUsuario());

		verify(factoria, never()).cancelarTransaccion();

		verify(factoria).cerrarConexion();

		verifyNoInteractions(utilidades);

	}

	@Test
	void consultaDevuelveElDTOYCierraSinIniciarTransaccion() {

		var utilidad = new UtilidadEntidad.Builder()
				.id(UUID.randomUUID())
				.servicio(new ServicioEntidad.Builder().id(idServicio).build())
				.valorIngresos(1425000.0)
				.valorCostos(140100.0)
				.valorUtilidad(1284900.0)
				.build();

		when(utilidades.consultarPorFiltro(any())).thenReturn(List.of(utilidad));

		var resultado = fachada.consultarUtilidadPorServicio(idServicio);

		assertEquals(utilidad.getId(), resultado.getId());

		assertEquals(idServicio, resultado.getServicio().getId());

		assertEquals(1284900.0, resultado.getValorUtilidad());

		verify(factoria, never()).iniciarTransaccion();

		verify(factoria).cerrarConexion();

	}

	@Test
	void consultaSinResultadosDevuelveDTOConValoresPorDefecto() {

		var resultado = fachada.consultarUtilidadPorServicio(idServicio);

		assertNotNull(resultado);

		assertEquals(UtilUUID.UUID_DEFECTO, resultado.getId());

		verify(factoria).cerrarConexion();

	}

}
