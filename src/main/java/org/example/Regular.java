package org.example;

public class Regular extends Asiento{
    private static int precio = 200;


    public void Regular(){}
    public static int quePrecio(){
        return precio;
    }

    @Override
    public String queCategoria(){
        return "Regular";
    }

}
