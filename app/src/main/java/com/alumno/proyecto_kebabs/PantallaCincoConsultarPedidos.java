package com.alumno.proyecto_kebabs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adminportatil on 10/02/2017.
 */

public class PantallaCincoConsultarPedidos  extends AppCompatActivity{

    private Button volver;
    private TextView pedidos;

    String texto="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cinco_consultar_pedidos);

        pedidos = (TextView) findViewById (R.id.txtPedidos);
        volver = (Button) findViewById (R.id.btnSalir);


        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT nombre, id_pedido, precio_total FROM Clientes INNER JOIN Pedidos ON Clientes.id_cliente = Pedidos.id_cliente", null);
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                texto += "NUMERO PEDIDO:  "+cursor.getInt(1);
                texto += "\nNOMBRE CLIENTE:  "+cursor.getString(0);
                texto += "\nPRECIO TOTAL:  "+cursor.getInt(2)+" €\n\n";
            } while(cursor.moveToNext());
        }
        db.close();
        pedidos.setMovementMethod(new ScrollingMovementMethod());
        pedidos.setText(texto);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAtras();
            }
        });
    }
    public void lanzarAtras(){
        finish();
    }
}