# Modelo de clases

[Volver al proyecto](../README.md)

![Diagrama del modelo de clases](imagenes/clases.png)

[Abrir diagrama en tamaño completo](imagenes/clases.png)

## Contenido

| Clase | Detalle |
| --- | --- |
| Empresa | [Consultar](clases/empresa.md) |
| Pais | [Consultar](clases/pais.md) |
| Pedido | [Consultar](clases/pedido.md) |
| Tercero | [Consultar](clases/tercero.md) |
| TipoDireccion | [Consultar](clases/tipo-direccion.md) |
| TipoDocumento | [Consultar](clases/tipo-documento.md) |
| DetallePedido | [Consultar](clases/detalle-pedido.md) |
| Departamento | [Consultar](clases/departamento.md) |
| Persona | [Consultar](clases/persona.md) |
| Municipio | [Consultar](clases/municipio.md) |
| Barrio | [Consultar](clases/barrio.md) |
| Direccion | [Consultar](clases/direccion.md) |
| CEDI | [Consultar](clases/cedi.md) |
| Servicio | [Consultar](clases/servicio.md) |
| Entrega | [Consultar](clases/entrega.md) |
| EmpresaServicio | [Consultar](clases/empresa-servicio.md) |
| EntregaTercero | [Consultar](clases/entrega-tercero.md) |
| Factura | [Consultar](clases/factura.md) |
| ServicioCEDI | [Consultar](clases/servicio-cedi.md) |
| DetalleEntrega | [Consultar](clases/detalle-entrega.md) |
| ServicioEntrega | [Consultar](clases/servicio-entrega.md) |
| ServicioFactura | [Consultar](clases/servicio-factura.md) |
| CostoRecorrido | [Consultar](clases/costo-recorrido.md) |
| Utilidad | [Consultar](clases/utilidad.md) |
| Preliquidacion | [Consultar](clases/preliquidacion.md) |
| EstadoServicio | [Consultar](clases/estado-servicio.md) |
| EstadoEntrega | [Consultar](clases/estado-entrega.md) |
| EstadoFactura | [Consultar](clases/estado-factura.md) |
| EstadoPreliquidacion | [Consultar](clases/estado-preliquidacion.md) |
| TransicionEstadoServicio | [Consultar](clases/transicion-estado-servicio.md) |
| TransicionEstadoEntrega | [Consultar](clases/transicion-estado-entrega.md) |
| TransicionEstadoFactura | [Consultar](clases/transicion-estado-factura.md) |
| TransicionEstadoPreliquidacion | [Consultar](clases/transicion-estado-preliquidacion.md) |

## Índice del modelo original

<a id="clases-s1"></a>

## Diagrama de clases



<a id="clases-s2"></a>

## Clases

<table>
<tr>
<td><a id="clases-s2-a1"></a>  </td>
<td>Estereotipo</td>
<td>Descripción</td>
</tr>
<tr>
<td><a href="clases/empresa.md#clases-s3-a1">Empresa</a></td>
<td>class</td>
<td>Representa la empresa de venta por catalogo que contrata los servicios de la empresa logística para gestionar el traslado y entrega de su mercancía a los destinatarios finales</td>
</tr>
<tr>
<td><a href="clases/pais.md#clases-s4-a1">Pais</a></td>
<td>class</td>
<td>Representa a cada uno de los países a los que pertenecen los departamentos , municipios y direcciones</td>
</tr>
<tr>
<td><a href="clases/pedido.md#clases-s5-a1">Pedido</a></td>
<td>class</td>
<td>Representa aquello que la empresa de venta por catalogo solicita transportar y entregar mediante el servicio logístico contratado</td>
</tr>
<tr>
<td><a href="clases/tercero.md#clases-s6-a1">Tercero</a></td>
<td>class</td>
<td>Empresa externa que realiza las entregas y genera costos</td>
</tr>
<tr>
<td><a href="clases/tipo-direccion.md#clases-s7-a1">TipoDireccion</a></td>
<td>class</td>
<td>Representa el tipo de ubicación al que corresponde una dirección dentro del sistema</td>
</tr>
<tr>
<td><a href="clases/tipo-documento.md#clases-s8-a1">TipoDocumento</a></td>
<td>class</td>
<td>Representa el tipo de documento utilizado para identificar a una persona.</td>
</tr>
<tr>
<td><a href="clases/detalle-pedido.md#clases-s9-a1">DetallePedido</a></td>
<td>class</td>
<td>Representa la información específica que permite conocer qué contiene un pedido que debe ser trasladado.</td>
</tr>
<tr>
<td><a href="clases/departamento.md#clases-s10-a1">Departamento</a></td>
<td>class</td>
<td>Representa a cada uno de los departamentos de un país, donde se encuentran los municipios y direcciones</td>
</tr>
<tr>
<td><a href="clases/persona.md#clases-s11-a1">Persona</a></td>
<td>class</td>
<td>Representa a la persona relacionada con una operación logística, principalmente como destinatario de una entrega, almacenando sus datos de identificación y contacto.</td>
</tr>
<tr>
<td><a href="clases/municipio.md#clases-s12-a1">Municipio</a></td>
<td>class</td>
<td>Representa a cada uno de los municipios de los departamentos de un país</td>
</tr>
<tr>
<td><a href="clases/barrio.md#clases-s13-a1">Barrio</a></td>
<td>class</td>
<td>Representa a cada uno de los barrios o veredas de los municipios de los departamentos de un pais</td>
</tr>
<tr>
<td><a href="clases/direccion.md#clases-s14-a1">Direccion</a></td>
<td>class</td>
<td>Representa cada una de las ubicaciones específicas de los barrios o veredas donde se realizan las recogidas, entregas o se encuentran los CEDI</td>
</tr>
<tr>
<td><a href="clases/cedi.md#clases-s15-a1">CEDI</a></td>
<td>class</td>
<td>Representa el centro de distribución desde el cual la empresa logística recibe o despacha la mercancía para ejecutar los servicios contratados</td>
</tr>
<tr>
<td><a href="clases/servicio.md#clases-s16-a1">Servicio</a></td>
<td>class</td>
<td>Representa el servicio logístico contratado por una empresa para gestionar el transporte y entrega de sus pedidos</td>
</tr>
<tr>
<td><a href="clases/entrega.md#clases-s17-a1">Entrega</a></td>
<td>class</td>
<td>Proceso mediante el cual el pedido es transportado y entregado al cliente</td>
</tr>
<tr>
<td><a href="clases/empresa-servicio.md#clases-s18-a1">EmpresaServicio</a></td>
<td>class</td>
<td>Representa la relación entre una empresa y un servicio</td>
</tr>
<tr>
<td><a href="clases/factura.md#clases-s20-a1">Factura</a></td>
<td>class</td>
<td>Documento comercial que consolida uno o más pedidos</td>
</tr>
<tr>
<td><a href="clases/servicio-cedi.md#clases-s21-a1">ServicioCEDI</a></td>
<td>class</td>
<td>Representa la relación entre un servicio, un CEDI y los pedidos que deben ser gestionados desde dicho CEDI para la ejecución del servicio</td>
</tr>
<tr>
<td><a href="clases/detalle-entrega.md#clases-s22-a1">DetalleEntrega</a></td>
<td>class</td>
<td>Representa la información de un trayecto específico realizado para ejecutar una entrega dentro de un servicio logístico</td>
</tr>
<tr>
<td><a href="clases/entrega-tercero.md#clases-s19-a1">EntregaTercero</a></td>
<td>class</td>
<td>Representa la relación entre una entrega y un tercero</td>
</tr>
<tr>
<td><a href="clases/servicio-entrega.md#clases-s23-a1">ServicioEntrega</a></td>
<td>class</td>
<td>Representa la relación entre un servicio y una entrega</td>
</tr>
<tr>
<td><a href="clases/servicio-factura.md#clases-s24-a1">ServicioFactura</a></td>
<td>class</td>
<td>Representa la relación entre un servicio y una factura</td>
</tr>
<tr>
<td><a href="clases/costo-recorrido.md#clases-s25-a1">CostoRecorrido</a></td>
<td>class</td>
<td>Representa el costo generado por un recorrido, calculado de acuerdo con la distancia recorrida y el valor establecido por kilómetro.</td>
</tr>
<tr>
<td><a href="clases/utilidad.md#clases-s26-a1">Utilidad</a></td>
<td>class</td>
<td>Representa el resultado obtenido al comparar los ingresos generados por la facturación con los costos asociados a la ejecución de los servicios logísticos.</td>
</tr>
<tr>
<td><a href="clases/preliquidacion.md#clases-s27-a1">Preliquidacion</a></td>
<td>class</td>
<td>Representa el cálculo de los costos que se deben reconocer a un tercero por las entregas realizadas.</td>
</tr>
<tr>
<td><a href="clases/estado-servicio.md#clases-s28-a1">EstadoServicio</a></td>
<td>class</td>
<td>Representa cada uno de los estados definidos para un servicio.</td>
</tr>
<tr>
<td><a href="clases/estado-entrega.md#clases-s29-a1">EstadoEntrega</a></td>
<td>class</td>
<td>Representa cada uno de los estados definidos para una entrega.</td>
</tr>
<tr>
<td><a href="clases/estado-factura.md#clases-s30-a1">EstadoFactura</a></td>
<td>class</td>
<td>Representa cada uno de los estados definidos para una factura.</td>
</tr>
<tr>
<td><a href="clases/estado-preliquidacion.md#clases-s31-a1">EstadoPreliquidacion</a></td>
<td>class</td>
<td>Representa cada uno de los estados definidos para una preliquidación.</td>
</tr>
<tr>
<td><a href="clases/transicion-estado-servicio.md#clases-s32-a1">TransicionEstadoServicio</a></td>
<td>class</td>
<td>Representa una transición permitida entre un estado de origen y un estado de destino del servicio.</td>
</tr>
<tr>
<td><a href="clases/transicion-estado-entrega.md#clases-s33-a1">TransicionEstadoEntrega</a></td>
<td>class</td>
<td>Representa una transición permitida entre un estado de origen y un estado de destino de la entrega.</td>
</tr>
<tr>
<td><a href="clases/transicion-estado-factura.md#clases-s34-a1">TransicionEstadoFactura</a></td>
<td>class</td>
<td>Representa una transición permitida entre un estado de origen y un estado de destino de la factura.</td>
</tr>
<tr>
<td><a href="clases/transicion-estado-preliquidacion.md#clases-s35-a1">TransicionEstadoPreliquidacion</a></td>
<td>class</td>
<td>Representa una transición permitida entre un estado de origen y un estado de destino de la preliquidación.</td>
</tr>
</table>
