package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.IRankeable;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public class Usuario implements Propietario, Inquilino, IRankeable {
	
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

	
	//Métodos para el Propietario
	
	
	@Override
	public void aceptarReservaInquilino(Reserva reserva) { 
			reserva.aceptarReserva();

	}

	@Override
	public void rankearInquilino(Usuario inquilino, Ranking ranking) {
		if (ranking.getPuntaje()>=1 && ranking.getPuntaje()<=5) {
			inquilino.addRanking(ranking);
		}
	}
	
	// Inquilino
	@Override
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
		Reserva reserva = new Reserva(fechaInicio, fechaFin, this);
		inmueble.addReserva(reserva);
		inmueble.informarReserva(inmueble);
	}

	@Override
	public List<Inmueble> buscarAlquiler(SAT sat, String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida,
			int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		return sat.busquedaDelInquilino(ciudad, fechaEntrada, fechaSalida, cantHuespuedes, minPrecio,maxPrecio);
	}

	@Override
	public void rankearInmueble(Inmueble inmueble, Ranking ranking) {
		if (ranking.getPuntaje()>=1 && ranking.getPuntaje()<=5) {
			inmueble.addRankeo(ranking);
		}	
	}
	
	@Override
	public void rankearPropietario(Usuario propietario, Ranking ranking) {
		if (ranking.getPuntaje()>=1 && ranking.getPuntaje()<=5) {
			propietario.addRanking(ranking);
		}	
	}
	
	
	//GET 
	
	public List<Ranking> getRankings() {
		return rankings;
	}

	@Override
	public Double getPromedioGeneral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPromedioCategoria(CategoriaRankeo categoriaRankeo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
