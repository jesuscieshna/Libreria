package vista;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLabelsTextFields extends JPanel{
	JTextField[] listaTextos;
	
	public PanelLabelsTextFields(String[] labels) {
		listaTextos = new JTextField[labels.length];
		int i=0;
		for (String label : labels) {
			this.add(new JLabel(label));
			JTextField nuevoJTextField = new JTextField();
			this.add(nuevoJTextField);
			listaTextos[i]=nuevoJTextField;
			i++;
		}
		setTextFields("");
	}

	public JTextField[] getListaTextFields() {
		return listaTextos;
	}
	
	public void setTextFields(String string) {
		for (JTextField jTextField : listaTextos) {
			jTextField.setText(string);
		}
	}
	
	public void isbnTextBackground(int length) {
		if (length < 13) {
			listaTextos[0].setBackground(new Color(255, 150, 150));
		} else {
			listaTextos[0].setBackground(new Color(255, 255, 255));
		}
	}
	
	
}
