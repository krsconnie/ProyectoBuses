package Test;
import org.example.Bus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    private Bus bus;

    @BeforeEach
    void setUp() {
        // Configurar el autobús antes de cada prueba
        int numeroAsientos = 70; // Cambia este valor según tus necesidades de prueba
        Bus.Recorrido recorrido = Bus.Recorrido.Concepcion_Santiago; // Cambia este valor según tus necesidades de prueba
        bus = new Bus(numeroAsientos, recorrido);
    }

    @Test
    void testGetValorPasaje() {
        // Prueba el método getValorPasaje para diferentes asientos y recorridos

        // Prueba para un asiento regular en un recorrido regular
        int numeroAsientoRegular = 0;
        int valorPasajeRegular = bus.getValorPasaje(numeroAsientoRegular);
        assertEquals(10000, valorPasajeRegular);

        // Prueba para un asiento de salón cama en un recorrido especial
        int numeroAsientoSalonCama = 10;
        int valorPasajeSalonCama = bus.getValorPasaje(numeroAsientoSalonCama);
        assertEquals(15000, valorPasajeSalonCama);

        // Prueba para un asiento de semicama en un recorrido especial
        int numeroAsientoSemiCama = 15;
        int valorPasajeSemiCama = bus.getValorPasaje(numeroAsientoSemiCama);
        assertEquals(15000, valorPasajeSemiCama);

        // Agrega más casos de prueba según los diferentes escenarios que desees cubrir
    }

    @Test
    void testGetHorario() {
        // Prueba el método getHorario

        // Establece el horario del autobús usando el método setHorario de la clase Bus
        String horario = "10:00 AM"; // Cambia este valor según tus necesidades de prueba
        bus.setHorario(horario);

        // Obtiene el horario del autobús usando el método getHorario de la clase Bus
        String horarioObtenido = bus.getHorario();

        // Verifica que el horario obtenido sea igual al horario establecido
        assertEquals(horario, horarioObtenido);
    }

    @Test
    void testGetRecorrido() {
        // Prueba el método getRecorrido

        // Obtiene el recorrido del autobús usando el método getRecorrido de la clase Bus
        String recorridoObtenido = bus.getRecorrido();

        // Verifica que el recorrido obtenido sea igual al recorrido esperado
        String recorridoEsperado = "Concepcion Santiago"; // Cambia este valor según tus necesidades de prueba
        assertEquals(recorridoEsperado, recorridoObtenido);
    }
}
