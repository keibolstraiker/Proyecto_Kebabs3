package com.alumno.proyecto_kebabs;



public class Cliente {

    private String nombre,direccion;
    private int telefono;



    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void setDireccion(String direccion) {
        int contar;
        this.direccion = direccion;

    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;

    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
}
