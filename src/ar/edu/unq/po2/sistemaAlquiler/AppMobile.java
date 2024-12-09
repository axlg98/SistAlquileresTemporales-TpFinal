package ar.edu.unq.po2.sistemaAlquiler;

public class AppMobile implements Notificado {
	private PopUpWindow popUpWindow;

	@Override
	public void recibirCancelacion(Inmueble inmueble) {
		this.popUpWindow.popUp("El/la " + inmueble.getTipoInmueble() + " que te interesa se ha liberado! Corre a reservarlo!", "Rojo", 12);
	}

	@Override
	public void recibirReserva(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recibirBajaDePrecio(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

}
