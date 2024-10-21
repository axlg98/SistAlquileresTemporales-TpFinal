package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.sistemaAlquiler.Inmueble;

public class Inquilino extends Usuario{

	public Inquilino(String nombreCompleto, String telefono, String mail) {
		super(nombreCompleto,telefono,mail);
	}
	
	//ARREGLAR PARA SELECCIONAR EL INMUEBLE DEL SAT
	
	public Inmueble seleccionarInmueble(Inmueble inmueble) {
		Inmueble inms = inmueble;
		return inms;
	}
	
	//ARREGLAR PARA BUSCAR ALQUILE DE LOS INMUEBLES DEL SAT

	public List<Inmueble> buscarAlquiler(String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida, int cantHuespuedes, Double minPrecio, Double maxPrecio){
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		return inmuebles;
	}
	
}
