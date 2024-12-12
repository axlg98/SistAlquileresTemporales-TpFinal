package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;

class CancelacionGratuitaTest {
	
	
	private CancelacionGratuita cGratuita;
	private Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		cGratuita = new CancelacionGratuita();
		reserva = mock(Reserva.class);
		
	}

	@Test
	void cancelacionGratuitaCuandoLaFechaCancelacionEsDe10DiasAntesALafechaDeLaReserva() {
		when(reserva.getFechaInicio()).thenReturn(LocalDate.of(2024,11, 10));
		
		assertEquals( 0 , cGratuita.costoDeCancelacion(reserva, LocalDate.of(2024,10,30), 100.0));
	}
	
	@Test
	void cancelacionGratuitaCuandoLaFechaCancelacionDia10AntesDeLafechaDeLaReserva() {
		when(reserva.getFechaInicio()).thenReturn(LocalDate.of(2024,11, 10));
		
		assertEquals( 0 , cGratuita.costoDeCancelacion(reserva, LocalDate.of(2024,10,31), 100.0));
	}
	@Test
	void costoPorCancelarPasandoLaFechaLimiteDeCancelacion() {
		when(reserva.getFechaInicio()).thenReturn(LocalDate.of(2024,11, 10));
		
		assertEquals( 200 , cGratuita.costoDeCancelacion(reserva, LocalDate.of(2024,11,1), 100.0));
	}
}
