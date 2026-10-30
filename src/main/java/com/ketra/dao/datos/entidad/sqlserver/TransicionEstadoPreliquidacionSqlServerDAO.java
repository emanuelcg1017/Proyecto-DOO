package com.ketra.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.dao.datos.entidad.TransicionEstadoPreliquidacionDAO;
import com.ketra.entidad.EstadoPreliquidacionEntidad;
import com.ketra.entidad.TransicionEstadoPreliquidacionEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilUUID;

public class TransicionEstadoPreliquidacionSqlServerDAO extends SqlDAO implements TransicionEstadoPreliquidacionDAO {

	public TransicionEstadoPreliquidacionSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public TransicionEstadoPreliquidacionEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    tra.id AS id,
                    ori.id AS estadoOrigen_id,
                    ori.codigo AS estadoOrigen_codigo,
                    ori.nombre AS estadoOrigen_nombre,
                    des.id AS estadoDestino_id,
                    des.codigo AS estadoDestino_codigo,
                    des.nombre AS estadoDestino_nombre
                FROM dbo.TransicionEstadoPreliquidacion tra
                INNER JOIN dbo.EstadoPreliquidacion ori ON tra.idEstadoOrigen = ori.id
                INNER JOIN dbo.EstadoPreliquidacion des ON tra.idEstadoDestino = des.id

                WHERE tra.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirTransicionEstadoPreliquidacionEntidad(resultado);
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

		return new TransicionEstadoPreliquidacionEntidad.Builder().build();
	}

	@Override
	public List<TransicionEstadoPreliquidacionEntidad> consultarPorFiltro(TransicionEstadoPreliquidacionEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    tra.id AS id,
                    ori.id AS estadoOrigen_id,
                    ori.codigo AS estadoOrigen_codigo,
                    ori.nombre AS estadoOrigen_nombre,
                    des.id AS estadoDestino_id,
                    des.codigo AS estadoDestino_codigo,
                    des.nombre AS estadoDestino_nombre
                FROM dbo.TransicionEstadoPreliquidacion tra
                INNER JOIN dbo.EstadoPreliquidacion ori ON tra.idEstadoOrigen = ori.id
                INNER JOIN dbo.EstadoPreliquidacion des ON tra.idEstadoDestino = des.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("tra.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEstadoOrigen().getId())) {
			condiciones.add("ori.id = ?");
			parametros.add(filtro.getEstadoOrigen().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoOrigen().getCodigo())) {
			condiciones.add("ori.codigo = ?");
			parametros.add(filtro.getEstadoOrigen().getCodigo());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoOrigen().getNombre())) {
			condiciones.add("ori.nombre = ?");
			parametros.add(filtro.getEstadoOrigen().getNombre());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEstadoDestino().getId())) {
			condiciones.add("des.id = ?");
			parametros.add(filtro.getEstadoDestino().getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoDestino().getCodigo())) {
			condiciones.add("des.codigo = ?");
			parametros.add(filtro.getEstadoDestino().getCodigo());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getEstadoDestino().getNombre())) {
			condiciones.add("des.nombre = ?");
			parametros.add(filtro.getEstadoDestino().getNombre());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<TransicionEstadoPreliquidacionEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirTransicionEstadoPreliquidacionEntidad(resultado));
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
	public List<TransicionEstadoPreliquidacionEntidad> consultarTodos() {
		return consultarPorFiltro(new TransicionEstadoPreliquidacionEntidad.Builder().build());
	}

	private TransicionEstadoPreliquidacionEntidad construirTransicionEstadoPreliquidacionEntidad(final ResultSet resultado) throws SQLException {

		return new TransicionEstadoPreliquidacionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.estadoOrigen(new EstadoPreliquidacionEntidad.Builder()
						.id(UUID.fromString(resultado.getString("estadoOrigen_id")))
						.codigo(resultado.getString("estadoOrigen_codigo"))
						.nombre(resultado.getString("estadoOrigen_nombre"))
						.build())
				.estadoDestino(new EstadoPreliquidacionEntidad.Builder()
						.id(UUID.fromString(resultado.getString("estadoDestino_id")))
						.codigo(resultado.getString("estadoDestino_codigo"))
						.nombre(resultado.getString("estadoDestino_nombre"))
						.build())
				.build();
	}
}
