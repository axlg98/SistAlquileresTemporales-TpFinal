package ar.edu.unq.po2.reserva;

public class ReservaAceptada extends EstadoReserva{
	
	@Override
	public boolean isConfirmada() {
		return true;
	}
	
	@Override
	public void aceptarReserva(Reserva reserva) {
		System.out.println("La reserva ya está Confirmada.");
	}
	
	@Override
	public  void completarReserva(Reserva reserva) {
		System.out.println("Reserva completada");
		reserva.setEstado(new ReservaCompletada());
	}
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		System.out.println(" reserva cancelada.");
		reserva.setEstado(new ReservaCancelada());
	}
	
	@Override
	public void solicitarEstadoReserva() {
		System.out.println("Estado reserva: Confirmada");
	}
}
