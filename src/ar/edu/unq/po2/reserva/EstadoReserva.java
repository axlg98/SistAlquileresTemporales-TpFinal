package ar.edu.unq.po2.reserva;

public interface EstadoReserva {
	public void aceptarReserva(Reserva reserva);
	public void cancelarReserva(Reserva reserva);
	//public void completarReserva(Reserva reserva);
	public void solicitarEstadoReserva();
}
