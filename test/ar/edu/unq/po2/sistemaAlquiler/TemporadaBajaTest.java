package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemporadaBajaTest {
	private TemporadaBaja temporadaBaja;
	@BeforeEach
	void setUp() throws Exception {
		temporadaBaja = new TemporadaBaja(LocalDate.of(2024,11, 15), LocalDate.of(2024,11, 17), 1.0);
	}
	@Test
	void retornandoAjusteDePrecio() {
		assertEquals(1.0, temporadaBaja.getAjustePrecio());
	}
	@Test
	void retornandoFechaInicioDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 15), temporadaBaja.getFechaInicio());
	}
	@Test
	void retornandoFechaFinDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 17), temporadaBaja.getFechaFin());
	}

}
