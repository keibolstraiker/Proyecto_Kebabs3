package com.alumno.proyecto_kebabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PantallaCuatroResumenPedido extends AppCompatActivity {

    private TextView resumen;
    private Button realizar;
    private Button atras;

    String texto;
    int totalpedido,bebidaAcumulado = 0, comidaAcumulado = 0, clave;
    Cliente c;
    ArrayList<Comida> arraylistcomida;
    ArrayList<Bebida> arraylistbebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_cuatro_resumen_pedido);

        Intent i = getIntent();
        c = (Cliente)i.getSerializableExtra("cliente");

        arraylistcomida = (ArrayList<Comida>)getIntent().getExtras().getSerializable("comida");
        arraylistbebida = (ArrayList<Bebida>)getIntent().getExtras().getSerializable("bebida");

        resumen = (TextView) findViewById(R.id.lblResumen);
        realizar = (Button) findViewById(R.id.btnRealizar);
        atras = (Button) findViewById(R.id.btnAtras);


        mostrarDatos();
        mostrarComida();
        mostrarBebida();
        calculartotal();
        comprobarregalo();

        resumen.setMovementMethod(new ScrollingMovementMethod());
        resumen.setText(texto);

        realizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarRealizar();
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAtras();
            }
        });
    }

       public void mostrarDatos(){
        texto = "DATOS CLIENTE:\n\n";

            texto += c.getNombre() + "\n" + c.getDireccion() + "\n" + c.getTelefono();

    }
    public void mostrarComida(){
        texto += "\n PARA COMER:\n\n";
        int cont1 = 0, cont2 = 0;
        for(int i=0;i<=(arraylistcomida.size()-1);i++) { // Se recorre el arraylist de la comida.

            //texto += arraylistcomida.get(i).getCantidad() + "DE:\n";
            texto += arraylistcomida.get(i).getTipoKebab() + "  " + arraylistcomida.get(i).getPrecioKebab()+"\n";
            texto += arraylistcomida.get(i).getTipoCarne() + "  " + arraylistcomida.get(i).getPrecioCarne()+"\n";
            texto += arraylistcomida.get(i).getTipoTamaño() + "  " + arraylistcomida.get(i).getPrecioTamaño()+"\n";
            comidaAcumulado = arraylistcomida.get(i).getPrecioTotalComida(); //Se suma en la pantalla 2
            texto +="ACUMULADO:  " + comidaAcumulado + "€\n\n";
        }
    }
    public void mostrarBebida(){  //// Se recorre el arraylist de la bebida. Como sabemos el orden en el que se han almacenado los datos, podemos mostrarlos como queramos.
        texto += "PARA BEBER:\n\n";
        int cont=0, cont2=0;
        for(int i=0;i<=(arraylistbebida.size()-1);i++) {

            texto += arraylistbebida.get(i).getCantidad() + " DE:\n";
            texto += arraylistbebida.get(i).getNombre()+"  "+ arraylistbebida.get(i).getPrecio()+"\n";
            bebidaAcumulado += arraylistbebida.get(i).getPrecio();
            texto +="ACUMULADO: "+ bebidaAcumulado + "€\n\n";
        }
    }

    public void calculartotal(){

        totalpedido = comidaAcumulado + bebidaAcumulado;
        texto += "TOTAL PEDIDO:    " + totalpedido + "€\n\n";
    }

    public void comprobarregalo(){

        if (totalpedido > 23 && totalpedido < 33)
            texto += "¡Ehorabuena! Como su pedido supera los 23€ se lleva un peluche del muñeco de Android de regalo.\n\n";

        if (totalpedido > 33)
            texto += "¡Ehorabuena! Como su pedido supera los 33€ le regalamos un peluche del muñeco de Android y un vale para comer en el comedor de Cebanc.\n\n";
    }
    public void lanzarRealizar(){
        Toast.makeText(getApplicationContext(), "SU PEDIDO HA SIDO REALIZARDO CORRECTAMENTE, UN REPARTIDOR VA DE CAMINO A SU DIRECCIÓN",
                Toast.LENGTH_LONG).show();

        insertarPedido();

        for (int i=0; i<=arraylistcomida.size()-1;i++){
            insertarLineasComida(i);}
        for (int i=0; i<=arraylistbebida.size()-1;i++){
            //insertarLineas();
            }
    }
    public void lanzarAtras(){
        finish();
    }

    public void insertarPedido(){
//Seleccionamos el id del cliente
        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT id_cliente FROM Clientes WHERE nombre = '"+c.getNombre()+"'", null);
        cursor.moveToFirst();
        int idCliente = cursor.getInt(0);
        db.close();

//Pillamos la fecha de hoy
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date date = new Date();

        //Creamos el registro a insertar como objeto ContentValues
        SentenciadorSQL usdbh1 = new SentenciadorSQL(this, "DBKebabs", null, 1);

        db = usdbh1.getWritableDatabase();

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("id_cliente",idCliente);
        nuevoRegistro.put("fecha",dateFormat.format(date));
        nuevoRegistro.put("precio_total", totalpedido);

//Insertamos el registro en la base de datos
        db.insert("Pedidos", null, nuevoRegistro);
        db.close();
    }
    public void insertarLineasComida(int i){
//Pillamos id tipokebab
        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT id_tipokebab FROM TipoKebab WHERE nombre = '"+arraylistcomida.get(i).getTipoKebab()+"'", null);
        cursor.moveToFirst();
       int idkebab = cursor.getInt(0);
        db.close();
//Pillamos id tipocarne
        SentenciadorSQL usdbh1 = new SentenciadorSQL(this, "DBKebabs", null, 1);

        db = usdbh.getWritableDatabase();
        Cursor cursor1 = db.rawQuery(" SELECT id_tipocarne FROM TipoCarne WHERE nombre = '"+arraylistcomida.get(i).getTipoCarne()+"'", null);
        cursor.moveToFirst();
        int idcarne = cursor.getInt(0);
        db.close();
        //Pillamos id tipotamaño
        SentenciadorSQL usdbh2 = new SentenciadorSQL(this, "DBKebabs", null, 1);

        db = usdbh.getWritableDatabase();
        Cursor cursor2 = db.rawQuery(" SELECT id_tipotamaño FROM TipoTamaño WHERE nombre = '"+arraylistcomida.get(i).getTipoTamaño()+"'", null);
        cursor.moveToFirst();
        int idtamaño = cursor.getInt(0);
        db.close();

        //Pillamos id del pedido
        SentenciadorSQL usdbh4 = new SentenciadorSQL(this, "DBUsuarios", null, 1);
        db = usdbh.getWritableDatabase();
        Cursor cursor3 = db.rawQuery(" SELECT id_pedido FROM Pedidos", null);
        if (cursor3.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                clave = cursor3.getInt(0);
            } while(cursor3.moveToNext());
        }
        db.close();

        //Añadimos línea
        SentenciadorSQL usdbh3 = new SentenciadorSQL(this, "DBKebabs", null, 1);

        db = usdbh3.getWritableDatabase();

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("id_pedido",clave);
        nuevoRegistro.put("id_tipokebab",idkebab);
        nuevoRegistro.put("id_tipocarne",idcarne);
        nuevoRegistro.put("id_tipotamaño",idtamaño);
        // nuevoRegistro.put("cantidad",);
        //nuevoRegistro.put("precio",);

        db.insert("Pedidos", null, nuevoRegistro);
        db.close();

    }
}