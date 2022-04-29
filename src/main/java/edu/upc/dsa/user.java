package edu.upc.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class user {
    private String id;
    private String nombre;
    private String apellidos;
    private String fechadenacimiento;
    private String correo;
    private String password;
    public int saldo = 50;
    public List<objeto> objetoscomprados = new ArrayList<>();

    public user(String id, String nombre, String apellidos,String fechadenacimiento, String correo, String password){
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechadenacimiento=fechadenacimiento;
        this.correo=correo;
        this.password=password;
    }

    public user(String id, String nombre){}

    public String getNombre(){
        return nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getPassword(){
        return correo;
    }
}
