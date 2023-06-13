package org.example;
public class Bus {
    private int valorPasaje;
    private String horario;
    private String recorrido;

    private Asiento asientos Arraylist[];

    public Bus() {}

    public int getValorPasaje() {
        return valorPasaje;
    }
    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getRecorrido() {
        return recorrido;
    }
    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }
}

