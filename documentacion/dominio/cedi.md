# CEDI

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s7) · [Datos de ejemplo](#dominio-s8) · [Políticas](#dominio-s10) · [Eventos y colaboración](#dominio-s9)

<a id="dominio-s7"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s7-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">CEDI</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
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
<td><a id="dominio-s7-v4"></a><a href="cedi.md#dominio-s7-a19">Registra la informacion de un nuevo CEDI</a></td>
<td><a id="dominio-s7-w4"></a><a href="cedi.md#dominio-s7-a23">Consultar informacion de un CEDI por su identificador</a></td>
<td colspan="2"><a id="dominio-s7-x4"></a><a href="cedi.md#dominio-s7-a24">Consultar informacion de los CEDI&#x27;s</a></td>
<td colspan="2"><a id="dominio-s7-z4"></a><a href="cedi.md#dominio-s7-a25">Actualizar la informacion de un CEDI</a></td>
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
<td>Nombre</td>
<td>Representa el nombre del centro de distribucion</td>
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
<td>Direccion</td>
<td>Representa la direccion fisica del centro de distrucion </td>
<td>No</td>
<td><a href="direccion.md#dominio-s27-a1">Direccion</a></td>
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
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="2">No puede existir mas de un CEDI con la misma combinacion de nombre y direccion</td>
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
<td>Direccion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="4" colspan="2"><a id="dominio-s7-a19"></a><a href="cedi.md#dominio-s7-v4">Registra la informacion de un nuevo CEDI</a></td>
<td rowspan="4" colspan="4">Acción que permite llevar a cabo el registro de la información de el CEDI</td>
<td rowspan="4">Datos</td>
<td rowspan="4">CEDI</td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el registro del nuevo CEDI</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-CED-0001</td>
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
<td>P-CED-0002</td>
<td>Asegurar que el identiticador generado para el CEDI ya no esté siendo utilizado por otro CEDI</td>
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
<td>P-CED-0003</td>
<td>Asegurar que no exista otro CEDI registrado con la misma combinacion de nombre y direccion</td>
<td>Generar una excepción indicándole al usuario que ya existe un CEDI registrado con la misma combinación de nombre y direccion</td>
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
<td>P-CED-0004</td>
<td>Asegurar que la direccion que esta siendo utilizada para registrar la información del nuevo CEDI exista y sea de tipo CEDI</td>
<td>Generar una excepcion indicandole al usuario que la direccion utilizada para registrar el CEDI no existe o no es de tipo CEDI</td>
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
<td colspan="2"><a id="dominio-s7-a23"></a><a href="cedi.md#dominio-s7-w4">Consultar informacion de un CEDI por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un CEDI especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador del CEDI que se va a consultar</td>
<td>CEDI</td>
<td colspan="4">Contiene la informacion del CEDI consultada por su id</td>
<td>P-CED-0001</td>
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
<td colspan="2"><a id="dominio-s7-a24"></a><a href="cedi.md#dominio-s7-x4">Consultar informacion de los CEDI&#x27;s</a></td>
<td colspan="4">Accion que permite obtener un listado de los CEDIS  registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>CEDI</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;CEDI&gt;</td>
<td colspan="4">Contiene la informacion de todos los CEDI&#x27;s que cumplen con el filtro de consulta</td>
<td>P-CED-0001</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s7-a25"></a><a href="cedi.md#dominio-s7-z4">Actualizar la informacion de un CEDI</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar la informacion de un CEDI que se encuentra registrado en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">CEDI</td>
<td rowspan="4">Contiene la informacion actualizada de la empresa que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-CED-0001</td>
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
<td>P-CED-0003</td>
<td>Asegurar que no exista otro CEDI registrado con la misma combinacion de nombre y direccion</td>
<td>Generar una excepción indicándole al usuario que ya existe un CEDI registrado con la misma combinación de nombre y direccion</td>
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
<td>P-CED-0004</td>
<td>Asegurar que la direccion que esta siendo utilizada para registrar la información del nuevo CEDI exista y sea de tipo CEDI</td>
<td>La direccion utilizada para registrar el CEDI no existe o no es de tipo CEDI</td>
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
<td>P-CED-0005</td>
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
</tr>
</table>


<a id="dominio-s8"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s8-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Representa el nombre del centro de distribucion</td>
<td>Representa la direccion fisica del centro de distrucion </td>
<td>No puede existir mas de un CEDI con la misma combinacion de nombre y direccion</td>
</tr>
<tr>
<td>ID</td>
<td>Nombre</td>
<td><a href="direccion.md#dominio-s28-a1">Direccion</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>CEDI Rionegro</td>
<td>Colombia-Antioquia-Rionegro-Belchite-Diagonal 50C #43</td>
<td>CEDI Rionegro-Colombia-Antioquia-Rionegro-Belchite-Diagonal 50C #43</td>
</tr>
<tr>
<td>2</td>
<td>CEDI Medellín</td>
<td>Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
<td>CEDI Medellín-Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
</tr>
<tr>
<td>3</td>
<td>CEDI GUARNE</td>
<td>Colombia-Antioquia-Guarne-San Francisco-Calle 45 #49-31</td>
<td>CEDI GUARNE-Colombia-Antioquia-Guarne-San Francisco-Calle 45 #49-31</td>
</tr>
<tr>
<td>4</td>
<td>CEDI Marinilla</td>
<td>Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
<td>CEDI Marinilla-Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
</tr>
<tr>
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
</tr>
<tr>
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
</tr>
<tr>
<td> </td>
<td>Corresponde a las descripciones de los atributos</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los nombres de los atributos</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los datos colocados</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a los ID</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>Corresponde a la combinacion unica 1</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td>corresponde a valores calculados</td>
<td></td>
<td></td>
</tr>
</table>


<a id="dominio-s9"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s9-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">CEDI</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
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
<td rowspan="4">Registrar CEDI</td>
<td rowspan="4">Permite registrar un nuevo centro de distribución disponible para la operación logística.</td>
<td rowspan="4">CEDI</td>
<td rowspan="3"></td>
<td rowspan="3"></td>
<td><a href="cedi.md#dominio-s10-a5">P-CED-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">CEDI registrado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="cedi.md#dominio-s10-a6">P-CED-0002</a></td>
<td>Asegurar que el identiticador generado para el CEDI ya no esté siendo utilizado por otro CEDI</td>
</tr>
<tr>
<td><a href="cedi.md#dominio-s10-a7">P-CED-0003</a></td>
<td>Asegurar que no exista otro CEDI registrado con la misma combinacion de nombre y direccion</td>
</tr>
<tr>
<td>Direccion</td>
<td>Validar que la direccion asignada al nuevo CEDI sea real y este registrada</td>
<td><a href="cedi.md#dominio-s10-a8">P-CED-0004</a></td>
<td>Asegurar que la direccion que esta siendo utilizada para registrar la información del nuevo CEDI exista y sea de tipo CEDI</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar CEDI</td>
<td>Permite consultar los centros de distribución disponibles para la operación logística.</td>
<td>CEDI</td>
<td></td>
<td></td>
<td><a href="cedi.md#dominio-s10-a5">P-CED-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>CEDI consultado</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar CEDI</td>
<td rowspan="4">Permite modificar la información de un centro de distribución registrado.</td>
<td rowspan="4">CEDI</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="cedi.md#dominio-s10-a5">P-CED-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">CEDI Actualizado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td><a href="cedi.md#dominio-s10-a7">P-CED-0003</a></td>
<td>Asegurar que no exista otro CEDI registrado con la misma combinacion de nombre y direccion</td>
</tr>
<tr>
<td>Direccion</td>
<td>Validar que la direccion asignada al nuevo CEDI sea real y este registrada</td>
<td><a href="cedi.md#dominio-s10-a8">P-CED-0004</a></td>
<td>Asegurar que la direccion que esta siendo utilizada para registrar la información del nuevo CEDI exista y sea de tipo CEDI</td>
</tr>
<tr>
<td></td>
<td></td>
<td><a href="cedi.md#dominio-s10-a9">P-CED-0005</a></td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
</tr>
</table>


<a id="dominio-s10"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s10-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">CEDI</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s10-a5"></a>P-CED-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>CEDI</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s10-a6"></a>P-CED-0002</td>
<td>Asegurar que el identiticador generado para el CEDI ya no esté siendo utilizado por otro CEDI</td>
<td>CEDI</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s10-a7"></a>P-CED-0003</td>
<td>Asegurar que no exista otro CEDI registrado con la misma combinacion de nombre y direccion</td>
<td>CEDI</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s10-a8"></a>P-CED-0004</td>
<td>Asegurar que la direccion que esta siendo utilizada para registrar la información del nuevo CEDI exista y sea de tipo CEDI</td>
<td>Direccion</td>
<td><a href="direccion.md#dominio-s30-a5">P-DIR-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s10-a9"></a>P-CED-0005</td>
<td>Asegurar que almenos un dato a modificar sea diferente a los que se tienen actualmente</td>
<td>CEDI</td>
<td></td>
</tr>
</table>
