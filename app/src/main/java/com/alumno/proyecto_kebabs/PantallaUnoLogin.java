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
import android.widget.Toast;


public class PantallaUnoLogin extends AppCompatActivity {

    private Button salir;
    private Button siguiente;
    private Button comprobar;
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
        siguiente = (Button) findViewById(R.id.btnSiguiente);
        salir = (Button) findViewById(R.id.btnSalir);
        comprobar = (Button) findViewById(R.id.btnComprobarCliente);

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

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res = comprobarExiste();
                if(res == false) {
                    Toast.makeText(getApplicationContext(), "Este nombre no ha sido aún registrado",
                            Toast.LENGTH_LONG).show();
                }else{
                    rellenarCampos();
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

    boolean res = comprobarExiste();

    if(res == false) {

            SentenciadorSQL sentsql1 = new SentenciadorSQL(this, "DBKebabs", null, 1);
            SQLiteDatabase db1 = sentsql1.getWritableDatabase();
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", nom.getText().toString());
            nuevoRegistro.put("direccion", dir.getText().toString());
            nuevoRegistro.put("telefono", tel.getText().toString());
            db1.insert("Clientes", null, nuevoRegistro);
            db1.close();
    }
    Intent i = new Intent(this, PantallaDosMenuComida.class);
    i.putExtra("cliente", c);
    startActivity(i);
}
    public boolean comprobarExiste(){

        SentenciadorSQL sentsql = new SentenciadorSQL(this,"DBKebabs",null,1);
        SQLiteDatabase db1 = sentsql.getWritableDatabase();
        Cursor cursor = db1.rawQuery(" SELECT count(*) FROM Clientes WHERE nombre = '"+nom.getText().toString()+"'", null);
        cursor.moveToFirst();
        if (cursor.getInt(0)==0){
            return false;}
        else{
            return true;}
    }
    public void rellenarCampos(){

        SentenciadorSQL sentsql = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = sentsql.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT direccion, telefono FROM Clientes WHERE nombre = '" + nom.getText().toString() + "'", null);
        cursor.moveToFirst();
        dir.setText(cursor.getString(0));
        tel.setText(cursor.getString(1));
    }
}
