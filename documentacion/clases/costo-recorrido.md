# CostoRecorrido

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s25"></a>

## CostoRecorrido

<table>
<tr>
<td><a id="clases-s25-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">CostoRecorrido</td>
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
<td colspan="4">Representa el costo generado por un recorrido, calculado de acuerdo con la distancia recorrida y el valor establecido por kilómetro.</td>
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
<td>Es generado por</td>
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
<td>Genera</td>
<td colspan="3">Asociación</td>
<td><a href="preliquidacion.md#clases-s27-a1">Preliquidacion</a></td>
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
<td colspan="5">Identificador único del costo de recorrido.</td>
</tr>
<tr>
<td>private</td>
<td>NumeroCosto</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica de manera única el costo de recorrido.</td>
</tr>
<tr>
<td>private</td>
<td>DetalleEntrega</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Detalle de entrega al que corresponde el costo.</td>
</tr>
<tr>
<td>private</td>
<td>ValorPorKM</td>
<td>Int</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Valor establecido por cada kilómetro recorrido.</td>
</tr>
<tr>
<td>private</td>
<td>ValorCosto</td>
<td>Decimal</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Costo total generado por el recorrido.</td>
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
<td>CostoRecorrido</td>
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
<td rowspan="3">CostoRecorrido</td>
<td rowspan="3">Parametrizado</td>
<td rowspan="3">Inicializa el costo de recorrido con la información necesaria para calcularlo.</td>
<td>NumeroCosto</td>
<td>Sttring</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número que identifica el costo de recorrido.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>DetalleEntrega</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Detalle de entrega correspondiente.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>ValorPorKM</td>
<td>Int</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Valor establecido por kilómetro.</td>
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
<td>Permite obtener el identificador único del costo.</td>
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
<td>Permite establecer el identificador único del costo.</td>
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
<td>getNumeroCosto</td>
<td>Getter</td>
<td>no final</td>
<td>Obtiene el número del costo de recorrido.</td>
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
<td>setNumeroCosto</td>
<td>Setter</td>
<td>no final</td>
<td>Establece el número del costo de recorrido.</td>
<td>NumeroCosto</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número que identifica el costo de recorrido.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDetalleEntrega</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el detalle de entrega relacionado con el costo.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setDetalleEntrega</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el detalle de entrega relacionado.</td>
<td>DetalleEntrega</td>
<td>Otro</td>
<td>DetalleEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Detalle de entrega correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorPorKM</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el valor establecido por kilómetro.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Int</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setValorPorKM</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el valor por kilómetro.</td>
<td>ValorPorKM</td>
<td>Otro</td>
<td>Int</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor establecido por kilómetro.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorCosto</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el costo total del recorrido.</td>
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
<td>setValorCosto</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el costo total calculado.</td>
<td>ValorCosto</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Costo total del recorrido.</td>
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
<td>Permite registrar la información de un nuevo costo de recorrido.</td>
<td>Datos</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar el costo de recorrido.</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de un costo de recorrido utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador del costo de recorrido que se desea consultar.</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener los costos de recorrido registrados que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los costos de recorrido.</td>
<td>Otro</td>
<td>List&lt;CostoRecorrido&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>CalcularValorCosto</td>
<td>no static</td>
<td>no final</td>
<td>Permite calcular el valor del costo generado por un recorrido.</td>
<td>Datos</td>
<td>Otro</td>
<td>CostoRecorrido</td>
<td>Por valor</td>
<td>no final</td>
<td>Información necesaria para calcular el valor del costo del recorrido.</td>
<td>Otro</td>
<td>Decimal</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
