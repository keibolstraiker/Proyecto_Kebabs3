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


public class PantallaDosMenuComida extends AppCompatActivity {


    private TextView lblPedido;

    private Spinner cmbTipo_tamaño;
    private Spinner cmbTipo_carne;
    private Spinner cmbTipo_kebab;

    private EditText txtCantidad;

    private Button btnAñadir;
    private Button btnSalir;
    private Button btnSiguiente;

    ArrayList<String> datos;


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
        cmbTipo_kebab.setAdapter(adaptadorTamaño);


        cmbTipo_kebab.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        if (position == 0) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el Doner.
                        } else if (position == 1) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el durum.
                        } else if (position == 2) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el lamhacum.
                        } else if (position == 3) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el Shawarma.
                        } else if (position == 4) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el Gyros.
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
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el ternera.
                        } else if (position == 1) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el pollo.
                        } else if (position == 2) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el cordero.
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

        cmbTipo_tamaño.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario
                        if (position == 0) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el tamaño normal.
                        } else if (position == 1) {
                            //aquí habra que meter en el arrai list que va recabando toda la informacion del pedido el tamaño completo.
                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });
        txtCantidad.setText(Integer.parseInt("1"));

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK){

            datos = data.getExtras().getStringArrayList("datos");
        }
    }

    public void lanzarAñadir(){

        cmbTipo_kebab.clearFocus();
        cmbTipo_carne.clearFocus();
        cmbTipo_tamaño.clearFocus();
        
        /*este método tiene que añadir al arraylist todo lo que hemos asignado en cada Spinner y reiniciarlos a 0 para añadir otro*/
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


