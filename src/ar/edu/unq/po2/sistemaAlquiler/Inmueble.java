package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Propietario;
import ar.edu.unq.po2.usuario.Ranking;
import ar.edu.unq.po2.usuario.Usuario;

public class Inmueble implements IRankeable, Notificador {
	
	private Usuario				propietario;
	private TipoInmueble 	  	tipoInmueble;
	private Double 		 	  	superficie;
	private String 		 	  	pais;
	private String 		 	  	ciudad;
	private String 		 	  	direccion;
	private int 		 	  	capacidad;
	private LocalTime 	 	  	checkIn;
	private LocalTime 	 	  	checkOut;
	private Double 		 	  	precio;
	private IPoliticaCancelacion politicaCancelacion;
	private Set<Servicio> 	  	servicios;
	private Set<String> 	  	fotos;
	private FormaDePago	  		formaDePago;
	
	private Set<Reserva>	  	reservas;
	private Set<Ranking>		rankeos;
	private Set<Periodo> 		periodos;
	private Set<Notificado>		notificados;
	
	public Inmueble(Usuario propietario, TipoInmueble tipoInmueble, Double superficie, String pais, String ciudad, String direccion, int capacidad, LocalTime checkIn, 
					LocalTime checkOut, Double precio, IPoliticaCancelacion politicaCancelacion, Set<Servicio> servicios, Set<String> fotos, FormaDePago formasDePago) {
		this.propietario		 = propietario;
		this.tipoInmueble 		 = tipoInmueble;
		this.superficie   		 = superficie;
		this.pais 		  		 = pais;
		this.ciudad 	  		 = ciudad;
		this.direccion 	  		 = direccion;
		this.capacidad 	  		 = capacidad;
		this.checkIn 	  		 = checkIn;
		this.checkOut 	  		 = checkOut;
		this.precio 	  		 = precio;
		this.servicios 	  		 = servicios;
		this.fotos 		  		 = fotos;
		this.formaDePago 		 = formasDePago;
		this.politicaCancelacion = politicaCancelacion;
		
		this.reservas	  = new HashSet<Reserva>();
		this.rankeos	  = new HashSet<Ranking>();
		this.periodos 	  = new HashSet<Periodo>();
		this.notificados  = new HashSet<Notificado>();
	}
	public void setPoliticaCancelacion(IPoliticaCancelacion p ) {
		this.politicaCancelacion = p; 
	}
	public void agregarPeriodo(Periodo periodo) {
		this.periodos.add(periodo);
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public List<Periodo> getPeriodos() {
		return this.periodos.stream().collect(Collectors.toList());
	}
	
	public Double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		 Double precioTotal = 0.0;

	        // Itera cada dia del rango de búsqueda
		 
	        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
	            Double precioDia = this.precio;

	            // se ajusta el precio si las fechas dadas son de algún periodo en especial asignado en inmueble
	            
	            for (Periodo periodo : this.getPeriodos()) {
	                if (!fecha.isBefore(periodo.getFechaInicio()) && !fecha.isAfter(periodo.getFechaFin())) {
	                    precioDia *= periodo.getAjustePrecio();
	                }
	            }

	           
	            precioTotal += precioDia;
	        }

	        return precioTotal;
	    }
	
	public Usuario getPropietario() {
		return this.propietario;
	}
	
	public TipoInmueble getTipoInmueble() {
		return this.tipoInmueble;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}

	public int getCapacidad() {
		return this.capacidad;
	}
	
	public List<Servicio> getServicios() {
		return servicios.stream().collect(Collectors.toList());
	}
	
	public List<String> getFotos() {
		return fotos.stream().collect(Collectors.toList());
	}
	
	public FormaDePago getFormaDePago() {
		return this.formaDePago;
	}
	
	
	
	public List<Reserva> getReservas() {
		return reservas.stream().collect(Collectors.toList());
	}
	
	public List<Ranking> getRankeos() {
		return rankeos.stream().collect(Collectors.toList());
	}

	public void setPrecio(Double precio) {
		if (precio < this.precio) {
			this.informarBajaDePrecio(this);
		}
		this.precio = precio;
	}
	
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public void addFoto(String foto) {
		this.fotos.add(foto);
	}

	
	
	
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void addRankeo(Ranking rankeo) {
		this.rankeos.add(rankeo);
	}

	
	
	
	
	public void cancelarReserva(Reserva reserva, LocalDate fechaCancelacion) {
		if (this.getReservas().contains(reserva)) {
			
			this.costoPorCancelacion(reserva, fechaCancelacion);

			this.informarCancelacion(this);
		}
	}
	public void costoPorCancelacion(Reserva r, LocalDate fechaCancelacion) {
		
			Double costo = this.politicaCancelacion.costoDeCancelacion(r, fechaCancelacion, this.getPrecio());
			this.getFormaDePago().pagar(costo);
			r.cancelarReserva();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Double getPromedioGeneral() {
		return this.getRankeos().stream().mapToInt(ranking -> ranking.getPuntaje()).average().getAsDouble();
	}

	@Override
	public Double getPromedioCategoria(CategoriaRankeo categoriaRankeo) {
		return this.getRankeos().stream().filter(ranking -> ranking.getCategoria().equals(categoriaRankeo)).mapToInt(ranking -> ranking.getPuntaje()).average().getAsDouble();
	}
	
	public Boolean isDisponible(LocalDate fechaEntrada, LocalDate fechaSalida) {
		return this.getReservas().stream().allMatch(reserva -> this.periodoANotInPeriodoB(fechaEntrada, fechaSalida, reserva.getFechaInicio(), reserva.getFechaFin()));
	}
	
	private Boolean periodoANotInPeriodoB(LocalDate inicioA, LocalDate finA, LocalDate inicioB, LocalDate finB) {
		return (finA.isBefore(inicioB) || inicioA.isAfter(finB));
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Notificado> getNotificados() {
		return notificados.stream().collect(Collectors.toList());
	}

	@Override
	public void suscribirNotificado(Notificado notificado) {
		this.notificados.add(notificado);
	}
	
	@Override
	public void desuscribirNotificado(Notificado notificado) {
		this.notificados.remove(notificado);
	}

	@Override
	public void informarCancelacion(Inmueble inmueble) {
		this.getNotificados().stream().forEach(notificado -> notificado.recibirCancelacion(inmueble));
		
	}
	
	@Override
	public void informarReserva(Inmueble inmueble) {
		this.getNotificados().stream().forEach(notificado -> notificado.recibirReserva(inmueble));
	}
	
	@Override
	public void informarBajaDePrecio(Inmueble inmueble) {
		this.getNotificados().stream().forEach(notificado -> notificado.recibirBajaDePrecio(inmueble));
	}

}

