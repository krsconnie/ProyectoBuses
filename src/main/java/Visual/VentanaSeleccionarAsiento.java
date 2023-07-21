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
    private Bus busSeleccionado;

    public VentanaSeleccionarAsiento(ArrayList<Bus> buses, Bus busSeleccionado) {
        this.busSeleccionado = busSeleccionado;

        // Parámetros de la ventana
        setTitle("Seleccionar Asiento");
        setSize(1280, 720); // Ajustar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creación de panel
        // creacion de de 4 columnas de botones que representaran los asientos
        int numAsientos = busSeleccionado.getAsientos().size();
        int numFilas = (int) Math.ceil((double) numAsientos / 4);
        panel = new JPanel(new GridLayout(numFilas, 4, 5, 5));

        // Obtener lista de asientos del bus seleccionado
        ArrayList<Asiento> asientos = busSeleccionado.getAsientos();

        // Creacion de botones que representan los asientos
        for (Asiento asiento : asientos) {
            JButton btnAsiento = new JButton(String.valueOf(asiento.getNumero()));
            actualizarEstadoAsiento(btnAsiento, asiento); // Se actualiza el color del asiento
            btnAsiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Reservar o cancelar reserva del asiento al hacer clic
                    if (asiento.getEstado() instanceof AsientoDisponible) {
                        asiento.reservar();
                    } else if (asiento.getEstado() instanceof AsientoReservado) {
                        asiento.cancelarReserva();
                    }
                    actualizarEstadoAsiento(btnAsiento, asiento); // SE actualiza el color del asiento
                }
            });
            panel.add(btnAsiento);
        }

        // Se añade panel
        add(panel);
    }

    // Se actualiza el color del asiento depéndiendo del estado
    private void actualizarEstadoAsiento(JButton btnAsiento, Asiento asiento) {
        if (asiento.getEstado() instanceof AsientoDisponible) {
            btnAsiento.setBackground(Color.GREEN);
        } else if (asiento.getEstado() instanceof AsientoReservado) {
            btnAsiento.setBackground(Color.RED);
        }
        btnAsiento.setOpaque(true);
        btnAsiento.setBorderPainted(false);
        btnAsiento.setFont(new Font("Arial", Font.BOLD, 12));
        btnAsiento.setForeground(Color.BLACK);
    }
}





