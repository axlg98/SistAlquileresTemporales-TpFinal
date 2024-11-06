package ar.edu.unq.po2.usuario;
import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.*;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario{
	private List<Inmueble> inmuebles;
	
	public Propietario(String nombreCompleto, String telefono, String mail) {
		super(nombreCompleto,telefono,mail);
		inmuebles = new ArrayList<Inmueble>();
	}
	
	//Aceptar la Reserva de un Inquilino
	
	public void aceptarReservaInquilino(Reserva reserva) {
		if(!reserva.isConfirmada()) {
			reserva.aceptarReserva();
			System.out.println("La Reserva fue aceptada correctamente.");
		}else {
			System.out.println("La Reserva ya fue aceptada previamente.");
		}
	}
	
	//Rechazar la Reserva de un Inquilino
	
	public void cancelarReservaInquilino(Reserva reserva) {
		if(reserva.isConfirmada()) {
			reserva.cancelarReserva();
			System.out.println("La Reserva fue cancelada correctamente.");
		}else {
			System.out.println("La Reserva ya fue cancelada previamente.");
		}
	}
	
	//Verificar las Reservas Aceptadas.
	
	public List<Reserva> todasLasReservasAceptadas(){
		List<Reserva> reservasAceptadas = new ArrayList<Reserva>();
		for(Inmueble inmueble : this.getInmuebles()) {
			reservasAceptadas.addAll(this.reservasAceptadasDelInmuebleSiCorresponde(inmueble));
		}
		return reservasAceptadas;
	}
	
	public List<Reserva> reservasAceptadasDelInmuebleSiCorresponde(Inmueble inmueble){
		return inmueble.getReservas().stream().filter(r -> r.isConfirmada()).toList();
		
	}
	
	//Agregar y eliminar un inmueble. 
	
	public void addInmueble(Inmueble inmueble) {
		inmuebles.add(inmueble);
	}
	
	public void eliminarInmueble(Inmueble inmueble) {
		if(this.getInmuebles().contains(inmueble)) {
			inmuebles.remove(inmueble);
		}
	}
	
	//Get

	public List<Inmueble> getInmuebles(){
		return inmuebles;
	}

}
