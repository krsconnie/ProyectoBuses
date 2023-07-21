package org.example;

/**
 * Excepción personalizada para el caso en que no hay buses disponibles.
 */
public class NoHayBusesException extends Exception {

    /**
     * Constructor sin argumentos que crea una instancia de NoHayBusesException con el mensaje predeterminado.
     * El mensaje predeterminado es "No hay buses disponibles."
     */
    public NoHayBusesException() {
        super("No hay buses disponibles.");
    }

    /**
     * Constructor que crea una instancia de NoHayBusesException con un mensaje personalizado.
     *
     * @param message El mensaje personalizado de la excepción.
     */
    public NoHayBusesException(String message) {
        super(message);
    }
}
