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
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.PreliquidacionEntidad;
import com.ketra.entidad.TerceroEntidad;
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
					pre.fechaPreliquidacion AS fechaPreliquidacion,
					pre.estado AS estado,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto,
					cre.id AS cre_id,
					cre.numeroCosto AS cre_numeroCosto,
					cre.valorPorKM AS cre_valorPorKM,
					cre.valorCosto AS cre_valorCosto,
					cre.idDetalleEntrega AS cre_idDetalleEntrega
				FROM Preliquidacion pre
				INNER JOIN Tercero ter ON pre.idTercero = ter.id
				INNER JOIN CostoRecorrido cre ON pre.idCostoRecorrido = cre.id
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
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR, excepcion.getMessage()),
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
					pre.fechaPreliquidacion AS fechaPreliquidacion,
					pre.estado AS estado,
					ter.id AS ter_id,
					ter.nombre AS ter_nombre,
					ter.nit AS ter_nit,
					ter.numeroContacto AS ter_numeroContacto,
					ter.correoContacto AS ter_correoContacto,
					cre.id AS cre_id,
					cre.numeroCosto AS cre_numeroCosto,
					cre.valorPorKM AS cre_valorPorKM,
					cre.valorCosto AS cre_valorCosto,
					cre.idDetalleEntrega AS cre_idDetalleEntrega
				FROM Preliquidacion pre
				INNER JOIN Tercero ter ON pre.idTercero = ter.id
				INNER JOIN CostoRecorrido cre ON pre.idCostoRecorrido = cre.id
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
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR, excepcion.getMessage()),
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
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CREAR, excepcion.getMessage()),
					excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, PreliquidacionEntidad entidad) {

		final String sql = """
				UPDATE Preliquidacion
				SET estado = ?
				WHERE id = ?
				""";

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setString(1, entidad.getEstado());
			sentencia.setObject(2, id);

			if (sentencia.executeUpdate() != 1) {
				throw new SQLException(CatalogoMensajes.SqlServerDAO.TECNICO_REGISTRO_NO_ENCONTRADO);
			}

		} catch (SQLException excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_ACTUALIZAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_ACTUALIZAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_ACTUALIZAR, excepcion.getMessage()),
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

		final DetalleEntregaEntidad den = new DetalleEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("cre_idDetalleEntrega")))
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
