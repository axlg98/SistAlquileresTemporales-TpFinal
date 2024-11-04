package ar.edu.unq.po2.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {

	Reserva reserva;
	Reserva r1;
	ReservaAceptada aceptada;
	ReservaPendiente pendiente;
	ReservaCancelada cancelada;
	ReservaCompletada completada;

	@BeforeEach
	void setUp() {
		r1 = mock(Reserva.class);
		aceptada = mock(ReservaAceptada.class);
		pendiente   = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		completada = mock(ReservaCompletada.class);
		
		reserva = new Reserva(aceptada,LocalDate.now(), LocalDate.of(2024,11, 10));
	}

	@Test
	void EstadoDeLaReservaActualTest() {
		reserva.solicitarEstadoReserva();
		assertEquals(reserva.getEstado(),aceptada);
	}
	
	@Test
	void EstadoDeLaReservaConfirmadaCancelandoLaReservaTest() {
		when(r1.getEstado()).thenReturn(aceptada);
		reserva.cancelarReserva();
		reserva.solicitarEstadoReserva();
		assertEquals(reserva.getEstado(),aceptada);
		//verify(r1.getEstado(), times(0)).cancelarReserva(r1);
	}

}
