package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.reserva.Reserva;




public class Intermedia implements IPoliticaCancelacion {


	@Override
	public Double costoDeCancelacion(Reserva reserva, LocalDate fechaCancelacion, Double precio) {
		
		LocalDate fechaLimiteDeCancelacion = reserva.getFechaInicio().minusDays(20);
		
		LocalDate fechaLimiteDeCancelacion50Porciento = reserva.getFechaInicio().minusDays(10);
		
		long totalDias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
		
		if(fechaCancelacionAntesDeFechaLimiteDe20Dias(fechaCancelacion, fechaLimiteDeCancelacion)) {
			// antes de los 20 dias 
			return precio * 0;
			
		} //entre dia 19 a 10 
		else if((fechaCancelacionDespuesDeFechaLimiteDe20Dias(fechaCancelacion, fechaLimiteDeCancelacion) || 
				fechaCancelacionEsElDia19(fechaCancelacion, fechaLimiteDeCancelacion)) 
				
				&&
	            (fechaCancelacionAntesDeFechaLimiteDe20Dias(fechaCancelacion, fechaLimiteDeCancelacion50Porciento) || 
	            fechaCancelacionEsDia10(fechaCancelacion, fechaLimiteDeCancelacion50Porciento))) {
			
			return (totalDias * precio) * 0.5;
			
		} 
		else { //desp del dia 10
			return totalDias * precio;
		}
		
	}

	private boolean fechaCancelacionEsDia10(LocalDate fechaCancelacion, LocalDate fechaLimiteDeCancelacion50Porciento) {
		return fechaCancelacion.isEqual(fechaLimiteDeCancelacion50Porciento);
	}

	private boolean fechaCancelacionEsElDia19(LocalDate fechaCancelacion, LocalDate fechaLimiteDeCancelacion) {
		return fechaCancelacion.isEqual(fechaLimiteDeCancelacion.plusDays(1));
	}

	private boolean fechaCancelacionDespuesDeFechaLimiteDe20Dias(LocalDate fechaCancelacion,
			LocalDate fechaLimiteDeCancelacion) {
		return fechaCancelacion.isAfter(fechaLimiteDeCancelacion);
	}

	private boolean fechaCancelacionAntesDeFechaLimiteDe20Dias(LocalDate fechaCancelacion,
			LocalDate fechaLimiteDeCancelacion) {
		return fechaCancelacion.isBefore(fechaLimiteDeCancelacion);
	}
	

	


	

	
}
