package ar.edu.unq.po2.sistemaAlquiler;

	public SAT() {
		inmuebles = new ArrayList<Inmueble>();
		usuarios = new ArrayList<Usuario>();
	}
	
	public List<Inmueble> busquedaDelInquilino(Usuario usuario,String ciudad, LocalDate fechaEntrada,LocalDate fechaSalida,int cantHuespuedes, Double minPrecio, Double maxPrecio){
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		
		if(this.usuarioPerteneceAlSAT(usuario)) {
			
		}
		
		return inmuebles;
	}

	public boolean usuarioPerteneceAlSAT(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.usuarios.contains(usuario);
	}
	
}
