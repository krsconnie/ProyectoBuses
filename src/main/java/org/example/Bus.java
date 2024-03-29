package org.example;
import java.util.ArrayList;

/**
 * Representa un autobús que realiza un recorrido específico y tiene asientos disponibles.
 */
public class Bus {
    private int valorPasaje;
    private String horario;
    private String fecha;
    ArrayList<Asiento> asientos;
    private Recorrido recorrido;


    /**
     * Enumeración que define los diferentes recorridos y sus precios base.
     */
    public enum Recorrido {
        Concepcion_Santiago(10000),
        Concepcion_Chillan(5000),
        Concepcion_LosAngeles(5000),
        Chillan_Concepcion(5000),
        Santiago_Concepcion(10000),
        LosAngeles_Concepcion(5000);

        private int precio;

        Recorrido(int precio) {
            this.precio = precio;
        }

        /**
         * Obtiene el precio base del recorrido.
         *
         * @return el precio base del recorrido
         */
        public int getPrecio() {
            return precio;
        }
    }

    /**
     * Crea una instancia de la clase Bus con el número de asientos y el recorrido especificados.
     *
     * @param recorrido      el recorrido que realiza el autobús
     */
    public Bus(Recorrido recorrido) {
        asientos = new ArrayList<>();
        this.recorrido = recorrido;

        if ((recorrido.equals(Recorrido.Concepcion_Santiago) || recorrido.equals(Recorrido.Santiago_Concepcion))) {
            for (int i = 0; i < 11; i++) {
                asientos.add(new SalonCama());
            }
            for (int i = 11; i < 71; i++) {
                asientos.add(new SemiCama());
            }
        } else if ((recorrido.equals(Recorrido.Chillan_Concepcion) || recorrido.equals(Recorrido.Concepcion_Chillan) || recorrido.equals(Recorrido.Concepcion_LosAngeles) || recorrido.equals(Recorrido.LosAngeles_Concepcion))) {
            for (int i = 0; i < 11; i++) {
                asientos.add(new SemiCama());
            }
            for (int i = 11; i < 71; i++) {
                asientos.add(new Regular());
            }
        }
        Asiento target = new Asiento();
        for (int i = 0; i > 71 ; i++) {

            target = asientos.get(i); // Objeto que deseas buscar
            int position = asientos.indexOf(target) + 1;
            asientos.get(i).setNumero(position);
        }

    }


    /**
     * Obtiene el valor del pasaje para un asiento específico.
     *
     * @param numeroAsiento el número de asiento para el cual se desea obtener el valor del pasaje
     * @return el valor del pasaje para el asiento especificado
     */
    public int getValorPasaje(int numeroAsiento) {
        Asiento asiento = asientos.get(numeroAsiento - 1);
        int precioAsiento = asiento.quePrecio();
        int valorPasaje = recorrido.getPrecio() + precioAsiento;
        return valorPasaje;
    }

    /**
     * Obtiene el horario del autobús.
     *
     * @return el horario del autobús
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Establece el horario del autobús.
     *
     * @param horario el horario del autobús
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Obtiene el recorrido del autobús en formato legible.
     *
     * @return el recorrido del autobús
     */
    public String getRecorrido() {
        return recorrido.name().replace("_", " ");
    }

    /**
     * Obtiene la fecha del autobús.
     *
     * @return la fecha del autobús
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha del autobús.
     *
     * @param fecha la fecha del autobús
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene el asiento en la posición especificada.
     *
     * @param i la posición del asiento a obtener
     * @return el asiento en la posición especificada, o null si la posición es inválida
     */
    public Asiento getAsiento(int i) {
        if (i > 71 && i < 0) {
            return asientos.get(i);
        } else{
            return null;
        }
    }


    public ArrayList<Asiento> getAsientos() {
        return null;
    }
}