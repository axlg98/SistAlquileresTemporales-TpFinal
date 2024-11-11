package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FinSemanaLargoTest {
	private FinSemanaLargo finde; 
	@BeforeEach
	void setUp() throws Exception {
		finde = new FinSemanaLargo(LocalDate.of(2024,11, 15), LocalDate.of(2024,11, 17), 1.1);
	}

	@Test
	void retornandoAjusteDePrecio() {
		assertEquals(1.1, finde.getAjustePrecio());
	}
	@Test
	void retornandoFechaInicioDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 15), finde.getFechaInicio());
	}
	@Test
	void retornandoFechaFinDelPeriodo() {
		assertEquals(LocalDate.of(2024,11, 17), finde.getFechaFin());
	}

}
