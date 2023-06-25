package org.example;

/**
 * La clase Asiento representa un asiento en un autobús.
 */
public class Asiento {
    private EstadoAsiento estado = new AsientoDisponible();
    private int numero;
    private String categoria;
    private String ubicacion;
    private static int precio;

    /**
     * Constructor de la clase Asiento.
     */
    public void Asiento() {
    }

    /**
     * Establece el estado del asiento.
     *
     * @param estado el estado del asiento
     */
    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    /**
     * Reserva el asiento.
     */
    public void reservar() {
        estado.reservar(this);
    }

    /**
     * Cancela la reserva del asiento.
     */
    public void cancelarReserva() {
        estado.cancelarReserva(this);
    }

    /**
     * Obtiene el estado actual del asiento.
     *
     * @return el estado del asiento
     */
    public EstadoAsiento getEstado() {
        return estado;
    }

    /**
     * Obtiene el número del asiento.
     *
     * @return el número del asiento
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Se especifica el número del asiento
     * @param n */
    public void setNumero(int n){
        numero = n;
    }

    /**
     * Obtiene la categoría del asiento.
     *
     * @return la categoría del asiento
     */
    public String queCategoria() {
        return this.categoria;
    }

    /**
     * Obtiene el precio base del asiento.
     *
     * @return el precio base del asiento
     */
    public static int quePrecio() {
        return precio;
    }

    /**
     * Obtiene la ubicación del asiento.
     *
     * @return la ubicación del asiento
     */
    public String dondeQueda() {
        if (getNumero() % 2 == 0) {
            return "pasillo"; // Si el asiento es par va al pasillo
        } else {
            return "ventana";
        }
    }
}

