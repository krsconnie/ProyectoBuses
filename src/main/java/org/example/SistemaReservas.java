package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase SistemaReservas representa un sistema de reservas de autobuses.
 */
public class SistemaReservas {
    private ArrayList<Bus> autobuses;

    /**
     * Constructor de la clase SistemaReservas.
     * Inicializa la lista de autobuses.
     *
     * @param autobuses la lista de autobuses disponibles en el sistema
     */
    public SistemaReservas(ArrayList<Bus> autobuses) {
        this.autobuses = autobuses;
    }

    /**
     * Obtiene la lista de autobuses disponibles en el sistema.
     *
     * @return la lista de autobuses
     */
    public ArrayList<Bus> getAutobuses() {
        return autobuses;
    }

    /**
     * Busca un autobús por su recorrido.
     *
     * @param recorrido el recorrido del autobús a buscar
     * @return el autobús encontrado, o null si no se encuentra un autobús con el recorrido especificado
     */
    public Bus buscarBusPorRecorrido(Bus.Recorrido recorrido) {
        for (Bus bus : autobuses) {
            if (recorrido.name().equals(bus.getRecorrido())) {
                return bus;
            }
        }
        return null;
    }

    /**
     * Busca un autobús por su horario.
     *
     * @param horario el horario del autobús a buscar
     * @return el autobús encontrado, o null si no se encuentra un autobús con el horario especificado
     */
    public Bus buscarBusPorHorario(String horario) {
        for (Bus bus : autobuses) {
            if (bus.getHorario().equals(horario)) {
                return bus;
            }
        }
        return null;
    }

    /**
     * Selecciona un asiento de un autobús.
     *
     * @param cualBus el índice del autobús en la lista de autobuses
     * @param numeroAsiento el número del asiento a seleccionar
     * @return el asiento seleccionado
     */
    public Asiento seleccionarAsiento(int cualBus, int numeroAsiento) {
        Bus bus = autobuses.get(cualBus - 1);
        return bus.getAsiento(numeroAsiento - 1);
    }

    /**
     * Paga un asiento de un autobús.
     * Si el asiento está disponible, se reserva y se muestra el mensaje de éxito.
     * Si el asiento no está disponible, se lanza una excepción AsientoNoDisponibleException.
     *
     * @param bus el autobús en el que se encuentra el asiento
     * @param i el índice del asiento en la lista de asientos del autobús
     * @throws AsientoNoDisponibleException si el asiento no está disponible para reservar
     */
    public void pagarAsiento(Bus bus, int i) throws AsientoNoDisponibleException {
        Asiento asiento = bus.getAsiento(i);

        if (asiento.getEstado().equals("Disponible")) {
            asiento.reservar();
            System.out.println("Asiento reservado y pagado exitosamente. Precio: $" + bus.getValorPasaje(i));
        } else {
            throw new AsientoNoDisponibleException("El asiento no está disponible para reservar.");
        }
    }

    /**
     * Cancela la reservación de un asiento de un autobús.
     * Si el asiento está reservado, se cancela la reserva y se muestra el mensaje de éxito.
     * Si el asiento no está reservado, se lanza una excepción AsientoNoReservadoException.
     *
     * @param bus el autobús en el que se encuentra el asiento
     * @param i el índice del asiento en la lista de asientos del autobús
     * @throws AsientoNoReservadoException si el asiento no está reservado y no se puede cancelar la reservación
     */
    public void cancelarReservacion(Bus bus, int i) throws AsientoNoReservadoException {
        Asiento asiento = bus.getAsiento(i);

        if (asiento.getEstado().equals("Reservado")) {
            asiento.cancelarReserva();
            System.out.println("Asiento liberado, dinero devuelto exitosamente. Cantidad devuelta: $" + bus.getValorPasaje(i));
        } else {
            throw new AsientoNoReservadoException("El asiento está disponible, no se puede cancelar la reservación.");
        }
    }
}
