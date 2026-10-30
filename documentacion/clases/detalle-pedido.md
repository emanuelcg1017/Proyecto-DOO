# DetallePedido

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s9"></a>

## DetallePedido

<table>
<tr>
<td><a id="clases-s9-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>Clase</td>
<td colspan="4">DetallePedido</td>
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
<td>Estereotipo</td>
<td colspan="4">class</td>
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
<td>Descripción</td>
<td colspan="4">Representa la información específica que permite conocer qué contiene un pedido que debe ser trasladado.</td>
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
<td>Modificador acceso:</td>
<td colspan="4">public</td>
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
<td>Tipo clase:</td>
<td colspan="4">no final</td>
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
<td colspan="5">Relaciones</td>
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
<td>Relación</td>
<td colspan="3">Tipo relación</td>
<td>Estructura</td>
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
<td>Pertenece a</td>
<td colspan="3">Composición</td>
<td><a href="pedido.md#clases-s5-a1">Pedido</a></td>
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
</tr>
<tr>
<td colspan="14">Atributos</td>
</tr>
<tr>
<td rowspan="2">Modificador de aceso</td>
<td rowspan="2">Nombre</td>
<td colspan="2">Tipo de dato</td>
<td rowspan="2">Tipo modificación atributo</td>
<td rowspan="2">Tipo acceso atributo</td>
<td rowspan="2" colspan="3">Valor por defecto</td>
<td rowspan="2" colspan="5">Descripción atributo</td>
</tr>
<tr>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
</tr>
<tr>
<td>private</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Identificador único del detalle del pedido.</td>
</tr>
<tr>
<td>private</td>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Pedido al que pertenece la caja.</td>
</tr>
<tr>
<td>private</td>
<td>CodigoBarras</td>
<td>String</td>
<td>-</td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Código de barras que identifica la caja del pedido.</td>
</tr>
<tr>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td colspan="3"> </td>
<td colspan="5"> </td>
</tr>
<tr>
<td colspan="14">Constructores</td>
</tr>
<tr>
<td rowspan="2">Modificador de aceso</td>
<td rowspan="2">Nombre</td>
<td rowspan="2">Tipo constructor</td>
<td rowspan="2">Descripción</td>
<td colspan="8">Parámetros</td>
<td rowspan="2" colspan="2">Excepciones</td>
</tr>
<tr>
<td>Nombre</td>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
<td>Tipo parámetro</td>
<td>Tipo modificación atributo</td>
<td colspan="3">Descripción</td>
</tr>
<tr>
<td>private</td>
<td>DetallePedido</td>
<td>Defecto</td>
<td>Crea una instancia vacía de la clase.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td colspan="3"></td>
<td colspan="2"> </td>
</tr>
<tr>
<td rowspan="2">public</td>
<td rowspan="2">DetallePedido</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa el detalle del pedido con sus datos básicos.</td>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Pedido al que pertenece.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>CodigoBarras</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Código de barras de la caja.</td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="14">Métodos accesores</td>
</tr>
<tr>
<td rowspan="2">Modificador de aceso</td>
<td rowspan="2">Nombre</td>
<td rowspan="2">Tipo método accesor</td>
<td rowspan="2">Tipo modificación método</td>
<td rowspan="2">Descripción</td>
<td colspan="6">Parámetros</td>
<td colspan="2">Tipo dato de retorno</td>
<td rowspan="2">Excepciones</td>
</tr>
<tr>
<td>Nombre</td>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
<td>Tipo parámetro</td>
<td>Tipo modificación atributo</td>
<td>Descripción</td>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
</tr>
<tr>
<td>public</td>
<td>getID</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el identificador único del detalle del pedido.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>UUID</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setID</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el identificador único del detalle.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único del detalle.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPedido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el pedido al que pertenece el detalle.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Pedido</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setPedido</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el pedido al que pertenece el detalle.</td>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>Por valor</td>
<td>no final</td>
<td>Pedido correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getCodigoBarras</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el código de barras de la caja.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>String</td>
<td></td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setCodigoBarras</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el código de barras de la caja.</td>
<td>CodigoBarras</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Código de barras de la caja.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="14">Métodos</td>
</tr>
<tr>
<td rowspan="2">Modificador de aceso</td>
<td rowspan="2">Nombre</td>
<td rowspan="2">Tipo acceso método</td>
<td rowspan="2">Tipo modificación método</td>
<td rowspan="2">Descripción</td>
<td colspan="6">Parámetros</td>
<td colspan="2">Tipo dato de retorno</td>
<td rowspan="2">Excepciones</td>
</tr>
<tr>
<td>Nombre</td>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
<td>Tipo parámetro</td>
<td>Tipo modificación atributo</td>
<td>Descripción</td>
<td>Tipo de dato</td>
<td>¿Cuál?</td>
</tr>
<tr>
<td>public</td>
<td>Registrar</td>
<td>static</td>
<td>final</td>
<td>Permite registrar la información de un nuevo detalle de pedido.</td>
<td>Datos</td>
<td>Otro</td>
<td>DetallePedido</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar el detalle del pedido.</td>
<td>Otro</td>
<td>DetallePedido</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de un detalle de pedido utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador del detalle de pedido que se desea consultar.</td>
<td>Otro</td>
<td>DetallePedido</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener los detalles de pedido registrados que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>DetallePedido</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los detalles de pedido.</td>
<td>Otro</td>
<td>List&lt;DetallePedido&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
