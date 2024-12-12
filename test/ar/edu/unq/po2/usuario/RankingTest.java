package ar.edu.unq.po2.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;

class RankingTest {
	
	private CategoriaRankeo categoria;
	private Ranking			ranking;

	@BeforeEach
	void setUp() throws Exception {
		
		this.categoria = mock(CategoriaRankeo.class);
		
		this.ranking   = new Ranking(3, categoria, "Buen trato");
	}

	@Test
	void testConstructor() {
		assertNotNull(ranking);
		
		
	}
	
	@Test
	void testGetPuntaje() {
		assertEquals(3, ranking.getPuntaje());
	}
	
	@Test
	void testGetCategoria() {
		assertEquals(categoria, ranking.getCategoria());
	}
	
	@Test
	void testGetComentario() {
		assertEquals("Buen trato", ranking.getComentarios());
	}

}
