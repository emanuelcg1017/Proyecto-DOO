USE KETRA;
GO


/* ============================================================
   PAIS
   ============================================================ */

IF OBJECT_ID('dbo.Pais', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Pais (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_Pais
            PRIMARY KEY (id),

        CONSTRAINT UK_Pais_nombre
            UNIQUE (nombre)
    );
END;
GO


/* ============================================================
   TIPO DOCUMENTO
   ============================================================ */

IF OBJECT_ID('dbo.TipoDocumento', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.TipoDocumento (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(40) NOT NULL,

        CONSTRAINT PK_TipoDocumento
            PRIMARY KEY (id),

        CONSTRAINT UK_TipoDocumento_nombre
            UNIQUE (nombre)
    );
END;
GO


/* ============================================================
   TIPO DIRECCION
   ============================================================ */

IF OBJECT_ID('dbo.TipoDireccion', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.TipoDireccion (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(10) NOT NULL,

        CONSTRAINT PK_TipoDireccion
            PRIMARY KEY (id),

        CONSTRAINT UK_TipoDireccion_nombre
            UNIQUE (nombre)
    );
END;
GO


/* ============================================================
   EMPRESA
   ============================================================ */

IF OBJECT_ID('dbo.Empresa', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Empresa (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        nit VARCHAR(20) NOT NULL,
        correoContacto VARCHAR(50) NOT NULL,
        telefonoContacto VARCHAR(15) NOT NULL,

        CONSTRAINT PK_Empresa
            PRIMARY KEY (id),

        CONSTRAINT UK_Empresa_nombre_nit
            UNIQUE (nombre, nit)
    );
END;
GO


/* ============================================================
   PEDIDO
   ============================================================ */

IF OBJECT_ID('dbo.Pedido', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Pedido (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroPedido VARCHAR(30) NOT NULL,
        fechaPedido DATE NOT NULL,

        CONSTRAINT PK_Pedido
            PRIMARY KEY (id),

        CONSTRAINT UK_Pedido_numeroPedido
            UNIQUE (numeroPedido)
    );
END;
GO


/* ============================================================
   TERCERO
   ============================================================ */

IF OBJECT_ID('dbo.Tercero', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Tercero (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(30) NOT NULL,
        nit VARCHAR(20) NOT NULL,
        numeroContacto VARCHAR(15) NOT NULL,

        correoContacto VARCHAR(30) NOT NULL
            CONSTRAINT DF_Tercero_correoContacto DEFAULT '',

        CONSTRAINT PK_Tercero
            PRIMARY KEY (id),

        CONSTRAINT UK_Tercero_nombre_nit
            UNIQUE (nombre, nit)
    );
END;
GO


/* ============================================================
   DEPARTAMENTO
   ============================================================ */

IF OBJECT_ID('dbo.Departamento', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Departamento (
        id UNIQUEIDENTIFIER NOT NULL,
        idPais UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_Departamento
            PRIMARY KEY (id),

        CONSTRAINT FK_Departamento_Pais
            FOREIGN KEY (idPais)
            REFERENCES dbo.Pais(id),

        CONSTRAINT UK_Departamento_nombre_pais
            UNIQUE (nombre, idPais)
    );
END;
GO


/* ============================================================
   PERSONA
   ============================================================ */

IF OBJECT_ID('dbo.Persona', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Persona (
        id UNIQUEIDENTIFIER NOT NULL,
        idTipoDocumento UNIQUEIDENTIFIER NOT NULL,
        numeroIdentificacion VARCHAR(15) NOT NULL,
        primerNombre VARCHAR(20) NOT NULL,

        segundoNombre VARCHAR(20) NOT NULL
            CONSTRAINT DF_Persona_segundoNombre DEFAULT '',

        primerApellido VARCHAR(20) NOT NULL,

        segundoApellido VARCHAR(20) NOT NULL
            CONSTRAINT DF_Persona_segundoApellido DEFAULT '',

        numeroTelefonico VARCHAR(15) NOT NULL,

        correoElectronico VARCHAR(30) NOT NULL
            CONSTRAINT DF_Persona_correoElectronico DEFAULT '',

        CONSTRAINT PK_Persona
            PRIMARY KEY (id),

        CONSTRAINT FK_Persona_TipoDocumento
            FOREIGN KEY (idTipoDocumento)
            REFERENCES dbo.TipoDocumento(id),

        CONSTRAINT UK_Persona_tipoDocumento_identificacion
            UNIQUE (idTipoDocumento, numeroIdentificacion)
    );
END;
GO


/* ============================================================
   MUNICIPIO
   ============================================================ */

IF OBJECT_ID('dbo.Municipio', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Municipio (
        id UNIQUEIDENTIFIER NOT NULL,
        idDepartamento UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_Municipio
            PRIMARY KEY (id),

        CONSTRAINT FK_Municipio_Departamento
            FOREIGN KEY (idDepartamento)
            REFERENCES dbo.Departamento(id),

        CONSTRAINT UK_Municipio_nombre_departamento
            UNIQUE (nombre, idDepartamento)
    );
END;
GO


/* ============================================================
   BARRIO
   ============================================================ */

IF OBJECT_ID('dbo.Barrio', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Barrio (
        id UNIQUEIDENTIFIER NOT NULL,
        idMunicipio UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_Barrio
            PRIMARY KEY (id),

        CONSTRAINT FK_Barrio_Municipio
            FOREIGN KEY (idMunicipio)
            REFERENCES dbo.Municipio(id),

        CONSTRAINT UK_Barrio_nombre_municipio
            UNIQUE (nombre, idMunicipio)
    );
END;
GO


/* ============================================================
   DIRECCION
   ============================================================ */

IF OBJECT_ID('dbo.Direccion', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Direccion (
        id UNIQUEIDENTIFIER NOT NULL,
        idBarrio UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        idTipoDireccion UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_Direccion
            PRIMARY KEY (id),

        CONSTRAINT FK_Direccion_Barrio
            FOREIGN KEY (idBarrio)
            REFERENCES dbo.Barrio(id),

        CONSTRAINT FK_Direccion_TipoDireccion
            FOREIGN KEY (idTipoDireccion)
            REFERENCES dbo.TipoDireccion(id),

        CONSTRAINT UK_Direccion_nombre_barrio
            UNIQUE (nombre, idBarrio)
    );
END;
GO


/* ============================================================
   CEDI
   ============================================================ */

IF OBJECT_ID('dbo.CEDI', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.CEDI (
        id UNIQUEIDENTIFIER NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        idDireccion UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_CEDI
            PRIMARY KEY (id),

        CONSTRAINT FK_CEDI_Direccion
            FOREIGN KEY (idDireccion)
            REFERENCES dbo.Direccion(id),

        CONSTRAINT UK_CEDI_nombre_direccion
            UNIQUE (nombre, idDireccion)
    );
END;
GO


/* ============================================================
   SERVICIO
   ============================================================ */

IF OBJECT_ID('dbo.Servicio', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Servicio (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroServicio VARCHAR(30) NOT NULL,
        fechaServicio DATE NOT NULL,
        estado VARCHAR(15) NOT NULL,

        CONSTRAINT PK_Servicio
            PRIMARY KEY (id),

        CONSTRAINT UK_Servicio_numeroServicio
            UNIQUE (numeroServicio),

        CONSTRAINT CK_Servicio_estado
            CHECK (
                estado IN (
                    'Registrado',
                    'En ejecución',
                    'Finalizado',
                    'Cancelado'
                )
            )
    );
END;
GO


/* ============================================================
   ENTREGA
   ============================================================ */

IF OBJECT_ID('dbo.Entrega', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Entrega (
        id UNIQUEIDENTIFIER NOT NULL,
        codigoEntrega VARCHAR(30) NOT NULL,
        fechaEntrega DATE NOT NULL,
        estadoEntrega VARCHAR(30) NOT NULL,
        idPersona UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_Entrega
            PRIMARY KEY (id),

        CONSTRAINT FK_Entrega_Persona
            FOREIGN KEY (idPersona)
            REFERENCES dbo.Persona(id),

        CONSTRAINT UK_Entrega_codigoEntrega
            UNIQUE (codigoEntrega),

        CONSTRAINT CK_Entrega_estadoEntrega
            CHECK (
                estadoEntrega IN (
                    'Pendiente',
                    'En tránsito',
                    'Entregada',
                    'Cancelada'
                )
            )
    );
END;
GO


/* ============================================================
   DETALLE PEDIDO
   ============================================================ */

IF OBJECT_ID('dbo.DetallePedido', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.DetallePedido (
        id UNIQUEIDENTIFIER NOT NULL,
        idPedido UNIQUEIDENTIFIER NOT NULL,
        codigoBarras VARCHAR(30) NOT NULL,

        CONSTRAINT PK_DetallePedido
            PRIMARY KEY (id),

        CONSTRAINT FK_DetallePedido_Pedido
            FOREIGN KEY (idPedido)
            REFERENCES dbo.Pedido(id)
    );
END;
GO


/* ============================================================
   EMPRESA SERVICIO
   ============================================================ */

IF OBJECT_ID('dbo.EmpresaServicio', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.EmpresaServicio (
        id UNIQUEIDENTIFIER NOT NULL,
        idEmpresa UNIQUEIDENTIFIER NOT NULL,
        idServicio UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_EmpresaServicio
            PRIMARY KEY (id),

        CONSTRAINT FK_EmpresaServicio_Empresa
            FOREIGN KEY (idEmpresa)
            REFERENCES dbo.Empresa(id),

        CONSTRAINT FK_EmpresaServicio_Servicio
            FOREIGN KEY (idServicio)
            REFERENCES dbo.Servicio(id),

        CONSTRAINT UK_EmpresaServicio_empresa_servicio
            UNIQUE (idEmpresa, idServicio)
    );
END;
GO


/* ============================================================
   FACTURA
   ============================================================ */

IF OBJECT_ID('dbo.Factura', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Factura (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroFactura VARCHAR(30) NOT NULL,
        fechaFactura DATE NOT NULL,
        ingresos DECIMAL(18,0) NOT NULL,
        estadoFactura VARCHAR(15) NOT NULL,

        CONSTRAINT PK_Factura
            PRIMARY KEY (id),

        CONSTRAINT UK_Factura_numeroFactura
            UNIQUE (numeroFactura),

        CONSTRAINT CK_Factura_ingresos
            CHECK (
                ingresos >= 0
                AND ingresos <= 100000000
            ),

        CONSTRAINT CK_Factura_estadoFactura
            CHECK (
                estadoFactura IN (
                    'Pendiente',
                    'Pagada',
                    'Anulada'
                )
            )
    );
END;
GO


/* ============================================================
   SERVICIO CEDI
   ============================================================ */

IF OBJECT_ID('dbo.ServicioCEDI', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.ServicioCEDI (
        id UNIQUEIDENTIFIER NOT NULL,
        idServicio UNIQUEIDENTIFIER NOT NULL,
        idCedi UNIQUEIDENTIFIER NOT NULL,
        idPedido UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_ServicioCEDI
            PRIMARY KEY (id),

        CONSTRAINT FK_ServicioCEDI_Servicio
            FOREIGN KEY (idServicio)
            REFERENCES dbo.Servicio(id),

        CONSTRAINT FK_ServicioCEDI_CEDI
            FOREIGN KEY (idCedi)
            REFERENCES dbo.CEDI(id),

        CONSTRAINT FK_ServicioCEDI_Pedido
            FOREIGN KEY (idPedido)
            REFERENCES dbo.Pedido(id),

        CONSTRAINT UK_ServicioCEDI_servicio_cedi_pedido
            UNIQUE (idServicio, idCedi, idPedido)
    );
END;
GO


/* ============================================================
   DETALLE ENTREGA
   ============================================================ */

IF OBJECT_ID('dbo.DetalleEntrega', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.DetalleEntrega (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroDetalleEntrega VARCHAR(30) NOT NULL,
        idPedido UNIQUEIDENTIFIER NOT NULL,
        idEntrega UNIQUEIDENTIFIER NOT NULL,
        idCediOrigen UNIQUEIDENTIFIER NOT NULL,
        idDireccionDestino UNIQUEIDENTIFIER NOT NULL,
        distanciaKM DECIMAL(18,2) NOT NULL,

        CONSTRAINT PK_DetalleEntrega
            PRIMARY KEY (id),

        CONSTRAINT FK_DetalleEntrega_Pedido
            FOREIGN KEY (idPedido)
            REFERENCES dbo.Pedido(id),

        CONSTRAINT FK_DetalleEntrega_Entrega
            FOREIGN KEY (idEntrega)
            REFERENCES dbo.Entrega(id),

        CONSTRAINT FK_DetalleEntrega_CEDIOrigen
            FOREIGN KEY (idCediOrigen)
            REFERENCES dbo.CEDI(id),

        CONSTRAINT FK_DetalleEntrega_DireccionDestino
            FOREIGN KEY (idDireccionDestino)
            REFERENCES dbo.Direccion(id),

        CONSTRAINT UK_DetalleEntrega_numeroDetalleEntrega
            UNIQUE (numeroDetalleEntrega),

        CONSTRAINT CK_DetalleEntrega_distanciaKM
            CHECK (
                distanciaKM >= 0
                AND distanciaKM <= 999999
            )
    );
END;
GO


/* ============================================================
   ENTREGA TERCERO
   ============================================================ */

IF OBJECT_ID('dbo.EntregaTercero', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.EntregaTercero (
        id UNIQUEIDENTIFIER NOT NULL,
        idEntrega UNIQUEIDENTIFIER NOT NULL,
        idTercero UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_EntregaTercero
            PRIMARY KEY (id),

        CONSTRAINT FK_EntregaTercero_Entrega
            FOREIGN KEY (idEntrega)
            REFERENCES dbo.Entrega(id),

        CONSTRAINT FK_EntregaTercero_Tercero
            FOREIGN KEY (idTercero)
            REFERENCES dbo.Tercero(id),

        CONSTRAINT UK_EntregaTercero_entrega_tercero
            UNIQUE (idEntrega, idTercero)
    );
END;
GO


/* ============================================================
   SERVICIO ENTREGA
   ============================================================ */

IF OBJECT_ID('dbo.ServicioEntrega', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.ServicioEntrega (
        id UNIQUEIDENTIFIER NOT NULL,
        idServicio UNIQUEIDENTIFIER NOT NULL,
        idEntrega UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_ServicioEntrega
            PRIMARY KEY (id),

        CONSTRAINT FK_ServicioEntrega_Servicio
            FOREIGN KEY (idServicio)
            REFERENCES dbo.Servicio(id),

        CONSTRAINT FK_ServicioEntrega_Entrega
            FOREIGN KEY (idEntrega)
            REFERENCES dbo.Entrega(id),

        CONSTRAINT UK_ServicioEntrega_servicio_entrega
            UNIQUE (idServicio, idEntrega)
    );
END;
GO


/* ============================================================
   SERVICIO FACTURA
   ============================================================ */

IF OBJECT_ID('dbo.ServicioFactura', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.ServicioFactura (
        id UNIQUEIDENTIFIER NOT NULL,
        idServicio UNIQUEIDENTIFIER NOT NULL,
        idFactura UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_ServicioFactura
            PRIMARY KEY (id),

        CONSTRAINT FK_ServicioFactura_Servicio
            FOREIGN KEY (idServicio)
            REFERENCES dbo.Servicio(id),

        CONSTRAINT FK_ServicioFactura_Factura
            FOREIGN KEY (idFactura)
            REFERENCES dbo.Factura(id),

        CONSTRAINT UK_ServicioFactura_servicio_factura
            UNIQUE (idServicio, idFactura)
    );
END;
GO


/* ============================================================
   COSTO RECORRIDO
   ============================================================ */

IF OBJECT_ID('dbo.CostoRecorrido', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.CostoRecorrido (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroCosto VARCHAR(30) NOT NULL,
        idDetalleEntrega UNIQUEIDENTIFIER NOT NULL,
        valorPorKM INT NOT NULL,
        valorCosto DECIMAL(18,2) NOT NULL,

        CONSTRAINT PK_CostoRecorrido
            PRIMARY KEY (id),

        CONSTRAINT FK_CostoRecorrido_DetalleEntrega
            FOREIGN KEY (idDetalleEntrega)
            REFERENCES dbo.DetalleEntrega(id),

        CONSTRAINT UK_CostoRecorrido_numeroCosto
            UNIQUE (numeroCosto),

        CONSTRAINT CK_CostoRecorrido_valorPorKM
            CHECK (
                valorPorKM >= 0
                AND valorPorKM <= 9999999
            ),

        CONSTRAINT CK_CostoRecorrido_valorCosto
            CHECK (
                valorCosto >= 0
                AND valorCosto <= 999999999
            )
    );
END;
GO


/* ============================================================
   UTILIDAD
   ============================================================ */

IF OBJECT_ID('dbo.Utilidad', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Utilidad (
        id UNIQUEIDENTIFIER NOT NULL,
        idServicio UNIQUEIDENTIFIER NOT NULL,
        valorIngresos DECIMAL(18,2) NOT NULL,
        valorCostos DECIMAL(18,2) NOT NULL,
        valorUtilidad DECIMAL(18,2) NOT NULL,

        CONSTRAINT PK_Utilidad
            PRIMARY KEY (id),

        CONSTRAINT FK_Utilidad_Servicio
            FOREIGN KEY (idServicio)
            REFERENCES dbo.Servicio(id),

        CONSTRAINT UK_Utilidad_servicio
            UNIQUE (idServicio),

        CONSTRAINT CK_Utilidad_valorIngresos
            CHECK (valorIngresos >= 0),

        CONSTRAINT CK_Utilidad_valorCostos
            CHECK (valorCostos >= 0)
    );
END;
GO


/* ============================================================
   PRELIQUIDACION
   ============================================================ */

IF OBJECT_ID('dbo.Preliquidacion', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Preliquidacion (
        id UNIQUEIDENTIFIER NOT NULL,
        numeroPreliquidacion VARCHAR(30) NOT NULL,
        idTercero UNIQUEIDENTIFIER NOT NULL,
        idCostoRecorrido UNIQUEIDENTIFIER NOT NULL,
        fechaPreliquidacion DATE NOT NULL,
        estado VARCHAR(15) NOT NULL,

        CONSTRAINT PK_Preliquidacion
            PRIMARY KEY (id),

        CONSTRAINT FK_Preliquidacion_Tercero
            FOREIGN KEY (idTercero)
            REFERENCES dbo.Tercero(id),

        CONSTRAINT FK_Preliquidacion_CostoRecorrido
            FOREIGN KEY (idCostoRecorrido)
            REFERENCES dbo.CostoRecorrido(id),

        CONSTRAINT UK_Preliquidacion_numeroPreliquidacion
            UNIQUE (numeroPreliquidacion),

        CONSTRAINT CK_Preliquidacion_estado
            CHECK (
                estado IN (
                    'Pendiente',
                    'Pagada',
                    'Anulada'
                )
            )
    );
END;
GO