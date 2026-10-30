# Tercero

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s103) · [Datos de ejemplo](#dominio-s104) · [Políticas](#dominio-s106) · [Eventos y colaboración](#dominio-s105)

<a id="dominio-s103"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s103-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Tercero</td>
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
<td colspan="20">Empresa externa que realiza las entregas y genera costos</td>
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
<td><a href="tercero.md#dominio-s103-a19">Registra la informacion de un nuevo tercero</a></td>
<td><a id="dominio-s103-w4"></a><a href="tercero.md#dominio-s103-a23">Consultar informacion de un tercero por su identificador</a></td>
<td colspan="2"><a id="dominio-s103-x4"></a><a href="tercero.md#dominio-s103-a24">Consultar informacion de tercero</a></td>
<td colspan="2"><a id="dominio-s103-z4"></a><a href="tercero.md#dominio-s103-a25">Actualizar la informacion de un tercero</a></td>
<td><a id="dominio-s103-ab4"></a><a href="tercero.md#dominio-s103-a29">Inactivar tercero</a></td>
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
<td>Nombre</td>
<td>Nombre de la empresa transportadora.</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
<td>1</td>
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
<td>nit</td>
<td>Numero de Identificación Tributaria de la empresa transportadora.</td>
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
<td>NumeroContacto</td>
<td>Numero telefonico de la empresa transportadora.</td>
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
<td>CorreoContacto</td>
<td>Direccion de correo electronico de la empresa transportadora.</td>
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
<td rowspan="2">No puede haber más de un tercero con el mismo nombre y NIT.</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s103-a19"></a><a href="tercero.md#dominio-s103-w4">Registra la informacion de un nuevo tercero</a></td>
<td rowspan="4" colspan="4">Acción que permite llevar a cabo el registro de la información de el tercero</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Tercero</td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el registro del nuevo tercero</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-TER-0001</td>
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
<td>P-TER-0002</td>
<td>Asegurar que el identiticador generado para el tercero ya no esté siendo utilizado por otro tercero</td>
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
<td>P-TER-0003</td>
<td>Asegurar que no exista otro tercero registrado con la misma combinacion de nombre y NIT </td>
<td>Generar una excepción indicándole al usuario que ya existe un tercero registrado con la misma combinación de nombre y direccion</td>
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
<td>P-TER-0004</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>La direccion utilizada para registrar el tercero no existe o no es de tipo tercero</td>
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
<td colspan="2"><a id="dominio-s103-a23"></a><a href="tercero.md#dominio-s103-x4">Consultar informacion de un tercero por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un tercero especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del tercero que se va a consultar</td>
<td>Tercero</td>
<td colspan="4">Contiene la informacion del tercero consultada por su id</td>
<td>P-TER-0001</td>
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
<td colspan="2"><a id="dominio-s103-a24"></a><a href="tercero.md#dominio-s103-x4">Consultar informacion de tercero</a></td>
<td colspan="4">Accion que permite obtener un listado de los terceros registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Tercero</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Tercero&gt;</td>
<td colspan="4">Contiene la informacion de todos los terceros que cumplen con el filtro de consulta</td>
<td>P-TER-0001</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s103-a25"></a><a href="tercero.md#dominio-s103-z4">Actualizar la informacion de un tercero</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar la informacion de un tercero que se encuentra registrado en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Tercero</td>
<td rowspan="4">Contiene la informacion actualizada del tercero que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-TER-0001</td>
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
<td>P-TER-0003</td>
<td>Asegurar que no exista otro tercero registrado con la misma combinacion de nombre y NIT </td>
<td>Generar una excepción indicándole al usuario que ya existe un tercero registrado con la misma combinación de nombre y direccion</td>
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
<td>P-TER-0004</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>La direccion utilizada para registrar el tercero no existe o no es de tipo tercero</td>
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
<td>P-TER-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Generar una excepción indicándole al usuario que debe modificar al menos uno de los datos actuales del CEDI</td>
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
<td colspan="2"><a id="dominio-s103-a29"></a><a href="tercero.md#dominio-s103-ab4">Inactivar tercero</a></td>
<td colspan="4">Accion que permite inactivar un tercero registrado en el sistema para evitar su utilizacion en nuevas operaciones</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene el identificador unico (UUID) de tercero que se desea inactivar</td>
<td></td>
<td colspan="4"></td>
<td>P-TER-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Generar una excepcion indicandole al usuario que existen problemas con los datos y de ser posible indicarle como solucionarlos</td>
<td>Detener operacion</td>
<td colspan="2"></td>
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


<a id="dominio-s104"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s104-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Nombre de la empresa transportadora.</td>
<td>Numero de Identificación Tributaria de la empresa transportadora.</td>
<td>Numero telefonico de la empresa transportadora.</td>
<td>Direccion de correo electronico de la empresa transportadora.</td>
<td>No puede haber más de un tercero con el mismo nombre y NIT.</td>
</tr>
<tr>
<td>ID</td>
<td>Nombre</td>
<td>nit</td>
<td>NumeroContacto</td>
<td>CorreoContacto</td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Transportes Oriente</td>
<td>890910871-2</td>
<td>604 230 9257</td>
<td><a href="mailto:mercadeo@transorientevirtual.com">mercadeo@transorientevirtual.com</a></td>
<td>Transportes Oriente-890910871-2</td>
</tr>
<tr>
<td>2</td>
<td>Contransporte</td>
<td>811001202-8</td>
<td>604 444 6698</td>
<td><a href="mailto:servicios@contransporte.co">servicios@contransporte.co</a></td>
<td>Contransporte-811001202-8</td>
</tr>
<tr>
<td>3</td>
<td>Transportes Saferbo</td>
<td>890920990-3</td>
<td>604 369 6060</td>
<td><a href="mailto:servicioalcliente@saferbo.com">servicioalcliente@saferbo.com</a></td>
<td>Transportes Saferbo-890920990-3</td>
</tr>
<tr>
<td>4</td>
<td>Correcamiones</td>
<td>900257142-6</td>
<td>311 635 5780</td>
<td></td>
<td>Correcamiones-900257142-6</td>
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


<a id="dominio-s105"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s105-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Tercero</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Empresa externa que realiza las entregas y genera costos</td>
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
<td rowspan="4">Registrar tercero</td>
<td rowspan="4"></td>
<td rowspan="4">Tercero</td>
<td rowspan="4"></td>
<td rowspan="4"></td>
<td><a href="tercero.md#dominio-s106-a5">P-TER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Tercero registrado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a6">P-TER-0002</a></td>
<td>Asegurar que el identiticador generado para el tercero ya no esté siendo utilizado por otro tercero</td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a7">P-TER-0003</a></td>
<td>Asegurar que no exista otro tercero registrado con la misma combinacion de nombre y NIT </td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a8">P-TER-0004</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar tercero</td>
<td></td>
<td>Tercero</td>
<td></td>
<td></td>
<td><a href="tercero.md#dominio-s106-a5">P-TER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Tercero consultado</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar información de tercero</td>
<td rowspan="4"></td>
<td rowspan="4">Tercero</td>
<td rowspan="4"></td>
<td rowspan="4"></td>
<td><a href="tercero.md#dominio-s106-a5">P-TER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Información de tercero actualizada</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a7">P-TER-0003</a></td>
<td>Asegurar que el identiticador generado para el tercero ya no esté siendo utilizado por otro tercero</td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a8">P-TER-0004</a></td>
<td>Asegurar que no exista otro tercero registrado con la misma combinacion de nombre y NIT </td>
</tr>
<tr>
<td><a href="tercero.md#dominio-s106-a9">P-TER-0005</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Inactivar tercero</td>
<td></td>
<td>Tercero</td>
<td></td>
<td></td>
<td><a href="tercero.md#dominio-s106-a5">P-TER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Tercero inactivado</td>
<td></td>
</tr>
</table>


<a id="dominio-s106"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s106-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Tercero</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Tercero</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s106-a5"></a>P-TER-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Tercero</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s106-a6"></a>P-TER-0002</td>
<td>Asegurar que el identiticador generado para el tercero ya no esté siendo utilizado por otro tercero</td>
<td>Tercero</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s106-a7"></a>P-TER-0003</td>
<td>Asegurar que no exista otro tercero registrado con la misma combinacion de nombre y NIT </td>
<td>Tercero</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s106-a8"></a>P-TER-0004</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Tercero</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s106-a9"></a>P-TER-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Tercero</td>
<td></td>
</tr>
</table>
