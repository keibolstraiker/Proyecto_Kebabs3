package com.alumno.proyecto_kebabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SentenciadorSQL extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String clientes = "CREATE TABLE Clientes (id_cliente INTEGER PRIMARY KEY, nombre TEXT, direccion TEXT, telefono NUMERIC)";
    String comida = "CREATE TABLE Comidas (id_comida INTEGER PRIMARY KEY, tipo_kebab TEXT, precio_tipo_kebab INTEGER, tipo_carne TEXT, precio_tipo_carne INTEGER, tipo_tamaño TEXT, precio_tipo_tamaño INTEGER, precio_total_comida INTEGER)";
    String bebida = "CREATE TABLE Bebidas (id_bebida INTEGER PRIMARY KEY, coca INTEGER, precio_coca INTEGER, naranja INTEGER, precio_naranja INTEGER, limon INTEGER, precio_limon INTEGER, agua INTEGER, precio_agua INTEGER, cerveza INTEGER, precio_cerveza INTEGER, nestea INTEGER, precio_nestea INTEGER, precio_total_bebida INTEGER)";
    String lineas = "CREATE TABLE Lineas (id_linea INTEGER PRIMARY KEY, id_pedido INTEGER PRIMARY KEY,id_comida INTEGER, id_bebida INTEGER, cantidad INTEGER, precio INTEGER, FOREIGN KEY(id_pedido) REFERENCES Pedidos(id_pedido), FOREIGN KEY(id_comida) REFERENCES Comidas(id_comida), FOREIGN KEY(id_bebida) REFERENCES Bebidas(id_bebida))";
    String pedido = "CREATE TABLE Pedidos (id_pedido INTEGER PRIMARY KEY, id_cliente INTEGER, fecha DATE, precio_total INTEGER, FOREIGN KEY(id_cliente) REFERENCES Clientes(id_cliente))";

    public SentenciadorSQL(Context contexto, String nombre,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(clientes);
        db.execSQL(comida);
        db.execSQL(bebida);
        db.execSQL(lineas);
        db.execSQL(pedido);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        //Se crea la nueva versión de la tabla
        db.execSQL(clientes);
        db.execSQL(comida);
        db.execSQL(bebida);
        db.execSQL(lineas);
        db.execSQL(pedido);
    }
    public boolean existeCliente (SQLiteDatabase db,Cliente nom){
        int contar;

        String consulta = "SELECT Count(*) FROM Clientes Where nombre='"+nom.getNombre()+"'";
        contar = Integer.parseInt(db.execSQL(consulta));



        return true;
    }
}
