package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Ranking;
import ar.edu.unq.po2.usuario.Usuario;

class InmuebleTest {
	private Inmueble			inmueble;
	private Usuario				propietario;
	private TipoInmueble 	  	tipoInmueble;
	private Double 		 	  	superficie;
	private String 		 	  	pais;
	private String 		 	  	ciudad;
	private String 		 	  	direccion;
	private int 		 	  	capacidad;
	private LocalTime 	 	  	checkIn;
	private LocalTime 	 	  	checkOut;
	private Double 		 	  	precio;
	private PoliticaCancelacion politicaCancelacion;
	private Servicio			servicio;
	private List<Servicio> 	  	servicios;
	private String				foto;
	private List<String> 	  	fotos;
	private FormaDePago			formaDePago;
	private List<FormaDePago> 	formasDePago;
	private Alquiler			alquiler;
	private List<Alquiler>	  	alquileres;
	private Reserva				reserva1;
	private Reserva				reserva2;
	private List<Reserva>	  	reservas;
	private Ranking				ranking1;
	private Ranking				ranking2;
	private Ranking				ranking3;
	private Ranking				ranking4;
	private List<Ranking>		rankeos;
	private CategoriaRankeo		categoriaRankeo1;
	private CategoriaRankeo		categoriaRankeo2;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario		 = mock(Usuario.class);
		this.tipoInmueble 		 = mock(TipoInmueble.class);
		this.superficie  		 = 70.0;
		this.pais		 		 = "Argentina";
		this.ciudad		 		 = "Buenos Aires";
		this.direccion	 		 = "Moreno 72";
		this.capacidad	 		 = 3;
		this.checkIn	 		 = LocalTime.of(15, 0);
		this.checkOut	  		 = LocalTime.of(10, 0);
		this.precio				 = 20000.0;
		this.foto				 = "foto1.jpg";
		this.politicaCancelacion = mock(PoliticaCancelacion.class);
		this.servicio			 = mock(Servicio.class);
		this.servicios			 = new ArrayList<Servicio>();
		this.foto				 = "foto.jpg";
		this.fotos				 = new ArrayList<String>();
		this.formaDePago		 = mock(FormaDePago.class);
		this.formasDePago		 = new ArrayList<FormaDePago>();
		this.alquiler			 = mock(Alquiler.class);
		this.alquileres			 = new ArrayList<Alquiler>();
		this.reserva1			 = mock(Reserva.class);
		this.reserva2			 = mock(Reserva.class);
		this.reservas			 = new ArrayList<Reserva>();
		this.ranking1			 = mock(Ranking.class);
		this.ranking2			 = mock(Ranking.class);
		this.ranking3			 = mock(Ranking.class);
		this.ranking4			 = mock(Ranking.class);
		this.rankeos			 = new ArrayList<Ranking>();
		this.categoriaRankeo1	 = mock(CategoriaRankeo.class);
		this.categoriaRankeo2	 = mock(CategoriaRankeo.class);
		
		this.inmueble			 = new Inmueble(propietario, tipoInmueble, superficie, pais, ciudad, direccion, capacidad, 
												checkIn, checkOut, precio, politicaCancelacion, servicios, fotos, formasDePago);
	}

	@Test
	void testConstructor() {
		assertNotNull(inmueble);
	}
	
	@Test
	void testGetPropietario(){
		assertEquals(propietario, inmueble.getPropietario());
	}
	
	@Test
	void testGetServicios(){
		assertEquals(servicios, inmueble.getServicios());
	}
	
	@Test
	void testGetFotos(){
		assertEquals(fotos, inmueble.getFotos());
	}
	
	@Test
	void testGetFormasDePago(){
		assertEquals(formasDePago, inmueble.getFormasDePago());
	}
	
	@Test
	void testGetAlquileres(){
		assertEquals(alquileres, inmueble.getAlquileres());
	}
	
	@Test
	void testGetReservas(){
		assertEquals(reservas, inmueble.getReservas());
	}
	
	@Test
	void testGetRankeos(){
		assertEquals(rankeos, inmueble.getRankeos());
	}
	
	
	@Test
	void testAddServicio() {
		inmueble.addServicio(servicio);
		assertEquals(1, inmueble.getServicios().size());
		inmueble.addServicio(servicio);
		assertEquals(1, inmueble.getServicios().size());
	}
	
	@Test
	void testAddFoto() {
		inmueble.addFoto(foto);
		assertEquals(1, inmueble.getFotos().size());
		inmueble.addFoto(foto);
		inmueble.addFoto(foto);
		inmueble.addFoto(foto);
		inmueble.addFoto(foto);
		inmueble.addFoto(foto);
		assertEquals(5, inmueble.getFotos().size());
	}
	
	@Test
	void testAddFormaDePago() {
		inmueble.addFormaDePago(formaDePago);
		assertEquals(1, inmueble.getFormasDePago().size());
		inmueble.addFormaDePago(formaDePago);
		assertEquals(1, inmueble.getFormasDePago().size());
	}
	
	@Test
	void testAddAlquiler() {
		inmueble.addAlquiler(alquiler);
		assertEquals(1, inmueble.getAlquileres().size());
		inmueble.addAlquiler(alquiler);
		assertEquals(1, inmueble.getAlquileres().size());
	}
	
	@Test
	void testAddReserva() {
		inmueble.addReserva(reserva1);
		assertEquals(1, inmueble.getReservas().size());
		inmueble.addReserva(reserva1);
		assertEquals(1, inmueble.getReservas().size());
	}
	
	@Test
	void testAddRankeo() {
		inmueble.addRankeo(ranking1);
		assertEquals(1, inmueble.getRankeos().size());
	}
	
	@Test
	void testCancelarReserva() {
		inmueble.addReserva(reserva1);
		inmueble.cancelarReserva(reserva1);
		verify(reserva1, times(1)).cancelarReserva();
		inmueble.cancelarReserva(reserva2);
		verify(reserva2, times(0)).cancelarReserva();
	}
	
	@Test
	void testGetPromedioGeneral() {
		inmueble.addRankeo(ranking1);
		inmueble.addRankeo(ranking2);
		when(ranking1.getPuntaje()).thenReturn(4);
		when(ranking2.getPuntaje()).thenReturn(3);
		assertEquals(3.5, inmueble.getPromedioGeneral());
	}
	
	@Test
	void testGetPromedioCategoria() {
		inmueble.addRankeo(ranking1);
		inmueble.addRankeo(ranking2);
		inmueble.addRankeo(ranking3);
		inmueble.addRankeo(ranking4);
		when(ranking1.getPuntaje()).thenReturn(4);
		when(ranking1.getCategoria()).thenReturn(categoriaRankeo1);
		when(ranking2.getPuntaje()).thenReturn(3);
		when(ranking2.getCategoria()).thenReturn(categoriaRankeo1);
		when(ranking3.getPuntaje()).thenReturn(3);
		when(ranking3.getCategoria()).thenReturn(categoriaRankeo2);
		when(ranking4.getPuntaje()).thenReturn(2);
		when(ranking4.getCategoria()).thenReturn(categoriaRankeo2);
		assertEquals(3.5, inmueble.getPromedioCategoria(categoriaRankeo1));
		assertEquals(2.5, inmueble.getPromedioCategoria(categoriaRankeo2));
	}

}