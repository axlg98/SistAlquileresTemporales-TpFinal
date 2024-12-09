package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.reserva.ReservaAceptada;
import ar.edu.unq.po2.reserva.ReservaPendiente;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

class UsuarioTest {
	
	
	 Usuario inquilino;
	 Usuario propietario;
	 SAT sat;
	 Ranking r1;
	 Ranking r2;
	 Ranking r3;
	 Ranking r4;
	 CategoriaRankeo	categoriaRankeo1;
	 CategoriaRankeo	categoriaRankeo2;
	 Inmueble inmueble;
	 List<Inmueble> inmuebles;
	 Reserva reserva;
	
	
	@BeforeEach
	void setUp() throws Exception {
		inquilino = new Usuario("Damian", "@@", "123");
		propietario = new Usuario("Axel", "example@gmail.com", "91218");
		sat = mock(SAT.class);
		this.r1 = mock(Ranking.class);
		this.r2 = mock(Ranking.class);
		this.r3 = mock(Ranking.class);
		this.r4 = mock(Ranking.class);
		this.categoriaRankeo1	 = mock(CategoriaRankeo.class);
		this.categoriaRankeo2	 = mock(CategoriaRankeo.class);
		inmuebles = mock(List.class);
		inmueble = mock(Inmueble.class);
		reserva = mock(Reserva.class);
	}
	
	@Test
	void PropietarioRankeandoInquilinoTest() {
		when(r1.getPuntaje()).thenReturn(1);
		propietario.rankearInquilino(inquilino, r1);
		assertEquals(1, inquilino.getRankings().size());
	}
	
	@Test
	void InquilinoRankeandoPropietarioTest() {
		when(r1.getPuntaje()).thenReturn(1);
		inquilino.rankearPropietario(propietario, r1);
		assertEquals(1, propietario.getRankings().size());
	}
	
	@Test
	void InquilinoRankeandoInmuebleTest() {
		when(r1.getPuntaje()).thenReturn(1);
		inquilino.rankearInmueble(inmueble, r1);
		verify(inmueble, times(1)).addRankeo(r1);
	}
	
	@Test
	void addRankingTest() {
		propietario.addRanking(r1);
		propietario.addRanking(r2);
		inquilino.addRanking(r3);
		inquilino.addRanking(r4);
		assertEquals(2, propietario.getRankings().size());
		assertEquals(2, inquilino.getRankings().size());
	}
	
	@Test
	void aceptarReservaInquilinoTest() {
		when(reserva.getEstado()).thenReturn( new ReservaPendiente());
		//assertTrue(reserva.getEstado() instanceof ReservaPendiente);
		//when(reserva.getEstado()).thenReturn(new ReservaAceptada());
		propietario.aceptarReservaInquilino(reserva);
		//assertTrue(reserva.getEstado() instanceof ReservaAceptada);
		verify(reserva).aceptarReserva();
	}
	
	@Test
	void rankearConPuntajeMayorA5Test() {
		when(r1.getPuntaje()).thenReturn(6);
		propietario.rankearInquilino(inquilino, r1);
		assertEquals(0, inquilino.getRankings().size());
	}
	
	@Test
	void rankearConPuntajeMenorA1Test() {
		when(r1.getPuntaje()).thenReturn(0);
		propietario.rankearInquilino(inquilino, r1);
		assertEquals(0, inquilino.getRankings().size());
	}
	
	//Inquilino
	
	@Test
	void reservarInmuebleTest() {
		// comprueba que se haya pasado el objeto de tipo Reserva y no el que se instancia
				// al agregar la reserva (any)
		
		
		inquilino.reservarInmueble(inmueble, null, null);
		
		verify(inmueble).addReserva(any(Reserva.class));
		
	}
	
	@Test
	void buscarInmuebles() {
		when(inmuebles.size()).thenReturn(0);
		when(sat.busquedaDelInquilino( null, null, null, 0, null, null)).thenReturn(inmuebles);
		int tamaño = (inquilino.buscarAlquiler(sat, "quilmes", LocalDate.now(), LocalDate.now(), 5, 1000.0, 2000.0)).size();
		
		assertEquals(tamaño, inmuebles.size());
	}
	
	@Test
	void testNotificacionReserva() {
		this.inquilino.reservarInmueble(inmueble, null, null);
		verify(inmueble, times(1)).informarReserva(inmueble);
	}

}
