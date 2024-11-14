package ar.edu.unq.po2.reserva;

public interface EstadoReserva {
	public abstract void aceptarReserva(Reserva reserva);
	public abstract void cancelarReserva(Reserva reserva);
	public abstract void solicitarEstadoReserva();
}
