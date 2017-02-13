package com.alumno.proyecto_kebabs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 12/02/2017.
 */

public class PantallaSeisMantenimiento extends AppCompatActivity  {

    String kebab,carne,tamaño;
    int preciokebab, preciocarne, preciotamaño, cont;
    private Button btnClientes;
    private Button btnComidas;
    private Button btnBebidas;
    private Button btnSalir;
    private Button btnComprobar;
    private Button btnBorrar2;
    private Button btnInsertarC;
    private Button btnBorrarC;
    private Button btnBorrarComida;
    private Button btnInsertarComida;
    private EditText tipoKebab;
    private EditText precioTipoKebab;
    private EditText tipoCarne;
    private EditText precioTipoCarne;
    private EditText tipoTamaño;
    private EditText precioTipoTamaño;
    private Button btnVolver;
    private TextView nom;
    private TextView dir;
    private TextView tel;
    private Spinner cmbTipo_tamaño;
    private Spinner cmbTipo_carne;
    private Spinner cmbTipo_kebab;

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
            btnInsertarC = (Button) findViewById(R.id.btnInsertarC);
            btnBorrarC = (Button) findViewById(R.id.btnBorrarC);
            btnInsertarC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutInsertarComidas();
                }
            });
            btnBorrarC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutBorrarComidas();
                }
            });
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
        String borrar ="DELETE FROM Clientes WHERE nombre='"+nom.getText().toString()+"'";
        SQLiteDatabase db = usdbh.getWritableDatabase();
        db.execSQL(borrar);
        db.close();
    }
    public void layoutInsertarComidas(){
        setContentView(R.layout.layout_insertar_comidas);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnInsertarComida = (Button) findViewById(R.id.btnInsertarComida);
        tipoKebab = (EditText) findViewById(R.id.txtTipoKebab);
        precioTipoKebab = (EditText) findViewById(R.id.txtPrecioTipoKebab);
        tipoCarne = (EditText) findViewById(R.id.txtTipoCarne);
        precioTipoCarne = (EditText) findViewById(R.id.txtPrecioTipoCarne);
        tipoTamaño = (EditText) findViewById(R.id.txtTipoTamaño);
        precioTipoTamaño = (EditText) findViewById(R.id.txtPrecioTipoTamaño);

        btnInsertarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI SE TIENE QUE COMPROBAR QUE TODO ESTE REYENO PARA EL INSERT.
            }
        });
        }
    public void layoutBorrarComidas(){
        setContentView(R.layout.layout_borrar_comidas);
        cmbTipo_tamaño = (Spinner) findViewById(R.id.cmbTipoTamaño);
        cmbTipo_kebab = (Spinner) findViewById(R.id.cmbTipoKebab);
        cmbTipo_carne = (Spinner) findViewById(R.id.cmbTipoCarne);
        btnBorrarComida = (Button) findViewById(R.id.btnBorrarComida);

        btnBorrarComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI SE TIENE QUE HACER EL DELETE
            }
        });

        ArrayAdapter<CharSequence> adaptadorKebab =
                new ArrayAdapter
                        (this, R.layout.spinner_item, spinnerKebab());
        ArrayAdapter<CharSequence> adaptadorCarne =
                new ArrayAdapter
                        (this,  R.layout.spinner_item, spinnerCarne());
        ArrayAdapter<CharSequence> adaptadorTamaño =
                new ArrayAdapter
                        (this,  R.layout.spinner_item, spinnerTamaño());//el array adapter esta señalando al array de strings llamado tamaños


        adaptadorKebab.setDropDownViewResource(
                R.layout.spinner_dropdown_item);
        cmbTipo_kebab.setAdapter(adaptadorKebab);



        adaptadorCarne.setDropDownViewResource(
                R.layout.spinner_dropdown_item);
        cmbTipo_carne.setAdapter(adaptadorCarne);


        adaptadorTamaño.setDropDownViewResource(
                R.layout.spinner_dropdown_item);



        cmbTipo_tamaño.setAdapter(adaptadorTamaño);
        cmbTipo_tamaño.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        obtenerTamaño(position);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorCarne.setDropDownViewResource(
                R.layout.spinner_dropdown_item);
        cmbTipo_carne.setAdapter(adaptadorCarne);

        cmbTipo_carne.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        obtenerCarne(position);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorTamaño.setDropDownViewResource(
                R.layout.spinner_dropdown_item);
        cmbTipo_kebab.setAdapter(adaptadorKebab);

        cmbTipo_kebab.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        obtenerKebab(position);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
    public ArrayList<String> spinnerKebab(){
        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM TipoKebab", null);
        ArrayList<String> spinner1 = new ArrayList<>();
        spinner1.add("Seleccione una opción");
        if (cursor.moveToFirst()) {
            do {
                if(cursor.getInt(2)==0) {
                    spinner1.add(cursor.getString(1) + "        (Sin Suplemento)");

                }else
                    spinner1.add(cursor.getString(1) + " " + String.valueOf(cursor.getInt(2))+" €");
            } while (cursor.moveToNext());
        }
        db.close();
        return spinner1;
    }
    public ArrayList<String> spinnerCarne(){
        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM TipoCarne", null);
        ArrayList<String> spinner2 = new ArrayList<>();
        spinner2.add("Seleccione una opción");
        if (cursor.moveToFirst()) {
            do {
                if(cursor.getInt(2)==0) {
                    spinner2.add(cursor.getString(1) + "        (Sin Suplemento)");

                }else
                    spinner2.add(cursor.getString(1) + "    + " + String.valueOf(cursor.getInt(2))+" €");
            } while (cursor.moveToNext());
        }
        db.close();
        return spinner2;
    }
    public ArrayList<String> spinnerTamaño(){
        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM TipoTamaño", null);
        ArrayList<String> spinner3 = new ArrayList<>();
        spinner3.add("Seleccione una opción");
        if (cursor.moveToFirst()) {
            do {
                if(cursor.getInt(2)==0) {
                    spinner3.add(cursor.getString(1) + "       (Sin Suplemento)");

                }else
                    spinner3.add(cursor.getString(1) + "    + " + String.valueOf(cursor.getInt(2))+" €");
            } while (cursor.moveToNext());
        }
        db.close();

        return spinner3;
    }
    public void obtenerTamaño(int pos){

        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor3 = db.rawQuery(" SELECT * FROM TipoTamaño", null);
        if (cursor3.moveToFirst()) {
            cont=1;
            while (cont<=pos){
                tamaño = cursor3.getString(1);
                preciotamaño = cursor3.getInt(2);
                cont++;
                cursor3.moveToNext();
            }
        }
        if (pos == 0)
            tamaño = null;
        db.close();
    }
    public void obtenerCarne(int pos){
        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM TipoCarne", null);
        if (cursor.moveToFirst()) {
            cont=1;
            while (cont<=pos) {
                carne = cursor.getString(1);
                preciocarne = cursor.getInt(2);
                cont++;
                cursor.moveToNext();
            }
        }
        if (pos == 0)
            carne = null;
        db.close();
    }
    public void obtenerKebab(int pos){
        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor3 = db.rawQuery(" SELECT * FROM TipoKebab", null);
        if (cursor3.moveToFirst()) {
            cont=1;
            while (cont<=pos){
                kebab = cursor3.getString(1);
                preciokebab = cursor3.getInt(2);
                cont++;
                cursor3.moveToNext();
            }
        }
        if (pos == 0)
            kebab = null;
        db.close();
    }
    }






