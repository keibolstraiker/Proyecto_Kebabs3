package com.alumno.proyecto_kebabs;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by adminportatil on 08/02/2017.
 */
public class Bebida implements Serializable {

    private String Nombre;
    private int Precio;
    private int Cantidad;

    public Bebida(String nom, int pre, int cant){

        Nombre=nom;
        Precio=pre;
        Cantidad=cant;

    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPrecio() {
        return Precio;
    }

}