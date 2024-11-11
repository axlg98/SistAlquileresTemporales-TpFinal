package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.usuario.Usuario;

class SATTest {
	
	private Usuario 			  usuario;
	private Inmueble 			  inmueble;
	private TipoInmueble 		  tipoInmueble;
	private Servicio 			  servicio;
	private FormaDePago	    	  formaDePago;
	private CategoriaRankeo 	  categoriaRankeo;
	private IPoliticaCancelacion  politicaCancelacion;
	private List<Usuario> 		  usuarios;
	private List<Inmueble> 		  inmuebles;
	private List<TipoInmueble> 	  tiposInmueble;
	private List<Servicio> 		  servicios;
	private List<FormaDePago>	  formasDePago;
	private List<CategoriaRankeo> categoriasRankeo;
	
	private SAT					  SAT;

	@BeforeEach
	void setUp() throws Exception {
		
		this.usuario 			 = mock(Usuario.class);
		this.inmueble 			 = mock(Inmueble.class);
		this.tipoInmueble 		 = mock(TipoInmueble.class);
		this.servicio 			 = mock(Servicio.class);
		this.formaDePago 		 = mock(FormaDePago.class);
		this.categoriaRankeo 	 = mock(CategoriaRankeo.class);
		this.politicaCancelacion = mock(IPoliticaCancelacion.class);
		this.usuarios 			 = new ArrayList<Usuario>();
		this.inmuebles 			 = new ArrayList<Inmueble>();
		this.tiposInmueble		 = new ArrayList<TipoInmueble>();
		this.servicios 			 = new ArrayList<Servicio>();
		this.formasDePago 		 = new ArrayList<FormaDePago>();
		this.categoriasRankeo 	 = new ArrayList<CategoriaRankeo>();
		
		this.SAT				 = new SAT();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.SAT);
	}
	
	@Test
	void testGetUsuarios() {
		assertEquals(usuarios, SAT.getUsuarios());
	}
	
	@Test
	void testGetInmuebles() {
		assertEquals(inmuebles, SAT.getInmuebles());
	}
	
	@Test
	void testGetTiposInmuebles() {
		assertEquals(tiposInmueble, SAT.getTiposInmueble());
	}
	
	@Test
	void testGetServicios() {
		assertEquals(servicios, SAT.getServicios());
	}
	
	@Test
	void testGetFormasDePago() {
		assertEquals(formasDePago, SAT.getFormasDePago());
	}
	
	@Test
	void testGetCategoriasRankeo() {
		assertEquals(categoriasRankeo, SAT.getCategoriasRankeo());
	}
	
	@Test
	void testAltaUsuario() {
		this.SAT.altaUsuario(usuario);
		assertTrue(SAT.getUsuarios().contains(usuario));
		this.SAT.altaUsuario(usuario);
		assertEquals(1, SAT.getUsuarios().size());
	}
	
	@Test
	void testAltaInmueble() {
		this.SAT.altaInmueble(inmueble);
		assertTrue(SAT.getInmuebles().contains(inmueble));
		this.SAT.altaInmueble(inmueble);
		assertEquals(1, SAT.getInmuebles().size());
	}

	@Test
	void testAltaTipoInmueble() {
		this.SAT.altaTipoInmueble(tipoInmueble);
		assertTrue(SAT.getTiposInmueble().contains(tipoInmueble));
		this.SAT.altaTipoInmueble(tipoInmueble);
		assertEquals(1, SAT.getTiposInmueble().size());
	}
	
	@Test
	void testAltaServicio() {
		this.SAT.altaServicio(servicio);
		assertTrue(SAT.getServicios().contains(servicio));
		this.SAT.altaServicio(servicio);
		assertEquals(1, SAT.getServicios().size());
	}
	
	@Test
	void testAltaFormaDePago() {
		this.SAT.altaFormaDePago(formaDePago);
		assertTrue(SAT.getFormasDePago().contains(formaDePago));
		this.SAT.altaFormaDePago(formaDePago);
		assertEquals(1, SAT.getFormasDePago().size());
	}
	
	@Test
	void testCategoriasRankeo() {
		this.SAT.altaCategoriaRankeo(categoriaRankeo);
		assertTrue(SAT.getCategoriasRankeo().contains(categoriaRankeo));
		this.SAT.altaCategoriaRankeo(categoriaRankeo);
		assertEquals(1, SAT.getCategoriasRankeo().size());
	}
	
}
