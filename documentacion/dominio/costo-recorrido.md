# CostoRecorrido

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s11) · [Datos de ejemplo](#dominio-s12) · [Políticas](#dominio-s14) · [Eventos y colaboración](#dominio-s13)

<a id="dominio-s11"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s11-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">CostoRecorrido</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa el costo generado por un recorrido, calculado de acuerdo con la distancia recorrida y el valor establecido por kilómetro.</td>
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
<td><a id="dominio-s11-v4"></a><a href="costo-recorrido.md#dominio-s11-a19">Registra la informacion de un nuevo costo recorrido</a></td>
<td><a id="dominio-s11-w4"></a><a href="costo-recorrido.md#dominio-s11-a22">Consultar informacion de un costo recorrido por su identificador</a></td>
<td colspan="2"><a id="dominio-s11-x4"></a><a href="costo-recorrido.md#dominio-s11-a23">Consultar informacion de costo recorrido</a></td>
<td><a id="dominio-s11-z4"></a><a href="costo-recorrido.md#dominio-s11-a24">Calcular ValorCosto</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
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
</tr>
<tr>
<td>NumeroCosto</td>
<td>Código que identifica el costo asociado a un recorrido registrado</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>30</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
</tr>
<tr>
<td>DetalleEntrega</td>
<td>Identifica el detalle de entrega al que corresponde el costo del recorrido y del cual vamos a sacar la distancia en kilometro</td>
<td>No</td>
<td><a href="detalle-entrega.md#dominio-s19-a1">DetalleEntrega</a></td>
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
<td>Requerido</td>
</tr>
<tr>
<td>ValorPorKM</td>
<td>Representa el valor monetario establecido para cada kilómetro recorrido</td>
<td>No</td>
<td>Entero</td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>0</td>
<td>9999999</td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>Requerido</td>
</tr>
<tr>
<td>ValorCosto</td>
<td>Representa el costo generado por el trayecto registrado en un detalle de entrega, de acuerdo con la distancia recorrida y el valor establecido por kilómetro</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>2</td>
<td>Truncamiento</td>
<td>0</td>
<td>999999999</td>
<td></td>
<td>Corresponde al resultado de multiplicar la distancia en kilómetros del detalle de entrega por el valor establecido por kilómetro.<br><br>ValorTotal = DistanciaKM × ValorPorKM.</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>No</td>
<td>No</td>
<td></td>
<td>No</td>
<td>No Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
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
</tr>
<tr>
<td>Nombre combinación única</td>
<td>Descripción</td>
<td>Atributos involucrados</td>
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
<td>Combinación única 1</td>
<td>No puede haber más de un costo de recorrido con el mismo numero costo</td>
<td>NumeroCosto</td>
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
</tr>
<tr>
<td rowspan="2" colspan="2">Responsabilidad</td>
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
</tr>
<tr>
<td rowspan="3" colspan="2"><a id="dominio-s11-a19"></a><a href="costo-recorrido.md#dominio-s11-v4">Registra la informacion de un nuevo costo recorrido</a></td>
<td rowspan="3" colspan="4">Acción que permite llevar a cabo el registro de la información del costo recorrido</td>
<td rowspan="3">Datos</td>
<td rowspan="3">CostoRecorrido</td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el registro del nuevo costo recorrido</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-COS-0001</td>
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
</tr>
<tr>
<td>P-COS-0002</td>
<td>Asegurar que el identiticador generado para el costo recorrido ya no esté siendo utilizado por otro costo recorrido </td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td>Continuar operacion</td>
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
<td>P-COS-0003</td>
<td>Asegurar que la distancia utilizada para calcular el costo corresponda al trayecto registrado en el detalle de entrega.</td>
<td>Generar una excepción indicando que la distancia utilizada no corresponde al trayecto registrado en el detalle de entrega.</td>
<td>Detener operacion</td>
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
<td colspan="2"><a id="dominio-s11-a22"></a><a href="costo-recorrido.md#dominio-s11-w4">Consultar informacion de un costo recorrido por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un costo recorrido especifico utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del costo recorrido que se va a consultar</td>
<td>Costo Recorrido</td>
<td colspan="4">Contiene la informacion del costo recorrido consultado por su id</td>
<td>P-COS-0001</td>
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
</tr>
<tr>
<td colspan="2"><a id="dominio-s11-a23"></a><a href="costo-recorrido.md#dominio-s11-x4">Consultar informacion de costo recorrido</a></td>
<td colspan="4">Accion que permite obtener un listado de los costo recorrido registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>CostoRecorrido</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;CostoRecorrido&gt;</td>
<td colspan="4">Contiene la informacion de todas los costo recorrido que cumplen con el filtro de consulta</td>
<td>P-COS-0001</td>
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
</tr>
<tr>
<td colspan="2"><a id="dominio-s11-a24"></a><a href="costo-recorrido.md#dominio-s11-z4">Calcular ValorCosto</a></td>
<td colspan="4">Acción que permite determinar el costo generado por el recorrido a partir de la distancia registrada y el valor establecido por kilómetro</td>
<td>Datos</td>
<td>CostoRecorrido</td>
<td>Contiene la información requerida para llevar a cabo el calculo del valor costo</td>
<td></td>
<td colspan="4"></td>
<td>P-COS-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Continuar operacion</td>
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


<a id="dominio-s12"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s12-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Código que identifica el costo asociado a un recorrido registrado</td>
<td>Identifica el detalle de entrega al que corresponde el costo del recorrido y del cual vamos a sacar la distancia en kilometro</td>
<td>Representa el valor monetario establecido para cada kilómetro recorrido</td>
<td>Representa el costo generado por el trayecto registrado en un detalle de entrega, de acuerdo con la distancia recorrida y el valor establecido por kilómetro</td>
<td>No puede haber más de un costo de recorrido con el mismo numero costo</td>
</tr>
<tr>
<td>ID</td>
<td>NumeroCosto</td>
<td><a href="detalle-entrega.md#dominio-s20-a1">DetalleEntrega</a></td>
<td>ValorPorKM</td>
<td>ValorCosto</td>
<td>Combinacion unica</td>
</tr>
<tr>
<td>1</td>
<td>COS-0001</td>
<td>DET-001</td>
<td>3000</td>
<td>85200</td>
<td>COS-0001</td>
</tr>
<tr>
<td>2</td>
<td>COS-0002</td>
<td>DET-002</td>
<td>3000</td>
<td>28800</td>
<td>COS-0002</td>
</tr>
<tr>
<td>3</td>
<td>COS-0003</td>
<td>DET-003</td>
<td>3000</td>
<td>26100</td>
<td>COS-0003</td>
</tr>
<tr>
<td>4</td>
<td>COS-0004</td>
<td>DET-004</td>
<td>3000</td>
<td>23400</td>
<td>COS-0004</td>
</tr>
<tr>
<td>5</td>
<td>COS-0005</td>
<td>DET-005</td>
<td>3000</td>
<td>17700</td>
<td>COS-0005</td>
</tr>
<tr>
<td>6</td>
<td>COS-0006</td>
<td>DET-006</td>
<td>3000</td>
<td>52500</td>
<td>COS-0006</td>
</tr>
<tr>
<td>7</td>
<td>COS-0007</td>
<td>DET-007</td>
<td>3000</td>
<td>20400</td>
<td>COS-0007</td>
</tr>
<tr>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s13"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s13-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">CostoRecorrido</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa el costo generado por un recorrido, calculado de acuerdo con la distancia recorrida y el valor establecido por kilómetro.</td>
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
<td rowspan="3">Administrador del sistema</td>
<td rowspan="3">Registrar costo de recorrido</td>
<td rowspan="3">Permite registrar el valor establecido por kilómetro para un recorrido.</td>
<td rowspan="3">CostoRecorrido</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="costo-recorrido.md#dominio-s14-a5">P-COS-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">Costo de recorrido registrado</td>
<td rowspan="3"></td>
</tr>
<tr>
<td><a href="costo-recorrido.md#dominio-s14-a6">P-COS-0002</a></td>
<td>Asegurar que el identiticador generado para el costo recorrido ya no esté siendo utilizado por otro costo recorrido </td>
</tr>
<tr>
<td>DetalleEntrega</td>
<td>Validar que la Distanciakm asignada al nuevo costo recorrido sea real y este registrada</td>
<td><a href="costo-recorrido.md#dominio-s14-a7">P-COS-0003</a></td>
<td>Asegurar que la distancia utilizada para calcular el costo corresponda al trayecto registrado en el detalle de entrega.</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar costo recorrido</td>
<td>Permite consultar los costos recorridos</td>
<td>CostoRecorrido</td>
<td></td>
<td></td>
<td>P-COS-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Costo recorrido consultado</td>
<td></td>
</tr>
<tr>
<td>Sistema</td>
<td>Calcular ValorCosto</td>
<td>Permite determinar el costo generado por el recorrido a partir de la distancia registrada y el valor establecido por kilómetro.</td>
<td>CostoRecorrido</td>
<td></td>
<td></td>
<td><a href="costo-recorrido.md#dominio-s14-a5">P-COS-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Valor del costo calculado</td>
<td></td>
</tr>
</table>


<a id="dominio-s14"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s14-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">CostoRecorrido</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa el costo generado por un recorrido, calculado de acuerdo con la distancia recorrida y el valor establecido por kilómetro.</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s14-a5"></a>P-COS-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>CostoRecorrido</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s14-a6"></a>P-COS-0002</td>
<td>Asegurar que el identiticador generado para el costo recorrido ya no esté siendo utilizado por otro costo recorrido </td>
<td>CostoRecorrido</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s14-a7"></a>P-COS-0003</td>
<td>Asegurar que la distancia utilizada para calcular el costo corresponda al trayecto registrado en el detalle de entrega.</td>
<td>DetalleEntrega</td>
<td><a href="detalle-entrega.md#dominio-s22-a5">P-DET-0001</a></td>
</tr>
</table>
