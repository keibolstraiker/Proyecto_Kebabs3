package com.alumno.proyecto_kebabs;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PantallaDosMenuComida extends AppCompatActivity {

    String kebab,carne,tamaño;

    private TextView lblPedido;

    private Spinner cmbTipo_tamaño;
    private Spinner cmbTipo_carne;
    private Spinner cmbTipo_kebab;

    private EditText txtCantidad;

    private Button btnAñadir;
    private Button btnSalir;
    private Button btnSiguiente;

    ArrayList<String> datos;


    List<String> arraylistcomida = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_dos_menu_comida);

        lblPedido = (TextView) findViewById(R.id.lblPedido);

        cmbTipo_tamaño = (Spinner) findViewById(R.id.cmbTamaño);
        cmbTipo_kebab = (Spinner) findViewById(R.id.cmbTipoKebab);
        cmbTipo_carne = (Spinner) findViewById(R.id.cmbTipoCarne);

        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
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
                        if (position==0){
                            tamaño=null;
                        }else if (position == 1) {
                            tamaño="Normal";
                        } else if (position == 2) {
                            tamaño="Completa";
                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorCarne.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_carne.setAdapter(adaptadorTamaño);

        cmbTipo_carne.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        if (position == 0) {
                            carne=null;
                        } else if (position == 1) {
                            carne="Ternera";
                        } else if (position == 2) {
                            carne="Pollo";
                        } else if (position == 3) {
                            carne="Cordero";
                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        adaptadorTamaño.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTipo_tamaño.setAdapter(adaptadorTamaño);

        cmbTipo_kebab.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        if (position == 0) {

                            kebab=null;
                        } else if (position == 1) {
                            kebab="Döner";
                        } else if (position == 2) {
                            kebab="Durum";
                        } else if (position == 3) {
                            kebab="Lamhacum";
                        } else if (position == 4) {
                            kebab="Shawarma";
                        } else if (position == 5) {
                            kebab="Gyros";

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

    public void lanzarAñadir(){


        if (kebab != null && carne != null && tamaño != null) {
            arraylistcomida.add(kebab);
            arraylistcomida.add(carne);
            arraylistcomida.add(tamaño);
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                    Toast.LENGTH_LONG).show();
        }

        lblPedido.setText(arraylistcomida.toString());
    }
    public void lanzarSiguiente(){

        Intent i = new Intent(this,PantallaTresMenuBebida.class);
        i.putExtra("datos",datos);
       // i.putExtra("comida",arraylistcomida);
        startActivityForResult(i,2);


        /*este método tiene que acceder a la siguiente aplicación añadiendo al arraylist todo el contenido de los spiner */
    }
    public void lanzarSalir(){
       finish();
    }


}


