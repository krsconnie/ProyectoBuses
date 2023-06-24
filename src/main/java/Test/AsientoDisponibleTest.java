package Test;

import org.example.Asiento;
import org.example.AsientoDisponible;
import org.example.AsientoReservado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoDisponibleTest {
    @Test
    void testReservar() {
        // Prueba que se pueda reservar un asiento disponible

        // Crea un objeto Asiento en estado AsientoDisponible
        Asiento asiento = new Asiento();
        asiento.setEstado(new AsientoDisponible());

        // Reserva el asiento
        asiento.reservar();

        // Verifica que el estado del asiento haya cambiado a AsientoReservado
        assertTrue(asiento.getEstado() instanceof AsientoReservado);
    }

    @Test
    void testCancelarReserva() {
        // Prueba que no se pueda cancelar la reserva de un asiento disponible

        // Crea un objeto Asiento en estado AsientoDisponible
        Asiento asiento = new Asiento();
        asiento.setEstado(new AsientoDisponible());

        // Intenta cancelar la reserva del asiento
        asiento.cancelarReserva();

        // Verifica que el estado del asiento no haya cambiado
        assertTrue(asiento.getEstado() instanceof AsientoDisponible);
    }
}
