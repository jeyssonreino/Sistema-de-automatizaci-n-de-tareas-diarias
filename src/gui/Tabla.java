package gui;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel{
	
	JTable tabla1;
	DefaultTableModel mt;
	JScrollPane sp;
	Label lbl1,lbl2;
	JTextField txt1, txt2;
	JButton btn1, btn2, btn3;
	int numNuevoRegistro;
	
	public Tabla() {
		//
		numNuevoRegistro = 1;
		//
		this.setBackground(Color.decode("#82e0aa")); // Colores hexadecimales
		this.setLayout(null);
		//
		sp = new JScrollPane();
		mt = new DefaultTableModel();
		String ids[] = {"#","Nombre","Apellido"}; // Columnas
		mt.setColumnIdentifiers(ids);
		tabla1 = new JTable(mt);
		sp.setBounds(10, 50, 480, 250);
		tabla1.setBounds(10, 50, 480, 250);
		sp.setViewportView(tabla1);
		this.add(sp);
		//
		lbl1 = new Label();
		lbl1.setText("Nombre:");
		lbl1.setBounds(490, 60, 50, 10);
		this.add(lbl1);
		//
		lbl2 = new Label();
		lbl2.setText("Apellido:");
		lbl2.setBounds(490, 90, 50, 10);
		this.add(lbl2);
		//
		txt1 = new JTextField();
		txt1.setBounds(550, 55, 100, 20);
		this.add(txt1);
		//
		txt2 = new JTextField();
		txt2.setBounds(550, 87, 100, 20);
		this.add(txt2);
		//
		btn1 = new JButton();
		btn1.setText("Guardar");
		btn1.setBounds(520, 150, 100, 30);
		btn1.addActionListener(e -> {
			guardarRegistro();
		});
		this.add(btn1);
		//
		btn2 = new JButton();
		btn2.setText("Borrar");
		btn2.setBounds(520, 190, 100, 30);
		btn2.addActionListener(e -> {
			eliminarRegistro();
		});
		this.add(btn2);
		//
		btn3 = new JButton();
		btn3.setText("Actualizar");
		btn3.setBounds(520, 230, 100, 30);
		btn3.addActionListener(e -> {
			actualizarRegistro();
		});
		this.add(btn3);
		//
	}
	
	public void guardarRegistro() {
		String nombre = txt1.getText();
		String apellido = txt2.getText();
		if (!nombre.equals("") && !apellido.equals("")) {
			mt.addRow(new Object[] {this.numNuevoRegistro, nombre, apellido});
			actualizarNumeracion();
			txt1.setText("");
			txt2.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}
	}
	
	public void eliminarRegistro() {
	    int filaSeleccionada = tabla1.getSelectedRow(); // Obtiene la fila seleccionada
	    if (filaSeleccionada != -1) { // Verifica si hay una fila seleccionada
	        mt.removeRow(filaSeleccionada); // Elimina la fila seleccionada
	        actualizarNumeracion(); 
	    } else {
	        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	public void actualizarRegistro() {
		String nombre = txt1.getText();
		String apellido = txt2.getText();	
		if (!nombre.equals("") && !apellido.equals("")) {
			mt.setValueAt(nombre, tabla1.getSelectedRow(), 1);//nuevo campo/fila/columna
			mt.setValueAt(apellido, tabla1.getSelectedRow(), 2);//nuevo campo/fila/columna
			txt1.setText("");
			txt2.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}
	}
	
    public void actualizarNumeracion() {
        for (int i = 0; i < mt.getRowCount(); i++) {
            mt.setValueAt(i + 1, i, 0); // Reasigna el valor secuencial en la columna "#"
        }
    }
	


}
