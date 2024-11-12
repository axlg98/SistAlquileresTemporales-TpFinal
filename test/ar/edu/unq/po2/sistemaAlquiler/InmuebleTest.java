package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Propietario;
import ar.edu.unq.po2.usuario.Ranking;

class InmuebleTest {
	private Inmueble			inmueble;
	private Propietario			propietario;
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
	private Ranking				ranking1;
	private Ranking				ranking2;
	private Ranking				ranking3;
	private Ranking				ranking4;
	private List<Ranking>		rankeos;
	private CategoriaRankeo		categoriaRankeo1;
	private CategoriaRankeo		categoriaRankeo2;
	private TemporadaAlta 		tempoAlta;
	private TemporadaBaja 		tempoBaja;
	private Carnaval 			carnaval;
	private FinSemanaLargo 		finDeLargo;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario		 = mock(Propietario.class);
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
		this.ranking1			 = mock(Ranking.class);
		this.ranking2			 = mock(Ranking.class);
		this.ranking3			 = mock(Ranking.class);
		this.ranking4			 = mock(Ranking.class);
		this.rankeos			 = new ArrayList<Ranking>();
		this.categoriaRankeo1	 = mock(CategoriaRankeo.class);
		this.categoriaRankeo2	 = mock(CategoriaRankeo.class);
		this.tempoAlta 			 = mock(TemporadaAlta.class);
		this.tempoBaja			 = mock(TemporadaBaja.class);
		this.carnaval			 = mock(Carnaval.class);
		this.finDeLargo 		 = mock(FinSemanaLargo.class);
		
		
		this.inmueble			 = new Inmueble(propietario, tipoInmueble, superficie, pais, ciudad, direccion, capacidad, 
												checkIn, checkOut, precio, politicaCancelacion, servicios, fotos, formasDePago);
		
	}

	@Test
	void calcularPrecioCuandoEsTemporadaBaja() {
		when(tempoBaja.getAjustePrecio()).thenReturn(1.0);
		when(tempoBaja.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoBaja.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		inmueble.agregarPeriodo(tempoBaja);
		
		assertEquals(80000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 4)) );
	}
	@Test
	void calcularPrecioCuandoEsTemporadaAlta() {
		when(tempoAlta.getAjustePrecio()).thenReturn(2.0);
		when(tempoAlta.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoAlta.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		inmueble.agregarPeriodo(tempoAlta);
		
		assertEquals(160000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 4)) );
	}
	@Test
	void calcularPrecioCuandoEsPeriodoCarnaval() {
		when(carnaval.getAjustePrecio()).thenReturn(1.5);
		when(carnaval.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(carnaval.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 2));
		inmueble.agregarPeriodo(carnaval);
		
		assertEquals(100000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 4)) );
	}
	@Test
	void calcularPrecioCuandoEsPeriodoFinSemanaLargo() {
		when(finDeLargo.getAjustePrecio()).thenReturn(1.3);
		when(finDeLargo.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(finDeLargo.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 3));
		inmueble.agregarPeriodo(finDeLargo);
		
		assertEquals(118000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 5)) );
	}
	@Test
	void calcularPrecioCuandoEsPeriodoFinSemanaLargoYTemporadaAlta() {
		when(tempoAlta.getAjustePrecio()).thenReturn(2.0);
		when(tempoAlta.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoAlta.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		
		when(finDeLargo.getAjustePrecio()).thenReturn(1.3);
		when(finDeLargo.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 5));
		when(finDeLargo.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 5));
		
		inmueble.agregarPeriodo(tempoAlta);
		inmueble.agregarPeriodo(finDeLargo);
		
		assertEquals(186000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 5)) );
	}
	@Test
	void calcularPrecioCuandoEsPeriodoFinSemanaLargoYTemporadaBaja() {
		when(finDeLargo.getAjustePrecio()).thenReturn(1.3);
		when(finDeLargo.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 4));
		when(finDeLargo.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 5));
		inmueble.agregarPeriodo(finDeLargo);
		when(tempoBaja.getAjustePrecio()).thenReturn(1.0);
		when(tempoBaja.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoBaja.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		inmueble.agregarPeriodo(tempoBaja);
		
		assertEquals(112000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 5)) );
	}
	@Test
	void calcularPrecioCuandoEsPeriodoFinSemanaLargoYCarnaval() {
		when(finDeLargo.getAjustePrecio()).thenReturn(1.3);
		when(finDeLargo.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 4));
		when(finDeLargo.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 5));
		
		when(carnaval.getAjustePrecio()).thenReturn(1.5);
		when(carnaval.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(carnaval.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 2));
		
		inmueble.agregarPeriodo(finDeLargo);
		inmueble.agregarPeriodo(carnaval);
		
		assertEquals(132000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 5)) );
	}
	@Test
	void calcularPrecioCuandoEsTemporadaAltaYTemporadaBaja() {
		when(tempoAlta.getAjustePrecio()).thenReturn(2.0);
		when(tempoAlta.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoAlta.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		when(tempoBaja.getAjustePrecio()).thenReturn(1.0);
		when(tempoBaja.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 5));
		when(tempoBaja.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 6));
		inmueble.agregarPeriodo(tempoBaja);
		inmueble.agregarPeriodo(tempoAlta);
		
		assertEquals(200000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 6)) );
	}
	@Test
	void calcularPrecioCuandoEsTemporadaAltaYCarnaval() {
		when(tempoAlta.getAjustePrecio()).thenReturn(2.0);
		when(tempoAlta.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoAlta.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		when(carnaval.getAjustePrecio()).thenReturn(1.5);
		when(carnaval.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 5));
		when(carnaval.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 6));
		inmueble.agregarPeriodo(carnaval);
		inmueble.agregarPeriodo(tempoAlta);
		
		assertEquals(220000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 6)) );
	}
	@Test
	void calcularPrecioCuandoEsTemporadaBajaYCarnaval() {
		when(tempoBaja.getAjustePrecio()).thenReturn(1.0);
		when(tempoBaja.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 1));
		when(tempoBaja.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 4));
		when(carnaval.getAjustePrecio()).thenReturn(1.5);
		when(carnaval.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 5));
		when(carnaval.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 6));
		inmueble.agregarPeriodo(carnaval);
		inmueble.agregarPeriodo(tempoBaja);
		
		assertEquals(140000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 1), LocalDate.of(2000, 11, 6)) );
	}
	@Test
	void cuandoNoHayPeriodoAsignadoEnLasFechasDeBusqueda() {
		when(tempoBaja.getAjustePrecio()).thenReturn(1.0);
		when(tempoBaja.getFechaInicio()).thenReturn(LocalDate.of(2000, 10, 1));
		when(tempoBaja.getFechaFin()).thenReturn(LocalDate.of(2000, 10, 4));
		when(carnaval.getAjustePrecio()).thenReturn(1.5);
		when(carnaval.getFechaInicio()).thenReturn(LocalDate.of(2000, 12, 5));
		when(carnaval.getFechaFin()).thenReturn(LocalDate.of(2000, 12, 6));
		when(tempoAlta.getAjustePrecio()).thenReturn(2.0);
		when(tempoAlta.getFechaInicio()).thenReturn(LocalDate.of(2000, 10, 1));
		when(tempoAlta.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 1));
		when(finDeLargo.getAjustePrecio()).thenReturn(1.3);
		when(finDeLargo.getFechaInicio()).thenReturn(LocalDate.of(2000, 11, 4));
		when(finDeLargo.getFechaFin()).thenReturn(LocalDate.of(2000, 11, 5));
		
		inmueble.agregarPeriodo(tempoBaja);
		inmueble.agregarPeriodo(carnaval);
		inmueble.agregarPeriodo(tempoAlta);
		inmueble.agregarPeriodo(finDeLargo);
		
		assertEquals(40000.0, inmueble.calcularPrecioTotal(LocalDate.of(2000, 11, 21), LocalDate.of(2000, 11, 22)) );
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
		inmueble.addReserva(reserva);
		assertEquals(1, inmueble.getReservas().size());
		inmueble.addReserva(reserva);
		assertEquals(1, inmueble.getReservas().size());
	}
	
	@Test
	void testAddRankeo() {
		inmueble.addRankeo(ranking1);
		assertEquals(1, inmueble.getRankeos().size());
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