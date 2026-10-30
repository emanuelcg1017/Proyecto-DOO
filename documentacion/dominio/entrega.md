# Entrega

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s39) · [Datos de ejemplo](#dominio-s40) · [Políticas](#dominio-s42) · [Eventos y colaboración](#dominio-s41)

<a id="dominio-s39"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s39-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">Entrega</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Proceso mediante el cual el pedido es transportado y entregado al cliente</td>
<td></td>
<td></td>
<td></td>
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
<td><a id="dominio-s39-v4"></a><a href="entrega.md#dominio-s39-a18">Registra la informacion de una nueva entrega</a></td>
<td><a id="dominio-s39-w4"></a><a href="entrega.md#dominio-s39-a23">Consultar informacion de unaentrega por su identificador</a></td>
<td colspan="2"><a id="dominio-s39-x4"></a><a href="entrega.md#dominio-s39-a24">Consultar informacion de entrega</a></td>
<td colspan="2"><a id="dominio-s39-z4"></a><a href="entrega.md#dominio-s39-a25">Actualizar el estado de un servicio</a></td>
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
<td>Requerido</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
<td>Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>CodigoEntrega</td>
<td>Código que identifica la entrega como referencia para su seguimiento y gestión durante la operación logística.</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>30</td>
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
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>FechaEntrega</td>
<td>Fecha en la que se registra la entrega de la mercancía al destinatario final.</td>
<td>No</td>
<td>Fecha</td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td><code>#REF!</code></td>
<td>Identifica el estado actual de la entrega</td>
<td>No</td>
<td><a href="estado-entrega.md#dominio-s47-a1">EstadoEntrega</a></td>
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
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
</tr>
<tr>
<td>Persona</td>
<td>Identifica a la persona que recibe la entrega</td>
<td>No</td>
<td><a href="persona.md#dominio-s79-a1">Persona</a></td>
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
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>No Modificable</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Combinación única 1</td>
<td>No puede haber más de una entrega con el mismo codigo de entrega</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="5" colspan="2"><a id="dominio-s39-a18"></a><a href="entrega.md#dominio-s39-v4">Registra la informacion de una nueva entrega</a></td>
<td rowspan="5" colspan="4">Acción que permite llevar a cabo el registro de la información de la entrega</td>
<td rowspan="5">Datos</td>
<td rowspan="5">Entrega</td>
<td rowspan="5">Contiene la información requerida para llevar a cabo el registro de la nueva entrega</td>
<td rowspan="5"></td>
<td rowspan="5" colspan="4"></td>
<td>P-ENT-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
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
<td>P-ENT-0002</td>
<td>Asegurar que el identiticador generado para la entrega ya no esté siendo utilizado por otra entrega</td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td>Continuar operacion</td>
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
<td>P-ENT-0003</td>
<td>Asegurar que no exista otra entrega registrada con el mismo numero de entrega</td>
<td>Generar una excepción indicándole al usuario que ya existe una entrega registrada con la misma combinación de nombre y direccion</td>
<td>Detener operacion</td>
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
<td>P-ENT-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
<td>Detener operacion</td>
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
<td>P-ENT-0005</td>
<td>Asegurar que la persona que esta siendo utilizada para registrar la información de la nueva entrega exista</td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
<td>Detener operacion</td>
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
<td colspan="2"><a id="dominio-s39-a23"></a><a href="entrega.md#dominio-s39-w4">Consultar informacion de unaentrega por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una entrega especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la entrega que se va a consultar</td>
<td>Entrega</td>
<td colspan="4">Contiene la informacion de la entrega consultada por su id</td>
<td>P-ENT-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
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
<td colspan="2"><a id="dominio-s39-a24"></a><a href="entrega.md#dominio-s39-x4">Consultar informacion de entrega</a></td>
<td colspan="4">Accion que permite obtener un listado de las entregas registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Entrega</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Entrega&gt;</td>
<td colspan="4">Contiene la informacion de todas las entregas que cumplen con el filtro de consulta</td>
<td>P-ENT-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s39-a25"></a><a href="entrega.md#dominio-s39-z4">Actualizar el estado de un servicio</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar el estado de una entrega que se encuentra registrada en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Entrega</td>
<td rowspan="4">Contiene el estado actualizado de la entrega que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-ENT-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
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
<td>P-ENT-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
<td>Detener operacion</td>
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
<td>P-ENT-0006</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Generar una excepción indicándole al usuario que el estado a modificar es igual al estado actual del servicio</td>
<td>Detener operacion</td>
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
<td>P-ENT-0007</td>
<td>Asegurar que la transición para cambiar el estado de entrega sea válida.</td>
<td>Generar una excepción indicando que la transición solicitada no está permitida.</td>
<td>Detener operacion</td>
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
</table>


<a id="dominio-s40"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s40-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Código que identifica la entrega como referencia para su seguimiento y gestión durante la operación logística.</td>
<td>Fecha en la que se registra la entrega de la mercancía al destinatario final.</td>
<td>Identifica el estado actual de la entrega</td>
<td>Identifica a la persona que recibe la entrega</td>
<td>No puede haber más de una entrega con el mismo codigo de entrega</td>
</tr>
<tr>
<td>ID</td>
<td>CodigoEntrega</td>
<td>FechaEntrega</td>
<td><a href="estado-entrega.md#dominio-s48-a5">EstadoEntrega</a></td>
<td><a href="persona.md#dominio-s80-a1">Persona</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>ENT-001</td>
<td>2026-10-08</td>
<td>Entregada</td>
<td>Cédula-1017930467</td>
<td>ENT-001</td>
</tr>
<tr>
<td>2</td>
<td>ENT-002</td>
<td>2026-11-08</td>
<td>Entregada</td>
<td>Cédula-1041325675</td>
<td>ENT-002</td>
</tr>
<tr>
<td>3</td>
<td>ENT-003</td>
<td>2026-12-08</td>
<td>En tránsito</td>
<td>Cédula-1034777725</td>
<td>ENT-003</td>
</tr>
<tr>
<td>4</td>
<td>ENT-004</td>
<td>13/08/2026</td>
<td>Pendiente</td>
<td>Cédula-1017930467</td>
<td>ENT-004</td>
</tr>
<tr>
<td>5</td>
<td>ENT-005</td>
<td>14/08/2026</td>
<td>Entregada</td>
<td>Cédula-1041325675</td>
<td>ENT-005</td>
</tr>
<tr>
<td>6</td>
<td>ENT-006</td>
<td>15/08/2026</td>
<td>Pendiente</td>
<td>Cédula-1034777725</td>
<td>ENT-006</td>
</tr>
<tr>
<td>7</td>
<td>ENT-007</td>
<td>16/08/2026</td>
<td>Cancelada</td>
<td>Cédula-1017930467</td>
<td>ENT-007</td>
</tr>
<tr>
<td>8</td>
<td>ENT-008</td>
<td>17/08/2026</td>
<td>Entregada</td>
<td>Cédula-1041325675</td>
<td>ENT-008</td>
</tr>
<tr>
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
</tr>
<tr>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s41"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s41-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Entrega</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Proceso mediante el cual el pedido es transportado y entregado al cliente</td>
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
<td rowspan="5">Administrador del sistema</td>
<td rowspan="5">Registrar entrega</td>
<td rowspan="5">Permite registrar una entrega que debe ser ejecutada dentro de un servicio logístico.</td>
<td rowspan="5">Entrega</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="entrega.md#dominio-s42-a5">P-ENT-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="5"></td>
<td rowspan="5">Entrega registrada</td>
<td rowspan="5"></td>
</tr>
<tr>
<td><a href="entrega.md#dominio-s42-a6">P-ENT-0002</a></td>
<td>Asegurar que el identiticador generado para la entrega ya no esté siendo utilizado por otra entrega</td>
</tr>
<tr>
<td><a href="entrega.md#dominio-s42-a7">P-ENT-0003</a></td>
<td>Asegurar que no exista otra entrega registrada con el mismo numero de entrega</td>
</tr>
<tr>
<td>EstadoEntrega</td>
<td>Validar que la estado asignada a la nueva entrega sea real y este registrada</td>
<td><a href="entrega.md#dominio-s42-a8">P-ENT-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td>Persona</td>
<td>Validar que la persona asignada a la nueva entrega sea real y este registrada</td>
<td><a href="entrega.md#dominio-s42-a9">P-ENT-0005</a></td>
<td>Asegurar que la persona que esta siendo utilizada para registrar la información de la nueva entrega exista</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar entrega</td>
<td>Permite consultar las entregas según un criterio de búsqueda.</td>
<td>Entrega</td>
<td></td>
<td></td>
<td><a href="entrega.md#dominio-s42-a5">P-ENT-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Entrega consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar estado de entrega</td>
<td rowspan="4">Permite actualizar el estado de una entrega de acuerdo con su resultado operativo.</td>
<td rowspan="4">Entrega</td>
<td></td>
<td></td>
<td><a href="entrega.md#dominio-s42-a5">P-ENT-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Estado de entrega actualizado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>EstadoEntrega</td>
<td>Validar que la estado asignada a la  entrega sea real y este registrada</td>
<td><a href="entrega.md#dominio-s42-a8">P-ENT-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="entrega.md#dominio-s42-a10">P-ENT-0006</a></td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
</tr>
<tr>
<td><a href="entrega.md#dominio-s42-a11">P-ENT-0007</a></td>
<td>Asegurar que la transición para cambiar el estado de entrega sea válida.</td>
</tr>
</table>


<a id="dominio-s42"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s42-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Entrega</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Proceso mediante el cual el pedido es transportado y entregado al cliente</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s42-a5"></a>P-ENT-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Entrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s42-a6"></a>P-ENT-0002</td>
<td>Asegurar que el identiticador generado para la entrega ya no esté siendo utilizado por otra entrega</td>
<td>Entrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s42-a7"></a>P-ENT-0003</td>
<td>Asegurar que no exista otra entrega registrada con el mismo numero de entrega</td>
<td>Entrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s42-a8"></a>P-ENT-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>EstadoEntrega</td>
<td><a href="estado-entrega.md#dominio-s50-a5">P-EEN-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s42-a9"></a>P-ENT-0005</td>
<td>Asegurar que la persona que esta siendo utilizada para registrar la información de la nueva entrega exista</td>
<td>Persona</td>
<td><a href="persona.md#dominio-s82-a5">P-PER-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s42-a10"></a>P-ENT-0006</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Entrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s42-a11"></a>P-ENT-0007</td>
<td>Asegurar que la transición para cambiar el estado de entrega sea válida.</td>
<td>TransicionEstadoEntrega</td>
<td><a href="transicion-estado-entrega.md#dominio-s118-a5">P-TSE-0001</a></td>
</tr>
</table>
