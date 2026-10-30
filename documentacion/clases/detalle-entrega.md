# DetalleEntrega

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s22"></a>

## DetalleEntrega

<table>
<tr>
<td><a id="clases-s22-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">DetalleEntrega</td>
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
<td colspan="4">Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
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
<td><a href="entrega.md#clases-s17-a1">Entrega</a></td>
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
<td>Corresponde a</td>
<td colspan="3">Asociación</td>
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
<td>Tiene como origen</td>
<td colspan="3">Asociación</td>
<td><a href="cedi.md#clases-s15-a1">CEDI</a></td>
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
<td>Tiene como destino</td>
<td colspan="3">Asociación</td>
<td><a href="direccion.md#clases-s14-a1">Direccion</a></td>
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
<td>Genera</td>
<td colspan="3">Asociación</td>
<td><a href="costo-recorrido.md#clases-s25-a1">CostoRecorrido</a></td>
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
<td colspan="3"></td>
<td colspan="5">Identificador único del detalle de entrega.</td>
</tr>
<tr>
<td>private</td>
<td>NumeroDetalleEntrega</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica de manera única el detalle de entrega.</td>
</tr>
<tr>
<td>private</td>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Pedido movilizado mediante este detalle de entrega.</td>
</tr>
<tr>
<td>private</td>
<td>Entrega</td>
<td>Otro</td>
<td>Entrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Entrega a la que pertenece este detalle.</td>
</tr>
<tr>
<td>private</td>
<td>CEDIOrigen</td>
<td>Otro</td>
<td>CEDI</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">CEDI desde la cual se inicia el trayecto.</td>
</tr>
<tr>
<td>private</td>
<td>DireccionDestino</td>
<td>Otro</td>
<td>Direccion</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Dirección hacia la cual se dirige el trayecto.</td>
</tr>
<tr>
<td>private</td>
<td>DistanciaKM</td>
<td>Decimal</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Distancia en kilómetros correspondiente al trayecto realizado.</td>
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
<td>DetalleEntrega</td>
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
<td rowspan="6">public</td>
<td rowspan="6">DetalleEntrega</td>
<td rowspan="6">Parametrizado</td>
<td rowspan="6">Inicializa el detalle de entrega con la información del trayecto.</td>
<td>NumeroDetalleEntrega</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número que identifica el detalle de entrega.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Pedido movilizado.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Entrega</td>
<td>Otro</td>
<td>Entrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Entrega correspondiente.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>CEDIOrigen</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">CEDI de origen.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>DireccionDestino</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Dirección de destino.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>DistanciaKM</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Distancia del trayecto en kilómetros.</td>
<td colspan="2"></td>
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
<td>Permite obtener el identificador único del detalle de entrega.</td>
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
<td>Identificador único.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNumeroDetalleEntrega</td>
<td>Getter</td>
<td>no final</td>
<td>Obtiene el número del detalle de entrega.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>-</td>
<td>String</td>
<td></td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setNumeroDetalleEntrega</td>
<td>Setter</td>
<td>no final</td>
<td>Establece el número del detalle de entrega.</td>
<td>NumeroDetalleEntrega</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número que identifica el detalle de entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPedido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el pedido movilizado.</td>
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
<td>Permite establecer el pedido movilizado.</td>
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
<td>getEntrega</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la entrega a la que pertenece.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Entrega</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEntrega</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la entrega correspondiente.</td>
<td>Entrega</td>
<td>Otro</td>
<td>Entrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Entrega correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getCEDIOrigen</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el CEDI de origen.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>CEDI</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setCEDIOrigen</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la CEDI de origen.</td>
<td>CEDIOrigen</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>CEDI de origen.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDireccionDestino</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la dirección de destino.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setDireccionDestino</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la dirección de destino.</td>
<td>DireccionDestino</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Dirección de destino.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDistanciaKM</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la distancia del trayecto en kilómetros.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Decimal</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setDistanciaKM</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la distancia del trayecto.</td>
<td>DistanciaKM</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Distancia del trayecto en kilómetros.</td>
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
<td>Permite registrar la información de un nuevo detalle de entrega.</td>
<td>Datos</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar el detalle de entrega.</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de un detalle de entrega utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador del detalle de entrega que se desea consultar.</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener los detalles de entrega registrados que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los detalles de entrega.</td>
<td>Otro</td>
<td>List&lt;DetalleEntrega&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
