# EntregaTercero

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s19"></a>

## EntregaTercero

<table>
<tr>
<td><a id="clases-s19-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">EntregaTercero</td>
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
<td colspan="4">Representa la relación entre una entrega y un tercero</td>
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
<td><a href="tercero.md#clases-s6-a1">Tercero</a></td>
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
<td>Entrega</td>
<td>Otro</td>
<td>Entrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Entrega que será realizada.</td>
</tr>
<tr>
<td>private</td>
<td>Tercero</td>
<td>Otro</td>
<td>Tercero</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Tercero responsable de realizar la entrega.</td>
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
<td>EntregaTercero</td>
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
<td rowspan="2">EntregaTercero</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa la asociación entre la entrega y el tercero.</td>
<td>Entrega</td>
<td>Otro</td>
<td>Entrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Entrega correspondiente.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Tercero</td>
<td>Otro</td>
<td>Tercero</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Tercero responsable.</td>
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
<td>getEntrega</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la entrega asociada.</td>
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
<td>Permite establecer la entrega asociada.</td>
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
<td>getTercero</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el tercero asociado.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Tercero</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setTercero</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el tercero asociado.</td>
<td>Tercero</td>
<td>Otro</td>
<td>Tercero</td>
<td>Por valor</td>
<td>no final</td>
<td>Tercero correspondiente.</td>
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
<td>Permite obtener la información de una relación EntregaTercero utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la relación EntregaTercero que se desea consultar.</td>
<td>Otro</td>
<td>EntregaTercero</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las relaciones EntregaTercero que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>EntregaTercero</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las relaciones EntregaTercero.</td>
<td>Otro</td>
<td>List&lt;EntregaTercero&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
