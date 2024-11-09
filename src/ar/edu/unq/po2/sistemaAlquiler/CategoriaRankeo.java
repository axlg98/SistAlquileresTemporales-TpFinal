package ar.edu.unq.po2.sistemaAlquiler;

public class CategoriaRankeo {
	
	private String 	   nombre;
	private IRankeable entidad;
	
	public CategoriaRankeo(String nombre, IRankeable entidad) {
		this.nombre  = nombre;
		this.entidad = entidad;
	}

	public String getNombre() {
		return nombre;
	}

	public IRankeable getEntidad() {
		return entidad;
	}
	
}
