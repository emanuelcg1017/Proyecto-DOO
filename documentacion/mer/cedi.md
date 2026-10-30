# CEDI

[Volver al modelo entidad-relación](../modelo-entidad-relacion.md) · [Proyecto](../../README.md)

<a id="mer-s23"></a>

## CEDI

<table>
<tr>
<td colspan="5"><a id="mer-s23-a1"></a><a href="../modelo-entidad-relacion.md#mer-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="19">CEDI</td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="19">Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
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
<td>Identificador único del CEDI</td>
</tr>
<tr>
<td>Nombre</td>
<td>VARCHAR</td>
<td>50</td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>NO</td>
<td></td>
<td></td>
<td>SI</td>
<td>UK_CED_Nombre_Direccion</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Nombre que identifica al CEDI</td>
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
<td>SI</td>
<td>UK_CED_Nombre_Direccion</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador de la dirección donde se encuentra ubicado el CEDI</td>
</tr>
</table>
