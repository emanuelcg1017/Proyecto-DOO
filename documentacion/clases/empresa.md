# Empresa

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s3"></a>

## Empresa

<table>
<tr>
<td><a id="clases-s3-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Empresa</td>
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
<td colspan="4">Representa la empresa de venta por catalogo que contrata los servicios de la empresa logística para gestionar el traslado y entrega de su mercancía a los destinatarios finales</td>
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
<td>Contrata</td>
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
<td colspan="3">-</td>
<td colspan="5">Identificador único de la empresa.</td>
</tr>
<tr>
<td>private</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Nombre comercial o legal de la empresa.</td>
</tr>
<tr>
<td>private</td>
<td>NIT</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Número de identificación tributaria de la empresa.</td>
</tr>
<tr>
<td>private</td>
<td>CorreoContacto</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Correo electrónico de contacto de la empresa.</td>
</tr>
<tr>
<td>private</td>
<td>TelefonoContacto</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3">-</td>
<td colspan="5">Número telefónico de contacto de la empresa.</td>
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
<td>Empresa</td>
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
<td rowspan="4">Empresa</td>
<td rowspan="4">Parametrizado</td>
<td rowspan="4">Inicializa la empresa con sus datos básicos.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Nombre de la empresa.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>NIT</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">NIT de la empresa.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>CorreoContacto</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Correo de contacto.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>TelefonoContacto</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Teléfono de contacto.</td>
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
<td>Permite obtener el identificador único de la empresa.</td>
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
<td>Permite establecer el identificador único de la empresa.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único de la empresa.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNombre</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el nombre de la empresa.</td>
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
<td>Permite establecer el nombre de la empresa.</td>
<td>Nombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Nombre de la empresa.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNIT</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el NIT de la empresa.</td>
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
<td>setNIT</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el NIT de la empresa.</td>
<td>NIT</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>NIT de la empresa.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getCorreoContacto</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el correo de contacto.</td>
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
<td>setCorreoContacto</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el correo de contacto.</td>
<td>CorreoContacto</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Correo de contacto.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getTelefonoContacto</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el teléfono de contacto.</td>
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
<td>setTelefonoContacto</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el teléfono de contacto.</td>
<td>TelefonoContacto</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Teléfono de contacto.</td>
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
<td>Permite registrar la información de una nueva empresa.</td>
<td>Datos</td>
<td>Otro</td>
<td>Empresa</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar la empresa.</td>
<td>Otro</td>
<td>Empresa</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una empresa utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la empresa que se desea consultar.</td>
<td>Otro</td>
<td>Empresa</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las empresas registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Empresa</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las empresas que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Empresa&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>Actualizar</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar la información de una empresa registrada.</td>
<td>Datos</td>
<td>Otro</td>
<td>Empresa</td>
<td>Por valor</td>
<td>no final</td>
<td>Información actualizada de la empresa que se desea modificar.</td>
<td>Otro</td>
<td>Empresa</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
