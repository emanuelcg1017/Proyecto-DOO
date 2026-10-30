# KETRA

Sistema de gestión de servicios logísticos. Permite consultar servicios, finalizarlos y consultar su utilidad con las facturas, entregas, detalles de entrega y costos de recorrido asociados.

## Documentación

| Modelo | Contenido |
| --- | --- |
| [Modelo de dominio](documentacion/modelo-dominio.md) | Objetos, caracterización, datos de ejemplo, políticas, responsabilidades y eventos. |
| [Modelo de clases](documentacion/modelo-clases.md) | Relaciones, atributos, constructores y métodos. |
| [Modelo entidad-relación](documentacion/modelo-entidad-relacion.md) | Entidades, campos, claves y restricciones. |

Cada modelo contiene su diagrama y un índice con enlaces al detalle de cada objeto. Las tablas están dentro de la documentación y pueden consultarse directamente en GitHub.

## Organización de la documentación

```text
documentacion/
    modelo-dominio.md
    modelo-clases.md
    modelo-entidad-relacion.md
    dominio/
    clases/
    mer/
    imagenes/
```

Los archivos `.md` contienen el texto y las tablas. La carpeta `imagenes` contiene los tres diagramas que se muestran en los modelos. Los enlaces son relativos para que funcionen al clonar el proyecto y en GitHub.

Las tablas usan HTML dentro de Markdown para conservar las celdas combinadas de los Excel. Las celdas vacías permanecen vacías. Las referencias que ya estaban rotas en el documento de origen se identifican al final del modelo correspondiente.

## Proyecto

Backend en Java 26 con Spring Boot, acceso a SQL Server mediante JDBC y frontend integrado en `src/main/resources/static`.

Los scripts de la base de datos se encuentran en [sql](sql). La configuración local y las credenciales se mantienen en archivos de propiedades excluidos de Git. La carpeta `target` contiene archivos generados durante la compilación y también está excluida.
