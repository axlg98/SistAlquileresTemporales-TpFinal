package ar.edu.unq.po2.reserva;

public class ReservaPendiente implements EstadoReserva{
	
	@Override
	public void aceptarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaAceptada());
	}
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaCancelada());
	}


}