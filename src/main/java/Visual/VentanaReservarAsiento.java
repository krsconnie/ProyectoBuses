package Visual;

import org.example.Asiento;
import org.example.Bus;
import org.example.SistemaReservas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * La clase VentanaReservarAsiento representa una ventana para reservar un asiento en un autobús.
 * Hereda de JFrame y contiene varios componentes como etiquetas y botones para mostrar información
 * sobre la reserva y permitir al usuario volver a la ventana anterior.
 */
public class VentanaReservarAsiento extends JFrame {
    private JPanel panel;
    ArrayList<Bus> buses;
    SistemaReservas sistema;
    VentanaCancelarReserva ventanaCancelarReserva;
    /**
     * Constructor de la clase VentanaReservarAsiento.
     * Configura los parámetros de la ventana, crea el panel y añade los componentes necesarios,
     * como una etiqueta de mensaje y un botón "Volver".
     * También define el comportamiento del botón "Volver".
     */
    public VentanaReservarAsiento(ArrayList<Bus> buses) {
        this.buses = buses;

        ventanaCancelarReserva = new VentanaCancelarReserva();
        sistema = new SistemaReservas(buses);

        // Parametros de la ventana
        setTitle("Reservar Asiento");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon image = new ImageIcon("resources/Fruna-Bus(2).png");
                Image backgroundImage = image.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new GridLayout(buses.size(), 1));

        // Botones de cada bus
        for (Bus bus : buses) {
            JButton btnBus = new JButton("Bus: " + bus.getRecorrido() + ", Fecha: " + bus.getFecha() + ", Hora: " + bus.getHorario());
            btnBus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    abrirVentanaAsientos(bus);
                }
            });
            panel.add(btnBus);
        }
        // Usamos JScrollPane en caso de que haya demasiados botones para mostrar en la ventana.
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

    }
    /**
     * Establece la lista de buses disponibles en el sistema de reservas para esta ventana.
     *
     * @param buses La lista de buses disponibles.
     */
    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    /**
     * Establece la instancia de la ventana VentanaCancelarReserva para esta ventana.
     *
     * @param ventanaCancelarReserva La instancia de VentanaCancelarReserva.
     */

    public void setVentanaCancelarReserva(VentanaCancelarReserva ventanaCancelarReserva) {
        this.ventanaCancelarReserva = ventanaCancelarReserva;
    }

    /**
     * Realiza el traspaso de la lista de buses disponibles a la ventana VentanaCancelarReserva.
     *
     * @param buses La lista de buses disponibles para la reserva.
     */
    public void traspasoBuses(ArrayList<Bus> buses){
        ventanaCancelarReserva.setBuses(buses);
    }

    // Abrir ventanas de cada bus
    private void abrirVentanaAsientos(Bus bus) {
        System.out.println("Aqui van los asientos");
    }
}
