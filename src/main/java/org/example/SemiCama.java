package org.example;

public class SemiCama extends Asiento{
    private static int precio = 400;
    public void SemiCama(){}
    public static int quePrecio(){
        return precio;
    }

    @Override
    public String queCategoria(){
        return "SemiCama";
    }

}
