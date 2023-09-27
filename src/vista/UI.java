package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Libro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JLabel libreriaText;
	protected JTextField tituloTxt;
	protected JTextField autorTxt;
	protected JTextField editorialTxt;
	protected JTextField precioTxt;
	protected JTextField isbnTxt;
	protected JButton guardarButton;
	protected JTable librosTable;
	private PanelLabelsTextFields panelLibro;
	protected JScrollPane scrollPane;
	protected JButton borrarButton;
	protected JButton salirButton;
	protected JButton consultarButton;
	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSueperior = new JPanel();
		panelSueperior.setBackground(new Color(202, 232, 231));
		contentPane.add(panelSueperior, BorderLayout.NORTH);
		panelSueperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		libreriaText = new JLabel("Libreria");
		libreriaText.setHorizontalAlignment(SwingConstants.CENTER);
		panelSueperior.add(libreriaText);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		guardarButton = new JButton("Guardar");
		panelInferior.add(guardarButton);
		
		consultarButton = new JButton("Consultar");
		panelInferior.add(consultarButton);
		
		borrarButton = new JButton("Borrar");
		panelInferior.add(borrarButton);
		
		salirButton = new JButton("Salir");
		panelInferior.add(salirButton);
		
		JTabbedPane panelCentral = new JTabbedPane(JTabbedPane.TOP);
		panelCentral.setBackground(new Color(202, 232, 231));
		panelCentral.setForeground(new Color(0, 0, 0));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		
		panelLibro = new PanelLabelsTextFields(Libro.PROPIEDADES);
		
		panelLibro.setBackground(new Color(202, 232, 231));
		panelLibro.setForeground(new Color(0, 0, 0));
		panelCentral.addTab("Libro", null, panelLibro, null);
		panelCentral.setBackgroundAt(0, new Color(255, 255, 128));
		panelLibro.setLayout(new GridLayout(Libro.PROPIEDADES.length, 2, 0, 0));
		
//		JLabel lblIsbn = new JLabel("Isbn");
//		panelLibro.add(lblIsbn);
//		
//		isbnTxt = new JTextField();
//		panelLibro.add(isbnTxt);
//		isbnTxt.setColumns(10);
//		
//		JLabel lblTitulo = new JLabel("Titulo");
//		panelLibro.add(lblTitulo);
//		
//		tituloTxt = new JTextField();
//		panelLibro.add(tituloTxt);
//		tituloTxt.setColumns(10);
//		
//		JLabel lblAutor = new JLabel("Autor");
//		panelLibro.add(lblAutor);
//		
//		autorTxt = new JTextField();
//		panelLibro.add(autorTxt);
//		autorTxt.setColumns(10);
//		
//		JLabel lblEditorial = new JLabel("Editorial");
//		panelLibro.add(lblEditorial);
//		
//		editorialTxt = new JTextField();
//		panelLibro.add(editorialTxt);
//		editorialTxt.setColumns(10);
//		
//		JLabel lblprecio = new JLabel("Precio");
//		panelLibro.add(lblprecio);
//		
//		precioTxt = new JTextField();
//		panelLibro.add(precioTxt);
//		precioTxt.setColumns(10);
//		
		JPanel panelEstanteria = new JPanel();
		panelEstanteria.setBackground(new Color(202, 232, 231));
		panelCentral.addTab("Estanteria", null, panelEstanteria, null);
		panelEstanteria.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		panelEstanteria.add(scrollPane);
		
		librosTable = new JTable();
		scrollPane.setViewportView(librosTable);
		panelCentral.setBackgroundAt(1, new Color(0, 0, 0));
		
		
	}
	
	protected void borrarCamposVista() {
		panelLibro.setTextFields("");
	}
	
	protected JTextField[] getListaTextFieldsLibro() {
		return panelLibro.getListaTextFields();
	}
	
	protected JTextField getIsbnTextFields() {
		return panelLibro.getListaTextFields()[0];
	}
	
	protected void isbnTextBackground(int length) {
		panelLibro.isbnTextBackground(length);
	}
	
	protected JTextField getPrecioTextField() {
		return panelLibro.getListaTextFields()[4];
	}
}
