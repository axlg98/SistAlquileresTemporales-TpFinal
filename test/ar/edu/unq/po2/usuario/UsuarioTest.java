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
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

class UsuarioTest {
	
	//private Inquilino inquilino;
	private Usuario inquilino;
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
		inquilino = new Usuario("Damian", "@@", "123");
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

}
