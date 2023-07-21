package Test;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase SistemaReservasTest realiza pruebas unitarias para la clase SistemaReservas.
 */
class SistemaReservasTest {

    private SistemaReservas sistema;
    private ArrayList<Bus> buses;

    /**
     * Configuración inicial para las pruebas unitarias.
     */
    @BeforeEach
    void setUp() {
        // Configurar los datos para las pruebas
        buses = new ArrayList<>();
        buses.add(new Bus(Bus.Recorrido.Concepcion_Santiago));
        buses.add(new Bus(Bus.Recorrido.Concepcion_Chillan));
        buses.add(new Bus(Bus.Recorrido.Chillan_Concepcion));
        buses.add(new Bus(Bus.Recorrido.Concepcion_LosAngeles));
        sistema = new SistemaReservas(buses);
    }

    /**
     * Prueba para el método buscarBusPorRecorrido cuando se busca un bus existente.
     */
    @Test
    void buscarBusPorRecorrido_busExistente_debeEncontrarElBus() {
        Bus busEncontrado = sistema.buscarBusPorRecorrido(Bus.Recorrido.Concepcion_Chillan);
        assertNotNull(busEncontrado);
        assertEquals(Bus.Recorrido.Concepcion_Chillan.name().replace("_", " "), busEncontrado.getRecorrido());
    }

    /**
     * Prueba para el método buscarBusPorRecorrido cuando se busca un bus no existente.
     */
    @Test
    void buscarBusPorRecorrido_busNoExistente_debeRetornarNull() {
        Bus busEncontrado = sistema.buscarBusPorRecorrido(Bus.Recorrido.Santiago_Concepcion);
        assertNull(busEncontrado);
    }


    /**
     * Prueba para el método buscarBusPorHorario cuando se busca un bus existente.
     */
    @Test
    void buscarBusPorHorario_busExistente_debeEncontrarElBus() {
        Bus busEncontrado = sistema.buscarBusPorHorario(buses.get(0).getHorario());
        assertNotNull(busEncontrado);
        assertEquals(buses.get(0).getHorario(), busEncontrado.getHorario());
    }


    /**
     * Prueba para el método buscarBusPorHorario cuando se busca un bus existente.
     */
    @Test
    void buscarBusPorHorario_busNoExistente_debeRetornarNull() {
        Bus busEncontrado = sistema.buscarBusPorHorario("10:00");
        assertNull(busEncontrado);
    }

    /**
     * Prueba para el método seleccionarAsiento cuando se selecciona un asiento existente.
     */
    @Test
    void seleccionarAsiento_asientoExistente_debeRetornarElAsientoCorrecto() {
        int cualBus = 1;
        int numeroAsiento = 1;
        Asiento asientoSeleccionado = sistema.seleccionarAsiento(cualBus, numeroAsiento);
        assertNotNull(asientoSeleccionado);
        assertEquals(numeroAsiento, asientoSeleccionado.getNumero());
    }

    /**
     * Prueba para el método seleccionarAsiento cuando se selecciona un asiento no existente.
     */
    @Test
    void seleccionarAsiento_asientoNoExistente_debeRetornarNull() {
        int cualBus = 1;
        int numeroAsiento = 100;
        Asiento asientoSeleccionado = sistema.seleccionarAsiento(cualBus, numeroAsiento);
        assertNull(asientoSeleccionado);
    }

    /**
     * Prueba para el método pagarAsiento cuando se paga un asiento disponible.
     */
    @Test
    void pagarAsiento_asientoDisponible_debeReservarElAsiento() {
        Bus bus = buses.get(1); // Tomar un bus cualquiera
        int asientoIndex = 5; // Tomar un asiento disponible
        try {
            sistema.pagarAsiento(bus, asientoIndex);
            Asiento asientoReservado = bus.getAsiento(asientoIndex);
            assertEquals("Reservado", asientoReservado.getEstado());
        } catch (AsientoNoDisponibleException e) {
            fail("No se esperaba una excepción");
        }
    }

    /**
     * Prueba para el método pagarAsiento cuando se intenta pagar un asiento no disponible.
     */
    @Test
    void pagarAsiento_asientoNoDisponible_debeLanzarAsientoNoDisponibleException() {
        Bus bus = buses.get(0); // Tomar un bus cualquiera
        int asientoIndex = 1; // Tomar un asiento que ya está reservado
        assertThrows(AsientoNoDisponibleException.class, () -> sistema.pagarAsiento(bus, asientoIndex));
    }

    /**
     * Prueba para el método cancelarReservacion cuando se cancela la reservación de un asiento reservado.
     */
    @Test
    void cancelarReservacion_asientoReservado_debeCancelarLaReservacion() {
        Bus bus = buses.get(2); // Tomar un bus cualquiera
        int asientoIndex = 2; // Tomar un asiento reservado
        try {
            sistema.cancelarReservacion(bus, asientoIndex);
            Asiento asientoLiberado = bus.getAsiento(asientoIndex);
            assertEquals("Disponible", asientoLiberado.getEstado());
        } catch (AsientoNoReservadoException e) {
            fail("No se esperaba una excepción");
        }
    }

    /**
     * Prueba para el método cancelarReservacion cuando se intenta cancelar la reservación de un asiento no reservado.
     */
    @Test
    void cancelarReservacion_asientoNoReservado_debeLanzarAsientoNoReservadoException() {
        Bus bus = buses.get(3); // Tomar un bus cualquiera
        int asientoIndex = 1; // Tomar un asiento disponible
        assertThrows(AsientoNoReservadoException.class, () -> sistema.cancelarReservacion(bus, asientoIndex));
    }
}