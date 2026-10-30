# CEDI

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s15"></a>

## CEDI

<table>
<tr>
<td><a id="clases-s15-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">CEDI</td>
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
<td colspan="4">Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
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
<td>Corresponde a</td>
<td colspan="3">Asociación</td>
<td><a href="direccion.md#clases-s14-a1">Direccion</a></td>
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
<td>Participa en</td>
<td colspan="3">Asociación</td>
<td><a href="municipio.md#clases-s12-a1">Municipio</a></td>
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
<td>Es usado como origen por</td>
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
<td colspan="5">Identificador único del CEDI.</td>
</tr>
<tr>
<td>private</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Nombre que identifica el centro de distribución.</td>
</tr>
<tr>
<td>private</td>
<td>Direccion</td>
<td>Otro</td>
<td>Direccion</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Dirección correspondiente al centro de distribución.</td>
</tr>
<tr>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td colspan="3"> </td>
<td colspan="5"> </td>
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
<td>CEDI</td>
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
<td rowspan="2">public</td>
<td rowspan="2">CEDI</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa el CEDI con sus datos básicos.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Nombre del centro de distribución.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Direccion</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Dirección del centro de distribución.</td>
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
<td>Permite obtener el identificador único del CEDI.</td>
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
<td>Permite establecer el identificador único del CEDI.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único del CEDI.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNombre</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el nombre del CEDI.</td>
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
<td>setNombre</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el nombre del CEDI.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Nombre del CEDI.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDireccion</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la dirección del CEDI.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setDireccion</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la dirección del CEDI.</td>
<td>Direccion</td>
<td>Otro</td>
<td>Direccion</td>
<td>Por valor</td>
<td>no final</td>
<td>Dirección correspondiente al CEDI.</td>
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
<td>Permite registrar la información de un nuevo CEDI.</td>
<td>Datos</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar el CEDI.</td>
<td>Otro</td>
<td>CEDI</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de un CEDI utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador del CEDI que se desea consultar.</td>
<td>Otro</td>
<td>CEDI</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener los CEDI registrados que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los CEDI que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;CEDI&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>Actualizar</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar la información de un CEDI que se encuentra registrado en el sistema.</td>
<td>Datos</td>
<td>Otro</td>
<td>CEDI</td>
<td>Por valor</td>
<td>no final</td>
<td>Información actualizada del CEDI que se desea modificar.</td>
<td>Otro</td>
<td>CEDI</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
