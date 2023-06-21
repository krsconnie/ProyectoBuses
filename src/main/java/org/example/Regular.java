package org.example;

/**
 * La clase Regular representa un tipo de asiento regular en un autobús.
 * Extiende la clase Asiento.
 */
public class Regular extends Asiento {
    private static int precio = 200;

    /**
     * Constructor de la clase Regular.
     */
    public void Regular() {}

    /**
     * Obtiene el precio del asiento regular.
     *
     * @return el precio del asiento regular
     */
    public static int quePrecio() {
        return precio;
    }

    /**
     * Obtiene la categoría del asiento regular.
     *
     * @return la categoría del asiento regular
     */
    @Override
    public String queCategoria() {
        return "Regular";
    }
}

