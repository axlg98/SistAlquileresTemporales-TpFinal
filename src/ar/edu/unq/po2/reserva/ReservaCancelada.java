package ar.edu.unq.po2.reserva;

public class ReservaCancelada extends EstadoReserva{
	
	@Override
	public void aceptarReserva(Reserva reserva) {
		System.out.println("La reserva no se puede confirmar");
	}
	
	@Override
	public  void completarReserva(Reserva reserva) {
		System.out.println("No es posible completar la Reserva.");
	}
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		System.out.println(" La Reserva ya está cancelada.");
	}
	
	@Override
	public void solicitarEstadoReserva() {
		System.out.println("Estado reserva: Cancelada");
	}

}