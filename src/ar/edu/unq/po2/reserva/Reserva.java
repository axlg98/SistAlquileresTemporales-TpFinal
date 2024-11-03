package ar.edu.unq.po2.reserva;

public class Reserva {

	private EstadoReserva estado;
	
	public Reserva(EstadoReserva estado) {
		this.estado = estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	public void aceptarReserva() {
		estado.aceptarReserva(this);
	}
	
	public void cancelarReserva() {
		estado.cancelarReserva(this);
	}
	
	public void solicitarEstadoReserva() {
		estado.solicitarEstadoReserva();
	}
	

}
