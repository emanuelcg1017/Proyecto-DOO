package com.ketra.servicio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ketra.dto.ServicioDTO;
import com.ketra.dto.UtilidadDTO;
import com.ketra.transversal.utilitarios.UtilFecha;
import com.ketra.transversal.utilitarios.UtilUUID;

import tools.jackson.databind.json.JsonMapper;

class DTOJsonTests {

	private final JsonMapper mapper = JsonMapper.builder().build();

	@Test
	void jsonConstruyeDTOConBuilderSinSettersPublicos() {

		var dto = mapper.readValue("{\"estado\":\" En ejecución \"}", ServicioDTO.class);

		assertEquals("En ejecución", dto.getEstado());

		assertEquals(UtilUUID.UUID_DEFECTO, dto.getId());

		assertEquals(UtilFecha.FECHA_DEFECTO, dto.getFechaServicio());

		assertTrue(mapper.writeValueAsString(dto).contains("En ejecución"));

	}

	@Test
	void utilidadYServicioAnidadosDeserializanYNormalizanNulos() {

		var id = UUID.randomUUID();

		var dto = mapper.readValue("{\"servicio\":{\"id\":\""+id+"\"},\"valorIngresos\":null}", UtilidadDTO.class);

		assertEquals(id, dto.getServicio().getId());

		assertEquals(0.0, dto.getValorIngresos());

		assertEquals(0.0, dto.getValorUtilidad());

	}

	@Test
	void uuidMalFormadoYFechaInvalidaSeRechazanAntesDeNegocio() {

		assertThrows(Exception.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				mapper.readValue("{\"id\":\"no-es-uuid\"}", ServicioDTO.class);

			}

		});

		assertThrows(Exception.class, new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {

				mapper.readValue("{\"fechaServicio\":\"2026-02-30\"}", ServicioDTO.class);

			}

		});

	}

}
