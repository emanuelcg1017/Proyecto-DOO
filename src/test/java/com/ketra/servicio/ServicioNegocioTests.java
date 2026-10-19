package com.ketra.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.ketra.dao.datos.entidad.*;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dominio.ServicioDominio;
import com.ketra.entidad.*;
import com.ketra.negocio.negocio.impl.ServicioNegocioImpl;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilUUID;

class ServicioNegocioTests {

	private final UUID id = UUID.fromString("24b5feac-721b-40a9-9c8c-945fbc2714da");

	private DAOFactory factoria;

	private ServicioDAO servicios;

	private UtilidadDAO utilidades;

	private FacturaDAO facturas;

	private CostoRecorridoDAO costos;

	private ServicioNegocioImpl negocio;

	private ServicioEntregaDAO servicioEntregas;

	@BeforeEach
	void preparar() {

		factoria = mock(DAOFactory.class);

		servicios = mock(ServicioDAO.class);

		utilidades = mock(UtilidadDAO.class);

		facturas = mock(FacturaDAO.class);

		costos = mock(CostoRecorridoDAO.class);

		when(factoria.obtenerServicioDAO()).thenReturn(servicios);

		when(factoria.obtenerUtilidadDAO()).thenReturn(utilidades);

		when(factoria.obtenerFacturaDAO()).thenReturn(facturas);

		when(factoria.obtenerCostoRecorridoDAO()).thenReturn(costos);

		when(utilidades.consultarPorFiltro(any())).thenReturn(List.of());

		when(facturas.consultarTotalIngresosPorServicio(id)).thenReturn(1425000.0);

		when(costos.consultarTotalCostosPorServicio(id)).thenReturn(140100.0);

		servicioEntregas = mock(ServicioEntregaDAO.class);

		when(factoria.obtenerServicioEntregaDAO()).thenReturn(servicioEntregas);

		when(servicioEntregas.consultarPorFiltro(any())).thenReturn(List.of());

		negocio = new ServicioNegocioImpl(factoria);

	}

	private ServicioEntidad registro(String estado) {

		return new ServicioEntidad.Builder().id(id).numeroServicio("SRV-001")
			.fechaServicio(LocalDate.of(2026, 8, 1)).estado(estado).build();

	}

	static Stream<Arguments> transiciones() {

		java.util.List<Arguments> casos = new java.util.ArrayList<>();

		String[] estados = {

			"Registrado", "En ejecución", "Finalizado", "Cancelado"

		};

		for (String actual : estados) {

			for (String nuevo : estados) {

				boolean permitido = actual.equals("Registrado") && (nuevo.equals("En ejecución") || nuevo.equals("Cancelado"))
				|| actual.equals("En ejecución") && nuevo.equals("Finalizado");

				casos.add(Arguments.of(actual, nuevo, permitido));

			}

		}

		return casos.stream();

	}

	@ParameterizedTest @MethodSource("transiciones")
	void compruebaLasDieciseisTransiciones(String actual, String nuevo, boolean permitido) {

		when(servicios.consultarPorId(id)).thenReturn(registro(actual), registro("Finalizado"));

		var solicitud = new ServicioDominio.Builder().estado(nuevo).build();

		if (!permitido) {

			assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() throws Throwable {

					negocio.actualizarEstado(id, solicitud);

				}

			});

			verify(servicios, never()).actualizar(any(), any());

			verify(utilidades, never()).crear(any());

			return;

		}

		var resultado = negocio.actualizarEstado(id, solicitud);

		assertEquals(nuevo, resultado.getEstado());

		assertEquals("SRV-001", resultado.getNumeroServicio());

		assertEquals(LocalDate.of(2026, 8, 1), resultado.getFechaServicio());

		var servicioCapturado = org.mockito.ArgumentCaptor.forClass(ServicioEntidad.class);

		verify(servicios).actualizar(eq(id), servicioCapturado.capture());

		assertEquals(nuevo, servicioCapturado.getValue().getEstado());

		if (nuevo.equals("Finalizado")) {

			var utilidadCapturada = org.mockito.ArgumentCaptor.forClass(UtilidadEntidad.class);

			verify(utilidades).crear(utilidadCapturada.capture());

			assertEquals(1284900.0, utilidadCapturada.getValue().getValorUtilidad());

			assertEquals(id, utilidadCapturada.getValue().getServicio().getId());

		} else verify(utilidades, never()).crear(any());

		verify(factoria, never()).iniciarTransaccion();

		verify(factoria, never()).cerrarConexion();

	}

	@Test
	void ignoraCambiosDeNumeroYFechaEnLaSolicitud() {

		when(servicios.consultarPorId(id)).thenReturn(registro("Registrado"));

		var solicitud = new ServicioDominio.Builder().numeroServicio("ALTERADO").fechaServicio(LocalDate.of(2030, 1, 1)).estado("En ejecución").build();

		var respuesta = negocio.actualizarEstado(id, solicitud);

		assertEquals("SRV-001", respuesta.getNumeroServicio());

		assertEquals(LocalDate.of(2026, 8, 1), respuesta.getFechaServicio());

	}

	@Test
	void validaDatosAntesDeConsultarYRechazaIdDiferente() {

		for (String estado : List.of("", " ", "Inventado", "x".repeat(16))) {

			assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() throws Throwable {

					negocio.actualizarEstado(id, new ServicioDominio.Builder().estado(estado).build());

				}

			});

		}
		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				negocio.actualizarEstado(null, new ServicioDominio.Builder().estado("Finalizado").build());

			}

		});

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				negocio.actualizarEstado(id, null);

			}

		});

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				negocio.actualizarEstado(id, new ServicioDominio.Builder().id(UUID.randomUUID()).estado("Finalizado").build());

			}

		});

		verifyNoInteractions(servicios);

	}

	@Test
	void rechazaServicioInexistente() {

		when(servicios.consultarPorId(id)).thenReturn(new ServicioEntidad.Builder().build());

		assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				negocio.actualizarEstado(id, new ServicioDominio.Builder().estado("En ejecución").build());

			}

		});

		verify(servicios, never()).actualizar(any(), any());

	}

	@Test
	void permiteConsultarTodosPorIdYPorEstado() {

		when(servicios.consultarPorId(id)).thenReturn(registro("Registrado"));

		when(servicios.consultarPorFiltro(any())).thenReturn(List.of(registro("Registrado")));

		assertEquals(id, negocio.consultarPorId(id).getId());

		assertEquals(1, negocio.consultarTodos().size());

		assertEquals(1, negocio.consultarPorFiltro(new ServicioDominio.Builder().estado("Registrado").build()).size());

		var filtros = org.mockito.ArgumentCaptor.forClass(ServicioEntidad.class);

		verify(servicios, times(2)).consultarPorFiltro(filtros.capture());

		assertEquals("Registrado", filtros.getValue().getEstado());

	}

	@Test
	void reglasDeFiltroRechazanNumeroLargoYEstadoInventadoAntesDelDAO() {

		var filtros = List.of(
				new ServicioDominio.Builder().numeroServicio("X".repeat(31)).build(),
				new ServicioDominio.Builder().estado("Inventado").build());

		for (ServicioDominio filtro : filtros) {

			assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() {

					negocio.consultarPorFiltro(filtro);

				}

			});

		}

		verifyNoInteractions(servicios);

	}

	@Test
	void filtroOpcionalAceptaNuloYNumeroDeTreintaCaracteres() {

		negocio.consultarPorFiltro(null);

		negocio.consultarPorFiltro(new ServicioDominio.Builder().numeroServicio("X".repeat(30)).build());

		var filtros = org.mockito.ArgumentCaptor.forClass(ServicioEntidad.class);

		verify(servicios, times(2)).consultarPorFiltro(filtros.capture());

		assertEquals("", filtros.getAllValues().get(0).getNumeroServicio());

		assertEquals(30, filtros.getAllValues().get(1).getNumeroServicio().length());

	}

	@Test
	void solicitudNulaSeRechazaEnLaReglaDeDatos() {

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				negocio.actualizarEstado(id, null);

			}

		});

		assertEquals(CatalogoMensajes.ServicioNegocioImpl.DATOS_ESTADO_INVALIDOS, resultado.getMensajeUsuario());

		verifyNoInteractions(servicios, servicioEntregas);

	}

	@Test
	void aceptaIdDelCuerpoCuandoCoincideConLaRuta() {

		when(servicios.consultarPorId(id)).thenReturn(registro("Registrado"));

		var solicitud = new ServicioDominio.Builder().id(id).estado("En ejecución").build();

		assertEquals("En ejecución", negocio.actualizarEstado(id, solicitud).getEstado());

		verify(servicioEntregas, never()).consultarPorFiltro(any());

	}

	@Test
	void consultarPorIdRechazaUUIDNuloOVacioAntesDeAccederAlDAO() {

		UUID[] identificadores = { null, UtilUUID.UUID_DEFECTO };

		for (UUID identificador : identificadores) {

			var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() {

					negocio.consultarPorId(identificador);

				}

			});

			assertEquals(CatalogoMensajes.ServicioNegocioImpl.ID_REQUERIDO, resultado.getMensajeUsuario());

		}

		verifyNoInteractions(servicios);

	}

	@Test
	void UUIDValidoPuedeCorresponderAUnServicioInexistente() {

		when(servicios.consultarPorId(id)).thenReturn(new ServicioEntidad.Builder().build());

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				negocio.consultarPorId(id);

			}

		});

		assertEquals(CatalogoMensajes.UtilidadNegocioImpl.SERVICIO_NO_EXISTE, resultado.getMensajeUsuario());

		verify(servicios).consultarPorId(id);

	}

	@Test
	void filtroValidoSinCoincidenciasDevuelveListaVaciaSinComprobarExistencia() {

		var filtro = new ServicioDominio.Builder()
				.id(UUID.randomUUID())
				.numeroServicio("SRV-999")
				.estado("Registrado")
				.fechaServicio(LocalDate.of(2030, 1, 1))
				.build();

		assertTrue(negocio.consultarPorFiltro(filtro).isEmpty());

		verify(servicios).consultarPorFiltro(any());

		verify(servicios, never()).consultarPorId(any());

	}

	static Stream<LocalDate> fechasFiltroValidas() {

		return Stream.of(UtilFecha.FECHA_DEFECTO, LocalDate.of(1, 1, 1),
				LocalDate.of(9999, 12, 31), LocalDate.of(2030, 1, 1));

	}

	@ParameterizedTest
	@MethodSource("fechasFiltroValidas")
	void filtroAceptaFechaPorDefectoYFechasDentroDelRangoSQL(LocalDate fecha) {

		negocio.consultarPorFiltro(new ServicioDominio.Builder().fechaServicio(fecha).build());

		var filtro = org.mockito.ArgumentCaptor.forClass(ServicioEntidad.class);

		verify(servicios).consultarPorFiltro(filtro.capture());

		assertEquals(fecha, filtro.getValue().getFechaServicio());

	}

	static Stream<LocalDate> fechasFiltroInvalidas() {

		return Stream.of(LocalDate.of(0, 1, 1), LocalDate.of(10000, 1, 1));

	}

	@ParameterizedTest
	@MethodSource("fechasFiltroInvalidas")
	void filtroRechazaFechaFueraDelRangoSQLAntesDeConsultar(LocalDate fecha) {

		var resultado = assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() {

				negocio.consultarPorFiltro(new ServicioDominio.Builder().fechaServicio(fecha).build());

			}

		});

		assertEquals(CatalogoMensajes.ServicioNegocioImpl.FECHA_FILTRO_INVALIDA, resultado.getMensajeUsuario());

		verifyNoInteractions(servicios);

	}

	static Stream<String> estadosEntrega() {

		return Stream.of("Pendiente", "En tránsito", "Entregada", "Cancelada");

	}

	private ServicioEntregaEntidad asociarEntrega(String estado) {

		var entrega = new EntregaEntidad.Builder()
			.id(UUID.randomUUID())
			.estadoEntrega(estado)
			.build();

		return new ServicioEntregaEntidad.Builder()
			.servicio(registro("En ejecución"))
			.entrega(entrega)
			.build();

	}

	@ParameterizedTest
	@MethodSource("estadosEntrega")
	void soloFinalizaCuandoTodasLasEntregasEstanEntregadas(String estadoEntrega) {

		when(servicios.consultarPorId(id)).thenReturn(registro("En ejecución"), registro("Finalizado"));

		when(servicioEntregas.consultarPorFiltro(any())).thenReturn(
		List.of(asociarEntrega("Entregada"), asociarEntrega(estadoEntrega)));

		var solicitud = new ServicioDominio.Builder()
			.estado("Finalizado")
			.build();

		if ("Entregada".equals(estadoEntrega)) {

			assertEquals("Finalizado", negocio.actualizarEstado(id, solicitud).getEstado());

			verify(utilidades).crear(any());

		} else {

			assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() {

					negocio.actualizarEstado(id, solicitud);

				}

			});

			verify(servicios, never()).actualizar(any(), any());

			verify(utilidades, never()).crear(any());

		}

		var filtro = org.mockito.ArgumentCaptor.forClass(ServicioEntregaEntidad.class);

		verify(servicioEntregas).consultarPorFiltro(filtro.capture());

		assertEquals(id, filtro.getValue().getServicio().getId());

	}

	@ParameterizedTest
	@MethodSource("estadosEntrega")
	void cancelarCompruebaQueNingunaEntregaEsteEnTransito(String estadoEntrega) {

		when(servicios.consultarPorId(id)).thenReturn(registro("Registrado"));

		when(servicioEntregas.consultarPorFiltro(any())).thenReturn(List.of(asociarEntrega(estadoEntrega)));

		var solicitud = new ServicioDominio.Builder()
			.estado("Cancelado")
			.build();

		if ("En tránsito".equals(estadoEntrega)) {

			assertThrows(KETRAExcepcion.class, new org.junit.jupiter.api.function.Executable() {

				@Override
				public void execute() {

					negocio.actualizarEstado(id, solicitud);

				}

			});

			verify(servicios, never()).actualizar(any(), any());

		} else {

			assertEquals("Cancelado", negocio.actualizarEstado(id, solicitud).getEstado());

		}

		verify(utilidades, never()).crear(any());

	}

}
