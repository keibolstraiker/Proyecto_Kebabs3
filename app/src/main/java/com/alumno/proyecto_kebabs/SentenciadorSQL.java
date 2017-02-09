package com.alumno.proyecto_kebabs;

import android.database.sqlite.SQLiteOpenHelper;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 08/02/2017.
 */
public class SentenciadorSQL extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String clientes = "CREATE TABLE Clientes (id_cliente INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, direccion TEXT, telefono NUMERIC)";
    String tipokebab = "CREATE TABLE TipoKebab (id_tipokebab  INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio INTEGER)";
    String tipocarne = "CREATE TABLE TipoCarne (id_tipocarne  INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio INTEGER)";
    String tipotamaño = "CREATE TABLE TipoTamaño (id_tipotamaño  INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio INTEGER)";
    String bebida = "CREATE TABLE Bebidas (id_bebida INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    String lineas = "CREATE TABLE Lineas (id_linea INTEGER PRIMARY KEY AUTOINCREMENT, id_pedido INTEGER PRIMARY KEY,id_tipokebab INTEGER,id_tipocarne INTEGER," +
            "id_tipotamaño INTEGER, id_bebida INTEGER, cantidad INTEGER, precio INTEGER, FOREIGN KEY(id_pedido) REFERENCES Pedidos(id_pedido)," +
            " FOREIGN KEY(id_tipokebab) REFERENCES TipoKebab(id_tipokebab),FOREIGN KEY(id_tipocarne) REFERENCES TipoCarne(id_tipocarne)," +
            "FOREIGN KEY(id_tipotamaño) REFERENCES TipoTamaño(id_tipotamaño), FOREIGN KEY(id_bebida) REFERENCES Bebidas(id_bebida))";
    String pedido = "CREATE TABLE Pedidos (id_pedido INTEGER PRIMARY KEY AUTOINCREMENT, id_cliente INTEGER, fecha DATE, precio_total INTEGER," +
            " FOREIGN KEY(id_cliente) REFERENCES Clientes(id_cliente))";

    public SentenciadorSQL(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Se ejecuta la sentencia SQL de creación de la tabla

        db.execSQL(clientes);
        db.execSQL(tipokebab);
        db.execSQL(tipocarne);
        db.execSQL(tipotamaño);
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
       // db.execSQL(sqlCreate);
    }

}
