package org.example;
public class AsientoDisponible implements EstadoAsiento {
    @Override
    public void reservar(Asiento asiento) {
        asiento.setEstado(new AsientoReservado());
    }

    @Override
    public void cancelarReserva(Asiento asiento) {
        // No se puede cancelar una reserva si el asiento está disponible
    }
}

