package ar.edu.unq.po2.reserva;

public class ReservaPendiente extends EstadoReserva{
	
	@Override
	public void aceptarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaAceptada());
		System.out.println("La reserva fue Confirmada.");
	}
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		reserva.setEstado(new ReservaCancelada());
		System.out.println(" reserva cancelada.");
	}
	
	@Override
	public void solicitarEstadoReserva() {
		System.out.println("Estado reserva: Pendiente");
	}

	
}