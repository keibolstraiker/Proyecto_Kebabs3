package com.alumno.proyecto_kebabs;



public class Comida {

    private String tipo_kebab,tipo_carne,tipo_tamaño;
    private int precio_kebab,precio_carne,precio_tamaño,precio_total_comida;


    /*public Comida(String tipo_kebab, String tipo_carne, String tipo_tamaño){
        this.tipo_kebab = tipo_kebab;
        this.tipo_carne = tipo_carne;
        this.tipo_tamaño = tipo_tamaño;
    }*/


    public void setTipo_kebab(String tipo_kebab) {
        this.tipo_kebab = tipo_kebab;
    }

    public void setTipo_carne(String tipo_carne) {
        this.tipo_carne = tipo_carne;
    }

    public void setTipo_tamaño(String tipo_tamaño) {
        this.tipo_tamaño = tipo_tamaño;
    }

    public void setPrecio_kebab(int precio_kebab) {
        if (tipo_kebab.equals("Durum")){
            precio_kebab=4;
            this.precio_kebab = precio_kebab;
        }else if (tipo_kebab.equals("Döner")){
            precio_kebab=3;
            this.precio_kebab = precio_kebab;
        }else if (tipo_kebab.equals("Lamhacun")){
            precio_kebab=5;
            this.precio_kebab = precio_kebab;
        }else if (tipo_kebab.equals("Shawarma")){
            precio_kebab=5;
            this.precio_kebab = precio_kebab;
        }else if (tipo_kebab.equals("Gyros")){
            precio_kebab=5;
            this.precio_kebab = precio_kebab;
        }else {
            System.out.println("No existe");
        }

    }

    public void setPrecio_carne(int precio_carne) {
        if (tipo_carne.equals("Cordero")){
            precio_carne=0;
            this.precio_carne = precio_carne;
        }else if (tipo_carne.equals("Pollo")){
            precio_carne=0;
            this.precio_carne = precio_carne;
        }else if (tipo_carne.equals("Ternera")){
            precio_carne=1;
            this.precio_carne = precio_carne;
        }else{
            System.out.println("No existe");
        }

    }

    public void setPrecio_tamaño(int precio_tamaño) {
        if (tipo_tamaño.equals("Normal")){
            precio_tamaño=0;
            this.precio_tamaño = precio_tamaño;
        }else if (tipo_tamaño.equals("Completa")){
            precio_tamaño=1;
            this.precio_tamaño = precio_tamaño;
        }else{
            System.out.println("No existe");
        }

    }

    public void setPrecio_total_comida(int precio_total_comida) {
        precio_total_comida = precio_kebab + precio_carne + precio_tamaño;
        this.precio_total_comida = precio_total_comida;
    }

    public int getPrecio_kebab() {
        return precio_kebab;
    }

    public int getPrecio_carne() {
        return precio_carne;
    }

    public int getPrecio_tamaño() {
        return precio_tamaño;
    }

    public int getPrecio_total_comida() {
        return precio_total_comida;
    }
}
