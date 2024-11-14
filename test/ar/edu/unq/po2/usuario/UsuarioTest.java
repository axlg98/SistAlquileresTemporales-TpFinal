package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
		propietario.rankearInquilino(1, inmueble, "pésimo servicio");
		
		assertEquals(propietario.getRankings().size(),1);
	}
	
	@Test
	void InquilinoRankeandoPropietarioTest() {
		inquilino.rankearPropietario(3, inmueble, "Regular");
		
		assertEquals(inquilino.getRankings().size(),1);
	}
	
	@Test
	void InquilinoRankeandoInmuebleTest() {
		inquilino.rankearInmueble(5, inmueble, "Excelenteservicio");
		
		assertEquals(inquilino.getRankings().size(),1);
	}
	
	@Test
	void addRankingTest() {
		propietario.addRanking(r1);
		propietario.addRanking(r2);
		propietario.addRanking(r3);
		propietario.addRanking(r4);
		
		assertEquals(propietario.getRankings().size(),4);
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
		propietario.rankearInquilino(6, inmueble, "Excelente servicio");
		assertEquals(propietario.getRankings().size(),0);
	}
	
	@Test
	void rankearConPuntajeMenorA1Test() {
		propietario.rankearInquilino(0, inmueble, "Pésimo servicio");
		assertEquals(propietario.getRankings().size(),0);
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

}
