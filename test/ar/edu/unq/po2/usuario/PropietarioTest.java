package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.EstadoReserva;
import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.reserva.ReservaAceptada;
import ar.edu.unq.po2.reserva.ReservaCancelada;
import ar.edu.unq.po2.reserva.ReservaCompletada;
import ar.edu.unq.po2.reserva.ReservaPendiente;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;

class PropietarioTest {
	
	Inmueble i1;
	Inmueble i2;
	
	Propietario p;
	
	Reserva reserva;
	EstadoReserva aceptada;
	EstadoReserva pendiente;
	EstadoReserva cancelada;
	EstadoReserva completada;

	@BeforeEach
	void setUp(){
		
		p = new Propietario("p1","11111111", "example@gmail.com");
		
		i1 = mock(Inmueble.class);
		i2 = mock(Inmueble.class);
		
		reserva = mock(Reserva.class);
		
		aceptada = mock(ReservaAceptada.class);
		pendiente   = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		completada = mock(ReservaCompletada.class);
		
		p.addInmueble(i1);
		p.addInmueble(i2);
	}

	@Test
	void PropietarioAceptandoReservaDelInquilinoTest() {
		when(reserva.getEstado()).thenReturn(pendiente);
		p.aceptarReservaInquilino(reserva);
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void PropietarioCancelandoReservaDelInquilinoTest() {
		p.cancelarReservaInquilino(reserva);
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void PropietarioAceptandoReservaDelInquilinoEstandoACeptadaTest() {
		when(reserva.getEstado()).thenReturn(aceptada);
		p.aceptarReservaInquilino(reserva);
		
		//No hay nada más para verificar.
		
		assertFalse(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void PropietarioAceptandoReservaDelInquilinoEstandoCanceladaTest() {
		when(reserva.getEstado()).thenReturn(cancelada);
		p.cancelarReservaInquilino(reserva);
		
		//No hay nada más para verificar.
		
		assertFalse(reserva.getEstado() instanceof ReservaCancelada);
	}

}
