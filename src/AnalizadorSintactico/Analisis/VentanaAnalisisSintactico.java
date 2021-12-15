package AnalizadorSintactico.Analisis;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Utilidades.Archivo;
import Utilidades.ColeccionCanonica;
import Utilidades.Gramatica.Gramatica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAnalisisSintactico extends JDialog {
	private FlowLayout diseñoPanel;
	private JPanel panelInformacion, panelArchivo, panelResultado;
	private JLabel lblSimbolosNoTerminales, lblSimbolosTerminales, lblSimboloInicial, lblGramatica,
			lblColeccionCanonica, lblArchivoGramatica, lblArchivoPrograma;
	private JTextField textNoTerminales, textTerminales, textSimboloInicial, textRutaArchivoGramatica, textRutaArchivoPrograma;
	private JTextArea areaGramatica, areaColeccionCanonica;
	private JButton botonBuscarGramatica, botonBuscarPrograma;
	private final JDialog estaVentana = this;
	private final int altoElementos = 30;
	private final Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	private final Border paddingTextArea = BorderFactory.createEmptyBorder(10, 10, 10, 10);

	// Constructor de la ventana
	public VentanaAnalisisSintactico(JFrame parent, String noTerminales, String terminales, String simboloInicial,
			String gramatica, String coleccionCanonica) {
		super(parent, true);

		// Iniciar componentes
		inicializarComponentes();

		// Rellenar con informacion dada
		rellenarComponentes(noTerminales, terminales, simboloInicial, gramatica, coleccionCanonica);

		this.setVisible(true);
	}

	// Constructor Vacio
	public VentanaAnalisisSintactico() {
		super();

		// Iniciar Componentes
		inicializarComponentes();

		this.setVisible(true);
	}

	private void inicializarComponentes() {
		// Propiedades de la ventana
		diseñoPanel = new FlowLayout(FlowLayout.LEFT, 10, 10);
		this.setSize(1000, 760);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(diseñoPanel);
		this.setTitle("Analizador Sintáctico - Análisis Sintactico");


		/** Mostrar ruta dle archivo y boton para cargar otro archivo */

		// Propiedades del panel de Archivo
		panelArchivo = new JPanel();
		panelArchivo.setPreferredSize(new Dimension(900, 90));
		panelArchivo.setLayout(diseñoPanel);

		// Mostrar la ruta del archivo de Gramatica
		lblArchivoGramatica = new JLabel("Gramática:");
		lblArchivoGramatica.setPreferredSize(new Dimension(80, altoElementos));

		textRutaArchivoGramatica = new JTextField("src/ArchivosExtra/gramatica.txt");
		textRutaArchivoGramatica.setPreferredSize(new Dimension(600, altoElementos));
		textRutaArchivoGramatica.setEditable(false);
		textRutaArchivoGramatica.setBorder(BorderFactory.createCompoundBorder(textRutaArchivoGramatica.getBorder(), padding));

		// Boton para buscar otro archivo
		botonBuscarGramatica = new JButton("Buscar Archivo Gramatica");
		botonBuscarGramatica.setPreferredSize(new Dimension(160, altoElementos));

		// Agregar Accion al boton
		botonBuscarGramatica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener nueva ruta dle archivo
				String ruta = Archivo.obtenerRutaArchivo(estaVentana);

				editarRutaArchivo(ruta);

				// Obtener datos nuevos
				Gramatica grama = new Gramatica(ruta);
				String coleccionCanonica = ColeccionCanonica.hacer(grama).getProceso();

				// Modificar datos
				rellenarComponentes(grama.stringSimbolosNoTerminales(), grama.stringSimbolosTerminales(), grama.getSimboloInicial(), grama.stringGramatica(), coleccionCanonica);

			}
		});

		// Agregar elementos al panel Archivo
		panelArchivo.add(lblArchivoGramatica);
		panelArchivo.add(textRutaArchivoGramatica);
		panelArchivo.add(botonBuscarGramatica);

		// Mostrar la ruta del archivo del Programa
		lblArchivoPrograma = new JLabel("Programa:");
		lblArchivoPrograma.setPreferredSize(new Dimension(80, altoElementos));

		textRutaArchivoPrograma = new JTextField("src/ArchivosExtra/programa.js");
		textRutaArchivoPrograma.setPreferredSize(new Dimension(600, altoElementos));
		textRutaArchivoPrograma.setEditable(false);
		textRutaArchivoPrograma.setBorder(BorderFactory.createCompoundBorder(textRutaArchivoPrograma.getBorder(), padding));

		// Boton para buscar otro archivo
		botonBuscarPrograma = new JButton("Buscar Archivo Programa");
		botonBuscarPrograma.setPreferredSize(new Dimension(160, altoElementos));

		// Agregar Accion al boton
		botonBuscarPrograma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener nueva ruta dle archivo
				String ruta = Archivo.obtenerRutaArchivo(estaVentana);

				editarRutaArchivo(ruta);

				// Obtener datos nuevos

				// Modificar datos

			}
		});

		// Agregar elementos al panel Archivo
		panelArchivo.add(lblArchivoPrograma);
		panelArchivo.add(textRutaArchivoPrograma);
		panelArchivo.add(botonBuscarPrograma);


		/** Mostrar Simbolos de la gramatica */

		// Propiedades del panel Informacion
		panelInformacion = new JPanel();
		panelInformacion.setPreferredSize(new Dimension(500, 128));
		panelInformacion.setLayout(diseñoPanel);

		// Mostrar los simbolos no terminales
		lblSimbolosNoTerminales = new JLabel("Símbolos no Terminales");
		lblSimbolosNoTerminales.setPreferredSize(new Dimension(120, altoElementos));

		textNoTerminales = new JTextField();
		textNoTerminales.setPreferredSize(new Dimension(300, altoElementos));
		textNoTerminales.setEditable(false);
		textNoTerminales.setBorder(BorderFactory.createCompoundBorder(textNoTerminales.getBorder(), padding));

		// Mostrar los simbolos terminales
		lblSimbolosTerminales = new JLabel("Símbolos Terminales: ");
		lblSimbolosTerminales.setPreferredSize(new Dimension(120, altoElementos));

		textTerminales = new JTextField();
		textTerminales.setPreferredSize(new Dimension(300, altoElementos));
		textTerminales.setEditable(false);
		textTerminales.setBorder(BorderFactory.createCompoundBorder(textTerminales.getBorder(), padding));

		// Mostrar Simbolo Inicial
		lblSimboloInicial = new JLabel("Símbolo Inicial:");
		lblSimboloInicial.setPreferredSize(new Dimension(120, altoElementos));

		textSimboloInicial = new JTextField();
		textSimboloInicial.setPreferredSize(new Dimension(300, altoElementos));
		textSimboloInicial.setEditable(false);
		textSimboloInicial.setBorder(BorderFactory.createCompoundBorder(textSimboloInicial.getBorder(), padding));

		// Agregar elementos al panel Informacion
		panelInformacion.add(lblSimbolosNoTerminales);
		panelInformacion.add(textNoTerminales);
		panelInformacion.add(lblSimbolosTerminales);
		panelInformacion.add(textTerminales);
		panelInformacion.add(lblSimboloInicial);
		panelInformacion.add(textSimboloInicial);

		/** Panel de Resultados */

		// Propiedades del panel de Resultado
		panelResultado = new JPanel();
		panelResultado.setPreferredSize(new Dimension(960, 470));
		panelResultado.setLayout(diseñoPanel);
		Font fuenteResultado = new Font("Arial", Font.PLAIN, 16);

		// Mostrar Etiqueta Gramatica
		lblGramatica = new JLabel("Gramática");
		lblGramatica.setPreferredSize(new Dimension(237, altoElementos));

		// Mostrar Etiqueta Coleccion Canonica
		lblColeccionCanonica = new JLabel("Colección Canonica:");
		lblColeccionCanonica.setPreferredSize(new Dimension(700, altoElementos));

		// Mostrar Contenido de la Gramatica
		areaGramatica = new JTextArea();
		areaGramatica.setPreferredSize(new Dimension(237, 470 - altoElementos - 20));
		areaGramatica.setEditable(false);
		areaGramatica.setFont(fuenteResultado);
		areaGramatica.setBorder(BorderFactory.createCompoundBorder(areaGramatica.getBorder(), paddingTextArea));

		// Mostrar Coleccion Canonica
		areaColeccionCanonica = new JTextArea();
		areaColeccionCanonica.setPreferredSize(new Dimension(700, 470 - altoElementos - 20));
		areaColeccionCanonica.setEditable(false);
		areaColeccionCanonica.setFont(fuenteResultado);
		areaColeccionCanonica
				.setBorder(BorderFactory.createCompoundBorder(areaColeccionCanonica.getBorder(), paddingTextArea));

		// Agregar elementos al panel resultado
		panelResultado.add(lblGramatica);
		panelResultado.add(lblColeccionCanonica);
		panelResultado.add(areaGramatica);
		panelResultado.add(areaColeccionCanonica);
		panelResultado.setBackground(Color.BLUE);

		// Agregar componente a la Ventana
		this.add(panelArchivo);
		this.add(panelInformacion);
		this.add(panelResultado);
	}

	private void rellenarComponentes(String noTerminales, String terminales, String simboloInicial, String gramatica,
			String coleccionCanonica) {
		textNoTerminales.setText(noTerminales);
		textTerminales.setText(terminales);
		textSimboloInicial.setText(simboloInicial);
		areaGramatica.setText(gramatica);
		areaColeccionCanonica.setText(coleccionCanonica);
	}

	private void editarRutaArchivo(String nuevaRuta) {
		textRutaArchivoGramatica.setText(nuevaRuta);
	}

}