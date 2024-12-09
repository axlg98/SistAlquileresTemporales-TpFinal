package ar.edu.unq.po2.sistemaAlquiler;

public class TipoTrivago implements Notificado {
	private HomePagePublisher homePagePublisher;

	@Override
	public void recibirCancelacion(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recibirReserva(Inmueble inmueble) {
		this.homePagePublisher.publish("Mensaje");

	}

	@Override
	public void recibirBajaDePrecio(Inmueble inmueble) {
		this.homePagePublisher.publish("Un inmueble " + inmueble.getTipoInmueble() + " a tan sólo " + inmueble.getPrecio() + " pesos."); 
	}

}
