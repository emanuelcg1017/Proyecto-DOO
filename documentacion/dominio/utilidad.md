# Utilidad

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s131) · [Datos de ejemplo](#dominio-s132) · [Políticas](#dominio-s134) · [Eventos y colaboración](#dominio-s133)

<a id="dominio-s131"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s131-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">Utilidad</td>
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
<td colspan="20">Representa el resultado obtenido al comparar los ingresos generados por la facturación con los costos asociados a la ejecución de los servicios logísticos.</td>
<td></td>
<td></td>
<td></td>
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
<td><a id="dominio-s131-v4"></a><a href="utilidad.md#dominio-s131-a15">Generar Utilidad</a></td>
<td><a id="dominio-s131-w4"></a><a href="utilidad.md#dominio-s131-a20">Consultar informacion de una utilidad por su identificador</a></td>
<td colspan="2"><a id="dominio-s131-x4"></a><a href="utilidad.md#dominio-s131-a21">Consultar informacion de preliquidacion</a></td>
<td><a id="dominio-s131-z4"></a><a href="utilidad.md#dominio-s131-a22">Calcular ValorIngresos</a></td>
<td><a id="dominio-s131-aa4"></a><a href="utilidad.md#dominio-s131-a25">Calcular ValorCostos</a></td>
<td><a id="dominio-s131-ab4"></a><a href="utilidad.md#dominio-s131-a28">Calcular ValorUtilidad</a></td>
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
<td>No Requerido</td>
<td>No Requerido</td>
<td>No Requerido</td>
</tr>
<tr>
<td>Servicio</td>
<td>Representa el servicio al cual pertenece la utilidad.</td>
<td>Si</td>
<td><a href="servicio.md#dominio-s87-a1">Servicio</a></td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Aplican las reglas del objeto referenciado.</td>
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
<td>No Requerido</td>
<td>No Requerido</td>
<td>No Requerido</td>
</tr>
<tr>
<td>ValorIngresos</td>
<td>Representa la suma de los valores de las facturas válidas asociadas al servicio.</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>2</td>
<td></td>
<td>0</td>
<td></td>
<td></td>
<td>Corresponde a la suma de los valores totales de las facturas asociadas al servicio.</td>
<td>Si</td>
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
<td>Requerido</td>
<td>Requerido</td>
<td>Requerido</td>
</tr>
<tr>
<td>ValorCostos</td>
<td>Representa la suma de los costos de recorrido generados por los detalles de entrega asociados a las entregas de un mismo servicio.</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>2</td>
<td></td>
<td>0</td>
<td></td>
<td></td>
<td>Corresponde a la suma de los valores totales de los costos de recorrido asociados a las entregas del servicio.</td>
<td>Si</td>
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
<td>Requerido</td>
<td>Requerido</td>
<td>Requerido</td>
</tr>
<tr>
<td>ValorUtilidad</td>
<td>Representa el resultado obtenido al restar el valor de los costos al valor de los ingresos del servicio.</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>2</td>
<td></td>
<td>0</td>
<td></td>
<td></td>
<td>Corresponde al resultado de restar el valor de los costos al valor de los ingresos del servicio. ValorUtilidad = ValorIngresos − ValorCostos</td>
<td>Si</td>
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
<td>No Requerido</td>
<td>No Requerido</td>
<td>No Requerido</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="2" colspan="2"><a id="dominio-s131-a15"></a>Responsabilidad</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="5" colspan="2"><a id="dominio-s131-a20"></a><a href="utilidad.md#dominio-s131-v4">Generar Utilidad</a></td>
<td rowspan="5" colspan="4">Acción que permite llevar generar una nueva utilidad</td>
<td rowspan="5">Datos</td>
<td rowspan="5">Utlidad</td>
<td rowspan="5">Contiene la información requerida para llevar a cabo el registro de la nueva utilidad</td>
<td rowspan="5"></td>
<td rowspan="5" colspan="4"></td>
<td>P-UTI-0001</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-UTI-0002</td>
<td>Asegurar que el identiticador generado para la utilidad ya no esté siendo utilizado por otra utilidad</td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td>Continuar Operacion</td>
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
<td>P-UTI-0003</td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
<td>Generar una excepción indicándole al usuario que el servicio no se encuentra finalizado y, por lo tanto, no es posible generar la utilidad.</td>
<td>Detener operacion</td>
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
<td>P-UTI-0004</td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
<td>Excluir las facturas que se encuentren en estado anulada del cálculo de los ingresos del servicio.</td>
<td>Continuar Operacion</td>
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
<td>P-UTI-0005</td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
<td>Excluir del cálculo los costos que no estén asociados a recorridos realizados.</td>
<td>Continuar operación</td>
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
<td colspan="2"><a id="dominio-s131-a21"></a><a href="utilidad.md#dominio-s131-w4">Consultar informacion de una utilidad por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una utilidad especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la utilidad que se va a consultar</td>
<td>Utilidad</td>
<td colspan="4">Contiene la informacion de la utilidad consultada por su id</td>
<td>P-UTI-0001</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s131-a22"></a><a href="utilidad.md#dominio-s131-x4">Consultar informacion de las utilidades</a></td>
<td colspan="4">Accion que permite obtener un listado de las utilidades registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Utilidad</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Utilidad&gt;</td>
<td colspan="4">Contiene la informacion de todos las utilidades que cumplen con el filtro de consulta</td>
<td>P-UTI-0001</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="3" colspan="2"><a id="dominio-s131-a25"></a><a href="utilidad.md#dominio-s131-z4">Calcular ValorIngresos</a></td>
<td rowspan="3" colspan="4">Acción que permite determinar el valor de los ingresos generados por un servicio a partir de las facturas asociadas al mismo</td>
<td rowspan="3">Datos</td>
<td rowspan="3"></td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el calculo de los ingresos</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-UTI-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operación</td>
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
<td>P-UTI-0003</td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
<td>Generar una excepción indicándole al usuario que el servicio no se encuentra finalizado y, por lo tanto, no es posible generar la utilidad.</td>
<td>Detener operación</td>
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
<td>P-UTI-0004</td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
<td>Excluir las facturas que se encuentren en estado anulada del cálculo de los ingresos del servicio.</td>
<td>Continuar operación</td>
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
<td rowspan="3" colspan="2"><a id="dominio-s131-a28"></a><a href="utilidad.md#dominio-s131-aa4">Calcular ValorCostos</a></td>
<td rowspan="3" colspan="4">Acción que permite determinar el valor de los costos generados por un servicio a partir de los costos asociados a los recorridos realizados</td>
<td rowspan="3">Datos</td>
<td rowspan="3"></td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el calculo de los costos</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-UTI-0001</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-UTI-0003</td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
<td>Generar una excepción indicándole al usuario que el servicio no se encuentra finalizado y, por lo tanto, no es posible generar la utilidad.</td>
<td>Detener operacion</td>
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
<td>P-UTI-0005</td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
<td>Excluir del cálculo los costos que no estén asociados a recorridos realizados.</td>
<td>Continuar operación</td>
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
<td rowspan="4" colspan="2"><a href="utilidad.md#dominio-s131-ab4">Calcular ValorUtilidad</a></td>
<td rowspan="4" colspan="4">Acción que permite determinar el valor de la utilidad de un servicio a partir de los ingresos y costos calculados</td>
<td rowspan="4">Datos</td>
<td rowspan="4"></td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el calculo de la utilidad</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-UTI-0001</td>
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
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-UTI-0003</td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
<td>Generar una excepción indicándole al usuario que el servicio no se encuentra finalizado y, por lo tanto, no es posible generar la utilidad.</td>
<td>Detener operacion</td>
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
<td>P-UTI-0004</td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
<td>Excluir las facturas que se encuentren en estado anulada del cálculo de los ingresos del servicio.</td>
<td>Continuar operación</td>
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
<td>P-UTI-0005</td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
<td>Excluir del cálculo los costos que no estén asociados a recorridos realizados.</td>
<td>Continuar operación</td>
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
</table>


<a id="dominio-s132"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s132-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hará único cada objeto de dominio de este tipo. No se puede repetir.</td>
<td>Representa el servicio al cual pertenece la utilidad.</td>
<td>Representa la suma de los valores de las facturas válidas asociadas al servicio</td>
<td>Representa la suma de los costos de recorrido generados por los detalles de entrega asociados a las entregas de un mismo servicio.</td>
<td>Representa el resultado obtenido al restar el valor de los costos al valor de los ingresos del servicio</td>
</tr>
<tr>
<td>ID</td>
<td><a href="servicio.md#dominio-s88-a1">Servicio</a></td>
<td><a href="servicio-factura.md#dominio-s100-a1">ValorIngresos</a></td>
<td><a href="servicio-entrega.md#dominio-s96-a1">ValorCostos</a></td>
<td>ValorUtilidad</td>
</tr>
<tr>
<td>1</td>
<td>SRV-001</td>
<td>1425000</td>
<td>140100</td>
<td>1284900</td>
</tr>
<tr>
<td>2</td>
<td>SRV-002</td>
<td>820000</td>
<td>23400</td>
<td>796600</td>
</tr>
<tr>
<td>3</td>
<td>SRV-004</td>
<td>720000</td>
<td>90600</td>
<td>629400</td>
</tr>
<tr>
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
</tr>
<tr>
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
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinacion unica 1</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s133"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s133-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Utilidad</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa el resultado obtenido al comparar los ingresos generados por la facturación con los costos asociados a la ejecución de los servicios logísticos.</td>
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
<td rowspan="3">Sistema</td>
<td rowspan="3">Calcular ValorIngresos</td>
<td rowspan="3">Permite determinar los ingresos generados por un servicio a partir de las facturas asociadas al mismo.</td>
<td rowspan="3">Utilidad</td>
<td></td>
<td></td>
<td><a href="utilidad.md#dominio-s134-a5">P-UTI-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">Valor de ingresos calculado</td>
<td rowspan="3"></td>
</tr>
<tr>
<td>Servicio</td>
<td>Consultar el servicio para verificar que se encuentre finalizado antes de generar la utilidad.</td>
<td><a href="utilidad.md#dominio-s134-a7">P-UTI-0003</a></td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
</tr>
<tr>
<td>Factura</td>
<td>Consultar las facturas asociadas al servicio para determinar los ingresos correspondientes.</td>
<td><a href="utilidad.md#dominio-s134-a8">P-UTI-0004</a></td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
</tr>
<tr>
<td rowspan="3">Sistema</td>
<td rowspan="3">Calcular ValorCostos</td>
<td rowspan="3">Permite determinar los costos generados por los recorridos realizados para ejecutar un servicio.</td>
<td rowspan="3">Utilidad</td>
<td></td>
<td></td>
<td><a href="utilidad.md#dominio-s134-a5">P-UTI-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">Valor de costos calculado</td>
<td rowspan="3"></td>
</tr>
<tr>
<td>Servicio</td>
<td>Consultar el servicio para verificar que se encuentre finalizado antes de generar la utilidad.</td>
<td><a href="utilidad.md#dominio-s134-a7">P-UTI-0003</a></td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
</tr>
<tr>
<td>CostoRecorrido</td>
<td>Consultar los costos asociados a los recorridos realizados para determinar los costos del servicio.</td>
<td><a href="utilidad.md#dominio-s134-a9">P-UTI-0005</a></td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
</tr>
<tr>
<td rowspan="4">Sistema</td>
<td rowspan="4">Calcular ValorUtilidad</td>
<td rowspan="4">Permite determinar la utilidad de un servicio a partir de sus ingresos y costos.</td>
<td rowspan="4">Utilidad</td>
<td></td>
<td></td>
<td><a href="utilidad.md#dominio-s134-a5">P-UTI-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Valor de utilidad calculado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>Servicio</td>
<td>Consultar el servicio para verificar que se encuentre finalizado antes de generar la utilidad.</td>
<td><a href="utilidad.md#dominio-s134-a7">P-UTI-0003</a></td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
</tr>
<tr>
<td>Factura</td>
<td>Consultar las facturas asociadas al servicio para determinar los ingresos correspondientes.</td>
<td><a href="utilidad.md#dominio-s134-a8">P-UTI-0004</a></td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
</tr>
<tr>
<td>CostoRecorrido</td>
<td>Consultar los costos asociados a los recorridos realizados para determinar los costos del servicio.</td>
<td><a href="utilidad.md#dominio-s134-a9">P-UTI-0005</a></td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
</tr>
<tr>
<td rowspan="5">Sistema</td>
<td rowspan="5">Generar Utilidad</td>
<td rowspan="5">Permite generar la utilidad correspondiente a un servicio finalizado.</td>
<td rowspan="5">Utilidad</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="utilidad.md#dominio-s134-a5">P-UTI-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="5"></td>
<td rowspan="5">Utilidad generada</td>
<td rowspan="5"></td>
</tr>
<tr>
<td><a href="utilidad.md#dominio-s134-a6">P-UTI-0002</a></td>
<td>Asegurar que el identiticador generado para la utilidad ya no esté siendo utilizado por otra utilidad</td>
</tr>
<tr>
<td>Servicio</td>
<td>Consultar el servicio para verificar que se encuentre finalizado antes de generar la utilidad.</td>
<td><a href="utilidad.md#dominio-s134-a7">P-UTI-0003</a></td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
</tr>
<tr>
<td>Factura</td>
<td>Consultar las facturas asociadas al servicio para determinar los ingresos correspondientes.</td>
<td><a href="utilidad.md#dominio-s134-a8">P-UTI-0004</a></td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
</tr>
<tr>
<td>CostoRecorrido</td>
<td>Consultar los costos asociados a los recorridos realizados para determinar los costos del servicio.</td>
<td><a href="utilidad.md#dominio-s134-a9">P-UTI-0005</a></td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar Utilidad</td>
<td>Permite consultar los  disponibles para identificar una persona.</td>
<td>Utilidad</td>
<td></td>
<td></td>
<td><a href="utilidad.md#dominio-s134-a5">P-UTI-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Utilidad  consultada</td>
<td></td>
</tr>
</table>


<a id="dominio-s134"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s134-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Utilidad</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa el resultado obtenido al comparar los ingresos generados por la facturación con los costos asociados a la ejecución de los servicios logísticos.</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s134-a5"></a>P-UTI-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Utilidad</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s134-a6"></a>P-UTI-0002</td>
<td>Asegurar que el identiticador generado para la utilidad ya no esté siendo utilizado por otra utilidad</td>
<td>Utilidad</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s134-a7"></a>P-UTI-0003</td>
<td>Asegurar que la utilidad solo sea generada para servicios que hayan finalizado</td>
<td>Servicio</td>
<td><a href="servicio.md#dominio-s90-a5">P-SER-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s134-a8"></a>P-UTI-0004</td>
<td>Asegurar que las facturas anuladas no sean consideradas para determinar los ingresos de un servicio</td>
<td>Factura</td>
<td><a href="factura.md#dominio-s66-a5">P-FAC-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s134-a9"></a>P-UTI-0005</td>
<td>Asegurar que para determinar los costos de un servicio solo se consideren los costos de recorrido asociados a entregas realizadas</td>
<td>CostoRecorrido</td>
<td><a href="costo-recorrido.md#dominio-s14-a5">P-COS-0001</a></td>
</tr>
</table>
