package controldor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;

public class GestionTabla {
	Libreria libreria;
	
	public GestionTabla(Libreria libreria) {
		this.libreria = libreria;
	}
	
	public JTable refrescar(JTable table) {
		String[] columnas = Libro.PROPIEDADES;
		DefaultTableModel tablaCompleta = new DefaultTableModel(libreria.devolverMatrizDatosLibros(), columnas);
		table.setModel(tablaCompleta);
		return table;
	}
}
