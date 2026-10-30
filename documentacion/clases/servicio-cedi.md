# ServicioCEDI

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s21"></a>

## ServicioCEDI

<table>
<tr>
<td><a id="clases-s21-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">ServicioCEDI</td>
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
<td colspan="4">Representa la relación entre un servicio, un CEDI y los pedidos que deben ser gestionados desde dicho CEDI para la ejecución del servicio</td>
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
<td>Corresponde a</td>
<td colspan="3">Asociación</td>
<td><a href="servicio.md#clases-s16-a1">Servicio</a></td>
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
<td colspan="5">Identificador único de la asociación.</td>
</tr>
<tr>
<td>private</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Servicio en el que participa el CEDI.</td>
</tr>
<tr>
<td>private</td>
<td>CEDI</td>
<td>Otro</td>
<td>CEDI</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Centro de distribución asignado.</td>
</tr>
<tr>
<td>private</td>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Pedido asignado al CEDI dentro del servicio.</td>
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
<td>ServicioCEDI</td>
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
<td rowspan="3">public</td>
<td rowspan="3">ServicioCEDI</td>
<td rowspan="3">Parametrizado</td>
<td rowspan="3">Inicializa la asignación del pedido al CEDI dentro del servicio.</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Servicio correspondiente.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>CEDI</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">CEDI asignado.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Pedido</td>
<td>Otro</td>
<td>Pedido</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Pedi</td>
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
<td>Permite obtener el identificador único de la asociación.</td>
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
<td>Permite establecer el identificador único.</td>
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
<td>getServicio</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el servicio correspondiente.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setServicio</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el servicio correspondiente.</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getCEDI</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el CEDI asignado.</td>
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
<td>setCEDI</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el CEDI asignado.</td>
<td>CEDI</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>CEDI correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPedido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el pedido asignado.</td>
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
<td>Permite establecer el pedido asignado.</td>
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
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una relación ServicioCEDI utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la relación ServicioCEDI que se desea consultar.</td>
<td>Otro</td>
<td>ServicioCEDI</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las relaciones ServicioCEDI que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>ServicioCEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las relaciones ServicioCEDI.</td>
<td>Otro</td>
<td>List&lt;ServicioCEDI&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
