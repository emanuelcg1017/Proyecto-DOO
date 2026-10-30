package com.ketra.transversal.catalogo;

public final class CatalogoCodigosEstado {

	private CatalogoCodigosEstado() {

	}

	public static final class Servicio {
		
		private Servicio() {

		}

		public static final String REGISTRADO = "SER-01";

		public static final String EN_EJECUCION = "SER-02";

		public static final String FINALIZADO = "SER-03";

		public static final String CANCELADO = "SER-04";



	}

	public static final class Entrega {

		private Entrega() {

		}

		public static final String PENDIENTE = "ENT-01";

		public static final String EN_TRANSITO = "ENT-02";

		public static final String ENTREGADA = "ENT-03";

		public static final String CANCELADA = "ENT-04";

	}

	public static final class Factura {
		
		private Factura() {

		}

		public static final String PENDIENTE = "FAC-01";

		public static final String PAGADA = "FAC-02";

		public static final String ANULADA = "FAC-03";

	}

	public static final class Preliquidacion {

		private Preliquidacion() {

		}
		
		public static final String PENDIENTE = "PRE-01";

		public static final String PAGADA = "PRE-02";

		public static final String ANULADA = "PRE-03";


	}

}
