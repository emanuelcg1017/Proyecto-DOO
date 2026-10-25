package com.ketra.dao.datos.entidad;

import java.util.List;
import java.util.UUID;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;
import com.ketra.entidad.CostoRecorridoEntidad;

public interface CostoRecorridoDAO extends ConsultarDAO<CostoRecorridoEntidad, UUID>, CrearDAO<CostoRecorridoEntidad>{

	Double consultarTotalCostosPorServicio(UUID idServicio);
	
	List<CostoRecorridoEntidad> consultarPorServicio(UUID idServicio);

}
