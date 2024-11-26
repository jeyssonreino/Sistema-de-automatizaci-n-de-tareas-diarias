package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Ventana2 extends JFrame {
	

	JFrame ventana2;
	
	public Ventana2(Display display) {
		
     ventana2 = new JFrame();
     ventana2.setVisible(true);
     ventana2.setBounds(510, 90, 400, 400);
     ventana2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     ventana2.setTitle("Ventana2");
     ventana2.setLayout(null);
     ventana2.setResizable(false);
     ventana2.addWindowListener(new WindowAdapter() {
    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	        display.setVentana2(false);
    	    }
    	});
	
	}

}
