# Utilidad

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s26"></a>

## Utilidad

<table>
<tr>
<td><a id="clases-s26-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
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
<td colspan="4">Utilidad</td>
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
<td colspan="4">Representa el resultado obtenido al comparar los ingresos generados por la facturación con los costos asociados a la ejecución de los servicios logísticos.</td>
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
<td>Es generada por</td>
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
<td>Recibe ingresos de</td>
<td colspan="3">Asociación</td>
<td><a href="servicio-factura.md#clases-s24-a1">ServicioFactura</a></td>
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
<td>Recibe costos de</td>
<td colspan="3">Asociación</td>
<td><a href="servicio-entrega.md#clases-s23-a1">ServicioEntrega</a></td>
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
<td colspan="5">Identificador único de la utilidad.</td>
</tr>
<tr>
<td>private</td>
<td>Servico</td>
<td>Otro</td>
<td>Servicio</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Servicio al cual pertenece la utilidad.</td>
</tr>
<tr>
<td>private</td>
<td>ValorIngresos</td>
<td>Otro</td>
<td>Decimal</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Suma de los valores de las facturas asociadas al servicio mediante ServicioFactura.</td>
</tr>
<tr>
<td>private</td>
<td>ValorCostos</td>
<td>Otro</td>
<td>Decimal</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Suma de los costos generados por las entregas asociadas al servicio mediante ServicioEntrega.</td>
</tr>
<tr>
<td>private</td>
<td>ValorUtilidad</td>
<td>Otro</td>
<td>Decimal</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Resultado obtenido al restar el valor de los costos al valor de los ingresos del servicio.</td>
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
<td>Utilidad</td>
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
<td>public</td>
<td>Utilidad</td>
<td>Parametrizado</td>
<td>Inicializa una utilidad con los datos requeridos para representar su resultado económico.</td>
<td>Servico</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Servicio al cual pertenece la utilidad.</td>
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
<td>Permite obtener el identificador único de la utilidad.</td>
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
<td>Permite establecer el identificador único de la utilidad.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único de la utilidad.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getServicio</td>
<td>Getter</td>
<td>no final</td>
<td>Obtiene el servicio al cual pertenece la utilidad.</td>
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
<td>Setter</td>
<td>no final</td>
<td>Establece el servicio al cual pertenece la utilidad.</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio al cual pertenece la utilidad.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorIngresos</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el valor de los ingresos del servicio.</td>
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
<td>setValorIngresos</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el valor de los ingresos.</td>
<td>ValorIngresos</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor de los ingresos.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorCostos</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el valor de los costos del servicio.</td>
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
<td>setValorCostos</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el valor de los costos.</td>
<td>ValorCostos</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor de los costos.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorUtilidad</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el valor de la utilidad.</td>
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
<td>setValorUtilidad</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el valor de la utilidad.</td>
<td>ValorUtilidad</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor de la utilidad.</td>
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
<td>Permite generar la utilidad correspondiente a un servicio.</td>
<td>Datos</td>
<td>Otro</td>
<td>Utilidad</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para generar la utilidad.</td>
<td>Otro</td>
<td>Utilidad</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una utilidad utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la utilidad que se desea consultar.</td>
<td>Otro</td>
<td>Utilidad</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las utilidades registradas que cumplen con un filtro de búsqueda.</td>
<td>filtro</td>
<td>Otro</td>
<td>Utilidad</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las utilidades.</td>
<td>Otro</td>
<td>List&lt;Utilidad&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>CalcularValorIngresos</td>
<td>no static</td>
<td>no final</td>
<td>Permite calcular el valor de los ingresos generados por un servicio.</td>
<td>ServicioFactura</td>
<td>Otro</td>
<td>ServicioFactura</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio cuyos ingresos serán calculados.</td>
<td>Otro</td>
<td>Decimal</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>CalcularValorCostos</td>
<td>no static</td>
<td>no final</td>
<td>Permite calcular el valor de los costos generados por un servicio.</td>
<td>ServicioEntrega</td>
<td>Otro</td>
<td>ServicioEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio cuyos costos serán calculados.</td>
<td>Otro</td>
<td>Decimal</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td rowspan="2">public</td>
<td rowspan="2">CalcularValorUtilidad</td>
<td rowspan="2">no static</td>
<td rowspan="2">no final</td>
<td rowspan="2">Permite calcular el valor de la utilidad a partir de los ingresos y costos del servicio.</td>
<td>ValorIngresos</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor de los ingresos del servicio.</td>
<td rowspan="2">Otro</td>
<td rowspan="2">Decimal</td>
<td rowspan="2">Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>ValorCostos</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor de los costos del servicio.</td>
</tr>
</table>
