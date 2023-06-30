package Test;
import Visual.VentanaCrearRecorrido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la ventana de creación de recorridos (VentanaCrearRecorrido).
 */
public class VentanaCrearRecorridoTest {

    private VentanaCrearRecorrido ventanaCrearRecorrido;

    /**
     * Configura la instancia de VentanaCrearRecorrido antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        ventanaCrearRecorrido = new VentanaCrearRecorrido();
    }

    /**
     * Prueba para verificar el título de VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoTitle() {
        assertEquals("Crear Recorrido", ventanaCrearRecorrido.getTitle());
    }

    /**
     * Prueba para verificar el tamaño de VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoSize() {
        assertEquals(1280, ventanaCrearRecorrido.getWidth());
        assertEquals(720, ventanaCrearRecorrido.getHeight());
    }

    /**
     * Prueba para verificar la operación de cierre de VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoCloseOperation() {
        assertEquals(WindowConstants.DISPOSE_ON_CLOSE, ventanaCrearRecorrido.getDefaultCloseOperation());
    }

    /**
     * Prueba para verificar los componentes en VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoComponents() {
        JPanel panel = (JPanel) ventanaCrearRecorrido.getContentPane();
        Component[] components = panel.getComponents();

        assertEquals(8, components.length);

        assertTrue(components[0] instanceof JLabel);
        assertTrue(components[1] instanceof JComboBox);
        assertTrue(components[2] instanceof JLabel);
        assertTrue(components[3] instanceof JComboBox);
        assertTrue(components[4] instanceof JComboBox);
        assertTrue(components[5] instanceof JLabel);
        assertTrue(components[6] instanceof JTextField);
        assertTrue(components[7] instanceof JButton);
    }

    /**
     * Prueba para verificar el botón "Aceptar" en VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoAceptarButton() {
        JPanel panel = (JPanel) ventanaCrearRecorrido.getContentPane();
        JButton btnAceptar = (JButton) panel.getComponent(7);

        assertNotNull(btnAceptar);
        assertEquals("Aceptar", btnAceptar.getText());

        // Simular clic en el botón "Aceptar" y verificar que la ventana se cierre
        btnAceptar.doClick();
        assertFalse(ventanaCrearRecorrido.isVisible());
    }

    /**
     * Prueba para verificar el arreglo de días en VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoDayArray() {
        Integer[] expectedDays = new Integer[31];
        for (int i = 0; i < 31; i++) {
            expectedDays[i] = i + 1;
        }

        Integer[] actualDays = ventanaCrearRecorrido.generateDayArray();

        assertArrayEquals(expectedDays, actualDays);
    }

    /**
     * Prueba para verificar el arreglo de meses en VentanaCrearRecorrido.
     */
    @Test
    public void testVentanaCrearRecorridoMonthArray() {
        Integer[] expectedMonths = new Integer[12];
        for (int i = 0; i < 12; i++) {
            expectedMonths[i] = i + 1;
        }

        Integer[] actualMonths = ventanaCrearRecorrido.generateMonthArray();

        assertArrayEquals(expectedMonths, actualMonths);
    }
}
