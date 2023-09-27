package controldor;

import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;
import utils.Validaciones;
import vista.UI;

public class ParaUI extends UI{
	private Libreria libreria;
	
	public ParaUI() {
		super();
		libreria = new Libreria();
		borrarCamposVista();
		botonGuardarPulsado();
		botonEliminarPulsado();
		botonSalirPulsado();
		anadirTableListener();
		botonConsultarPulsado();
		isbnValidation();
		validatePrecio();
		
	}
	
	private void validatePrecio() {
		JTextField precioText = getPrecioTextField();
		precioText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String nuevo = String.valueOf(precioText.getText() + e.getKeyChar());
				if(!Validaciones.validateNumber(nuevo)) {
					e.consume();
				}
			}
		});
	}

	private void isbnValidation() {
		JTextField isbnText = getIsbnTextFields();
		isbnText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				String numero = isbnText.getText();
				String nuevoNumero = String.valueOf(e.getKeyChar());
				if (!Validaciones.validateisbn(numero, nuevoNumero)) {
					e.consume();
					isbnTextBackground(numero.length());
				} else {
					isbnTextBackground(numero.length()+1);
				}

			}
		});
		
	}

	private void botonConsultarPulsado() {
		consultarButton.addActionListener(e -> {
			String isbn = JOptionPane.showInputDialog("introduce el ISBN");
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
