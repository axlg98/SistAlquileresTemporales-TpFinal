package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalTime;
import java.util.List;

public class Inmueble {
	
	private String tipoInmueble;
	private String pais;
	private Double superficie;
	private String ciudad;
	private String direccion;
	private LocalTime checkIn;
	private LocalTime checkOut;
	private List<String> formasDePago;
	private List<String> fotos;
	
	public Inmueble(String tipoInmueble, String pais, Double superficie, String ciudad, String direccion,
			LocalTime checkIn, LocalTime checkOut) {
		this.tipoInmueble = tipoInmueble;
		this.pais = pais;
		this.superficie = superficie;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public void addFormaDePago(String formaDePago) {
		this.formasDePago.add(formaDePago);
	}
	
	public void addFoto(String foto) {
		if(this.getFotos().size() > 5) {
			System.out.println("Se alcanzó el máximo permitido de fotos.");
		}else {
			this.getFotos().add(foto);
		}
	}

	public List<String> getFotos() {
		return fotos;
	}
	
	
	
}
