package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

class InquilinoTest {
	
	
	private Inquilino inquilino;
	private SAT sat;
	private Ranking r1;
	private Ranking r2;
	private Ranking r3;
	private Ranking r4;
	private CategoriaRankeo	categoriaRankeo1;
	private CategoriaRankeo	categoriaRankeo2;
	private Inmueble inmueble;
	private List<Inmueble> inmuebles;
	private Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		inquilino = new Inquilino("damian", "123", "d@gmail.com");
		sat = mock(SAT.class);
		this.r1 = mock(Ranking.class);
		this.r2 = mock(Ranking.class);
		this.r3 = mock(Ranking.class);
		this.r4 = mock(Ranking.class);
		this.categoriaRankeo1	 = mock(CategoriaRankeo.class);
		this.categoriaRankeo2	 = mock(CategoriaRankeo.class);
		inmuebles = mock(List.class);
		inmueble = mock(Inmueble.class);
		
	}
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
		when(sat.busquedaDelInquilino(null, null, null, null, 0, null, null)).thenReturn(inmuebles);
		int tamaño = (inquilino.buscarAlquiler(sat, "quilmes", LocalDate.now(), LocalDate.now(), 5, 1000.0, 2000.0)).size();
		
		assertEquals(tamaño, inmuebles.size());
	}
	
	@Test
	void agregarRankingAInquilino() {
		inquilino.addRankeo(r1);
		assertEquals(1, inquilino.getRankeos().size());
	}
	
	@Test
	void obtenerPromedioGeneralRankingEnInquilino() {
		when(r1.getPuntaje()).thenReturn(5);
		when(r2.getPuntaje()).thenReturn(2);
		
		inquilino.addRankeo(r1);
		inquilino.addRankeo(r2);
		
		assertEquals(3.5, inquilino.getPromedioGeneral());
	}
	
	@Test
	void testGetPromedioCategoria() {
		
		inquilino.addRankeo(r1);
		inquilino.addRankeo(r2);
		inquilino.addRankeo(r3);
		inquilino.addRankeo(r4);
		
		when(r1.getPuntaje()).thenReturn(4);
		when(r1.getCategoria()).thenReturn(categoriaRankeo1);
		when(r2.getPuntaje()).thenReturn(3);
		when(r2.getCategoria()).thenReturn(categoriaRankeo1);
		when(r3.getPuntaje()).thenReturn(3);
		when(r3.getCategoria()).thenReturn(categoriaRankeo2);
		when(r4.getPuntaje()).thenReturn(2);
		when(r4.getCategoria()).thenReturn(categoriaRankeo2);
		
		assertEquals(3.5, inquilino.getPromedioCategoria(categoriaRankeo1));
		assertEquals(2.5, inquilino.getPromedioCategoria(categoriaRankeo2));
		
	}

}
