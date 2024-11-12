package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public interface Inquilino {
	
	
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<Inmueble> buscarAlquiler(	SAT sat, String ciudad, 
											LocalDate fechaEntrada, LocalDate fechaSalida,
											int cantHuespuedes, Double minPrecio, Double maxPrecio);
	
	public void rankearInmueble(Inmueble inmueble, Ranking ranking);
	
	public void rankearPropietario(Inmueble inmueble, Ranking ranking);
	
}
