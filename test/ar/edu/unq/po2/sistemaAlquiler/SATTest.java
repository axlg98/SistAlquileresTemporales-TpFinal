package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Inquilino;
import ar.edu.unq.po2.usuario.Usuario;

class SATTest {
	
	private Usuario 			  usuario;
	private Inmueble 			  inmueble1;
	private Inmueble 			  inmueble2;
	private Inmueble 			  inmueble3;
	private Inmueble 			  inmueble4;
	private Inmueble 			  inmueble5;
	private Inmueble 			  inmueble6;
	private Inmueble 			  inmueble7;
	private TipoInmueble 		  tipoInmueble;
	private Servicio 			  servicio;
	private FormaDePago	    	  formaDePago;
	private CategoriaRankeo 	  categoriaRankeo;
	private IPoliticaCancelacion  politicaCancelacion;
	private Reserva				  reserva1;
	private Reserva				  reserva2;
	private Reserva				  reserva3;
	private List<Usuario> 		  usuarios;
	private List<Inmueble> 		  inmuebles;
	private List<TipoInmueble> 	  tiposInmueble;
	private List<Servicio> 		  servicios;
	private List<FormaDePago>	  formasDePago;
	private List<CategoriaRankeo> categoriasRankeo;
	private Inquilino 			  inquilino1;
	private Inquilino 			  inquilino2;
	private SAT					  SAT;

	@BeforeEach
	void setUp() throws Exception {
		
		this.usuario 			 = mock(Usuario.class);
		this.inmueble1 			 = mock(Inmueble.class);
		this.inmueble2 			 = mock(Inmueble.class);
		this.inmueble3 			 = mock(Inmueble.class);
		this.inmueble4 			 = mock(Inmueble.class);
		this.inmueble5 			 = mock(Inmueble.class);
		this.inmueble6 			 = mock(Inmueble.class);
		this.inmueble7 			 = mock(Inmueble.class);
		this.tipoInmueble 		 = mock(TipoInmueble.class);
		this.servicio 			 = mock(Servicio.class);
		this.formaDePago 		 = mock(FormaDePago.class);
		this.categoriaRankeo 	 = mock(CategoriaRankeo.class);
		this.politicaCancelacion = mock(IPoliticaCancelacion.class);
		this.reserva1			 = mock(Reserva.class);
		this.reserva2			 = mock(Reserva.class);
		this.reserva3			 = mock(Reserva.class);
		this.usuarios 			 = new ArrayList<Usuario>();
		this.inmuebles 			 = new ArrayList<Inmueble>();
		this.tiposInmueble		 = new ArrayList<TipoInmueble>();
		this.servicios 			 = new ArrayList<Servicio>();
		this.formasDePago 		 = new ArrayList<FormaDePago>();
		this.categoriasRankeo 	 = new ArrayList<CategoriaRankeo>();
		this.inquilino1			 = mock(Inquilino.class);
		this.inquilino2			 = mock(Inquilino.class);
		
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
		this.SAT.altaInmueble(inmueble1);
		assertTrue(SAT.getInmuebles().contains(inmueble1));
		this.SAT.altaInmueble(inmueble1);
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
	@Test
	void todasLasReservasDeUnInquilino() {
		when(reserva1.getInquilino()).thenReturn(inquilino1);
		when(reserva2.getInquilino()).thenReturn(inquilino2);
		when(reserva3.getInquilino()).thenReturn(inquilino1);
		inmueble1.addReserva(reserva1);
		inmueble2.addReserva(reserva2);
		inmueble2.addReserva(reserva3);
		when(inmueble1.getReservas()).thenReturn((Arrays.asList(reserva1)));
		when(inmueble2.getReservas()).thenReturn((Arrays.asList(reserva2)));
		when(inmueble2.getReservas()).thenReturn((Arrays.asList(reserva3)));
		SAT.altaInmueble(inmueble1);
		SAT.altaInmueble(inmueble2);
		SAT.altaInmueble(inmueble3);
		assertTrue(SAT.todasLasReservas(inquilino1).contains(reserva1));
		assertFalse(SAT.todasLasReservas(inquilino1).contains(reserva2));
		assertTrue(SAT.todasLasReservas(inquilino1).contains(reserva3));
	}
	@Test
	void testGetInmueblesDisponibles() {
		when(inmueble1.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble2.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(false);
		when(inmueble3.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		this.SAT.altaInmueble(inmueble1);
		this.SAT.altaInmueble(inmueble2);
		this.SAT.altaInmueble(inmueble3);
		assertTrue(this.SAT.getInmueblesDisponibles("", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 0, 0.0, 0.0).contains(inmueble1));
		assertFalse(this.SAT.getInmueblesDisponibles("", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 0, 0.0, 0.0).contains(inmueble2));
		assertTrue(this.SAT.getInmueblesDisponibles("", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 0, 0.0, 0.0).contains(inmueble3));
	}
	@Test
	void testBusquedaDeInmueblesParaReservar() {
		when(inmueble1.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble1.getCiudad()).thenReturn("Quilmes");
		when(inmueble1.getCapacidad()).thenReturn(3);
		when(inmueble1.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(6000.0);
		when(inmueble2.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(false);
		when(inmueble2.getCiudad()).thenReturn("Quilmes");
		when(inmueble2.getCapacidad()).thenReturn(3);
		when(inmueble2.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(6000.0);
		when(inmueble3.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble3.getCiudad()).thenReturn("Quilmes");
		when(inmueble3.getCapacidad()).thenReturn(3);
		when(inmueble3.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(7000.0);
		when(inmueble4.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble4.getCiudad()).thenReturn("Bernal");
		when(inmueble4.getCapacidad()).thenReturn(3);
		when(inmueble4.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(4000.0);
		when(inmueble5.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble5.getCiudad()).thenReturn("Quilmes");
		when(inmueble5.getCapacidad()).thenReturn(2);
		when(inmueble5.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(6000.0);
		when(inmueble6.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble6.getCiudad()).thenReturn("Quilmes");
		when(inmueble6.getCapacidad()).thenReturn(3);
		when(inmueble6.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(7000.0);
		when(inmueble7.isDisponible(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(true);
		when(inmueble7.getCiudad()).thenReturn("Quilmes");
		when(inmueble7.getCapacidad()).thenReturn(3);
		when(inmueble7.calcularPrecioTotal(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20))).thenReturn(11000.0);
		this.SAT.altaInmueble(inmueble1);
		this.SAT.altaInmueble(inmueble2);
		this.SAT.altaInmueble(inmueble3);
		this.SAT.altaInmueble(inmueble4);
		this.SAT.altaInmueble(inmueble5);
		this.SAT.altaInmueble(inmueble6);
		this.SAT.altaInmueble(inmueble7);
		assertTrue(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble1));
		assertFalse(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble2));
		assertTrue(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble3));
		assertFalse(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble4));
		assertFalse(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble5));
		assertTrue(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble6));
		assertFalse(this.SAT.busquedaDelInquilino("Quilmes", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), 3, 5000.0, 10000.0).contains(inmueble7));
	}
	
}
