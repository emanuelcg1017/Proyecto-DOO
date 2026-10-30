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
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.CostoRecorridoEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.PedidoEntidad;
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
                    cre.valorPorKM AS valorPorKM,
                    cre.valorCosto AS valorCosto,
                    den.id AS den_id,
                    den.numeroDetalleEntrega AS den_numeroDetalleEntrega,
                    den.distanciaKM AS den_distanciaKM,
                    den.idPedido AS den_idPedido,
                    den.idEntrega AS den_idEntrega,
                    den.idCediOrigen AS den_idCediOrigen,
                    den.idDireccionDestino AS den_idDireccionDestino
                FROM CostoRecorrido cre
                INNER JOIN DetalleEntrega den ON cre.idDetalleEntrega = den.id
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
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CONSULTAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CONSULTAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CONSULTAR, excepcion.getMessage()),
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
                    cre.valorPorKM AS valorPorKM,
                    cre.valorCosto AS valorCosto,
                    den.id AS den_id,
                    den.numeroDetalleEntrega AS den_numeroDetalleEntrega,
                    den.distanciaKM AS den_distanciaKM,
                    den.idPedido AS den_idPedido,
                    den.idEntrega AS den_idEntrega,
                    den.idCediOrigen AS den_idCediOrigen,
                    den.idDireccionDestino AS den_idDireccionDestino
                FROM CostoRecorrido cre
                INNER JOIN DetalleEntrega den ON cre.idDetalleEntrega = den.id
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

		if (UtilNumero.diferenteQue(filtro.getValorPorKM(), UtilNumero.CERO)) {
			condiciones.add("cre.valorPorKM = ?");
			parametros.add(filtro.getValorPorKM());
		}

		if (UtilNumero.diferenteQue(filtro.getValorCosto(), UtilNumero.CERO_DECIMAL)) {
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
	public List<CostoRecorridoEntidad> consultarTodos() {
		return consultarPorFiltro(new CostoRecorridoEntidad.Builder().build());
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
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_CREAR, excepcion.getMessage()),
					excepcion);

		} catch (Exception excepcion) {

			throw KETRADatosException.crear(
					CatalogoMensajes.SqlServerDAO.USUARIO_ERROR_CREAR,
					UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.SqlServerDAO.TECNICO_ERROR_NO_CONTROLADO_CREAR, excepcion.getMessage()),
					excepcion);
		}
	}

	private CostoRecorridoEntidad construirCostoRecorridoEntidad(final ResultSet resultado) throws SQLException {

		final PedidoEntidad ped = new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_idPedido")))
				.build();

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_idEntrega")))
				.build();

		final CEDIEntidad ced = new CEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_idCediOrigen")))
				.build();

		final DireccionEntidad dir2 = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_idDireccionDestino")))
				.build();

		final DetalleEntregaEntidad den = new DetalleEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("den_id")))
				.numeroDetalleEntrega(resultado.getString("den_numeroDetalleEntrega"))
				.pedido(ped)
				.entrega(ent)
				.cediOrigen(ced)
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
