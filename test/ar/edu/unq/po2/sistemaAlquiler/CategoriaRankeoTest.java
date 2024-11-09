package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaRankeoTest {
	
	private CategoriaRankeo categoria;
	private IRankeable		entidad;

	@BeforeEach
	void setUp() throws Exception {
		this.entidad   = mock(IRankeable.class);
		this.categoria = new CategoriaRankeo("Atención", entidad);
	}

	@Test
	void testConstructor() {
		assertNotNull(categoria);
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Atención", categoria.getNombre());
	}
	
	@Test
	void testGetEntidad() {
		assertEquals(entidad, categoria.getEntidad());
	}

}
