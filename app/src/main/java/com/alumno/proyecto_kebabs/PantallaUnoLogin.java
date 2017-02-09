package com.alumno.proyecto_kebabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class PantallaUnoLogin extends AppCompatActivity {

    private Button salir;
    private Button siguiente;
    private TextView nom;
    private TextView dir;
    private TextView tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_uno_login);

        nom = (TextView) findViewById(R.id.txtNombre);
        dir = (TextView) findViewById(R.id.txtDireccion);
        tel = (TextView) findViewById(R.id.txtTelefono);
        siguiente = (Button) findViewById(R.id.btnSiguiente3);
        salir = (Button) findViewById(R.id.btnSalir);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                    if (nom.getText().length() > 0) {
                        if (dir.getText().length() > 0) {
                            if (tel != null && !tel.equals("")) {

                                Cliente cliente = new Cliente();

                                cliente.setNombre(nom.getText().toString());
                                cliente.setDireccion(dir.getText().toString());
                                cliente.setTelefono(tel.getText().toString());


                                //datos.add(nom.getText().toString());
                                //datos.add(dir.getText().toString());
                                //datos.add(tel.getText().toString());

                                //Gari aquí hay un problema ya que estás haciendo "add" a datos y
                                // es un metodo de arraylist y datos es un array normal de Strings
                                //todavía no se como fucionan los arrayList lo tengo que mirar si no corregiría esto.
                                //de echo ahora no me sale el array datos, creo que te lo he pisado de alguna manera,
                                // tenemos que quedar para hacer esto

                                LanzarActividadDos(cliente);

                            } else {
                               tel.setError("Debes introducir un teléfono");
                            }

                        } else {
                            dir.setError("Debes introducir una dirección");
                        }
                    } else {
                        nom.setError("Debes introducir un nombre");
                    }

                }

        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                finish();
            }
        });
    }
public void LanzarActividadDos(Cliente c){

    SentenciadorSQL sentsql = new SentenciadorSQL(this,"DBKebabs",null,1);
    SQLiteDatabase db = sentsql.getWritableDatabase();
    Cursor cursor = db.rawQuery(" SELECT count(*) FROM Clientes WHERE nombre = '"+nom.getText().toString()+"'", null);
    cursor.moveToFirst();
    if (cursor.getInt(0)==0) {

        SentenciadorSQL sentsql1 = new SentenciadorSQL(this,"DBKebabs",null,1);
        SQLiteDatabase db1 = sentsql1.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", nom.getText().toString());
        nuevoRegistro.put("direccion", dir.getText().toString());
        nuevoRegistro.put("telefono", tel.getText().toString());
        db1.insert("Clientes", null, nuevoRegistro);
        db1.close();
    }
    db.close();
    Intent i = new Intent(this, PantallaDosMenuComida.class);
    i.putExtra("cliente", c);
    startActivity(i);
}
}
