package com.alumno.proyecto_kebabs;

import android.database.sqlite.SQLiteOpenHelper;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;


public class SentenciadorSQL extends SQLiteOpenHelper {

    //Sentencias SQL para crear las tablas
    String clientes = "CREATE TABLE Clientes (id_cliente INTEGER PRIMARY KEY , nombre TEXT, direccion TEXT, telefono NUMERIC)";
    String tipokebab = "CREATE TABLE TipoKebab (id_tipokebab  INTEGER PRIMARY KEY , nombre TEXT, precio INTEGER)";
    String tipocarne = "CREATE TABLE TipoCarne (id_tipocarne  INTEGER PRIMARY KEY , nombre TEXT, precio INTEGER)";
    String tipotamaño = "CREATE TABLE TipoTamaño (id_tipotamaño  INTEGER PRIMARY KEY , nombre TEXT, precio INTEGER)";
    String bebida = "CREATE TABLE Bebidas (id_bebida INTEGER PRIMARY KEY , nombre TEXT)";
    String lineas = "CREATE TABLE Lineas (id_linea INTEGER  , id_pedido INTEGER ,id_tipokebab INTEGER,id_tipocarne INTEGER," +
            "id_tipotamaño INTEGER, id_bebida INTEGER, cantidad INTEGER, precio INTEGER, PRIMARY KEY(id_linea,id_pedido),FOREIGN KEY(id_pedido) REFERENCES Pedidos(id_pedido)," +
            " FOREIGN KEY(id_tipokebab) REFERENCES TipoKebab(id_tipokebab),FOREIGN KEY(id_tipocarne) REFERENCES TipoCarne(id_tipocarne)," +
            "FOREIGN KEY(id_tipotamaño) REFERENCES TipoTamaño(id_tipotamaño), FOREIGN KEY(id_bebida) REFERENCES Bebidas(id_bebida))";
    String pedido = "CREATE TABLE Pedidos (id_pedido INTEGER PRIMARY KEY , id_cliente INTEGER, fecha DATE, precio_total INTEGER," +
            " FOREIGN KEY(id_cliente) REFERENCES Clientes(id_cliente))";
    //Inserción de cliente Admin
    //Inserción de comidas
    String tk1 = "INSERT INTO TipoKebab(nombre,precio) VALUES('Doner',3)";
    String tk2 = "INSERT INTO TipoKebab(nombre,precio) VALUES('Durum',4)";
    String tk3 = "INSERT INTO TipoKebab(nombre,precio) VALUES('Lamhacun',5)";
    String tk4 = "INSERT INTO TipoKebab(nombre,precio) VALUES('Shawarma',5)";
    String tk5 = "INSERT INTO TipoKebab(nombre,precio) VALUES('Gyros',5)";
    String tc1 = "INSERT INTO TipoCarne(nombre,precio) VALUES('Ternera',0)";
    String tc2 = "INSERT INTO TipoCarne(nombre,precio) VALUES('Pollo',0)";
    String tc3 = "INSERT INTO TipoCarne(nombre,precio) VALUES('Cordero',1)";
    String tt1 = "INSERT INTO TipoTamaño(nombre,precio) VALUES('Normal',0)";
    String tt2 = "INSERT INTO TipoTamaño(nombre,precio) VALUES('Completa',1)";
    //Inserción de bebidas
    String cola = "INSERT INTO Bebidas(nombre) VALUES('CocaCola')";
    String naranja = "INSERT INTO Bebidas(nombre) VALUES('Naranja')";
    String limon = "INSERT INTO Bebidas(nombre) VALUES('Limon')";
    String nestea = "INSERT INTO Bebidas(nombre) VALUES('Nestea')";
    String cerveza = "INSERT INTO Bebidas(nombre) VALUES('Cerveza')";
    String agua = "INSERT INTO Bebidas(nombre) VALUES('Agua')";

    public SentenciadorSQL(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Se ejecutan las sentencias SQL de creación de las tablas
        db.execSQL(clientes);
        db.execSQL(tipokebab);
        db.execSQL(tipocarne);
        db.execSQL(tipotamaño);
        db.execSQL(bebida);
        db.execSQL(lineas);
        db.execSQL(pedido);
        //Se ejecutan las sentencias SQL de inserción de las comidas
        db.execSQL(tk1);
        db.execSQL(tk2);
        db.execSQL(tk3);
        db.execSQL(tk4);
        db.execSQL(tk5);
        db.execSQL(tc1);
        db.execSQL(tc2);
        db.execSQL(tc3);
        db.execSQL(tt1);
        db.execSQL(tt2);
        //Se ejecutan las sentencias SQL de inserción de las bebidas
        db.execSQL(cola);
        db.execSQL(naranja);
        db.execSQL(limon);
        db.execSQL(nestea);
        db.execSQL(cerveza);
        db.execSQL(agua);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Bebidas");

        //Se crea la nueva versión de la tabla
       // db.execSQL(sqlCreate);
    }

}
