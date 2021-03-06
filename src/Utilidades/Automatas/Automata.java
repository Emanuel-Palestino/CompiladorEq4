package Utilidades.Automatas;

import java.util.ArrayList;

import Utilidades.Alfabeto.Alfabeto;
import Utilidades.Listas.*;

public class Automata {
	private String id;
	private int totalEstados;
	private ListaDoblementeEnlazada[] adyacencia;
	private Alfabeto alfabeto;

	public Automata() {
		id = null;
		totalEstados = 0;
		adyacencia = null;
		alfabeto = null;
	}

	public Automata(Automata a) {
		totalEstados = a.getNumEstados();
		adyacencia = new ListaDoblementeEnlazada[totalEstados];
		for (int i = 0; i < totalEstados; i++) {
			try {
				adyacencia[i] = new ListaDoblementeEnlazada(a.getTransiciones(i));
			} catch (NullPointerException e) {
				System.out.println("Advertencia El estado (" + i + ") no contiene transiciones.");
			}
		}
	}

	public Automata(int totalE) {
		id = null;
		totalEstados = totalE;
		adyacencia = new ListaDoblementeEnlazada[totalEstados];
	}

	public Automata(String simbolo) {
		id = simbolo;
		totalEstados = 2;
		adyacencia = new ListaDoblementeEnlazada[totalEstados];
		this.insertarTransicion(0, 1, simbolo);
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public int getNumEstados() {
		return totalEstados;
	}

	public ListaDoblementeEnlazada getTransiciones(int estado) {
		return adyacencia[estado];
	}

	public Alfabeto getAlfabeto() {
		return alfabeto;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumEstados(int t) {
		totalEstados = t;
	}

	public void setAlfabeto(Alfabeto alf) {
		alfabeto = alf;
	}

	// Metodos
	public void insertarTransicion(int estadoOrigen, int estadoDestino, String simbolo) {
		if (adyacencia[estadoOrigen] == null)
			adyacencia[estadoOrigen] = new ListaDoblementeEnlazada();
		adyacencia[estadoOrigen].insertar(estadoDestino, simbolo);
	}

	public void insertarTransiciones(int estado, ListaDoblementeEnlazada tran) {
		adyacencia[estado] = tran;
	}

	public String[] getSimbolosTransiciones(int estado) {
		ArrayList<String> resultado = new ArrayList<String>();
		NodoLista aux = null;
		try {
			aux = adyacencia[estado].getInicio();
		} catch (NullPointerException e) {
			System.out.println("Advertencia: El estado (" + estado + ") no contiene transiciones.");
		}
		while (aux != null) {
			resultado.add(aux.getSimbolo());
			aux = aux.getSiguiente();
		}

		// Devolver Arreglo
		String[] res = new String[resultado.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = resultado.get(i);
		return res;
	}

	public int[] getEstadosDestinoSimbolo(int estado, String simbolo) {
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		NodoLista aux = null;
		try {
			aux = adyacencia[estado].getInicio();
		} catch (NullPointerException e) {
			System.out.println("Advertencia El estado (" + estado + ") no contiene transiciones.");
		}
		while (aux != null) {
			if (aux.getSimbolo().equals(simbolo))
				resultado.add(aux.getEstadoDestino());
			aux = aux.getSiguiente();
		}

		// Devolver Arreglo
		int[] res = new int[resultado.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = resultado.get(i);
		return res;
	}

	public String[][] getMatrizAdyacencia() {
		return new String[0][0];
	}

}