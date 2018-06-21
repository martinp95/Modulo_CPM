package logica.reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

	private List<AlojamientoReserva> alojamientos = new ArrayList<AlojamientoReserva>();
	private List<PaqueteReserva> paquetes = new ArrayList<PaqueteReserva>();
	private List<EntradaReserva> entradas = new ArrayList<EntradaReserva>();
	private Cliente cliente;
	private Date fechaRealizacion;
	private String observaciones;

	public Reserva(List<AlojamientoReserva> alojamientos, List<PaqueteReserva> paquetes, List<EntradaReserva> entradas,
			Cliente cliente, Date fechaRealizacion, String observaciones) {
		super();
		this.alojamientos = alojamientos;
		this.paquetes = paquetes;
		this.entradas = entradas;
		this.cliente = cliente;
		this.fechaRealizacion = fechaRealizacion;
		this.setObservaciones(observaciones);
	}

	public List<AlojamientoReserva> getAlojamientos() {
		return alojamientos;
	}

	public void setAlojamientos(List<AlojamientoReserva> alojamientos) {
		this.alojamientos = alojamientos;
	}

	public List<PaqueteReserva> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PaqueteReserva> paquetes) {
		this.paquetes = paquetes;
	}

	public List<EntradaReserva> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<EntradaReserva> entradas) {
		this.entradas = entradas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@SuppressWarnings("deprecation")
	public String resumen() {
		double totalPaquetes = 0, totalAlojamientos = 0, totalEntradas = 0;
		double descuentoPaquetes = 0, descuentoAlojamientos = 0, descuentoEntradas = 0;
		String resumen = "";

		resumen += "Viajes EII-TOURS\nJUSTIFICANTE DE RESERVA - " + fechaRealizacion.getDate() + "/"
				+ (fechaRealizacion.getMonth() + 1) + "/" + (fechaRealizacion.getYear() + 1900) + "\n";
		resumen += "------------------------------------------------------------------------------------------\n";
		resumen += cliente.getDni() + " - " + cliente.getNombre() + " " + cliente.getApellidos() + "\n";
		resumen += "**** DATOS DE LA/S RESERVA/S ****\n";

		resumen += "** PAQUETES TEMATICOS **\n";
		for (PaqueteReserva paquete : paquetes) {
			resumen += "Paquete: " + paquete.getCodigo() + "/ " + paquete.getDenominacion() + "/ "
					+ paquete.getDenominacionParque() + "/ " + paquete.getDuracion() + " días\nFecha Inicio: "
					+ paquete.getFechaInicio().getDay() + "/" + (paquete.getFechaInicio().getMonth() + 1) + "/"
					+ (paquete.getFechaInicio().getYear() + 1900) + "\nN. Adultos: " + paquete.getNumeroAdultos()
					+ "/ N. Niños: " + paquete.getNumeroNinos() + "\n\n";
			totalPaquetes += paquete.getPrecioTotal();
			descuentoPaquetes += paquete.getDescuento();
		}

		resumen += "** ALOJAMIENTOS **\n";
		for (AlojamientoReserva alojamientoReserva : alojamientos) {
			String desayuno;
			if (alojamientoReserva.isDesayuno()) {
				desayuno = "s";
			} else {
				desayuno = "n";
			}
			resumen += "Alojamiento: " + alojamientoReserva.getCodigo() + "/ " + alojamientoReserva.getTipo() + "/ "
					+ alojamientoReserva.getDenominacion() + "/ " + alojamientoReserva.getCategoria() + " estrellas / "
					+ alojamientoReserva.getDenominacionParque() + "\nFecha Inicio: "
					+ alojamientoReserva.getFechaInicio().getDay() + "/"
					+ (alojamientoReserva.getFechaInicio().getMonth() + 1) + "/"
					+ (alojamientoReserva.getFechaInicio().getYear() + 1900) + " / Número noches: "
					+ alojamientoReserva.getNumeroNoches() + " / Desayuno: " + desayuno + "\nN. Personas:"
					+ alojamientoReserva.getNumeroPersonas() + "\n\n";
			totalAlojamientos = alojamientoReserva.getPrecioTotal();
			descuentoAlojamientos += alojamientoReserva.getDescuento();
		}

		resumen += "** ENTRADAS **\n";
		for (EntradaReserva entrada : entradas) {
			resumen += "Entrada: " + entrada.getCodigo() + " / " + entrada.getDenominacionParque() + "\nFecha Inicio: "
					+ entrada.getFechaInicio().getDay() + "/" + (entrada.getFechaInicio().getMonth() + 1) + "/"
					+ (entrada.getFechaInicio().getYear() + 1900) + " / Número de días: " + entrada.getNumeroDiaas()
					+ "\nN. Adultos: " + entrada.getNumeroAdultos() + "/ N. Niños: " + entrada.getNumeroNinos()
					+ "\n\n";
			totalEntradas += entrada.getPrecioTotal();
			descuentoEntradas += entrada.getDescuento();
		}

		resumen += "**** PAGADO RESERVA ****\nPaquetes temáticos:\t\t\t\t" + totalPaquetes + "€"
				+ "\nAlojamientos:\t\t\t\t\t" + totalAlojamientos + "€" + "\nEntradas:\t\t\t\t\t" + totalEntradas + "€"
				+ "\nDescuentos Oferta:\t\t\t\t" + (descuentoAlojamientos + descuentoEntradas + descuentoPaquetes) + "€"
				+ "\n\nImporte Total:\t\t\t\t\t" + (totalPaquetes + totalAlojamientos + totalEntradas) + "€";

		return resumen.toUpperCase();
	}
}
