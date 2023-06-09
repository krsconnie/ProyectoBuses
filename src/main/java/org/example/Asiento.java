package org.example;

public class Asiento {
    private boolean reservado;
    private int numero;
    private String categoria;
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
}

