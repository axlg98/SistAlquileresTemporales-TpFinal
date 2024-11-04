package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;

import ar.edu.unq.po2.reserva.Reserva;



public class CancelacionGratuita implements IPoliticaCancelacion{

	@Override
	public Double costoDeCancelacion(Reserva reserva, LocalDate fechaCancelacion, Double precio) {
		
		// fechaInicio es la fecha que comienza el alquiler
		// se le resta 10 días como fecha limite para cancelarlo
		
		LocalDate fechaLimiteDeCancelacion = reserva.getFechaInicio().minusDays(10);
		
		if(fechaCancelacion.isBefore(fechaLimiteDeCancelacion) || fechaCancelacion.isEqual(fechaLimiteDeCancelacion)) {
			
			return precio * 0;
			
		} 
		else {
			
			// abona el precio de dos días de alquiler por haber pasado la fecha limite
			
			return precio * 2;
			
		}
	}

	

	

	

	

	

	
}
