# Pedido

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s75) · [Datos de ejemplo](#dominio-s76) · [Políticas](#dominio-s78) · [Eventos y colaboración](#dominio-s77)

<a id="dominio-s75"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s75-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Pedido</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa aquello que la empresa de venta por catalogo solicita transportar y entregar mediante el servicio logístico contratado</td>
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
<td><a id="dominio-s75-v4"></a><a href="pedido.md#dominio-s75-a16">Registra la informacion de un nuevo Pedido</a></td>
<td><a id="dominio-s75-w4"></a><a href="pedido.md#dominio-s75-a18">Consultar informacion de un pedido por su identificador</a></td>
<td colspan="2"><a id="dominio-s75-x4"></a><a href="pedido.md#dominio-s75-a19">Consultar informacion de los pedidos</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hará único cada objeto de dominio de este tipo. No se puede repetir.</td>
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
<td>Representa el número con el que se identifica el pedido que la empresa de venta por catalogo entrega a la empresa logística para su gestión y posterior entrega.</td>
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
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
</tr>
<tr>
<td>FechaPedido</td>
<td>Representa la fecha en la que se registra el pedido que será gestionado por la operación logística.</td>
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
</tr>
<tr>
<td>Combinación única 1</td>
<td>No puede haber más de un Pedido con el mismo número de pedido.</td>
<td>NumeroPedido</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="3" colspan="2"><a id="dominio-s75-a16"></a><a href="pedido.md#dominio-s75-v4">Registra la informacion de un nuevo Pedido</a></td>
<td rowspan="3" colspan="4">Acción que permite llevar a cabo el registro de la información del pedido</td>
<td rowspan="3">Datos</td>
<td rowspan="3">Pedido</td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el registro del nuevo pedido</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-PED-0001</td>
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
<td>P-PED-0002</td>
<td>Asegurar que el identiticador generado para el pedido ya no esté siendo utilizado por otro pedido</td>
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
<td>P-PED-0003</td>
<td>Asegurar que no exista otro pedido registrado con el mismo numero de pedido</td>
<td>Generar una excepción indicándole al usuario que ya existe un pedido registrado con el mismo pedido</td>
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
<td colspan="2"><a id="dominio-s75-a18"></a><a href="pedido.md#dominio-s75-w4">Consultar informacion de un pedido por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un pedido especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del pedido que se va a consultar</td>
<td>Pedido</td>
<td colspan="4">Contiene la informacion del pedido consultada por su id</td>
<td>P-PED-0001</td>
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
<td colspan="2"><a id="dominio-s75-a19"></a><a href="pedido.md#dominio-s75-x4">Consultar informacion de los pedidos</a></td>
<td colspan="4">Accion que permite obtener un listado de los pedidos registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Pedido</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Pedido&gt;</td>
<td colspan="4">Contiene la informacion de todos los pedidos que cumplen con el filtro de consulta</td>
<td>P-PED-0001</td>
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


<a id="dominio-s76"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s76-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hará único cada objeto de dominio de este tipo. No se puede repetir.</td>
<td>Representa el número con el que se identifica el pedido que la empresa de venta por catalogo entrega a la empresa logística para su gestión y posterior entrega.</td>
<td>Representa la fecha en la que se registra el pedido que será gestionado por la operación logística.</td>
<td>No puede haber más de un Pedido con el mismo número de pedido.</td>
</tr>
<tr>
<td>ID</td>
<td>NumeroPedido</td>
<td>FechaPedido</td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>PED-000001</td>
<td>2026-01-08</td>
<td>PED-000001</td>
</tr>
<tr>
<td>2</td>
<td>PED-000002</td>
<td>2026-02-08</td>
<td>PED-000002</td>
</tr>
<tr>
<td>3</td>
<td>PED-000003</td>
<td>2026-03-08</td>
<td>PED-000003</td>
</tr>
<tr>
<td>4</td>
<td>PED-000004</td>
<td>2026-04-08</td>
<td>PED-000004</td>
</tr>
<tr>
<td>5</td>
<td>PED-000005</td>
<td>2026-05-08</td>
<td>PED-000005</td>
</tr>
<tr>
<td>6</td>
<td>PED-000006</td>
<td>2026-06-08</td>
<td>PED-000006</td>
</tr>
<tr>
<td>7</td>
<td>PED-000007</td>
<td>2026-07-08</td>
<td>PED-000007</td>
</tr>
<tr>
<td>8</td>
<td>PED-000008</td>
<td>2026-08-08</td>
<td>PED-000008</td>
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


<a id="dominio-s77"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s77-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Pedido</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa aquello que la empresa de venta por catalogo solicita transportar y entregar mediante el servicio logístico contratado</td>
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
<td rowspan="3">Registrar pedido</td>
<td rowspan="3">Permite registrar un pedido recibido de una empresa para ser gestionado logísticamente.</td>
<td rowspan="3">Pedido</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="pedido.md#dominio-s78-a5">P-PED-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">Pedido registrado</td>
<td rowspan="3"></td>
</tr>
<tr>
<td><a href="pedido.md#dominio-s78-a6">P-PED-0002</a></td>
<td>Asegurar que el identiticador generado para el pedido ya no esté siendo utilizado por otro pedido</td>
</tr>
<tr>
<td><a href="pedido.md#dominio-s78-a7">P-PED-0003</a></td>
<td>Asegurar que no exista otro pedido registrado con el mismo numero de pedido</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar pedido</td>
<td>Permite consultar los pedidos registrados según un criterio de búsqueda.</td>
<td>Pedido</td>
<td></td>
<td></td>
<td><a href="pedido.md#dominio-s78-a5">P-PED-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Pedido consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s78"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s78-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Pedido</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa aquello que la empresa de venta por catalogo solicita transportar y entregar mediante el servicio logístico contratado</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s78-a5"></a>P-PED-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Pedido</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s78-a6"></a>P-PED-0002</td>
<td>Asegurar que el identiticador generado para el pedido ya no esté siendo utilizado por otro pedido</td>
<td>Pedido</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s78-a7"></a>P-PED-0003</td>
<td>Asegurar que no exista otro pedido registrado con el mismo numero de pedido</td>
<td>Pedido</td>
<td></td>
</tr>
</table>
