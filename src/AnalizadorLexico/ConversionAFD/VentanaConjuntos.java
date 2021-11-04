package AnalizadorLexico.ConversionAFD;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class VentanaConjuntos extends JDialog{
    JDialog ventana;
    FlowLayout diseñoPanel;
    JPanel panelInformacion;
    JScrollPane panelTabla;
	JLabel lblAlfabeto, lblExpresionRegular;
	JTextField textAlfabeto, textExpresionRegular;
	JTable transiciones;

    public VentanaConjuntos(JFrame parent, boolean modal, String alfabeto, String expresion, String[] encabezado, String[][] datos) {
		super(parent, modal);
                
		// Iniciar componentes que se muestran en la ventana
		inicializarInformacion();
		rellenarInformacion(alfabeto, expresion);
		mostrarTabla(encabezado, datos);
		ventana.setVisible(true);
	}

	public VentanaConjuntos(JFrame parent, boolean modal) {
		super(parent, modal);
        String [] encabezado = {"Encabezado prueba"};
		String [][] datos ={
			{"Juan", "25"},
            {"Sonia", "33"},
            {"Pedro", "42"}
		};
		// Iniciar componentes que se muestran en la ventana
		inicializarInformacion();
		//rellenarInformacion(alfabeto, expresion);
		mostrarTabla(encabezado, datos);
		ventana.setVisible(true);
	}


    private void inicializarInformacion(){
        diseñoPanel = new FlowLayout(FlowLayout.LEFT, 10, 10);
		ventana = new JDialog();
		ventana.setSize(1000, 680);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setLayout(diseñoPanel);

		ventana.setTitle("Algoritmo de Construcción de Conjuntos");

        //Muestra el AFN o una expresión regular
        panelInformacion = new JPanel();
        panelInformacion.setPreferredSize(new Dimension(500,200));
        panelInformacion.setLayout(diseñoPanel);

        lblAlfabeto = new JLabel("Alfabeto: ");
        lblAlfabeto.setPreferredSize(new Dimension(200, 30));

		textAlfabeto = new JTextField();
		textAlfabeto.setPreferredSize(new Dimension(200, 30));
		textAlfabeto.setEditable(false);

		lblExpresionRegular = new JLabel("Expresión Regular:");
		lblExpresionRegular.setPreferredSize(new Dimension(200, 30));

		textExpresionRegular = new JTextField();
		textExpresionRegular.setPreferredSize(new Dimension(200, 30));
		textExpresionRegular.setEditable(false);

		// Agregar elementos al panel Informacion
		panelInformacion.add(lblAlfabeto);
		panelInformacion.add(textAlfabeto);
		panelInformacion.add(lblExpresionRegular);
		panelInformacion.add(textExpresionRegular);

		ventana.add(panelInformacion);
    }

	public void mostrarTabla(String [] encabezado, String[][] datos){
		DefaultTableModel modeloTabla = new DefaultTableModel(datos,encabezado);
		transiciones = new JTable(modeloTabla);
		transiciones.setEnabled(false);
		transiciones.getTableHeader().setReorderingAllowed(false);
		transiciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		panelTabla = new JScrollPane(transiciones);
		panelTabla.setPreferredSize(new Dimension(960,410));

		//Hacemos visible la tabla
		ventana.add(panelTabla);
	}

	public void rellenarInformacion(String alfabeto, String expresion){
		textAlfabeto.setText(alfabeto);
		textExpresionRegular.setText(expresion);
	}
}