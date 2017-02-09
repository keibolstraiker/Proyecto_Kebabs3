package com.alumno.proyecto_kebabs;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by adminportatil on 08/02/2017.
 */
public class Comida implements Serializable {

    private String TipoKebab;
    private int PrecioKebab;
    private String TipoCarne;
    private int PrecioCarne;
    private String TipoTamaño;
    private int PrecioTamaño;
    private int Precio;
    private int Cantidad;

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getPrecioCarne() {
        return PrecioCarne;
    }

    public void setPrecioCarne(int precioCarne) {
        PrecioCarne = precioCarne;
    }

    public int getPrecioKebab() {
        return PrecioKebab;
    }

    public void setPrecioKebab(int precioKebab) {
        PrecioKebab = precioKebab;
    }

    public int getPrecioTamaño() {
        return PrecioTamaño;
    }

    public void setPrecioTamaño(int precioTamaño) {
        PrecioTamaño = precioTamaño;
    }

    public int getPrecioTotalComida() {
        return Precio;
    }

    public void setPrecioTotalComida(int precioTotalComida) {
        Precio = precioTotalComida;
    }

    public String getTipoTamaño() {
        return TipoTamaño;
    }

    public void setTipoTamaño(String tipoTamaño) {
        TipoTamaño = tipoTamaño;
    }

    public String getTipoKebab() {
        return TipoKebab;
    }

    public void setTipoKebab(String tipoKebab) {
        TipoKebab = tipoKebab;
    }

    public String getTipoCarne() {
        return TipoCarne;
    }

    public void setTipoCarne(String tipoCarne) {
        TipoCarne = tipoCarne;
    }
}
