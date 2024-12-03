package ar.edu.unq.po2.sistemaAlquiler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unq.po2.reserva.Reserva;
import ar.edu.unq.po2.usuario.Inquilino;
import ar.edu.unq.po2.usuario.Usuario;

public class SAT {
	
	private Set<Usuario> 		  usuarios;
	private Set<Inmueble> 		  inmuebles;
	private Set<TipoInmueble> 	  tiposInmueble;
	private Set<Servicio> 		  servicios;
	private Set<FormaDePago>	  formasDePago;
	private Set<CategoriaRankeo>  categoriasRankeo;

	public SAT() {
		this.usuarios 		  = new HashSet<Usuario>();
		this.inmuebles 		  = new HashSet<Inmueble>();
		this.tiposInmueble 	  = new HashSet<TipoInmueble>();
		this.servicios 		  = new HashSet<Servicio>();
		this.formasDePago 	  = new HashSet<FormaDePago>();
		this.categoriasRankeo = new HashSet<CategoriaRankeo>();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios.stream().collect(Collectors.toList());
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles.stream().collect(Collectors.toList());
	}

	public List<TipoInmueble> getTiposInmueble() {
		return tiposInmueble.stream().collect(Collectors.toList());
	}

	public List<Servicio> getServicios() {
		return servicios.stream().collect(Collectors.toList());
	}

	public List<FormaDePago> getFormasDePago() {
		return formasDePago.stream().collect(Collectors.toList());
	}

	public List<CategoriaRankeo> getCategoriasRankeo() {
		return categoriasRankeo.stream().collect(Collectors.toList());
	}

	public void altaUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void altaInmueble(Inmueble inmueble ) {
		this.inmuebles.add(inmueble);
	}
	
	public void altaTipoInmueble(TipoInmueble tipoInmueble) {
		this.tiposInmueble.add(tipoInmueble);
	}
	
	public void altaServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public void altaFormaDePago(FormaDePago formaDePago) {
		this.formasDePago.add(formaDePago);
	}
	
	public void altaCategoriaRankeo(CategoriaRankeo categoriaRankeo) {
		this.categoriasRankeo.add(categoriaRankeo);
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
		Double precio = inmueble.calcularPrecioTotal(fechaEntrada, fechaSalida);
		return (precio >= minPrecio && precio <= maxPrecio);
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
