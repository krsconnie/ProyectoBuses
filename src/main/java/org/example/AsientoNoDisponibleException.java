package org.example;
/**
 * Excepción lanzada cuando se intenta reservar un asiento que ya está ocupado.
 */
public class AsientoNoDisponibleException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */
    public AsientoNoDisponibleException(String mensaje) {
        super(mensaje);
    }

    /**
     * Devuelve el mensaje descriptivo de la excepción.
     *
     * @return mensaje descriptivo de la excepción
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
