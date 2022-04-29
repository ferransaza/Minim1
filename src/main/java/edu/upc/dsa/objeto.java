package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public class objeto {
    private String nombre;
    private String descripcion;
    private int precio;
    public List<user> usuariosquehancomprado = new ArrayList<>();

    public objeto (String nombre, String descripcion, Integer precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public Integer GetPrecio(){
        return precio;
    }
}
