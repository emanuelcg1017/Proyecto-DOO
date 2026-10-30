# Barrio

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s13"></a>

## Barrio

<table>
<tr>
<td><a id="clases-s13-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Barrio</td>
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
<td colspan="4">Representa a cada uno de los barrios o veredas de los municipios de los departamentos de un pais</td>
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
<td>Pertenece a</td>
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
<td>Es usado por</td>
<td colspan="3">Composición</td>
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
<td></td>
<td></td>
<td></td>
<td>Identificador único del barrio.</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>Municipio</td>
<td>Otro</td>
<td>Municipio</td>
<td>no final</td>
<td>no static</td>
<td></td>
<td></td>
<td></td>
<td>Municipio al que pertenece el barrio.</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td></td>
<td></td>
<td></td>
<td>Nombre del barrio o vereda registrado en el sistema.</td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>Barrio</td>
<td>Defecto</td>
<td>Crea una instancia vacía de la clase.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td colspan="2"> </td>
</tr>
<tr>
<td rowspan="2">public</td>
<td rowspan="2">Barrio</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa el barrio con sus datos básicos.</td>
<td>Municipio</td>
<td>Otro</td>
<td>Municipio</td>
<td>Por valor</td>
<td>no final</td>
<td>Municipio al que pertenece el barrio.</td>
<td></td>
<td></td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Nombre del barrio o vereda.</td>
<td></td>
<td></td>
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
<td>Permite obtener el identificador único del barrio.</td>
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
<td>Permite establecer el identificador único del barrio.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único del barrio.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getMunicipio</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el municipio al que pertenece el barrio.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Municipio</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setMunicipio</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el municipio al que pertenece el barrio.</td>
<td>Municipio</td>
<td>Otro</td>
<td>Municipio</td>
<td>Por valor</td>
<td>no final</td>
<td>Municipio al que pertenece el barrio.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNombre</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el nombre del barrio.</td>
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
<td>Permite establecer el nombre del barrio.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Nombre del barrio.</td>
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
<td>Permite consultar la información de un barrio a partir de su identificador.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador del barrio.</td>
<td>Otro</td>
<td>Barrio</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>no final</td>
<td>Permite consultar los barrios registrados que cumplen con los criterios establecidos en el filtro.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Barrio</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar los barrios.</td>
<td>Otro</td>
<td>List&lt;Barrio&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
