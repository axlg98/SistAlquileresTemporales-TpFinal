package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormaDePagoTest {

	private FormaDePago formaDePago;

	@BeforeEach
	void setUp() throws Exception {
		
		this.formaDePago = new FormaDePago("Efectivo");
	}

	@Test
	void testConstructor() {
		assertNotNull(formaDePago);
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Efectivo", formaDePago.getNombre());
	}

}
