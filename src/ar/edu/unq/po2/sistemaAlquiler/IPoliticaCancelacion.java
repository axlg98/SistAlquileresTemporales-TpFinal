package ar.edu.unq.po2.sistemaAlquiler;


import java.time.LocalDate;

import ar.edu.unq.po2.reserva.Reserva;





public interface IPoliticaCancelacion {
	public Double costoDeCancelacion(Reserva reserva, LocalDate fechaCancelacion, Double precio);

	
}
