package org.example;

public class SalonCama extends Asiento{
    private static int precio = 600;
    public void SalonCama(){}
    public static int quePrecio(){
        return precio;
    }
    @Override
    public String queCategoria(){
        return "Salon Cama";
    }

}
