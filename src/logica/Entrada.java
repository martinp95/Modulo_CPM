package logica;

public class Entrada {

	private String codigo;
	private String codigoParque;
	private double precioAdulto;
	private double precioNino;

	public Entrada(String codigo, String codigoParque, double precioAdulto, double precioNino) {
		super();
		this.codigo = codigo;
		this.codigoParque = codigoParque;
		this.precioAdulto = precioAdulto;
		this.precioNino = precioNino;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
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
