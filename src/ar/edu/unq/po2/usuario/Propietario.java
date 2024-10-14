package ar.edu.unq.po2.usuario;
import ar.edu.unq.po2.sistemaAlquiler.*;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario{
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	public Propietario(String nombreCompleto, String telefono, String mail) {
		super(nombreCompleto,telefono,mail);
	}
	

}
