package logica.reserva;

import java.util.Date;

public class EntradaReserva {

	private String codigo;
	private String denominacionParque;
	private Date fechaInicio;
	private int numeroDiaas;
	private int numeroAdultos;
	private int numeroNinos;
	private double precioAdulto;
	private double precioNino;
	private double precioTotal;
	private boolean oferta;
	private double descuento;

	public EntradaReserva(String codigo, String denominacionParque, Date fechaInicio, int numeroDiaas,
			int numeroAdultos, int numeroNinos, double precioAdulto, double precioNino, boolean oferta) {
		super();
		this.codigo = codigo;
		this.denominacionParque = denominacionParque;
		this.fechaInicio = fechaInicio;
		this.numeroDiaas = numeroDiaas;
		this.numeroAdultos = numeroAdultos;
		this.numeroNinos = numeroNinos;
		this.precioAdulto = precioAdulto;
		this.precioNino = precioNino;
		this.oferta = oferta;
		calcularTotal();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacionParque() {
		return denominacionParque;
	}

	public void setDenominacionParque(String denominacionParque) {
		this.denominacionParque = denominacionParque;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getNumeroDiaas() {
		return numeroDiaas;
	}

	public void setNumeroDiaas(int numeroDiaas) {
		this.numeroDiaas = numeroDiaas;
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

	public double getPrecioAdulto() {
		return precioAdulto;
	}

	public void setPrecioAdulto(double precioAdulto) {
		this.precioAdulto = precioAdulto;
	}

	public double getPrecioNino() {
		return precioNino;
	}

	public void setPrecioNino(double precioNino) {
		this.precioNino = precioNino;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void calcularTotal() {
		if (!oferta) {
			this.precioTotal = (numeroAdultos * precioAdulto + numeroNinos * precioNino) * numeroDiaas;
		} else {
			double cantidad = (numeroAdultos * precioAdulto + numeroNinos * precioNino) * numeroDiaas;
			descuento = cantidad * 0.2;
			this.precioTotal = cantidad - descuento;
		}

	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

}
