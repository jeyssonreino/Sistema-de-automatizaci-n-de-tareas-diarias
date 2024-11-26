package gui;
import java.text.DecimalFormat;
public class Redmine {
	
	private float minutos;
	private float tiempoconvertido;
	
	
	 // Getter y Setter para minutos
    public float getMinutos() {
        return minutos;
    }

    public void setMinutos(float minutos) {
        this.minutos = minutos;
    }

    // Getter y Setter para tiempoconvertido
    public float getTiempoconvertido() {
        return tiempoconvertido;
    }

    public void setTiempoconvertido(float tiempoconvertido) {
        this.tiempoconvertido = tiempoconvertido;
    }
    
    public float convertir() {
        return this.tiempoconvertido = (getMinutos() * 1) / 60;
    }
	

}
