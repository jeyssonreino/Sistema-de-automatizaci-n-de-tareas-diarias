package gui;

import java.awt.Color;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame {
	
	JFrame ventana;
	JButton btn1, btnConvertir, btnLimpiarRedmine;
	Label lblMinutos, lblRedmine, lblTituloRedmine;
	JLabel imgRedmine;
	JMenu menu1;
	JMenuItem opcion1, opcion2, opcion3;
	JMenuBar menubar;
	JPanel panel1, panel2, panel3;
	JTextField txtMinutos, txtMinutosConvertidos;
	ImageIcon iconRedmine;
	
	//
	private boolean ventana2 = false;
    //
	public Display() {
		ventana = new JFrame();
		btn1 = new JButton();
		menubar = new JMenuBar();
		menu1 = new JMenu();
		opcion1 = new JMenuItem();
		opcion2 = new JMenuItem();
		opcion3 = new JMenuItem();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		lblMinutos = new Label();
		txtMinutos = new JTextField();
		btnConvertir = new JButton();
		txtMinutosConvertidos = new JTextField();
		lblRedmine = new Label();
		btnLimpiarRedmine = new JButton();
		lblTituloRedmine = new Label();
		iconRedmine = new ImageIcon(getClass().getResource("/logo_redmine.png"));
		imgRedmine = new JLabel(iconRedmine);
		Tabla tabla = new Tabla();

		//
		ventana.setVisible(true);
		ventana.setBounds(250, 100, 700, 400);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setTitle("Programas v2024");
		ventana.setLayout(null);
		ventana.setResizable(false);
		ventana.setIconImage(new ImageIcon(getClass().getResource("/p.png")).getImage());
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);
		//
		opcion1.setText("Abrir ventana");
		opcion1.addActionListener(e -> {
			panel1.setVisible(true);
			panel2.setVisible(false);
			panel3.setVisible(false);
		});
		opcion2.setText("Minutos Redmine");
		opcion2.addActionListener(e -> {
			panel1.setVisible(false);
			panel2.setVisible(true);
			panel3.setVisible(false);
		});
		opcion3.setText("Crear Tablas");
		opcion3.addActionListener(e -> {	
			tabla.setBounds(0, 0, 700, 400);
			ventana.add(tabla);
			panel1.setVisible(false);
			panel2.setVisible(false);
			tabla.setVisible(true);
		});
		menu1.setBounds(0, 0, 30, 30);
		menu1.setText("Lista de programas");
		menu1.add(opcion1);
		menu1.add(opcion2);
		menu1.add(opcion3);
		menubar.add(menu1);
		menubar.setBounds(0, 0, 700, 30);
		ventana.setJMenuBar(menubar);
		//
		btn1.setBounds(250, 60, 200, 20);
		btn1.setText("Abrir ventana 2");
		btn1.addActionListener(e -> {
	    abrirVentana2();
		});
		//panel1
		panel1.setBounds(0, 0, 700, 400);
		panel1.setBackground(Color.BLUE);
		panel1.setLayout(null);
		panel1.add(btn1);
		ventana.add(panel1);
		//label y textfield
		lblMinutos.setText("Minutos:");
		lblMinutos.setBounds(400, 90, 50, 30);
		txtMinutos.setBounds(450, 90, 150, 30);
		btnConvertir.setText("Convertir");
		btnConvertir.setBounds(450, 250, 150, 20);
		btnConvertir.addActionListener(e -> {
			if(!txtMinutos.getText().equals("")) {
				float minutos = Float.parseFloat(txtMinutos.getText());
				Redmine redmine = new Redmine();
				redmine.setMinutos(minutos);
				String tiempoconvertido = String.valueOf(redmine.convertir());
				txtMinutosConvertidos.setText(tiempoconvertido);		
			}

		});
		txtMinutosConvertidos.setBounds(450, 150, 150, 30);
		txtMinutosConvertidos.setEnabled(false);
		txtMinutosConvertidos.setForeground(Color.GREEN);
		lblRedmine.setText("Redmine:");
		lblRedmine.setBounds(370, 150, 80, 30);
		btnLimpiarRedmine.setBounds(450, 200, 150, 20);
		btnLimpiarRedmine.setText("Limpiar");
		btnLimpiarRedmine.addActionListener(e -> {
			txtMinutos.setText("");
			txtMinutosConvertidos.setText("");
		});
		lblTituloRedmine.setText("SISTEMA DE CONVERSIÓN DE MINUTOS A TIEMPO EN REDMINE");
		lblTituloRedmine.setBounds(160, 20, 500, 50);
		imgRedmine.setBounds(100, 100, 200, 200);
		//panel2
		panel2.setBounds(0, 0, 700, 400);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setLayout(null);
		panel2.add(imgRedmine);
		panel2.add(lblMinutos);
		panel2.add(txtMinutos);
		panel2.add(btnConvertir);
		panel2.add(lblRedmine);
		panel2.add(txtMinutosConvertidos);
		panel2.add(btnLimpiarRedmine);
		panel2.add(lblTituloRedmine);
		ventana.add(panel2);
		//


	}
	
	public void setVentana2(boolean ventana2) {
		this.ventana2 = ventana2;
	};
	
	public void abrirVentana2() {

		if (this.ventana2 == false) {
			Ventana2 ventana2 = new Ventana2(this);
			this.ventana2 = true;
	}
	}
	
	

}
