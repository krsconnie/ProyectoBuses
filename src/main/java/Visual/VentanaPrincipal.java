package Visual;

import org.example.NoHayBusesException;
import org.example.NoRecorridoException;
import org.example.SistemaReservas;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase VentanaPrincipal representa la ventana principal de una aplicación de venta de pasajes de buses.
 * Hereda de JFrame y contiene un panel con botones para realizar acciones principales, como crear un recorrido,
 * reservar un asiento y cancelar una reserva.
 */
public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private SistemaReservas sistemaReservas;
    private VentanaCrearRecorrido ventanaCrearRecorrido;

    /**
     * Constructor de la clase VentanaPrincipal.
     * Configura los parámetros de la ventana principal, crea el panel y agrega los botones correspondientes.
     * También define el comportamiento de los botones al ser presionados.
     */
    public VentanaPrincipal() {
        // Creación de la ventana para crear recorridos
        ventanaCrearRecorrido = new VentanaCrearRecorrido();

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

                // Inicialización sistema de reservas
                sistemaReservas = new SistemaReservas(ventanaCrearRecorrido.buses);
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
                if (ventanaCrearRecorrido.recorridos.size() != 0) {
                    try {
                        ventanaCrearRecorrido.CrearBuses();
                    } catch (NoRecorridoException ex) {
                        throw new RuntimeException(ex);
                    }
                    // Se muestra la ventana para reservar un asiento
                    ventanaCrearRecorrido.ventanaReservarAsiento.setVisible(true);
                } else {
                    // Manejo de la excepción NoHayBusesException
                    JOptionPane.showMessageDialog(null, "No hay buses disponibles para realizar reservas.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnCancelarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ventanaCrearRecorrido.recorridos.size() != 0) {
                    // Se muestra la ventana para cancelar una reserva
                    ventanaCrearRecorrido.ventanaCancelarReserva.setVisible(true);
                } else {
                    // Manejo de la excepción NoHayBusesException
                    JOptionPane.showMessageDialog(null, "No hay buses disponibles para realizar esta acción.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}