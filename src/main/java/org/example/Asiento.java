package org.example;

public class Asiento {
    private boolean reservado;
    private int numero;
    private String categoria;

    private String Ubicación;
    private int precio;

    public void Asiento(int numero){
        this.numero = numero;
        this.reservado = false;
    }

    public void reservarAsiento(){
        this.reservado = true;
    }

    public int getNumero(){
        return numero;
    }

    public boolean estaReservado(){
        return reservado;
    }

    public String queCategoria(){
        return this.categoria;
    }

    public int quePrecio(){
        return this.precio;
    }

    public String dondeQueda(){

        if(getNumero()%2 == 0){

            return "pasillo";//Si el asiento es par va al pasillo

        } else{

            return "ventana";
        }
    }
}

