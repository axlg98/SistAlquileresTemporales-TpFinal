package ar.edu.unq.po2.reserva;

public abstract class EstadoReserva {
	public abstract void aceptarReserva(Reserva reserva);
	public abstract void cancelarReserva(Reserva reserva);
	//public void completarReserva(Reserva reserva);
	public abstract void solicitarEstadoReserva();
}
