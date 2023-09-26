package modelo;

import java.util.Iterator;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private float precio;
	private String formato;
	private String edicion;
	private int stock;
	public static final String[] PROPIEDADES = {"Isbn", "Titulo", "Autor",
												"Editorial", "Precio", "Formato",
												"Edicion", "Stock"};
	public static final String[] FORMATOS=null;
	
	public Libro(String[] libroData) {
		isbn=libroData[0];
		titulo=libroData[1];
		autor=libroData[2];
		editorial=libroData[3];
		precio=Float.valueOf(libroData[4]);
		formato=libroData[5];
		edicion=libroData[6];
		stock=Integer.valueOf(libroData[7]);
	}
	
	public String[] devolverDatosLibro() {
		String[] datos = new String[PROPIEDADES.length];
		datos[0]=isbn;
		datos[1]=titulo;
		datos[2]=autor;
		datos[3]=editorial;
		datos[4]=String.valueOf(precio);
		datos[5]=formato;
		datos[6]=edicion;
		datos[7]=String.valueOf(stock);
		return datos;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", precio=" + precio + ", formato=" + formato + ", edicion=" + edicion + ", stock=" + stock + "]";
	}
	
	
	
	
	

	

	
	
}
