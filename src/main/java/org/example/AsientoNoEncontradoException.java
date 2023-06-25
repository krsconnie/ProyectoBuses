package org.example;
/**
 * Excepción lanzada cuando se intenta acceder a un asiento que no existe en un autobús específico.
 */
public class AsientoNoEncontradoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     *
     * @param mensaje mensaje descriptivo de la excepción
     */
    public AsientoNoEncontradoException(String mensaje) {
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

