package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Inquilino;
import ar.edu.unq.po2.usuario.Usuario;

public class SAT {
	
	private List<Usuario> 		  usuarios;
	private List<Inmueble> 		  inmuebles;
	private List<TipoInmueble> 	  tiposInmueble;
	private List<Servicio> 		  servicios;
	private List<FormaDePago>	  formasDePago;
	private List<CategoriaRankeo> categoriasRankeo;

	public SAT() {
		this.usuarios 		  = new ArrayList<Usuario>();
		this.inmuebles 		  = new ArrayList<Inmueble>();
		this.tiposInmueble 	  = new ArrayList<TipoInmueble>();
		this.servicios 		  = new ArrayList<Servicio>();
		this.formasDePago 	  = new ArrayList<FormaDePago>();
		this.categoriasRankeo = new ArrayList<CategoriaRankeo>();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public List<TipoInmueble> getTiposInmueble() {
		return tiposInmueble;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public List<FormaDePago> getFormasDePago() {
		return formasDePago;
	}

	public List<CategoriaRankeo> getCategoriasRankeo() {
		return categoriasRankeo;
	}

	public void altaUsuario(Usuario usuario) {
		if (this.getUsuarios().contains(usuario)) {
			System.out.println("El usuario ya existe en el sistema.");
		} else {
			this.getUsuarios().add(usuario);
		}
	}
	
	public void altaInmueble(Inmueble inmueble ) {
		if (this.getInmuebles().contains(inmueble)) {
			System.out.println("El inmueble ya existe en el sistema.");
		} else {
			this.getInmuebles().add(inmueble);
		}
	}
	
	public void altaTipoInmueble(TipoInmueble tipoInmueble) {
		if (this.getTiposInmueble().contains(tipoInmueble)) {
			System.out.println("El tipo de inmueble ya existe en el sistema.");
		} else {
			this.getTiposInmueble().add(tipoInmueble);
		}	}
	
	public void altaServicio(Servicio servicio) {
		if (this.getServicios().contains(servicio)) {
			System.out.println("El servicio ya existe en el sistema.");
		} else {
			this.getServicios().add(servicio);
		}
	}
	
	public void altaFormaDePago(FormaDePago formaDePago) {
		if (this.getFormasDePago().contains(formaDePago)) {
			System.out.println("La forma de pago ya existe en el sistema.");
		} else {
			this.getFormasDePago().add(formaDePago);
		}
	}
	
	public void altaCategoriaRankeo(CategoriaRankeo categoriaRankeo) {
		if (this.getCategoriasRankeo().contains(categoriaRankeo)) {
			System.out.println("La categoría ya existe en el sistema.");
		} else {
			this.getCategoriasRankeo().add(categoriaRankeo);
		}
	}

	public List<Inmueble> busquedaDelInquilino( String ciudad, LocalDate fechaEntrada,
			LocalDate fechaSalida, int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		// TODO Auto-generated method stub
		return this.getInmuebles().stream()
				.filter(i -> esMismaCiudad(ciudad, i))
				.filter(i -> i.isDisponible(fechaEntrada, fechaSalida))
				.filter(i -> isIgualCapacidad(cantHuespuedes, i))
				.filter(i -> isValorEntre(minPrecio, maxPrecio, fechaEntrada, fechaSalida, i))
				.collect(Collectors.toList());
	}

	private boolean esMismaCiudad(String ciudad, Inmueble i) {
		return i.getCiudad().equals(ciudad);
	}
	
	private boolean isIgualCapacidad(int capacidad, Inmueble inmueble) {
		return inmueble.getCapacidad() == capacidad;
	}
	
	private boolean isValorEntre(Double minPrecio, Double maxPrecio, LocalDate fechaEntrada, LocalDate fechaSalida, Inmueble inmueble) {
		return (inmueble.calcularPrecioTotal(fechaEntrada, fechaSalida) >= minPrecio && inmueble.calcularPrecioTotal(fechaEntrada, fechaSalida) <= maxPrecio);
	}
	
	public List<Inmueble> getInmueblesDisponibles(String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida, int cantHuespuedes, Double minPrecio, Double maxPrecio) {
		return this.getInmuebles().stream().filter(inmueble -> inmueble.isDisponible(fechaEntrada, fechaSalida)).toList();
	}
	
	
	public List<Reserva> todasLasReservas(Inquilino inquilino) {
		return this.getInmuebles().stream()
		        .flatMap(i -> i.getReservas().stream()) // agarra cada lista de reservas y las une en una sola lista de stream
		        .filter(r -> r.getInquilino().equals(inquilino))
		        .collect(Collectors.toList());
	}
}
