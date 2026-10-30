# Persona

[Volver al modelo entidad-relación](../modelo-entidad-relacion.md) · [Proyecto](../../README.md)

<a id="mer-s19"></a>

## Persona

<table>
<tr>
<td colspan="5"><a id="mer-s19-a1"></a><a href="../modelo-entidad-relacion.md#mer-s2-a1">&lt;&lt;&lt; Volver al inicio</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
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
<td colspan="19">Persona</td>
</tr>
<tr>
<td>Descripción</td>
<td colspan="19">Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
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
<td>Identificador único de la persona</td>
</tr>
<tr>
<td>IDTipoDocumento</td>
<td>UUID</td>
<td></td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>SI</td>
<td>TipoDocumento</td>
<td>ID</td>
<td>SI</td>
<td>UK_Per_TipoDocumento_DocumentoIdentidad</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Identificador del tipo de documento de identidad</td>
</tr>
<tr>
<td>DocumentoIdentidad</td>
<td>VARCHAR</td>
<td>15</td>
<td></td>
<td></td>
<td>NO</td>
<td>SI</td>
<td>NO</td>
<td>NO</td>
<td></td>
<td></td>
<td>SI</td>
<td>UK_Per_TipoDocumento_DocumentoIdentidad</td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Número del documento de identidad de la persona</td>
</tr>
<tr>
<td>PrimerNombre</td>
<td>VARCHAR</td>
<td>20</td>
<td></td>
<td></td>
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
<td>Primer nombre de la persona</td>
</tr>
<tr>
<td>SegundoNombre</td>
<td>VARCHAR</td>
<td>20</td>
<td></td>
<td></td>
<td>NO</td>
<td>NO</td>
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
<td>Segundo nombre de la persona</td>
</tr>
<tr>
<td>PrimerApellido</td>
<td>VARCHAR</td>
<td>20</td>
<td></td>
<td></td>
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
<td>Primer apellido de la persona</td>
</tr>
<tr>
<td>SegundoApellido</td>
<td>VARCHAR</td>
<td>20</td>
<td></td>
<td></td>
<td>NO</td>
<td>NO</td>
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
<td>Segundo apellido de la persona</td>
</tr>
<tr>
<td>NumeroTelefonico</td>
<td>VARCHAR</td>
<td>15</td>
<td></td>
<td></td>
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
<td>Número telefónico de contacto de la persona</td>
</tr>
<tr>
<td>CorreoElectronico</td>
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
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td>NO</td>
<td></td>
<td></td>
<td></td>
<td>Dirección de correo electrónico de contacto de la persona</td>
</tr>
</table>
