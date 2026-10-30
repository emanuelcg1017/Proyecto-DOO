# Direccion

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s27) · [Datos de ejemplo](#dominio-s28) · [Políticas](#dominio-s30) · [Eventos y colaboración](#dominio-s29)

<a id="dominio-s27"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s27-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Direccion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa cada una de las ubicaciones específicas de los barrios o veredas donde se realizan las recogidas, entregas o se encuentran los CEDI</td>
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
<td><a id="dominio-s27-v4"></a><a href="direccion.md#dominio-s27-a18">Registra la informacion de una nueva direccion</a></td>
<td><a id="dominio-s27-w4"></a><a href="direccion.md#dominio-s27-a23">Consultar informacion de una direccion por su identificador</a></td>
<td colspan="2"><a id="dominio-s27-x4"></a><a href="direccion.md#dominio-s27-a24">Consultar informacion de las direcciones</a></td>
<td colspan="2"><a id="dominio-s27-z4"></a><a href="direccion.md#dominio-s27-a25">Actualizar la informacion de una direccion</a></td>
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
</tr>
<tr>
<td>Barrio</td>
<td>Representa el nombre de una direccion</td>
<td>No</td>
<td><a href="barrio.md#dominio-s3-a1">Barrio</a></td>
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
<td>No</td>
<td>No</td>
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
<td>Nombre</td>
<td>Representa el nombre de una direccion</td>
<td>No</td>
<td>Alfanumérico</td>
<td>Si</td>
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
</tr>
<tr>
<td>TipoDireccion</td>
<td>Representa el tipo direccion</td>
<td>No</td>
<td><a href="tipo-documento.md#dominio-s107-a1">TipoDireccion</a></td>
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
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
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
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="2">Combinación única 1</td>
<td rowspan="2">No puede existir dos direcciones con el mismo nombre dentro de un mismo barrio o vereda</td>
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
<td>Barrio</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="2" colspan="2"><a id="dominio-s27-a18"></a>Responsabilidad</td>
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
<td rowspan="5" colspan="2"><a id="dominio-s27-a23"></a><a href="direccion.md#dominio-s27-v4">Registra la informacion de una nueva direccion</a></td>
<td rowspan="5" colspan="4">Acción que permite llevar a cabo el registro de la información de la direccion</td>
<td rowspan="5">Datos</td>
<td rowspan="5">Direccion</td>
<td rowspan="5">Contiene la información requerida para llevar a cabo el registro de la nueva direccion</td>
<td rowspan="5"></td>
<td rowspan="5" colspan="4"></td>
<td>P-DIR-0001</td>
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
<td>P-DIR-0002</td>
<td>Asegurar que el identiticador generado para la dirrecion ya no este siendo utilizada por otra direccion</td>
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
<td>P-DIR-0003</td>
<td>Asegurar que no exista otra direccion registrada con la misma combinacion de barrio y nombre</td>
<td>Generar una excepción indicándole al usuario que ya existe una direccion registrada con la misma combinación de nombre y direccion</td>
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
<td>P-DIR-0004</td>
<td>Asegurar que el barrio que esta siendo utilizada para registrar la información de la nueva direccion exista</td>
<td>Generar una excepcion indicandole al usuario que el barrio utilizado para registrar la direccion no existe </td>
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
<td>P-DIR-0006</td>
<td>Asegurar que el tipo de dirección utilizado para registrar la dirección exista</td>
<td>Generar una excepcion indicandole al usuario que el tipo de direccion utilizado para registrar la direccion no existe </td>
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
<td colspan="2"><a id="dominio-s27-a24"></a><a href="direccion.md#dominio-s27-w4">Consultar informacion de una direccion por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de una direccion especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la direccion que se va a consultar</td>
<td>Direccion</td>
<td colspan="4">Contiene la informacion de la direccion consultada por su id</td>
<td>P-DIR-0001</td>
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
<td colspan="2"><a id="dominio-s27-a25"></a><a href="direccion.md#dominio-s27-x4">Consultar informacion de las direcciones</a></td>
<td colspan="4">Accion que permite obtener un listado de las direcciones  registradas en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Direccion</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Dirreccion&gt;</td>
<td colspan="4">Contiene la informacion de todas las direcciones que cumplen con el filtro de consulta</td>
<td>P-DIR-0001</td>
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
<td rowspan="5" colspan="2"><a href="direccion.md#dominio-s27-z4">Actualizar la informacion de una direccion</a></td>
<td rowspan="5" colspan="4">Accion que permite actualizar la informacion de una direccion que se encuentra registrada en el sistema</td>
<td rowspan="5">Datos</td>
<td rowspan="5">Direccion</td>
<td rowspan="5">Contiene la informacion actualizada de la direccion que se desea modificar</td>
<td rowspan="5"></td>
<td rowspan="5" colspan="4"></td>
<td>P-DIR-0001</td>
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
<td>P-DIR-0003</td>
<td>Asegurar que no exista otra direccion registrada con la misma combinacion de barrio y nombre</td>
<td>Generar una excepción indicándole al usuario que ya existe una direccion registrada con la misma combinación de nombre y direccion</td>
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
<td>P-DIR-0004</td>
<td>Asegurar que el barrio que esta siendo utilizada para registrar la información de la nueva direccion exista</td>
<td>Generar una excepcion indicandole al usuario que el barrio utilizado para registrar la direccion no existe </td>
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
<td>P-DIR-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Generar una excepción indicándole al usuario que debe modificar al menos uno de los datos actuales de la direccion</td>
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
<td>P-DIR-0006</td>
<td>Asegurar que el tipo de dirección utilizado para registrar la dirección exista</td>
<td>Generar una excepcion indicandole al usuario que el tipo de direccion utilizado para registrar la direccion no existe </td>
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


<a id="dominio-s28"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s28-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>representa el barrio, vereda, localidad a la que pertenece la direccion</td>
<td>Representa el nombre de una direccion</td>
<td>Representa el tipo direccion</td>
<td>No puede existir dos direcciones con el mismo nombre dentro de un mismo barrio o vereda</td>
</tr>
<tr>
<td>ID</td>
<td><a href="barrio.md#dominio-s4-a1">Barrio</a></td>
<td>Nombre</td>
<td><a href="tipo-direccion.md#dominio-s108-a1">TipoDireccion</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>Colombia-Antioquia-Rionegro-Belchite</td>
<td>Diagonal 50C #43</td>
<td>CEDI</td>
<td>Colombia-Antioquia-Rionegro-Belchite-Diagonal 50C #43</td>
</tr>
<tr>
<td>2</td>
<td>Colombia-Antioquia-Rionegro-Alto del Medio</td>
<td>Calle 50</td>
<td>Entrega</td>
<td>Colombia-Antioquia-Rionegro-Alto del Medio-Calle 50</td>
</tr>
<tr>
<td>3</td>
<td>Colombia-Antioquia-Medellin-Laureles</td>
<td>Circular 1A #70-01</td>
<td>CEDI</td>
<td>Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
</tr>
<tr>
<td>4</td>
<td>Colombia-Antioquia-Medellin-El Poblado</td>
<td>Carrera 43B #12-20</td>
<td>Entrega</td>
<td>Colombia-Antioquia-Medellin-El Poblado-Carrera 43B #12-20</td>
</tr>
<tr>
<td>5</td>
<td>Colombia-Antioquia-Guarne-San Francisco</td>
<td>Calle 45 #49-31</td>
<td>CEDI</td>
<td>Colombia-Antioquia-Guarne-San Francisco-Calle 45 #49-31</td>
</tr>
<tr>
<td>6</td>
<td>Colombia-Antioquia-Guarne-La Cabaña</td>
<td>Carrera 52 #59-2</td>
<td>Entrega</td>
<td>Colombia-Antioquia-Guarne-La Cabaña-Carrera 52 #59-2</td>
</tr>
<tr>
<td>7</td>
<td>Colombia-Antioquia-Marinilla-La Inmaculada</td>
<td>6P6M+33, Marinilla</td>
<td>CEDI</td>
<td>Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
</tr>
<tr>
<td>8</td>
<td>Colombia-Antioquia-Marinilla-María Auxiliadora</td>
<td>Calle 30 #38-63</td>
<td>Entrega</td>
<td>Colombia-Antioquia-Marinilla-María Auxiliadora-Calle 30 #38-63</td>
</tr>
<tr>
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
</tr>
<tr>
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
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
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
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td>revisar y colocar las ubicaciones reales de cedis y lugares de entrega</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
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
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s29"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s29-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Direccion</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa cada una de las ubicaciones específicas de los barrios o veredas donde se realizan las recogidas, entregas o se encuentran los CEDI</td>
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
<td rowspan="5">Administrador del sistema</td>
<td rowspan="5">Registrar dirección</td>
<td rowspan="5">Permite registrar una dirección asociada a una ubicación del sistema.</td>
<td rowspan="5">Direccion</td>
<td rowspan="3" colspan="2"></td>
<td><a href="direccion.md#dominio-s30-a5">P-DIR-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="5"></td>
<td rowspan="5">Dirección consultada</td>
<td rowspan="5"></td>
</tr>
<tr>
<td><a href="direccion.md#dominio-s30-a6">P-DIR-0002</a></td>
<td>Asegurar que el identiticador generado para la dirrecion ya no este siendo utilizada por otra direccion</td>
</tr>
<tr>
<td><a href="direccion.md#dominio-s30-a7">P-DIR-0003</a></td>
<td>Asegurar que no exista otra direccion registrada con la misma combinacion de barrio y nombre</td>
</tr>
<tr>
<td>Barrio</td>
<td>Validar que el barrio asignado a la nueva ubicación sea real y esté registrado.</td>
<td><a href="direccion.md#dominio-s30-a8">P-DIR-0004</a></td>
<td>Asegurar que el barrio que esta siendo utilizada para registrar la información de la nueva direccion exista</td>
</tr>
<tr>
<td>TipoDireccion</td>
<td>Validar que el tipo de direccion asignado a la nueva ubicación sea real y esté registrado.</td>
<td><a href="direccion.md#dominio-s30-a10">P-DIR-0006</a></td>
<td>Asegurar que el tipo de dirección utilizado para registrar la dirección exista</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar dirección</td>
<td>Permite consultar una dirección según un criterio de búsqueda.</td>
<td>Direccion</td>
<td></td>
<td></td>
<td><a href="direccion.md#dominio-s30-a5">P-DIR-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Dirección consultada</td>
<td></td>
</tr>
<tr>
<td rowspan="5">Administrador del sistema</td>
<td rowspan="5">Actualizar dirección</td>
<td rowspan="5">Permite modificar la información de una dirección registrada.</td>
<td rowspan="5">Direccion</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="direccion.md#dominio-s30-a5">P-DIR-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="5"></td>
<td rowspan="5">Dirección actualizada</td>
<td rowspan="5"></td>
</tr>
<tr>
<td><a href="direccion.md#dominio-s30-a7">P-DIR-0003</a></td>
<td>Asegurar que no exista otra direccion registrada con la misma combinacion de barrio y nombre</td>
</tr>
<tr>
<td><a href="direccion.md#dominio-s30-a8">P-DIR-0004</a></td>
<td>Asegurar que el barrio que esta siendo utilizada para registrar la información de la nueva direccion exista</td>
</tr>
<tr>
<td>Barrio</td>
<td>Validar que el barrio asignado a la nueva ubicación sea real y esté registrado.</td>
<td><a href="direccion.md#dominio-s30-a9">P-DIR-0005</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
<tr>
<td>TipoDireccion</td>
<td>Validar que el tipo de direccion asignado a la nueva ubicación sea real y esté registrado.</td>
<td><a href="direccion.md#dominio-s30-a10">P-DIR-0006</a></td>
<td>Asegurar que el tipo de dirección utilizado para registrar la dirección exista</td>
</tr>
</table>


<a id="dominio-s30"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s30-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Direccion</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa cada una de las ubicaciones específicas de los barrios o veredas donde se realizan las recogidas, entregas o se encuentran los CEDI</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s30-a5"></a>P-DIR-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s30-a6"></a>P-DIR-0002</td>
<td>Asegurar que el identiticador generado para la dirrecion ya no este siendo utilizada por otra direccion</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s30-a7"></a>P-DIR-0003</td>
<td>Asegurar que no exista otra direccion registrada con la misma combinacion de barrio y nombre</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s30-a8"></a>P-DIR-0004</td>
<td>Asegurar que el barrio que esta siendo utilizada para registrar la información de la nueva direccion exista</td>
<td>Barrio</td>
<td><a href="barrio.md#dominio-s5-a5">P-BAR-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s30-a9"></a>P-DIR-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>Direccion</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s30-a10"></a>P-DIR-0006</td>
<td>Asegurar que el tipo de dirección utilizado para registrar la dirección exista</td>
<td>TipoDireccion</td>
<td><a href="tipo-direccion.md#dominio-s110-a5">P-TDI-0001</a></td>
</tr>
</table>
