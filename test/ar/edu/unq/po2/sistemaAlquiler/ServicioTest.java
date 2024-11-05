package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {
	private Servicio servicio;
	@BeforeEach
	void setUp() throws Exception {
		servicio = new Servicio("Agua");
	}

	@Test
	void nombreDelServicioTest() {
		assertEquals("Agua", servicio.getNombre());
	}

}
