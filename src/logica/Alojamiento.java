package logica;

public class Alojamiento {

	private String codigo;
	private String tipo;
	private int categoria;
	private String denominacion;
	private String codigoParque;
	private boolean completo;
	private int plazas;
	private double precio;

	public Alojamiento(String codigo, String tipo, int categoria, String denominacion, String codigoParque,boolean completo, int plazas,
			double precio) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.categoria = categoria;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.completo = completo;
		this.plazas = plazas;
		this.precio = precio;
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

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

}
