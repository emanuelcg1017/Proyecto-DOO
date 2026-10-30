# TransicionEstadoPreliquidacion

[Volver al modelo entidad-relación](../modelo-entidad-relacion.md) · [Proyecto](../../README.md)

<a id="mer-s17"></a>

## TransicionEstadoPreliquidacion

<table>
<tr>
<td colspan="5"><a id="mer-s17-a1"></a><a href="../modelo-entidad-relacion.md#mer-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="19">TransicionEstadoPreliquidacion</td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="19">Representa una transición permitida entre un estado de origen y un estado de destino de la preliquidación.</td>
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
<td>Identificador único de la transición de estado de la preliquidación.</td>
</tr>
<tr>
<td>IDEstadoOrigen</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>EstadoPreliquidacion</td>
<td>ID</td>
<td>SI</td>
<td>UK_TransicionEstadoPreliquidacion_origen_destino</td>
<td>SI</td>
<td>CK_TransicionEstadoPreliquidacion_estados_diferentes</td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador del estado de origen de la preliquidación. La combinación de origen y destino debe ser única y ambos estados deben ser diferentes.</td>
</tr>
<tr>
<td>IDEstadoDestino</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>EstadoPreliquidacion</td>
<td>ID</td>
<td>SI</td>
<td>UK_TransicionEstadoPreliquidacion_origen_destino</td>
<td>SI</td>
<td>CK_TransicionEstadoPreliquidacion_estados_diferentes</td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador del estado de destino de la preliquidación. La combinación de origen y destino debe ser única y ambos estados deben ser diferentes.</td>
</tr>
</table>
