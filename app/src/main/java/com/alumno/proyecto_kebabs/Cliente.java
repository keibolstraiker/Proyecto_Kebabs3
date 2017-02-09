package com.alumno.proyecto_kebabs;

import java.io.Serializable;

/**
 * Created by adminportatil on 01/02/2017.
 */
public class Cliente implements Serializable{

    private String Nombre;
    private String Direccion;
    private String Telefono;

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }



}
