# Consultar utilidad por servicio

## Arquitectura revisada

El proyecto utiliza Spring Boot 4.1.1, Java 25 y Maven. Ya cuenta con Thymeleaf
y el starter web, por lo que no fue necesario modificar el pom.xml.
Las capas existentes son entidad, dto, dominio, dao y transversal. Los DAO
usan JDBC y factorías explícitas; esta consulta no instancia ninguna de ellas.
No había vistas ni controladores web. application.properties contiene el nombre
de la aplicación y se conserva sin cambios.

## Archivos creados

| Archivo | Función |
| --- | --- |
| `src/main/java/com/ketra/controlador/utilidad/UtilidadVistaControlador.java` | Abre la vista Thymeleaf con GET /utilidad. |
| `src/main/java/com/ketra/controlador/utilidad/UtilidadRestControlador.java` | Expone GET /api/utilidades/{numeroServicio}; devuelve 404 si no existe. |
| `src/main/java/com/ketra/controlador/utilidad/UtilidadRespuesta.java` | Contrato JSON propio de la consulta, con fechas y valores monetarios BigDecimal. |
| `src/main/java/com/ketra/controlador/utilidad/simulado/UtilidadSimulada.java` | Datos temporales aislados de SRV-001, incluyendo la utilidad ya registrada. |
| `src/main/resources/templates/utilidad/consultar-utilidad.html` | Selector, único botón Consultar utilidad, tablas vacías y resumen. |
| `src/main/resources/static/css/consultar-utilidad.css` | Estilo KETRA y distribución adaptable a escritorio y móvil. |
| `src/main/resources/static/js/consultar-utilidad.js` | Consulta mediante fetch, llena tablas y resumen, formatea valores y maneja carga y errores. |
| `src/test/java/com/ketra/UtilidadConsultaTests.java` | Pruebas HTTP de API, vista y recursos, 404 y consistencia de importes. |
| `CONSULTAR-UTILIDAD.md` | Esta guía. |

No se modificó ningún archivo existente. Los cambios previos del usuario en
pom.xml, SqlServerDAOFactory.java y sql/ se conservaron.

## Ejecutar

En IntelliJ o Eclipse, seleccionar el JDK 25 y ejecutar
`com.ketra.KetraBackEndApplication` como aplicación Java/Spring Boot.
No se requiere iniciar SQL Server para esta consulta.

Alternativamente, desde PowerShell en la raíz del proyecto, con Maven disponible:

```powershell
$env:JAVA_HOME = 'C:\Users\emanu\.jdks\openjdk-25.0.1'
mvn spring-boot:run
```

En este equipo también se puede usar el Maven instalado con IntelliJ:

```powershell
$env:JAVA_HOME = 'C:\Users\emanu\.jdks\openjdk-25.0.1'
& 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2025.2.6\plugins\maven\lib\maven3\bin\mvn.cmd' spring-boot:run
```

El mvnw.cmd existente falla en este equipo al acceder a Target[0] de la carpeta
.m2; no se modificó porque está fuera del alcance de esta funcionalidad.
El Java predeterminado del terminal es Java 8; usar expresamente el JDK 25.

Abrir http://localhost:8080/utilidad, seleccionar SRV-001 y pulsar Consultar utilidad.
El JSON se puede consultar en http://localhost:8080/api/utilidades/SRV-001.

Bootstrap se carga desde CDN; su descarga requiere conexión a Internet.
Las tablas tienen desplazamiento horizontal en pantallas pequeñas.
Los demás módulos del menú son referencias visuales sin enlaces funcionales.

## Validación

Se ejecutó Maven test con Java 25: cuatro pruebas aprobadas, incluyendo la prueba
de contexto existente. También pasó node --check para el JavaScript.
Se probó la consulta real en navegador y se revisó el diseño a 1440 y 390 píxeles.

## Integración futura

Sustituir la dependencia UtilidadSimulada del controlador REST por la consulta
de negocio cuando esté lista, manteniendo el contrato UtilidadRespuesta.
El frontend consume la utilidad registrada: no calcula, crea ni persiste utilidad.
La finalización del servicio y su cálculo automático quedan en la futura capa
de negocio. Este módulo únicamente consulta datos simulados.
