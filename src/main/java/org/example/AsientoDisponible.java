package org.example;
/**
 * La clase AsientoDisponible implementa la interfaz EstadoAsiento y representa el estado de un asiento disponible para ser reservado.
 */
public class AsientoDisponible implements EstadoAsiento {
    /**
     * Reserva el asiento especificado, cambiando su estado a AsientoReservado.
     *
     * @param asiento el asiento que se desea reservar
     */
    @Override
    public void reservar(Asiento asiento) {
        asiento.setEstado(new AsientoReservado());
    }

    /**
     * No se puede cancelar una reserva si el asiento está disponible.
     * Este método no tiene ningún efecto en un asiento en estado AsientoDisponible.
     *
     * @param asiento el asiento cuya reserva se desea cancelar
     */
    @Override
    public void cancelarReserva(Asiento asiento) {
        // No se puede cancelar una reserva si el asiento está disponible
    }
    public String getEstado(){
        return "Disponible";
    }
}

