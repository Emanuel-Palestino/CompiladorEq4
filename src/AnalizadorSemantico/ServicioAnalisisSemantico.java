package AnalizadorSemantico;

import java.io.IOException;

import AnalizadorLexico.Final.EvaluarCodigo;
import AnalizadorSintactico.ConstruccionTablaLR.TablaLR;
import Utilidades.ColeccionCanonica;
import Utilidades.ResultadoAnalisisSemantico;
import Utilidades.AnalizadorLexico.ResultadoAnalisisLexico;
import Utilidades.Excepciones.ExcepcionER;
import Utilidades.Gramatica.Gramatica;

public class ServicioAnalisisSemantico {

	private Gramatica gramatica;
	private ColeccionCanonica coleccionCanonica;
	private TablaLR tablaAnalisis;
	private ResultadoAnalisisLexico resultadoLexico;
	private ResultadoAnalisisSemantico resultadoSemantico;
	private String rutaPrograma;

	public ServicioAnalisisSemantico() {
		gramatica = new Gramatica("src/ArchivosExtra/GramaticaJS/gramaticajs1.txt", "src/ArchivosExtra/AccionesSemanticasJS/accionesSemanticasG1.txt");
		coleccionCanonica = ColeccionCanonica.hacer(gramatica);
		tablaAnalisis = TablaLR.construir(coleccionCanonica, gramatica);
		resultadoLexico = new ResultadoAnalisisLexico();
		resultadoSemantico = null;
		rutaPrograma = "";
	}

	public void ejecutar(String rutaPrograma) throws IOException, ExcepcionER {
		resultadoLexico = EvaluarCodigo.evaluar(rutaPrograma);
		resultadoSemantico = AnalisisSemantico.analizar(resultadoLexico.getTokens(), resultadoLexico.getTiraTokens(),
				resultadoLexico.getTiraTokensSemantico(), gramatica, tablaAnalisis);
		this.rutaPrograma = rutaPrograma;
		gramatica.reiniciarTraduccionReglas();
	}

	public void actualizarGramatica(String rutaGramatica) throws IOException, ExcepcionER {
		String numGramatica = rutaGramatica.charAt(rutaGramatica.length() - 5) + "";
		gramatica = new Gramatica(rutaGramatica, "src/ArchivosExtra/RecursosGramaticasClase/accionSemantica" + numGramatica + ".txt");

		coleccionCanonica = ColeccionCanonica.hacer(gramatica);
		tablaAnalisis = TablaLR.construir(coleccionCanonica, gramatica);

		ejecutar(rutaPrograma);

		gramatica.reiniciarTraduccionReglas();
	}

	// Getters
	public Gramatica getGramatica() {
		return gramatica;
	}

	public ColeccionCanonica getColeccionCanonica() {
		return coleccionCanonica;
	}

	public TablaLR getTablaAnalisis() {
		return tablaAnalisis;
	}

	public ResultadoAnalisisLexico getResultadoLexico() {
		return resultadoLexico;
	}

	public ResultadoAnalisisSemantico gerResultadoSemantico() {
		return resultadoSemantico;
	}

}
