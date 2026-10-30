# TransicionEstadoEntrega

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s33"></a>

## TransicionEstadoEntrega

<table>
<tr>
<td><a id="clases-s33-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">TransicionEstadoEntrega</td>
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
<td colspan="4">Representa una transición permitida entre un estado de origen y un estado de destino de la entrega.</td>
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
<td>Da estado origen</td>
<td colspan="3">Asociación</td>
<td><a href="estado-entrega.md#clases-s29-a1">EstadoEntrega</a></td>
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
<td>Da estado destino</td>
<td colspan="3">Asociación</td>
<td><a href="estado-entrega.md#clases-s29-a1">EstadoEntrega</a></td>
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
<td colspan="5">Identificador único de la transición de estado de la entrega.</td>
</tr>
<tr>
<td>private</td>
<td>EstadoOrigen</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado de origen de la entrega.</td>
</tr>
<tr>
<td>private</td>
<td>EstadoDestino</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado de destino de la entrega.</td>
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
<td>TransicionEstadoEntrega</td>
<td>Defecto</td>
<td>Crea una instancia vacía de la clase.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td colspan="3"></td>
<td colspan="2"></td>
</tr>
<tr>
<td rowspan="2">public</td>
<td rowspan="2">TransicionEstadoEntrega</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa la transición con sus estados de origen y destino.</td>
<td>EstadoOrigen</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado de origen de la entrega.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>EstadoDestino</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado de destino de la entrega.</td>
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
<td>Permite obtener el identificador único.</td>
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
<td>Identificador único de la transición de estado de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstadoOrigen</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado de origen.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstadoOrigen</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado de origen.</td>
<td>EstadoOrigen</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Estado de origen de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstadoDestino</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado de destino.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstadoDestino</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado de destino.</td>
<td>EstadoDestino</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Estado de destino de la entrega.</td>
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
<td>Permite consultar una transición de estado a partir de su identificador.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador que se desea consultar.</td>
<td>Otro</td>
<td>TransicionEstadoEntrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorFiltro</td>
<td>no static</td>
<td>no final</td>
<td>Permite consultar las transiciones de estado que cumplen los criterios establecidos en el filtro.</td>
<td>Filtro</td>
<td>Otro</td>
<td>TransicionEstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para realizar la consulta.</td>
<td>Otro</td>
<td>List&lt;TransicionEstadoEntrega&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
