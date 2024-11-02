package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTest {
	private Inmueble			inmueble;
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
	private Reserva				reserva;
	private List<Reserva>	  	reservas;
	private Ranking				ranking;
	private List<Ranking>		rankeos; 

	@BeforeEach
	void setUp() throws Exception {
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
		this.reserva			 = mock(Reserva.class);
		this.reservas			 = new ArrayList<Reserva>();
		this.ranking			 = mock(Ranking.class);
		this.rankeos			 = new ArrayList<Ranking>();
		
		this.inmueble			 = new Inmueble(tipoInmueble, superficie, pais, ciudad, direccion, capacidad, checkIn, checkOut,
												precio, politicaCancelacion, servicios, fotos, formasDePago);
	}

	@Test
	void testConstructor() {
		assertNotNull(inmueble);
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
		inmueble.addReserva(reserva);
		assertEquals(1, inmueble.getReservas().size());
		inmueble.addReserva(reserva);
		assertEquals(1, inmueble.getReservas().size());
	}
	
	@Test
	void testAddRankeo() {
		inmueble.addRankeo(ranking);
		assertEquals(1, inmueble.getRankeos().size());
	}

}
