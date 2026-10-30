# Persona

[Volver al modelo de clases](../modelo-clases.md) · [Proyecto](../../README.md)

<a id="clases-s11"></a>

## Persona

<table>
<tr>
<td><a id="clases-s11-a1"></a><a href="../modelo-clases.md#clases-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="4">Persona</td>
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
<td colspan="4">Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
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
<td>Es clasificada por</td>
<td colspan="3">Asociación</td>
<td><a href="tipo-documento.md#clases-s8-a1">TipoDocumento</a></td>
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
<td><a href="entrega.md#clases-s17-a1">Entrega</a></td>
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
<td colspan="5">Identificador único de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>TipoDocumento</td>
<td>Otro</td>
<td>TipoDocumento</td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Tipo de documento de identidad de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>DocumentoIdentidad</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número de documento de identidad de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>PrimerNombre</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Primer nombre de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>SegundoNombre</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Segundo nombre de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>PrimerApellido</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Primer apellido de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>SegundoApellido</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Segundo apellido de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>NumeroTelefonico</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Número telefónico de contacto de la persona.</td>
</tr>
<tr>
<td>private</td>
<td>CorreoElectronico</td>
<td>String</td>
<td></td>
<td>no final</td>
<td>no static</td>
<td colspan="3"></td>
<td colspan="5">Correo electrónico de contacto de la persona.</td>
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
<td>Persona</td>
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
<td rowspan="8">public</td>
<td rowspan="8">Persona</td>
<td rowspan="8">Parametrizado</td>
<td rowspan="8">Inicializa la persona con sus datos de identificación y contacto.</td>
<td>TipoDocumento</td>
<td>Otro</td>
<td>TipoDocumento</td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Tipo de documento de identidad.</td>
<td colspan="2"> </td>
</tr>
<tr>
<td>DocumentoIdentidad</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Documento de identidad.</td>
<td colspan="2"></td>
</tr>
<tr>
<td>PrimerNombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Primer nombre.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>SegundoNombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Segundo nombre.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>PrimerApellido</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Primer apellido.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>SegundoApellido</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Segundo apellido.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>NumeroTelefonico</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Número telefónico.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>CorreoElectronico</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td colspan="3">Correo electrónico.</td>
<td></td>
<td></td>
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
<td>Permite obtener el identificador único de la persona.</td>
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
<td>Permite establecer el identificador único de la persona.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por valor</td>
<td>no final</td>
<td>Identificador único de la persona.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getTipoDocumento</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el tipo de documento de la persona.</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Otro</td>
<td>TipoDocumento</td>
<td></td>
</tr>
<tr>
<td>private</td>
<td>setTipoDocumento</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el tipo de documento de la persona.</td>
<td>TipoDocumento</td>
<td>Otro</td>
<td>TipoDocumento</td>
<td>Por valor</td>
<td>no final</td>
<td>Tipo de documento.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getDocumentoIdentidad</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el documento de identidad.</td>
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
<td>setDocumentoIdentidad</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el documento de identidad.</td>
<td>DocumentoIdentidad</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Documento de identidad.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPrimerNombre</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el primer nombre.</td>
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
<td>setPrimerNombre</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el primer nombre.</td>
<td>PrimerNombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Primer nombre.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getSegundoNombre</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el segundo nombre.</td>
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
<td>setSegundoNombre</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el segundo nombre.</td>
<td>SegundoNombre</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Segundo nombre.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getPrimerApellido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el primer apellido.</td>
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
<td>setPrimerApellido</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el primer apellido.</td>
<td>PrimerApellido</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Primer apellido.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getSegundoApellido</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el segundo apellido.</td>
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
<td>setSegundoApellido</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el segundo apellido.</td>
<td>SegundoApellido</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Segundo apellido.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getNumeroTelefonico</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el número telefónico.</td>
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
<td>setNumeroTelefonico</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el número telefónico.</td>
<td>NumeroTelefonico</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Número telefónico.</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>getCorreoElectronico</td>
<td>getter</td>
<td>no final</td>
<td>Permite obtener el correo electrónico.</td>
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
<td>setCorreoElectronico</td>
<td>setter</td>
<td>no final</td>
<td>Permite establecer el correo electrónico.</td>
<td>CorreoElectronico</td>
<td>String</td>
<td></td>
<td>Por valor</td>
<td>no final</td>
<td>Correo electrónico.</td>
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
<td>Permite registrar la información de una nueva persona.</td>
<td>Datos</td>
<td>Otro</td>
<td>Persona</td>
<td>Por valor</td>
<td>no final</td>
<td>Información requerida para registrar la persona.</td>
<td>Otro</td>
<td>Persona</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarPorID</td>
<td>no static</td>
<td>no final</td>
<td>Permite obtener la información de una persona utilizando su identificador único.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la persona que se desea consultar.</td>
<td>Otro</td>
<td>Persona</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>ConsultarTodos</td>
<td>static</td>
<td>final</td>
<td>Permite obtener las personas registradas que cumplen con un filtro de búsqueda.</td>
<td>Filtro</td>
<td>Otro</td>
<td>Persona</td>
<td>Por valor</td>
<td>no final</td>
<td>Criterios utilizados para filtrar las personas que se desean consultar.</td>
<td>Otro</td>
<td>List&lt;Persona&gt;</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>Actualizar</td>
<td>no static</td>
<td>no final</td>
<td>Permite actualizar la información de una persona registrada.</td>
<td>Datos</td>
<td>Otro</td>
<td>Persona</td>
<td>Por valor</td>
<td>no final</td>
<td>Información actualizada de la persona que se desea modificar.</td>
<td>Otro</td>
<td>Persona</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
<tr>
<td>public</td>
<td>Inactivar</td>
<td>no static</td>
<td>no final</td>
<td>Permite inactivar una persona registrada en el sistema.</td>
<td>ID</td>
<td>Otro</td>
<td>UUID</td>
<td>Por referencia</td>
<td>no final</td>
<td>Identificador de la persona que se desea inactivar.</td>
<td>Otro</td>
<td>Persona</td>
<td>Excepción por datos de entrada inválidos.</td>
</tr>
</table>
