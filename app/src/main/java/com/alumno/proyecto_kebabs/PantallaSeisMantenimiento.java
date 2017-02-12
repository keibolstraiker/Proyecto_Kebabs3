package com.alumno.proyecto_kebabs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adminportatil on 12/02/2017.
 */

public class PantallaSeisMantenimiento extends AppCompatActivity  {


    private Button btnClientes;
    private Button btnComidas;
    private Button btnBebidas;
    private Button btnSalir;
    private Button btnComprobar;
    private Button btnBorrar2;
    private TextView nom;
    private TextView dir;
    private TextView tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mantenimiento_main);

        btnClientes = (Button) findViewById(R.id.btnClientes);
        btnComidas = (Button) findViewById(R.id.btnComidas);
        btnBebidas = (Button) findViewById(R.id.btnBebidas);
        btnSalir = (Button) findViewById(R.id.btnSalir);



        btnClientes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                lanzarLayout(1);
            }
        });
        btnComidas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                lanzarLayout(2);
            }
        });
        btnBebidas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                lanzarLayout(3);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }
        });

    }

    public void lanzarLayout(int posicion){
        if (posicion ==1){
            setContentView(R.layout.layout_mantenimiento_clientes);
            btnComprobar = (Button) findViewById(R.id.btnComprobarCli);
            btnBorrar2 = (Button) findViewById(R.id.btnBorrar2);
            btnSalir = (Button) findViewById(R.id.btnSalir);
            nom = (TextView) findViewById(R.id.txtNombre);
            dir = (TextView) findViewById(R.id.txtDireccion);
            tel = (TextView) findViewById(R.id.txtTelefono);

            btnComprobar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean res = comprobarExiste();
                    if (res == false) {
                        Toast.makeText(getApplicationContext(), "Este nombre no ha sido aún registrado",
                                Toast.LENGTH_LONG).show();
                    } else {
                        rellenarCampos();
                    }
                }
            });
            btnBorrar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean res = comprobarExiste();
                    if (res == true){
                        borrarCliente();
                    }else
                        Toast.makeText(getApplicationContext(), "No puedes borrar un cliente que no está registrado",
                                Toast.LENGTH_LONG).show();

                }
            });
            btnSalir.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    finish();
                }
            });
        }else if (posicion ==2){
            setContentView(R.layout.layout_mantenimiento_comidas);
        }else if (posicion == 3){
            setContentView(R.layout.layout_mantenimiento_bebidas);
        }else{
            Toast.makeText(getApplicationContext(), "No ha seleccionado nada de lo debido",
                    Toast.LENGTH_LONG).show();
        }
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
    public void borrarCliente(){
        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        db.delete("Clientes", "nombre="+nom.getText().toString(), null);
        db.close();
    }
}