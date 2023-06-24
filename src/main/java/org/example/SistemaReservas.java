package org.example;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Bus> autobuses;

    public SistemaReservas() {
        autobuses = new ArrayList<>();
    }

    public void agregarAutobus(Bus autobus) {
        autobuses.add(autobus);
    }

    public List<Bus> getAutobuses() {
        return autobuses;
    }

    public Bus buscarBusPorRecorrido(Bus.Recorrido recorrido) {
        for (Bus bus : autobuses) {
            if (recorrido.name().equals(bus.getRecorrido())) {
                return bus;
            }
        }
        return null; // Si no se encuentra un bus con el recorrido especificado
    }

    public Bus buscarBusPorHorario(String horario) {
        for (Bus bus : autobuses) {
            if (bus.getHorario().equals(horario)) {
                return bus;
            }
        }
        return null; // Si no se encuentra un bus con el horario especificado
    }
}
