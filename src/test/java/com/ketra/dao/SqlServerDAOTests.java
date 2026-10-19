package com.ketra.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.ketra.dao.factoria.DAOFactory;
import com.ketra.dao.factoria.impl.SqlServerDAOFactory;
import com.ketra.entidad.*;
import com.ketra.transversal.excepciones.KETRAExcepcion;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilUUID;

/** Verifica JDBC sin escribir en la base real: SQL, parámetros, mapeo y recursos. */
class SqlServerDAOTests {

	private static final UUID ID = UUID.fromString("ca9a6718-b4be-47d7-b5d8-b729683c4b80");

	private static final UUID ID_ACTUALIZAR = UUID.fromString("243ad1a6-dcf5-4bb1-999b-fc3f64db3ed1");

	private static final LocalDate FECHA = LocalDate.of(2026, 10, 12);

	static Stream<String> nombres() {

		return Stream.of("Barrio", "CEDI", "CostoRecorrido", "Departamento", "DetalleEntrega",
		"DetallePedido", "Direccion", "Empresa", "EmpresaServicio", "Entrega", "EntregaTercero",
		"Factura", "Municipio", "Pais", "Pedido", "Persona", "Preliquidacion", "ServicioCEDI",
		"Servicio", "ServicioEntrega", "ServicioFactura", "Tercero", "TipoDireccion", "TipoDocumento", "Utilidad");

	}

	private static Class<?> entidad(String nombre) throws Exception {

		return Class.forName("com.ketra.entidad." + nombre + "Entidad");

	}

	private static Object construir(Class<?> tipo, boolean poblar) throws Exception {

		var builder = Class.forName(tipo.getName() + "$Builder").getConstructor().newInstance();

		if (poblar) {

			for (Method metodo : builder.getClass().getDeclaredMethods()) {

				if (metodo.getParameterCount() != 1) continue;

				Class<?> param = metodo.getParameterTypes()[0];

				Object valor;

				if (param == UUID.class) valor = ID;

				else if (param == String.class) valor = "valor ' con comillas";

				else if (param == LocalDate.class) valor = FECHA;

				else if (param == int.class) valor = 3000;

				else if (param == Double.class) valor = 1234.5;

				else valor = construir(param, true);

				metodo.invoke(builder, valor);

			}

		}

		return builder.getClass().getMethod("build").invoke(builder);

	}

	private static final class Jdbc {

		final Connection conexion = mock(Connection.class);

		final PreparedStatement sentencia = mock(PreparedStatement.class);

		final ResultSet resultado = mock(ResultSet.class);

		String sql;

		final Map<Integer, Object> parametros = new TreeMap<>();

		Jdbc() throws Exception {

			when(conexion.isClosed()).thenReturn(false);

			when(conexion.prepareStatement(anyString())).thenAnswer(new org.mockito.stubbing.Answer<PreparedStatement>() {

				@Override
				public PreparedStatement answer(org.mockito.invocation.InvocationOnMock inv) throws Exception {

					sql = inv.getArgument(0);
					parametros.clear();
					validarSQL(sql);
					return sentencia;

				}

			});

			org.mockito.stubbing.Answer<Object> registrarParametro = new org.mockito.stubbing.Answer<Object>() {

				@Override
				public Object answer(org.mockito.invocation.InvocationOnMock inv) {

					return registrar(inv.getArgument(0), inv.getArgument(1));

				}

			};

			doAnswer(registrarParametro).when(sentencia).setObject(anyInt(), any());

			doAnswer(registrarParametro).when(sentencia).setString(anyInt(), anyString());

			doAnswer(registrarParametro).when(sentencia).setDouble(anyInt(), anyDouble());

			doAnswer(registrarParametro).when(sentencia).setInt(anyInt(), anyInt());

			doAnswer(registrarParametro).when(sentencia).setDate(anyInt(), any(java.sql.Date.class));

			when(sentencia.executeQuery()).thenReturn(resultado);

			when(sentencia.executeUpdate()).thenReturn(1);

		}

		private Object registrar(Integer indice, Object valor) {

			parametros.put(indice, valor);

			return null;

		}

		Object dao(String nombre) throws Exception {

			return Class.forName("com.ketra.dao.datos.entidad.sqlserver." + nombre + "SqlServerDAO")
				.getConstructor(Connection.class).newInstance(conexion);

		}

		void verificarParametros() {

			int cantidad = 0;

			for (char caracter : sql.toCharArray()) {

				if (caracter == '?') {

					cantidad++;

				}

			}
			assertEquals(cantidad, parametros.size());

			for (int i = 1; i <= parametros.size(); i++) assertTrue(parametros.containsKey(i));

			assertFalse(sql.contains("valor ' con comillas"), "Valores deben enviarse como parámetros");

		}

		void fila() throws Exception {

			when(resultado.next()).thenReturn(true, false);

			when(resultado.getString(anyString())).thenAnswer(new org.mockito.stubbing.Answer<String>() {

				@Override
				public String answer(org.mockito.invocation.InvocationOnMock inv) {

					String columna = inv.getArgument(0);
					return columna.equals("id") || columna.endsWith("_id") || columna.startsWith("id")
					? ID.toString() : "dato";

				}

			});

			when(resultado.getDate(anyString())).thenReturn(java.sql.Date.valueOf(FECHA));

			when(resultado.getDouble(anyString())).thenReturn(1234.5);

			when(resultado.getInt(anyString())).thenReturn(3000);

		}

	}

	private static Map<String, Set<String>> esquema() throws Exception {

		String ddl = Files.readString(Path.of("sql/02-crear-tablas.sql"));

		var tablas = new HashMap<String, Set<String>>();

		var matcher = Pattern.compile("CREATE TABLE dbo\\.(\\w+) \\(([\\s\\S]*?)\\n\\s*CONSTRAINT PK_").matcher(ddl);

		while (matcher.find()) {

			var columnas = new HashSet<String>();

			var campos = Pattern.compile("(?m)^\\s*(\\w+) (?:UNIQUEIDENTIFIER|VARCHAR|DATE|INT|DECIMAL)").matcher(matcher.group(2));

			while (campos.find()) columnas.add(campos.group(1).toLowerCase(Locale.ROOT));

			tablas.put(matcher.group(1).toLowerCase(Locale.ROOT), columnas);

		}

		return tablas;

	}

	/** Contrasta nombres y columnas con el DDL, independiente del código de cada DAO. */
	private static void validarSQL(String sql) throws Exception {

		var tablas = esquema();

		var aliases = new HashMap<String, Set<String>>();

		var from = Pattern.compile("(?i)(?:FROM|JOIN) (\\w+) (\\w+)").matcher(sql);

		while (from.find()) {

			var columnas = tablas.get(from.group(1).toLowerCase(Locale.ROOT));

			assertNotNull(columnas, "Tabla desconocida " + from.group(1));

			aliases.put(from.group(2), columnas);

		}

		var referencias = Pattern.compile("\\b(\\w+)\\.(\\w+)\\b").matcher(sql);

		while (referencias.find()) {

			assertTrue(aliases.containsKey(referencias.group(1)), "Alias desconocido: " + referencias.group());

			assertTrue(aliases.get(referencias.group(1)).contains(referencias.group(2).toLowerCase(Locale.ROOT)),
			"Columna desconocida: " + referencias.group());

		}

		var insert = Pattern.compile("(?is)INSERT INTO (\\w+) \\((.*?)\\)\\s*VALUES").matcher(sql);

		if (insert.find()) {

			Set<String> columnas = new HashSet<>();

			for (String columna : insert.group(2).split(",")) columnas.add(columna.trim().toLowerCase(Locale.ROOT));

			assertEquals(tablas.get(insert.group(1).toLowerCase(Locale.ROOT)), columnas,
			"El INSERT debe incluir todos los campos obligatorios del esquema");

		}

		var update = Pattern.compile("(?is)UPDATE (\\w+)\\s+SET (.*?)WHERE").matcher(sql);

		if (update.find()) {

			var columnas = tablas.get(update.group(1).toLowerCase(Locale.ROOT));

			var asignaciones = Pattern.compile("(\\w+)\\s*=").matcher(update.group(2));

			while (asignaciones.find()) assertTrue(columnas.contains(asignaciones.group(1).toLowerCase(Locale.ROOT)));

		}

	}

	@ParameterizedTest @MethodSource("nombres")
	void buildersNormalizanNulosYTextos(String nombre) throws Exception {

		Class<?> tipo = entidad(nombre);

		var builder = Class.forName(tipo.getName() + "$Builder").getConstructor().newInstance();

		for (Method metodo : builder.getClass().getDeclaredMethods()) {

			if (metodo.getParameterCount() == 1 && !metodo.getParameterTypes()[0].isPrimitive()) {

				metodo.invoke(builder, new Object[] {

					null

				});

			}

		}
		Object vacio = builder.getClass().getMethod("build").invoke(builder);

		assertEquals(UtilUUID.UUID_DEFECTO, tipo.getMethod("getId").invoke(vacio));

		for (Method getter : tipo.getDeclaredMethods()) {

			if (!getter.getName().startsWith("get")) continue;

			Object valor = getter.invoke(vacio);

			assertNotNull(valor, getter.getName());

			if (getter.getReturnType() == String.class) assertEquals("", valor);

			if (getter.getReturnType() == LocalDate.class) assertEquals(UtilFecha.FECHA_DEFECTO, valor);

		}

		for (Method metodo : builder.getClass().getDeclaredMethods()) {

			if (Arrays.equals(metodo.getParameterTypes(), new Class<?>[] {

				String.class

			})) {

				metodo.invoke(builder, "  nombre  ");

				Object construido = builder.getClass().getMethod("build").invoke(builder);

				String getter = "get" + Character.toUpperCase(metodo.getName().charAt(0)) + metodo.getName().substring(1);

				assertEquals("nombre", tipo.getMethod(getter).invoke(construido));

			}

		}

	}

	@ParameterizedTest @MethodSource("nombres")
	void consultasVaciasDevuelvenEntidadDefectoYListaVacia(String nombre) throws Exception {

		var jdbc = new Jdbc();

		var dao = jdbc.dao(nombre);

		Object encontrado = dao.getClass().getMethod("consultarPorId", UUID.class).invoke(dao, ID);

		assertEquals(UtilUUID.UUID_DEFECTO, entidad(nombre).getMethod("getId").invoke(encontrado));

		assertEquals(ID, jdbc.parametros.get(1));

		jdbc.verificarParametros();

		Object lista = dao.getClass().getMethod("consultarTodos").invoke(dao);

		assertEquals(List.of(), lista);

		assertFalse(jdbc.sql.contains(" WHERE "));

		jdbc.verificarParametros();

		verify(jdbc.sentencia, times(2)).close();

		verify(jdbc.resultado, times(2)).close();

		verify(jdbc.conexion, never()).close();

	}

	@ParameterizedTest @MethodSource("nombres")
	void filtrosUsanParametrosYReconstruyenRelaciones(String nombre) throws Exception {

		var jdbc = new Jdbc();

		jdbc.fila();

		var dao = jdbc.dao(nombre);

		Object filtro = construir(entidad(nombre), true);

		@SuppressWarnings("unchecked")
		List<Object> lista = (List<Object>) dao.getClass().getMethod("consultarPorFiltro", entidad(nombre)).invoke(dao, filtro);

		assertEquals(1, lista.size());

		assertEquals(ID, entidad(nombre).getMethod("getId").invoke(lista.getFirst()));

		verificarObjeto(lista.getFirst());

		assertTrue(jdbc.sql.contains(" WHERE "));

		jdbc.verificarParametros();

		assertTrue(jdbc.parametros.containsValue(ID));

		verify(jdbc.sentencia).close();

		verify(jdbc.resultado).close();

	}

	private static void verificarObjeto(Object objeto) throws Exception {

		for (Method getter : objeto.getClass().getDeclaredMethods()) {

			if (!getter.getName().startsWith("get")) continue;

			Object valor = getter.invoke(objeto);

			Class<?> tipo = getter.getReturnType();

			if (tipo == UUID.class) assertEquals(ID, valor);

			else if (tipo == String.class) assertEquals("dato", valor);

			else if (tipo == LocalDate.class) assertEquals(FECHA, valor);

			else if (tipo == int.class) assertEquals(3000, valor);

			else if (tipo == Double.class) assertEquals(1234.5, valor);

			else verificarObjeto(valor);

		}

	}

	@ParameterizedTest @MethodSource("nombres")
	void escriturasUsanCamposDeEntidadYElIdRecibido(String nombre) throws Exception {

		var jdbc = new Jdbc();

		var dao = jdbc.dao(nombre);

		Object registro = construir(entidad(nombre), true);

		for (Method metodo : dao.getClass().getDeclaredMethods()) {

			switch (metodo.getName()) {

				case "crear": {

					metodo.invoke(dao, registro);

					assertTrue(jdbc.sql.contains("INSERT INTO " + nombre));

					assertEquals(ID, jdbc.parametros.get(1));

					jdbc.verificarParametros();

					break;

				}
				case "actualizar": {

					metodo.invoke(dao, ID_ACTUALIZAR, registro);

					assertTrue(jdbc.sql.contains("UPDATE " + nombre));

					assertEquals(ID_ACTUALIZAR, jdbc.parametros.get(jdbc.parametros.size()));

					jdbc.verificarParametros();

					break;

				}
				case "eliminar": {

					metodo.invoke(dao, ID);

					assertTrue(jdbc.sql.contains("DELETE FROM " + nombre));

					assertEquals(ID, jdbc.parametros.get(1));

					jdbc.verificarParametros();

					break;

				}

			}

		}
		verify(jdbc.conexion, never()).commit();

		verify(jdbc.conexion, never()).close();

	}

	@ParameterizedTest @MethodSource("nombres")
	void erroresSQLSeTraducenALaExcepcionDelProyecto(String nombre) throws Exception {

		var jdbc = new Jdbc();

		SQLException causa = new SQLException("error JDBC de prueba");

		when(jdbc.conexion.prepareStatement(anyString())).thenThrow(causa);

		Object dao = jdbc.dao(nombre);

		var error = assertThrows(InvocationTargetException.class,
		new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				dao.getClass().getMethod("consultarPorId", UUID.class).invoke(dao, ID);

			}

		});

		assertInstanceOf(KETRAExcepcion.class, error.getCause());

		assertSame(causa, ((KETRAExcepcion) error.getCause()).getExcepcionRaiz());

	}

	@Test
	void relacionesConNombresDistintosAlSQLSeFiltranPorSuClave() throws Exception {

		var jdbc = new Jdbc();

		var dao = jdbc.dao("DetallePedido");

		dao.getClass().getMethod("consultarPorFiltro", DetallePedidoEntidad.class).invoke(dao,
		new DetallePedidoEntidad.Builder().numeroPedido(new PedidoEntidad.Builder().id(ID).build()).build());

		assertTrue(jdbc.sql.endsWith("WHERE dpe.idPedido = ?"));

		assertEquals(Map.of(1, ID), jdbc.parametros);

	}

	@Test
	void totalIngresosYCostosConservanSusCriterios() throws Exception {

		var jdbc = new Jdbc();

		when(jdbc.resultado.next()).thenReturn(true);

		when(jdbc.resultado.getDouble("totalIngresos")).thenReturn(1425000.0);

		when(jdbc.resultado.getDouble("totalCostos")).thenReturn(140100.0);

		Object facturas = jdbc.dao("Factura");

		assertEquals(1425000.0, facturas.getClass().getMethod("consultarTotalIngresosPorServicio", UUID.class)
			.invoke(facturas, ID));

		assertTrue(jdbc.sql.contains("fac.estadoFactura <> 'Anulada'"));

		assertEquals(Map.of(1, ID), jdbc.parametros);

		Object costos = jdbc.dao("CostoRecorrido");

		assertEquals(140100.0, costos.getClass().getMethod("consultarTotalCostosPorServicio", UUID.class)
			.invoke(costos, ID));

		assertTrue(jdbc.sql.contains("ent.estadoEntrega = 'Entregada'"));

		assertEquals(Map.of(1, ID), jdbc.parametros);

	}

	static Stream<String> documentosConEstado() {

		return Stream.of("Servicio", "Entrega", "Factura", "Preliquidacion");

	}

	@ParameterizedTest @MethodSource("documentosConEstado")
	void actualizarDocumentoSoloEscribeEstado(String nombre) throws Exception {

		var jdbc = new Jdbc();

		var dao = jdbc.dao(nombre);

		Object registro = construir(entidad(nombre), true);

		dao.getClass().getMethod("actualizar", UUID.class, entidad(nombre)).invoke(dao, ID_ACTUALIZAR, registro);

		assertTrue(jdbc.sql.matches("(?s).*SET (estado|estadoFactura|estadoEntrega) = \\?\\s+WHERE id = \\?.*"));

		assertEquals(Map.of(1, "valor ' con comillas", 2, ID_ACTUALIZAR), jdbc.parametros);

		verify(jdbc.sentencia).setString(1, "valor ' con comillas");

		verify(jdbc.sentencia).setObject(2, ID_ACTUALIZAR);

		verify(jdbc.sentencia, never()).setDate(anyInt(), any());

	}

	@ParameterizedTest @MethodSource("nombres")
	void ambasFactoriasOfrecenCadaDAO(String nombre) throws Exception {

		Method contrato = DAOFactory.class.getMethod("obtener" + nombre + "DAO");

		assertEquals("com.ketra.dao.datos.entidad." + nombre + "DAO", contrato.getReturnType().getName());

		// Evita abrir SQL Server; prueba el cuerpo real del método de la factoría.
		var factoria = mock(SqlServerDAOFactory.class, CALLS_REAL_METHODS);

		var campo = DAOFactory.class.getDeclaredField("conexion");

		campo.setAccessible(true);

		var jdbc = new Jdbc();

		campo.set(factoria, jdbc.conexion);

		Object dao = contrato.invoke(factoria);

		assertEquals(nombre + "SqlServerDAO", dao.getClass().getSimpleName());

	}

}
