package edu.upc.dsa;

import edu.upc.dsa.user;
import edu.upc.dsa.objeto;
import java.util.List;

public interface manager {
    public void adduser(String id, String nombre, String apellidos, String fechadenacimiento, String correo, String password);

    public List<user> listausuariosordenados();

    public int login(String correo, String password);

    public user getUserByCorreo(String correo);

    public user consultarusuario(String nombre);
}
