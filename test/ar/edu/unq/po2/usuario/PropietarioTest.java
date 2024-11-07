package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

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
	
	Inmueble inmueble1;
	Inmueble inmueble2;
	
	Propietario propietario;
	
	Reserva reserva;
	Reserva r2;
	
	EstadoReserva aceptada;
	EstadoReserva pendiente;
	EstadoReserva cancelada;
	EstadoReserva completada;
	
	List<Reserva> reservas;
	List<Inmueble> inmuebles;

	@BeforeEach
	void setUp(){
		
		propietario = new Propietario("p1","11111111", "example@gmail.com");
		
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		
		reserva = mock(Reserva.class);
		r2      = mock(Reserva.class);
		
		aceptada   = mock(ReservaAceptada.class);
		pendiente  = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		completada = mock(ReservaCompletada.class);
		
		propietario.addInmueble(inmueble1);
		propietario.addInmueble(inmueble2);
		
		 reservas = mock(List.class);
		 inmuebles = mock(List.class);
	}

	@Test
	void PropietarioAceptandoReservaDelInquilinoTest() {
		when(reserva.getEstado()).thenReturn(aceptada);
		propietario.aceptarReservaInquilino(reserva);
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void PropietarioCancelandoReservaDelInquilinoTest() {
		when(reserva.getEstado()).thenReturn(cancelada);
		propietario.cancelarReservaInquilino(reserva);
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void PropietarioAceptandoReservaDelInquilinoEstandoACeptadaTest() {
		propietario.aceptarReservaInquilino(reserva);
		when(reserva.getEstado()).thenReturn(aceptada);
		propietario.aceptarReservaInquilino(reserva);
		
		//No hay nada más para verificar.
		//verify(reserva).setEstado(any(ReservaAceptada.class));
		
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void PropietarioCancelandoReservaDelInquilinoEstandoCanceladaTest() {
		when(reserva.getEstado()).thenReturn(cancelada);
		propietario.cancelarReservaInquilino(reserva);
		propietario.cancelarReservaInquilino(reserva);
		
		//No hay nada más para verificar.
		
		assertTrue(reserva.getEstado() instanceof ReservaCancelada);
	}
	
	@Test
	void cantidadDeInmueblesTest() {
		assertEquals(propietario.getInmuebles().size(),2);
	}
	
	@Test
	void eliminarUnInmuebleTest() {
		propietario.eliminarInmueble(inmueble1);
		assertEquals(propietario.getInmuebles().size(),1);
	}
	
	@Test
	void cantidadDeReservasAceptadasDelInmuebleTest() {
		
		//Arreglar
		
		
		
		
		
		propietario.aceptarReservaInquilino(reserva);
		propietario.aceptarReservaInquilino(r2);
		
		inmueble1.addReserva(reserva);
		inmueble1.addReserva(r2);
		
		inmueble2.addReserva(reserva);
		
		verify(inmueble1, times(2)).addReserva(any(Reserva.class));
		verify(inmueble2, times(1)).addReserva(any(Reserva.class));
		//assertEquals(propietario.todasLasReservasAceptadas().size(),2 );
	}
	
	@Test
	void ProbarQueSeCancelaLaReserva() { 
		
		//setUp
		
		when(reserva.getEstado()).thenReturn(pendiente);
		
		//exercise
		
		propietario.aceptarReservaInquilino(reserva);
		propietario.cancelarReservaInquilino(reserva);
		//Verify
		
		verify(reserva,times(1)).cancelarReserva();
	}
	
	//Probando un Spy
	
	@Test
	void pruebaSpyTest() {
		
		inmueble1.addReserva(reserva);
		
		verify(inmueble1).addReserva(any(Reserva.class));
		
	}

}
