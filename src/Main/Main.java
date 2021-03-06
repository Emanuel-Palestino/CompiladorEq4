package Main;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import Utilidades.Excepciones.ExcepcionER;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ExcepcionER, FontFormatException {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo Windows");
		}

		new VentanaPrincipal();
	}
}
