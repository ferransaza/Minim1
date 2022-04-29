package edu.upc.dsa;

import java.util.Comparator;

public class OrdenarObjetosPorPrecio implements Comparator<objeto> {
    public int compare(objeto p1, objeto p2){
        return (int)(p1.GetPrecio() - p2.GetPrecio());
    }
}
