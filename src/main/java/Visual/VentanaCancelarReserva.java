package Visual;

import org.example.Asiento;
import org.example.Bus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class VentanaCancelarReserva extends JFrame {
    private JPanel panel;
    ArrayList<Bus> buses;
    public VentanaCancelarReserva(ArrayList<Bus> buses) {
        // Parametros de la ventana
        setTitle("Cancelar Reserva");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creación de panel
        panel = new JPanel(new GridBagLayout());

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon image = new ImageIcon("resources/Fruna-Bus(3).png");
                Image backgroundImage = image.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };

        // Creación de etiqueta de mensaje
        JLabel lblMensaje = new JLabel("Pagina en construccion");
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 40));
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        // Creación de botón "Volver"
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
            }
        });

        // Configuración de restricciones de diseño
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);

        // Agregar componentes al panel
        panel.add(lblMensaje, gbc);

        gbc.gridy = 1;
        panel.add(btnVolver, gbc);

        // Agregar panel a la ventana
        add(panel);
    }
    public Bus getBus(int i){
        return buses.get(i);
    }
    public Asiento getAsiento(int j, int i) {
        if (i > 71 && i < 0) {
            return buses.get(j).getAsiento(i);
        } else {
            return null;
        }
    }
}
