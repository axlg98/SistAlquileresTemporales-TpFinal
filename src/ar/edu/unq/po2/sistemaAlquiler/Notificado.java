package ar.edu.unq.po2.sistemaAlquiler;

public interface Notificado {
	void recibirCancelacion(Inmueble inmueble);
	void recibirReserva(Inmueble inmueble);
	void recibirBajaDePrecio(Inmueble inmueble);
}
