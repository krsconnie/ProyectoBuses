package org.example;
/**
 * Excepción lanzada cuando no se encuentra un autobús en la lista de autobuses disponibles.
 */
public class BusNoEncontradoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */
    public BusNoEncontradoException(String mensaje) {
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
