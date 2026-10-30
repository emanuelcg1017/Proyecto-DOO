# Entrega

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s17"></a>

## Entrega

<table>
<tr>
<td><a id="clases-s17-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Entrega</td>
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
<td colspan="4">Proceso mediante el cual el pedido es transportado y entregado al cliente</td>
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
<td>Recibe</td>
<td colspan="3">Asociación</td>
<td><a href="persona.md#clases-s11-a1">Persona</a></td>
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
<td>Contiene</td>
<td colspan="3">Composición</td>
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
<td>Pertenece a</td>
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
<td>Tiene</td>
<td colspan="3">Asociación</td>
<td><a href="entrega-tercero.md#clases-s19-a1">EntregaTercero</a></td>
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
<td><a href="estado-entrega.md#clases-s29-a1">EstadoEntrega</a></td>
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
<td colspan="5">Identificador único de la entrega.</td>
</tr>
<tr>
<td>private</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica la entrega.</td>
</tr>
<tr>
<td>private</td>
<td>Fecha</td>
<td>LocalDate</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Fecha de la entrega.</td>
</tr>
<tr>
<td>private</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado actual de la entrega, referenciado en EstadoEntrega.</td>
</tr>
<tr>
<td>private</td>
<td>Persona</td>
<td>Otro</td>
<td>Persona</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Persona que recibe la entrega.</td>
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
<td>Entrega</td>
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
<td rowspan="4">public</td>
<td rowspan="4">Entrega</td>
<td rowspan="4">Parametrizado</td>
<td rowspan="4">Inicializa la entrega con sus datos básicos.</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número de la entrega.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Fecha</td>
<td>LocalDate</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Fecha de la entrega.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Estado</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado inicial de la entrega.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Persona</td>
<td>Otro</td>
<td>Persona</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Persona que recibe la entrega.</td>
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
<td>Permite obtener el identificador único de la entrega.</td>
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
<td>Permite establecer el identificador único de la entrega.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNumero</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el número de la entrega.</td>
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
<td>setNumero</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el número de la entrega.</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getFecha</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la fecha de la entrega.</td>
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
<td>setFecha</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la fecha de la entrega.</td>
<td>Fecha</td>
<td>Otro</td>
<td>LocalDate</td>
<td>Por valor</td>
<td>no final</td>
<td>Fecha de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstado</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado actual de la entrega.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstado</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado de la entrega.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Estado de la entrega.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPersona</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la persona que recibe la entrega.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Persona</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setPersona</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la persona que recibe la entrega.</td>
<td>Persona</td>
<td>Otro</td>
<td>Persona</td>
<td>Por valor</td>
<td>no final</td>
<td>Persona receptora de la entrega.</td>
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
<td>Permite registrar la información de una nueva entrega.</td>
<td>Datos</td>
<td>Otro</td>
<td>Entrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar la entrega.</td>
<td>Otro</td>
<td>Entrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una entrega utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la entrega que se desea consultar.</td>
<td>Otro</td>
<td>Entrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las entregas registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Entrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las entregas que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Entrega&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ActualizarEstado</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar el estado de una entrega registrada.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoEntrega</td>
<td>Por valor</td>
<td>no final</td>
<td>Nuevo estado que se asignará a la entrega.</td>
<td>Otro</td>
<td>Entrega</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
