package Visual;

import org.example.Bus;

import java.util.ArrayList;

/**
 * Representa un autobús visual que realiza un recorrido específico y tiene asientos disponibles.
 */
public class BusVisual extends Bus {
    private String imagen;
    private int posicionX;
    private int posicionY;

    /**
     * Crea una instancia de la clase BusVisual con el número de asientos y el recorrido especificados.
     *
     * @param numeroAsientos el número de asientos disponibles en el autobús
     * @param recorrido      el recorrido que realiza el autobús
     */
    public BusVisual(int numeroAsientos, Bus.Recorrido recorrido) {
        super(recorrido);
    }

    /**
     * Obtiene la imagen asignada al autobús visual.
     *
     * @return la imagen del autobús visual
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen del autobús visual.
     *
     * @param imagen la imagen del autobús visual
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la posición X del autobús visual.
     *
     * @return la posición X del autobús visual
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Establece la posición X del autobús visual.
     *
     * @param posicionX la posición X del autobús visual
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Obtiene la posición Y del autobús visual.
     *
     * @return la posición Y del autobús visual
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * Establece la posición Y del autobús visual.
     *
     * @param posicionY la posición Y del autobús visual
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * Posiciona el autobús visual en una posición específica.
     *
     * @param posicionX la posición X del autobús visual
     * @param posicionY la posición Y del autobús visual
     */
    public void posicionar(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
}
