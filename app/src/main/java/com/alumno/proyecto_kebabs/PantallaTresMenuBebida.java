package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;


public class PantallaTresMenuBebida extends AppCompatActivity {


    private EditText txtCola;
    private EditText txtLimon;
    private EditText txtNaranja;
    private EditText txtNestea;
    private EditText txtCerveza;
    private EditText txtAgua;
    private TextView lblPrecioCola;
    private TextView lblPrecioLimon;
    private TextView lblPrecioNaranja;
    private TextView lblPrecioNestea;
    private TextView lblPrecioCerveza;
    private TextView lblPrecioAgua;

    ArrayList<String> datos;
    ArrayList<String> arraylistcomida;
    ArrayList<String> arraylistbebida = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_tres_menu_bebida);


        txtCola = (EditText) findViewById(R.id.txtCola);
        txtNaranja = (EditText) findViewById(R.id.txtNaranja);
        txtLimon = (EditText) findViewById(R.id.txtLimon);
        txtNestea = (EditText) findViewById(R.id.txtNestea);
        txtCerveza = (EditText) findViewById(R.id.txtCerveza);
        txtAgua = (EditText) findViewById(R.id.txtAgua);

        lblPrecioCola = (TextView) findViewById(R.id.lblPrecioCola);
        lblPrecioLimon = (TextView) findViewById(R.id.lblPrecioLimon);
        lblPrecioNaranja = (TextView) findViewById(R.id.lblPrecioNaranja);
        lblPrecioNestea = (TextView) findViewById(R.id.lblPrecioNestea);
        lblPrecioCerveza= (TextView) findViewById(R.id.lblPrecioCerveza);
        lblPrecioAgua = (TextView) findViewById(R.id.lblPrecioAgua);

        txtCola.addTextChangedListener(new TextWatcher(){

            public void onTextChanged(CharSequence s){

            }

            public void beforeTextChaged(CharSequence s){

            }
            public void afterTextChanged(CharSequence s){

            }

         //   lblPrecioCola.setText(txtCola.toString);
       });

    }



    public void lanzarSiguiente(){

        Intent i = new Intent(this,PantallaTresMenuBebida.class);
        i.putExtra("datos",datos);
        i.putExtra("comida",arraylistcomida);
        i.putExtra("bebida",arraylistbebida);
        startActivityForResult(i,3);

    }

    public void lanzarSalir(){
        finish();
    }
}
