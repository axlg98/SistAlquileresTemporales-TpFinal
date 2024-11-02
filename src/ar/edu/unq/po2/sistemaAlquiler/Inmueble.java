package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Inmueble implements IRankeable	{
	
	private TipoInmueble 	  	tipoInmueble;
	private Double 		 	  	superficie;
	private String 		 	  	pais;
	private String 		 	  	ciudad;
	private String 		 	  	direccion;
	private int 		 	  	capacidad;
	private LocalTime 	 	  	checkIn;
	private LocalTime 	 	  	checkOut;
	private Double 		 	  	precio;
	private PoliticaCancelacion politicaCancelacion;
	private List<Servicio> 	  	servicios;
	private List<String> 	  	fotos;
	private List<FormaDePago> 	formasDePago;
	private List<Alquiler>	  	alquileres;
	private List<Reserva>	  	reservas;
	private List<Ranking>		rankeos;
	
	
	public Inmueble(TipoInmueble tipoInmueble, Double superficie, String pais, String ciudad, String direccion, int capacidad, LocalTime checkIn, LocalTime checkOut,
					Double precio, PoliticaCancelacion politicaCancelacion, List<Servicio> servicios, List<String> fotos, List<FormaDePago> formasDePago) {
		this.tipoInmueble 		 = tipoInmueble;
		this.superficie   		 = superficie;
		this.pais 		  		 = pais;
		this.ciudad 	  		 = ciudad;
		this.direccion 	  		 = direccion;
		this.capacidad 	  		 = capacidad;
		this.checkIn 	  		 = checkIn;
		this.checkOut 	  		 = checkOut;
		this.precio 	  		 = precio;
		this.servicios 	  		 = servicios;
		this.fotos 		  		 = fotos;
		this.formasDePago 		 = formasDePago;
		this.politicaCancelacion = politicaCancelacion;
		this.alquileres	  = new ArrayList<Alquiler>();
		this.reservas	  = new ArrayList<Reserva>();
		this.rankeos	  = new ArrayList<Ranking>();
		
	}
	
	public List<Servicio> getServicios() {
		return servicios;
	}
	
	public List<String> getFotos() {
		return fotos;
	}
	
	public List<FormaDePago> getFormasDePago() {
		return formasDePago;
	}
	
	public List<Alquiler> getAlquileres() {
		return alquileres;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public List<Ranking> getRankeos() {
		return rankeos;
	}

	public void addServicio(Servicio servicio) {
		if (this.getServicios().contains(servicio)) {
			System.out.println("El servicio ya existe.");
		} else {
			this.getServicios().add(servicio);
		}
	}
	
	public void addFoto(String foto) {
		if (this.getFotos().size() >= 5) {
			System.out.println("Se alcanzó el máximo permitido de fotos.");
		} else {
			this.getFotos().add(foto);
		}
	}

	public void addFormaDePago(FormaDePago formaDePago) {
		if (this.getFormasDePago().contains(formaDePago)) {
			System.out.println("La forma de pago ya existe.");
		} else {
			this.getFormasDePago().add(formaDePago);
		}
	}
	
	public void addAlquiler(Alquiler alquiler) {
		if (this.getAlquileres().contains(alquiler)) {
			System.out.println("Ese alquiler ya existe.");
		} else {
			this.getAlquileres().add(alquiler);
		}
	}
	
	public void addReserva(Reserva reserva) {
		if (this.getReservas().contains(reserva)) {
			System.out.println("Esa reserva ya existe.");
		} else {
			this.getReservas().add(reserva);
		}
	}
	
	public void addRankeo(Ranking rankeo) {
			this.getRankeos().add(rankeo);
	}	
	
}