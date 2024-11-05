package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;

class SinCancelacionTest {
	
	
	private SinCancelacion sinCancelacion;
	private Reserva reserva;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		sinCancelacion = new SinCancelacion();
		reserva = mock(Reserva.class);
	}

	@Test
	void costoPorCancelacionConPoliticaDeSinCancelacion() {
		when(reserva.getFechaInicio()).thenReturn(LocalDate.of(2024,11, 10));
		when(reserva.getFechaFin()).thenReturn(LocalDate.of(2024,11, 15));
		assertEquals(500, sinCancelacion.costoDeCancelacion(reserva, LocalDate.now(), 100.0));
	}

}
