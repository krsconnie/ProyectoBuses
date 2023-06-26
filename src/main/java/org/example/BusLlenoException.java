package org.example;

/**
 * Excepción lanzada cuando el bus seleccionado no tiene asientos disponibles.
 */

public class BusLlenoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */

    public BusLlenoException(String mensaje) {
    
        super(mensaje);
    
    }

    /**
     * Devuelve el mensaje descriptivo de la excepción.
     *
     * @return mensaje descriptivo de la excepción
     */

    public String getMessage() {
        return super.getMessage();
    }
}