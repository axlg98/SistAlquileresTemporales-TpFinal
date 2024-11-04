package ar.edu.unq.po2.reserva;

public class ReservaCompletada extends EstadoReserva{
	
	@Override
	public void aceptarReserva(Reserva reserva) {
		System.out.println("La reserva no se puede confirmar");
	}
	
	@Override
	public  void completarReserva(Reserva reserva) {
		System.out.println("La Reserva ya fue completada.");
	}
	
	@Override
	public void cancelarReserva(Reserva reserva) {
		System.out.println(" La Reserva no se puede cancelar.");
	}
	
	@Override
	public void solicitarEstadoReserva() {
		System.out.println("Estado reserva: Completada");
	}
}