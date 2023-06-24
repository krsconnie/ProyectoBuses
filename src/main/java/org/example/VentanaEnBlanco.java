package org.example;
import javax.swing.JFrame;

public class VentanaEnBlanco {
    // Crear una instancia de JFrame

    public void VentanaEnBlanco() {
        JFrame ventana = new JFrame("Ventana en blanco");

        // Configurar el tamaño de la ventana
        ventana.setSize(400, 300);

        // Terminar el programa cuando se cierra la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mostrar la ventana en pantalla
        ventana.setVisible(true);
    }
}
