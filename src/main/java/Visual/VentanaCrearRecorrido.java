package Visual;
import org.example.Bus;
import org.example.NoRecorridoException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase VentanaCrearRecorrido representa una ventana para crear un recorrido.
 * Hereda de JFrame y contiene varios componentes como etiquetas, combo boxes,
 * campos de texto y botones para seleccionar y capturar información sobre la ruta,
 * fecha y hora del recorrido a crear.
 */
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
    private Bus.Recorrido recorrido;
    ArrayList<Bus> buses;

    private Bus bus;

    VentanaReservarAsiento ventanaReservarAsiento;
    VentanaCancelarReserva ventanaCancelarReserva;
    ArrayList<Bus.Recorrido> recorridos;
    private ArrayList<String> horarios;
    private ArrayList<String> fechas;


    /**
     * La clase VentanaCrearRecorrido representa una ventana para crear un recorrido.
     * Hereda de JFrame y contiene varios componentes como etiquetas,
     * campos de texto y botones para seleccionar y capturar información sobre la ruta,
     * fecha y hora del recorrido a crear.
     */
    public VentanaCrearRecorrido() {


        recorridos = new ArrayList<Bus.Recorrido>(); // Asigna la lista a la variable miembro recorridos
        fechas = new ArrayList<>();
        horarios = new ArrayList<>();
        buses = new ArrayList<>();

        // Parametros de la ventana submenú
        setTitle("Crear Recorrido");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creacion de panel
        panel = new JPanel();

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar imagen de fondo
                ImageIcon image = new ImageIcon("resources/Fruna-Bus(1).png");
                Image backgroundImage = image.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };

        // Se añaden componentes
        lblRuta = new JLabel("Ruta:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");
        cmbRuta = new JComboBox<>(new String[]{"Santiago_Concepcion", "Chillan_Concepcion", "LosAngeles_Concepcion", "Concepcion_Santiago", "Concepcion_LosAngeles", "Concepcion_Chillan"});
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

        // Se añade el panel a la ventana
        add(panel);

        // Creación de eventos específicos
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Captura de los valores seleccionados y escritos en los campos
                String ruta = cmbRuta.getSelectedItem().toString();
                int dia = cmbDia.getItemAt(cmbDia.getSelectedIndex());
                int mes = cmbMes.getItemAt(cmbMes.getSelectedIndex());
                String fecha = String.format("%02d/%02d", dia, mes);
                String hora = txtHora.getText();

                // Impresión de la información seleccionada
                System.out.println("Ruta: " + ruta);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);

                recorrido = Bus.Recorrido.valueOf(ruta);
                recorridos.add(recorrido);
                fechas.add(fecha);
                horarios.add(hora);
                 //Se cierra la ventana tras finalizar
                dispose();
            }
        });
        if(buses != null){
            ventanaReservarAsiento = new VentanaReservarAsiento(buses);
            ventanaCancelarReserva = new VentanaCancelarReserva();
            ventanaReservarAsiento.setBuses(buses);
        }
        ventanaReservarAsiento.setVentanaCancelarReserva(ventanaCancelarReserva);
    }

    /**
     * Genera y devuelve un arreglo de enteros que representa los días del mes (1 al 31).
     *
     * @return Un arreglo de enteros con los días del mes.
     */
    public Integer[] generateDayArray() {
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1;
        }
        return days;
    }

    /**
     * Genera y devuelve un arreglo de enteros que representa los meses del año (1 al 12).
     *
     * @return Un arreglo de enteros con los meses del año.
     */
    public Integer[] generateMonthArray() {
        Integer[] months = new Integer[12];
        for (int i = 0; i < 12; i++) {
            months[i] = i + 1;
        }
        return months;
    }
    /**
     * Obtiene el número de buses creados en la lista de recorridos.
     *
     * @return el número de buses creados
     * @throws NoRecorridoException si no hay recorridos (la lista está vacía)
     */
    public int getNumBuses()throws NoRecorridoException{
        if(recorridos.size() != 0){
            return recorridos.size();
        } else {
            throw new NoRecorridoException("No hay recorridos");
        }
    }

    /**
     * Obtiene el recorrido del bus en la posición i.
     *
     * @param i Indice del bus.
     * @return El recorrido del bus.
     */
    public Bus.Recorrido getRuta(int i){
            return recorridos.get(i);
    }
    /**
     * Obtiene la fecha del bus en la posición i.
     *
     * @param i Indice del bus.
     * @return La fecha del bus en formato "dd/MM".
     */
    public String getFecha(int i){
        return fechas.get(i);
    }
    /**
     * Obtiene el horario del bus en la posición i.
     *
     * @param i Indice del bus.
     * @return El horario del bus.
     */
    public String getHorario(int i){
        return horarios.get(i);
    }

    /**
     * Crea objetos de la clase Bus con los datos de los recorridos y horarios seleccionados,
     * y los agrega a la lista de buses disponibles en la ventana de reserva de asientos.
     */
    public void CrearBuses() throws NoRecorridoException {
        for (int i = 0; i < getNumBuses(); i++) {
            Bus.Recorrido recorrido = getRuta(i);
            if (recorrido != null) {
                bus = new Bus(recorrido);
                bus.setHorario(horarios.get(i));
                bus.setFecha(fechas.get(i));
                buses.add(bus);
            } else {
                throw new NoRecorridoException("No hay recorridos válidos para crear los buses");
            }
        }
        ventanaReservarAsiento.setBuses(buses);

    }
    /**
     * Obtiene el objeto Bus en la posición i de la lista de buses disponibles.
     *
     * @param i Indice del bus en la lista.
     * @return El objeto Bus en la posición i.
     */
    public Bus getBus(int i){
        return buses.get(i);
    }
}
