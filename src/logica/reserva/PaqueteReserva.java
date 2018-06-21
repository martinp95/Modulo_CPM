package logica.reserva;

import java.util.Date;

public class PaqueteReserva {

	private String codigo;
	private String denominacion;
	private String denominacionParque;
	private int duracion;
	private Date fechaInicio;
	private int numeroAdultos;
	private int numeroNinos;
	private double precioNino;
	private double precioAdulto;
	private double precioTotal;
	private boolean oferta;
	private double descuento;

	public PaqueteReserva(String codigo, String denominacion, String denominacionParque, int duracion, Date fechaInicio,
			int numeroAdultos, int numeroNinos, double precioAdulto, double precioNino, boolean oferta) {
		super();
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.denominacionParque = denominacionParque;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.numeroAdultos = numeroAdultos;
		this.numeroNinos = numeroNinos;
		this.precioAdulto = precioAdulto;
		this.precioNino = precioNino;
		this.oferta = oferta;
		calcularPrecioTotal();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDenominacionParque() {
		return denominacionParque;
	}

	public void setDenominacionParque(String denominacionParque) {
		this.denominacionParque = denominacionParque;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getNumeroAdultos() {
		return numeroAdultos;
	}

	public void setNumeroAdultos(int numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}

	public int getNumeroNinos() {
		return numeroNinos;
	}

	public void setNumeroNinos(int numeroNinos) {
		this.numeroNinos = numeroNinos;
	}

	public double getPrecioNino() {
		return precioNino;
	}

	public void setPrecioNino(double precioNino) {
		this.precioNino = precioNino;
	}

	public double getPrecioAdulto() {
		return precioAdulto;
	}

	public void setPrecioAdulto(double precioAdulto) {
		this.precioAdulto = precioAdulto;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	private void calcularPrecioTotal() {
		if (oferta) {
			double sinDescuento = precioAdulto * numeroAdultos + precioNino * numeroNinos;
			descuento = sinDescuento * 0.2;
			this.precioTotal = sinDescuento - descuento;
		} else {
			this.precioTotal = precioAdulto * numeroAdultos + precioNino * numeroNinos;
		}
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
