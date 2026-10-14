# Implementación de los DAO SQL Server

Se completaron los 24 DAO SQL Server restantes, usando PersonaSqlServerDAO como
referencia: constructor con Connection, herencia de SqlDAO, PreparedStatement,
parámetros, try-with-resources, manejo de SQLException y de excepciones no
controladas con CatalogoMensajes y KETRADatosException, y construcción de las
entidades mediante Builder.

## Cambios realizados

- Las 25 interfaces DAO utilizan su entidad correspondiente. Se corrigieron
  las 19 que todavía utilizaban un DAO como tipo genérico.
- Las 25 entidades tienen constructor privado con Builder, getters y métodos
  del Builder que aplican los utilitarios del proyecto. Se actualizaron las
  24 entidades restantes; PersonaEntidad ya tenía el formato solicitado y
  se conservaron sus cambios locales previos.
- Cada SQL Server DAO implementa exclusivamente las operaciones de su interfaz.
  Las consultas recuperan las relaciones con JOIN y reconstruyen también las
  entidades relacionadas, sin hacer consultas adicionales por cada fila.
- DAOFactory y SqlServerDAOFactory ofrecen los 25 DAO, utilizando la misma
  conexión de la factoría y conservando su gestión de transacciones.
- Se conservaron las consultas específicas de totales de Factura y CostoRecorrido.
- Se añadió src/test/java/com/ketra/dao/SqlServerDAOTests.java.

PersonaSqlServerDAO ya coincide con las columnas indicadas por el usuario,
incluyendo idTipoDocumento y los campos opcionales de texto con valor vacío.
Sus cambios posteriores solo organizan las consultas primero y utilizan los
alias per y tdo, conservando sus operaciones.

Los 25 DAO presentan primero consultarPorId, consultarPorFiltro y consultarTodos,
seguidos de las consultas específicas y las escrituras que permite cada interfaz.
Se usan alias descriptivos como bar, pai, mun, dep, per y tdo; si la misma tabla
se necesita dos veces en una consulta, se distingue con un sufijo (dir y dir2).
Las etiquetas del ResultSet se acortaron a mun_id, mun_nombre, etc., conservando
la reconstrucción completa de las relaciones. El tamaño de los DAO con más
relaciones se debe a esos JOIN, al mapeo con Builders y al manejo de excepciones
del patrón aprobado.

EntregaEntidad incorpora PersonaEntidad persona, getPersona() y
Builder.persona(...): el esquema exige idPersona NOT NULL, y esa relación
faltaba en la entidad. Crear y actualizar entregas utiliza persona.getId().

Se mantienen los getters existentes, incluidos getNIT(), getCEDI(),
getCEDIOrigen(), getDireccion() de DireccionEntidad y getValorCosto() de
PreliquidacionEntidad. Sus correspondencias con las columnas SQL son explícitas.
Las entidades se construyen con new NombreEntidad.Builder().build(); ya no
se construyen mediante un constructor público vacío ni se modifican con setters.

No se cambiaron los DTO, dominio, negocio, API, pantalla, pom.xml,
configuración de conexión ni scripts SQL. sysdiagrams queda fuera del modelo.

## Operaciones conservadas

Todas las entidades ofrecen consultarPorId, consultarPorFiltro y consultarTodos.

| DAO | Crear | Actualizar | Eliminar |
| --- | --- | --- | --- |
| Barrio | — | — | — |
| CEDI | Sí | Sí | — |
| CostoRecorrido | Sí | — | — |
| Departamento | — | — | — |
| DetalleEntrega | Sí | — | — |
| DetallePedido | Sí | — | — |
| Direccion | Sí | Sí | — |
| Empresa | Sí | Sí | — |
| EmpresaServicio | — | — | — |
| Entrega | Sí | Sí | — |
| EntregaTercero | — | — | — |
| Factura | Sí | Sí | — |
| Municipio | — | — | — |
| Pais | — | — | — |
| Pedido | Sí | — | — |
| Persona | Sí | Sí | Sí |
| Preliquidacion | Sí | Sí | — |
| Servicio | Sí | Sí | — |
| ServicioCEDI | — | — | — |
| ServicioEntrega | — | — | — |
| ServicioFactura | — | — | — |
| Tercero | Sí | Sí | Sí |
| TipoDireccion | — | — | — |
| TipoDocumento | — | — | — |
| Utilidad | Sí | — | — |

## Validación realizada

- Compilación completa con Java 25 mediante una propiedad de Maven temporal:
  -Djava.version=25. El pom.xml sigue solicitando Java 26.
- 156 pruebas aprobadas: 152 de entidades, JDBC y factorías y las cuatro pruebas
  existentes del proyecto. Las pruebas usan conexiones simuladas; no modifican
  la base de datos.
- SQL Server local validó las 77 sentencias mediante análisis de metadatos
  (sys.dm_exec_describe_first_result_set), incluyendo tablas, columnas y JOIN.
  No se ejecutaron INSERT, UPDATE ni DELETE contra los datos reales.
- Se contrastó la lista de operaciones de cada interfaz con su versión anterior:
  ninguna interfaz recibió operaciones nuevas.
- La prueba de conexión JDBC real encontró el problema de autenticación integrada
  descrito abajo, por lo que todavía no se verificaron lecturas ni escrituras
  completas de los DAO contra registros reales desde Java.

Para repetir las pruebas en este equipo:

```powershell
$env:JAVA_HOME = 'C:\Users\emanu\.jdks\openjdk-25.0.1'
& 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2025.2.6\plugins\maven\lib\maven3\bin\mvn.cmd' '-Djava.version=25' test
```

## Pendientes fuera del alcance solicitado

Por indicación del usuario, la conexión, la versión de Java, la integración de
la API y la generación automática permanecen como están hasta que se retomen
en clase. Los puntos siguientes registran lo encontrado durante la verificación;
no implican que deba cambiarse ahora la autenticación integrada.

1. La conexión JDBC actual utiliza integratedSecurity=true. Java no pudo cargar
   mssql-jdbc_auth-13.4.0.x64.dll, requerido por el driver 13.4.0. La conexión
   falla con «Este controlador no está configurado para la autenticación
   integrada». SQL Server sí respondió mediante sqlcmd con autenticación de
   Windows. Falta configurar la biblioteca nativa en el entorno de ejecución.
2. El proyecto pide Java 26 y el JDK disponible para esta verificación es 25.
   Falta usar un JDK 26 o autorizar un cambio de la versión del proyecto.
3. La API /api/utilidades/{numeroServicio} todavía depende de UtilidadSimulada.
   Para que la pantalla consulte registros reales falta conectar el controlador
   con la fachada/negocio y preparar su respuesta completa con tablas asociadas.
4. El negocio ya tiene generarUtilidad, pero no hay un flujo implementado que
   lo invoque automáticamente al finalizar un servicio. Esa integración pertenece
   a negocio, no a los DAO.

Los filtros siguen la convención del ejemplo de Persona: UUID_DEFECTO, texto
vacío, FECHA_DEFECTO y cero numérico representan campos sin filtro. Por esa
convención, un cero no selecciona exclusivamente registros con valor cero.

Al guardar entidades se deben proporcionar UUID reales, claves relacionadas
existentes y datos válidos según las restricciones de SQL Server. Los Builders
normalizan los valores; no crean registros relacionados ni generan UUID nuevos.

## Dónde se consultarán los datos de la pantalla

Los SQL Server DAO consultan los datos de sus tablas y relaciones. FacturaDAO
consulta facturas, EntregaDAO consulta entregas, DetalleEntregaDAO consulta sus
detalles y CostoRecorridoDAO consulta costos. Los DAO de asociación permiten
identificar cuáles pertenecen a un servicio utilizando consultarPorFiltro.

En una integración futura, negocio o una fachada coordinará esas consultas y
reunirá la información. El controlador expondrá una respuesta JSON para que el
frontend la muestre. El DAO no construye HTML ni depende de una API REST.
Esta coordinación y la generación automática se mantienen separadas por ahora.
