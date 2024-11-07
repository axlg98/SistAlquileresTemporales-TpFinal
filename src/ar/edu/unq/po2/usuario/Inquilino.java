package ar.edu.unq.po2.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;
import ar.edu.unq.po2.sistemaAlquiler.IRankeable;
import ar.edu.unq.po2.sistemaAlquiler.Inmueble;
import ar.edu.unq.po2.sistemaAlquiler.SAT;

public class Inquilino extends Usuario implements IRankeable{
	
	private List<Ranking> rankeos;
	
	
	public Inquilino(String nombreCompleto, String telefono, String mail) {
		
		super(nombreCompleto,telefono,mail);
		this.rankeos = new ArrayList<Ranking>();
		
	}
	
	
	
	public void reservarInmueble(Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
		// damos por hecho que se le pasa un inmueblo para la posible reserva
			Reserva reserva = new Reserva(fechaInicio, fechaFin);
			inmueble.addReserva(reserva);				
		
	}
	
	public List<Inmueble> buscarAlquiler(
											SAT sat, String ciudad, 
											LocalDate fechaEntrada, LocalDate fechaSalida,
											int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		return sat.busquedaDelInquilino(this, ciudad, fechaEntrada, fechaSalida, cantHuespuedes, minPrecio, maxPrecio);
	}
	
	
	
	public List<Ranking> getRankeos() {
		return rankeos;
	}
	public void addRankeo(Ranking rankeo) {
		this.getRankeos().add(rankeo);
	}
	@Override
	public Double getPromedioGeneral() {
		// TODO Auto-generated method stub
		return this.getRankeos().stream().mapToInt(ranking -> ranking.getPuntaje()).average().getAsDouble();
	}

	@Override
	public Double getPromedioCategoria(CategoriaRankeo categoriaRankeo) {
		// TODO Auto-generated method stub
		return this.getRankeos()
				.stream()
				.filter(ranking -> ranking.getCategoria().equals(categoriaRankeo))
					.mapToInt(ranking -> ranking.getPuntaje()).average().getAsDouble();
	}
	
}
