package Visual;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;

    public VentanaPrincipal() {
        // Parametros de la ventana
        setTitle("Venta de Pasajes de Buses");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de panel
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon image = new ImageIcon("resources/TW_BUS.jpg");
                Image backgroundImage = image.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
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