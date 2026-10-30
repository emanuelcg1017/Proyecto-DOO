# Pais

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s4"></a>

## Pais

<table>
<tr>
<td><a id="clases-s4-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Departamento</td>
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
<td colspan="4">Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
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
<td>Es usado por</td>
<td colspan="3">Composición</td>
<td><a href="departamento.md#clases-s10-a1">Departamento</a></td>
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
<td colspan="3"> </td>
<td colspan="5">Identificador único del pais</td>
</tr>
<tr>
<td>private</td>
<td>Nombre</td>
<td>String</td>
<td> </td>
<td>no final</td>
<td>no static</td>
<td colspan="3"> </td>
<td colspan="5">Nombre del país registrado en el sistema</td>
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
<td>Pais</td>
<td>Defecto</td>
<td> Crea una instancia de la clase Pais sin recibir información por parámetro</td>
<td></td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td colspan="3"> </td>
<td colspan="2"> </td>
</tr>
<tr>
<td>public</td>
<td>Pais</td>
<td>Parametrizado</td>
<td>Crea una instancia de la clase Pais inicializando sus atributos</td>
<td>Nombre</td>
<td>String</td>
<td> </td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Nombre que tendrá el país.</td>
<td colspan="2"> </td>
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
<td>Método encargado de obtener el identificador único del país.</td>
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
<td>Método encargado de establecer el identificador único del país.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único que tendrá el país.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNombre</td>
<td>getter</td>
<td>no final</td>
<td>Método encargado de obtener el nombre del país.</td>
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
<td>Método encargado de establecer el nombre del país.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Nombre que tendrá el país.</td>
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
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite consultar la información de un país a partir de su identificador.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador del país que se desea consultar.</td>
<td>Otro</td>
<td>Pais</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>no final</td>
<td>Permite consultar los países registrados que cumplen con los criterios establecidos en el filtro.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Pais</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los países que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Pais&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
