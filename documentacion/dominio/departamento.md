# Departamento

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s15) · [Datos de ejemplo](#dominio-s16) · [Políticas](#dominio-s18) · [Políticas](#dominio-s34) · [Eventos y colaboración](#dominio-s17)

<a id="dominio-s15"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s15-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">Departamento</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Nombre atributo</td>
<td>Descripción atributo</td>
<td>Identificador del objeto de dominio</td>
<td>Tipo de dato</td>
<td>Obligatorio</td>
<td>Longitud mínima (si aplica)</td>
<td>Longitud máxima (si aplica)</td>
<td>Precisión (si aplica)</td>
<td>Rendondeo (si aplica)</td>
<td>Rango inicial (si aplica)</td>
<td>Rango final (si aplica)</td>
<td>Formato (si aplica)</td>
<td>Reglas especiales (si aplica)</td>
<td>Dato calculado</td>
<td>Aplica ajuste del dato (si aplica)</td>
<td>Carácter de ajuste (si aplica)</td>
<td>Quitar espacios en blanco al inicio (si aplica)</td>
<td>Quitar espacios en blanco al fin (si aplica)</td>
<td>Dato sensible (si aplica)</td>
<td>Valor por defecto (si aplica)</td>
<td>Auto generado</td>
<td><a id="dominio-s15-v4"></a><a href="departamento.md#dominio-s15-a17">Consultar informacion de un departamento por su identificador</a></td>
<td colspan="2"><a id="dominio-s15-w4"></a><a href="departamento.md#dominio-s15-a18">Consultar informacion de los departamentos</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Sí</td>
<td>Identificador único universal</td>
<td>Sí</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Sí</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
</tr>
<tr>
<td>Nombre</td>
<td>Representa un nombre de un departamento</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>50</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
</tr>
<tr>
<td>Pais</td>
<td>Representa el pais al que pertence departamento</td>
<td>No</td>
<td><a href="pais.md#dominio-s71-a1">Pais</a></td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Aplican las reglas del objeto referenciado.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Nombre combinación única</td>
<td>Descripción</td>
<td>Atributos involucrados</td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="2">Combinación única 1</td>
<td rowspan="2">No puede existir dos departamentos con el mismo nombre dentro de un pais</td>
<td>Nombre</td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Pais</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="2" colspan="2">Responsabilidad</td>
<td rowspan="2" colspan="4">Descripción</td>
<td colspan="3">Entradas</td>
<td colspan="5">Salida</td>
<td colspan="2">Políticas (Reglas de Negocio)</td>
<td colspan="2">Excepción</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Parámetro</td>
<td>Tipo de dato</td>
<td>Descripción</td>
<td>Tipo de Dato</td>
<td colspan="4">Descripción</td>
<td>Política</td>
<td>Descripción</td>
<td>Detalle</td>
<td>¿Qué hago?</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s15-a17"></a><a href="departamento.md#dominio-s15-v4">Consultar informacion de un departamento por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un departamento especifico utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del departamento que se va a consultar</td>
<td>Departamento</td>
<td colspan="4">Contiene la informacion del departamento consultado por su id</td>
<td>P-DEP-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s15-a18"></a><a href="departamento.md#dominio-s15-w4">Consultar informacion de los departamentos</a></td>
<td colspan="4">Accion que permite obtener un listado de los departamentos registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Departamento</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Departamento&gt;</td>
<td colspan="4">Contiene la informacion de todos los departamentos que cumplen con el filtro de consulta</td>
<td>P-DEP-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s16"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s16-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Representa el pais al que pertence departamento</td>
<td>Representa un nombre de un departamento</td>
<td>No puede existir dos departamentos con el mismo nombre dentro de un pais</td>
</tr>
<tr>
<td>ID</td>
<td><a href="pais.md#dominio-s72-a1">Pais</a></td>
<td>Nombre</td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Colombia</td>
<td>Antioquia</td>
<td>Colombia-Antioquia</td>
</tr>
<tr>
<td>2</td>
<td>Colombia</td>
<td>Boyacá</td>
<td>Colombia-Boyacá</td>
</tr>
<tr>
<td>3</td>
<td>Colombia</td>
<td>Santander</td>
<td>Colombia-Santander</td>
</tr>
<tr>
<td>4</td>
<td>Colombia</td>
<td>Bogota.D.C.</td>
<td>Colombia-Bogota.D.C.</td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinacion unica 1</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s17"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s17-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio:</td>
<td colspan="10">Departamento</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
</tr>
<tr>
<td>Actor</td>
<td colspan="2">Action/Command</td>
<td>Entity/Aggregate/Object domain</td>
<td colspan="2">Read Model</td>
<td colspan="2">Business Rule/Policy</td>
<td>External System</td>
<td>Domain Event</td>
<td>Hotspot/questions/Risk</td>
</tr>
<tr>
<td rowspan="2">Actor</td>
<td rowspan="2">Acción</td>
<td rowspan="2">Descripción</td>
<td rowspan="2">Objeto de dominio</td>
<td colspan="2">Información externa</td>
<td colspan="2">Políticas</td>
<td rowspan="2">Sistema Externo</td>
<td>Evento</td>
<td>Aspectos por solucionar</td>
</tr>
<tr>
<td>Información</td>
<td>Descripción</td>
<td>Número</td>
<td>Descripción</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar departamento</td>
<td>Permite consultar los departamentos asociados a un país según un criterio de búsqueda.</td>
<td>Departamento</td>
<td></td>
<td></td>
<td><a href="departamento.md#dominio-s18-a5">P-DEP-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Departamento consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s18"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s18-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Departamento</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s18-a5"></a>P-DEP-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Departamento</td>
<td></td>
</tr>
</table>


<a id="dominio-s34"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s34-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Departamento</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s34-a5"></a>P-EMP-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Empresa</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s34-a6"></a>P-EMP-0002</td>
<td>Asegurar que el identiticador generado para la empresa ya no esté siendo utilizado por otra empresa</td>
<td>Empresa</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s34-a7"></a>P-EMP-0003</td>
<td>Asegurar que no exista otra empresa registrada con la misma combinacion de nombre y NIT </td>
<td>Empresa</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s34-a8"></a>P-EMP-0004</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Empresa</td>
<td></td>
</tr>
</table>
