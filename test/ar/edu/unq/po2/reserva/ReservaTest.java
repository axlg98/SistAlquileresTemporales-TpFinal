package ar.edu.unq.po2.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {

	Reserva reserva;
	EstadoReserva aceptada;
	EstadoReserva pendiente;
	EstadoReserva cancelada;
	EstadoReserva completada;

	@BeforeEach
	void setUp() {
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
		reserva.cancelarReserva();
		reserva.solicitarEstadoReserva();
		assertEquals(reserva.getEstado(),cancelada);
	}

}
