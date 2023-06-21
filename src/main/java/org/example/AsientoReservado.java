package org.example;
public class AsientoReservado implements EstadoAsiento {
    @Override
    public void reservar(Asiento asiento) {
        // No se puede reservar un asiento que ya está reservado
    }

    @Override
    public void cancelarReserva(Asiento asiento) {
        asiento.setEstado(new AsientoDisponible());
    }
}
