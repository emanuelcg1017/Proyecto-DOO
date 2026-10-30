# Empresa

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s31) · [Datos de ejemplo](#dominio-s32) · [Eventos y colaboración](#dominio-s33)

<a id="dominio-s31"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s31-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Empresa</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa la empresa de venta por catalogo que contrata los servicios de la empresa logística para gestionar el traslado y entrega de su mercancía a los destinatarios finales</td>
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
<td><a id="dominio-s31-v4"></a><a href="empresa.md#dominio-s31-a18">Registra la informacion de una nueva empresa</a></td>
<td><a id="dominio-s31-w4"></a><a href="empresa.md#dominio-s31-a21">Consultar informacion de una empresa por su identificador</a></td>
<td colspan="2"><a id="dominio-s31-x4"></a><a href="empresa.md#dominio-s31-a22">Consultar informacion de las empresas</a></td>
<td colspan="2"><a id="dominio-s31-z4"></a><a href="empresa.md#dominio-s31-a23">Actualizar la informacion de una empresa</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Sí</td>
<td>Identificador único universal</td>
<td>Sí</td>
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
<td>Sí</td>
<td>Requerido</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
<td>Requerido</td>
<td>No Modificable</td>
</tr>
<tr>
<td>Nombre</td>
<td>Nombre comercial o legal de la empresa de venta por catálogo</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Sí</td>
<td>1</td>
<td>50</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Sí</td>
<td>Sí</td>
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
<td>nit</td>
<td>Número de identificación tributaria de la empresa cliente</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Sí</td>
<td>1</td>
<td>20</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Sí</td>
<td>Sí</td>
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
<td>CorreoContacto</td>
<td>Correo electrónico principal de la empresa cliente</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Sí</td>
<td>1</td>
<td>50</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Sí</td>
<td>Sí</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>No Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
</tr>
<tr>
<td>TelefonoContacto</td>
<td>Teléfono principal de la empresa cliente</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Sí</td>
<td>1</td>
<td>15</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Sí</td>
<td>Sí</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>No Filtro</td>
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
<td rowspan="2">Combinación única 1</td>
<td rowspan="2">No puede haber mas de una empresa con el mismo nombre y NIT</td>
<td>Nombre</td>
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
<td>nit</td>
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
<td rowspan="3" colspan="2"><a id="dominio-s31-a18"></a><a href="empresa.md#dominio-s31-v4">Registra la informacion de una nueva empresa</a></td>
<td rowspan="3" colspan="4">Acción que permite llevar a cabo el registro de la información de la nueva empresa</td>
<td rowspan="3">Datos</td>
<td rowspan="3">Empresa</td>
<td rowspan="3">Contiene la información requerida para llevar a cabo el registro de la nueva empresa</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-EMP-0001</td>
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
<td>P-EMP-0002</td>
<td>Asegurar que el identiticador generado para la empresa ya no esté siendo utilizado por otra empresa</td>
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
<td>P-EMP-0003</td>
<td>Asegurar que no exista otra empresa registrada con la misma combinacion de nombre y NIT </td>
<td>Generar una excepcion indicandole al usuario que ya existe una empresa con la combinacion de nombre y nit</td>
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
<td colspan="2"><a id="dominio-s31-a21"></a><a href="empresa.md#dominio-s31-w4">Consultar informacion de una empresa por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una empresa especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la empresa que se va a consultar</td>
<td>Empresa</td>
<td colspan="4">Contiene la informacion de la empresa consultada por su id</td>
<td>P-EMP-0001</td>
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
<td colspan="2"><a id="dominio-s31-a22"></a><a href="empresa.md#dominio-s31-x4">Consultar informacion de las empresas</a></td>
<td colspan="4">Accion que permite obtener un listado de las empresas registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Empresa</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Empresa&gt;</td>
<td colspan="4">Contiene la informacion de todos las empresas que cumplen con el filtro de consulta</td>
<td>P-EMP-0001</td>
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
<td rowspan="3" colspan="2"><a id="dominio-s31-a23"></a><a href="empresa.md#dominio-s31-z4">Actualizar la informacion de una empresa</a></td>
<td rowspan="3" colspan="4">Accion que permite actualizar la informacion de una empresa que se encuentra registrada en el sistema</td>
<td rowspan="3">Datos</td>
<td rowspan="3">Empresa</td>
<td rowspan="3">Contiene la informacion actualizada de la empresa que se desea modificar</td>
<td rowspan="3"></td>
<td rowspan="3" colspan="4"></td>
<td>P-EMP-0001</td>
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
<td>P-EMP-0003</td>
<td>Asegurar que no exista otra empresa registrada con la misma combinacion de nombre y NIT </td>
<td>Generar una excepción indicándole al usuario que ya existe una empresa registrada con la misma combinación de nombre y NIT.</td>
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
<td>P-EMP-0004</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Generar una excepción indicándole al usuario que debe modificar al menos uno de los datos actuales de la empresa.</td>
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


<a id="dominio-s32"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s32-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Nombre comercial o legal de la empresa de venta por catálogo</td>
<td>Número de identificación tributaria de la empresa cliente</td>
<td>Correo electrónico principal de la empresa cliente</td>
<td>Teléfono principal de la empresa cliente</td>
<td>No puede haber mas de una empresa con el mismo nombre y NIT</td>
</tr>
<tr>
<td>ID</td>
<td>Nombre</td>
<td>nit</td>
<td>CorreoContacto</td>
<td>TelefonoContacto</td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Novaventa</td>
<td>811025289-1</td>
<td><a href="mailto:servicioalcliente@novaventa.com">servicioalcliente@novaventa.com</a></td>
<td>604 306 8600</td>
<td>Novaventa-811025289-1</td>
</tr>
<tr>
<td>2</td>
<td>Carmel</td>
<td>811.017.000-7</td>
<td><a href="mailto:servicioalcliente@carmel.com.co">servicioalcliente@carmel.com.co</a></td>
<td>604 448 5035</td>
<td>Carmel-811.017.000-7</td>
</tr>
<tr>
<td>3</td>
<td>Pacifika</td>
<td>811.017.000-7</td>
<td><a href="mailto:servicioalcliente@pcfk.com.co">servicioalcliente@pcfk.com.co</a></td>
<td>604 448 5035</td>
<td>Pacifika-811.017.000-7</td>
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


<a id="dominio-s33"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s33-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Empresa</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa la empresa de venta por catalogo que contrata los servicios de la empresa logística para gestionar el traslado y entrega de su mercancía a los destinatarios finales</td>
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
<td>Objeto de dominio</td>
<td colspan="2">Información externa</td>
<td colspan="2">Políticas</td>
<td>Sistema Externo</td>
<td>Evento</td>
<td>Aspectos por solucionar</td>
</tr>
<tr>
<td></td>
<td>Información</td>
<td>Descripción</td>
<td>Número</td>
<td>Descripción</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="3">Administrador del sistema</td>
<td rowspan="3">Registra la informacion de una nueva empresa</td>
<td rowspan="3">Permite llevar a cabo el registro de la informacion de una nueva empresa</td>
<td rowspan="3">Empresa</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="departamento.md#dominio-s34-a5">P-EMP-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">informacion de una nueva empresa registrada</td>
<td rowspan="3"></td>
</tr>
<tr>
<td><a href="departamento.md#dominio-s34-a6">P-EMP-0002</a></td>
<td>Asegurar que el identiticador generado para la empresa ya no esté siendo utilizado por otra empresa</td>
</tr>
<tr>
<td><a href="departamento.md#dominio-s34-a7">P-EMP-0003</a></td>
<td>Asegurar que no exista otra empresa registrada con la misma combinacion de nombre y NIT </td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar empresa</td>
<td>Permite consultar la informacion de las empresas registradas</td>
<td>Empresa</td>
<td></td>
<td></td>
<td><a href="departamento.md#dominio-s34-a5">P-EMP-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Empresa consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="3">Administrador del sistema</td>
<td rowspan="3">Actualizar la informacion de una empresa</td>
<td rowspan="3">Permite modificar la informacion de una empresa registrada</td>
<td rowspan="3">Empresa</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="departamento.md#dominio-s34-a5">P-EMP-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="3"></td>
<td rowspan="3">Informacion de empresa actualizada</td>
<td rowspan="3"></td>
</tr>
<tr>
<td><a href="departamento.md#dominio-s34-a7">P-EMP-0003</a></td>
<td>Asegurar que no exista otra empresa registrada con la misma combinacion de nombre y NIT </td>
</tr>
<tr>
<td><a href="departamento.md#dominio-s34-a8">P-EMP-0004</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
</table>
