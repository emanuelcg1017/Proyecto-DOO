# EmpresaServicio

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s18"></a>

## EmpresaServicio

<table>
<tr>
<td><a id="clases-s18-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">EmpresaServicio</td>
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
<td colspan="4">Representa la relación entre una empresa y un servicio</td>
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
<td><a href="empresa.md#clases-s3-a1">Empresa</a></td>
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
<td><a href="servicio.md#clases-s16-a1">Servicio</a></td>
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
<td colspan="5">Identificador único de la asociación.</td>
</tr>
<tr>
<td>private</td>
<td>Empresa</td>
<td>Otro</td>
<td>Empresa</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Empresa asociada al servicio.</td>
</tr>
<tr>
<td>private</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Servicio contratado por la empresa.</td>
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
<td>EmpresaServicio</td>
<td>Defecto</td>
<td>Crea una instancia vacía de la clase.</td>
<td>-</td>
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
<td rowspan="2">EmpresaServicio</td>
<td rowspan="2">Parametrizado</td>
<td rowspan="2">Inicializa la asociación entre la empresa y el servicio.</td>
<td>Empresa</td>
<td>Otro</td>
<td>Empresa</td>
<td>Por valor</td>
<td>no final</td>
<td>Empresa asociada.</td>
<td></td>
<td></td>
<td colspan="2"> </td>
</tr>
<tr>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio contratado.</td>
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
<td>Permite obtener el identificador único de la asociación.</td>
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
<td>Permite establecer el identificador único de la asociación.</td>
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
<td>getEmpresa</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener la empresa asociada.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Empresa</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setEmpresa</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer la empresa asociada.</td>
<td>Empresa</td>
<td>Otro</td>
<td>Empresa</td>
<td>Por valor</td>
<td>no final</td>
<td>Empresa correspondiente.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getServicio</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el servicio asociado.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setServicio</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el servicio asociado.</td>
<td>Servicio</td>
<td>Otro</td>
<td>Servicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Servicio correspondiente.</td>
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
<td>consultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una relación EmpresaServicio utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la relación EmpresaServicio que se desea consultar.</td>
<td>Otro</td>
<td>EmpresaServicio</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>consultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las relaciones EmpresaServicio que cumplen con un filtro de búsqueda.</td>
<td>filtro</td>
<td>Otro</td>
<td>EmpresaServicio</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las relaciones EmpresaServicio.</td>
<td>Otro</td>
<td>List&lt;EmpresaServicio&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
