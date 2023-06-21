package org.example;

/**
 * La clase SemiCama es una subclase de Asiento que representa un tipo de asiento SemiCama.
 */
public class SemiCama extends Asiento {
    private static int precio = 400;

    /**
     * Constructor de la clase SemiCama.
     * Crea una instancia de SemiCama.
     */
    public void SemiCama() {
    }

    /**
     * Obtiene el precio del asiento SemiCama.
     *
     * @return el precio del asiento SemiCama
     */
    public static int quePrecio() {
        return precio;
    }

    /**
     * Obtiene la categoría del asiento SemiCama.
     *
     * @return la categoría del asiento SemiCama
     */
    @Override
    public String queCategoria() {
        return "SemiCama";
    }
}

