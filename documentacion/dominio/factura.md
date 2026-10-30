# Factura

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s63) · [Datos de ejemplo](#dominio-s64) · [Políticas](#dominio-s66) · [Eventos y colaboración](#dominio-s65)

<a id="dominio-s63"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s63-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Factura</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Documento comercial que consolida uno o más pedidos</td>
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
<td><a id="dominio-s63-v4"></a><a href="factura.md#dominio-s63-a18">Registra la informacion de una nueva factura</a></td>
<td><a id="dominio-s63-w4"></a><a href="factura.md#dominio-s63-a22">Consultar informacion de una factura por su identificador</a></td>
<td colspan="2"><a id="dominio-s63-x4"></a><a href="factura.md#dominio-s63-a23">Consultar informacion de factura</a></td>
<td colspan="2"><a id="dominio-s63-z4"></a><a href="factura.md#dominio-s63-a24">Actualizar el estado de una factura</a></td>
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
<td>Numero factura</td>
<td>Número que identifica la factura en el negocio</td>
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
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>FechaFactura</td>
<td>Fecha en que se emite la factura</td>
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
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>Ingresos</td>
<td>Valor total de los servicios de entrega facturados, que constituye el ingreso sobre el cual se calcula la utilidad del servicio logístico.</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>0</td>
<td></td>
<td>0</td>
<td>100.000.000</td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>EstadoFactura</td>
<td>Identifica el estado actual de la factura</td>
<td>No</td>
<td><a href="estado-factura.md#dominio-s51-a1">EstadoFactura</a></td>
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
<td>No puede haber más de una factura con el mismo número</td>
<td>Numero factura</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="4" colspan="2"><a id="dominio-s63-a18"></a><a href="factura.md#dominio-s63-v4">Registra la informacion de una nueva factura</a></td>
<td rowspan="4" colspan="4">Acción que permite llevar a cabo el registro de la información de la factura</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Factura</td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el registro de la nueva factura</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-FAC-0001</td>
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
<td>P-FAC-0002</td>
<td>Asegurar que el identiticador generado para la factura ya no esté siendo utilizado por otra factura </td>
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
<td></td>
</tr>
<tr>
<td>P-FAC-0003</td>
<td>Asegurar que no exista otra factura registrada con el mismo numero de factura </td>
<td>Generar una excepción indicándole al usuario que ya existe una factura registrada con la mismo numero de factura</td>
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
<td>P-FAC-0004</td>
<td>Asegurar que el estado referenciado exista </td>
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
<td colspan="2"><a id="dominio-s63-a22"></a><a href="factura.md#dominio-s63-w4">Consultar informacion de una factura por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una factura especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la factura que se va a consultar</td>
<td>Factura</td>
<td colspan="4">Contiene la informacion de la factura consultada por su id</td>
<td>P-FAC-0001</td>
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
<td colspan="2"><a id="dominio-s63-a23"></a><a href="factura.md#dominio-s63-x4">Consultar informacion de factura</a></td>
<td colspan="4">Accion que permite obtener un listado de las facturas registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Factura</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Factura&gt;</td>
<td colspan="4">Contiene la informacion de todas las facturas que cumplen con el filtro de consulta</td>
<td>P-FAC-0001</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s63-a24"></a><a href="factura.md#dominio-s63-z4">Actualizar el estado de una factura</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar el estado de una factura que se encuentra registrada en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Factura</td>
<td rowspan="4">Contiene la informacion actualizada de la factura que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-FAC-0001</td>
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
<td>P-FAC-0004</td>
<td>Asegurar que el estado referenciado exista </td>
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
<td>P-FAC-0005</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Generar una excepción indicándole al usuario que el estado a modificar es igual al estado actual de la factura</td>
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
<td>P-FAC-0006</td>
<td>Asegurar que la transición para cambiar el estado de factura sea válida.</td>
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


<a id="dominio-s64"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s64-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Número que identifica la factura en el negocio</td>
<td>Fecha en que se emite la factura</td>
<td>Valor total de los servicios de entrega facturados, que constituye el ingreso sobre el cual se calcula la utilidad del servicio logístico.</td>
<td>Identifica el estado actual de la factura</td>
<td>No puede haber más de una factura con el mismo número</td>
</tr>
<tr>
<td>ID</td>
<td>Numero factura</td>
<td>FechaFactura</td>
<td>Ingresos</td>
<td><a href="estado-factura.md#dominio-s52-a5">EstadoFactura</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>FAC-001</td>
<td>15/08/2026</td>
<td>950000</td>
<td>Pagada</td>
<td>FAC-001</td>
</tr>
<tr>
<td>2</td>
<td>FAC-002</td>
<td>15/08/2026</td>
<td>475000</td>
<td>Pagada</td>
<td>FAC-002</td>
</tr>
<tr>
<td>3</td>
<td>FAC-003</td>
<td>16/08/2026</td>
<td>820000</td>
<td>Pendiente</td>
<td>FAC-003</td>
</tr>
<tr>
<td>4</td>
<td>FAC-004</td>
<td>17/08/2026</td>
<td>610000</td>
<td>Pagada</td>
<td>FAC-004</td>
</tr>
<tr>
<td>5</td>
<td>FAC-005</td>
<td>18/08/2026</td>
<td>720000</td>
<td>Pendiente</td>
<td>FAC-005</td>
</tr>
<tr>
<td>6</td>
<td>FAC-006</td>
<td>19/08/2026</td>
<td>560000</td>
<td>Pagada</td>
<td>FAC-006</td>
</tr>
<tr>
<td>7</td>
<td>FAC-007</td>
<td>20/08/2026</td>
<td>880000</td>
<td>Anulada</td>
<td>FAC-007</td>
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


<a id="dominio-s65"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s65-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Factura</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Documento comercial que consolida uno o más pedidos</td>
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
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Registrar factura</td>
<td rowspan="4">Permite registrar una factura generada por los servicios logísticos prestados.</td>
<td rowspan="4">Factura</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="factura.md#dominio-s66-a5">P-FAC-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Factura registrada</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="factura.md#dominio-s66-a6">P-FAC-0002</a></td>
<td>Asegurar que el identiticador generado para la factura ya no esté siendo utilizado por otra factura </td>
</tr>
<tr>
<td><a href="factura.md#dominio-s66-a7">P-FAC-0003</a></td>
<td>Asegurar que no exista otra factura registrada con el mismo numero de factura </td>
</tr>
<tr>
<td>EstadoFactura</td>
<td>Validar que la estado asignado a la nueva factura sea real y este registrada</td>
<td><a href="factura.md#dominio-s66-a8">P-FAC-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar factura</td>
<td>Permite consultar las facturas registradas según un criterio de búsqueda.</td>
<td>Factura</td>
<td></td>
<td></td>
<td><a href="factura.md#dominio-s66-a5">P-FAC-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Factura consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar estado de factura</td>
<td rowspan="4">Permite actualizar el estado de una factura de acuerdo con su situación en el proceso de pago.</td>
<td rowspan="4">Factura</td>
<td></td>
<td></td>
<td><a href="factura.md#dominio-s66-a5">P-FAC-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Estado de factura actualizado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>EstadoFactura</td>
<td>Validar que la estado asignado a la  factura sea real y este registrada</td>
<td><a href="factura.md#dominio-s66-a8">P-FAC-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="factura.md#dominio-s66-a9">P-FAC-0005</a></td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
</tr>
<tr>
<td><a href="factura.md#dominio-s66-a10">P-FAC-0006</a></td>
<td>Asegurar que la transición para cambiar el estado de factura sea válida.</td>
</tr>
</table>


<a id="dominio-s66"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s66-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Factura</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Documento comercial que consolida uno o más pedidos</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s66-a5"></a>P-FAC-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Factura</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s66-a6"></a>P-FAC-0002</td>
<td>Asegurar que el identiticador generado para la factura ya no esté siendo utilizado por otra factura </td>
<td>Factura</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s66-a7"></a>P-FAC-0003</td>
<td>Asegurar que no exista otra factura registrada con el mismo numero de factura </td>
<td>Factura</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s66-a8"></a>P-FAC-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>EstadoFactura</td>
<td><a href="estado-factura.md#dominio-s54-a5">P-EFA-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s66-a9"></a>P-FAC-0005</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Factura</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s66-a10"></a>P-FAC-0006</td>
<td>Asegurar que la transición para cambiar el estado de factura sea válida.</td>
<td>TransicionEstadoFactura</td>
<td><a href="transicion-estado-factura.md#dominio-s122-a5">P-TSF-0001</a></td>
</tr>
</table>
