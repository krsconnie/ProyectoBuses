package Visual;
import org.example.Regular;

import java.awt.Image;

/**
 * La clase RegularVisual es una clase wrapper de la clase Regular que proporciona métodos visuales adicionales.
 */
public class RegularVisual extends AsientoVisual {
    private Regular asiento;
    private Image imagen;
    private int posicionX;
    private int posicionY;

    /**
     * Constructor de la clase RegularVisual.
     */
    public RegularVisual() {
        asiento = new Regular();
    }

    /**
     * Asigna una imagen al asiento visual.
     *
     * @param imagen la imagen a asignar
     */
    public void asignarImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Posiciona la imagen del asiento visual en las coordenadas especificadas.
     *
     * @param posicionX la posición X de la imagen
     * @param posicionY la posición Y de la imagen
     */
    public void posicionarImagen(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
}
