package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaRankeoTest {
	
	private CategoriaRankeo categoria;

	@BeforeEach
	void setUp() throws Exception {
		
		this.categoria = new CategoriaRankeo("Atención");
	}

	@Test
	void testConstructor() {
		assertNotNull(categoria);
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Atención", categoria.getNombre());
	}

}
