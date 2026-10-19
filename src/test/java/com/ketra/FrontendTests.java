package com.ketra;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FrontendTests {

	@Value("${local.server.port}") private int port;

	private HttpResponse<String> get(String path) throws Exception {

		return HttpClient.newHttpClient().send(HttpRequest.newBuilder(URI.create("http://localhost:"+port+path)).GET().build(), HttpResponse.BodyHandlers.ofString());

	}

	@Test
	void vistasConservadasSinApiSimuladaNiControladorDeServicio() throws Exception {

		assertEquals(200, get("/utilidad").statusCode());

		var servicios = get("/servicios.html");

		assertEquals(200, servicios.statusCode());

		assertTrue(servicios.body().contains("Actualizar estado"));

		assertTrue(servicios.body().contains("readonly"));

		assertTrue(servicios.body().contains("data-api-base=\"\""));

		assertEquals(404, get("/api/utilidades/SRV-001").statusCode());

		assertEquals(404, get("/api/v1/servicios").statusCode());

	}

}
