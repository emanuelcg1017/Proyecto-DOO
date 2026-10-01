package com.ketra.transversal.catalogo;

public class CatalogoMensajes {

	private CatalogoMensajes() {

	}

	public static final class UtilSQL {

		private UtilSQL() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión con la fuente de información se encuentra abierta. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema no controlado tratando de validar si la conexión con la fuente de información se encuentra abierta. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";
		
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA ="No es posible continuar con la operación porque la conexión con la fuente de información no se encuentra abierta.";

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si existe una transacción iniciada. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema no controlado tratando de validar si existe una transacción iniciada. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible iniciar la transacción porque la conexión no se encuentra disponible o ya existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar la transacción porque no existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible cancelar la transacción porque no existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible cerrar la conexión porque esta no se encuentra abierta.";

		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema intentando iniciar la transacción.";

		public static final String USUARIO_ERROR_CONFIRMAR_TRANSACCION_SQL = "Se ha presentado un problema intentando confirmar la transacción.";

		public static final String USUARIO_ERROR_CANCELAR_TRANSACCION_SQL = "Se ha presentado un problema intentando cancelar la transacción.";

		public static final String USUARIO_ERROR_CERRAR_CONEXION_SQL = "Se ha presentado un problema intentando cerrar la conexión.";
	}
	
	public static class SqlServerDAOFactory {

		private SqlServerDAOFactory() {

		}

		public static final String USUARIO_ERROR_CONEXION_SQL_SERVER ="No fue posible establecer la conexión con la fuente de información. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String TECNICO_ERROR_CONEXION_SQL_SERVER ="Se presentó un error tratando de establecer la conexión con SQL Server. Detalle técnico: ";
	}
	
	public static class SqlServerDAO {

		private SqlServerDAO() {
		}

		public static final String USUARIO_ERROR_CREAR ="No fue posible realizar el registro solicitado.";

		public static final String TECNICO_ERROR_CREAR ="Se presentó un error al ejecutar la operación de registro en la fuente de datos. Detalle técnico: ";

		public static final String USUARIO_ERROR_CONSULTAR ="No fue posible realizar la consulta solicitada.";

		public static final String TECNICO_ERROR_CONSULTAR ="Se presentó un error al ejecutar la operación de consulta en la fuente de datos. Detalle técnico: ";

		public static final String USUARIO_ERROR_ACTUALIZAR ="No fue posible realizar la actualización solicitada.";

		public static final String TECNICO_ERROR_ACTUALIZAR ="Se presentó un error al ejecutar la operación de actualización en la fuente de datos. Detalle técnico: ";

		public static final String USUARIO_ERROR_ELIMINAR ="No fue posible realizar la eliminación solicitada.";

		public static final String TECNICO_ERROR_ELIMINAR ="Se presentó un error al ejecutar la operación de eliminación en la fuente de datos. Detalle técnico: ";
	}
}
