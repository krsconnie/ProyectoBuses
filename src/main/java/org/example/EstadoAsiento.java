package org.example;
/**
 * La interfaz EstadoAsiento define los métodos para reservar y cancelar la reserva de un asiento.
 */
public interface EstadoAsiento {
    /**
     * Reserva el asiento especificado.
     *
     * @param asiento el asiento que se desea reservar
     */
    void reservar(Asiento asiento);

    /**
     * Cancela la reserva del asiento especificado.
     *
     * @param asiento el asiento cuya reserva se desea cancelar
     */
    void cancelarReserva(Asiento asiento);
}
