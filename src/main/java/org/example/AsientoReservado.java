package org.example;
/**
 * La clase AsientoReservado implementa la interfaz EstadoAsiento y representa el estado de un asiento que ha sido reservado.
 */
public class AsientoReservado implements EstadoAsiento {
    /**
     * No se puede reservar un asiento que ya está reservado.
     * Este método no tiene ningún efecto en un asiento en estado AsientoReservado.
     *
     * @param asiento el asiento que se desea reservar
     */
    @Override
    public void reservar(Asiento asiento) {
        // No se puede reservar un asiento que ya está reservado
    }

    /**
     * Cancela la reserva del asiento especificado, cambiando su estado a AsientoDisponible.
     *
     * @param asiento el asiento cuya reserva se desea cancelar
     */
    @Override
    public void cancelarReserva(Asiento asiento) {
        asiento.setEstado(new AsientoDisponible());
    }
}

