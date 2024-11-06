package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TipoInmuebleTest {

	private TipoInmueble tipo;

	@BeforeEach
	void setUp() throws Exception {
		
		this.tipo = new TipoInmueble("Departamento");
	}

	@Test
	void testConstructor() {
		assertNotNull(tipo);
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Departamento", tipo.getNombre());
	}

}
