package edu.upc.dsa;

import edu.upc.dsa.user;
import org.apache.log4j.Logger;

import java.util.*;

public class managerImpl implements manager{

    HashMap<String, user> listausuarios = new HashMap<String, user>();
    HashMap<String, objeto> listadeobjetos = new HashMap<>();
    static final Logger logger = Logger.getLogger(managerImpl.class.getName());
    private static managerImpl manager;

    //Singleton
    public static managerImpl getInstance() {
        if (manager == null) {
            manager = new managerImpl();
        }
        return manager;
    }

    public managerImpl() {
    }

    @Override
    public void adduser(String id, String nombre, String apellidos, String fechadenacimiento, String correo, String password) {
        user usuarionuevo = new user(id, nombre, apellidos, fechadenacimiento, correo, password);
        listausuarios.put(correo, usuarionuevo);
        logger.info("S'ha afegit un nou usuari: " + usuarionuevo.getNombre() + " " + usuarionuevo.getApellidos());
    }

    public List<user> listausuariosordenados() {
        List<user> r = new LinkedList<>(listausuarios.values());
        Collections.sort(r, new Comparator<user>() {
            @Override
            public int compare(user o1, user o2) {
                int e = o1.getNombre().compareToIgnoreCase(o2.getNombre());
                if (e == 0)
                    e = o1.getApellidos().compareToIgnoreCase(o2.getApellidos());
                return e;
            }
        });
        logger.info("Lista ordenada alfabeticamente: " + r.toString());
        return r;
    }

    @Override
    public int login(String correo, String password){
        user usuario = getUserByCorreo(correo);
        int e = usuario.getPassword().compareToIgnoreCase(password);
        if (e==0){
            logger.info("Bienvenido");
            return 0;
        }
        else{
            logger.info("Disculpe, no se encuentra el usuario");
            return -1;
        }
    }

    @Override
    public user getUserByCorreo(String correo) {
        user usuario = this.listausuarios.get(correo);
        return usuario;
    }

    @Override
    public user consultarusuario(String nombre) {
        return null;
    }

    public void AddObject(String nombre, String descripcion, Integer precio){
        objeto objeto = new objeto(nombre, descripcion, precio);
        listadeobjetos.put(nombre, objeto);
    }

    public List<objeto> listaobjetosordenados() {
        List<objeto> listaOrdenada = new LinkedList<objeto>(listadeobjetos.values());
        Collections.sort(listaOrdenada, new OrdenarObjetosPorPrecio());
        return listaOrdenada;
    }

    public List<objeto> listaobjetoscomprados(String correo){
        user usuario = this.listausuarios.get(correo);
        return usuario.objetoscomprados;
    }
}