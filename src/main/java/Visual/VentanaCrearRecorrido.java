package Visual;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearRecorrido extends JFrame {
    private JPanel panel;
    private JLabel lblRuta;
    private JLabel lblFecha;
    private JLabel lblHora;
    private JComboBox<String> cmbRuta;
    private JComboBox<Integer> cmbDia;
    private JComboBox<Integer> cmbMes;
    private JTextField txtHora;
    private JButton btnAceptar;

    public VentanaCrearRecorrido() {
        
        // Parametros de la ventana sub menu
        setTitle("Crear Recorrido");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creacion de panel
        panel = new JPanel();

        // Se añaden componentes
        lblRuta = new JLabel("Ruta:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");
        cmbRuta = new JComboBox<>(new String[]{"Santiago-Concepcion", "Chillan-Concepcion", "Los Angeles-Concepcion", "Concepcion-Santiago", "Concepcion-Los Angeles", "Concepcion-Chillan"});
        cmbDia = new JComboBox<>(generateDayArray());
        cmbMes = new JComboBox<>(generateMonthArray());
        txtHora = new JTextField(10);
        btnAceptar = new JButton("Aceptar");

        // Parametros del panel
        panel.add(lblRuta);
        panel.add(cmbRuta);
        panel.add(lblFecha);
        panel.add(cmbDia);
        panel.add(cmbMes);
        panel.add(lblHora);
        panel.add(txtHora);
        panel.add(btnAceptar);

        // Se añade panel
        add(panel);

        // Creación de eventos específicos
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ruta = cmbRuta.getSelectedItem().toString();
                int dia = cmbDia.getItemAt(cmbDia.getSelectedIndex());
                int mes = cmbMes.getItemAt(cmbMes.getSelectedIndex());
                String fecha = String.format("%02d/%02d", dia, mes);
                String hora = txtHora.getText();

                System.out.println("Ruta: " + ruta);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);

                // Se cierra tras finalizar
                dispose();
            }
        });
    }

    private Integer[] generateDayArray() {
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1;
        }
        return days;
    }

    private Integer[] generateMonthArray() {
        Integer[] months = new Integer[12];
        for (int i = 0; i < 12; i++) {
            months[i] = i + 1;
        }
        return months;
    }
    
}