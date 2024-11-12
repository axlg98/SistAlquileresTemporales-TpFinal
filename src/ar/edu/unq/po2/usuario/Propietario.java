package ar.edu.unq.po2.usuario;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;

public interface  Propietario{
	
	public void aceptarReservaInquilino(Reserva reserva);
	//public List<Inmueble> obtenerInmuebles();
	//public void rankearInquilino(Inquilino inquilino, int puntaje);
	public void rankearInquilino(Usuario inquilino, Ranking ranking);
	

}
