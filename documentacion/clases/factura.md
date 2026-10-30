# Factura

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s20"></a>

## Factura

<table>
<tr>
<td><a id="clases-s20-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Factura</td>
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
<td colspan="4">Documento comercial que consolida uno o más pedidos</td>
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
<td>Está asociada a</td>
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
<td>Puede estar</td>
<td colspan="3">Asociación</td>
<td><a href="estado-factura.md#clases-s30-a1">EstadoFactura</a></td>
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
<td colspan="5">Identificador único de la factura.</td>
</tr>
<tr>
<td>private</td>
<td>NumeroFactura</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica la factura.</td>
</tr>
<tr>
<td>private</td>
<td>FechaFactura</td>
<td>LocalDate</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Fecha de emisión de la factura.</td>
</tr>
<tr>
<td>private</td>
<td>ValorTotal</td>
<td>BigDecimal</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Valor total registrado en la factura.</td>
</tr>
<tr>
<td>private</td>
<td>EstadoFactura</td>
<td>Otro</td>
<td>EstadoFactura</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado actual de la factura, referenciado en EstadoFactura.</td>
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
<td>Factura</td>
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
<td>Factura</td>
<td>Parametrizado</td>
<td>Inicializa la factura con sus datos básicos.</td>
<td>NumeroFactura</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número de factura.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>public</td>
<td>Factura</td>
<td>Parametrizado</td>
<td>Inicializa la factura con sus datos básicos.</td>
<td>FechaFactura</td>
<td>Date</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Fecha de factura.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>public</td>
<td>Factura</td>
<td>Parametrizado</td>
<td>Inicializa la factura con sus datos básicos.</td>
<td>ValorTotal</td>
<td>Decimal</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Valor total de la factura.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>public</td>
<td>Factura</td>
<td>Parametrizado</td>
<td>Inicializa la factura con sus datos básicos.</td>
<td>EstadoFactura</td>
<td>Otro</td>
<td>EstadoFactura</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado inicial de la factura.</td>
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
<td>Permite obtener el identificador único de la factura.</td>
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
<td>Permite establecer el identificador único de la factura.</td>
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
<td>getNumeroFactura</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el número de factura.</td>
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
<td>setNumeroFactura</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el número de factura.</td>
<td>NumeroFactura</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número de factura.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getFechaFactura</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la fecha de la factura.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Date</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setFechaFactura</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la fecha de la factura.</td>
<td>FechaFactura</td>
<td>Otro</td>
<td>Date</td>
<td>Por valor</td>
<td>no final</td>
<td>Fecha de factura.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getValorTotal</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el valor total de la factura.</td>
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
<td>setValorTotal</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el valor total de la factura.</td>
<td>ValorTotal</td>
<td>Otro</td>
<td>Decimal</td>
<td>Por valor</td>
<td>no final</td>
<td>Valor total de la factura.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstadoFactura</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado de la factura.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoFactura</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstadoFactura</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado de la factura.</td>
<td>EstadoFactura</td>
<td>Otro</td>
<td>EstadoFactura</td>
<td></td>
<td></td>
<td></td>
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
<td>Permite registrar la información de una nueva factura.</td>
<td>Datos</td>
<td>Otro</td>
<td>Factura</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar la factura.</td>
<td>Otro</td>
<td>Factura</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una factura utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la factura que se desea consultar.</td>
<td>Otro</td>
<td>Factura</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las facturas registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Factura</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las facturas que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Factura&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ActualizarEstado</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar el estado de una factura registrada.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoFactura</td>
<td>Por valor</td>
<td>no final</td>
<td>Nuevo estado que se asignará a la factura.</td>
<td>Otro</td>
<td>Factura</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
