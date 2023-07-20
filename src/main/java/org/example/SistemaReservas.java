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
     */
    public SistemaReservas(ArrayList<Bus> autobuses) {
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

    public Asiento seleccionarAsiento(int cualBus, int numeroAsiento) {
        int precio = 0;
        Asiento seleccionado = new Asiento();
        Bus bus = autobuses.get(cualBus - 1);
        seleccionado = bus.asientos.get(numeroAsiento - 1);
        precio = bus.getValorPasaje(numeroAsiento - 1);
        return seleccionado;
    }

    public void pagarAsiento(Bus bus, int i)throws AsientoNoDisponibleException {
        if (bus.getAsiento(i).getEstado().equals("Disponible")) {
            bus.getAsiento(i).reservar();
            System.out.println("Asiento reservado y pagado exitosamente. Precio:$" + bus.getValorPasaje(i));
        }else{
            throw new AsientoNoDisponibleException("El asiento no está disponible para reservar.");
        }
    }
    public void cancelarReservacion(Bus bus, int i) throws AsientoNoReservadoException{
        if(bus.getAsiento(i).getEstado().equals("Reservado")){
            bus.getAsiento(i).cancelarReserva();
            System.out.println("Asiento liberado, dinero devuelto exitosamente. Cantidad devuelta:$"+bus.getValorPasaje(i));
        } else {
            throw new AsientoNoReservadoException("El asiento esta disponible, no se puede cancelar reservación");
        }
    }
}