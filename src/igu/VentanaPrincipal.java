package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jvnet.substance.SubstanceLookAndFeel;

import logica.Agencia;
import logica.Alojamiento;
import logica.Entrada;
import logica.Paquete;
import logica.ParqueTematico;
import logica.reserva.AlojamientoReserva;
import logica.reserva.Cliente;
import logica.reserva.EntradaReserva;
import logica.reserva.PaqueteReserva;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Agencia agencia;
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenuItem mntmSalir;
	private JSeparator separator;
	private JMenuItem mntmAyuda;
	private JMenu mnContenido;
	private JMenuItem mntmAcercaDeParques;
	private JPanel pnParquesTematicos;
	private JTextArea textAreaDescripcionParque;
	private JScrollPane scrollPane_1;
	private JLabel lblDescripcionParque;
	private JPanel pnlDescripcionParque;
	private JTable tbParquesTematicos;
	private JScrollPane scrollPane;
	private JPanel pnlCentro;
	private JPanel pnlSur;
	private JPanel pnNorte;
	private JButton btnSeleccionar;
	private JLabel lblParquesTematicosEii;
	private JLabel lblLogo;
	private ModeloNoEditable modeloTabla;
	private JPanel pnFiltro;
	private JLabel lblFiltroPorPas;
	private JComboBox<String> comboBoxFiltroPais;
	private JPanel pnPaquetesAlojmientoEntradas;
	private JPanel pnCentroPaquetesEtc;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_2;
	private JTable tbPaquetes;
	private ModeloNoEditable modeloTablaPaquete;
	private JScrollPane scrollPane_3;
	private ModeloNoEditable modeloTablaAlojamiento;
	private JTable tbAlojamiento;
	private JScrollPane scrollPane_4;
	private ModeloNoEditable modeloTablaEntradas;
	private JTable tbEntradas;
	private JPanel pnFotoAlojamiento;
	private JLabel lbImagenAlojamiento;
	private JButton btnSiguiente;
	private JButton btnAtras;
	private JPanel pnBotones;
	private JPanel pnResumenBotones;
	private JButton btnCancelar;
	private JPanel pnResumen;
	private JCheckBox chckbxDesayunoIncluido;
	private JSpinner spinnerNoches;
	private JLabel lblNNoches;
	private JSpinner spinnerFecha;
	private JLabel lblFechaReserva;
	private JSpinner spinnerNiños;
	private JLabel lblNiNos;
	private JSpinner spinnerAdultos;
	private JLabel lblNAdultos;
	private JPanel pnBotonAñadirEliminar;
	private JButton btnAñadir;
	private JPanel pnProductosAnadidos;
	private JTabbedPane tabbedPaneProductosAnadidos;
	private JLabel lblObservaciones;
	private JPanel pnObservaciones;
	private JScrollPane scrollPane_6;
	private JTextArea textAreaObservaciones;
	private JPanel pnBotonEliminar;
	private JPanel pnEliminar;
	private JButton btnEliminar;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JTable tbPaquetesReserva;
	private JTable tbAlojamientosReserva;
	private JTable tbEntradasReserva;
	private ModeloNoEditable modeloTablaPaqueteReserva;
	private ModeloNoEditable modeloTablaAlojamientoReserva;
	private ModeloNoEditable modeloTablaEntradasReserva;
	private List<AlojamientoReserva> alojamientosReserva = new ArrayList<AlojamientoReserva>();
	private List<PaqueteReserva> paquetes = new ArrayList<PaqueteReserva>();
	private List<EntradaReserva> entradas = new ArrayList<EntradaReserva>();
	private JPanel pnDatosClienteResumen;
	private JPanel pnBotones1;
	private JPanel pnDatosCliente;
	private JLabel lblNombre;
	private JTextField txNombre;
	private JLabel lblApellidos;
	private JTextField txApellidos;
	private JLabel lblDni;
	private JTextField txDni;
	private JButton btnGenerarReserva;
	private JButton btnAtras_1;
	private JButton btnGuardarReservsa;
	private JPanel pnListaResumenReserva;
	private JTextArea textAreaReserva;
	private JScrollPane scrollPane_9;
	private JButton btnCancelar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setMinimumSize(new Dimension(1400, 500));
		agencia = new Agencia();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/img/parque-de-atracciones-de-agua_23-2147517736.png")));
		setTitle("Parques Tem\u00E1ticos EII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1495, 811);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnParquesTematicos(), "principal");
		contentPane.add(getPanel_1(), "relacionPaquetesAlojamientos");
		contentPane.add(getPnDatosClienteResumen(), "pnDatosClienteResumen");
		setLocationRelativeTo(null);
		cargaAyuda();
	}

	/**
	 * Metodo que carga la ayuda de la aplicacion.
	 */
	private void cargaAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();

		hb.enableHelpKey(getRootPane(), "introduccion", hs);
		hb.enableHelpOnButton(mntmAyuda, "introduccion", hs);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOpciones());
			menuBar.add(getMnContenido());
		}
		return menuBar;
	}

	private JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/cogs-icon.png")));
			mnOpciones.setMnemonic('O');
			mnOpciones.add(getMntmSalir());
		}
		return mnOpciones;
	}

	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setMnemonic('S');
			mntmSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/exit.png")));
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir?", "Salir",
							JOptionPane.YES_OPTION);
					if (respuesta == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
		}
		return mntmSalir;
	}

	private JMenu getMnContenido() {
		if (mnContenido == null) {
			mnContenido = new JMenu("Contenido");
			mnContenido.setMnemonic('C');
			mnContenido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/book-icon.png")));
			mnContenido.add(getMntmAyuda());
			mnContenido.add(getSeparator());
			mnContenido.add(getMntmAcercaDeParques());
		}
		return mnContenido;
	}

	private JMenuItem getMntmAyuda() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Ayuda");
			mntmAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cargaAyuda();
				}
			});
			mntmAyuda.setMnemonic('A');
			mntmAyuda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/help.png")));
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenuItem getMntmAcercaDeParques() {
		if (mntmAcercaDeParques == null) {
			mntmAcercaDeParques = new JMenuItem("Acerca de Parques Tematicos EII");
			mntmAcercaDeParques.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Aplicación de Parques Tematicos EII creada por: \nMartín Peláez Díaz 71674187-T");
				}
			});
			mntmAcercaDeParques.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
			mntmAcercaDeParques.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/about.png")));
			mntmAcercaDeParques.setMnemonic('c');
		}
		return mntmAcercaDeParques;
	}

	private JPanel getPnParquesTematicos() {
		if (pnParquesTematicos == null) {
			pnParquesTematicos = new JPanel();
			pnParquesTematicos.setLayout(new BorderLayout(0, 0));
			pnParquesTematicos.add(getPnNorte(), BorderLayout.NORTH);
			pnParquesTematicos.add(getPnlCentro(), BorderLayout.CENTER);
			pnParquesTematicos.add(getPnlSur(), BorderLayout.SOUTH);
		}
		return pnParquesTematicos;
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnNorte.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnNorte.add(getLblLogo());
			pnNorte.add(getLblParquesTematicosEii());
		}
		return pnNorte;
	}

	private JPanel getPnlSur() {
		if (pnlSur == null) {
			pnlSur = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnlSur.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnlSur.add(getBtnSeleccionar());
		}
		return pnlSur;
	}

	private JPanel getPnlCentro() {
		if (pnlCentro == null) {
			pnlCentro = new JPanel();
			pnlCentro.setLayout(new BorderLayout(0, 0));
			pnlCentro.add(getPnFiltro(), BorderLayout.NORTH);
			pnlCentro.add(getScrollPane(), BorderLayout.CENTER);
			pnlCentro.add(getPnlDescripcionParque(), BorderLayout.SOUTH);
		}
		return pnlCentro;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTbParquesTematicos());
		}
		return scrollPane;
	}

	private JTable getTbParquesTematicos() {
		if (tbParquesTematicos == null) {
			// Tabla
			String[] nombreColumnas = { "Oferta", "Portada", "Denominación", "País", "Localidad" };
			modeloTabla = new ModeloNoEditable(nombreColumnas, 0);
			cargarTabla();
			tbParquesTematicos = new JTable(modeloTabla);
			tbParquesTematicos.setToolTipText("Seleccione un parque de atracciones para continuar.");
			tbParquesTematicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbParquesTematicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbParquesTematicos.setMinimumSize(new Dimension(0, 0));
			tbParquesTematicos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent ev) {
					mostrarDescripcionParque();
					btnSeleccionar.setEnabled(true);
				}
			});
			// Incrementar el alto de la fila
			tbParquesTematicos.setRowHeight(120);
			// Modifica el ancho de la columnas
			tbParquesTematicos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(1);
			tbParquesTematicos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(50);
			tbParquesTematicos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(100);
			tbParquesTematicos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(40);
			tbParquesTematicos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(40);
			// Columnas no intercambiables
			tbParquesTematicos.getTableHeader().setReorderingAllowed(false);
		}
		return tbParquesTematicos;
	}

	/**
	 * Mostrar la descripcion del parque seleccionado en la tabla
	 */
	private void mostrarDescripcionParque() {
		textAreaDescripcionParque
				.setText(agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getDescripcion());
		textAreaDescripcionParque.setEnabled(true);
		if (agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).isOferta()) {
			textAreaDescripcionParque.insert("¡Oferta, 20% de descuento!\n", 0);
		}
	}

	/**
	 * Cargar datos de la tabla que muestra la relacion de parques tematicos
	 */
	private void cargarTabla() {
		Object[] nuevaFila = new Object[5];
		agencia.eliminarFiltroParquesTematicos();
		agencia.rellenarFiltroParquesTematicos();
		List<ParqueTematico> relacionParquesTematicos = agencia.getFiltroParquesTematicos();
		for (int i = 0; i < relacionParquesTematicos.size(); i++) {
			ParqueTematico parque = relacionParquesTematicos.get(i);
			// Saco si el parque tematico esta en oferta o no lo esta
			ImageIcon logoOferta = new ImageIcon(VentanaPrincipal.class.getResource("/img/vacio.png"));
			if (parque.isOferta()) {
				logoOferta = new ImageIcon(VentanaPrincipal.class.getResource("/img/deals-icon.png"));
			}
			nuevaFila[0] = logoOferta;
			// Foto del parque de atracciones.
			ImageIcon imagen = getImagenAdaptada(new ImageIcon("img/" + parque.getCodigo() + ".jpg"), 150, 120);
			imagen.setDescription(parque.getCodigo());
			nuevaFila[1] = imagen;
			// denominacion
			nuevaFila[2] = parque.getDenominacion();
			// pais
			nuevaFila[3] = parque.getPais();
			// localidad
			nuevaFila[4] = parque.getLocalidad();

			modeloTabla.addRow(nuevaFila);
		}
	}

	/**
	 * Metodo para renderizar el tamaño de la imagen.
	 * 
	 * @param imgOriginal
	 * @param ancho
	 * @param alto
	 * @return
	 */
	private ImageIcon getImagenAdaptada(ImageIcon imgOriginal, int ancho, int alto) {
		this.setVisible(true);
		Image imgEscalada = imgOriginal.getImage().getScaledInstance((int) ancho, (int) alto, Image.SCALE_FAST);
		return new ImageIcon(imgEscalada);
	}

	private JPanel getPnlDescripcionParque() {
		if (pnlDescripcionParque == null) {
			pnlDescripcionParque = new JPanel();
			pnlDescripcionParque.setPreferredSize(new Dimension(120, 120));
			pnlDescripcionParque.setLayout(new BorderLayout(0, 0));
			pnlDescripcionParque.add(getLblDescripcionParque(), BorderLayout.NORTH);
			pnlDescripcionParque.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return pnlDescripcionParque;
	}

	private JLabel getLblDescripcionParque() {
		if (lblDescripcionParque == null) {
			lblDescripcionParque = new JLabel("Descripción");
			lblDescripcionParque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDescripcionParque;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextAreaDescripcionParque());
		}
		return scrollPane_1;
	}

	private JTextArea getTextAreaDescripcionParque() {
		if (textAreaDescripcionParque == null) {
			textAreaDescripcionParque = new JTextArea();
			textAreaDescripcionParque.setEnabled(false);
			textAreaDescripcionParque.setLineWrap(true);
			textAreaDescripcionParque.setWrapStyleWord(true);
			textAreaDescripcionParque.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textAreaDescripcionParque.setEditable(false);
		}
		return textAreaDescripcionParque;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/parque-de-atracciones-de-agua_23-2147517736.png")));
		}
		return lblLogo;
	}

	private JLabel getLblParquesTematicosEii() {
		if (lblParquesTematicosEii == null) {
			lblParquesTematicosEii = new JLabel("Parques Tem\u00E1ticos EII");
			lblParquesTematicosEii.setFont(new Font("Dialog", Font.PLAIN, 50));
		}
		return lblParquesTematicosEii;
	}

	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					addModelTablas();

					cargarTablasRelacionPaquetesAlojamientos();

					((CardLayout) contentPane.getLayout()).show(contentPane, "relacionPaquetesAlojamientos");
				}
			});
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.setMnemonic('S');
			btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnSeleccionar;
	}

	/**
	 * Asigna el modelo a las tablas incluyendoles las cabeceras etc.
	 */
	private void addModelTablas() {
		getTbPaquetes().setModel(modeloTablaPaquete);
		getTbAlojamiento().setModel(modeloTablaAlojamiento);
		getTbEntradas().setModel(modeloTablaEntradas);

		getTbPaquetesReserva().setModel(modeloTablaPaqueteReserva);
		getTbAlojamientosReserva().setModel(modeloTablaAlojamientoReserva);
		getTbEntradasReserva().setModel(modeloTablaEntradasReserva);
	}

	/**
	 * Carga los datos relacionados con el parque seleccionado en las tablas
	 */
	private void cargarTablasRelacionPaquetesAlojamientos() {
		cargarPaquetes();
		cargarAlojamientos();
		cargarEntradas();
	}

	/**
	 * Metodo encargado de rellenar la tabla de entradas.
	 */
	private void cargarEntradas() {
		Object[] nuevaFila = new Object[2];
		List<Entrada> entradasParque = agencia.getRelacionEntradasByParque(
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo());
		for (Entrada entrada : entradasParque) {
			nuevaFila[0] = entrada.getPrecioAdulto() + "€";
			nuevaFila[1] = entrada.getPrecioNino() + "€";

			modeloTablaEntradas.addRow(nuevaFila);
		}
	}

	/**
	 * Metodo encargado de rellenar la tabla de alojamientos.
	 */
	private void cargarAlojamientos() {
		Object[] nuevaFila = new Object[5];
		List<Alojamiento> alojamientos = agencia.getRelacionAlojamientosByParque(
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo());
		for (Alojamiento alojamiento : alojamientos) {
			nuevaFila[0] = alojamiento.getTipo();
			nuevaFila[1] = alojamiento.getCategoria();
			nuevaFila[2] = alojamiento.getDenominacion();
			nuevaFila[3] = alojamiento.getPlazas();
			nuevaFila[4] = alojamiento.getPrecio() + "€";

			modeloTablaAlojamiento.addRow(nuevaFila);
		}
	}

	/**
	 * Metodo encargado de rellenar la tabla que muestra los paquetes tematicos de
	 * un parque.
	 */
	private void cargarPaquetes() {
		Object[] nuevaFila = new Object[6];
		List<Paquete> paquetes = agencia.getRelacionPaquetesByParque(
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo());

		Alojamiento alojamiento = null;
		for (Paquete paquete : paquetes) {
			nuevaFila[0] = paquete.getDenominacion();
			alojamiento = agencia.getRelacionAlojamientosByPaqueteAlojamiento(paquete.getCodigoAlojamiento());
			nuevaFila[1] = alojamiento.getDenominacion();
			nuevaFila[2] = alojamiento.getTipo();
			nuevaFila[3] = alojamiento.getCategoria();
			nuevaFila[4] = paquete.getDuracion();
			nuevaFila[5] = paquete.getPrecioAdulto() + "/" + paquete.getPrecioNino() + "€";

			modeloTablaPaquete.addRow(nuevaFila);
		}
	}

	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.add(getLblFiltroPorPas());
			pnFiltro.add(getComboBoxFiltroPais());
		}
		return pnFiltro;
	}

	private JLabel getLblFiltroPorPas() {
		if (lblFiltroPorPas == null) {
			lblFiltroPorPas = new JLabel("Filtro por país:");
			lblFiltroPorPas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblFiltroPorPas.setDisplayedMnemonic('F');
			lblFiltroPorPas.setLabelFor(getComboBoxFiltroPais());
		}
		return lblFiltroPorPas;
	}

	private JComboBox<String> getComboBoxFiltroPais() {
		if (comboBoxFiltroPais == null) {
			comboBoxFiltroPais = new JComboBox<String>();
			comboBoxFiltroPais.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					if (evt.getStateChange() == ItemEvent.SELECTED) {
						filtrarPais((String) comboBoxFiltroPais.getSelectedItem());
					}
				}
			});
			comboBoxFiltroPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxFiltroPais.setModel((new DefaultComboBoxModel<String>(rellenarPaises())));
			comboBoxFiltroPais.setSelectedIndex(0);
		}
		return comboBoxFiltroPais;
	}

	/**
	 * Metodo que filtra la lista de parques tematicos en funcion del pais.
	 * 
	 * @param pais
	 *            Nombre del pais por el que se quiere filtrar.
	 */
	private void filtrarPais(String pais) {
		textAreaDescripcionParque.setText("");
		textAreaDescripcionParque.setEnabled(false);
		btnSeleccionar.setEnabled(false);
		reiniciarTablaParquesTematicos();
		cargarTabla();
		if (!pais.equals("Todos los paises")) {
			for (int i = 0; i < modeloTabla.getRowCount(); i++) {
				if (!modeloTabla.getValueAt(i, 3).equals(pais)) {
					modeloTabla.removeRow(i);
					agencia.eliminarElementoFiltroParquesTematicos(i);
					i--;
				}
			}
		}
	}

	/**
	 * Metodo encargado del borrado de la tabla que muestra la relacion de parques
	 * tematicos.
	 */
	private void reiniciarTablaParquesTematicos() {
		int a = modeloTabla.getRowCount() - 1;
		for (int i = a; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}

	/**
	 * Rellenar el combobox para el filtro con los paises.
	 * 
	 * @return paises por los que se puede filtrar.
	 */
	private String[] rellenarPaises() {
		Set<String> paises = new HashSet<String>();

		for (ParqueTematico parque : agencia.getFiltroParquesTematicos()) {
			paises.add(parque.getPais());
		}

		List<String> todosPaises = new ArrayList<String>(paises);
		todosPaises.add(0, "Todos los paises");

		return todosPaises.toArray(new String[todosPaises.size()]);
	}

	private JPanel getPanel_1() {
		if (pnPaquetesAlojmientoEntradas == null) {
			pnPaquetesAlojmientoEntradas = new JPanel();
			pnPaquetesAlojmientoEntradas.setLayout(new BorderLayout(0, 0));
			pnPaquetesAlojmientoEntradas.add(getPanel_2(), BorderLayout.SOUTH);
			pnPaquetesAlojmientoEntradas.add(getPanel_3(), BorderLayout.CENTER);
		}
		return pnPaquetesAlojmientoEntradas;
	}

	private JPanel getPanel_3() {
		if (pnCentroPaquetesEtc == null) {
			pnCentroPaquetesEtc = new JPanel();
			pnCentroPaquetesEtc.setLayout(new BorderLayout(0, 0));
			pnCentroPaquetesEtc.add(getTabbedPane(), BorderLayout.CENTER);
			pnCentroPaquetesEtc.add(getPnFotoAlojamiento(), BorderLayout.WEST);
		}
		return pnCentroPaquetesEtc;
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setToolTipText("");
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tabbedPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					desHabilitarSpinner();
				}
			});
			tabbedPane.addTab("Paquetes", null, getScrollPane_2(), null);
			tabbedPane.addTab("Alojamiento", null, getScrollPane_3(), null);
			tabbedPane.addTab("Entradas", null, getScrollPane_4(), null);
			tabbedPane.setMnemonicAt(0, 'P');
			tabbedPane.setMnemonicAt(1, 'J');
			tabbedPane.setMnemonicAt(2, 'R');
		}
		return tabbedPane;
	}

	/**
	 * Metodo que deshabilita el boton de añadir a la reserva asi como los spinner y
	 * checkbox para elegir dias etc
	 */
	@SuppressWarnings("deprecation")
	private void desHabilitarSpinner() {
		lblNAdultos.setEnabled(false);
		spinnerAdultos.setValue(0);
		spinnerAdultos.setEnabled(false);

		lblNiNos.setEnabled(false);
		spinnerNiños.setValue(0);
		spinnerNiños.setEnabled(false);

		lblFechaReserva.setEnabled(false);
		Calendar ahoraCal = Calendar.getInstance();
		spinnerFecha.setModel(new SpinnerDateModel(
				new Date(ahoraCal.get(Calendar.YEAR) - 1900, ahoraCal.get(Calendar.MONTH), ahoraCal.get(Calendar.DATE)),
				new Date(ahoraCal.get(Calendar.YEAR) - 1900, ahoraCal.get(Calendar.MONTH), ahoraCal.get(Calendar.DATE)),
				null, Calendar.DAY_OF_YEAR));
		spinnerFecha.setEnabled(false);

		lblNNoches.setEnabled(false);
		spinnerNoches.setValue(0);
		spinnerNoches.setEnabled(false);

		chckbxDesayunoIncluido.setSelected(false);
		chckbxDesayunoIncluido.setEnabled(false);

		btnAñadir.setEnabled(false);
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTbPaquetes());
		}
		return scrollPane_2;
	}

	private JTable getTbPaquetes() {
		if (tbPaquetes == null) {
			String[] nombreColumnas = { "Denominación", "Alojamiento", "Tipo", "Estrellas", "Duracion",
					"Precio Adulto/Niño" };
			modeloTablaPaquete = new ModeloNoEditable(nombreColumnas, 0);
			tbPaquetes = new JTable();
			tbPaquetes.setToolTipText("Seleccione alguna de nuestra relacion de paquetes para reservar.");
			tbPaquetes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbPaquetes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String codigoAlojamiento = getCodigoAlojamientoPaquete();

					mostrarImagen(codigoAlojamiento);

					habitlitarEleccionPaquetes();
				}
			});
			tbPaquetes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbPaquetes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbPaquetes.getTableHeader().setReorderingAllowed(false);
		}
		return tbPaquetes;
	}

	/**
	 * Habilita las etiquetas y spinners corres pondientes a la eleccion de paquetes
	 */
	private void habitlitarEleccionPaquetes() {
		btnAñadir.setEnabled(true);
		lblNAdultos.setEnabled(true);
		spinnerAdultos.setEnabled(true);
		lblNiNos.setEnabled(true);
		spinnerNiños.setEnabled(true);
		lblFechaReserva.setEnabled(true);
		spinnerFecha.setEnabled(true);
	}

	/**
	 * Devuelve el codigo del alojamiento asiciado a un paquete.
	 * 
	 * @return
	 */
	private String getCodigoAlojamientoPaquete() {
		String codigoAlojamiento = agencia
				.getRelacionPaquetesByParque(
						agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo())
				.get(tbPaquetes.getSelectedRow()).getCodigoAlojamiento();
		return codigoAlojamiento;
	}

	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportView(getTbAlojamiento());
		}
		return scrollPane_3;
	}

	private JTable getTbAlojamiento() {
		if (tbAlojamiento == null) {
			String[] nombreColumnas = { "Tipo", "Estrellas", "Denominación", "Nº Plazas", "Precio" };
			modeloTablaAlojamiento = new ModeloNoEditable(nombreColumnas, 0);
			tbAlojamiento = new JTable();
			tbAlojamiento.setToolTipText("Seleccione alguna de nuestra relacion de alojamientos para reservar.");
			tbAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbAlojamiento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String codigoAlojamiento = getCodigoAlojamiento();

					mostrarImagen(codigoAlojamiento);

					habilitarEleccionAlojamientos();
				}
			});
			tbAlojamiento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbAlojamiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbAlojamiento.getTableHeader().setReorderingAllowed(false);
		}
		return tbAlojamiento;
	}

	/**
	 * Habilita la eleccion de los alojamientos, noches nº adultos etc
	 */
	private void habilitarEleccionAlojamientos() {
		btnAñadir.setEnabled(true);

		lblNAdultos.setEnabled(true);
		spinnerAdultos.setEnabled(true);
		lblNiNos.setEnabled(true);
		spinnerNiños.setEnabled(true);
		lblFechaReserva.setEnabled(true);
		spinnerFecha.setEnabled(true);
		lblNNoches.setEnabled(true);
		spinnerNoches.setEnabled(true);

		List<Alojamiento> alojamientos = agencia.getRelacionAlojamientosByParque(
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo());
		if (alojamientos.get(tbAlojamiento.getSelectedRow()).getTipo().equals("HO")) {
			chckbxDesayunoIncluido.setEnabled(true);
		} else {
			chckbxDesayunoIncluido.setEnabled(false);
			chckbxDesayunoIncluido.setSelected(false);
		}
	}

	/**
	 * Devuelve el codigo de un alojamiento.
	 * 
	 * @return
	 */
	private String getCodigoAlojamiento() {
		String codigoAlojamiento = agencia
				.getRelacionAlojamientosByParque(
						agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo())
				.get(tbAlojamiento.getSelectedRow()).getCodigo();
		return codigoAlojamiento;
	}

	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setViewportView(getTbEntradas());
		}
		return scrollPane_4;
	}

	private JTable getTbEntradas() {
		if (tbEntradas == null) {
			String[] nombreColumnas = { "Precio Adulto", "Precio Niño" };
			modeloTablaEntradas = new ModeloNoEditable(nombreColumnas, 0);
			tbEntradas = new JTable();
			tbEntradas.setToolTipText("Seleccione alguna de nuestra relacion de entradas para reservar.");
			tbEntradas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbEntradas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnAñadir.setEnabled(true);
					lblNAdultos.setEnabled(true);
					spinnerAdultos.setEnabled(true);
					lblNiNos.setEnabled(true);
					spinnerNiños.setEnabled(true);
					lblFechaReserva.setEnabled(true);
					spinnerFecha.setEnabled(true);
					lblNNoches.setEnabled(true);
					spinnerNoches.setEnabled(true);
				}
			});
			tbEntradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbEntradas.getTableHeader().setReorderingAllowed(false);
		}
		return tbEntradas;
	}

	private JPanel getPnFotoAlojamiento() {
		if (pnFotoAlojamiento == null) {
			pnFotoAlojamiento = new JPanel();
			pnFotoAlojamiento.setLayout(new BorderLayout(0, 0));
			pnFotoAlojamiento.add(getLbImagenAlojamiento());
		}
		return pnFotoAlojamiento;
	}

	private JLabel getLbImagenAlojamiento() {
		if (lbImagenAlojamiento == null) {
			lbImagenAlojamiento = new JLabel("");
			lbImagenAlojamiento.setPreferredSize(new Dimension(200, 0));
			lbImagenAlojamiento.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					if (tabbedPane.getSelectedIndex() == 0 && tbPaquetes.getSelectedRow() > -1) {
						String codigoAlojamiento = getCodigoAlojamientoPaquete();

						mostrarImagen(codigoAlojamiento);
					} else if (tabbedPane.getSelectedIndex() == 1 && tbAlojamiento.getSelectedRow() > -1) {
						String codigoAlojamiento = getCodigoAlojamiento();

						mostrarImagen(codigoAlojamiento);
					}
				}
			});
		}
		return lbImagenAlojamiento;
	}

	/**
	 * Metodo que redimensiona la imagen para adaptarla a los diferentes tipos de
	 * pantalla.
	 * 
	 * @param JLabel
	 * @param rutaImagen
	 */
	private void adaptarImagenLabel(JLabel label, String rutaImagen) {
		Image imgOriginal = new ImageIcon(VentanaPrincipal.class.getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int) (label.getWidth()), (int) (label.getHeight()),
				Image.SCALE_FAST);
		label.setIcon(new ImageIcon(imgEscalada));
	}

	/**
	 * Metodo que muestra las imagenes de la pelicula seleccionada en la tabla de
	 * las peliculas.
	 */
	private void mostrarImagen(String codigoImagen) {
		String rutaImagen = ("/img/" + codigoImagen + ".JPG");
		adaptarImagenLabel(lbImagenAlojamiento, rutaImagen);
	}

	private JPanel getPanel_2() {
		if (pnResumenBotones == null) {
			pnResumenBotones = new JPanel();
			pnResumenBotones.setLayout(new BorderLayout(0, 0));
			pnResumenBotones.add(getPnResumen(), BorderLayout.CENTER);
			pnResumenBotones.add(getPnBotones(), BorderLayout.SOUTH);
		}
		return pnResumenBotones;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnCancelar());
			pnBotones.add(getBtnAtras());
			pnBotones.add(getBtnSiguiente());
		}
		return pnBotones;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setToolTipText("Vuelva a nuestra seleccion de parques tematicos para añadir mas a su reserva.");
			btnAtras.setMnemonic('T');
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					borrarContenidoTablaRelacionPaquetesAlojamientosEntradas();

					lbImagenAlojamiento.setIcon(null);
					desHabilitarSpinner();

					((CardLayout) contentPane.getLayout()).show(contentPane, "principal");
				}

			});
			btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAtras;
	}

	/**
	 * Borra el contenido de las tablas que contienen la relacion de paquetes
	 * alojamientos y entradas asociadas a un parque de atracciones.
	 */
	private void borrarContenidoTablaRelacionPaquetesAlojamientosEntradas() {
		modeloTablaPaquete.getDataVector().clear();
		modeloTablaAlojamiento.getDataVector().clear();
		modeloTablaEntradas.getDataVector().clear();
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "pnDatosClienteResumen");
				}
			});
			btnSiguiente.setMnemonic('G');
			btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSiguiente.setEnabled(false);
		}
		return btnSiguiente;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('E');
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarContenidoTablaRelacionPaquetesAlojamientosEntradas();

					borrarContenidoTablasReserva();

					borrarContenidoTotalReserva();

					borrarDeshabilitarObservaciones();

					deshabilitarBotones();

					desHabilitarSpinner();

					borrarInformacionPnDatosClienteResumen();

					lbImagenAlojamiento.setIcon(null);

					deshabilitarTabbedPaneProductos();

					tbParquesTematicos.clearSelection();
					btnSeleccionar.setEnabled(false);
					textAreaDescripcionParque.setText("");
					textAreaDescripcionParque.setEnabled(false);
					
					comboBoxFiltroPais.setSelectedIndex(0);

					((CardLayout) contentPane.getLayout()).show(contentPane, "principal");
				}
			});
		}
		return btnCancelar;
	}

	private JPanel getPnResumen() {
		if (pnResumen == null) {
			pnResumen = new JPanel();
			pnResumen.setPreferredSize(new Dimension(350, 380));
			pnResumen.setLayout(new BorderLayout(0, 0));
			pnResumen.add(getPnBotonAñadirEliminar(), BorderLayout.NORTH);
			pnResumen.add(getPnProductosAnadidos(), BorderLayout.CENTER);
		}
		return pnResumen;
	}

	private JPanel getPnBotonAñadirEliminar() {
		if (pnBotonAñadirEliminar == null) {
			pnBotonAñadirEliminar = new JPanel();
			pnBotonAñadirEliminar.add(getLblNAdultos());
			pnBotonAñadirEliminar.add(getSpinnerAdultos());
			pnBotonAñadirEliminar.add(getLblNiNos());
			pnBotonAñadirEliminar.add(getSpinnerNiños());
			pnBotonAñadirEliminar.add(getLblFechaReserva());
			pnBotonAñadirEliminar.add(getSpinnerFecha());
			pnBotonAñadirEliminar.add(getLblNNoches());
			pnBotonAñadirEliminar.add(getSpinnerNoches());
			pnBotonAñadirEliminar.add(getChckbxDesayunoIncluido());
			pnBotonAñadirEliminar.add(getBtnAñadir());
		}
		return pnBotonAñadirEliminar;
	}

	private JLabel getLblNAdultos() {
		if (lblNAdultos == null) {
			lblNAdultos = new JLabel("N\u00BA Adultos:");
			lblNAdultos.setDisplayedMnemonic('U');
			lblNAdultos.setLabelFor(getSpinnerAdultos());
			lblNAdultos.setEnabled(false);
			lblNAdultos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNAdultos;
	}

	private JSpinner getSpinnerAdultos() {
		if (spinnerAdultos == null) {
			spinnerAdultos = new JSpinner();
			spinnerAdultos.setPreferredSize(new Dimension(50, 30));
			spinnerAdultos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerAdultos.setEnabled(false);
			spinnerAdultos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spinnerAdultos;
	}

	private JLabel getLblNiNos() {
		if (lblNiNos == null) {
			lblNiNos = new JLabel("N\u00BA Ni\u00F1os:");
			lblNiNos.setDisplayedMnemonic('N');
			lblNiNos.setLabelFor(getSpinnerNiños());
			lblNiNos.setEnabled(false);
			lblNiNos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNiNos;
	}

	private JSpinner getSpinnerNiños() {
		if (spinnerNiños == null) {
			spinnerNiños = new JSpinner();
			spinnerNiños.setPreferredSize(new Dimension(50, 30));
			spinnerNiños.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerNiños.setEnabled(false);
			spinnerNiños.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spinnerNiños;
	}

	private JLabel getLblFechaReserva() {
		if (lblFechaReserva == null) {
			lblFechaReserva = new JLabel("Fecha Reserva:");
			lblFechaReserva.setDisplayedMnemonic('F');
			lblFechaReserva.setLabelFor(getSpinnerFecha());
			lblFechaReserva.setEnabled(false);
			lblFechaReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblFechaReserva;
	}

	@SuppressWarnings("deprecation")
	private JSpinner getSpinnerFecha() {
		if (spinnerFecha == null) {
			spinnerFecha = new JSpinner();
			spinnerFecha.setPreferredSize(new Dimension(120, 30));
			Calendar ahoraCal = Calendar.getInstance();
			spinnerFecha.setModel(new SpinnerDateModel(
					new Date(ahoraCal.get(Calendar.YEAR) - 1900, ahoraCal.get(Calendar.MONTH),
							ahoraCal.get(Calendar.DATE)),
					new Date(ahoraCal.get(Calendar.YEAR) - 1900, ahoraCal.get(Calendar.MONTH),
							ahoraCal.get(Calendar.DATE)),
					null, Calendar.DAY_OF_YEAR));
			spinnerFecha.setEnabled(false);
			spinnerFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spinnerFecha;
	}

	private JLabel getLblNNoches() {
		if (lblNNoches == null) {
			lblNNoches = new JLabel("N\u00BA Dias:");
			lblNNoches.setDisplayedMnemonic('D');
			lblNNoches.setLabelFor(getSpinnerNoches());
			lblNNoches.setEnabled(false);
			lblNNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNNoches;
	}

	private JSpinner getSpinnerNoches() {
		if (spinnerNoches == null) {
			spinnerNoches = new JSpinner();
			spinnerNoches.setPreferredSize(new Dimension(50, 30));
			spinnerNoches.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerNoches.setEnabled(false);
			spinnerNoches.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spinnerNoches;
	}

	private JCheckBox getChckbxDesayunoIncluido() {
		if (chckbxDesayunoIncluido == null) {
			chckbxDesayunoIncluido = new JCheckBox("Desayuno Incluido");
			chckbxDesayunoIncluido.setMnemonic('Y');
			chckbxDesayunoIncluido.setEnabled(false);
			chckbxDesayunoIncluido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return chckbxDesayunoIncluido;
	}

	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pestana = tabbedPane.getSelectedIndex();
					int ninos = (int) spinnerNiños.getValue();
					int adultos = (int) spinnerAdultos.getValue();
					int noches = (int) spinnerNoches.getValue();
					Date fecha = (Date) spinnerFecha.getValue();

					List<Alojamiento> alojamientos = agencia.getRelacionAlojamientosByParque(
							agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo());
					if ((ninos + adultos) > 0) {
						if (pestana == 0) {

							addPaqueteReserva(ninos, adultos, fecha);

						} else if (pestana == 1) {

							addAlojamientoReserva(ninos, adultos, noches, fecha, alojamientos);

						} else if (pestana == 2) {

							addEntradasReserva(ninos, adultos, noches, fecha);
						}
					} else {
						JOptionPane.showMessageDialog(null, "EL numero de personas no puede ser 0.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnAñadir.setEnabled(false);

			btnAñadir.setMnemonic('A');
			btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAñadir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/sign-add-icon.png")));
		}
		return btnAñadir;

	}

	/**
	 * Habilita las observaciones para la reserva.
	 */
	private void habilitarObservaciones() {
		lblObservaciones.setEnabled(true);
		textAreaObservaciones.setEnabled(true);
	}

	/**
	 * Añadir entradas a la reserva
	 * 
	 * @param ninos
	 * @param adultos
	 * @param noches
	 * @param fecha
	 */
	private void addEntradasReserva(int ninos, int adultos, int noches, Date fecha) {
		if (noches > 0) {
			Entrada entrada = agencia
					.getRelacionEntradasByParque(
							agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo())
					.get(tbEntradas.getSelectedRow());

			EntradaReserva entradaReserva = new EntradaReserva(entrada.getCodigo(),
					agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getDenominacion(),
					fecha, noches, adultos, ninos, entrada.getPrecioAdulto(), entrada.getPrecioNino(),
					agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).isOferta());

			entradas.add(entradaReserva);

			habilitarTabbedPaneReserva(2);

			cargarEntradasReservas(entradaReserva);

			habilitarObservaciones();

			btnSiguiente.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "EL numero de dias no puede ser 0.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Habilita las pestañas del tabbedPanel donde se muestra lo que el usuario
	 * añadio a la reserva y te ubica en el indice del de la ultima reserva añadida.
	 * 
	 * @param index
	 */
	private void habilitarTabbedPaneReserva(int index) {
		tabbedPaneProductosAnadidos.setEnabledAt(index, true);
		tabbedPaneProductosAnadidos.setSelectedIndex(index);
	}

	/**
	 * Rellena la tabla con las entradas que se han añadio a la reserva.
	 * 
	 * @param entradaReserva
	 */
	private void cargarEntradasReservas(EntradaReserva entradaReserva) {
		Object[] nuevaFila = new Object[4];
		nuevaFila[0] = (int) spinnerAdultos.getValue();
		nuevaFila[1] = (int) spinnerNiños.getValue();
		nuevaFila[2] = (Date) spinnerFecha.getValue();
		nuevaFila[3] = entradaReserva.getPrecioTotal() + "€";

		modeloTablaEntradasReserva.addRow(nuevaFila);
	}

	/**
	 * Metodo que añade un alojamiento a la reserva.
	 * 
	 * @param ninos
	 * @param adultos
	 * @param noches
	 * @param fecha
	 * @param alojamientos
	 */
	private void addAlojamientoReserva(int ninos, int adultos, int noches, Date fecha, List<Alojamiento> alojamientos) {
		if (noches > 0) {

			Alojamiento alojamiento = agencia
					.getRelacionAlojamientosByParque(
							agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo())
					.get(tbAlojamiento.getSelectedRow());

			if (alojamientos.get(tbAlojamiento.getSelectedRow()).getTipo().equals("HO")) {

				addAlojamientoTipoHotel(ninos, adultos, noches, fecha, alojamiento);

			} else {
				if ((ninos + adultos) <= alojamientos.get(tbAlojamiento.getSelectedRow()).getPlazas()) {

					addAlojamientoNoHotel(ninos, adultos, noches, fecha, alojamiento);

				} else {
					JOptionPane.showMessageDialog(null, "EL numero de personas supera el maximo de ocupacion.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "EL numero de dias no puede ser 0.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Añade un alojamiento a la reserva cuando no es un hotel.
	 * 
	 * @param ninos
	 * @param adultos
	 * @param noches
	 * @param fecha
	 * @param alojamiento
	 */
	private void addAlojamientoNoHotel(int ninos, int adultos, int noches, Date fecha, Alojamiento alojamiento) {
		AlojamientoReserva alojamientoReserva = new AlojamientoReserva(alojamiento.getCodigo(), alojamiento.getTipo(),
				alojamiento.getCategoria(), alojamiento.getDenominacion(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getDenominacion(), false,
				fecha, noches, (ninos + adultos), alojamiento.getPrecio(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).isOferta());

		alojamientosReserva.add(alojamientoReserva);

		habilitarTabbedPaneReserva(1);

		habilitarObservaciones();

		cargarAlojamientoReserva(alojamiento, alojamientoReserva, false);

		btnSiguiente.setEnabled(true);
	}

	/**
	 * Rellena la tabla con el alojamiento que se añadio a la reserva
	 * 
	 * @param alojamiento
	 * @param alojamientoReserva
	 */
	private void cargarAlojamientoReserva(Alojamiento alojamiento, AlojamientoReserva alojamientoReserva,
			boolean desayuno) {
		Object[] nuevaFila = new Object[7];
		nuevaFila[0] = alojamiento.getDenominacion();
		nuevaFila[1] = alojamiento.getTipo();
		nuevaFila[2] = alojamiento.getCategoria();
		nuevaFila[3] = (int) spinnerNoches.getValue();
		nuevaFila[4] = (Date) spinnerFecha.getValue();
		nuevaFila[5] = ((int) spinnerAdultos.getValue() + (int) spinnerNiños.getValue());
		if (desayuno)
			nuevaFila[6] = alojamientoReserva.getPrecioTotal() + "€, desayuno incluido";
		else
			nuevaFila[6] = alojamientoReserva.getPrecioTotal() + "€";

		modeloTablaAlojamientoReserva.addRow(nuevaFila);
	}

	/**
	 * Añade un alojamiento de tipo hotel a la reserva
	 * 
	 * @param ninos
	 * @param adultos
	 * @param noches
	 * @param fecha
	 * @param alojamiento
	 */
	private void addAlojamientoTipoHotel(int ninos, int adultos, int noches, Date fecha, Alojamiento alojamiento) {
		AlojamientoReserva alojamientoReserva = new AlojamientoReserva(alojamiento.getCodigo(), alojamiento.getTipo(),
				alojamiento.getCategoria(), alojamiento.getDenominacion(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getDenominacion(), false,
				fecha, noches, (ninos + adultos), alojamiento.getPrecio(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).isOferta());

		if (chckbxDesayunoIncluido.isSelected()) {

			alojamientoReserva.setDesayuno(true);

			cargarAlojamientoReserva(alojamiento, alojamientoReserva, true);

		} else {

			alojamientoReserva.setDesayuno(false);

			cargarAlojamientoReserva(alojamiento, alojamientoReserva, false);

		}

		alojamientosReserva.add(alojamientoReserva);

		habilitarTabbedPaneReserva(1);

		habilitarObservaciones();

		btnSiguiente.setEnabled(true);
	}

	/**
	 * Metodo que añade un nuevo paquete a la reserva.
	 * 
	 * @param ninos
	 * @param adultos
	 * @param fecha
	 */
	private void addPaqueteReserva(int ninos, int adultos, Date fecha) {
		Paquete paquete = agencia
				.getRelacionPaquetesByParque(
						agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getCodigo())
				.get(tbPaquetes.getSelectedRow());

		PaqueteReserva paqueteReserva = new PaqueteReserva(paquete.getCodigo(), paquete.getDenominacion(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).getDenominacion(),
				paquete.getDuracion(), fecha, adultos, ninos, paquete.getPrecioAdulto(), paquete.getPrecioNino(),
				agencia.getFiltroParquesTematicos().get(tbParquesTematicos.getSelectedRow()).isOferta());

		paquetes.add(paqueteReserva);

		habilitarTabbedPaneReserva(0);

		cargarPaquetesReserva(paquete, paqueteReserva);

		habilitarObservaciones();

		btnSiguiente.setEnabled(true);
	}

	/**
	 * Rellena la tabla con el paquete que se añade al pedido.
	 * 
	 * @param paquete
	 * @param paqueteReserva
	 */
	private void cargarPaquetesReserva(Paquete paquete, PaqueteReserva paqueteReserva) {
		Object[] nuevaFila = new Object[5];
		nuevaFila[0] = paquete.getDenominacion();
		nuevaFila[1] = paquete.getDuracion();
		nuevaFila[2] = ((Date) spinnerFecha.getValue());
		nuevaFila[3] = (int) spinnerAdultos.getValue() + "/" + (int) spinnerNiños.getValue();
		nuevaFila[4] = paqueteReserva.getPrecioTotal() + "€";

		modeloTablaPaqueteReserva.addRow(nuevaFila);
	}

	private JPanel getPnProductosAnadidos() {
		if (pnProductosAnadidos == null) {
			pnProductosAnadidos = new JPanel();
			pnProductosAnadidos.setLayout(new BorderLayout(0, 0));
			pnProductosAnadidos.add(getPnObservaciones(), BorderLayout.SOUTH);
			pnProductosAnadidos.add(getTabbedPaneProductosAnadidos(), BorderLayout.CENTER);
		}
		return pnProductosAnadidos;
	}

	private JTabbedPane getTabbedPaneProductosAnadidos() {
		if (tabbedPaneProductosAnadidos == null) {
			tabbedPaneProductosAnadidos = new JTabbedPane(JTabbedPane.TOP);
			tabbedPaneProductosAnadidos.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					btnEliminar.setEnabled(false);
				}
			});
			tabbedPaneProductosAnadidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tabbedPaneProductosAnadidos.addTab("Paquetes", null, getScrollPane_5(), null);
			tabbedPaneProductosAnadidos.addTab("Alojamientos", null, getScrollPane_7(), null);
			tabbedPaneProductosAnadidos.addTab("Entradas", null, getScrollPane_8(), null);
			tabbedPaneProductosAnadidos.setMnemonicAt(0, 'Q');
			tabbedPaneProductosAnadidos.setMnemonicAt(1, 'M');
			tabbedPaneProductosAnadidos.setMnemonicAt(2, 'S');
			tabbedPaneProductosAnadidos.setEnabledAt(0, false);
			tabbedPaneProductosAnadidos.setEnabledAt(1, false);
			tabbedPaneProductosAnadidos.setEnabledAt(2, false);
			tabbedPaneProductosAnadidos.setSelectedIndex(-1);
			
		}
		return tabbedPaneProductosAnadidos;
	}

	private JPanel getPnObservaciones() {
		if (pnObservaciones == null) {
			pnObservaciones = new JPanel();
			pnObservaciones.setLayout(new BorderLayout(0, 0));
			pnObservaciones.add(getScrollPane_6(), BorderLayout.CENTER);
			pnObservaciones.add(getPnBotonEliminar(), BorderLayout.NORTH);
		}
		return pnObservaciones;
	}

	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel("Observaciones:");
			lblObservaciones.setEnabled(false);
			lblObservaciones.setDisplayedMnemonic('B');
			lblObservaciones.setLabelFor(getTextAreaObservaciones());
			lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblObservaciones;
	}

	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setViewportView(getTextAreaObservaciones());
		}
		return scrollPane_6;
	}

	private JTextArea getTextAreaObservaciones() {
		if (textAreaObservaciones == null) {
			textAreaObservaciones = new JTextArea();
			textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textAreaObservaciones.setEnabled(false);
			textAreaObservaciones.setLineWrap(true);
			textAreaObservaciones.setPreferredSize(new Dimension(90, 90));
			textAreaObservaciones.setWrapStyleWord(true);
		}
		return textAreaObservaciones;
	}

	private JPanel getPnBotonEliminar() {
		if (pnBotonEliminar == null) {
			pnBotonEliminar = new JPanel();
			pnBotonEliminar.setLayout(new BorderLayout(0, 0));
			pnBotonEliminar.add(getPnEliminar(), BorderLayout.NORTH);
			pnBotonEliminar.add(getLblObservaciones());
		}
		return pnBotonEliminar;
	}

	private JPanel getPnEliminar() {
		if (pnEliminar == null) {
			pnEliminar = new JPanel();
			pnEliminar.add(getBtnEliminar());
		}
		return pnEliminar;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pestana = tabbedPaneProductosAnadidos.getSelectedIndex();

					if (pestana == 0) {
						borrarPaqueteReserva();
					} else if (pestana == 1) {
						borrarAlojamientoReserva();
					} else if (pestana == 2) {
						borrarEntradaReserva();
					}

					elementosReserva();
				}
			});
			btnEliminar.setMnemonic('M');
			btnEliminar.setEnabled(false);
			btnEliminar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/sign-delete-icon.png")));
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnEliminar;
	}

	/**
	 * Comprobar que todavia quedan elementos en la reserva despues de borrar
	 * alguno.
	 */
	private void elementosReserva() {
		int numPaquetes = paquetes.size();
		int numAlojamientos = alojamientosReserva.size();
		int numEntradas = entradas.size();

		if (numPaquetes == 0 && numAlojamientos == 0 && numEntradas == 0) {
			btnSiguiente.setEnabled(false);
			lblObservaciones.setEnabled(false);
			textAreaObservaciones.setEnabled(false);
			tabbedPaneProductosAnadidos.setSelectedIndex(-1);
		}
	}

	/**
	 * Borra una entrada añadida a la reserva seleccionada en la tabla.
	 */
	private void borrarEntradaReserva() {
		int fila = tbEntradasReserva.getSelectedRow();
		entradas.remove(fila);
		modeloTablaEntradasReserva.removeRow(fila);

		if (modeloTablaEntradasReserva.getRowCount() <= 0) {
			tabbedPaneProductosAnadidos.setEnabledAt(2, false);
			btnEliminar.setEnabled(false);
		}
	}

	/**
	 * Borra un alojamiento añadido a la reserva seleccionado en la tabla.
	 */
	private void borrarAlojamientoReserva() {
		int fila = tbAlojamientosReserva.getSelectedRow();
		alojamientosReserva.remove(fila);
		modeloTablaAlojamientoReserva.removeRow(fila);

		if (tbAlojamientosReserva.getRowCount() <= 0) {
			tabbedPaneProductosAnadidos.setEnabledAt(1, false);
			btnEliminar.setEnabled(false);
		}
	}

	/**
	 * Borra un paquete añadido a la reserva seleccionado en la tabla.
	 */
	private void borrarPaqueteReserva() {
		int fila = tbPaquetesReserva.getSelectedRow();
		paquetes.remove(fila);
		modeloTablaPaqueteReserva.removeRow(fila);

		if (tbPaquetesReserva.getRowCount() <= 0) {
			tabbedPaneProductosAnadidos.setEnabledAt(0, false);
			btnEliminar.setEnabled(false);
		}
	}

	private JScrollPane getScrollPane_5() {
		if (scrollPane_5 == null) {
			scrollPane_5 = new JScrollPane();
			scrollPane_5.setViewportView(getTbPaquetesReserva());
		}
		return scrollPane_5;
	}

	private JScrollPane getScrollPane_7() {
		if (scrollPane_7 == null) {
			scrollPane_7 = new JScrollPane();
			scrollPane_7.setViewportView(getTbAlojamientosReserva());
		}
		return scrollPane_7;
	}

	private JScrollPane getScrollPane_8() {
		if (scrollPane_8 == null) {
			scrollPane_8 = new JScrollPane();
			scrollPane_8.setViewportView(getTbEntradasReserva());
		}
		return scrollPane_8;
	}

	private JTable getTbPaquetesReserva() {
		if (tbPaquetesReserva == null) {
			String[] nombreColumnas = { "Deniminación Paquete", "Duración", "Fecha inicio", "Nº Adultos/Niños",
					"Precio" };
			modeloTablaPaqueteReserva = new ModeloNoEditable(nombreColumnas, 0);
			tbPaquetesReserva = new JTable();
			tbPaquetesReserva.setToolTipText("Selccione el elemento que desea eliminar.");
			tbPaquetesReserva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnEliminar.setEnabled(true);
				}
			});
			tbPaquetesReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbPaquetesReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbPaquetesReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbPaquetesReserva.getTableHeader().setReorderingAllowed(false);
		}
		return tbPaquetesReserva;
	}

	private JTable getTbAlojamientosReserva() {
		if (tbAlojamientosReserva == null) {
			String[] nombreColumnas = { "Denominacion", "Tipo", "Categoria", "Nº Dias", "Fecha Inicio", "Nº Personas",
					"Precio" };
			modeloTablaAlojamientoReserva = new ModeloNoEditable(nombreColumnas, 0);
			tbAlojamientosReserva = new JTable();
			tbAlojamientosReserva.setToolTipText("Selccione el elemento que desea eliminar.");
			tbAlojamientosReserva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnEliminar.setEnabled(true);
				}
			});
			tbAlojamientosReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbAlojamientosReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbAlojamientosReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbAlojamientosReserva.getTableHeader().setReorderingAllowed(false);
		}
		return tbAlojamientosReserva;
	}

	private JTable getTbEntradasReserva() {
		if (tbEntradasReserva == null) {
			String[] nombreColumnas = { "Nº Adultos", "Nº Niños", "Fecha", "Precio" };
			modeloTablaEntradasReserva = new ModeloNoEditable(nombreColumnas, 0);
			tbEntradasReserva = new JTable();
			tbEntradasReserva.setToolTipText("Selccione el elemento que desea eliminar.");
			tbEntradasReserva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnEliminar.setEnabled(true);
				}
			});
			tbEntradasReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbEntradasReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tbEntradasReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbEntradasReserva.getTableHeader().setReorderingAllowed(false);
		}
		return tbEntradasReserva;
	}

	private JPanel getPnDatosClienteResumen() {
		if (pnDatosClienteResumen == null) {
			pnDatosClienteResumen = new JPanel();
			pnDatosClienteResumen.setLayout(new BorderLayout(0, 0));
			pnDatosClienteResumen.add(getPnDatosCliente(), BorderLayout.NORTH);
			pnDatosClienteResumen.add(getPnBotones1(), BorderLayout.SOUTH);
			pnDatosClienteResumen.add(getPnListaResumenReserva(), BorderLayout.CENTER);
		}
		return pnDatosClienteResumen;
	}

	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.add(getLblNombre());
			pnDatosCliente.add(getTxNombre());
			pnDatosCliente.add(getLblApellidos());
			pnDatosCliente.add(getTxApellidos());
			pnDatosCliente.add(getLblDni());
			pnDatosCliente.add(getTxDni());
			pnDatosCliente.add(getBtnGenerarReserva());
		}
		return pnDatosCliente;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setLabelFor(getTxNombre());
			lblNombre.setDisplayedMnemonic('N');
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNombre;
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txNombre.setColumns(10);
		}
		return txNombre;
	}

	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setLabelFor(getTxApellidos());
			lblApellidos.setDisplayedMnemonic('A');
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblApellidos;
	}

	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setLabelFor(getTxDni());
			lblDni.setDisplayedMnemonic('D');
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDni;
	}

	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txDni.setColumns(10);
		}
		return txDni;
	}

	private JButton getBtnGenerarReserva() {
		if (btnGenerarReserva == null) {
			btnGenerarReserva = new JButton("Generar Recibo");
			btnGenerarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txApellidos.getText().trim().equals("") && !txNombre.getText().trim().equals("")
							&& !txDni.getText().trim().equals("")) {

						mostrarReciboReserva();
					} else {
						JOptionPane.showMessageDialog(null, "EL nombre, apellidos y dni son datos obligatorios",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnGenerarReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnGenerarReserva.setMnemonic('G');
		}
		return btnGenerarReserva;
	}

	/**
	 * Metodo que muestra en pantalla el recibo generado para la reserva del
	 * usuario.
	 */
	private void mostrarReciboReserva() {
		Cliente cliente = new Cliente(txNombre.getText(), txApellidos.getText(), txDni.getText());
		agencia.crearReserva(alojamientosReserva, paquetes, entradas, cliente, new Date(),
				textAreaObservaciones.getText());

		textAreaReserva.setText(agencia.resumenReserva());
		textAreaReserva.setEnabled(true);
		btnGuardarReservsa.setEnabled(true);
	}

	private JPanel getPnBotones1() {
		if (pnBotones1 == null) {
			pnBotones1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones1.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones1.add(getBtnCancelar_1());
			pnBotones1.add(getBtnAtras_1());
			pnBotones1.add(getBtnGuardarReservsa());
		}
		return pnBotones1;
	}

	private JButton getBtnAtras_1() {
		if (btnAtras_1 == null) {
			btnAtras_1 = new JButton("Atras");
			btnAtras_1.setToolTipText("Vuelve a ver la relacion de paquetes o alojamientos por si quiere realizar cambios.");
			btnAtras_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "relacionPaquetesAlojamientos");

					textAreaReserva.setText("");
					textAreaReserva.setEnabled(false);

					btnGuardarReservsa.setEnabled(false);
				}
			});
			btnAtras_1.setMnemonic('t');
			btnAtras_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAtras_1;
	}

	private JButton getBtnGuardarReservsa() {
		if (btnGuardarReservsa == null) {
			btnGuardarReservsa = new JButton("Guardar Reserva");
			btnGuardarReservsa.setMnemonic('U');
			btnGuardarReservsa.setEnabled(false);
			btnGuardarReservsa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						agencia.guardarReserva();

						JOptionPane.showMessageDialog(null, "Su reserva se ha realizado con exito", "INFORMACION",
								JOptionPane.INFORMATION_MESSAGE);

						borrarContenidoTablaRelacionPaquetesAlojamientosEntradas();

						borrarContenidoTablasReserva();

						borrarContenidoTotalReserva();

						borrarDeshabilitarObservaciones();

						deshabilitarBotones();

						desHabilitarSpinner();

						borrarInformacionPnDatosClienteResumen();

						lbImagenAlojamiento.setIcon(null);

						deshabilitarTabbedPaneProductos();

						tbParquesTematicos.clearSelection();
						btnSeleccionar.setEnabled(false);
						textAreaDescripcionParque.setText("");
						textAreaDescripcionParque.setEnabled(false);
						
						comboBoxFiltroPais.setSelectedIndex(0);

						((CardLayout) contentPane.getLayout()).show(contentPane, "principal");

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnGuardarReservsa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnGuardarReservsa;
	}

	private void deshabilitarTabbedPaneProductos() {
		tabbedPaneProductosAnadidos.setEnabledAt(0, false);
		tabbedPaneProductosAnadidos.setEnabledAt(1, false);
		tabbedPaneProductosAnadidos.setEnabledAt(2, false);
		tabbedPaneProductosAnadidos.setSelectedIndex(-1);
	}

	private void borrarInformacionPnDatosClienteResumen() {
		txNombre.setText("");
		txApellidos.setText("");
		txDni.setText("");
		textAreaReserva.setEnabled(false);
		textAreaReserva.setText("");
	}

	private void deshabilitarBotones() {
		btnSiguiente.setEnabled(false);
		btnAñadir.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	/**
	 * Metodo que borra el contenido de las observaciones y las deshabilita.
	 */
	private void borrarDeshabilitarObservaciones() {
		textAreaObservaciones.setEnabled(false);
		textAreaObservaciones.setText("");
		lblObservaciones.setEnabled(false);
	}

	/**
	 * Borra el contenido de los arrays que conforman la reserva.
	 */
	private void borrarContenidoTotalReserva() {
		paquetes.clear();
		alojamientosReserva.clear();
		entradas.clear();
	}

	/**
	 * Metodo que borra el contenido total de las tablas que muestran los productos
	 * añadidos a la reserva.
	 */
	private void borrarContenidoTablasReserva() {
		modeloTablaAlojamientoReserva.getDataVector().clear();
		modeloTablaEntradasReserva.getDataVector().clear();
		modeloTablaPaqueteReserva.getDataVector().clear();
	}

	private JPanel getPnListaResumenReserva() {
		if (pnListaResumenReserva == null) {
			pnListaResumenReserva = new JPanel();
			pnListaResumenReserva.setLayout(new BorderLayout(0, 0));
			pnListaResumenReserva.add(getScrollPane_9(), BorderLayout.CENTER);
		}
		return pnListaResumenReserva;
	}

	private JScrollPane getScrollPane_9() {
		if (scrollPane_9 == null) {
			scrollPane_9 = new JScrollPane();
			scrollPane_9.setViewportView(getTextAreaReserva());
		}
		return scrollPane_9;
	}

	private JTextArea getTextAreaReserva() {
		if (textAreaReserva == null) {
			textAreaReserva = new JTextArea();
			textAreaReserva.setFont(new Font("Monospaced", Font.PLAIN, 14));
			textAreaReserva.setEnabled(false);
			textAreaReserva.setEditable(false);
		}
		return textAreaReserva;
	}

	private JButton getBtnCancelar_1() {
		if (btnCancelar_1 == null) {
			btnCancelar_1 = new JButton("Cancelar");
			btnCancelar_1.setMnemonic('E');
			btnCancelar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					borrarContenidoTablaRelacionPaquetesAlojamientosEntradas();

					borrarContenidoTablasReserva();

					borrarContenidoTotalReserva();

					borrarDeshabilitarObservaciones();

					deshabilitarBotones();

					desHabilitarSpinner();

					borrarInformacionPnDatosClienteResumen();

					lbImagenAlojamiento.setIcon(null);

					deshabilitarTabbedPaneProductos();

					tbParquesTematicos.clearSelection();
					btnSeleccionar.setEnabled(false);
					textAreaDescripcionParque.setText("");
					textAreaDescripcionParque.setEnabled(false);
					
					comboBoxFiltroPais.setSelectedIndex(0);

					((CardLayout) contentPane.getLayout()).show(contentPane, "principal");
				}
			});
			btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancelar_1;
	}
}
