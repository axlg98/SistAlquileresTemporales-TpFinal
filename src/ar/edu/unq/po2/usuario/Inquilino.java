package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.IRankeable;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public interface Inquilino {
	
	
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<Inmueble> buscarAlquiler(	SAT sat, String ciudad, 
											LocalDate fechaEntrada, LocalDate fechaSalida,
											int cantHuespuedes, Double minPrecio, Double maxPrecio);
	
}
