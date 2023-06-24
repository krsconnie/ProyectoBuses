package Visual;

import org.example.Asiento;

import java.awt.Image;

/**
 * La clase AsientoVisual es una clase wrapper de la clase Asiento que proporciona métodos visuales adicionales.
 */
public class AsientoVisual {
    private Asiento asiento;
    private Image imagen;
    private int posicionX;
    private int posicionY;

    /**
     * Constructor de la clase AsientoVisual.
     *
     * @param numero el número del asiento
     */
    public AsientoVisual(int numero) {
        asiento = new Asiento();
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

