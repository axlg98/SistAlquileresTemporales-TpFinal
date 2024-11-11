package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemporadaAltaTest {
	
	private TemporadaAlta tempoAlta;
	@BeforeEach
	void setUp() throws Exception {
		tempoAlta = new TemporadaAlta(LocalDate.of(2024,11, 15), LocalDate.of(2024,11, 17), 2.0);
	}

	@Test
	void retornandoAjusteDePrecio() {
		assertEquals(2.0, tempoAlta.getAjustePrecio());
	}
	@Test
	void retornandoFechaInicioDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 15), tempoAlta.getFechaInicio());
	}
	@Test
	void retornandoFechaFinDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 17), tempoAlta.getFechaFin());
	}

}
