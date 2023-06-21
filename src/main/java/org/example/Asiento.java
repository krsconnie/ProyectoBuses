package org.example;

public class Asiento {
    private EstadoAsiento estado;
    private int numero;
    private String categoria;

    private String Ubicación;
    private static int precio;

    public void Asiento(int numero){
        this.numero = numero;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    public void reservar() {
        estado.reservar(this);
    }

    public void cancelarReserva() {
        estado.cancelarReserva(this);
    }
    public EstadoAsiento getEstado() {
        return estado;
    }


    public int getNumero(){
        return numero;
    }


    public String queCategoria(){
        return this.categoria;
    }

    public static int quePrecio(){
        return precio;
    }

    public String dondeQueda(){

        if(getNumero()%2 == 0){

            return "pasillo";//Si el asiento es par va al pasillo

        } else{

            return "ventana";
        }
    }
}

