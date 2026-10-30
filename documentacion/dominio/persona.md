# Persona

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s79) · [Datos de ejemplo](#dominio-s80) · [Políticas](#dominio-s82) · [Eventos y colaboración](#dominio-s81)

<a id="dominio-s79"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s79-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td></td>
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">Persona</td>
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
<td colspan="20">Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
<td></td>
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
<td><a id="dominio-s79-v4"></a><a href="persona.md#dominio-s79-a24">Registra la informacion de una nueva persona</a></td>
<td><a id="dominio-s79-w4"></a><a href="persona.md#dominio-s79-a28">Consultar informacion de una persona por su identificador</a></td>
<td colspan="2"><a id="dominio-s79-x4"></a><a href="persona.md#dominio-s79-a29">Consultar informacion de persona</a></td>
<td colspan="2"><a id="dominio-s79-z4"></a><a href="persona.md#dominio-s79-a30">Actualizar la informacion de una persona</a></td>
<td><a href="persona.md#dominio-s79-a34">Inactivar persona</a></td>
</tr>
<tr>
<td>ID</td>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Si</td>
<td>Identificador único universal</td>
<td>Si</td>
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
<td>Si</td>
<td>Requerido</td>
<td>No Mostrar</td>
<td>No Filtro</td>
<td>No Mostrar</td>
<td>Requerido</td>
<td>No Modificable</td>
<td>Requerido</td>
</tr>
<tr>
<td>TipoDocumento</td>
<td>Tipo de documento utilizado para identificar a la persona.</td>
<td>No</td>
<td><a href="tipo-direccion.md#dominio-s111-a1">TipoDocumento</a></td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Aplican las reglas del objeto referenciado.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>NumeroIdentificacion</td>
<td>Representa el numero de identificacion utilizado para identificar a la persona</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>15</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>Si</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>PrimerNombre</td>
<td>Representa el primer nombre de la persona que participa en la operación logística como destinatario</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>20</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>SegundoNombre</td>
<td>Representa el segundo nombre de la persona que participa en la operación logística como destinatario</td>
<td>No</td>
<td>Alfanumérico</td>
<td>No</td>
<td>0</td>
<td>20</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td>&quot;&quot;</td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>PrimerApellido</td>
<td>Representa el primer apellido de la persona que participa en la operación logística como destinatario</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>20</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>Si</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>SegundoApellido</td>
<td>Representa el segundo apellido de la persona que participa en la operación logística como destinatario</td>
<td>No</td>
<td>Alfanumérico</td>
<td>No</td>
<td>1</td>
<td>20</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td>&quot;&quot;</td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>NumeroTelefonico</td>
<td>Representa el número telefónico utilizado para contactar a la persona.</td>
<td>Si</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
<td>15</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td></td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>No Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
</tr>
<tr>
<td>CorreoElectronico</td>
<td>Representa el correo utilizado para contactar a la persona.</td>
<td>No</td>
<td>Alfanumérico</td>
<td>No</td>
<td>0</td>
<td>30</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
<td>No</td>
<td>No</td>
<td></td>
<td>Si</td>
<td>Si</td>
<td>No</td>
<td>&quot;&quot;</td>
<td>No</td>
<td>Requerido</td>
<td>Mostrar</td>
<td>No Filtro</td>
<td>Mostrar</td>
<td>No Requerido</td>
<td>Modificable</td>
<td>No Requerido</td>
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
<td></td>
</tr>
<tr>
<td rowspan="2">Combinación única 1</td>
<td rowspan="2">No puede existir mas de una persona con la misma combinacion de tipo de documento y numero de identificacion</td>
<td>TipoDocumento</td>
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
<td>NumeroIdentificacion</td>
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
<td></td>
</tr>
<tr>
<td rowspan="4" colspan="2"><a id="dominio-s79-a24"></a><a href="persona.md#dominio-s79-v4">Registra la informacion de una nueva persona</a></td>
<td rowspan="4" colspan="4">Acción que permite llevar a cabo el registro de la información de la persona</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Persona</td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el registro de la nueva persona</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-PER-0001</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0002</td>
<td>Asegurar que el identiticador generado para la persona ya no esté siendo utilizado por otra persona</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0003</td>
<td>Asegurar que no exista otra persona registrada con la misma combinacion de tipo de documento y numero de identificacion</td>
<td>Generar una excepción indicándole al usuario que ya existe una persona registrada con la misma combinación de nombre y direccion</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0004</td>
<td>Asegurar que el tipo documento que esta siendo utilizado para registrar la información de la nueva persona exista</td>
<td>Generar una excepcion indicandole al usuario que el tipo de documento utilizado para registrar a la persona no existe</td>
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
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s79-a28"></a><a href="persona.md#dominio-s79-w4">Consultar informacion de una persona por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una persona especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la persona que se va a consultar</td>
<td>Persona</td>
<td colspan="4">Contiene la informacion de la persona consultada por su id</td>
<td>P-PER-0001</td>
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
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s79-a29"></a><a href="persona.md#dominio-s79-x4">Consultar informacion de persona</a></td>
<td colspan="4">Accion que permite obtener un listado de las personas registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Persona</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Persona&gt;</td>
<td colspan="4">Contiene la informacion de todas las personas que cumplen con el filtro de consulta</td>
<td>P-PER-0001</td>
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
<td></td>
</tr>
<tr>
<td rowspan="4" colspan="2"><a id="dominio-s79-a30"></a><a href="persona.md#dominio-s79-z4">Actualizar la informacion de una persona</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar la informacion de una persona que se encuentra registrada en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Persona</td>
<td rowspan="4">Contiene la informacion actualizada de la persona que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-PER-0001</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0003</td>
<td>Asegurar que no exista otra persona registrada con la misma combinacion de tipo de documento y numero de identificacion</td>
<td>Generar una excepción indicándole al usuario que ya existe una persona registrada con la misma combinación de nombre y direccion</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0004</td>
<td>Asegurar que el tipo documento que esta siendo utilizado para registrar la información de la nueva persona exista</td>
<td>La direccion utilizada para registrar la persona no existe o no es de tipo persona</td>
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
<td></td>
</tr>
<tr>
<td>P-PER-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Generar una excepción indicándole al usuario que debe modificar al menos uno de los datos actuales de persona</td>
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
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s79-a34"></a>Inactivar persona</td>
<td colspan="4">Accion que permite inactivar una persona registrada en el sistema para evitar su utilizacion en nuevas operaciones</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene el identificador unico (UUID) de la persona que se desea inactivar</td>
<td></td>
<td colspan="4"></td>
<td>P-PER-0001</td>
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
<td></td>
</tr>
</table>


<a id="dominio-s80"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s80-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
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
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Tipo de documento utilizado para identificar a la persona.</td>
<td>Representa el numero de identificacion utilizado para identificar a la persona</td>
<td>Representa el primer nombre de la persona que participa en la operación logística como destinatario</td>
<td>Representa el segundo nombre de la persona que participa en la operación logística como destinatario</td>
<td>Representa el primer apellido de la persona que participa en la operación logística como destinatario</td>
<td>Representa el segundo apellido de la persona que participa en la operación logística como destinatario</td>
<td>Representa el número telefónico utilizado para contactar a la persona.</td>
<td>Representa el correo utilizado para contactar a la persona.</td>
<td>No puede existir mas de una persona con la misma combinacion de tipo de documento y numero de identificacion</td>
</tr>
<tr>
<td>ID</td>
<td><a href="tipo-documento.md#dominio-s112-a1">TipoDocumento</a></td>
<td>NumeroIdentificacion</td>
<td>PrimerNombre</td>
<td>SegundoNombre</td>
<td>PrimerApellido</td>
<td>SegundoApellido</td>
<td>NumeroTelefonico</td>
<td>CorreoElectronico</td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Cédula</td>
<td>1017930467</td>
<td>Emanuel</td>
<td></td>
<td>Carmona</td>
<td>Gaviria</td>
<td>3015340216</td>
<td><a href="mailto:emanuelc.g1017@gmail.com">emanuelc.g1017@gmail.com</a></td>
<td>Cédula-1017930467</td>
</tr>
<tr>
<td>2</td>
<td>Cédula</td>
<td>1041325675</td>
<td>Kelly</td>
<td>Andrea</td>
<td>Cardona</td>
<td>Lopez</td>
<td>3154474919</td>
<td><a href="mailto:andrea.56@gmail.com">andrea.56@gmail.com</a></td>
<td>Cédula-1041325675</td>
</tr>
<tr>
<td>3</td>
<td>Cédula</td>
<td>1034777725</td>
<td>Juan</td>
<td>Camilo</td>
<td>Lancheros</td>
<td>Ramirez</td>
<td>3213111125</td>
<td><a href="mailto:camilo.L07@gmail.com">camilo.L07@gmail.com</a></td>
<td>Cédula-1034777725</td>
</tr>
<tr>
<td>4</td>
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
<td>5</td>
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
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
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
<td>Corresponde a los nombres de los atributos</td>
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
<td>Corresponde a los datos colocados</td>
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
<td>Corresponde a los ID</td>
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
<td>Corresponde a la combinacion unica 1</td>
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
<td>corresponde a valores calculados</td>
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


<a id="dominio-s81"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s81-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Persona</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
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
<td rowspan="2">Objeto de dominio</td>
<td colspan="2">Información externa</td>
<td colspan="2">Políticas</td>
<td rowspan="2">Sistema Externo</td>
<td rowspan="2">Evento</td>
<td rowspan="2">Aspectos por solucionar</td>
</tr>
<tr>
<td>Información</td>
<td>Descripción</td>
<td>Número</td>
<td>Descripción</td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Registrar persona</td>
<td rowspan="4">Permite registrar los datos de una persona que puede recibir una entrega.</td>
<td rowspan="4">Persona</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="persona.md#dominio-s82-a5">P-PER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Persona registrada</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="persona.md#dominio-s82-a6">P-PER-0002</a></td>
<td>Asegurar que el identiticador generado para la persona ya no esté siendo utilizado por otra persona</td>
</tr>
<tr>
<td><a href="persona.md#dominio-s82-a7">P-PER-0003</a></td>
<td>Asegurar que no exista otra persona registrada con la misma combinacion de tipo de documento y numero de identificacion</td>
</tr>
<tr>
<td>Tipo de documento</td>
<td>Validar que el tipo de documento asignado a la nueva persona sea real y este registrado</td>
<td><a href="persona.md#dominio-s82-a8">P-PER-0004</a></td>
<td>Asegurar que el tipo documento que esta siendo utilizado para registrar la información de la nueva persona exista</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar persona</td>
<td>Permite consultar una o varias personas según un criterio de búsqueda.</td>
<td>Persona</td>
<td></td>
<td></td>
<td><a href="persona.md#dominio-s82-a5">P-PER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Persona consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Modificar información de persona</td>
<td rowspan="4">Permite modificar los datos de una persona registrada.</td>
<td rowspan="4">Persona</td>
<td rowspan="4"></td>
<td rowspan="4"></td>
<td><a href="persona.md#dominio-s82-a5">P-PER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Información de persona modificada</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="persona.md#dominio-s82-a7">P-PER-0003</a></td>
<td>Asegurar que no exista otra persona registrada con la misma combinacion de tipo de documento y numero de identificacion</td>
</tr>
<tr>
<td><a href="persona.md#dominio-s82-a8">P-PER-0004</a></td>
<td>Asegurar que el tipo documento que esta siendo utilizado para registrar la información de la nueva persona exista</td>
</tr>
<tr>
<td><a href="persona.md#dominio-s82-a9">P-PER-0005</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Inactivar persona</td>
<td>Permite dejar de utilizar una persona para nuevas operaciones sin eliminar el registro histórico asociado.</td>
<td>Persona</td>
<td></td>
<td></td>
<td><a href="persona.md#dominio-s82-a5">P-PER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Persona inactivada</td>
<td></td>
</tr>
</table>


<a id="dominio-s82"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s82-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Persona</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s82-a5"></a>P-PER-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Persona</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s82-a6"></a>P-PER-0002</td>
<td>Asegurar que el identiticador generado para la persona ya no esté siendo utilizado por otra persona</td>
<td>Persona</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s82-a7"></a>P-PER-0003</td>
<td>Asegurar que no exista otra persona registrada con la misma combinacion de tipo de documento y numero de identificacion</td>
<td>Persona</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s82-a8"></a>P-PER-0004</td>
<td>Asegurar que el tipo documento que esta siendo utilizado para registrar la información de la nueva persona exista</td>
<td>Direccion</td>
<td><a href="tipo-documento.md#dominio-s114-a5">P-TDO-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s82-a9"></a>P-PER-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Persona</td>
<td></td>
</tr>
</table>
