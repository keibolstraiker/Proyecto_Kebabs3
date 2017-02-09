package com.alumno.proyecto_kebabs;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by adminportatil on 08/02/2017.
 */
public class Comida implements Serializable {

    private String TipoKebab;
    private String PrecioKebab;
    private String TipoCarne;
    private String PrecioCarne;
    private String TipoTamaño;
    private String PrecioTamaño;
    private int PrecioTotalComida;
    private int Cantidad;

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getPrecioCarne() {
        return PrecioCarne;
    }

    public void setPrecioCarne(String precioCarne) {
        PrecioCarne = precioCarne;
    }

    public String getPrecioKebab() {
        return PrecioKebab;
    }

    public void setPrecioKebab(String precioKebab) {
        PrecioKebab = precioKebab;
    }

    public String getPrecioTamaño() {
        return PrecioTamaño;
    }

    public void setPrecioTamaño(String precioTamaño) {
        PrecioTamaño = precioTamaño;
    }

    public int getPrecioTotalComida() {
        return PrecioTotalComida;
    }

    public void setPrecioTotalComida(int precioTotalComida) {
        PrecioTotalComida = precioTotalComida;
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
