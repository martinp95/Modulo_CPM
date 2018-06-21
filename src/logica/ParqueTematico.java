package logica;

public class ParqueTematico {

	private String codigo;
	private String denominacion;
	private String pais;
	private String localidad;
	private String descripcion;
	private boolean oferta;

	public ParqueTematico(String codigo, String denominacion, String pais, String localidad, String descripcion) {
		super();
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.pais = pais;
		this.localidad = localidad;
		this.descripcion = descripcion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void ponerOferta() {
		this.oferta = true;
	}
}
