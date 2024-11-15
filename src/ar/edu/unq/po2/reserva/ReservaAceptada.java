package ar.edu.unq.po2.reserva;

public class ReservaAceptada implements EstadoReserva{
	

	
	@Override
	public void aceptarReserva(Reserva reserva) {
		
	}
	
	
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaCancelada());
	}
	
}
