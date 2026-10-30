# EmpresaServicio

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s35) · [Datos de ejemplo](#dominio-s36) · [Políticas](#dominio-s38) · [Eventos y colaboración](#dominio-s37)

<a id="dominio-s35"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s35-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">EmpresaServicio</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa la relación entre una empresa y un servicio</td>
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
<td><a id="dominio-s35-v4"></a><a href="empresa-servicio.md#dominio-s35-a18">Consultar informacion de una empresaServicio por su identificador</a></td>
<td colspan="2"><a id="dominio-s35-w4"></a><a href="empresa-servicio.md#dominio-s35-a19">Consultar informacion de EmpresaServicio</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Si</td>
<td>Identificador único universal</td>
<td>Si</td>
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
<td>Si</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
</tr>
<tr>
<td>Empresa</td>
<td>Representa el nombre de la empresa que contrata el servicio logístico.</td>
<td>No</td>
<td><a href="empresa.md#dominio-s31-a1">Empresa</a></td>
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
<td>NumeroServicio</td>
<td>Representa el número del servicio logístico contratado por la empresa.</td>
<td>No</td>
<td><a href="servicio.md#dominio-s87-a1">Servicio</a></td>
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
<td rowspan="2">Combinación única 1</td>
<td rowspan="2">No puede haber más de un EmpresaServicio con la misma combinación de empresa y servicio.</td>
<td>Empresa</td>
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
<td>NumeroServicio</td>
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
<td colspan="2"><a id="dominio-s35-a18"></a><a href="empresa-servicio.md#dominio-s35-v4">Consultar informacion de una EmpresaServicio por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una empresa servicio especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la empresa que se va a consultar</td>
<td>EmpresaServicio</td>
<td colspan="4">Contiene la informacion de la empresa servicio consultada por su id</td>
<td>P-ESE-0001</td>
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
<td colspan="2"><a id="dominio-s35-a19"></a><a href="empresa-servicio.md#dominio-s35-w4">Consultar informacion de EmpresaServicio</a></td>
<td colspan="4">Accion que permite obtener un listado de las empresas  servicio registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>EmpresaServicio</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;EmpresaServicio&gt;</td>
<td colspan="4">Contiene la informacion de todos las empresas servicio que cumplen con el filtro de consulta</td>
<td>P-ESE-0001</td>
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
<td>}</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s36"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s36-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Representa el nombre de la empresa que contrata el servicio logístico.</td>
<td>Representa el número del servicio logístico contratado por la empresa.</td>
<td>No puede haber más de un EmpresaServicio con la misma combinación de empresa y servicio.</td>
</tr>
<tr>
<td>ID</td>
<td><a href="empresa.md#dominio-s32-a1">Empresa</a></td>
<td><a href="servicio.md#dominio-s88-a1">NumeroServicio</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Novaventa-811025289-1</td>
<td>SRV-001</td>
<td>Novaventa-811025289-1-SRV-001</td>
</tr>
<tr>
<td>2</td>
<td>Novaventa-811025289-1</td>
<td>SRV-002</td>
<td>Novaventa-811025289-1-SRV-002</td>
</tr>
<tr>
<td>3</td>
<td>Carmel-811.017.000-7</td>
<td>SRV-003</td>
<td>Carmel-811.017.000-7-SRV-003</td>
</tr>
<tr>
<td>4</td>
<td>Carmel-811.017.000-7</td>
<td>SRV-004</td>
<td>Carmel-811.017.000-7-SRV-004</td>
</tr>
<tr>
<td>5</td>
<td>Pacifika-811.017.000-7</td>
<td>SRV-005</td>
<td>Pacifika-811.017.000-7-SRV-005</td>
</tr>
<tr>
<td>6</td>
<td>Pacifika-811.017.000-7</td>
<td>SRV-006</td>
<td>Pacifika-811.017.000-7-SRV-006</td>
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


<a id="dominio-s37"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s37-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">EmpresaServicio</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa la relación entre una empresa y un servicio</td>
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
<td rowspan="2">Evento</td>
<td rowspan="2">Aspectos por solucionar</td>
</tr>
<tr>
<td>Información</td>
<td>Descripción</td>
<td>Número</td>
<td>Descripción</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar EmpresaServicio</td>
<td>Permite consultar la información de una EmpresaServicio que cumpla con un criterio de búsqueda específico.</td>
<td>EmpresaServicio</td>
<td></td>
<td></td>
<td><a href="empresa-servicio.md#dominio-s38-a5">P-ESE-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>EmpresaServicio consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s38"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s38-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">EmpresaServicio</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa la relación entre una empresa y un servicio</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s38-a5"></a>P-ESE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>EmpresaServicio</td>
<td></td>
</tr>
</table>
