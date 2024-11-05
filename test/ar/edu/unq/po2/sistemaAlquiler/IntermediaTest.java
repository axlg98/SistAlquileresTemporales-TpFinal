package ar.edu.unq.po2.sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.reserva.Reserva;

class IntermediaTest {
	private Intermedia cancelacionIntermedia;
	private Reserva reserva;
	@BeforeEach
	void setUp() throws Exception {
		cancelacionIntermedia = new Intermedia();
		reserva = mock(Reserva.class);
		when(reserva.getFechaInicio()).thenReturn(LocalDate.of(2024,11, 21));
		when(reserva.getFechaFin()).thenReturn(LocalDate.of(2024,11, 30));
	}
	
	@Test
	void sinCostoPorCancelarConMasDe20DiasAntes() {
		
		assertEquals(0, cancelacionIntermedia.costoDeCancelacion(reserva, LocalDate.of(2024, 10,31), 100.0));
	}
	@Test
	void sinCostoPorCancelarConDia20AntesDelInicioReserva() {
		
		assertEquals(0, cancelacionIntermedia.costoDeCancelacion(reserva, LocalDate.of(2024, 11, 1), 100.0));
	}
	@Test
	void costoPorCancelarDel50PorcientoDia19AntesDeInicioReserva() {
		
		assertEquals(450, cancelacionIntermedia.costoDeCancelacion(reserva, LocalDate.of(2024, 11, 2), 100.0));
	}
	@Test
	void costoPorCancelarDel50PorcientoDia10AntesDeInicioReserva() {
		
		assertEquals(450, cancelacionIntermedia.costoDeCancelacion(reserva, LocalDate.of(2024, 11, 11), 100.0));
	}
	@Test
	void costoTotalPorCancelarAntesDeInicioReservaCon9DiasAntes() {
		
		assertEquals(900, cancelacionIntermedia.costoDeCancelacion(reserva, LocalDate.of(2024, 11, 12), 100.0));
	}
}
