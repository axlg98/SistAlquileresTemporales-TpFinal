package ar.edu.unq.po2.sistemaAlquiler;

import java.util.List;

public interface Notificador {
	public List<Notificado> getNotificados();
	public void suscribirNotificado(Notificado notificado);
	public void desuscribirNotificado(Notificado notificado);
	public void informarCancelacion(Inmueble inmueble);
	public void informarReserva(Inmueble inmueble);
	public void informarBajaDePrecio(Inmueble inmueble);
}
