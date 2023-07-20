package org.example;
public class AsientoNoReservadoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */
    public AsientoNoReservadoException(String mensaje) {
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