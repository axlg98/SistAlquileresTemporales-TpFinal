package ar.edu.unq.po2.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	Reserva reserva;
	EstadoReserva confirmada;
	EstadoReserva iniciada;
	EstadoReserva cancelada;
	EstadoReserva completada;

	@BeforeEach
	void setUp() {
		confirmada = new ReservaConfirmada();
		iniciada   = new ReservaIniciada();
		cancelada  = new ReservaCancelada();
		completada = new ReservaCompletada();
		
		reserva = new Reserva(confirmada,LocalDate.now(), LocalDate.of(2024,11, 10));
	}

	@Test
	void EstadoDeLaReservaActualTest() {
		reserva.solicitarEstadoReserva();
		assertEquals(reserva.getEstado(),confirmada);
	}
	
	@Test
	void EstadoDeLaReservaConfirmadaCancelandoLaReservaTest() {
		reserva.cancelarReserva();
		reserva.solicitarEstadoReserva();
		assertEquals(reserva.getEstado(),cancelada);
	}

}
