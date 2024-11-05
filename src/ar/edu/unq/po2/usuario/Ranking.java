package ar.edu.unq.po2.usuario;

import ar.edu.unq.po2.sistemaAlquiler.CategoriaRankeo;

public class Ranking {

	private int 			puntaje;
	private CategoriaRankeo categoria;
	private String 			comentario;
	
	public Ranking(int puntaje, CategoriaRankeo categoria, String comentario) {
		this.puntaje 	= puntaje;
		this.categoria 	= categoria;
		this.comentario = comentario;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	public CategoriaRankeo getCategoria() {
		return categoria;
	}
	public String getComentarios() {
		return comentario;
	}

}