package com.ketra.dao.datos.entidad.sqlserver;

import com.ketra.entidad.EstadoEntregaEntidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ketra.dao.datos.entidad.DetalleEntregaDAO;
import com.ketra.dao.datos.entidad.SqlDAO;
import com.ketra.entidad.BarrioEntidad;
import com.ketra.entidad.CEDIEntidad;
import com.ketra.entidad.DetalleEntregaEntidad;
import com.ketra.entidad.DireccionEntidad;
import com.ketra.entidad.EntregaEntidad;
import com.ketra.entidad.PedidoEntidad;
import com.ketra.entidad.PersonaEntidad;
import com.ketra.entidad.TipoDireccionEntidad;
import com.ketra.transversal.catalogo.CatalogoMensajes;
import com.ketra.transversal.excepciones.KETRADatosException;
import com.ketra.transversal.utilitarios.UtilUUID;
import com.ketra.transversal.utilitarios.UtilTexto;
import com.ketra.transversal.utilitarios.UtilNumero;

public class DetalleEntregaSqlServerDAO extends SqlDAO implements DetalleEntregaDAO {

	public DetalleEntregaSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DetalleEntregaEntidad consultarPorId(UUID id) {

		final String sql = """
                SELECT
                    den.id AS id,
                    den.numeroDetalleEntrega AS numeroDetalleEntrega,
                    den.distanciaKM AS distanciaKM,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona,
                    ced.id AS ced_id,
                    ced.nombre AS ced_nombre,
                    ced.idDireccion AS ced_idDireccion,
                    dir2.id AS dir2_id,
                    dir2.nombre AS dir2_nombre,
                    dir2.idBarrio AS dir2_idBarrio,
                    dir2.idTipoDireccion AS dir2_idTipoDireccion
                FROM DetalleEntrega den
                INNER JOIN Pedido ped ON den.idPedido = ped.id
                INNER JOIN Entrega ent ON den.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                INNER JOIN CEDI ced ON den.idCediOrigen = ced.id
                INNER JOIN Direccion dir2 ON den.idDireccionDestino = dir2.id
                WHERE den.id = ?
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					return construirDetalleEntregaEntidad(resultado);
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

		return new DetalleEntregaEntidad.Builder().build();
	}

	@Override
	public List<DetalleEntregaEntidad> consultarPorFiltro(DetalleEntregaEntidad filtro) {

		final StringBuilder sql = new StringBuilder("""
                SELECT
                    den.id AS id,
                    den.numeroDetalleEntrega AS numeroDetalleEntrega,
                    den.distanciaKM AS distanciaKM,
                    ped.id AS ped_id,
                    ped.numeroPedido AS ped_numeroPedido,
                    ped.fechaPedido AS ped_fechaPedido,
                    ent.id AS ent_id,
                    ent.codigoEntrega AS ent_codigoEntrega,
                    ent.fechaEntrega AS ent_fechaEntrega,
                    ese.id AS ent_estadoEntrega_id,
                    ese.codigo AS ent_estadoEntrega_codigo,
                    ese.nombre AS ent_estadoEntrega_nombre,
                    ent.idPersona AS ent_idPersona,
                    ced.id AS ced_id,
                    ced.nombre AS ced_nombre,
                    ced.idDireccion AS ced_idDireccion,
                    dir2.id AS dir2_id,
                    dir2.nombre AS dir2_nombre,
                    dir2.idBarrio AS dir2_idBarrio,
                    dir2.idTipoDireccion AS dir2_idTipoDireccion
                FROM DetalleEntrega den
                INNER JOIN Pedido ped ON den.idPedido = ped.id
                INNER JOIN Entrega ent ON den.idEntrega = ent.id
                INNER JOIN EstadoEntrega ese ON ent.idEstadoEntrega = ese.id
                INNER JOIN CEDI ced ON den.idCediOrigen = ced.id
                INNER JOIN Direccion dir2 ON den.idDireccionDestino = dir2.id
                """);
		final List<String> condiciones = new ArrayList<>();
		final List<Object> parametros = new ArrayList<>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getId())) {
			condiciones.add("den.id = ?");
			parametros.add(filtro.getId());
		}

		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNumeroDetalleEntrega())) {
			condiciones.add("den.numeroDetalleEntrega = ?");
			parametros.add(filtro.getNumeroDetalleEntrega());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getPedido().getId())) {
			condiciones.add("den.idPedido = ?");
			parametros.add(filtro.getPedido().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getEntrega().getId())) {
			condiciones.add("den.idEntrega = ?");
			parametros.add(filtro.getEntrega().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getCediOrigen().getId())) {
			condiciones.add("den.idCediOrigen = ?");
			parametros.add(filtro.getCediOrigen().getId());
		}

		if (!UtilUUID.UUID_DEFECTO.equals(filtro.getDireccionDestino().getId())) {
			condiciones.add("den.idDireccionDestino = ?");
			parametros.add(filtro.getDireccionDestino().getId());
		}

		if (UtilNumero.diferenteQue(filtro.getDistanciaKM(), UtilNumero.CERO_DECIMAL)) {
			condiciones.add("den.distanciaKM = ?");
			parametros.add(filtro.getDistanciaKM());
		}

		if (!condiciones.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", condiciones));
		}

		final List<DetalleEntregaEntidad> resultados = new ArrayList<>();

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql.toString())) {

			for (int indice = 0; indice < parametros.size(); indice++) {
				sentencia.setObject(indice + 1, parametros.get(indice));
			}

			try (ResultSet resultado = sentencia.executeQuery()) {
				while (resultado.next()) {
					resultados.add(construirDetalleEntregaEntidad(resultado));
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
	public List<DetalleEntregaEntidad> consultarTodos() {
		return consultarPorFiltro(new DetalleEntregaEntidad.Builder().build());
	}

	@Override
	public void crear(DetalleEntregaEntidad entidad) {

		final String sql = """
                INSERT INTO DetalleEntrega (
                    id,
                    numeroDetalleEntrega,
                    idPedido,
                    idEntrega,
                    idCediOrigen,
                    idDireccionDestino,
                    distanciaKM
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

		try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {

			sentencia.setObject(1, entidad.getId());
			sentencia.setString(2, entidad.getNumeroDetalleEntrega());
			sentencia.setObject(3, entidad.getPedido().getId());
			sentencia.setObject(4, entidad.getEntrega().getId());
			sentencia.setObject(5, entidad.getCediOrigen().getId());
			sentencia.setObject(6, entidad.getDireccionDestino().getId());
			sentencia.setDouble(7, entidad.getDistanciaKM());

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

	private DetalleEntregaEntidad construirDetalleEntregaEntidad(final ResultSet resultado) throws SQLException {

		final PedidoEntidad ped = new PedidoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ped_id")))
				.numeroPedido(resultado.getString("ped_numeroPedido"))
				.fechaPedido(resultado.getDate("ped_fechaPedido").toLocalDate())
				.build();

		final PersonaEntidad per = new PersonaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_idPersona")))
				.build();

		final EntregaEntidad ent = new EntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ent_id")))
				.codigoEntrega(resultado.getString("ent_codigoEntrega"))
				.fechaEntrega(resultado.getDate("ent_fechaEntrega").toLocalDate())
				.estadoEntrega(new EstadoEntregaEntidad.Builder()
						.id(UUID.fromString(resultado.getString("ent_estadoEntrega_id")))
						.codigo(resultado.getString("ent_estadoEntrega_codigo"))
						.nombre(resultado.getString("ent_estadoEntrega_nombre"))
						.build())
				.persona(per)
				.build();

		final DireccionEntidad dir = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ced_idDireccion")))
				.build();

		final CEDIEntidad ced = new CEDIEntidad.Builder()
				.id(UUID.fromString(resultado.getString("ced_id")))
				.nombre(resultado.getString("ced_nombre"))
				.direccion(dir)
				.build();

		final BarrioEntidad bar2 = new BarrioEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir2_idBarrio")))
				.build();

		final TipoDireccionEntidad tdi2 = new TipoDireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir2_idTipoDireccion")))
				.build();

		final DireccionEntidad dir2 = new DireccionEntidad.Builder()
				.id(UUID.fromString(resultado.getString("dir2_id")))
				.nombre(resultado.getString("dir2_nombre"))
				.barrio(bar2)
				.direccion(tdi2)
				.build();

		return new DetalleEntregaEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.numeroDetalleEntrega(resultado.getString("numeroDetalleEntrega"))
				.pedido(ped)
				.entrega(ent)
				.cediOrigen(ced)
				.direccionDestino(dir2)
				.distanciaKM(resultado.getDouble("distanciaKM"))
				.build();
	}
}
