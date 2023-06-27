package org.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearRecorrido extends JFrame {
    private JPanel panel;
    private JLabel lblDestino;
    private JLabel lblFecha;
    private JLabel lblHora;
    private JTextField txtDestino;
    private JTextField txtFecha;
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
        lblDestino = new JLabel("Destino:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");
        txtDestino = new JTextField(20);
        txtFecha = new JTextField(10);
        txtHora = new JTextField(10);
        btnAceptar = new JButton("Aceptar");

        // Parametros del panel
        panel.add(lblDestino);
        panel.add(txtDestino);
        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(lblHora);
        panel.add(txtHora);
        panel.add(btnAceptar);

        // Se añade panel
        add(panel);

        // Creación de eventos específicos
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String destino = txtDestino.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();

                System.out.println("Destino: " + destino);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);

                // Se cierra tras finalizar
                dispose();
            }
        });
    }
}
