package ar.edu.unq.po2.reserva;

import java.time.LocalDate;

public class Reserva {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstadoReserva estado;
	
	public Reserva(EstadoReserva estado,LocalDate fechaInicio, LocalDate fechaFin) {
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public void aceptarReserva() {
		System.out.println("Estado Actual: ");
		this.getEstado().aceptarReserva(this);
	}
	
	public void cancelarReserva() {
		System.out.println("Estado Actual: ");
		this.getEstado().cancelarReserva(this);
		System.out.println("Estado Actual: " + this.getEstado());
	}
	
	public void solicitarEstadoReserva() {
		this.getEstado().solicitarEstadoReserva();
	}
	
	//GETTER Y SETTER

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public EstadoReserva getEstado() { //Solamente para probar test temporal.
		return estado;
	}
	
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

}
