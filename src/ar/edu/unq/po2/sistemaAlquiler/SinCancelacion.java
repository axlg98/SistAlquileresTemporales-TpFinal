package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.reserva.Reserva;




public class SinCancelacion implements IPoliticaCancelacion {

	@Override
	public Double costoDeCancelacion(Reserva reserva, LocalDate fechaCancelacion, Double precio) {
		
		// cuantos dias hay dentro del rango de fechas
		
		long totalDias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
		
		return totalDias * precio;
	}

	



	
	
}
