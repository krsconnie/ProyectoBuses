package Test;

import Visual.VentanaPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la carga de la imagen de fondo en VentanaPrincipal.
 */
public class VentanaPrincipalTest {

    private VentanaPrincipal ventanaPrincipal;

    /**
     * Configura la instancia de VentanaPrincipal antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        ventanaPrincipal = new VentanaPrincipal();
    }

    /**
     * Prueba para verificar la carga de la imagen de fondo.
     */
    @Test
    public void testCargarImagenFondo() {
        try {
            ImageIcon image = new ImageIcon("resources/TW_BUS.jpg");
            assertNotNull("La imagen no debería ser nula", (Supplier<String>) image);
        } catch (Exception e) {
            fail("Se produjo una excepción al cargar la imagen de fondo: " + e.getMessage());
        }
    }

    /**
     * Prueba para verificar el título de VentanaPrincipal.
     */
    @Test
    public void testVentanaPrincipalTitle() {
        assertEquals("Venta de Pasajes de Buses", ventanaPrincipal.getTitle());
    }

    /**
     * Prueba para verificar el tamaño de VentanaPrincipal.
     */
    @Test
    public void testVentanaPrincipalSize() {
        assertEquals(1280, ventanaPrincipal.getWidth());
        assertEquals(720, ventanaPrincipal.getHeight());
    }

    /**
     * Prueba para verificar la existencia del panel en VentanaPrincipal.
     */
    @Test
    public void testVentanaPrincipalPanel() {
        JPanel panel = (JPanel) ventanaPrincipal.getContentPane();
        assertNotNull(panel);
    }

    /**
     * Prueba para verificar la existencia del botón "Crear recorrido" en VentanaPrincipal.
     */
    @Test
    public void testBotonCrearRecorrido() {
        JPanel panel = (JPanel) ventanaPrincipal.getContentPane();
        Component[] components = panel.getComponents();
        JButton btnCrearRecorrido = null;

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals("Crear recorrido")) {
                    btnCrearRecorrido = button;
                    break;
                }
            }
        }
        assertNotNull(btnCrearRecorrido);
    }
}
