# DetalleEntrega

[Volver al modelo entidad-relación](../modelo-entidad-relacion.md) · [Proyecto](../../README.md)

<a id="mer-s29"></a>

## DetalleEntrega

<table>
<tr>
<td colspan="5"><a id="mer-s29-a1"></a><a href="../modelo-entidad-relacion.md#mer-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td>Entidad</td>
<td colspan="19">DetalleEntrega</td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="19">Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
</tr>
<tr>
<td colspan="20">Atributos</td>
</tr>
<tr>
<td rowspan="2">Nombre</td>
<td rowspan="2">Tipo de dato</td>
<td rowspan="2">Longitud</td>
<td rowspan="2">Cantidad dígitos parte entera</td>
<td rowspan="2">Cantidad dígitos parte decimal (Precisión)</td>
<td rowspan="2">¿Es autoincremento?</td>
<td rowspan="2">¿Es obligatorio?</td>
<td rowspan="2">¿Es llave primeria o es parte de ella?</td>
<td colspan="3">Llave Foránea</td>
<td colspan="2">Restricciones de unicidad</td>
<td colspan="2">Restricciones de chequeo</td>
<td colspan="3">Restricciones de índice</td>
<td rowspan="2">Alias</td>
<td rowspan="2">Descripción del campo</td>
</tr>
<tr>
<td>¿Es llave foránea?</td>
<td>Entidad</td>
<td>Columna(s)</td>
<td>¿Posee restricción de unicidad o es parte de ella?</td>
<td>Nombre restricción unicidad a la que pertenece</td>
<td>¿Posee restricción de chequeo o es parte de ella?</td>
<td>Nombre restricción chequeo a la que pertenece</td>
<td>¿Posee restricción de índice o es parte de ella?</td>
<td>Tipo</td>
<td>Nombre restricción índice a la que pertenece</td>
</tr>
<tr>
<td>ID</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>SI</td>
<td>NO</td>
<td></td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador único del detalle de entrega</td>
</tr>
<tr>
<td>NumeroDetalleEntrega</td>
<td>VARCHAR</td>
<td>30</td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>NO</td>
<td></td>
<td></td>
<td>SI</td>
<td>UK_Det_NumeroDetalleEntrega</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Número que identifica el detalle de entrega</td>
</tr>
<tr>
<td>IDPedido</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>Pedido</td>
<td>ID</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador del pedido asociado al detalle de entrega</td>
</tr>
<tr>
<td>IDEntrega</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>Entrega</td>
<td>ID</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador de la entrega a la que pertenece el detalle</td>
</tr>
<tr>
<td>IDCEDI</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>CEDI</td>
<td>ID</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador del CEDI desde la cual inicia el trayecto</td>
</tr>
<tr>
<td>IDDireccion</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>Direccion</td>
<td>ID</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador de la dirección hacia la cual se dirige el trayecto</td>
</tr>
<tr>
<td>DistanciaKM</td>
<td>DECIMAL</td>
<td></td>
<td>8</td>
<td>2</td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>NO</td>
<td></td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Distancia en kilómetros correspondiente al trayecto realizado</td>
</tr>
</table>
