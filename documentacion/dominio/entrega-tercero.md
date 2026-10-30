# EntregaTercero

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s43) · [Datos de ejemplo](#dominio-s44) · [Políticas](#dominio-s46) · [Eventos y colaboración](#dominio-s45)

<a id="dominio-s43"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s43-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">EntregaTercero</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa la relación entre una entrega y un tercero</td>
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
<td><a id="dominio-s43-v4"></a><a href="entrega-tercero.md#dominio-s43-a16">Consultar informacion de una entregaTercero por su identificador</a></td>
<td colspan="2"><a id="dominio-s43-w4"></a><a href="entrega-tercero.md#dominio-s43-a17">Consultar informacion de EntregaTercero</a></td>
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
<td>No aplica</td>
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
<td>CodigoEntrega</td>
<td>Representa el código que identifica la entrega que será realizada por el tercero.</td>
<td>No</td>
<td><a href="entrega.md#dominio-s39-a1">Entrega</a></td>
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
<td>Tercero</td>
<td>Representa el nombre del tercero encargado de realizar la entrega.</td>
<td>No</td>
<td><a href="tercero.md#dominio-s104-a1">Tercero</a></td>
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
<td rowspan="2">No puede haber más de un EntregaTercero con la misma combinación de entrega y tercero.</td>
<td>CodigoEntrega</td>
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
<td>Tercero</td>
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
<td colspan="2"><a id="dominio-s43-a16"></a><a href="entrega-tercero.md#dominio-s43-v4">Consultar informacion de una EntregaTercero por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una entrega tercero especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la entrega tercero que se va a consultar</td>
<td>EntregaTercero</td>
<td colspan="4">Contiene la informacion de la entrega tercero consultada por su id</td>
<td>P-ETE-0001</td>
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
<td colspan="2"><a id="dominio-s43-a17"></a><a href="entrega-tercero.md#dominio-s43-w4">Consultar informacion de EntregaTercero</a></td>
<td colspan="4">Accion que permite obtener un listado de los EntregaTercero registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>EntregaTercero</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;EntregaTercero&gt;</td>
<td colspan="4">Contiene la informacion de todas las entregas tercero que cumplen con el filtro de consulta</td>
<td>P-ETE-0001</td>
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


<a id="dominio-s44"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s44-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Representa el código que identifica la entrega que será realizada por el tercero.</td>
<td>Representa el nombre del tercero encargado de realizar la entrega.</td>
<td>No puede haber más de un EntregaTercero con la misma combinación de entrega y tercero.</td>
</tr>
<tr>
<td>ID</td>
<td><a href="entrega.md#dominio-s40-a1">CodigoEntrega</a></td>
<td><a href="tercero.md#dominio-s104-a1">Tercero</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>ENT-001</td>
<td>Transportes Oriente-890910871-2</td>
<td>ENT-001-Transportes Oriente-890910871-2</td>
</tr>
<tr>
<td>2</td>
<td>ENT-002</td>
<td>Contransporte-811001202-8</td>
<td>ENT-002-Contransporte-811001202-8</td>
</tr>
<tr>
<td>3</td>
<td>ENT-003</td>
<td>Transportes Oriente-890910871-2</td>
<td>ENT-003-Transportes Oriente-890910871-2</td>
</tr>
<tr>
<td>4</td>
<td>ENT-004</td>
<td>Transportes Saferbo-890920990-3</td>
<td>ENT-004-Transportes Saferbo-890920990-3</td>
</tr>
<tr>
<td>5</td>
<td>ENT-005</td>
<td>Contransporte-811001202-8</td>
<td>ENT-005-Contransporte-811001202-8</td>
</tr>
<tr>
<td>6</td>
<td>ENT-006</td>
<td>Transportes Saferbo-890920990-3</td>
<td>ENT-006-Transportes Saferbo-890920990-3</td>
</tr>
<tr>
<td>7</td>
<td>ENT-007</td>
<td>Correcamiones-900257142-6</td>
<td>ENT-007-Correcamiones-900257142-6</td>
</tr>
<tr>
<td>8</td>
<td>ENT-008</td>
<td>Contransporte-811001202-8</td>
<td>ENT-008-Contransporte-811001202-8</td>
</tr>
<tr>
<td>9</td>
<td>ENT-001</td>
<td>Contransporte-811001202-8</td>
<td>ENT-001-Contransporte-811001202-8</td>
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


<a id="dominio-s45"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s45-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">EntregaTercero</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa la relación entre una entrega y un tercero</td>
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
<td>Consultar EntregaTercero</td>
<td>Permite consultar la información de un EntregaTercero que cumpla con un criterio de búsqueda específico.</td>
<td>EntregaTercero</td>
<td></td>
<td></td>
<td><a href="entrega-tercero.md#dominio-s46-a5">P-ETE-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>EntregaTercero consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s46"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s46-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">EntregaTercero</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa la relación entre una entrega y un tercero</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s46-a5"></a>P-ETE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>EntregaTercero</td>
<td></td>
</tr>
</table>
