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



    ArrayList<Bebida> arraylistbebida = new ArrayList<>();

    int totalcola, totallimon, totalnaranja, totalnestea, totalcerveza,totalagua,cantidad,contprecios = 0;
    Cliente c;
    ArrayList<Comida> arraylistcomida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_tres_menu_bebida);

        Intent i = getIntent();
        c = (Cliente)i.getSerializableExtra("cliente");

        arraylistcomida = (ArrayList<Comida>)getIntent().getExtras().getSerializable("comida");

       // Bundle extras = getIntent().getExtras();
        //arraylistcomida = extras.getArrayList("comida");

        txtCola = (EditText) findViewById(R.id.edtCantCola);
        txtNaranja = (EditText) findViewById(R.id.edtCantNaranja);
        txtLimon = (EditText) findViewById(R.id.edtCantLimon);
        txtNestea = (EditText) findViewById(R.id.edtCantNestea);
        txtCerveza = (EditText) findViewById(R.id.edtCantCerveza);
        txtAgua = (EditText) findViewById(R.id.edtCantAgua);

        lblPrecioCola = (TextView) findViewById(R.id.txtPrecioCola);
        lblPrecioLimon = (TextView) findViewById(R.id.txtPrecioLimon);
        lblPrecioNaranja = (TextView) findViewById(R.id.txtPrecioNaranja);
        lblPrecioNestea = (TextView) findViewById(R.id.txtPrecioNestea);
        lblPrecioCerveza= (TextView) findViewById(R.id.txtPrecioCerveza);
        lblPrecioAgua = (TextView) findViewById(R.id.txtPrecioAgua);
        lblTotal = (TextView) findViewById(R.id.lblPrecioTotal);

        btnSiguiente3 = (Button) findViewById(R.id.btnSiguiente3);
        btnSalir3 = (Button) findViewById(R.id.btnSalir);

        txtCola.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int preciocola=2;

                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totalcola = cantidad * preciocola;
                lblPrecioCola.setText(String.valueOf(totalcola));
                contprecios += Integer.parseInt(lblPrecioCola.getText().toString());
                lblTotal.setText(String.valueOf(contprecios));
            }
            @Override
            public void afterTextChanged(Editable s) {


            }});

        txtNaranja.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int precionaranja=2;
                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totalnaranja = cantidad * precionaranja;
                lblPrecioNaranja.setText(String.valueOf(totalnaranja));
                contprecios += Integer.parseInt(lblPrecioNaranja.getText().toString());
                lblTotal.setText(String.valueOf(contprecios)+"€");
            }
            @Override

            public void afterTextChanged(Editable s) {

            }});

        txtLimon.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int preciolimon=2;
                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totallimon = cantidad * preciolimon;
                lblPrecioLimon.setText(String.valueOf(totallimon));
                contprecios += Integer.parseInt(lblPrecioLimon.getText().toString());
                lblTotal.setText(String.valueOf(contprecios));
            }
            @Override
            public void afterTextChanged(Editable s) {
            }});

        txtNestea.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int precionestea=3;
                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totalnestea = cantidad * precionestea;
                lblPrecioNestea.setText(String.valueOf(totalnestea));
                contprecios += Integer.parseInt(lblPrecioNestea.getText().toString());
                lblTotal.setText(String.valueOf(contprecios));
            }
            @Override
            public void afterTextChanged(Editable s) {

            }});

        txtCerveza.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int preciocerveza=3;
                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totalcerveza = cantidad * preciocerveza;
                lblPrecioCerveza.setText(String.valueOf(totalcerveza));
                contprecios += Integer.parseInt(lblPrecioCerveza.getText().toString());
                lblTotal.setText(String.valueOf(contprecios));
            }


            public void afterTextChanged(Editable s) {

            }});

        txtAgua.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int precioagua=1;
                if (String.valueOf(s)==""){
                    cantidad=0;
                }else{
                    cantidad = Integer.valueOf(s.toString());
                }

                totalagua = cantidad * precioagua;
                lblPrecioAgua.setText(String.valueOf(totalagua));
                contprecios += Integer.parseInt(lblPrecioAgua.getText().toString());
                lblTotal.setText(String.valueOf(contprecios));
            }

            @Override
            public void afterTextChanged(Editable s) {}});



        btnSiguiente3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                ContabilizarBebidas();
                lanzarSiguiente(c,arraylistcomida,arraylistbebida);
            }
        });

        btnSalir3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               lanzarSalir();
            }
        });
    }

        public void ContabilizarBebidas (){

            if (txtCola.getText().length()>0){
                Bebida bebida = new Bebida ("CocaCola",totalcola,cantidad);
                arraylistbebida.add(bebida);
                }

            if (txtLimon.getText().length()>0){
                Bebida bebida = new Bebida ("Limon",totallimon,cantidad);
                arraylistbebida.add(bebida);
                }

            if (txtNaranja.getText().length()>0){
                Bebida bebida = new Bebida ("Naranja",totalnaranja,cantidad);
                arraylistbebida.add(bebida);
               }

            if (txtNestea.getText().length()>0){
                Bebida bebida = new Bebida ("Nestea",totalnestea,cantidad);
                arraylistbebida.add(bebida);
                }

            if (txtCerveza.getText().length()>0){
                Bebida bebida = new Bebida ("Cerveza",totalcerveza,cantidad);
                arraylistbebida.add(bebida);
                }

            if (txtAgua.getText().length()>0){
                Bebida bebida = new Bebida ("Agua",totalagua,cantidad);
                arraylistbebida.add(bebida);
                }
        }

    public void lanzarSiguiente(Cliente c, ArrayList<Comida> a, ArrayList<Bebida> b){

        Intent i = new Intent(this,PantallaCuatroResumenPedido.class);
        i.putExtra("cliente", c);
        i.putExtra("comida",a);
        i.putExtra("bebida",b);
        startActivity(i);

    }

    public void lanzarSalir(){
        finish();
    }
}
