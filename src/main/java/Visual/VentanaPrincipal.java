package Visual;

import org.example.Bus;
import org.example.SistemaReservas;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * La clase VentanaPrincipal representa la ventana principal de una aplicación de venta de pasajes de buses.
 * Hereda de JFrame y contiene un panel con botones para realizar acciones principales, como crear un recorrido,
 * reservar un asiento y cancelar una reserva.
 */
public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    SistemaReservas sistemaReservas;
    VentanaCrearRecorrido ventanaCrearRecorrido;
    VentanaReservarAsiento ventanaReservarAsiento;
    VentanaCancelarReserva ventanaCancelarReserva;
    ArrayList<Bus.Recorrido> recorridos;
    ArrayList<Bus> buses;
    private Bus bus;

    /**
     * Constructor de la clase VentanaPrincipal.
     * Configura los parámetros de la ventana principal, crea el panel y agrega los botones correspondientes.
     * También define el comportamiento de los botones al ser presionados.
     */
    public VentanaPrincipal() {

        ventanaCrearRecorrido = new VentanaCrearRecorrido();
        ventanaReservarAsiento = new VentanaReservarAsiento();
        ventanaCancelarReserva = new VentanaCancelarReserva();

        // Parametros de la ventana
        setTitle("Venta de Pasajes de Buses");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de panel
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon image = new ImageIcon("resources/Fruna-Bus.png");
                Image backgroundImage = image.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

                //Inicialización sistema de reservas
                sistemaReservas = new SistemaReservas();
            }
        };

        panel.setLayout(new GridBagLayout());

        // Creación de botones
        JButton btnCrearRecorrido = new JButton("Crear recorrido");
        JButton btnReservarAsiento = new JButton("Reservar asiento");
        JButton btnCancelarReserva = new JButton("Cancelar reserva");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Se agregan botones de acciones principales
        panel.add(btnCrearRecorrido, gbc);

        gbc.gridy = 1;
        panel.add(btnReservarAsiento, gbc);

        gbc.gridy = 2;
        panel.add(btnCancelarReserva, gbc);


        // Se añade panel a la ventana principal
        add(panel);

        // Creación de eventos para los botones
        btnCrearRecorrido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se muestra la ventana para crear un recorrido
                ventanaCrearRecorrido.setVisible(true);
            }
        });
        btnReservarAsiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se muestra la ventana para reservar un asiento
                ventanaReservarAsiento.setVisible(true);
            }
        });
        btnCancelarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se muestra la ventana para cancelar una reserva
                ventanaCancelarReserva.setVisible(true);
            }
        });
    }
    public void CrearBuses() {
        for (int i = 0; i < ventanaCrearRecorrido.getNumBuses(); i++) {
            Bus.Recorrido recorrido = ventanaCrearRecorrido.getRuta(i);
            if (recorrido != null) {
                bus = new Bus(recorrido);
            }
            buses.add(bus);
        }
    }
}
