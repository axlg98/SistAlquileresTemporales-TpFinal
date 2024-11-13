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
import ar.edu.unq.po2.reserva.ReservaPendiente;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;

class PropietarioTest {
	
	Inmueble inmueble1;
	Inmueble inmueble2;
	
	Reserva reserva;
	Reserva r2;
	
	EstadoReserva aceptada;
	EstadoReserva pendiente;
	EstadoReserva cancelada;
	EstadoReserva completada;
	
	List<Reserva> reservas;
	List<Inmueble> inmuebles;
	
	private Propietario propietario;
	private Usuario inquilino;
	private Ranking ranking;

	@BeforeEach
	void setUp(){
		
		
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		
		reserva = mock(Reserva.class);
		r2      = mock(Reserva.class);
		
		aceptada   = mock(ReservaAceptada.class);
		pendiente  = mock(ReservaPendiente.class);
		cancelada  = mock(ReservaCancelada.class);
		
		 reservas = mock(List.class);
		 inmuebles = mock(List.class);
		 
		 this.inquilino = mock(Usuario.class);
		 this.ranking	= mock(Ranking.class);
		 
		 this.propietario = new Usuario("Pablo Pérez", "1130205025", "pperez@gmail.com");
	}

	//ARREGLAR LA PARTE DE LOS TEST
	
	@Test
	void PropietarioAceptandoReservaDelInquilinoTest() {
		when(reserva.getEstado()).thenReturn(aceptada);
		assertTrue(reserva.getEstado() instanceof ReservaAceptada);
	}
	
	@Test
	void testRankearInquilino() {
		this.propietario.rankearInquilino(inquilino, ranking);
		verify(inquilino, times(1)).addRankeo(ranking);
	}

}
