package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.PreliquidacionDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.entidad.DepartamentoEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.MunicipioEntidad;
import com.ketra.entidad.PaisEntidad;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.PreliquidacionEntidad;
import com.ketra.entidad.TerceroEntidad;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilFecha;

public class PreliquidacionSqlServerDAO extends SqlDAO implements PreliquidacionDAO {

	public PreliquidacionSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public PreliquidacionEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					pre.id AS id,
					pre.numeroPreliquidacion AS numeroPreliquidacion,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto,
					cre.id AS cre_id,
					cre.numeroCosto AS cre_numeroCosto,
					den.id AS den_id,
					den.numeroDetalleEntrega AS den_numeroDetalleEntrega,
					ped.id AS ped_id,
					ped.numeroPedido AS ped_numeroPedido,
					ped.fechaPedido AS ped_fechaPedido,
					ent.id AS ent_id,
					ent.codigoEntrega AS ent_codigoEntrega,
					ent.fechaEntrega AS ent_fechaEntrega,
					ent.estadoEntrega AS ent_estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico,
					ced.id AS ced_id,
					ced.nombre AS ced_nombre,
					dir.id AS dir_id,
					dir.nombre AS dir_nombre,
					bar.id AS bar_id,
					bar.nombre AS bar_nombre,
					mun.id AS mun_id,
					mun.nombre AS mun_nombre,
					dep.id AS dep_id,
					dep.nombre AS dep_nombre,
					pai.id AS pai_id,
					pai.nombre AS pai_nombre,
					tdi.id AS tdi_id,
					tdi.nombre AS tdi_nombre,
					dir2.id AS dir2_id,
					dir2.nombre AS dir2_nombre,
					bar2.id AS bar2_id,
					bar2.nombre AS bar2_nombre,
					mun2.id AS mun2_id,
					mun2.nombre AS mun2_nombre,
					dep2.id AS dep2_id,
					dep2.nombre AS dep2_nombre,
					pai2.id AS pai2_id,
					pai2.nombre AS pai2_nombre,
					tdi2.id AS tdi2_id,
					tdi2.nombre AS tdi2_nombre,
					den.distanciaKM AS den_distanciaKM,
					cre.valorPorKM AS cre_valorPorKM,
					cre.valorCosto AS cre_valorCosto,
					pre.fechaPreliquidacion AS fechaPreliquidacion,
					pre.estado AS estado
				FROM Preliquidacion pre
				INNER JOIN Tercero ter ON pre.idTercero = ter.id
				INNER JOIN CostoRecorrido cre ON pre.idCostoRecorrido = cre.id
				INNER JOIN DetalleEntrega den ON cre.idDetalleEntrega = den.id
				INNER JOIN Pedido ped ON den.idPedido = ped.id
				INNER JOIN Entrega ent ON den.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				INNER JOIN CEDI ced ON den.idCediOrigen = ced.id
				INNER JOIN Direccion dir ON ced.idDireccion = dir.id
				INNER JOIN Barrio bar ON dir.idBarrio = bar.id
				INNER JOIN Municipio mun ON bar.idMunicipio = mun.id
				INNER JOIN Departamento dep ON mun.idDepartamento = dep.id
				INNER JOIN Pais pai ON dep.idPais = pai.id
				INNER JOIN TipoDireccion tdi ON dir.idTipoDireccion = tdi.id
				INNER JOIN Direccion dir2 ON den.idDireccionDestino = dir2.id
				INNER JOIN Barrio bar2 ON dir2.idBarrio = bar2.id
				INNER JOIN Municipio mun2 ON bar2.idMunicipio = mun2.id
				INNER JOIN Departamento dep2 ON mun2.idDepartamento = dep2.id
				INNER JOIN Pais pai2 ON dep2.idPais = pai2.id
				INNER JOIN TipoDireccion tdi2 ON dir2.idTipoDireccion = tdi2.id
				WHERE pre.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirPreliquidacionEntidad(resultado);
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return new PreliquidacionEntidad.Builder().build();
	}

	@Override
	public List<PreliquidacionEntidad> consultarPorFiltro(PreliquidacionEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					pre.id AS id,
					pre.numeroPreliquidacion AS numeroPreliquidacion,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto,
					cre.id AS cre_id,
					cre.numeroCosto AS cre_numeroCosto,
					den.id AS den_id,
					den.numeroDetalleEntrega AS den_numeroDetalleEntrega,
					ped.id AS ped_id,
					ped.numeroPedido AS ped_numeroPedido,
					ped.fechaPedido AS ped_fechaPedido,
					ent.id AS ent_id,
					ent.codigoEntrega AS ent_codigoEntrega,
					ent.fechaEntrega AS ent_fechaEntrega,
					ent.estadoEntrega AS ent_estadoEntrega,
					per.id AS per_id,
					tdo.id AS tdo_id,
					tdo.nombre AS tdo_nombre,
					per.numeroIdentificacion AS per_numeroIdentificacion,
					per.primerNombre AS per_primerNombre,
					per.segundoNombre AS per_segundoNombre,
					per.primerApellido AS per_primerApellido,
					per.segundoApellido AS per_segundoApellido,
					per.numeroTelefonico AS per_numeroTelefonico,
					per.correoElectronico AS per_correoElectronico,
					ced.id AS ced_id,
					ced.nombre AS ced_nombre,
					dir.id AS dir_id,
					dir.nombre AS dir_nombre,
					bar.id AS bar_id,
					bar.nombre AS bar_nombre,
					mun.id AS mun_id,
					mun.nombre AS mun_nombre,
					dep.id AS dep_id,
					dep.nombre AS dep_nombre,
					pai.id AS pai_id,
					pai.nombre AS pai_nombre,
					tdi.id AS tdi_id,
					tdi.nombre AS tdi_nombre,
					dir2.id AS dir2_id,
					dir2.nombre AS dir2_nombre,
					bar2.id AS bar2_id,
					bar2.nombre AS bar2_nombre,
					mun2.id AS mun2_id,
					mun2.nombre AS mun2_nombre,
					dep2.id AS dep2_id,
					dep2.nombre AS dep2_nombre,
					pai2.id AS pai2_id,
					pai2.nombre AS pai2_nombre,
					tdi2.id AS tdi2_id,
					tdi2.nombre AS tdi2_nombre,
					den.distanciaKM AS den_distanciaKM,
					cre.valorPorKM AS cre_valorPorKM,
					cre.valorCosto AS cre_valorCosto,
					pre.fechaPreliquidacion AS fechaPreliquidacion,
					pre.estado AS estado
				FROM Preliquidacion pre
				INNER JOIN Tercero ter ON pre.idTercero = ter.id
				INNER JOIN CostoRecorrido cre ON pre.idCostoRecorrido = cre.id
				INNER JOIN DetalleEntrega den ON cre.idDetalleEntrega = den.id
				INNER JOIN Pedido ped ON den.idPedido = ped.id
				INNER JOIN Entrega ent ON den.idEntrega = ent.id
				INNER JOIN Persona per ON ent.idPersona = per.id
				INNER JOIN TipoDocumento tdo ON per.idTipoDocumento = tdo.id
				INNER JOIN CEDI ced ON den.idCediOrigen = ced.id
				INNER JOIN Direccion dir ON ced.idDireccion = dir.id
				INNER JOIN Barrio bar ON dir.idBarrio = bar.id
				INNER JOIN Municipio mun ON bar.idMunicipio = mun.id
				INNER JOIN Departamento dep ON mun.idDepartamento = dep.id
				INNER JOIN Pais pai ON dep.idPais = pai.id
				INNER JOIN TipoDireccion tdi ON dir.idTipoDireccion = tdi.id
				INNER JOIN Direccion dir2 ON den.idDireccionDestino = dir2.id
				INNER JOIN Barrio bar2 ON dir2.idBarrio = bar2.id
				INNER JOIN Municipio mun2 ON bar2.idMunicipio = mun2.id
				INNER JOIN Departamento dep2 ON mun2.idDepartamento = dep2.id
				INNER JOIN Pais pai2 ON dep2.idPais = pai2.id
				INNER JOIN TipoDireccion tdi2 ON dir2.idTipoDireccion = tdi2.id
				""");
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("pre.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroPreliquidacion())) {
			condiciones.add("pre.numeroPreliquidacion = ?");
			parametros.add(filtro.getNumeroPreliquidacion());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getTercero().getId())) {
			condiciones.add("pre.idTercero = ?");
			parametros.add(filtro.getTercero().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getValorCosto().getId())) {
			condiciones.add("pre.idCostoRecorrido = ?");
			parametros.add(filtro.getValorCosto().getId());
		}

		if (!UtilFecha.FECHA_DEFECTO.equals(filtro.getFechaPreliquidacion())) {
			condiciones.add("pre.fechaPreliquidacion = ?");
			parametros.add(java.sql.Date.valueOf(filtro.getFechaPreliquidacion()));
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstado())) {
			condiciones.add("pre.estado = ?");
			parametros.add(filtro.getEstado());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<PreliquidacionEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirPreliquidacionEntidad(resultado));
				}
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR + excepcion.getMessage(),
					excepcion);
		}

		return resultados;
	}

	@Override
	public List<PreliquidacionEntidad> consultarTodos() {
		return consultarPorFiltro(new PreliquidacionEntidad.Builder().build());
	}

	@Override
	public void crear(PreliquidacionEntidad entidad) {

		final String sql = """
				INSERT INTO Preliquidacion (
					id,
					numeroPreliquidacion,
					idTercero,
					idCostoRecorrido,
					fechaPreliquidacion,
					estado
				)
				VALUES (?, ?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroPreliquidacion());
			sentencia.setObject(3, entidad.getTercero().getId());
			sentencia.setObject(4, entidad.getValorCosto().getId());
			sentencia.setDate(5, java.sql.Date.valueOf(entidad.getFechaPreliquidacion()));
			sentencia.setString(6, entidad.getEstado());

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CREAR + excepcion.getMessage(),
					excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, PreliquidacionEntidad entidad) {

		final String sql = """
				UPDATE Preliquidacion
				SET
					numeroPreliquidacion = ?,
					idTercero = ?,
					idCostoRecorrido = ?,
					fechaPreliquidacion = ?,
					estado = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getNumeroPreliquidacion());
			sentencia.setObject(2, entidad.getTercero().getId());
			sentencia.setObject(3, entidad.getValorCosto().getId());
			sentencia.setDate(4, java.sql.Date.valueOf(entidad.getFechaPreliquidacion()));
			sentencia.setString(5, entidad.getEstado());
			sentencia.setObject(6, id);

			sentencia.executeUpdate();

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ACTUALIZAR + excepcion.getMessage(),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ACTUALIZAR + excepcion.getMessage(),
					excepcion);
		}
	}

	private PreliquidacionEntidad construirPreliquidacionEntidad(final ResultSet resultado) throws SQLException {

		final TerceroEntidad ter = new TerceroEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ter_id")))
				.nombre(resultado.getString("ter_nombre"))
				.NIT(resultado.getString("ter_nit"))
				.numeroContacto(resultado.getString("ter_numeroContacto"))
				.correoContacto(resultado.getString("ter_correoContacto"))
				.build();

		final PedidoEntidad ped = new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ped_id")))
				.numeroPedido(resultado.getString("ped_numeroPedido"))
				.fechaPedido(resultado.getDate("ped_fechaPedido").toLocalDate())
				.build();

		final TipoDocumentoEntidad tdo = new TipoDocumentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdo_id")))
				.nombre(resultado.getString("tdo_nombre"))
				.build();

		final PersonaEntidad per = new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("per_id")))
				.tipoDocumento(tdo)
				.numeroIdentificacion(resultado.getString("per_numeroIdentificacion"))
				.primerNombre(resultado.getString("per_primerNombre"))
				.segundoNombre(resultado.getString("per_segundoNombre"))
				.primerApellido(resultado.getString("per_primerApellido"))
				.segundoApellido(resultado.getString("per_segundoApellido"))
				.numeroTelefonico(resultado.getString("per_numeroTelefonico"))
				.correoElectronico(resultado.getString("per_correoElectronico"))
				.build();

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_id")))
				.codigoEntrega(resultado.getString("ent_codigoEntrega"))
				.fechaEntrega(resultado.getDate("ent_fechaEntrega").toLocalDate())
				.estadoEntrega(resultado.getString("ent_estadoEntrega"))
				.persona(per)
				.build();

		final PaisEntidad pai = new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("pai_id")))
				.nombre(resultado.getString("pai_nombre"))
				.build();

		final DepartamentoEntidad dep = new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dep_id")))
				.nombre(resultado.getString("dep_nombre"))
				.pais(pai)
				.build();

		final MunicipioEntidad mun = new MunicipioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("mun_id")))
				.nombre(resultado.getString("mun_nombre"))
				.departamento(dep)
				.build();

		final BarrioEntidad bar = new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("bar_id")))
				.nombre(resultado.getString("bar_nombre"))
				.municipio(mun)
				.build();

		final TipoDireccionEntidad tdi = new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdi_id")))
				.nombre(resultado.getString("tdi_nombre"))
				.build();

		final DireccionEntidad dir = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir_id")))
				.nombre(resultado.getString("dir_nombre"))
				.barrio(bar)
				.direccion(tdi)
				.build();

		final CEDIEntidad ced = new CEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ced_id")))
				.nombre(resultado.getString("ced_nombre"))
				.direccion(dir)
				.build();

		final PaisEntidad pai2 = new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("pai2_id")))
				.nombre(resultado.getString("pai2_nombre"))
				.build();

		final DepartamentoEntidad dep2 = new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dep2_id")))
				.nombre(resultado.getString("dep2_nombre"))
				.pais(pai2)
				.build();

		final MunicipioEntidad mun2 = new MunicipioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("mun2_id")))
				.nombre(resultado.getString("mun2_nombre"))
				.departamento(dep2)
				.build();

		final BarrioEntidad bar2 = new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("bar2_id")))
				.nombre(resultado.getString("bar2_nombre"))
				.municipio(mun2)
				.build();

		final TipoDireccionEntidad tdi2 = new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("tdi2_id")))
				.nombre(resultado.getString("tdi2_nombre"))
				.build();

		final DireccionEntidad dir2 = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir2_id")))
				.nombre(resultado.getString("dir2_nombre"))
				.barrio(bar2)
				.direccion(tdi2)
				.build();

		final DetalleEntregaEntidad den = new DetalleEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_id")))
				.numeroDetalleEntrega(resultado.getString("den_numeroDetalleEntrega"))
				.pedido(ped)
				.entrega(ent)
				.CEDIOrigen(ced)
				.direccionDestino(dir2)
				.distanciaKM(resultado.getDouble("den_distanciaKM"))
				.build();

		final CostoRecorridoEntidad cre = new CostoRecorridoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("cre_id")))
				.numeroCosto(resultado.getString("cre_numeroCosto"))
				.detalleEntrega(den)
				.valorPorKM(resultado.getInt("cre_valorPorKM"))
				.valorCosto(resultado.getDouble("cre_valorCosto"))
				.build();

		return new PreliquidacionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroPreliquidacion(resultado.getString("numeroPreliquidacion"))
				.tercero(ter)
				.valorCosto(cre)
				.fechaPreliquidacion(resultado.getDate("fechaPreliquidacion").toLocalDate())
				.Estado(resultado.getString("estado"))
				.build();
	}
}
