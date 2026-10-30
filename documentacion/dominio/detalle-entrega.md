# DetalleEntrega

[Volver al modelo de dominio](../modelo-dominio.md) · [Proyecto](../../README.md)

[Caracterización y responsabilidades](#dominio-s19) · [Datos de ejemplo](#dominio-s20) · [Políticas](#dominio-s22) · [Eventos y colaboración](#dominio-s21)

<a id="dominio-s19"></a>

## Caracterización y responsabilidades

<table>
<tr>
<td><a id="dominio-s19-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
</tr>
<tr>
<td>Nombre</td>
<td colspan="20">DetalleEntrega</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="20">Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
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
<td><a id="dominio-s19-v4"></a><a href="detalle-entrega.md#dominio-s19-a19">Registra la informacion de un nuevo detalle entrega</a></td>
<td><a id="dominio-s19-w4"></a><a href="detalle-entrega.md#dominio-s19-a25">Consultar informacion de un detalle entrega por su identificador</a></td>
<td colspan="2"><a id="dominio-s19-x4"></a><a href="detalle-entrega.md#dominio-s19-a26">Consultar informacion de detalle entrega</a></td>
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
</tr>
<tr>
<td>NumeroDetalleEntrega</td>
<td>Codigo que identifica cada detalle de entrega, permitiendo diferenciar y realizar el seguimiento de cada movimiento asociado a una entrega.</td>
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
</tr>
<tr>
<td>Pedido</td>
<td>Identifica el pedido que se está movilizando mediante este detalle de entrega.</td>
<td>No</td>
<td><a href="pedido.md#dominio-s75-a1">Pedido</a></td>
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
</tr>
<tr>
<td>Entrega</td>
<td>Identifica la entrega a la que pertenece este detalle.</td>
<td>No</td>
<td><a href="entrega.md#dominio-s39-a1">Entrega</a></td>
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
</tr>
<tr>
<td>cediOrigen</td>
<td>Identifica el CEDI desde el cual comienza el movimiento del pedido.</td>
<td>No</td>
<td><a href="cedi.md#dominio-s7-a1">CEDI</a></td>
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
</tr>
<tr>
<td>DireccionDestino</td>
<td>Identifica la dirección hacia la cual se dirige el pedido en este movimiento.</td>
<td>No</td>
<td><a href="direccion.md#dominio-s27-a1">Destino</a></td>
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
</tr>
<tr>
<td>DistanciaKM</td>
<td>Distancia en kilómetros entre el CEDI de origen y la dirección de destino, distancia según el recorrido por carretera.</td>
<td>No</td>
<td>Decimal</td>
<td>Si</td>
<td></td>
<td></td>
<td>2</td>
<td></td>
<td>0</td>
<td>999999</td>
<td></td>
<td>Se debe asegurar una sanitización del dato, para garantizar que dentro de su contenido no tenga cualquier tipo de intento de ataque o instrucción maliciosa.</td>
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
</tr>
<tr>
<td>Combinación única 1</td>
<td>No puede haber más de un detalle de entrega con el mismo numero de detalle de entrega</td>
<td>NumeroDetalleEntrega</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
</tr>
<tr>
<td rowspan="6" colspan="2"><a id="dominio-s19-a19"></a><a href="detalle-entrega.md#dominio-s19-v4">Registra la informacion de un nuevo detalle entrega</a></td>
<td rowspan="6" colspan="4">Acción que permite llevar a cabo el registro de la información del detalle entrega</td>
<td rowspan="6">Datos</td>
<td rowspan="6">DetalleEntrega</td>
<td rowspan="6">Contiene la información requerida para llevar a cabo el registro del nuevo detalle entrega</td>
<td rowspan="6"></td>
<td rowspan="6" colspan="4"></td>
<td>P-DET-0001</td>
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
</tr>
<tr>
<td>P-DET-0002</td>
<td>Asegurar que el identiticador generado para el detalle de entrega ya no esté siendo utilizado por otro detalle de entrega</td>
<td>Generar un nuevo identificador hasta garantizar que no exista</td>
<td>Continuar operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-DET-0003</td>
<td>Asegurar que la CEDI origen que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista </td>
<td>Generar una excepción indicando que el CEDI origen no existe o no se encuentra registrado en el sistema</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-DET-0004</td>
<td>Asegurar que la direccion de entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Generar una excepción indicando que la dirección no existe</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-DET-0005</td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Generar una excepción indicando que el pedido no existe o no se encuentra registrado en el sistema</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>P-DET-0006</td>
<td>Asegurar que la entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Generar una excepción indicando que la entrega no existe o no se encuentra registrada en el sistema</td>
<td>Detener operacion</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="2"><a id="dominio-s19-a25"></a><a href="detalle-entrega.md#dominio-s19-w4">Consultar informacion de un detalle entrega por su identificador</a></td>
<td colspan="4">Accion que permite obtener la informacion de un detalle entrega especifico utilizando su identificador unico (UUID)</td>
<td>id</td>
<td>Alfanumerico</td>
<td>Contiene la informacion del identificador de la factura que se va a consultar</td>
<td>DetalleEntrega</td>
<td colspan="4">Contiene la informacion del datelle entrega consultado por su id</td>
<td>P-DET-0001</td>
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
</tr>
<tr>
<td colspan="2"><a id="dominio-s19-a26"></a><a href="detalle-entrega.md#dominio-s19-x4">Consultar informacion de detalle entrega</a></td>
<td colspan="4">Accion que permite obtener un listado de los detalles entrega registrados en el sistema mediante un filtro de busqueda</td>
<td>Filtro</td>
<td>DetalleEntrega</td>
<td>Contiene la informacion de los filtros que serviran como base para llevar a cabo la consulta de la informacion</td>
<td>Lista&lt;DetalleEntrega&gt;</td>
<td colspan="4">Contiene la informacion de todas los detalles entrega que cumplen con el filtro de consulta</td>
<td>P-DET-0001</td>
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
</tr>
</table>


<a id="dominio-s20"></a>

## Datos de ejemplo

<table>
<tr>
<td><a id="dominio-s20-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Representa un identificador que hara unico cada objeto de dominio de este tipo.No se puede repetir</td>
<td>Codigo que identifica cada detalle de entrega, permitiendo diferenciar y realizar el seguimiento de cada movimiento asociado a una entrega.</td>
<td>Identifica el pedido que se está movilizando mediante este detalle de entrega.</td>
<td>Identifica la entrega a la que pertenece este detalle.</td>
<td>Identifica el CEDI desde el cual comienza el movimiento del pedido.</td>
<td>Identifica la dirección hacia la cual se dirige el pedido en este movimiento.</td>
<td>Distancia en kilómetros entre el CEDI de origen y la dirección de destino, distancia según el recorrido por carretera.</td>
<td>No puede haber más de un detalle de entrega con el mismo numero de detalle de entrega</td>
</tr>
<tr>
<td>ID</td>
<td>NumeroDetalleEntrega</td>
<td><a href="pedido.md#dominio-s76-a1">Pedido</a></td>
<td><a href="entrega.md#dominio-s40-a1">Entrega</a></td>
<td>cediOrigen</td>
<td><a href="direccion.md#dominio-s28-a1">DireccionDestino</a></td>
<td>DistanciaKM</td>
<td>Combinacion Unica</td>
</tr>
<tr>
<td>1</td>
<td>DET-001</td>
<td>PED-000001</td>
<td>ENT-001</td>
<td>CEDI Medellín-Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
<td>Colombia-Antioquia-Rionegro-Belchite-Diagonal 50C #43</td>
<td>28.4</td>
<td>DET-001</td>
</tr>
<tr>
<td>2</td>
<td>DET-002</td>
<td>PED-000001</td>
<td>ENT-001</td>
<td>CEDI Rionegro-Colombia-Antioquia-Rionegro-Belchite-Diagonal 50C #43</td>
<td>Colombia-Antioquia-Rionegro-Alto del Medio-Calle 50</td>
<td>9.6</td>
<td>DET-002</td>
</tr>
<tr>
<td>3</td>
<td>DET-003</td>
<td>PED-000002</td>
<td>ENT-002</td>
<td>CEDI Medellín-Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
<td>Colombia-Antioquia-Medellin-El Poblado-Carrera 43B #12-20</td>
<td>8.6999999999999993</td>
<td>DET-003</td>
</tr>
<tr>
<td>4</td>
<td>DET-004</td>
<td>PED-000003</td>
<td>ENT-003</td>
<td>CEDI Medellín-Colombia-Antioquia-Medellin-Laureles-Circular 1A #70-01</td>
<td>Colombia-Antioquia-Guarne-La Cabaña-Carrera 52 #59-2</td>
<td>7.8</td>
<td>DET-004</td>
</tr>
<tr>
<td>5</td>
<td>DET-005</td>
<td>PED-000005</td>
<td>ENT-005</td>
<td>CEDI Marinilla-Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
<td>Colombia-Antioquia-Rionegro-Alto del Medio-Calle 50</td>
<td>5.9</td>
<td>DET-005</td>
</tr>
<tr>
<td>6</td>
<td>DET-006</td>
<td>PED-000008</td>
<td>ENT-008</td>
<td>CEDI GUARNE-Colombia-Antioquia-Guarne-San Francisco-Calle 45 #49-31</td>
<td>Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
<td>17.5</td>
<td>DET-006</td>
</tr>
<tr>
<td>7</td>
<td>DET-007</td>
<td>PED-000008</td>
<td>ENT-008</td>
<td>CEDI Marinilla-Colombia-Antioquia-Marinilla-La Inmaculada-6P6M+33, Marinilla</td>
<td>Colombia-Antioquia-Marinilla-María Auxiliadora-Calle 30 #38-63</td>
<td>6.8</td>
<td>DET-007</td>
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
</tr>
</table>


<a id="dominio-s21"></a>

## Eventos y colaboración

<table>
<tr>
<td><a id="dominio-s21-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
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
<td colspan="10">DetalleEntrega</td>
</tr>
<tr>
<td>Descripción:</td>
<td colspan="10">Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
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
<td rowspan="6">Administrador del sistema</td>
<td rowspan="6">Registrar detalle de entrega</td>
<td rowspan="6">Permite registrar un trayecto realizado como parte de una entrega.</td>
<td rowspan="6">DetalleEntrega</td>
<td rowspan="2"></td>
<td rowspan="2"></td>
<td><a href="detalle-entrega.md#dominio-s22-a5">P-DET-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td rowspan="6"></td>
<td rowspan="6">Detalle de entrega registrado</td>
<td rowspan="6"></td>
</tr>
<tr>
<td><a href="detalle-entrega.md#dominio-s22-a6">P-DET-0002</a></td>
<td>Asegurar que el identiticador generado para el detalle de entrega ya no esté siendo utilizado por otro detalle de entrega</td>
</tr>
<tr>
<td>CEDI</td>
<td>Validar que el CEDI asignado al nuevo detalle entrega sea real y esté registrado.</td>
<td><a href="detalle-entrega.md#dominio-s22-a7">P-DET-0003</a></td>
<td>Asegurar que la CEDI origen que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista </td>
</tr>
<tr>
<td>Direccion</td>
<td>Validar que la direccion asignada al nuevo detalle entrega sea real y esté registrado.</td>
<td><a href="detalle-entrega.md#dominio-s22-a8">P-DET-0004</a></td>
<td>Asegurar que la direccion de entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
</tr>
<tr>
<td>Pedido</td>
<td>Validar que el pedido asignado al nuevo detalle entrega sea real y esté registrado.</td>
<td><a href="detalle-entrega.md#dominio-s22-a9">P-DET-0005</a></td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
</tr>
<tr>
<td>Entrega</td>
<td>Validar que la entrega asignada al nuevo detalle entrega sea real y esté registrado.</td>
<td><a href="detalle-entrega.md#dominio-s22-a10">P-DET-0006</a></td>
<td>Asegurar que la entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
</tr>
<tr>
<td>Administrador del sistema</td>
<td>Consultar detalle de entrega</td>
<td>Permite consultar los trayectos asociados a una entrega.</td>
<td>DetalleEntrega</td>
<td></td>
<td></td>
<td><a href="detalle-entrega.md#dominio-s22-a5">P-DET-0001</a></td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td></td>
<td>Detalle de entrega consultado</td>
<td></td>
</tr>
</table>


<a id="dominio-s22"></a>

## Políticas

<table>
<tr>
<td><a id="dominio-s22-a1"></a><a href="../modelo-dominio.md#dominio-s1-a1">&lt;&lt;&lt;Ir a modelo de dominio</a></td>
<td><a href="../modelo-dominio.md#dominio-s2-a1">&lt;&lt;&lt;Ir a Objetos de dominio</a></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Objeto de Dominio</td>
<td colspan="3">DetalleEntrega</td>
</tr>
<tr>
<td>Descripcion:</td>
<td colspan="3">Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
</tr>
<tr>
<td>Numero politica </td>
<td>Descripcion politica</td>
<td>Objeto responsable </td>
<td>Objeto referenciado</td>
</tr>
<tr>
<td><a id="dominio-s22-a5"></a>P-DET-0001</td>
<td>Asegurar que los datos requeridos para llevar a cabo la operación deseada sean válidos a nivel de tipo de dato, longitud, obligatoriedad, formato y rango.</td>
<td>DetalleEntrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s22-a6"></a>P-DET-0002</td>
<td>Asegurar que el identiticador generado para el detalle de entrega ya no esté siendo utilizado por otro detalle de entrega</td>
<td>DetalleEntrega</td>
<td></td>
</tr>
<tr>
<td><a id="dominio-s22-a7"></a>P-DET-0003</td>
<td>Asegurar que la CEDI origen que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista </td>
<td>CEDI</td>
<td><a href="cedi.md#dominio-s10-a5">P-CED-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s22-a8"></a>P-DET-0004</td>
<td>Asegurar que la direccion de entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Direccion</td>
<td><a href="direccion.md#dominio-s30-a5">P-DIR-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s22-a9"></a>P-DET-0005</td>
<td>Asegurar que el pedido que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Pedido</td>
<td><a href="pedido.md#dominio-s78-a5">P-PED-0001</a></td>
</tr>
<tr>
<td><a id="dominio-s22-a10"></a>P-DET-0006</td>
<td>Asegurar que la entrega que esta siendo utilizada para registrar la información del nuevo detalle de entrega exista</td>
<td>Entrega</td>
<td><a href="entrega.md#dominio-s42-a5">P-ENT-0001</a></td>
</tr>
</table>
