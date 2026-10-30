# Direccion

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s14"></a>

## Direccion

<table>
<tr>
<td><a id="clases-s14-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Direccion</td>
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
<td colspan="4">Representa cada una de las ubicaciones específicas de los barrios o veredas donde se realizan las recogidas, entregas o se encuentran los CEDI</td>
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
<td colspan="3">Asociación</td>
<td><a href="barrio.md#clases-s13-a1">Barrio</a></td>
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
<td>Es clasificada por</td>
<td colspan="3">Asociación</td>
<td><a href="tipo-direccion.md#clases-s7-a1">TipoDireccion</a></td>
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
<td>Es usada por</td>
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
<td>Es usada como destino por</td>
<td colspan="3">Asociación</td>
<td><a href="detalle-entrega.md#clases-s22-a1">DetalleEntrega</a></td>
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
<td colspan="3"></td>
<td colspan="5">Identificador único de la dirección.</td>
</tr>
<tr>
<td>private</td>
<td>Barrio</td>
<td>Otro</td>
<td>Barrio</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Barrio o vereda al que pertenece la dirección.</td>
</tr>
<tr>
<td>private</td>
<td>TipoDireccion</td>
<td>Otro</td>
<td>TipoDireccion</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Tipo de ubicación al que corresponde la dirección.</td>
</tr>
<tr>
<td>private</td>
<td>Direccion</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Dirección específica utilizada como ubicación dentro de la operación logística.</td>
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
<td>Direccion</td>
<td>Defecto</td>
<td>Crea una instancia vacía de la clase.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td colspan="2"> </td>
</tr>
<tr>
<td rowspan="3">public</td>
<td rowspan="3">Direccion</td>
<td rowspan="3">Parametrizado</td>
<td rowspan="3">Inicializa la dirección con sus datos básicos.</td>
<td>Barrio</td>
<td>Otro</td>
<td>Barrio</td>
<td>Por valor</td>
<td>no final</td>
<td>Barrio al que pertenece la dirección.</td>
<td></td>
<td></td>
<td colspan="2"> </td>
</tr>
<tr>
<td>TipoDireccion</td>
<td>Otro</td>
<td>TipoDireccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Tipo de dirección correspondiente.</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Direccion</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Dirección específica.</td>
<td></td>
<td></td>
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
<td>Permite obtener el identificador único de la dirección.</td>
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
<td>Permite establecer el identificador único de la dirección.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único de la dirección.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getBarrio</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el barrio al que pertenece la dirección.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Barrio</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setBarrio</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el barrio de la dirección.</td>
<td>Barrio</td>
<td>Otro</td>
<td>Barrio</td>
<td>Por valor</td>
<td>no final</td>
<td>Barrio al que pertenece la dirección.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getTipoDireccion</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el tipo de dirección.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>TipoDireccion</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setTipoDireccion</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el tipo de dirección.</td>
<td>TipoDireccion</td>
<td>Otro</td>
<td>TipoDireccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Tipo de dirección correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDireccion</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la dirección registrada.</td>
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
<td>setDireccion</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la dirección registrada.</td>
<td>Direccion</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Dirección específica.</td>
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
<td>Permite registrar la información de una nueva dirección.</td>
<td>Datos</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar la nueva dirección.</td>
<td>Otro</td>
<td>Direccion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una dirección utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la dirección que se desea consultar.</td>
<td>Otro</td>
<td>Direccion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las direcciones registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las direcciones que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Direccion&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>Actualizar</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar la información de una dirección que se encuentra registrada en el sistema.</td>
<td>Datos</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Información actualizada de la dirección que se desea modificar.</td>
<td>Otro</td>
<td>Direccion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
