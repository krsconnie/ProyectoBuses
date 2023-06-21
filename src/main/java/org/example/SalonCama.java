package org.example;

/**
 * La clase SalonCama es una subclase de Asiento que representa un tipo de asiento SalonCama.
 */
public class SalonCama extends Asiento {
    private static int precio = 600;

    /**
     * Constructor de la clase SalonCama.
     * Crea una instancia de SalonCama.
     */
    public void SalonCama() {
    }

    /**
     * Obtiene el precio del asiento SalonCama.
     *
     * @return el precio del asiento SalonCama
     */
    public static int quePrecio() {
        return precio;
    }

    /**
     * Obtiene la categoría del asiento SalonCama.
     *
     * @return la categoría del asiento SalonCama
     */
    @Override
    public String queCategoria() {
        return "Salon Cama";
    }
}

