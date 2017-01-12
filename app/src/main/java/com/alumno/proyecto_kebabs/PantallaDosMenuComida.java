package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.content.res.Configuration;
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


public class PantallaDosMenuComida extends AppCompatActivity {

    String kebab,carne,tamaño, preciokebab, preciocarne, preciotamaño;
    int  contprecios=0;

    private TextView lblPedido;

    private Spinner cmbTipo_tamaño;
    private Spinner cmbTipo_carne;
    private Spinner cmbTipo_kebab;

    private EditText txtCantidad;

    private Button btnAñadir;
    private Button btnSalir;
    private Button btnSiguiente;

    ArrayList<String> datos;


    ArrayList<String> arraylistcomida = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_dos_menu_comida);

        Bundle extras = getIntent().getExtras();

        datos = extras.getStringArrayList("datos");


        lblPedido = (TextView) findViewById(R.id.lblPedidoBebida);

        cmbTipo_tamaño = (Spinner) findViewById(R.id.cmbTamaño);
        cmbTipo_kebab = (Spinner) findViewById(R.id.cmbTipoKebab);
        cmbTipo_carne = (Spinner) findViewById(R.id.cmbTipoCarne);

        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente3);
        btnSalir = (Button) findViewById(R.id.btnSalir);


        ArrayAdapter<CharSequence> adaptadorKebab =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_kebab, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptadorCarne =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_carne, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptadorTamaño =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_tamaño, android.R.layout.simple_spinner_item);//el array adapter esta señalando al array de strings llamado tamaños


        adaptadorKebab.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_kebab.setAdapter(adaptadorKebab);



        adaptadorCarne.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_carne.setAdapter(adaptadorCarne);


        adaptadorTamaño.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);



        cmbTipo_tamaño.setAdapter(adaptadorTamaño);
        cmbTipo_tamaño.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        switch (position) {
                            case 0:
                                tamaño = null;
                                break;
                            case 1:
                                tamaño = "Normal";
                                preciotamaño = "sin suplemento";
                                break;
                            case 2:
                                tamaño = "Completa";
                                preciotamaño = "+1€";
                                contprecios += 1;
                                break;

                        }
                    }


                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorCarne.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_carne.setAdapter(adaptadorCarne);

        cmbTipo_carne.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario

                        switch (position) {
                            case 0:
                                carne = null;
                                break;
                            case 1:
                                carne = "Ternera";
                                preciocarne = "sin suplemento";
                                break;
                            case 2:
                                carne = "Pollo";
                                preciocarne = "sin suplemento";
                                break;
                            case 3:
                                carne = "Cordero";
                                preciocarne = "+1€";
                                contprecios += 1;
                                break;

                        }



                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorTamaño.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_kebab.setAdapter(adaptadorKebab);

        cmbTipo_kebab.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario

                        switch (position) {
                            case 0:
                                kebab = null;
                                break;
                            case 1:
                                kebab = "Döner";
                                preciokebab = "3€";
                                contprecios += 3;
                                break;
                            case 2:
                                kebab = "Durum";
                                preciokebab = "4€";
                                contprecios += 4;
                                break;
                            case 3:
                                kebab = "Lamhacun";
                                preciokebab = "5€";
                                contprecios += 5;
                                break;
                            case 4:
                                kebab = "Shawarma";
                                preciokebab = "5€";
                                contprecios += 5;
                                break;
                            case 5:
                                kebab = "Gyros";
                                preciokebab = "5€";
                                contprecios += 5;
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });



        btnAñadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAñadir();
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarSiguiente();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarSalir();
            }
        });
    }//aqui termina el OnCreate

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK){
            datos = data.getExtras().getStringArrayList("datos");
        }
    }*/

    public void lanzarAñadir(){


        if (kebab != null && carne != null && tamaño != null) {
            arraylistcomida.add(kebab);
            arraylistcomida.add(preciokebab);
            arraylistcomida.add(carne);
            arraylistcomida.add(preciocarne);
            arraylistcomida.add(tamaño);
            arraylistcomida.add(preciotamaño);

            cmbTipo_kebab.setSelection(0);
            cmbTipo_carne.setSelection(0);
            cmbTipo_tamaño.setSelection(0);
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                    Toast.LENGTH_LONG).show();
        }

        lblPedido.setText(String.valueOf(contprecios));
    }
    public void lanzarSiguiente(){

        if (kebab != null && carne != null && tamaño != null) {

            arraylistcomida.add(String.valueOf(contprecios));

        Intent i = new Intent(this,PantallaTresMenuBebida.class);
        i.putExtra("datos",datos);
        i.putExtra("comida",arraylistcomida);
        startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                    Toast.LENGTH_LONG).show();
            }


        /*este método tiene que acceder a la siguiente aplicación añadiendo al arraylist todo el contenido de los spiner */
    }
    public void lanzarSalir(){
       finish();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}



