package ar.edu.unq.po2.sistemaAlquiler;

public class FormaDePago {
	
	private String nombre;
	
	public FormaDePago(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public Double pagar(Double monto) {
		// al no especificar cómo pagar, dejamos que retorne solamente el monto.
		
		return monto;
	}
}
