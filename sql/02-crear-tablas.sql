USE KETRA;
GO

IF OBJECT_ID(N'dbo.EstadoServicio', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.EstadoServicio (
        id UNIQUEIDENTIFIER NOT NULL,
        codigo VARCHAR(6) NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_EstadoServicio PRIMARY KEY (id),
        CONSTRAINT UK_EstadoServicio_nombre UNIQUE (nombre),
        CONSTRAINT UK_EstadoServicio_codigo UNIQUE (codigo)
    );
END;
GO


IF OBJECT_ID(N'dbo.EstadoEntrega', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.EstadoEntrega (
        id UNIQUEIDENTIFIER NOT NULL,
        codigo VARCHAR(6) NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_EstadoEntrega PRIMARY KEY (id),
        CONSTRAINT UK_EstadoEntrega_nombre UNIQUE (nombre),
        CONSTRAINT UK_EstadoEntrega_codigo UNIQUE (codigo)
    );
END;
GO


IF OBJECT_ID(N'dbo.EstadoFactura', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.EstadoFactura (
        id UNIQUEIDENTIFIER NOT NULL,
        codigo VARCHAR(6) NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_EstadoFactura PRIMARY KEY (id),
        CONSTRAINT UK_EstadoFactura_nombre UNIQUE (nombre),
        CONSTRAINT UK_EstadoFactura_codigo UNIQUE (codigo)
    );
END;
GO


IF OBJECT_ID(N'dbo.EstadoPreliquidacion', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.EstadoPreliquidacion (
        id UNIQUEIDENTIFIER NOT NULL,
        codigo VARCHAR(6) NOT NULL,
        nombre VARCHAR(50) NOT NULL,

        CONSTRAINT PK_EstadoPreliquidacion PRIMARY KEY (id),
        CONSTRAINT UK_EstadoPreliquidacion_nombre UNIQUE (nombre),
        CONSTRAINT UK_EstadoPreliquidacion_codigo UNIQUE (codigo)
    );
END;
GO


-- Incorporar codigos cuando los catalogos ya existian sin esa columna.
-- Conserva los identificadores y las relaciones existentes.
IF COL_LENGTH(N'dbo.EstadoServicio', N'codigo') IS NULL
    ALTER TABLE dbo.EstadoServicio ADD codigo VARCHAR(6) NULL;

IF COL_LENGTH(N'dbo.EstadoEntrega', N'codigo') IS NULL
    ALTER TABLE dbo.EstadoEntrega ADD codigo VARCHAR(6) NULL;

IF COL_LENGTH(N'dbo.EstadoFactura', N'codigo') IS NULL
    ALTER TABLE dbo.EstadoFactura ADD codigo VARCHAR(6) NULL;

IF COL_LENGTH(N'dbo.EstadoPreliquidacion', N'codigo') IS NULL
    ALTER TABLE dbo.EstadoPreliquidacion ADD codigo VARCHAR(6) NULL;

GO

SET XACT_ABORT ON;

BEGIN TRY
    BEGIN TRANSACTION;

    UPDATE dbo.EstadoServicio
    SET codigo = CASE nombre
        WHEN N'Registrado' THEN 'SER-01'
        WHEN N'En ejecución' THEN 'SER-02'
        WHEN N'Finalizado' THEN 'SER-03'
        WHEN N'Cancelado' THEN 'SER-04'
        ELSE codigo
    END
    WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '';

    IF EXISTS (SELECT 1 FROM dbo.EstadoServicio WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '')
        THROW 51001, 'Hay estados sin codigo en EstadoServicio. Asigne su codigo antes de continuar.', 1;

    IF EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID(N'dbo.EstadoServicio') AND name = N'codigo' AND is_nullable = 1)
        ALTER TABLE dbo.EstadoServicio ALTER COLUMN codigo VARCHAR(6) NOT NULL;

    IF NOT EXISTS (SELECT 1 FROM sys.key_constraints WHERE name = N'UK_EstadoServicio_codigo' AND parent_object_id = OBJECT_ID(N'dbo.EstadoServicio'))
        ALTER TABLE dbo.EstadoServicio ADD CONSTRAINT UK_EstadoServicio_codigo UNIQUE (codigo);

    UPDATE dbo.EstadoEntrega
    SET codigo = CASE nombre
        WHEN N'Pendiente' THEN 'ENT-01'
        WHEN N'En tránsito' THEN 'ENT-02'
        WHEN N'Entregada' THEN 'ENT-03'
        WHEN N'Cancelada' THEN 'ENT-04'
        ELSE codigo
    END
    WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '';

    IF EXISTS (SELECT 1 FROM dbo.EstadoEntrega WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '')
        THROW 51002, 'Hay estados sin codigo en EstadoEntrega. Asigne su codigo antes de continuar.', 1;

    IF EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID(N'dbo.EstadoEntrega') AND name = N'codigo' AND is_nullable = 1)
        ALTER TABLE dbo.EstadoEntrega ALTER COLUMN codigo VARCHAR(6) NOT NULL;

    IF NOT EXISTS (SELECT 1 FROM sys.key_constraints WHERE name = N'UK_EstadoEntrega_codigo' AND parent_object_id = OBJECT_ID(N'dbo.EstadoEntrega'))
        ALTER TABLE dbo.EstadoEntrega ADD CONSTRAINT UK_EstadoEntrega_codigo UNIQUE (codigo);

    UPDATE dbo.EstadoFactura
    SET codigo = CASE nombre
        WHEN N'Pendiente' THEN 'FAC-01'
        WHEN N'Pagada' THEN 'FAC-02'
        WHEN N'Anulada' THEN 'FAC-03'
        ELSE codigo
    END
    WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '';

    IF EXISTS (SELECT 1 FROM dbo.EstadoFactura WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '')
        THROW 51003, 'Hay estados sin codigo en EstadoFactura. Asigne su codigo antes de continuar.', 1;

    IF EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID(N'dbo.EstadoFactura') AND name = N'codigo' AND is_nullable = 1)
        ALTER TABLE dbo.EstadoFactura ALTER COLUMN codigo VARCHAR(6) NOT NULL;

    IF NOT EXISTS (SELECT 1 FROM sys.key_constraints WHERE name = N'UK_EstadoFactura_codigo' AND parent_object_id = OBJECT_ID(N'dbo.EstadoFactura'))
        ALTER TABLE dbo.EstadoFactura ADD CONSTRAINT UK_EstadoFactura_codigo UNIQUE (codigo);

    UPDATE dbo.EstadoPreliquidacion
    SET codigo = CASE nombre
        WHEN N'Pendiente' THEN 'PRE-01'
        WHEN N'Pagada' THEN 'PRE-02'
        WHEN N'Anulada' THEN 'PRE-03'
        ELSE codigo
    END
    WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '';

    IF EXISTS (SELECT 1 FROM dbo.EstadoPreliquidacion WHERE codigo IS NULL OR LTRIM(RTRIM(codigo)) = '')
        THROW 51004, 'Hay estados sin codigo en EstadoPreliquidacion. Asigne su codigo antes de continuar.', 1;

    IF EXISTS (SELECT 1 FROM sys.columns WHERE object_id = OBJECT_ID(N'dbo.EstadoPreliquidacion') AND name = N'codigo' AND is_nullable = 1)
        ALTER TABLE dbo.EstadoPreliquidacion ALTER COLUMN codigo VARCHAR(6) NOT NULL;

    IF NOT EXISTS (SELECT 1 FROM sys.key_constraints WHERE name = N'UK_EstadoPreliquidacion_codigo' AND parent_object_id = OBJECT_ID(N'dbo.EstadoPreliquidacion'))
        ALTER TABLE dbo.EstadoPreliquidacion ADD CONSTRAINT UK_EstadoPreliquidacion_codigo UNIQUE (codigo);

    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    IF @@TRANCOUNT > 0
        ROLLBACK TRANSACTION;

    THROW;
END CATCH;
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
        idEstadoServicio UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_Servicio
            PRIMARY KEY (id),

        CONSTRAINT UK_Servicio_numeroServicio
            UNIQUE (numeroServicio),

        CONSTRAINT FK_Servicio_EstadoServicio
            FOREIGN KEY (idEstadoServicio)
            REFERENCES dbo.EstadoServicio(id)
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
        idEstadoEntrega UNIQUEIDENTIFIER NOT NULL,
        idPersona UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_Entrega
            PRIMARY KEY (id),

        CONSTRAINT FK_Entrega_Persona
            FOREIGN KEY (idPersona)
            REFERENCES dbo.Persona(id),

        CONSTRAINT UK_Entrega_codigoEntrega
            UNIQUE (codigoEntrega),

        CONSTRAINT FK_Entrega_EstadoEntrega
            FOREIGN KEY (idEstadoEntrega)
            REFERENCES dbo.EstadoEntrega(id)
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
        idEstadoFactura UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_Factura
            PRIMARY KEY (id),

        CONSTRAINT UK_Factura_numeroFactura
            UNIQUE (numeroFactura),

        CONSTRAINT CK_Factura_ingresos
            CHECK (
                ingresos >= 0
                AND ingresos <= 100000000
            ),

        CONSTRAINT FK_Factura_EstadoFactura
            FOREIGN KEY (idEstadoFactura)
            REFERENCES dbo.EstadoFactura(id)
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
        idEstadoPreliquidacion UNIQUEIDENTIFIER NOT NULL,

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

        CONSTRAINT FK_Preliquidacion_EstadoPreliquidacion
            FOREIGN KEY (idEstadoPreliquidacion)
            REFERENCES dbo.EstadoPreliquidacion(id)
    );
END;
GO

SET XACT_ABORT ON;

BEGIN TRY
    BEGIN TRANSACTION;

INSERT INTO dbo.EstadoServicio (id, codigo, nombre)
SELECT datos.id, datos.codigo, datos.nombre
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000025-0000-4000-8000-000000000001'), 'SER-01', N'Registrado'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000025-0000-4000-8000-000000000002'), 'SER-02', N'En ejecución'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000025-0000-4000-8000-000000000003'), 'SER-03', N'Finalizado'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000025-0000-4000-8000-000000000004'), 'SER-04', N'Cancelado')
) AS datos (id, codigo, nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM dbo.EstadoServicio existente WHERE existente.codigo = datos.codigo
);

INSERT INTO dbo.EstadoEntrega (id, codigo, nombre)
SELECT datos.id, datos.codigo, datos.nombre
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000026-0000-4000-8000-000000000001'), 'ENT-01', N'Pendiente'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000026-0000-4000-8000-000000000002'), 'ENT-02', N'En tránsito'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000026-0000-4000-8000-000000000003'), 'ENT-03', N'Entregada'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000026-0000-4000-8000-000000000004'), 'ENT-04', N'Cancelada')
) AS datos (id, codigo, nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM dbo.EstadoEntrega existente WHERE existente.codigo = datos.codigo
);

INSERT INTO dbo.EstadoFactura (id, codigo, nombre)
SELECT datos.id, datos.codigo, datos.nombre
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000027-0000-4000-8000-000000000001'), 'FAC-01', N'Pendiente'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000027-0000-4000-8000-000000000002'), 'FAC-02', N'Pagada'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000027-0000-4000-8000-000000000003'), 'FAC-03', N'Anulada')
) AS datos (id, codigo, nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM dbo.EstadoFactura existente WHERE existente.codigo = datos.codigo
);

INSERT INTO dbo.EstadoPreliquidacion (id, codigo, nombre)
SELECT datos.id, datos.codigo, datos.nombre
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000028-0000-4000-8000-000000000001'), 'PRE-01', N'Pendiente'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000028-0000-4000-8000-000000000002'), 'PRE-02', N'Pagada'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000028-0000-4000-8000-000000000003'), 'PRE-03', N'Anulada')
) AS datos (id, codigo, nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM dbo.EstadoPreliquidacion existente WHERE existente.codigo = datos.codigo
);

IF COL_LENGTH(N'dbo.Servicio', N'estado') IS NOT NULL
BEGIN
    IF COL_LENGTH(N'dbo.Servicio', N'idEstadoServicio') IS NULL
        EXEC(N'ALTER TABLE dbo.Servicio ADD idEstadoServicio UNIQUEIDENTIFIER NULL;');

    EXEC(N'UPDATE registro
        SET idEstadoServicio = estado.id
        FROM dbo.Servicio registro
        INNER JOIN dbo.EstadoServicio estado ON LTRIM(RTRIM(registro.estado)) = estado.nombre;');

    EXEC(N'IF EXISTS (SELECT 1 FROM dbo.Servicio WHERE idEstadoServicio IS NULL)
        THROW 50001, ''No se encontró un estado de servicio en el catálogo. No se migraron los datos.'', 1;');

    EXEC(N'ALTER TABLE dbo.Servicio ALTER COLUMN idEstadoServicio UNIQUEIDENTIFIER NOT NULL;');

    IF OBJECT_ID(N'dbo.CK_Servicio_estado', N'C') IS NOT NULL
        EXEC(N'ALTER TABLE dbo.Servicio DROP CONSTRAINT CK_Servicio_estado;');

    EXEC(N'ALTER TABLE dbo.Servicio DROP COLUMN estado;');
END;

IF COL_LENGTH(N'dbo.Servicio', N'idEstadoServicio') IS NULL
    THROW 50002, 'No existe la referencia Servicio.idEstadoServicio.', 1;

IF OBJECT_ID(N'dbo.FK_Servicio_EstadoServicio', N'F') IS NULL
    EXEC(N'ALTER TABLE dbo.Servicio WITH CHECK
        ADD CONSTRAINT FK_Servicio_EstadoServicio
        FOREIGN KEY (idEstadoServicio) REFERENCES dbo.EstadoServicio(id);');

IF COL_LENGTH(N'dbo.Entrega', N'estadoEntrega') IS NOT NULL
BEGIN
    IF COL_LENGTH(N'dbo.Entrega', N'idEstadoEntrega') IS NULL
        EXEC(N'ALTER TABLE dbo.Entrega ADD idEstadoEntrega UNIQUEIDENTIFIER NULL;');

    EXEC(N'UPDATE registro
        SET idEstadoEntrega = estado.id
        FROM dbo.Entrega registro
        INNER JOIN dbo.EstadoEntrega estado ON LTRIM(RTRIM(registro.estadoEntrega)) = estado.nombre;');

    EXEC(N'IF EXISTS (SELECT 1 FROM dbo.Entrega WHERE idEstadoEntrega IS NULL)
        THROW 50001, ''No se encontró un estado de entrega en el catálogo. No se migraron los datos.'', 1;');

    EXEC(N'ALTER TABLE dbo.Entrega ALTER COLUMN idEstadoEntrega UNIQUEIDENTIFIER NOT NULL;');

    IF OBJECT_ID(N'dbo.CK_Entrega_estadoEntrega', N'C') IS NOT NULL
        EXEC(N'ALTER TABLE dbo.Entrega DROP CONSTRAINT CK_Entrega_estadoEntrega;');

    EXEC(N'ALTER TABLE dbo.Entrega DROP COLUMN estadoEntrega;');
END;

IF COL_LENGTH(N'dbo.Entrega', N'idEstadoEntrega') IS NULL
    THROW 50002, 'No existe la referencia Entrega.idEstadoEntrega.', 1;

IF OBJECT_ID(N'dbo.FK_Entrega_EstadoEntrega', N'F') IS NULL
    EXEC(N'ALTER TABLE dbo.Entrega WITH CHECK
        ADD CONSTRAINT FK_Entrega_EstadoEntrega
        FOREIGN KEY (idEstadoEntrega) REFERENCES dbo.EstadoEntrega(id);');

IF COL_LENGTH(N'dbo.Factura', N'estadoFactura') IS NOT NULL
BEGIN
    IF COL_LENGTH(N'dbo.Factura', N'idEstadoFactura') IS NULL
        EXEC(N'ALTER TABLE dbo.Factura ADD idEstadoFactura UNIQUEIDENTIFIER NULL;');

    EXEC(N'UPDATE registro
        SET idEstadoFactura = estado.id
        FROM dbo.Factura registro
        INNER JOIN dbo.EstadoFactura estado ON LTRIM(RTRIM(registro.estadoFactura)) = estado.nombre;');

    EXEC(N'IF EXISTS (SELECT 1 FROM dbo.Factura WHERE idEstadoFactura IS NULL)
        THROW 50001, ''No se encontró un estado de factura en el catálogo. No se migraron los datos.'', 1;');

    EXEC(N'ALTER TABLE dbo.Factura ALTER COLUMN idEstadoFactura UNIQUEIDENTIFIER NOT NULL;');

    IF OBJECT_ID(N'dbo.CK_Factura_estadoFactura', N'C') IS NOT NULL
        EXEC(N'ALTER TABLE dbo.Factura DROP CONSTRAINT CK_Factura_estadoFactura;');

    EXEC(N'ALTER TABLE dbo.Factura DROP COLUMN estadoFactura;');
END;

IF COL_LENGTH(N'dbo.Factura', N'idEstadoFactura') IS NULL
    THROW 50002, 'No existe la referencia Factura.idEstadoFactura.', 1;

IF OBJECT_ID(N'dbo.FK_Factura_EstadoFactura', N'F') IS NULL
    EXEC(N'ALTER TABLE dbo.Factura WITH CHECK
        ADD CONSTRAINT FK_Factura_EstadoFactura
        FOREIGN KEY (idEstadoFactura) REFERENCES dbo.EstadoFactura(id);');

IF COL_LENGTH(N'dbo.Preliquidacion', N'estado') IS NOT NULL
BEGIN
    IF COL_LENGTH(N'dbo.Preliquidacion', N'idEstadoPreliquidacion') IS NULL
        EXEC(N'ALTER TABLE dbo.Preliquidacion ADD idEstadoPreliquidacion UNIQUEIDENTIFIER NULL;');

    EXEC(N'UPDATE registro
        SET idEstadoPreliquidacion = estado.id
        FROM dbo.Preliquidacion registro
        INNER JOIN dbo.EstadoPreliquidacion estado ON LTRIM(RTRIM(registro.estado)) = estado.nombre;');

    EXEC(N'IF EXISTS (SELECT 1 FROM dbo.Preliquidacion WHERE idEstadoPreliquidacion IS NULL)
        THROW 50001, ''No se encontró un estado de preliquidacion en el catálogo. No se migraron los datos.'', 1;');

    EXEC(N'ALTER TABLE dbo.Preliquidacion ALTER COLUMN idEstadoPreliquidacion UNIQUEIDENTIFIER NOT NULL;');

    IF OBJECT_ID(N'dbo.CK_Preliquidacion_estado', N'C') IS NOT NULL
        EXEC(N'ALTER TABLE dbo.Preliquidacion DROP CONSTRAINT CK_Preliquidacion_estado;');

    EXEC(N'ALTER TABLE dbo.Preliquidacion DROP COLUMN estado;');
END;

IF COL_LENGTH(N'dbo.Preliquidacion', N'idEstadoPreliquidacion') IS NULL
    THROW 50002, 'No existe la referencia Preliquidacion.idEstadoPreliquidacion.', 1;

IF OBJECT_ID(N'dbo.FK_Preliquidacion_EstadoPreliquidacion', N'F') IS NULL
    EXEC(N'ALTER TABLE dbo.Preliquidacion WITH CHECK
        ADD CONSTRAINT FK_Preliquidacion_EstadoPreliquidacion
        FOREIGN KEY (idEstadoPreliquidacion) REFERENCES dbo.EstadoPreliquidacion(id);');


IF OBJECT_ID(N'dbo.TransicionEstadoServicio', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.TransicionEstadoServicio (
        id UNIQUEIDENTIFIER NOT NULL,
        idEstadoOrigen UNIQUEIDENTIFIER NOT NULL,
        idEstadoDestino UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_TransicionEstadoServicio PRIMARY KEY (id),
        CONSTRAINT FK_TransicionEstadoServicio_Origen
            FOREIGN KEY (idEstadoOrigen) REFERENCES dbo.EstadoServicio(id),
        CONSTRAINT FK_TransicionEstadoServicio_Destino
            FOREIGN KEY (idEstadoDestino) REFERENCES dbo.EstadoServicio(id),
        CONSTRAINT UK_TransicionEstadoServicio_origen_destino
            UNIQUE (idEstadoOrigen, idEstadoDestino),
        CONSTRAINT CK_TransicionEstadoServicio_estados_diferentes
            CHECK (idEstadoOrigen <> idEstadoDestino)
    );
END;

INSERT INTO dbo.TransicionEstadoServicio (id, idEstadoOrigen, idEstadoDestino)
SELECT datos.id, ori.id, des.id
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000029-0000-4000-8000-000000000001'), 'SER-01', 'SER-02'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000029-0000-4000-8000-000000000002'), 'SER-01', 'SER-04'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000029-0000-4000-8000-000000000003'), 'SER-02', 'SER-03')
) AS datos (id, codigoEstadoOrigen, codigoEstadoDestino)
INNER JOIN dbo.EstadoServicio ori ON ori.codigo = datos.codigoEstadoOrigen
INNER JOIN dbo.EstadoServicio des ON des.codigo = datos.codigoEstadoDestino
WHERE NOT EXISTS (
    SELECT 1
    FROM dbo.TransicionEstadoServicio existente
    WHERE existente.idEstadoOrigen = ori.id
      AND existente.idEstadoDestino = des.id
);

IF OBJECT_ID(N'dbo.TransicionEstadoEntrega', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.TransicionEstadoEntrega (
        id UNIQUEIDENTIFIER NOT NULL,
        idEstadoOrigen UNIQUEIDENTIFIER NOT NULL,
        idEstadoDestino UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_TransicionEstadoEntrega PRIMARY KEY (id),
        CONSTRAINT FK_TransicionEstadoEntrega_Origen
            FOREIGN KEY (idEstadoOrigen) REFERENCES dbo.EstadoEntrega(id),
        CONSTRAINT FK_TransicionEstadoEntrega_Destino
            FOREIGN KEY (idEstadoDestino) REFERENCES dbo.EstadoEntrega(id),
        CONSTRAINT UK_TransicionEstadoEntrega_origen_destino
            UNIQUE (idEstadoOrigen, idEstadoDestino),
        CONSTRAINT CK_TransicionEstadoEntrega_estados_diferentes
            CHECK (idEstadoOrigen <> idEstadoDestino)
    );
END;

INSERT INTO dbo.TransicionEstadoEntrega (id, idEstadoOrigen, idEstadoDestino)
SELECT datos.id, ori.id, des.id
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000030-0000-4000-8000-000000000001'), 'ENT-01', 'ENT-02'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000030-0000-4000-8000-000000000002'), 'ENT-01', 'ENT-04'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000030-0000-4000-8000-000000000003'), 'ENT-02', 'ENT-03')
) AS datos (id, codigoEstadoOrigen, codigoEstadoDestino)
INNER JOIN dbo.EstadoEntrega ori ON ori.codigo = datos.codigoEstadoOrigen
INNER JOIN dbo.EstadoEntrega des ON des.codigo = datos.codigoEstadoDestino
WHERE NOT EXISTS (
    SELECT 1
    FROM dbo.TransicionEstadoEntrega existente
    WHERE existente.idEstadoOrigen = ori.id
      AND existente.idEstadoDestino = des.id
);

IF OBJECT_ID(N'dbo.TransicionEstadoFactura', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.TransicionEstadoFactura (
        id UNIQUEIDENTIFIER NOT NULL,
        idEstadoOrigen UNIQUEIDENTIFIER NOT NULL,
        idEstadoDestino UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_TransicionEstadoFactura PRIMARY KEY (id),
        CONSTRAINT FK_TransicionEstadoFactura_Origen
            FOREIGN KEY (idEstadoOrigen) REFERENCES dbo.EstadoFactura(id),
        CONSTRAINT FK_TransicionEstadoFactura_Destino
            FOREIGN KEY (idEstadoDestino) REFERENCES dbo.EstadoFactura(id),
        CONSTRAINT UK_TransicionEstadoFactura_origen_destino
            UNIQUE (idEstadoOrigen, idEstadoDestino),
        CONSTRAINT CK_TransicionEstadoFactura_estados_diferentes
            CHECK (idEstadoOrigen <> idEstadoDestino)
    );
END;

INSERT INTO dbo.TransicionEstadoFactura (id, idEstadoOrigen, idEstadoDestino)
SELECT datos.id, ori.id, des.id
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000031-0000-4000-8000-000000000001'), 'ENT-01', 'FAC-02'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000031-0000-4000-8000-000000000002'), 'ENT-01', 'FAC-03')
) AS datos (id, codigoEstadoOrigen, codigoEstadoDestino)
INNER JOIN dbo.EstadoFactura ori ON ori.codigo = datos.codigoEstadoOrigen
INNER JOIN dbo.EstadoFactura des ON des.codigo = datos.codigoEstadoDestino
WHERE NOT EXISTS (
    SELECT 1
    FROM dbo.TransicionEstadoFactura existente
    WHERE existente.idEstadoOrigen = ori.id
      AND existente.idEstadoDestino = des.id
);

IF OBJECT_ID(N'dbo.TransicionEstadoPreliquidacion', N'U') IS NULL
BEGIN
    CREATE TABLE dbo.TransicionEstadoPreliquidacion (
        id UNIQUEIDENTIFIER NOT NULL,
        idEstadoOrigen UNIQUEIDENTIFIER NOT NULL,
        idEstadoDestino UNIQUEIDENTIFIER NOT NULL,

        CONSTRAINT PK_TransicionEstadoPreliquidacion PRIMARY KEY (id),
        CONSTRAINT FK_TransicionEstadoPreliquidacion_Origen
            FOREIGN KEY (idEstadoOrigen) REFERENCES dbo.EstadoPreliquidacion(id),
        CONSTRAINT FK_TransicionEstadoPreliquidacion_Destino
            FOREIGN KEY (idEstadoDestino) REFERENCES dbo.EstadoPreliquidacion(id),
        CONSTRAINT UK_TransicionEstadoPreliquidacion_origen_destino
            UNIQUE (idEstadoOrigen, idEstadoDestino),
        CONSTRAINT CK_TransicionEstadoPreliquidacion_estados_diferentes
            CHECK (idEstadoOrigen <> idEstadoDestino)
    );
END;

INSERT INTO dbo.TransicionEstadoPreliquidacion (id, idEstadoOrigen, idEstadoDestino)
SELECT datos.id, ori.id, des.id
FROM (VALUES
        (CONVERT(UNIQUEIDENTIFIER, N'00000032-0000-4000-8000-000000000001'), 'ENT-01', 'FAC-02'),
        (CONVERT(UNIQUEIDENTIFIER, N'00000032-0000-4000-8000-000000000002'), 'ENT-01', 'FAC-03')
) AS datos (id, codigoEstadoOrigen, codigoEstadoDestino)
INNER JOIN dbo.EstadoPreliquidacion ori ON ori.codigo = datos.codigoEstadoOrigen
INNER JOIN dbo.EstadoPreliquidacion des ON des.codigo = datos.codigoEstadoDestino
WHERE NOT EXISTS (
    SELECT 1
    FROM dbo.TransicionEstadoPreliquidacion existente
    WHERE existente.idEstadoOrigen = ori.id
      AND existente.idEstadoDestino = des.id
);

    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    IF @@TRANCOUNT > 0
        ROLLBACK TRANSACTION;
    THROW;
END CATCH;
GO
