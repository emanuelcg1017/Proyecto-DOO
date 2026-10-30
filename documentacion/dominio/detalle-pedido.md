# DetallePedido

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s23) · [Datos de ejemplo](#dominio-s24) · [Políticas](#dominio-s26) · [Eventos y colaboración](#dominio-s25)

<a id="dominio-s23"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s23-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">DetallePedido</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa la información específica que permite conocer qué contiene un pedido que debe ser trasladado.</td>
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
<td><a id="dominio-s23-v4"></a><a href="detalle-pedido.md#dominio-s23-a19">Registra la informacion de un nuevo detalle pedido</a></td>
<td><a id="dominio-s23-w4"></a><a href="detalle-pedido.md#dominio-s23-a20">Consultar informacion de un detalle pedido por su identificador</a></td>
<td colspan="2"><a id="dominio-s23-x4"></a><a href="detalle-pedido.md#dominio-s23-a21">Consultar informacion del detalle pedido</a></td>
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
<td>Requerido</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
</tr>
<tr>
<td>NumeroPedido</td>
<td>Identifica el pedido al que pertenece el detalle</td>
<td>No</td>
<td><a href="pedido.md#dominio-s75-a1">Pedido</a></td>
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
</tr>
<tr>
<td>CodigoBarras</td>
<td>Código de barras que identifica las cajas asociadas al detalle del pedido.</td>
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
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
</tr>
<tr>
<td rowspan="3" colspan="2"><a id="dominio-s23-a19"></a><a href="detalle-pedido.md#dominio-s23-v4">Registra la informacion de un nuevo detalle pedido</a></td>
<td rowspan="3" colspan="4">Acción que permite llevar a cabo el registro de la información del nuevo detalle pedido</td>
<td rowspan="3">Datos</td>
<td rowspan="3">DetallePedido</td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el registro del nuevo detalle pedido</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-DPE-0001</td>
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
</tr>
<tr>
<td>P-DPE-0002</td>
<td>Asegurar que el identiticador generado para el detalle pedido ya no esté siendo utilizado por otro detalle pedido</td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td>Continuar operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-DPE-0003</td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle pedido exista </td>
<td>Generar una excepcion indicandole al usuario que ya existe un detalle pedido con la combinacion de nombre y nit</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s23-a20"></a><a href="detalle-pedido.md#dominio-s23-w4">Consultar informacion de un detalle pedido por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un detalle pedido especifico utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del detalle pedido que se va a consultar</td>
<td>DetallePedido</td>
<td colspan="4">Contiene la informacion del detalle pedido consultado por su id</td>
<td>P-DPE-0001</td>
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
</tr>
<tr>
<td colspan="2"><a id="dominio-s23-a21"></a><a href="detalle-pedido.md#dominio-s23-x4">Consultar informacion del detalle pedido</a></td>
<td colspan="4">Accion que permite obtener un listado de los detalle pedido registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>DetallePedido</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;DetallePedido&gt;</td>
<td colspan="4">Contiene la informacion de todos los detalle pedido que cumplen con el filtro de consulta</td>
<td>P-DPE-0001</td>
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
</tr>
</table>


<a id="dominio-s24"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s24-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Identifica el pedido al que pertenece el detalle</td>
<td>Código de barras que identifica las cajas asociadas al detalle del pedido.</td>
</tr>
<tr>
<td>ID</td>
<td><a href="pedido.md#dominio-s76-a1">NumeroPedido</a></td>
<td>CodigoBarras</td>
</tr>
<tr>
<td>1</td>
<td>PED-000001</td>
<td>CB-001-1</td>
</tr>
<tr>
<td>2</td>
<td>PED-000001</td>
<td>CB-001-2</td>
</tr>
<tr>
<td>3</td>
<td>PED-000002</td>
<td>CB-002-1</td>
</tr>
<tr>
<td>4</td>
<td>PED-000003</td>
<td>CB-003-1</td>
</tr>
<tr>
<td>5</td>
<td>PED-000003</td>
<td>CB-003-2</td>
</tr>
<tr>
<td>6</td>
<td>PED-000003</td>
<td>CB-003-3</td>
</tr>
<tr>
<td>7</td>
<td>PED-000004</td>
<td>CB-004-1</td>
</tr>
<tr>
<td>8</td>
<td>PED-000005</td>
<td>CB-005-1</td>
</tr>
<tr>
<td>9</td>
<td>PED-000005</td>
<td>CB-005-2</td>
</tr>
<tr>
<td>10</td>
<td>PED-000006</td>
<td>CB-006-1</td>
</tr>
<tr>
<td>11</td>
<td>PED-000007</td>
<td>CB-007-1</td>
</tr>
<tr>
<td>12</td>
<td>PED-000007</td>
<td>CB-007-2</td>
</tr>
<tr>
<td>13</td>
<td>PED-000008</td>
<td>CB-008-1</td>
</tr>
<tr>
<td>14</td>
<td>PED-000008</td>
<td>CB-008-2</td>
</tr>
<tr>
<td>15</td>
<td>PED-000008</td>
<td>CB-008-3</td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinacion unica 1</td>
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
</tr>
</table>


<a id="dominio-s25"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s25-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">DetallePedido</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa la información específica que permite conocer qué contiene un pedido que debe ser trasladado.</td>
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
<td rowspan="3">Administrador del sistema</td>
<td rowspan="3">Registra la informacion de un nuevo detalle pedido</td>
<td rowspan="3">Permite llevar a cabo el registro de la informacion de un detalle pedido</td>
<td rowspan="3">DetallePedido</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td>P-DPE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">informacion del nuevo detalle de pedido registrada</td>
<td rowspan="3"></td>
</tr>
<tr>
<td>P-DPE-0002</td>
<td>Asegurar que el identiticador generado para el detalle pedido ya no esté siendo utilizado por otro detalle pedido</td>
</tr>
<tr>
<td>Pedido</td>
<td>Validar que el pedido asignado al nuevo detalle pedido sea real y este registrada</td>
<td>P-DPE-0003</td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle pedido exista </td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar detalle pedido</td>
<td>Permite consultar la informacion de los detalles pedido registrados</td>
<td>DetallePedido</td>
<td></td>
<td></td>
<td>P-DPE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Detalle pedido consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s26"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s26-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td colspan="3">DetallePedido</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa la información específica que permite conocer qué contiene un pedido que debe ser trasladado.</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td>P-DPE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>DetallePedido</td>
<td></td>
</tr>
<tr>
<td>P-DPE-0002</td>
<td>Asegurar que el identiticador generado para el detalle pedido ya no esté siendo utilizado por otro detalle pedido</td>
<td>DetallePedido</td>
<td></td>
</tr>
<tr>
<td>P-DPE-0003</td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle pedido exista </td>
<td>Pedido</td>
<td><a href="pedido.md#dominio-s78-a5">P-PED-0001</a></td>
</tr>
</table>
