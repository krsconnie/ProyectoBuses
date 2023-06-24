package Test;

import org.example.Asiento;
import org.example.AsientoDisponible;
import org.example.AsientoReservado;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AsientoReservadoTest {
    @Test
    void testReservar() {
        // Prueba que no se pueda reservar un asiento que ya está reservado

        // Crea un objeto Asiento en estado AsientoReservado
        Asiento asiento = new Asiento();
        asiento.setEstado(new AsientoReservado());

        // Intenta reservar el asiento nuevamente
        asiento.reservar();

        // Verifica que el estado del asiento no haya cambiado
        assertTrue(asiento.getEstado() instanceof AsientoReservado);
    }

    @Test
    void testCancelarReserva() {
        // Prueba que se pueda cancelar la reserva de un asiento

        // Crea un objeto Asiento en estado AsientoReservado
        Asiento asiento = new Asiento();
        asiento.setEstado(new AsientoReservado());

        // Cancela la reserva del asiento
        asiento.cancelarReserva();

        // Verifica que el estado del asiento haya cambiado a AsientoDisponible
        assertTrue(asiento.getEstado() instanceof AsientoDisponible);
    }
}
