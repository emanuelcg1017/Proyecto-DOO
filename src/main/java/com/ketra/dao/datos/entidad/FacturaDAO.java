package com.ketra.dao.datos.entidad;

import java.util.List;
import java.util.UUID;
import com.ketra.dao.datos.ActualizarDAO;
import com.ketra.dao.datos.ConsultarDAO;
import com.ketra.dao.datos.CrearDAO;
import com.ketra.entidad.FacturaEntidad;

public interface FacturaDAO extends CrearDAO<FacturaEntidad>, ConsultarDAO<FacturaEntidad, UUID>, ActualizarDAO<FacturaEntidad, UUID>{

	Double consultarTotalIngresosPorServicio(UUID idServicio);
	
	List<FacturaEntidad> consultarPorServicio(UUID idServicio);

}
