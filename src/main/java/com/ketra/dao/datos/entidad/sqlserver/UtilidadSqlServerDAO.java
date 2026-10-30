package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoServicioEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.UtilidadDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.ServicioEntidad;
import com.ketra.entidad.UtilidadEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilNumero;
import com.ketra.transversal.utilitarios.UtilTexto;

public class UtilidadSqlServerDAO extends SqlDAO implements UtilidadDAO {

	public UtilidadSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public UtilidadEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    uti.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    uti.valorIngresos AS valorIngresos,
                    uti.valorCostos AS valorCostos,
                    uti.valorUtilidad AS valorUtilidad
                FROM Utilidad uti
                INNER JOIN Servicio ser ON uti.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                WHERE uti.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirUtilidadEntidad(resultado);
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

		return new UtilidadEntidad.Builder().build();
	}

	@Override
	public List<UtilidadEntidad> consultarPorFiltro(UtilidadEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    uti.id AS id,
                    ser.id AS ser_id,
                    ser.numeroServicio AS ser_numeroServicio,
                    ser.fechaServicio AS ser_fechaServicio,
                    ess.id AS ser_estado_id,
                    ess.codigo AS ser_estado_codigo,
                    ess.nombre AS ser_estado_nombre,
                    uti.valorIngresos AS valorIngresos,
                    uti.valorCostos AS valorCostos,
                    uti.valorUtilidad AS valorUtilidad
                FROM Utilidad uti
                INNER JOIN Servicio ser ON uti.idServicio = ser.id
                INNER JOIN EstadoServicio ess ON ser.idEstadoServicio = ess.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("uti.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getServicio().getId())) {
			condiciones.add("uti.idServicio = ?");
			parametros.add(filtro.getServicio().getId());
		}

		if (UtilNumero.diferenteQue(filtro.getValorIngresos(), UtilNumero.CERO_DECIMAL)) {
			condiciones.add("uti.valorIngresos = ?");
			parametros.add(filtro.getValorIngresos());
		}

		if (UtilNumero.diferenteQue(filtro.getValorCostos(), UtilNumero.CERO_DECIMAL)) {
			condiciones.add("uti.valorCostos = ?");
			parametros.add(filtro.getValorCostos());
		}

		if (UtilNumero.diferenteQue(filtro.getValorUtilidad(), UtilNumero.CERO_DECIMAL)) {
			condiciones.add("uti.valorUtilidad = ?");
			parametros.add(filtro.getValorUtilidad());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<UtilidadEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirUtilidadEntidad(resultado));
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
	public List<UtilidadEntidad> consultarTodos() {
		return consultarPorFiltro(new UtilidadEntidad.Builder().build());
	}

	@Override
	public void crear(UtilidadEntidad entidad) {

		final String sql = """
                INSERT INTO Utilidad (
                    id,
                    idServicio,
                    valorIngresos,
                    valorCostos,
                    valorUtilidad
                )
                VALUES (?, ?, ?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setObject(2, entidad.getServicio().getId());
			sentencia.setDouble(3, entidad.getValorIngresos());
			sentencia.setDouble(4, entidad.getValorCostos());
			sentencia.setDouble(5, entidad.getValorUtilidad());

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

	private UtilidadEntidad construirUtilidadEntidad(final ResultSet resultado) throws SQLException {

		final ServicioEntidad ser = new ServicioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ser_id")))
				.numeroServicio(resultado.getString("ser_numeroServicio"))
				.fechaServicio(resultado.getDate("ser_fechaServicio").toLocalDate())
				.estado(new EstadoServicioEntidad.Builder()
						.id(UUID.fromString(resultado.getString("ser_estado_id")))
						.codigo(resultado.getString("ser_estado_codigo"))
						.nombre(resultado.getString("ser_estado_nombre"))
						.build())
				.build();

		return new UtilidadEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.servicio(ser)
				.valorIngresos(resultado.getDouble("valorIngresos"))
				.valorCostos(resultado.getDouble("valorCostos"))
				.valorUtilidad(resultado.getDouble("valorUtilidad"))
				.build();
	}
}
