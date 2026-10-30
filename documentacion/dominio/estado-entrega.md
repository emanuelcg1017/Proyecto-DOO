# EstadoEntrega

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s47) · [Datos de ejemplo](#dominio-s48) · [Políticas](#dominio-s50) · [Eventos y colaboración](#dominio-s49)

<a id="dominio-s47"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s47-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">EstadoEntrega</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa cada uno de los estados disponibles para una entrega</td>
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
<td><a id="dominio-s47-v4"></a><a href="estado-entrega.md#dominio-s47-a14">Consultar estado por identificador</a></td>
<td colspan="2"><a id="dominio-s47-w4"></a><a href="estado-entrega.md#dominio-s47-a15">Consultar estados por filtro</a></td>
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
<td>Código</td>
<td>Código que permite identificar el estado</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>6</td>
<td>6</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>Nombre</td>
<td>Nombre del estado</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>50</td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td> </td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td> </td>
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
<td>Combinación única 1</td>
<td>No pueden existir dos estados con el mismo nombre</td>
<td>Nombre</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>Combinación única 2</td>
<td>No pueden existir dos estados con el mismo código </td>
<td>Código</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="2"><a id="dominio-s47-a14"></a><a href="estado-entrega.md#dominio-s47-v4">Consultar estado por identificador</a></td>
<td colspan="4">Acción que permite consultar un EstadoEntrega por su identificador.</td>
<td>id</td>
<td>Identificador único universal</td>
<td>Contiene el identificador del estado que se desea consultar.</td>
<td>EstadoEntrega</td>
<td colspan="4">Contiene la información del estado consultado.</td>
<td>P-EEN-0001</td>
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
<td colspan="2"><a id="dominio-s47-a15"></a><a href="estado-entrega.md#dominio-s47-w4">Consultar estados por filtro</a></td>
<td colspan="4">Acción que permite consultar los estados por sus atributos o consultar todos si el filtro está vacío.</td>
<td>Filtro</td>
<td>EstadoEntrega</td>
<td>Contiene los criterios de consulta: identificador, código y nombre.</td>
<td>Lista de EstadoEntrega</td>
<td colspan="4">Contiene los estados que coinciden con el filtro.</td>
<td>P-EEN-0001</td>
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


<a id="dominio-s48"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s48-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Código que permite identificar el estado</td>
<td>Nombre del estado</td>
<td>No pueden existir dos estados con el mismo nombre</td>
<td>No pueden existir dos estados con el mismo código </td>
</tr>
<tr>
<td>ID</td>
<td>Código</td>
<td>Nombre</td>
<td>Combinación única 1</td>
<td>Combinación única 2</td>
</tr>
<tr>
<td>1</td>
<td>ENT-01</td>
<td>Pendiente</td>
<td>Pendiente</td>
<td>ENT-01</td>
</tr>
<tr>
<td><a id="dominio-s48-a5"></a>2</td>
<td>ENT-02</td>
<td>En tránsito</td>
<td>En tránsito</td>
<td>ENT-02</td>
</tr>
<tr>
<td>3</td>
<td>ENT-03</td>
<td>Entregada</td>
<td>Entregada</td>
<td>ENT-03</td>
</tr>
<tr>
<td>4</td>
<td>ENT-04</td>
<td>Cancelada</td>
<td>Cancelada</td>
<td>ENT-04</td>
</tr>
<tr>
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
</tr>
<tr>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinacion unica 1</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinación única 2</td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s49"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s49-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">EstadoEntrega</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa cada uno de los estados disponibles para una entrega</td>
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
<td>Consultar EstadoEntrega</td>
<td>Permite consultar un estado por identificador, por filtro o todos los estados del catálogo.</td>
<td>EstadoEntrega</td>
<td></td>
<td></td>
<td><a href="estado-entrega.md#dominio-s50-a5">P-EEN-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Estado consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s50"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s50-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">EstadoEntrega</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa cada uno de los estados disponibles para una entrega</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s50-a5"></a>P-EEN-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>EstadoEntrega</td>
<td></td>
</tr>
</table>
