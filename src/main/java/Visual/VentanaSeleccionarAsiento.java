package Visual;

import org.example.Asiento;
import org.example.Bus;
import org.example.AsientoDisponible;
import org.example.AsientoReservado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaSeleccionarAsiento extends JFrame {
    private JPanel panel;
    private Bus bus;
    private ArrayList<Asiento> asientos;

    public VentanaSeleccionarAsiento(Bus bus) {
        this.bus = bus;
        this.asientos = new ArrayList<>();

        // Se ajusta la ventana
        setTitle("Seleccionar Asiento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creación de panel
        panel = new JPanel(new GridLayout(6, 10, 5, 5));

        // Creación de asientos disponibles y agregándolos a la lista de asientos
        for (int i = 1; i <= 60; i++) {
            Asiento asiento = new Asiento();
            asiento.setEstado(new AsientoDisponible());
            asientos.add(asiento);
        }

        // Botones de asientos
        for (Asiento asiento : asientos) {
            JButton btnAsiento = new JButton(String.valueOf(asiento.getNumero()));
            actualizarEstadoAsiento(btnAsiento, asiento); // Se cambia el color
            btnAsiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Reserva o cancelacion de asiento
                    if (asiento.getEstado() instanceof AsientoDisponible) {
                        asiento.reservar();
                    } else if (asiento.getEstado() instanceof AsientoReservado) {
                        asiento.cancelarReserva();
                    }
                    actualizarEstadoAsiento(btnAsiento, asiento); // Se cambia el color
                }
            });
            panel.add(btnAsiento);
        }

        add(panel);
    }

    // Sincroniza el color con el estado del asiento
    private void actualizarEstadoAsiento(JButton btnAsiento, Asiento asiento) {
        if (asiento.getEstado() instanceof AsientoDisponible) {
            btnAsiento.setBackground(Color.GREEN);
        } else if (asiento.getEstado() instanceof AsientoReservado) {
            btnAsiento.setBackground(Color.RED);
        }
    }
}