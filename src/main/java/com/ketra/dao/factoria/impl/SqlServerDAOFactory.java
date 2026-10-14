package com.ketra.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ketra.dao.datos.entidad.BarrioDAO;
import com.ketra.dao.datos.entidad.CEDIDAO;
import com.ketra.dao.datos.entidad.CostoRecorridoDAO;
import com.ketra.dao.datos.entidad.DepartamentoDAO;
import com.ketra.dao.datos.entidad.DetalleEntregaDAO;
import com.ketra.dao.datos.entidad.DetallePedidoDAO;
import com.ketra.dao.datos.entidad.DireccionDAO;
import com.ketra.dao.datos.entidad.EmpresaDAO;
import com.ketra.dao.datos.entidad.EmpresaServicioDAO;
import com.ketra.dao.datos.entidad.EntregaDAO;
import com.ketra.dao.datos.entidad.EntregaTerceroDAO;
import com.ketra.dao.datos.entidad.FacturaDAO;
import com.ketra.dao.datos.entidad.MunicipioDAO;
import com.ketra.dao.datos.entidad.PaisDAO;
import com.ketra.dao.datos.entidad.PedidoDAO;
import com.ketra.dao.datos.entidad.PersonaDAO;
import com.ketra.dao.datos.entidad.PreliquidacionDAO;
import com.ketra.dao.datos.entidad.ServicioCEDIDAO;
import com.ketra.dao.datos.entidad.ServicioDAO;
import com.ketra.dao.datos.entidad.ServicioEntregaDAO;
import com.ketra.dao.datos.entidad.ServicioFacturaDAO;
import com.ketra.dao.datos.entidad.TerceroDAO;
import com.ketra.dao.datos.entidad.TipoDireccionDAO;
import com.ketra.dao.datos.entidad.TipoDocumentoDAO;
import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.dao.datos.entidad.sqlserver.BarrioSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.CEDISqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.CostoRecorridoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.DetalleEntregaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.DetallePedidoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.DireccionSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.EmpresaServicioSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.EmpresaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.EntregaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.EntregaTerceroSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.FacturaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.MunicipioSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PedidoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PersonaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.PreliquidacionSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.ServicioCEDISqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.ServicioEntregaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.ServicioFacturaSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.ServicioSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.TerceroSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.TipoDireccionSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.TipoDocumentoSqlServerDAO;
import com.ketra.dao.datos.entidad.sqlserver.UtilidadSqlServerDAO;
import com.ketra.dao.factoria.DAOFactory;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilSQL;

public class SqlServerDAOFactory extends DAOFactory{

	public SqlServerDAOFactory() {
		super();
	}

	@Override
	protected void abrirConexion() {

		if (UtilSQL.conexionEstaAbierta(getConexion())) {
			
			return;
			
		}

		try {

			String url = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=KETRA;"
					+ "integratedSecurity=true;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true";

			Connection conexion = DriverManager.getConnection(url);

			setConexion(conexion);

		} catch (SQLException excepcion) {


			var mensajeUsuario =CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_CONEXION_SQL_SERVER;
			var mensajeTecnico =CatalogoMensajes.SqlServerDAOFactory.TECNICO_ERROR_CONEXION_SQL_SERVER + excepcion.getMessage();
			throw KETRADatosException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		
		return new PaisSqlServerDAO(getConexion());
		
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO(getConexion());
	}

	@Override
	public UtilidadDAO obtenerUtilidadDAO() {
		return new UtilidadSqlServerDAO(getConexion());
	}

	@Override
	public ServicioDAO obtenerServicioDAO() {
		return new ServicioSqlServerDAO(getConexion());
	}

	@Override
	public FacturaDAO obtenerFacturaDAO() {
		return new FacturaSqlServerDAO(getConexion());
	}

	@Override
	public CostoRecorridoDAO obtenerCostoRecorridoDAO() {
		return new CostoRecorridoSqlServerDAO(getConexion());
	}
	
	


	@Override
	public BarrioDAO obtenerBarrioDAO() {
		return new BarrioSqlServerDAO(getConexion());
	}

	@Override
	public CEDIDAO obtenerCEDIDAO() {
		return new CEDISqlServerDAO(getConexion());
	}

	@Override
	public DetalleEntregaDAO obtenerDetalleEntregaDAO() {
		return new DetalleEntregaSqlServerDAO(getConexion());
	}

	@Override
	public DetallePedidoDAO obtenerDetallePedidoDAO() {
		return new DetallePedidoSqlServerDAO(getConexion());
	}

	@Override
	public DireccionDAO obtenerDireccionDAO() {
		return new DireccionSqlServerDAO(getConexion());
	}

	@Override
	public EmpresaDAO obtenerEmpresaDAO() {
		return new EmpresaSqlServerDAO(getConexion());
	}

	@Override
	public EmpresaServicioDAO obtenerEmpresaServicioDAO() {
		return new EmpresaServicioSqlServerDAO(getConexion());
	}

	@Override
	public EntregaDAO obtenerEntregaDAO() {
		return new EntregaSqlServerDAO(getConexion());
	}

	@Override
	public EntregaTerceroDAO obtenerEntregaTerceroDAO() {
		return new EntregaTerceroSqlServerDAO(getConexion());
	}

	@Override
	public MunicipioDAO obtenerMunicipioDAO() {
		return new MunicipioSqlServerDAO(getConexion());
	}

	@Override
	public PedidoDAO obtenerPedidoDAO() {
		return new PedidoSqlServerDAO(getConexion());
	}

	@Override
	public PersonaDAO obtenerPersonaDAO() {
		return new PersonaSqlServerDAO(getConexion());
	}

	@Override
	public PreliquidacionDAO obtenerPreliquidacionDAO() {
		return new PreliquidacionSqlServerDAO(getConexion());
	}

	@Override
	public ServicioCEDIDAO obtenerServicioCEDIDAO() {
		return new ServicioCEDISqlServerDAO(getConexion());
	}

	@Override
	public ServicioEntregaDAO obtenerServicioEntregaDAO() {
		return new ServicioEntregaSqlServerDAO(getConexion());
	}

	@Override
	public ServicioFacturaDAO obtenerServicioFacturaDAO() {
		return new ServicioFacturaSqlServerDAO(getConexion());
	}

	@Override
	public TerceroDAO obtenerTerceroDAO() {
		return new TerceroSqlServerDAO(getConexion());
	}

	@Override
	public TipoDireccionDAO obtenerTipoDireccionDAO() {
		return new TipoDireccionSqlServerDAO(getConexion());
	}

	@Override
	public TipoDocumentoDAO obtenerTipoDocumentoDAO() {
		return new TipoDocumentoSqlServerDAO(getConexion());
	}
}
