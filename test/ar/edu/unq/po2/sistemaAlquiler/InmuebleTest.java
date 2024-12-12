package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Ranking;
import ar.edu.unq.po2.usuario.Usuario;

class InmuebleTest {
	private Inmueble			inmueble;
	private Usuario				propietario;
	private Usuario				inquilino;
	private TipoInmueble 	  	tipoInmueble;
	private Double 		 	  	superficie;
	private String 		 	  	pais;
	private String 		 	  	ciudad;
	private String 		 	  	direccion;
	private int 		 	  	capacidad;
	private LocalTime 	 	  	checkIn;
	private LocalTime 	 	  	checkOut;
	private Double 		 	  	precio;
	private IPoliticaCancelacion politicaCancelacion;
	private IPoliticaCancelacion cancelacionGratuita;
	private IPoliticaCancelacion intermedia;
	private IPoliticaCancelacion sinCancelacion;
	private Servicio			servicio;
	private Set<Servicio> 	  	servicios;
	private String				foto1;
	private String				foto2;
	private Set<String> 	  	fotos;
	private FormaDePago			formaDePago;
	private Set<FormaDePago> 	formasDePago;
	
	private Reserva				reserva1;
	private Reserva				reserva2;
	private Reserva				reserva3;
	private Set<Reserva>	  	reservas;
	private Ranking				ranking1;
	private Ranking				ranking2;
	private Ranking				ranking3;
	private Ranking				ranking4;
	private Set<Ranking>		rankeos;
	private CategoriaRankeo		categoriaRankeo1;
	private CategoriaRankeo		categoriaRankeo2;
	private TemporadaAlta 		tempoAlta;
	private TemporadaBaja 		tempoBaja;
	private Carnaval 			carnaval;
	private FinSemanaLargo 		finDeLargo;
	private Notificado			notificado1;
	private Notificado			notificado2;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario		 = mock(Usuario.class);
		this.inquilino			 = mock(Usuario.class);
		this.tipoInmueble 		 = mock(TipoInmueble.class);
		this.superficie  		 = 70.0;
		this.pais		 		 = "Argentina";
		this.ciudad		 		 = "Buenos Aires";
		this.direccion	 		 = "Moreno 72";
		this.capacidad	 		 = 3;
		this.checkIn	 		 = LocalTime.of(15, 0);
		this.checkOut	  		 = LocalTime.of(10, 0);
		this.precio				 = 20000.0;
		this.foto1				 = "foto1.jpg";
		this.foto2				 = "foto2.jpg";
		this.politicaCancelacion = mock(IPoliticaCancelacion.class);
		this.cancelacionGratuita = mock(CancelacionGratuita.class);
		this.sinCancelacion      = mock(SinCancelacion.class);
		this.intermedia			 = mock(Intermedia.class);
		
		this.servicio			 = mock(Servicio.class);
		this.servicios			 = new HashSet<Servicio>();
		this.fotos				 = new HashSet<String>();
		this.formaDePago		 = mock(FormaDePago.class);
		
		
		this.reserva1			 = mock(Reserva.class);
		this.reserva2			 = mock(Reserva.class);
		this.reserva3			 = mock(Reserva.class);
		this.reservas			 = new HashSet<Reserva>();
		this.ranking1			 = mock(Ranking.class);
		this.ranking2			 = mock(Ranking.class);
		this.ranking3			 = mock(Ranking.class);
		this.ranking4			 = mock(Ranking.class);
		this.rankeos			 = new HashSet<Ranking>();
		this.categoriaRankeo1	 = mock(CategoriaRankeo.class);
		this.categoriaRankeo2	 = mock(CategoriaRankeo.class);
		this.tempoAlta 			 = mock(TemporadaAlta.class);
		this.tempoBaja			 = mock(TemporadaBaja.class);
		this.carnaval			 = mock(Carnaval.class);
		this.finDeLargo 		 = mock(FinSemanaLargo.class);
		this.notificado1		 = mock(Notificado.class);
		this.notificado2		 = mock(Notificado.class);
		
		
		this.inmueble			 = new Inmueble(propietario, tipoInmueble, superficie, pais, ciudad, direccion, capacidad, 
												checkIn, checkOut, precio, politicaCancelacion, servicios, fotos, formaDePago);
		
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
		List<Servicio> servicios = this.servicios.stream().collect(Collectors.toList()); 
		assertEquals(servicios, inmueble.getServicios());
	}
	
	@Test
	void testGetFotos(){
		List<String> fotos = this.fotos.stream().collect(Collectors.toList());
		assertEquals(fotos, inmueble.getFotos());
	}
	
	

	
	@Test
	void testGetReservas(){
		List<Reserva> reservas = this.reservas.stream().collect(Collectors.toList());
		assertEquals(reservas, inmueble.getReservas());
	}
	
	@Test
	void testGetRankeos(){
		List<Ranking> rankeos = this.rankeos.stream().collect(Collectors.toList());
		assertEquals(rankeos, inmueble.getRankeos());
	}
	
	@Test
	void testGetCiudad() {
		assertEquals(ciudad, inmueble.getCiudad());
	}
	
	@Test
	void testGetCapacidad() {
		assertEquals(capacidad, inmueble.getCapacidad());
	}
	
	@Test
	void testSetPrecio() {
		inmueble.setPrecio(15000.0);
		assertEquals(15000.0, inmueble.getPrecio());
		inmueble.setPrecio(18000.0);
		assertEquals(18000.0, inmueble.getPrecio());
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
		inmueble.addFoto(foto1);
		assertEquals(1, inmueble.getFotos().size());
		inmueble.addFoto(foto1);
		inmueble.addFoto(foto1);
		inmueble.addFoto(foto1);
		inmueble.addFoto(foto2);
		inmueble.addFoto(foto2);
		assertEquals(2, inmueble.getFotos().size());
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
		when(reserva1.getFechaInicio()).thenReturn(LocalDate.of(2024, 12, 1));
		when(reserva1.getFechaFin()).thenReturn(LocalDate.of(2024, 12, 5));
		
		when(politicaCancelacion.costoDeCancelacion(reserva1, LocalDate.of(2024, 11, 20), inmueble.getPrecio())).thenReturn(0.0);
		inmueble.setPoliticaCancelacion(cancelacionGratuita);
		
		
		inmueble.addReserva(reserva1);
		inmueble.cancelarReserva(reserva1, LocalDate.of(2024, 11, 30) );
		
		assertEquals(cancelacionGratuita.costoDeCancelacion(reserva1,  LocalDate.of(2024, 11, 20), inmueble.getPrecio()), 0.0);
		verify(reserva1, times(1)).cancelarReserva();
		
		
	}
	@Test
	void testCancelarReservaConPoliticaIntermedia() {
		when(reserva1.getFechaInicio()).thenReturn(LocalDate.of(2024, 12, 1));
		when(reserva1.getFechaFin()).thenReturn(LocalDate.of(2024, 12, 5));
		
		when(intermedia.costoDeCancelacion(reserva1, LocalDate.of(2024, 11, 20), inmueble.getPrecio())).thenReturn(0.0);
		inmueble.setPoliticaCancelacion(cancelacionGratuita);
		
		
		inmueble.addReserva(reserva1);
		inmueble.cancelarReserva(reserva1, LocalDate.of(2024, 11, 30) );
		
		assertEquals(cancelacionGratuita.costoDeCancelacion(reserva1,  LocalDate.of(2024, 11, 20), inmueble.getPrecio()), 0.0);
		verify(reserva1, times(1)).cancelarReserva();
		
		
	}
	// falta hacer para intermedia y Sin cancelacion
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
	
	@Test
	void testNotificacionBajaDePrecio() {
		inmueble.suscribirNotificado(notificado1);
		inmueble.suscribirNotificado(notificado2);
		inmueble.setPrecio(15000.0);
		verify(notificado1, times(1)).recibirBajaDePrecio(inmueble);
		verify(notificado2, times(1)).recibirBajaDePrecio(inmueble);
		inmueble.desuscribirNotificado(notificado2);
		inmueble.setPrecio(10000.0);
		verify(notificado1, times(2)).recibirBajaDePrecio(inmueble);
		verify(notificado2, times(1)).recibirBajaDePrecio(inmueble);
	}
	
	@Test
	void testNotificacionCancelacion() {
		inmueble.suscribirNotificado(notificado1);
		inmueble.suscribirNotificado(notificado2);
		inmueble.addReserva(reserva1);
		inmueble.addReserva(reserva2);
		inmueble.cancelarReserva(reserva1, LocalDate.of(2024, 11, 30));
		verify(notificado1, times(1)).recibirCancelacion(inmueble);
		verify(notificado2, times(1)).recibirCancelacion(inmueble);
		inmueble.desuscribirNotificado(notificado2);
		inmueble.cancelarReserva(reserva2, LocalDate.of(2024, 11, 30));
		verify(notificado1, times(2)).recibirCancelacion(inmueble);
		verify(notificado2, times(1)).recibirCancelacion(inmueble);
	}
	
	@Test
	void testIsDisponible() {
		when(reserva1.getFechaInicio()).thenReturn(LocalDate.of(2024, 12, 1));
		when(reserva1.getFechaFin()).thenReturn(LocalDate.of(2024, 12, 5));
		when(reserva2.getFechaInicio()).thenReturn(LocalDate.of(2024, 12, 6));
		when(reserva2.getFechaFin()).thenReturn(LocalDate.of(2024, 12, 10));
		when(reserva3.getFechaInicio()).thenReturn(LocalDate.of(2024, 12, 11));
		when(reserva3.getFechaFin()).thenReturn(LocalDate.of(2024, 12, 15));
		inmueble.addReserva(reserva1);
		inmueble.addReserva(reserva2);
		inmueble.addReserva(reserva3);
		assertTrue(inmueble.isDisponible(LocalDate.of(2024, 12, 16), LocalDate.of(2024, 12, 20)));
		assertFalse(inmueble.isDisponible(LocalDate.of(2024, 12, 4), LocalDate.of(2024, 12, 10)));
	}
	@Test
	void tipoDeInmuebleTest() {
		when(tipoInmueble.getNombre()).thenReturn("Casa");	
		assertEquals(inmueble.getTipoInmueble().getNombre(), "Casa");
	}
	
	@Test
	void formaDePagoTest() {
		when(formaDePago.getNombre()).thenReturn("efectivo");
		assertEquals(inmueble.getFormaDePago().getNombre(), "efectivo");
	}
	

	
	@Test
	void informandoBajaDePrecioTest() {
		inmueble.setPrecio(1.2);
		assertEquals(inmueble.getPrecio(),1.2);
	}

}