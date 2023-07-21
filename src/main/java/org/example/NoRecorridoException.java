package org.example;

/**
 * Excepción lanzada cuando se intenta crear un autobús con un recorrido no válido o desconocido.
 */
public class NoRecorridoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */
    public NoRecorridoException(String mensaje) {
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
