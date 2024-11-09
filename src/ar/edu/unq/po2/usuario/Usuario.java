package ar.edu.unq.po2.usuario;

import ar.edu.unq.po2.reserva.Reserva;

public class Usuario implements Propietario{
	
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
	
}
