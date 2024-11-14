package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public class Usuario implements Propietario, Inquilino{
	
	private String nombreCompleto;
	private String telefono;
	private String mail;
	private List<Ranking> rankings;

	public Usuario(String nombreCompleto, String telefono, String mail) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.mail = mail;
		this.rankings = new ArrayList<Ranking>();
	}
	
	public void addRanking(Ranking ranking) {
		rankings.add(ranking);
	}

	
	
	//Rankeo
	
	public void rankearInquilino(int puntaje, Inmueble inmueble,String comentario) {
		if (puntaje >= 1 && puntaje <= 5) {
			CategoriaRankeo categoria = new CategoriaRankeo("Inquilino", null);
			Ranking nuevoRanking = new Ranking(puntaje,categoria,comentario);
			inmueble.getRankeos().add(nuevoRanking);
			this.getRankings().add(nuevoRanking);
		}

	}
	
	public void rankearPropietario(int puntaje, Inmueble inmueble,String comentario) {
		if ( puntaje >= 1 && puntaje <= 5) {
			CategoriaRankeo categoria = new CategoriaRankeo("Propietario", null);
			Ranking nuevoRanking = new Ranking(puntaje,categoria,comentario);
			inmueble.getRankeos().add(nuevoRanking);
			this.getRankings().add(nuevoRanking);
		}
		
	}
	
	public void rankearInmueble(int puntaje, Inmueble inmueble,String comentario) {
		if ( puntaje >= 1 && puntaje <= 5) {
			CategoriaRankeo categoria = new CategoriaRankeo("Inmueble", null);
			Ranking nuevoRanking = new Ranking(puntaje,categoria,comentario);
			inmueble.getRankeos().add(nuevoRanking);
			this.getRankings().add(nuevoRanking);
		}
	}
	
	
	//Métodos para el Propietario
	
	//FALTA AGREGAR MÉTODOS.
	
	@Override
	public void aceptarReservaInquilino(Reserva reserva) { //Ver esto como arreglarlo
		if(reserva.isConfirmada()) {
			System.out.println("La Reserva ya fue aceptada previamente.");
		}else {
			reserva.aceptarReserva();
			System.out.println("La Reserva fue aceptada correctamente.");
		}
	}


	
	// Inquilino
	@Override
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
		Reserva reserva = new Reserva(fechaInicio, fechaFin, this);
		inmueble.addReserva(reserva);
		
	}

	@Override
	public List<Inmueble> buscarAlquiler(SAT sat, String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida,
			int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		return sat.busquedaDelInquilino(ciudad, fechaEntrada, fechaSalida, cantHuespuedes, minPrecio,maxPrecio);
	}

	
	
	//GET 
	
	public List<Ranking> getRankings() {
		return rankings;
	}
	

	@Override
	public void rankearInmueble(Inmueble inmueble, Ranking ranking) {
		inmueble.addRankeo(ranking);
	}

	@Override
	public void rankearPropietario(Inmueble inmueble, Ranking ranking) {
		inmueble.getPropietario().addRanking(ranking);
	}

	@Override
	public void rankearInquilino(Usuario inquilino, Ranking ranking) {
		inquilino.addRanking(ranking);
	}
	
	
}
