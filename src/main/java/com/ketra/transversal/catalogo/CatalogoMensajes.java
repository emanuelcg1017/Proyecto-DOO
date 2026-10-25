package com.ketra.transversal.catalogo;

public class CatalogoMensajes {

	

	private CatalogoMensajes() {

	}

	public static final class Seguridad {

		private Seguridad() {

		}


		public static final String CUENTA_NO_AUTORIZADA = "Esta cuenta de Google no tiene permiso para acceder a KETRA.";


	}

	public static final class AbstractRestController {

		private AbstractRestController() {

		}

		public static final String USUARIO_RECURSO_NO_ENCONTRADO = "El recurso solicitado no existe: ";

		public static final String USUARIO_METODO_RECURSO_NO_ENCONTRADO = ". Método HTTP: ";

		public static final String USUARIO_ERROR_NO_CONTROLADO = "No fue posible completar la operación. Inténtelo nuevamente.";

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
		
		public static final String TECNICO_ERROR_NO_CONTROLADO_CREAR ="Se presentó un error no controlado al realizar la operación de registro. Detalle técnico: ";

		public static final String USUARIO_ERROR_CONSULTAR ="No fue posible realizar la consulta solicitada.";

		public static final String TECNICO_ERROR_CONSULTAR ="Se presentó un error al ejecutar la operación de consulta en la fuente de datos. Detalle técnico: ";

		public static final String TECNICO_ERROR_NO_CONTROLADO_CONSULTAR ="Se presentó un error no controlado al realizar la operación de consulta. Detalle técnico: ";

		public static final String USUARIO_ERROR_ACTUALIZAR ="No fue posible realizar la actualización solicitada.";

		public static final String TECNICO_ERROR_ACTUALIZAR ="Se presentó un error al ejecutar la operación de actualización en la fuente de datos. Detalle técnico: ";

		public static final String TECNICO_ERROR_NO_CONTROLADO_ACTUALIZAR ="Se presentó un error no controlado al realizar la operación de actualización. Detalle técnico: ";

		public static final String TECNICO_REGISTRO_NO_ENCONTRADO = "No se encontró el registro que se desea actualizar.";

		public static final String USUARIO_ERROR_ELIMINAR ="No fue posible realizar la eliminación solicitada.";

		public static final String TECNICO_ERROR_ELIMINAR ="Se presentó un error al ejecutar la operación de eliminación en la fuente de datos. Detalle técnico: ";

		public static final String TECNICO_ERROR_NO_CONTROLADO_ELIMINAR ="Se presentó un error no controlado al realizar la operación de eliminación. Detalle técnico: ";
		
	}
	
	public static final class UtilidadNegocioImpl {
		
		private UtilidadNegocioImpl() {
		}

		public static final String ID_SERVICIO_REQUERIDO ="Se requiere un servicio válido para generar la utilidad.";

		public static final String SERVICIO_NO_EXISTE = "El servicio indicado no existe.";

		public static final String SERVICIO_DEBE_ESTAR_FINALIZADO = "La utilidad solo puede generarse cuando el servicio esté finalizado.";

		public static final String UTILIDAD_YA_GENERADA = "La utilidad del servicio ya fue generada.";


	}
	
	public static final class UtilidadFachadaImpl {
		
		private UtilidadFachadaImpl() {
		}

		public static final String ERROR_GENERANDO_UTILIDAD = "Se presentó un problema inesperado generando la utilidad del servicio. Por favor, inténtelo nuevamente o contacte al administrador.";

		public static final String ERROR_CONSULTANDO_UTILIDAD = "Se presentó un problema inesperado consultando la utilidad del servicio. Por favor, inténtelo nuevamente o contacte al administrador.";

		public static final String ERROR_CERRANDO_CONEXION = "Se presentó un problema cerrando la conexión con la base de datos.";

	}
	
	public static final class ServicioNegocioImpl {

		private ServicioNegocioImpl() {

		}

		public static final String ID_REQUERIDO = "Indique un identificador válido para el servicio.";
		
		public static final String DATOS_ESTADO_INVALIDOS = "Indique el estado del servicio con una longitud entre 1 y 15 caracteres.";
		
		public static final String ESTADO_INVALIDO = "El estado debe ser Registrado, En ejecución, Finalizado o Cancelado.";
		
		public static final String ESTADO_IGUAL = "El estado solicitado es igual al estado actual del servicio.";
		
		public static final String NO_CANCELABLE = "El servicio no puede cancelarse porque se encuentra en ejecución o ya ha finalizado.";
		
		public static final String TRANSICION_INVALIDA = "El cambio de estado no está permitido. Solo se admite Registrado a En ejecución o Cancelado, y En ejecución a Finalizado.";
		
		public static final String ESTADO_TERMINAL = "Un servicio Finalizado o Cancelado no puede cambiar de estado.";
		
		public static final String FILTRO_INVALIDO = "El número de servicio del filtro no puede superar 30 caracteres.";
		
		public static final String FECHA_FILTRO_INVALIDA = "La fecha del filtro debe estar entre el 1 de enero del año 1 y el 31 de diciembre del año 9999.";
		
		public static final String ID_NO_COINCIDE = "El identificador del cuerpo no coincide con el servicio indicado en la URL.";
		
		public static final String ENTREGA_EN_TRANSITO = "El servicio no puede cancelarse porque tiene una entrega en tránsito.";
		
		public static final String ENTREGAS_SIN_COMPLETAR = "El servicio solo puede finalizar cuando todas sus entregas estén en estado Entregada.";
	}

	public static final class ServicioFachadaImpl {

		private ServicioFachadaImpl() {

		}

		public static final String ERROR_CONSULTANDO = "No fue posible consultar los servicios. Inténtelo nuevamente.";
		
		public static final String ERROR_ACTUALIZANDO = "No fue posible actualizar el estado del servicio. No se confirmó la operación.";
	}

	public static final class DAOFactory {
		
		private DAOFactory() {
		}

		public static final String FUENTE_DATOS_NO_HABILITADA = "La fuente de datos solicitada no está habilitada. Por favor, contacte al administrador de la aplicación.";

	}
	








}
