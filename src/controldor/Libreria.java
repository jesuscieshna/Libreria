package controldor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Libro;

public class Libreria {
	private ArrayList<Libro> arrayLibro;
	
	public Libreria() {
		arrayLibro = new ArrayList<>();
	}
	
	public void anadirLibro(Libro libro) {
		arrayLibro.add(libro);
	}
	
	public void borrarLibro(Libro libro) {
		arrayLibro.remove(libro);
	}
	
	public void borrarLibro(String isbn) {
		Iterator<Libro> iterator = arrayLibro.iterator();
		Libro auxiliar;
		while(iterator.hasNext()) {
			auxiliar=iterator.next();
			if(isbn.equals(auxiliar.getIsbn())) {
				iterator.remove();
			}
		}
	}
	
	public String[][] devolverMatrizDatosLibros(){
		String[][] matrizDatosLibros = new String[arrayLibro.size()][Libro.PROPIEDADES.length];
		for (int i = 0; i < matrizDatosLibros.length; i++) {
			matrizDatosLibros[i]=arrayLibro.get(i).devolverDatosLibro();
		}
		
		return matrizDatosLibros;
	}

	public String findLibro(String isbn) {
		Libro libroEncontrado = arrayLibro.stream().filter(libro -> libro.getIsbn().equals(isbn)).collect(Collectors.toList()).get(0);
		return libroEncontrado.toString();
	}
	
}
