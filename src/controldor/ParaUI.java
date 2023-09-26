package controldor;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;
import vista.UI;

public class ParaUI extends UI{
	Libreria libreria;
	public ParaUI() {
		super();
		libreria = new Libreria();
		botonGuardarPulsado();
		botonEliminarPulsado();
		botonSalirPulsado();
		anadirTableListener();
		botonConsultarPulsado();
	}

	private void botonConsultarPulsado() {
		consultarButton.addActionListener(e -> {
			String isbn = JOptionPane.showInputDialog("introduce el ISBN");
			System.out.println(isbn);
			String datos = libreria.findLibro(isbn);
			
			JOptionPane.showMessageDialog(rootPane, datos);
		});
		
	}

	private void botonSalirPulsado() {
		salirButton.addActionListener(e -> dispose());
	}

	private void botonEliminarPulsado() {
		
	}

	public void botonGuardarPulsado() {
		guardarButton.addActionListener((e)->{
			Libro libro = crearLibro();
			new ControllerGuardar(libreria).control(libro);
			new GestionTabla(libreria).refrescar(librosTable);
			borrarCamposVista();
		});
	}
	
	private void anadirTableListener() {
		librosTable.addMouseListener(new MouseListener() {
			

			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = librosTable.rowAtPoint(e.getPoint());
				String isbn= (String) librosTable.getModel().getValueAt(fila, 0);
				PopupMenu menu = new PopupMenu();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
	}

	public Libro crearLibro() {
		JTextField[] textFieldLibro = getListaTextFieldsLibro();
		String[] datosLibro = new String[textFieldLibro.length];
		for (int i = 0; i < datosLibro.length; i++) {
			datosLibro[i]=textFieldLibro[i].getText();
		}
		return new Libro(datosLibro);
	}
}
