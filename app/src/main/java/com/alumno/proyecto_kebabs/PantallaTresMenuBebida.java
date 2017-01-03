package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
    private TextView lblTotal;
    private Button btnSiguiente3;
    private Button btnSalir3;

    ArrayList<String> datos;
    ArrayList<String> arraylistcomida;
    ArrayList<String> arraylistbebida = new ArrayList<>();

    int totalcola, totallimon, totalnaranja, totalnestea, totalcerveza,totalagua,contprecios = 0;

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
        lblTotal = (TextView) findViewById(R.id.lblTotal);

        btnSiguiente3 = (Button) findViewById(R.id.btnSiguiente3);
        btnSalir3 = (Button) findViewById(R.id.btnSalir3);

        txtCola.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int preciocola=2;
                int cantidad = Integer.parseInt(s.toString());
                totalcola = cantidad * preciocola;
                lblPrecioCola.setText(totalcola);
                contprecios += Integer.parseInt(lblPrecioCola.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});

        txtNaranja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int precionaranja=2;
                int cantidad = Integer.parseInt(s.toString());
                totalcola = cantidad * precionaranja;
                lblPrecioNaranja.setText(totalnaranja);
                contprecios += Integer.parseInt(lblPrecioNaranja.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});

        txtLimon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int preciolimon=2;
                int cantidad = Integer.parseInt(s.toString());
                totallimon = cantidad * preciolimon;
                lblPrecioLimon.setText(totallimon);
                contprecios += Integer.parseInt(lblPrecioLimon.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});

        txtNestea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int precionestea=3;
                int cantidad = Integer.parseInt(s.toString());
                totalnestea = cantidad * precionestea;
                lblPrecioNestea.setText(totalnestea);
                contprecios += Integer.parseInt(lblPrecioNestea.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});

        txtCerveza.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int preciocerveza=3;
                int cantidad = Integer.parseInt(s.toString());
                totalcerveza = cantidad * preciocerveza;
                lblPrecioCerveza.setText(totalcerveza);
                contprecios += Integer.parseInt(lblPrecioCerveza.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});

        txtAgua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                int precioagua=1;
                int cantidad = Integer.parseInt(s.toString());
                totalagua = cantidad * precioagua;
                lblPrecioAgua.setText(totalagua);
                contprecios += Integer.parseInt(lblPrecioAgua.toString());
                lblTotal.setText(Integer.valueOf(contprecios));
            }});



        btnSiguiente3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                ContabilizarBebidas();
            }
        });
    }

        public void ContabilizarBebidas (){

            if (txtCola.getText().length()>0){
               arraylistbebida.add(txtCola.toString());
                arraylistbebida.add("CocaCola");
                arraylistbebida.add(String.valueOf(totalcola));
                }

            if (txtLimon.getText().length()>0){
                arraylistbebida.add(txtLimon.toString());
                arraylistbebida.add("Limón");
                arraylistbebida.add(String.valueOf(totallimon));
                }

            if (txtNaranja.getText().length()>0){
                arraylistbebida.add(txtNaranja.toString());
                arraylistbebida.add("Naranja");
                arraylistbebida.add(String.valueOf(totalnaranja));
               }

            if (txtNestea.getText().length()>0){
                arraylistbebida.add(txtNestea.toString());
                arraylistbebida.add("Nestea");
                arraylistbebida.add(String.valueOf(totalnestea));
                }

            if (txtCerveza.getText().length()>0){
                arraylistbebida.add(txtCerveza.toString());
                arraylistbebida.add("Cerveza");
                arraylistbebida.add(String.valueOf(totalcerveza));
                }

            if (txtAgua.getText().length()>0){
                arraylistbebida.add(txtAgua.toString());
                arraylistbebida.add("Agua");
                arraylistbebida.add(String.valueOf(totalagua));
                }

            arraylistbebida.add(String.valueOf(contprecios));
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
