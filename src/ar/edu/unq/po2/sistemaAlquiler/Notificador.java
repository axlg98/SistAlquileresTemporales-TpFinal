package ar.edu.unq.po2.sistemaAlquiler;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
	
	private List<Notificado> notificados;
	
	public Notificador() {
		this.notificados = new ArrayList<Notificado>();
	}
	
	public List<Notificado> getNotificados() {
		return notificados;
	}

	public void suscribirNotificado(Notificado notificado) {
		this.getNotificados().add(notificado);
	}
	
	public void desuscribirNotificado(Notificado notificado) {
		this.getNotificados().remove(notificado);
	}
	
	public void informarNotificados() {
		this.getNotificados().stream().forEach(notificado -> notificado.informar());
	}

}
