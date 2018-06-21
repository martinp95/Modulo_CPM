package logica;

public class Paquete {

	private String codigo;
	private String denominacion;
	private String codigoParque;
	private String codigoAlojamiento;
	private int duracion;
	private double precioAdulto;
	private double precioNino;

	public Paquete(String codigo, String denominacion, String codigoParque, String codigoAlojamiento, int duracion,
			double precioAdulto, double precioNino) {
		super();
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.codigoAlojamiento = codigoAlojamiento;
		this.duracion = duracion;
		this.precioAdulto = precioAdulto;
		this.precioNino = precioNino;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public String getCodigoAlojamiento() {
		return codigoAlojamiento;
	}

	public void setCodigoAlojamiento(String codigoAlojamiento) {
		this.codigoAlojamiento = codigoAlojamiento;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
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

	public String getCodigo() {
		return codigo;
	}
	
}
