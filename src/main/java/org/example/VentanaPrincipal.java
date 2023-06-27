package org.example;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;

    public VentanaPrincipal() {
        // Parametros de la ventana
        setTitle("Venta de Buses");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de panel
        panel = new JPanel();

        // Creación de botones
        JButton btnCrearRecorrido = new JButton("Crear recorrido");
        JButton btnReservarAsiento = new JButton("Reservar asiento");
        JButton btnCancelarReserva = new JButton("Cancelar reserva");

        // Se agregan botones de acciones principales
        panel.add(btnCrearRecorrido);
        panel.add(btnReservarAsiento);
        panel.add(btnCancelarReserva);

        // Se añade panel
        add(panel);

        // Creación de eventos (en proceso)
        btnCrearRecorrido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se castea el sub menu
                VentanaCrearRecorrido ventanaCrearRecorrido = new VentanaCrearRecorrido();
                ventanaCrearRecorrido.setVisible(true);
            }
        });

        btnReservarAsiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón "Reservar asiento"
                System.out.println("Se ha hecho clic en el botón 'Reservar asiento'");
            }
        });

        btnCancelarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón "Cancelar reserva"
                System.out.println("Se ha hecho clic en el botón 'Cancelar reserva'");
            }
        });
    }
}