# Servicio

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s16"></a>

## Servicio

<table>
<tr>
<td><a id="clases-s16-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Servicio</td>
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
<td colspan="4">Representa el servicio logístico contratado por una empresa para gestionar el transporte y entrega de sus pedidos</td>
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
<td>Tiene</td>
<td colspan="3">Asociación</td>
<td><a href="empresa-servicio.md#clases-s18-a1">EmpresaServicio</a></td>
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
<td><a href="servicio-cedi.md#clases-s21-a1">ServicioCEDI</a></td>
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
<td>Genera</td>
<td colspan="3">Asociación</td>
<td><a href="utilidad.md#clases-s26-a1">Utilidad</a></td>
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
<td><a href="estado-servicio.md#clases-s28-a1">EstadoServicio</a></td>
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
<td colspan="5">Identificador único del servicio.</td>
</tr>
<tr>
<td>private</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número que identifica el servicio.</td>
</tr>
<tr>
<td>private</td>
<td>Fecha</td>
<td>LocalDate</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Fecha del servicio.</td>
</tr>
<tr>
<td>private</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoServicio</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Estado actual del servicio, referenciado en EstadoServicio.</td>
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
<td>Servicio</td>
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
<td rowspan="3">Servicio</td>
<td rowspan="3">Parametrizado</td>
<td rowspan="3">Inicializa el servicio con sus datos básicos.</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número del servicio.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>Fecha</td>
<td>LocalDate</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Fecha del servicio.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Estado</td>
<td>Otro</td>
<td>EstadoServicio</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Estado inicial del servicio.</td>
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
<td>Permite obtener el identificador único del servicio.</td>
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
<td>Permite establecer el identificador único del servicio.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único del servicio.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNumero</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el número del servicio.</td>
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
<td>Permite establecer el número del servicio.</td>
<td>Numero</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número del servicio.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getFecha</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la fecha del servicio.</td>
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
<td>Permite establecer la fecha del servicio.</td>
<td>Fecha</td>
<td>Otro</td>
<td>LocalDate</td>
<td>Por valor</td>
<td>no final</td>
<td>Fecha del servicio.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getEstado</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el estado actual del servicio.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>EstadoServicio</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEstado</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el estado del servicio.</td>
<td>Estado</td>
<td>Otro</td>
<td>EstadoServicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Estado del servicio.</td>
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
<td>Permite registrar la información de un nuevo servicio.</td>
<td>Datos</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar el servicio.</td>
<td>Otro</td>
<td>Servicio</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de un servicio utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador del servicio que se desea consultar.</td>
<td>Otro</td>
<td>Servicio</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener los servicios registrados que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los servicios que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Servicio&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>FinalizarServicio</td>
<td>no static</td>
<td>no final</td>
<td>Permite finalizar el servicio y generar su utilidad.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador del servicio que se desea finalizar.</td>
<td>Otro</td>
<td>Servicio</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
