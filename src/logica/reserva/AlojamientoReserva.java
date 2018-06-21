package logica.reserva;

import java.util.Date;

public class AlojamientoReserva {

	private String codigo;
	private String tipo;
	private int categoria;
	private String denominacion;
	private String denominacionParque;
	private boolean desayuno;
	private Date fechaInicio;
	private int numeroNoches;
	private int numeroPersonas;
	private double precio;
	private double precioTotal;
	private double descuento;
	private boolean oferta;

	public AlojamientoReserva(String codigo, String tipo, int categoria, String denominacion, String denominacionParque,
			boolean desayuno, Date fechaInicio, int numeroNoches, int numeroPersonas, double precio, boolean oferta) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.categoria = categoria;
		this.denominacion = denominacion;
		this.denominacionParque = denominacionParque;
		this.desayuno = desayuno;
		this.fechaInicio = fechaInicio;
		this.numeroNoches = numeroNoches;
		this.numeroPersonas = numeroPersonas;
		this.precio = precio;
		this.oferta = oferta;
		calcularPrecioTotal();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
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

	public boolean isDesayuno() {
		return desayuno;
	}

	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
		calcularPrecioTotal();
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getNumeroNoches() {
		return numeroNoches;
	}

	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void calcularPrecioTotal() {
		double total;
		if (tipo.equals("HO")) {
			total = precio * numeroPersonas * numeroNoches;
			if (desayuno) {
				total = total + total * 0.1;
			}

		} else {
			total = precio * numeroNoches;
		}

		if (oferta) {
			descuento = total * 0.2;
			total = total - descuento;
		}
		this.precioTotal = total;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

}
