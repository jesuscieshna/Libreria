package controldor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;

public class ControllerGuardar{
	Libreria libreria;
	public ControllerGuardar(Libreria libreria) {
		this.libreria = libreria;
	}

	public void control(Libro libro) {
		libreria.anadirLibro(libro);
	}
	

	
}
