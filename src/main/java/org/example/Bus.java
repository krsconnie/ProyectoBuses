package org.example;
import java.util.ArrayList;

public class Bus {
    private int valorPasaje;
    private String horario;
    private ArrayList<Asiento> asientos;
    private Recorrido recorrido;

    private enum Recorrido {
        Concepcion_Santiago(10000),
        Concepcion_Chillan(5000),
        Concepcion_LA(5000),
        Chillan_Concepcion(5000),
        Santiago_Concepcion(10000),
        LA_Concepcion(5000);

        private int precio;

        Recorrido(int precio) {
            this.precio = precio;
        }

        public int getPrecio() {
            return precio;
        }
    }

    public Bus(int numeroAsientos, Recorrido recorrido) {
        asientos = new ArrayList<>();
        this.recorrido = recorrido;

        if (numeroAsientos <= 60) {
            for (int i = 0; i < numeroAsientos; i++) {
                asientos.add(new Regular());
            }
        } else if ((numeroAsientos >= 60) && (recorrido.equals(Recorrido.Concepcion_Santiago) || recorrido.equals(Recorrido.Santiago_Concepcion))) {
            for (int i = 0; i < 11; i++) {
                asientos.add(new SalonCama());
            }
            for (int i = 11; i < numeroAsientos; i++) {
                asientos.add(new SemiCama());
            }
        } else if ((numeroAsientos >= 60) && (recorrido.equals(Recorrido.Chillan_Concepcion) || recorrido.equals(Recorrido.Concepcion_Chillan) || recorrido.equals(Recorrido.Concepcion_LA) || recorrido.equals(Recorrido.LA_Concepcion))) {
            for (int i = 0; i < 11; i++) {
                asientos.add(new SemiCama());
            }
            for (int i = 11; i < numeroAsientos; i++) {
                asientos.add(new Regular());
            }
        }
    }
    public int getValorPasaje(int numeroAsiento) {
        Asiento asiento = asientos.get(numeroAsiento);
        int precioAsiento = asiento.quePrecio();
        int valorPasaje = recorrido.getPrecio() + precioAsiento;
        return valorPasaje;
    }
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getRecorrido() {
        return recorrido.name().replace("_", " ");
    }
}
