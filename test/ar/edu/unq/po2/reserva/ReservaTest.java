package ar.edu.unq.po2.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.usuario.Usuario;

class ReservaTest {

	Reserva reserva;
	Reserva r1;
	EstadoReserva aceptada;
	EstadoReserva pendiente;
	EstadoReserva cancelada;
	EstadoReserva completada;
	Usuario inquilino;

	@BeforeEach
	void setUp() {
		inquilino = mock(Usuario.class);
		r1 = mock(Reserva.class);
		aceptada = mock(ReservaAceptada.class);
		pendiente   = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		completada = mock(ReservaCompletada.class);
		
		reserva = new Reserva(LocalDate.now(), LocalDate.now().plusDays(10), inquilino);
	}
	
	@Test
	void fechaInicioTest() {
		assertEquals(reserva.getFechaInicio(), LocalDate.now());
	}
	
	@Test
	void fechaFinTest() {
		assertEquals(reserva.getFechaFin(), LocalDate.now().plusDays(10));
	}
	
	@Test
	void EstadoDeLaReservaActualTest() {
		
		assertTrue(reserva.getEstado() instanceof ReservaPendiente);
		
	}
	
	@Test
	void ReservaConfirmadaTest() {
		reserva.aceptarReserva();
		reserva.solicitarEstadoReserva();
		//reserva.aceptarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
		
	}
	
	@Test
	void CancelandoLaReservaTest() {
		reserva.cancelarReserva();
		reserva.solicitarEstadoReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void CancelandoLaReservaConfirmadaTest() {
		reserva.aceptarReserva();
		reserva.solicitarEstadoReserva();
		reserva.cancelarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void ReservaCompletadaTest() {
		reserva.aceptarReserva();
		reserva.solicitarEstadoReserva();
		reserva.reservaCompletada();
		assertTrue(reserva.getEstado() instanceof ReservaCompletada);
	}
	
	@Test
	void AceptarReservaCompletadaTest() {
		reserva.aceptarReserva();
		reserva.reservaCompletada();
		reserva.aceptarReserva();
		reserva.solicitarEstadoReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCompletada);
	}
	
	@Test
	void CancelarReservaCompletadaTest() {
		reserva.aceptarReserva();
		reserva.reservaCompletada();
		reserva.cancelarReserva();
		reserva.solicitarEstadoReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCompletada);
	}
	
	@Test
	void CompletarLaReservaCompletadaTest() {
		reserva.aceptarReserva();
		reserva.reservaCompletada();
		reserva.reservaCompletada();
		reserva.solicitarEstadoReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCompletada);
	}
	
	@Test
	void CancelarReservaCanceladaTest() {
		reserva.cancelarReserva();
		reserva.cancelarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void AceptarReservaCanceladaTest() {
		reserva.cancelarReserva();
		reserva.aceptarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void CompletarReservaCanceladaTest() {
		reserva.cancelarReserva();
		reserva.reservaCompletada();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void AceptarLaReservaConfirmadaTest() {
		reserva.aceptarReserva();
		reserva.solicitarEstadoReserva();
		reserva.aceptarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void CompletarReservaPendienteTest() {
		reserva.reservaCompletada();
		assertTrue(reserva.getEstado() instanceof ReservaPendiente);
	}

}
