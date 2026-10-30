# Servicio

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s87) · [Datos de ejemplo](#dominio-s88) · [Políticas](#dominio-s90) · [Eventos y colaboración](#dominio-s89)

<a id="dominio-s87"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s87-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="20">Servicio</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa el servicio logístico contratado por una empresa para gestionar el transporte y entrega de sus pedidos</td>
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
<td><a id="dominio-s87-v4"></a><a href="servicio.md#dominio-s87-a18">Registra la informacion de un nuevo servicio</a></td>
<td><a id="dominio-s87-w4"></a><a href="servicio.md#dominio-s87-a22">Consultar informacion de un servicio por su identificador</a></td>
<td colspan="2"><a id="dominio-s87-x4"></a><a href="servicio.md#dominio-s87-a23">Consultar informacion de los servicios</a></td>
<td colspan="2"><a id="dominio-s87-z4"></a><a href="servicio.md#dominio-s87-a24">Actualizar el estado de un servicio</a></td>
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
<td>NumeroServicio</td>
<td>Código que identifica el servicio logístico contratado por la empresa y que se utiliza como referencia durante la ejecución, el seguimiento y la facturación del servicio.</td>
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
<td>No Modificable</td>
</tr>
<tr>
<td>FechaServicio</td>
<td>Fecha en la que la empresa contrató el servicio logístico, utilizada para iniciar y controlar la operación.</td>
<td>No</td>
<td>Fecha</td>
<td>Si</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>Se debe asegurar una sanitización del dato para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
<td>No Modificable</td>
</tr>
<tr>
<td>EstadoServicio</td>
<td>Identifica el estado actual del servicio.</td>
<td>No</td>
<td><a href="estado-servicio.md#dominio-s59-a1">EstadoServicio</a></td>
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
<td>Combinación única 1</td>
<td>No puede haber más de un servicio con el mismo número de servicio</td>
<td>NumeroServicio</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td rowspan="4" colspan="2"><a id="dominio-s87-a18"></a><a href="servicio.md#dominio-s87-v4">Registra la informacion de un nuevo servicio</a></td>
<td rowspan="4" colspan="4">Acción que permite llevar a cabo el registro de la información del nuevo servicio</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Servicio</td>
<td rowspan="4">Contiene la información requerida para llevar a cabo el registro del nuevo servicio</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-SER-0001</td>
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
<td>P-SER-0002</td>
<td>Asegurar que el identiticador generado para el servicio ya no esté siendo utilizado por otro servicio</td>
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
<td>P-SER-0003</td>
<td>Asegurar que no exista otro servicio registrado con el mismo numero de servicio</td>
<td>Generar una excepcion indicandole al usuario que ya existe un servicio con el mismo numero de servicio</td>
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
<td>P-SER-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
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
<td colspan="2"><a id="dominio-s87-a22"></a><a href="servicio.md#dominio-s87-w4">Consultar informacion de un servicio por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un servicio especifica utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la empresa que se va a consultar</td>
<td>Servicio</td>
<td colspan="4">Contiene la informacion del servicio consultado por su id</td>
<td>P-SER-0001</td>
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
<td colspan="2"><a id="dominio-s87-a23"></a><a href="servicio.md#dominio-s87-x4">Consultar informacion de los servicios</a></td>
<td colspan="4">Accion que permite obtener un listado de los servicios registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>Servicio</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;Servicio&gt;</td>
<td colspan="4">Contiene la informacion de todos los servicios que cumplen con el filtro de consulta</td>
<td>P-SER-0001</td>
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
<td rowspan="4" colspan="2"><a id="dominio-s87-a24"></a><a href="servicio.md#dominio-s87-z4">Actualizar el estado de un servicio</a></td>
<td rowspan="4" colspan="4">Accion que permite actualizar el estado de un servicio que se encuentra registrada en el sistema</td>
<td rowspan="4">Datos</td>
<td rowspan="4">Servicio</td>
<td rowspan="4">Contiene el estado actualizado del servicio que se desea modificar</td>
<td rowspan="4"></td>
<td rowspan="4" colspan="4"></td>
<td>P-SER-0001</td>
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
<td>P-SER-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>Generar una excepción indicando que el estado referenciado no existe en su catálogo.</td>
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
<td>P-SER-0005</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Generar una excepción indicándole al usuario que el estado a modificar es igual al estado actual del servicio</td>
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
<td>P-SER-0006</td>
<td>Asegurar que la transición para cambiar el estado de servicio sea válida.</td>
<td>Generar una excepción indicando que la transición solicitada no está permitida.</td>
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


<a id="dominio-s88"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s88-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Código que identifica el servicio logístico contratado por la empresa y que se utiliza como referencia durante la ejecución, el seguimiento y la facturación del servicio.</td>
<td>Fecha en la que la empresa contrató el servicio logístico, utilizada para iniciar y controlar la operación.</td>
<td>Identifica el estado actual del servicio.</td>
<td>No puede haber más de un servicio con el mismo número de servicio</td>
</tr>
<tr>
<td>ID</td>
<td>NumeroServicio</td>
<td>FechaServicio</td>
<td><a href="estado-servicio.md#dominio-s60-a1">EstadoServicio</a></td>
<td>Combinacion unica 1</td>
</tr>
<tr>
<td>1</td>
<td>SRV-001</td>
<td>2026-01-08</td>
<td>Finalizado</td>
<td>SRV-001</td>
</tr>
<tr>
<td>2</td>
<td>SRV-002</td>
<td>2026-02-08</td>
<td>Finalizado</td>
<td>SRV-002</td>
</tr>
<tr>
<td>3</td>
<td>SRV-003</td>
<td>2026-03-08</td>
<td>En ejecución</td>
<td>SRV-003</td>
</tr>
<tr>
<td>4</td>
<td>SRV-004</td>
<td>2026-04-08</td>
<td>Finalizado</td>
<td>SRV-004</td>
</tr>
<tr>
<td>5</td>
<td>SRV-005</td>
<td>2026-05-08</td>
<td>Registrado</td>
<td>SRV-005</td>
</tr>
<tr>
<td>6</td>
<td>SRV-006</td>
<td>2026-06-08</td>
<td>Cancelado</td>
<td>SRV-006</td>
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


<a id="dominio-s89"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s89-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">Servicio</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa el servicio logístico contratado por una empresa para gestionar el transporte y entrega de sus pedidos</td>
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
<td>Evento</td>
<td>Aspectos por solucionar</td>
</tr>
<tr>
<td>Información</td>
<td>Descripción</td>
<td>Número</td>
<td>Descripción</td>
<td></td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Registrar servicio</td>
<td rowspan="4">Permite registrar un servicio logístico solicitado por una empresa</td>
<td rowspan="4">Servicio</td>
<td></td>
<td></td>
<td><a href="servicio.md#dominio-s90-a5">P-SER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Servicio registrado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>EstadoServicio</td>
<td>Validar que la estado asignado a el nuevo servicio sea real y este registrada</td>
<td><a href="servicio.md#dominio-s90-a6">P-SER-0002</a></td>
<td>Asegurar que el identiticador generado para el servicio ya no esté siendo utilizado por otro servicio</td>
</tr>
<tr>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="servicio.md#dominio-s90-a7">P-SER-0003</a></td>
<td>Asegurar que no exista otro servicio registrado con el mismo numero de servicio</td>
</tr>
<tr>
<td><a href="servicio.md#dominio-s90-a8">P-SER-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar servicio</td>
<td>Permite consultar los servicios registrados según un criterio de búsqueda</td>
<td>Servicio</td>
<td></td>
<td></td>
<td><a href="servicio.md#dominio-s90-a5">P-SER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Servicio consultado</td>
<td></td>
</tr>
<tr>
<td rowspan="4">Administrador del sistema</td>
<td rowspan="4">Actualizar estado del servicio</td>
<td rowspan="4">Permite actualizar el estado de un servicio </td>
<td rowspan="4">Servicio</td>
<td></td>
<td></td>
<td><a href="servicio.md#dominio-s90-a5">P-SER-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="4"></td>
<td rowspan="4">Estado del servicio actualizado</td>
<td rowspan="4"></td>
</tr>
<tr>
<td>EstadoServicio</td>
<td>Validar que la estado asignado a el servicio sea real y este registrada</td>
<td><a href="servicio.md#dominio-s90-a8">P-SER-0004</a></td>
<td>Asegurar que el estado referenciado exista </td>
</tr>
<tr>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="servicio.md#dominio-s90-a9">P-SER-0005</a></td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
</tr>
<tr>
<td><a href="servicio.md#dominio-s90-a10">P-SER-0006</a></td>
<td>Asegurar que la transición para cambiar el estado de servicio sea válida.</td>
</tr>
</table>


<a id="dominio-s90"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s90-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">Servicio</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa el servicio logístico contratado por una empresa para gestionar el transporte y entrega de sus pedidos</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s90-a5"></a>P-SER-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s90-a6"></a>P-SER-0002</td>
<td>Asegurar que el identiticador generado para el servicio ya no esté siendo utilizado por otro servicio</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s90-a7"></a>P-SER-0003</td>
<td>Asegurar que no exista otro servicio registrado con el mismo numero de servicio</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s90-a8"></a>P-SER-0004</td>
<td>Asegurar que el estado referenciado exista </td>
<td>EstadoServicio</td>
<td><a href="estado-servicio.md#dominio-s62-a5">P-ESR-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s90-a9"></a>P-SER-0005</td>
<td>Asegurar que el estado a modificar sea diferente al estado actual</td>
<td>Servicio</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s90-a10"></a>P-SER-0006</td>
<td>Asegurar que la transición para cambiar el estado de servicio sea válida.</td>
<td>TransicionEstadoServicio</td>
<td><a href="transicion-estado-servicio.md#dominio-s130-a5">P-TSS-0001</a></td>
</tr>
</table>
