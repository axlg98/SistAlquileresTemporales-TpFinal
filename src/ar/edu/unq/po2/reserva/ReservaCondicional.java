package ar.edu.unq.po2.reserva;

public class ReservaCondicional implements EstadoReserva{

	@Override
	public void aceptarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaPendiente());
	}

	@Override
	public void cancelarReserva(Reserva reserva) {
		
		
	}


}
