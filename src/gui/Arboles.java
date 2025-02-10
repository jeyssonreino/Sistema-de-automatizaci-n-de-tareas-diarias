package gui;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.io.*;

public class Arboles extends JPanel {

	JTree arbol;
	JTextArea texto;
	JScrollPane scroll;

	public Arboles() {
		this.setLayout(null);
		this.setBackground(Color.decode("#f7dc6f"));
		//
		DefaultMutableTreeNode tablas = new DefaultMutableTreeNode("Tablas");
		DefaultMutableTreeNode reeef = new DefaultMutableTreeNode("REEF");
		DefaultMutableTreeNode iaxis = new DefaultMutableTreeNode("IAXIS");
		//
		DefaultTreeModel modelo = new DefaultTreeModel(tablas);
		modelo.insertNodeInto(reeef, tablas, 0);
		modelo.insertNodeInto(iaxis, tablas, 1);

		arbol = new JTree(modelo);
		arbol.setBounds(0, 0, 200, 400);
		arbol.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				try {
					texto.setText("");
					String seleccion = arbol.getLastSelectedPathComponent().toString();

					switch (seleccion) {
					case "REEF":
						muestraContenido("./src/resources/mapfre.txt");
						break;
					case "IAXIS":
						muestraContenido("./src/resources/iaxis.txt");
					break;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scroll = new JScrollPane(arbol);
		scroll.setBounds(0, 0, 200, 400);
		this.add(scroll);

		// Texto
		texto = new JTextArea();
		texto.setBounds(200, 0, 500, 400);
		texto.setBackground(Color.DARK_GRAY);
		texto.setForeground(Color.WHITE);
		texto.setEditable(false);
		texto.setWrapStyleWord(false);

		JScrollPane scrollPane = new JScrollPane(texto);
		scrollPane.setBounds(200, 0, 500, 400);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);

	}

	// Metodo para leer un archivo .txt en un TextArea
	public void muestraContenido(String name) throws IOException {
		String linea;
		FileReader f = new FileReader(name);
		BufferedReader b = new BufferedReader(f);
		do {
			linea = b.readLine();
			if (linea != null) {
				texto.setText(texto.getText() + linea + "\n");
			}
		} while (linea != null);
	}
}
