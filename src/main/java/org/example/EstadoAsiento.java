package org.example;
public interface EstadoAsiento {
    void reservar(Asiento asiento);
    void cancelarReserva(Asiento asiento);
}
