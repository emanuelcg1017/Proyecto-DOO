# Preliquidacion

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s27"></a>

## Preliquidacion

<table>
<tr>
<td><a id="clases-s27-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Preliquidacion</td>
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
<td colspan="4">Representa el cálculo de los costos que se deben reconocer a un tercero por las entregas realizadas.</td>
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
<td>Corresponde a</td>
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
<td>Puede estar</td>
<td colspan="3">Asociación</td>
<td><a href="estado-preliquidacion.md#clases-s31-a1">EstadoPreliquidacion</a></td>
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
<td colspan="5">Identificador único de la preliquidación.</td>
</tr>
<tr>
<td>private</td>
<td>NumeroPreliquidacion</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica la preliquidación.</td>
</tr>
<tr>
<td>private</td>
<td>Tercero</td>
<td>Otro</td>
<td>Tercero</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Tercero que recibe el valor de la preliquidación.</td>
</tr>
<tr>
<td>private</td>
<td>CostoRecorrido</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Costo de recorrido al que corresponde la preliquidación.</td>
</tr>
<tr>
<td>private</td>
<td>FechaPreliquidacion</td>
<td>LocalDate</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Fecha de generación de la preliquidación.</td>
</tr>
<tr>
<td>private</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoPreliquidacion</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado actual de la preliquidación, referenciado en EstadoPreliquidacion.</td>
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
<td>Preliquidacion</td>
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
<td rowspan="5">public</td>
<td rowspan="5">Preliquidacion</td>
<td rowspan="5">Parametrizado</td>
<td rowspan="5">Inicializa la preliquidación con sus datos básicos.</td>
<td>NumeroPreliquidacion</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número de la preliquidación.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Tercero</td>
<td>Otro</td>
<td>Tercero</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Tercero correspondiente.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>CostoRecorrido</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Costo de recorrido correspondiente.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>FechaPreliquidacion</td>
<td>LocalDate</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Fecha de la preliquidación.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Estado</td>
<td>Otro</td>
<td>EstadoPreliquidacion</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado inicial de la preliquidación.</td>
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
<td>Permite obtener el identificador único de la preliquidación.</td>
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
<td>getNumeroPreliquidacion</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el número de la preliquidación.</td>
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
<td>setNumeroPreliquidacion</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el número de la preliquidación.</td>
<td>NumeroPreliquidacion</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número de la preliquidación.</td>
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
<td>public</td>
<td>getCostoRecorrido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el costo de recorrido asociado.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setCostoRecorrido</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el costo de recorrido asociado.</td>
<td>CostoRecorrido</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Por valor</td>
<td>no final</td>
<td>Costo correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getFechaPreliquidacion</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la fecha de la preliquidación.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>LocalDate</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setFechaPreliquidacion</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la fecha de la preliquidación.</td>
<td>FechaPreliquidacion</td>
<td>Otro</td>
<td>LocalDate</td>
<td>Por valor</td>
<td>no final</td>
<td>Fecha de la preliquidación.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstado</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado de la preliquidación.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoPreliquidacion</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstado</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado de la preliquidación.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoPreliquidacion</td>
<td>Por valor</td>
<td>no final</td>
<td>Estado de la preliquidación.</td>
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
<td>Generar</td>
<td>static</td>
<td>final</td>
<td>Permite generar una preliquidación correspondiente a los costos que deben reconocerse a un tercero.</td>
<td>Datos</td>
<td>Otro</td>
<td>Preliquidacion</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para generar la preliquidación.</td>
<td>Otro</td>
<td>Preliquidacion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una preliquidación utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la preliquidación que se desea consultar.</td>
<td>Otro</td>
<td>Preliquidacion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las preliquidaciones registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Preliquidacion</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las preliquidaciones.</td>
<td>Otro</td>
<td>List&lt;Preliquidacion&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ActualizarEstado</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar el estado de una preliquidación registrada.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoPreliquidacion</td>
<td>Por valor</td>
<td>no final</td>
<td>Nuevo estado que se asignará a la preliquidación.</td>
<td>Otro</td>
<td>Preliquidacion</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
