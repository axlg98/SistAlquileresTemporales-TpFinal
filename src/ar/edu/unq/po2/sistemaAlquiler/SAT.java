package ar.edu.unq.po2.sistemaAlquiler;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.usuario.Inquilino;
import ar.edu.unq.po2.usuario.Usuario;

public class SAT {
	
	private List<Inmueble> inmuebles;
	private List<Usuario> usuarios;	

	public SAT() {
		inmuebles = new ArrayList<Inmueble>();
		usuarios = new ArrayList<Usuario>();
	}
	
	public List<Inmueble> busquedaDelInquilino(Inquilino inquilino){
		return null;
	}
	
}
