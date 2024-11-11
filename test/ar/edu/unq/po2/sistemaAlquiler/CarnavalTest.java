package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarnavalTest {
	private Carnaval carnaval;
	@BeforeEach
	void setUp() throws Exception {
		
		carnaval = new Carnaval(LocalDate.of(2024,11, 15), LocalDate.of(2024,11, 17), 1.5);
	}

	@Test
	void retornandoAjusteDePrecio() {
		assertEquals(1.5, carnaval.getAjustePrecio());
	}
	@Test
	void retornandoFechaInicioDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 15), carnaval.getFechaInicio());
	}
	@Test
	void retornandoFechaFinDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 17), carnaval.getFechaFin());
	}

}
