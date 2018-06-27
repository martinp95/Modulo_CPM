package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import logica.reserva.AlojamientoReserva;
import logica.reserva.Cliente;
import logica.reserva.EntradaReserva;
import logica.reserva.PaqueteReserva;
import logica.reserva.Reserva;

public class Agencia {

	private List<Paquete> relacionPaquetes = new ArrayList<Paquete>();
	private List<ParqueTematico> relacionParquesTematicos = new ArrayList<ParqueTematico>();
	private List<Alojamiento> relacionAlojamientos = new ArrayList<Alojamiento>();
	private List<Entrada> relacionEntradas = new ArrayList<Entrada>();
	private List<Reserva> reservas = new ArrayList<Reserva>();

	private List<ParqueTematico> filtroParquesTematicos = new ArrayList<ParqueTematico>();

	public Agencia() {
		// TODO Auto-generated constructor stub
		leerFicheroParqueTematico();
		leerFicheroAlojamiento();
		leerFicheroEntrada();
		leerFicheroPaquete();

		colocarOferta();
		filtroParquesTematicos.addAll(relacionParquesTematicos);
	}

	private void leerFicheroAlojamiento() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/alojamientos.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				relacionAlojamientos.add(new Alojamiento(trozos[0], trozos[1], Integer.parseInt(trozos[2]), trozos[3],
						trozos[4], Integer.parseInt(trozos[5]), Double.parseDouble(trozos[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "El archivo de alojamientos no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private void leerFicheroEntrada() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/entradas.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				relacionEntradas.add(new Entrada(trozos[0], trozos[1], Double.parseDouble(trozos[2]),
						Double.parseDouble(trozos[3])));
				if (Double.parseDouble(trozos[2]) == 0.0 && Double.parseDouble(trozos[3]) == 0.0) {
					setParqueCerradoByCodigo(trozos[1]);
				}
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "El archivo de entradas no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private void setParqueCerradoByCodigo(String codigo) {
		for (ParqueTematico parqueTematico : relacionParquesTematicos) {
			if (parqueTematico.getCodigo().equals(codigo)) {
				parqueTematico.setCerrado(true);
			}
		}
	}

	private void leerFicheroPaquete() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/paquetes.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				relacionPaquetes.add(new Paquete(trozos[0], trozos[1], trozos[2], trozos[3],
						Integer.parseInt(trozos[4]), Double.parseDouble(trozos[5]), Double.parseDouble(trozos[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "El archivo de paquetes no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private void leerFicheroParqueTematico() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("files/tematicos.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				relacionParquesTematicos.add(new ParqueTematico(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "El archivo de paquetes no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public List<Paquete> getRelacionPaquetes() {
		return relacionPaquetes;
	}

	public List<Alojamiento> getRelacionAlojamientos() {
		return relacionAlojamientos;
	}

	public List<Entrada> getRelacionEntradas() {
		return relacionEntradas;
	}

	public void colocarOferta() {
		int posicion;
		int semilla = relacionParquesTematicos.size() - 1;
		do {
			posicion = (int) (semilla * Math.random());
		} while (relacionParquesTematicos.get(posicion).isOferta());
		relacionParquesTematicos.get(posicion).ponerOferta();
	}

	public List<ParqueTematico> getFiltroParquesTematicos() {
		return filtroParquesTematicos;
	}

	public void rellenarFiltroParquesTematicos() {
		filtroParquesTematicos.addAll(relacionParquesTematicos);
	}

	public void eliminarFiltroParquesTematicos() {
		filtroParquesTematicos.removeAll(filtroParquesTematicos);
	}

	public void eliminarElementoFiltroParquesTematicos(int index) {
		filtroParquesTematicos.remove(index);
	}

	public List<Entrada> getRelacionEntradasByParque(String codigoParque) {
		List<Entrada> entradasByParque = new ArrayList<Entrada>();
		for (Entrada entrada : relacionEntradas) {
			if (entrada.getCodigoParque().equals(codigoParque)) {
				entradasByParque.add(entrada);
			}
		}
		return entradasByParque;
	}

	public List<Alojamiento> getRelacionAlojamientosByParque(String codigoParque) {
		List<Alojamiento> alojamientoByParque = new ArrayList<Alojamiento>();
		for (Alojamiento alojamiento : relacionAlojamientos) {
			if (alojamiento.getCodigoParque().equals(codigoParque)) {
				alojamientoByParque.add(alojamiento);
			}
		}
		return alojamientoByParque;
	}

	public List<Paquete> getRelacionPaquetesByParque(String codParque) {
		List<Paquete> paquetesByParque = new ArrayList<Paquete>();
		for (Paquete paquete : relacionPaquetes) {
			if (paquete.getCodigoParque().equals(codParque)) {
				paquetesByParque.add(paquete);
			}
		}
		return paquetesByParque;
	}

	public Alojamiento getRelacionAlojamientosByPaqueteAlojamiento(String codigoPaqueteAlojamiento) {
		Alojamiento alojamientoByPaquete = null;
		for (Alojamiento alojamiento : relacionAlojamientos) {
			if (alojamiento.getCodigo().equals(codigoPaqueteAlojamiento)) {
				alojamientoByPaquete = alojamiento;
			}
		}
		return alojamientoByPaquete;
	}

	public void crearReserva(List<AlojamientoReserva> alojamientos, List<PaqueteReserva> paquetes,
			List<EntradaReserva> entradas, Cliente cliente, Date fechaRealizacion, String observaciones) {
		Reserva reserva = new Reserva(alojamientos, paquetes, entradas, cliente, fechaRealizacion, observaciones);
		reservas.add(reserva);
	}

	public String resumenReserva() {
		return reservas.get(reservas.size() - 1).resumen();
	}

	/**
	 * @param DNI
	 * @throws IOException
	 * 
	 *             Metodo que me esribe la informacion de la reserva en un fichero
	 *             de nombre el dni del comprador.
	 */
	@SuppressWarnings("deprecation")
	public void guardarReserva() throws IOException {
		Reserva reserva = reservas.get(reservas.size() - 1);
		Date fecha = new Date();
		BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + reserva.getCliente().getDni() + "-"
				+ fecha.getDay() + "-" + (fecha.getMonth() + 1) + "-" + (fecha.getYear() + 1900) + "-"
				+ fecha.getHours() + "-" + fecha.getMinutes() + "-" + fecha.getSeconds() + ".dat"));
		try {
			String linea = reserva.resumen();
			fichero.write(linea);
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
		fichero.close();
	}
}
