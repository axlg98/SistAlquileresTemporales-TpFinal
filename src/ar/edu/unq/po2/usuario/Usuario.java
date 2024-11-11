package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public class Usuario implements Propietario, Inquilino{
	
	private String nombreCompleto;
	private String telefono;
	private String mail;

	public Usuario(String nombreCompleto, String telefono, String mail) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	//Métodos para el Propietario
	
	//FALTA AGREGAR MÉTODOS.
	
	@Override
	public void aceptarReservaInquilino(Reserva reserva) { //Ver esto como arreglarlo
		if(reserva.isConfirmada()) {
			System.out.println("La Reserva ya fue aceptada previamente.");
		}else {
			reserva.aceptarReserva();
			System.out.println("La Reserva fue aceptada correctamente.");
		}
	}

	
	
	
	// Inquilino
	@Override
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
		Reserva reserva = new Reserva(fechaInicio, fechaFin, this);
		inmueble.addReserva(reserva);
		
	}

	@Override
	public List<Inmueble> buscarAlquiler(SAT sat, String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida,
			int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		return sat.busquedaDelInquilino(this, ciudad, fechaEntrada, fechaSalida, cantHuespuedes, minPrecio,maxPrecio);
	}

	@Override
	public void cancelarReserva(Reserva reserva) {
		reserva.cancelarReserva();
		
	}
	
	
	
	
	
	
}
