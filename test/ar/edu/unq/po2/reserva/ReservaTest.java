package ar.edu.unq.po2.reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
	EstadoReserva condicional;
	Usuario inquilino;

	@BeforeEach
	void setUp() {
		inquilino = mock(Usuario.class);
		r1 = mock(Reserva.class);
		aceptada = mock(ReservaAceptada.class);
		pendiente   = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		condicional = mock(ReservaCondicional.class);
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
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
		
	}
	
	@Test
	void CancelandoLaReservaTest() {
		reserva.cancelarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void CancelandoLaReservaConfirmadaTest() {
		reserva.aceptarReserva();
		reserva.cancelarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
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
	void AceptarLaReservaConfirmadaTest() {
		reserva.aceptarReserva();
		reserva.aceptarReserva();
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void ReservaCondicional() {
		when(r1.getEstado()).thenReturn(new ReservaCondicional());
		assertTrue(r1.getEstado() instanceof ReservaCondicional);
	}
	
	@Test
	void ReservaCondicionalCancelada() {
		when(r1.getEstado()).thenReturn(new ReservaCondicional());
		assertTrue(r1.getEstado() instanceof ReservaCondicional);
		when(r1.getEstado()).thenReturn(condicional);
		r1.cancelarReserva();
		assertEquals(r1.getEstado(), condicional);
		
	}
	
	@Test
	void aceptandoUnaReservaCondicionalTest() {
		reserva.setEstado(new ReservaCondicional());
		
		reserva.aceptarReserva();
		
		assertTrue(reserva.getEstado() instanceof ReservaPendiente);
		
	}
	@Test
	void inquilinoReservaTest() {
		assertTrue(reserva.getInquilino() instanceof Usuario);
	}

}
