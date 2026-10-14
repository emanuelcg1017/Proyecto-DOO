package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.CostoRecorridoDAO;
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
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.entidad.TipoDocumentoEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilNumero;

public class CostoRecorridoSqlServerDAO extends SqlDAO implements CostoRecorridoDAO {

	public CostoRecorridoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public CostoRecorridoEntidad consultarPorId(UUID id) {

		final String sql = """
				SELECT
					cre.id AS id,
					cre.numeroCosto AS numeroCosto,
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
					cre.valorPorKM AS valorPorKM,
					cre.valorCosto AS valorCosto
				FROM CostoRecorrido cre
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
				WHERE cre.id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirCostoRecorridoEntidad(resultado);
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

		return new CostoRecorridoEntidad.Builder().build();
	}

	@Override
	public List<CostoRecorridoEntidad> consultarPorFiltro(CostoRecorridoEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
				SELECT
					cre.id AS id,
					cre.numeroCosto AS numeroCosto,
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
					cre.valorPorKM AS valorPorKM,
					cre.valorCosto AS valorCosto
				FROM CostoRecorrido cre
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
			condiciones.add("cre.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroCosto())) {
			condiciones.add("cre.numeroCosto = ?");
			parametros.add(filtro.getNumeroCosto());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getDetalleEntrega().getId())) {
			condiciones.add("cre.idDetalleEntrega = ?");
			parametros.add(filtro.getDetalleEntrega().getId());
		}

		if (filtro.getValorPorKM() != UtilNumero.CERO) {
			condiciones.add("cre.valorPorKM = ?");
			parametros.add(filtro.getValorPorKM());
		}

		if (filtro.getValorCosto().doubleValue() != UtilNumero.CERO_DECIMAL) {
			condiciones.add("cre.valorCosto = ?");
			parametros.add(filtro.getValorCosto());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<CostoRecorridoEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirCostoRecorridoEntidad(resultado));
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
	public List<CostoRecorridoEntidad> consultarTodos() {
		return consultarPorFiltro(new CostoRecorridoEntidad.Builder().build());
	}

	@Override
	public Double consultarTotalCostosPorServicio(UUID idServicio, String estadoEntregaRequerido) {

		final String sql = """
				SELECT COALESCE(SUM(cre.valorCosto), 0) AS totalCostos
				FROM ServicioEntrega sen
				INNER JOIN Entrega ent ON sen.idEntrega = ent.id
				INNER JOIN DetalleEntrega den ON den.idEntrega = ent.id
				INNER JOIN CostoRecorrido cre ON cre.idDetalleEntrega = den.id
				WHERE sen.idServicio = ?
				AND ent.estadoEntrega = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, idServicio);
			sentencia.setString(2, estadoEntregaRequerido);

			try (ResultSet resultado = sentencia.executeQuery()) {

				if (resultado.next()) {
					return resultado.getDouble("totalCostos");
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

		return UtilNumero.CERO_DECIMAL;
	}

	@Override
	public void crear(CostoRecorridoEntidad entidad) {

		final String sql = """
				INSERT INTO CostoRecorrido (
					id,
					numeroCosto,
					idDetalleEntrega,
					valorPorKM,
					valorCosto
				)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroCosto());
			sentencia.setObject(3, entidad.getDetalleEntrega().getId());
			sentencia.setInt(4, entidad.getValorPorKM());
			sentencia.setDouble(5, entidad.getValorCosto());

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

	private CostoRecorridoEntidad construirCostoRecorridoEntidad(final ResultSet resultado) throws SQLException {

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

		return new CostoRecorridoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroCosto(resultado.getString("numeroCosto"))
				.detalleEntrega(den)
				.valorPorKM(resultado.getInt("valorPorKM"))
				.valorCosto(resultado.getDouble("valorCosto"))
				.build();
	}
}
