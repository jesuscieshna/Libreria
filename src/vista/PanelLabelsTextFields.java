package vista;

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
	}

	public JTextField[] getListaTextFields() {
		return listaTextos;
	}
	
	public void setTextFields(String string) {
		for (JTextField jTextField : listaTextos) {
			jTextField.setText(string);
		}
	}
	
	
}
