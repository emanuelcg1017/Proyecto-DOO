# Preliquidación

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s83) · [Datos de ejemplo](#dominio-s84) · [Políticas](#dominio-s86) · [Eventos y colaboración](#dominio-s85)

<a id="dominio-s83"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s83-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">Preliquidación</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa el cálculo de los costos que se deben reconocer a un tercero por las entregas realizadas.</td>
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
<td><a id="dominio-s83-v4"></a><a href="preliquidacion.md#dominio-s83-a20">Generar una preliquidacion</a></td>
<td><a id="dominio-s83-w4"></a><a href="preliquidacion.md#dominio-s83-a26">Consultar informacion de una preliquidacion por su identificador</a></td>
<td colspan="2"><a id="dominio-s83-x4"></a><a href="preliquidacion.md#dominio-s83-a27">Consultar informacion de preliquidacion</a></td>
<td colspan="2"><a id="dominio-s83-z4"></a><a href="preliquidacion.md#dominio-s83-a28">Actualizar el estado de una preliquidacion</a></td>
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
<td>Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>NumeroPreliquidacion</td>
<td>Representa el número que identifica la preliquidación generada para el tercero.</td>
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
<td>No Modificable</td>
</tr>
<tr>
<td>NombreTercero</td>
<td>Representa el nombre del tercero al que corresponde la preliquidación.</td>
<td>No</td>
<td><a href="tercero.md#dominio-s103-a1">Tercero</a></td>
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
<td>No Modificable</td>
</tr>
<tr>
<td>ValorCosto</td>
<td>Representa el valor del costo de recorrido que se reconoce al tercero mediante la preliquidación</td>
<td>No</td>
<td><a href="costo-recorrido.md#dominio-s11-a1">ValorCosto</a></td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>No Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>FechaPreliquidacion</td>
<td>Representa la fecha en la que se genera la preliquidación.</td>
<td>No</td>
<td>Fecha</td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>No Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>EstadoPreliquidacion</td>
<td>Referencia al objeto EstadoPreliquidacion que identifica el estado actual.</td>
<td>No</td>
<td><a href="estado-preliquidacion.md#dominio-s55-a1">EstadoPreliquidacion</a></td>
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
<td>Modificable</td>
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
<td></td>
</tr>
<tr>
<td>Combinación única 1</td>
<td>No puede haber más de una Preliquidación con el mismo número de preliquidación</td>
<td>NumeroPreliquidacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
</tr>
<tr>
<td rowspan="6" colspan="2"><a id="dominio-s83-a20"></a><a href="preliquidacion.md#dominio-s83-v4">Generar una preliquidacion</a></td>
<td rowspan="6" colspan="4">Accion que permite generar el registro del costo de recorrido que debe reconocerse a un tercero por un viaje realizado.</td>
<td rowspan="6">Datos</td>
<td rowspan="6">Preliquidacion</td>
<td rowspan="6">Contiene la información requerida para llevar a cabo la nueva preliquidacion</td>
<td rowspan="6"></td>
<td rowspan="6" colspan="4"></td>
<td>P-PRE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td></td>
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
<td>P-PRE-0002</td>
<td>Asegurar que el identiticador generado para la preliquidacion ya no esté siendo utilizado por otra preliquidacion</td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td></td>
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
<td>P-PRE-0003</td>
<td>Asegurar que no exista otra preliquidacion registrada con el mismo numero de preliquidacion</td>
<td>Generar una excepción indicándole al usuario que ya existe una preliquidacion registrada con el mismo numero de preliquidacion</td>
<td></td>
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
<td>P-PRE-0004</td>
<td>Asegurar que el tercero que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
<td>Generar una excepcion indicandole al usuario que el tercero utilizado para registrar la preliquidacion no existe</td>
<td></td>
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
<td>P-PRE-0005</td>
<td>Asegurar que el costo recorrido que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
<td>Generar una excepcion indicandole al usuario que el costo recorrido utilizado para registrar la preliquidacion no existe</td>
<td></td>
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
<td>P-PRE-0006</td>
<td>Asegurar que el estado referenciado exista</td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
<td></td>
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
<td colspan="2"><a id="dominio-s83-a26"></a><a href="preliquidacion.md#dominio-s83-w4">Consultar informacion de una preliquidacion por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una preliquidacion especifico utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del preliquidacion que se va a consultar</td>
<td>Preliquidacion</td>
<td colspan="4">Contiene la informacion del preliquidacion consultado por su id</td>
<td>P-PRE-0001</td>
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
</tr>
<tr>
<td colspan="2"><a id="dominio-s83-a27"></a><a href="preliquidacion.md#dominio-s83-x4">Consultar informacion de preliquidacion</a></td>
<td colspan="4">Accion que permite obtener un listado de las preliquidaciones registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Preliquidacion</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Preliquidacion&gt;</td>
<td colspan="4">Contiene la informacion de todas las preliquidaciones que cumplen con el filtro de consulta</td>
<td>P-PRE-0001</td>
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
</tr>
<tr>
<td rowspan="4" colspan="2"><a id="dominio-s83-a28"></a><a href="preliquidacion.md#dominio-s83-z4">Actualizar el estado de una preliquidacion</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar el estado de una preliquidacion que se encuentra registrada en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Preliquidacion</td>
<td rowspan="4">Contiene el estado actualizado de la preliquidacion que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-PRE-0001</td>
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
</tr>
<tr>
<td>P-PRE-0006</td>
<td>Asegurar que el estado referenciado exista</td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
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
</tr>
<tr>
<td>P-PRE-0007</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Generar una excepción indicando que la preliquidación ya se encuentra en el estado seleccionado</td>
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
</tr>
<tr>
<td>P-PRE-0008</td>
<td>Asegurar que la transición para cambiar el estado de preliquidacion sea válida.</td>
<td>Generar una excepción indicando que la transición solicitada no está permitida.</td>
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
</tr>
</table>


<a id="dominio-s84"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s84-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Representa el número que identifica la preliquidación generada para el tercero.</td>
<td>Representa el nombre del tercero al que corresponde la preliquidación.</td>
<td>Representa el valor del costo de recorrido que se reconoce al tercero mediante la preliquidación</td>
<td>Representa la fecha en la que se genera la preliquidación.</td>
<td>Referencia al objeto EstadoPreliquidacion que identifica el estado actual.</td>
<td>No puede haber más de una Preliquidación con el mismo número de preliquidación</td>
</tr>
<tr>
<td>ID</td>
<td>NumeroPreliquidacion</td>
<td><a href="tercero.md#dominio-s104-a1">NombreTercero</a></td>
<td><a href="costo-recorrido.md#dominio-s12-a1">ValorCosto</a></td>
<td>FechaPreliquidacion</td>
<td><a href="estado-preliquidacion.md#dominio-s56-a5">EstadoPreliquidacion</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>PRE-0001</td>
<td>Transportes Oriente-890910871-2</td>
<td>COS-0001</td>
<td>21/08/2026</td>
<td>Pagada</td>
<td>PRE-0001</td>
</tr>
<tr>
<td>2</td>
<td>PRE-0002</td>
<td>Contransporte-811001202-8</td>
<td>COS-0002</td>
<td>22/08/2026</td>
<td>Pagada</td>
<td>PRE-0002</td>
</tr>
<tr>
<td>3</td>
<td>PRE-0003</td>
<td>Contransporte-811001202-8</td>
<td>COS-0003</td>
<td>23/08/2026</td>
<td>Pendiente</td>
<td>PRE-0003</td>
</tr>
<tr>
<td>4</td>
<td>PRE-0004</td>
<td>Transportes Oriente-890910871-2</td>
<td>COS-0004</td>
<td>24/08/2026</td>
<td>Pendiente</td>
<td>PRE-0004</td>
</tr>
<tr>
<td>5</td>
<td>PRE-0005</td>
<td>Contransporte-811001202-8</td>
<td>COS-0005</td>
<td>26/08/2026</td>
<td>Pagada</td>
<td>PRE-0005</td>
</tr>
<tr>
<td>6</td>
<td>PRE-0006</td>
<td>Transportes Saferbo-890920990-3</td>
<td>COS-0006</td>
<td>29/08/2026</td>
<td>Pendiente</td>
<td>PRE-0006</td>
</tr>
<tr>
<td>7</td>
<td>PRE-0007</td>
<td>Contransporte-811001202-8</td>
<td>COS-0007</td>
<td>30/08/2026</td>
<td>Pendiente</td>
<td>PRE-0007</td>
</tr>
<tr>
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
</tr>
<tr>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
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
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s85"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s85-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Preliquidación</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa el cálculo de los costos que se deben reconocer a un tercero por las entregas realizadas.</td>
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
<td rowspan="6">Sistema</td>
<td rowspan="6">Generar preliquidación</td>
<td rowspan="6">Permite generar el registro del costo de recorrido que debe reconocerse a un tercero por un viaje realizado.</td>
<td rowspan="6">Preliquidacion</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="preliquidacion.md#dominio-s86-a5">P-PRE-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="6"></td>
<td rowspan="6">Preliquidación generada</td>
<td rowspan="6"></td>
</tr>
<tr>
<td><a href="preliquidacion.md#dominio-s86-a6">P-PRE-0002</a></td>
<td>Asegurar que el identiticador generado para la preliquidacion ya no esté siendo utilizado por otra preliquidacion</td>
</tr>
<tr>
<td><a href="preliquidacion.md#dominio-s86-a7">P-PRE-0003</a></td>
<td>Asegurar que no exista otra preliquidacion registrada con el mismo numero de preliquidacion</td>
</tr>
<tr>
<td>Tercero</td>
<td>Validar que el tercero asignado a la nueva persona sea real y este registrado</td>
<td><a href="preliquidacion.md#dominio-s86-a8">P-PRE-0004</a></td>
<td>Asegurar que el tercero que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
</tr>
<tr>
<td>CostoRecorrido</td>
<td>Validar que el costo recorrido asignado a la nueva persona sea real y este registrado</td>
<td><a href="preliquidacion.md#dominio-s86-a9">P-PRE-0005</a></td>
<td>Asegurar que el costo recorrido que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
</tr>
<tr>
<td>EstadoPreliquidacion</td>
<td>Validar que la estado asignado a la nueva preliquidacion sea real y este registrada</td>
<td><a href="preliquidacion.md#dominio-s86-a10">P-PRE-0006</a></td>
<td>Asegurar que el estado referenciado exista</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar preliquidación</td>
<td>Permite consultar las preliquidaciones generadas para los terceros.</td>
<td>Preliquidacion</td>
<td></td>
<td></td>
<td><a href="preliquidacion.md#dominio-s86-a5">P-PRE-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Preliquidación consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar estado de preliquidación</td>
<td rowspan="4">Permite actualizar el estado de una preliquidación dentro del proceso de reconocimiento y pago al tercero.</td>
<td rowspan="4">Preliquidacion</td>
<td></td>
<td></td>
<td><a href="preliquidacion.md#dominio-s86-a5">P-PRE-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Estado de preliquidación actualizado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>EstadoPreliquidacion</td>
<td>Validar que la estado asignado a la preliquidacion sea real y este registrada</td>
<td><a href="preliquidacion.md#dominio-s86-a10">P-PRE-0006</a></td>
<td>Asegurar que el estado referenciado exista</td>
</tr>
<tr>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="preliquidacion.md#dominio-s86-a11">P-PRE-0007</a></td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
</tr>
<tr>
<td><a href="preliquidacion.md#dominio-s86-a12">P-PRE-0008</a></td>
<td>Asegurar que la transición para cambiar el estado de preliquidacion sea válida.</td>
</tr>
</table>


<a id="dominio-s86"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s86-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Preliquidación</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa el cálculo de los costos que se deben reconocer a un tercero por las entregas realizadas.</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s86-a5"></a>P-PRE-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Preliquidacion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s86-a6"></a>P-PRE-0002</td>
<td>Asegurar que el identiticador generado para la preliquidacion ya no esté siendo utilizado por otra preliquidacion</td>
<td>Preliquidacion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s86-a7"></a>P-PRE-0003</td>
<td>Asegurar que no exista otra preliquidacion registrada con el mismo numero de preliquidacion</td>
<td>Preliquidacion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s86-a8"></a>P-PRE-0004</td>
<td>Asegurar que el tercero que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
<td>Tercero</td>
<td><a href="tercero.md#dominio-s106-a5">P-TER-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s86-a9"></a>P-PRE-0005</td>
<td>Asegurar que el costo recorrido que esta siendo utilizado para registrar la información de la nueva preliquidacion exista</td>
<td>CostoRecorrido</td>
<td><a href="tercero.md#dominio-s106-a5">P-COS-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s86-a10"></a>P-PRE-0006</td>
<td>Asegurar que el estado referenciado exista</td>
<td>EstadoPreliquidacion</td>
<td><a href="estado-preliquidacion.md#dominio-s58-a5">P-EPR-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s86-a11"></a>P-PRE-0007</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Preliquidacion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s86-a12"></a>P-PRE-0008</td>
<td>Asegurar que la transición para cambiar el estado de preliquidacion sea válida.</td>
<td>TransicionEstadoPreliquidacion</td>
<td><a href="transicion-estado-preliquidacion.md#dominio-s126-a5">P-TSP-0001</a></td>
</tr>
</table>
