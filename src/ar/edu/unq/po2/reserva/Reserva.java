package ar.edu.unq.po2.reserva;

import java.time.LocalDate;

import ar.edu.unq.po2.usuario.Inquilino;

public class Reserva {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstadoReserva estado;
	private Inquilino inquilino;
	
	public Reserva(LocalDate fechaInicio, LocalDate fechaFin,Inquilino inquilino) {
		this.estado = new ReservaPendiente();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.inquilino = inquilino;
	}
	
	//Confirma si la reserva es aceptada.
	
	public boolean isConfirmada() {
		return this.getEstado().isConfirmada();
	}
	
	//Parte del State

	public void aceptarReserva() {
		this.getEstado().aceptarReserva(this);
	}
	
	public void cancelarReserva() {
		this.getEstado().cancelarReserva(this);
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
		return this.estado;
	}
	
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

}
