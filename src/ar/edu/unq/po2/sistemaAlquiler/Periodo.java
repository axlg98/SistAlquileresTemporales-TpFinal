package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;

public abstract class Periodo {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Double ajustePrecio;
	
	public Periodo(LocalDate fecInicio, LocalDate fecFin, Double ajuste) {
		this.ajustePrecio = ajuste;
		this.fechaInicio = fecInicio;
		this.fechaFin = fecFin;
	}

	public Double getAjustePrecio() {
		return ajustePrecio;
	}

	
	
}
