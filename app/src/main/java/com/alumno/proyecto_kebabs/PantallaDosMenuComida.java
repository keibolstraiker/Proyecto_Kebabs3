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

    String kebab,carne,tamaño;
    int  contprecios=0,preciokebab, preciocarne, preciotamaño;

    private TextView lblPedido;

    private EditText txtCantidad;

    private Spinner cmbTipo_tamaño;
    private Spinner cmbTipo_carne;
    private Spinner cmbTipo_kebab;



    private Button btnAñadir;
    private Button btnSalir;
    private Button btnSiguiente;


    ArrayList<Comida> arraylistcomida = new ArrayList<>();
    Cliente c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_dos_menu_comida);

        Intent i = getIntent();
        c = (Cliente)i.getSerializableExtra("cliente");


        lblPedido = (TextView) findViewById(R.id.lblTítulo);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        cmbTipo_tamaño = (Spinner) findViewById(R.id.cmbTipoTamaño);
        cmbTipo_kebab = (Spinner) findViewById(R.id.cmbTipoKebab);
        cmbTipo_carne = (Spinner) findViewById(R.id.cmbTipoCarne);



        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente3);
        btnSalir = (Button) findViewById(R.id.btnSalir);



        ArrayAdapter<CharSequence> adaptadorKebab =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_kebab, R.layout.spinner_item);
        ArrayAdapter<CharSequence> adaptadorCarne =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_carne, R.layout.spinner_item);
        ArrayAdapter<CharSequence> adaptadorTamaño =
                ArrayAdapter.createFromResource
                        (this, R.array.tipo_tamaño, R.layout.spinner_item);//el array adapter esta señalando al array de strings llamado tamaños


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
                        switch (position) {
                            case 0:
                                tamaño = null;
                                break;
                            case 1:
                                tamaño = "Normal";
                                preciotamaño = 0;
                                break;
                            case 2:
                                tamaño = "Completa";
                                preciotamaño = 1;
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
                R.layout.spinner_dropdown_item);
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
                                preciocarne = 0;
                                break;
                            case 2:
                                carne = "Pollo";
                                preciocarne = 0;
                                break;
                            case 3:
                                carne = "Cordero";
                                preciocarne = 1;
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
                R.layout.spinner_dropdown_item);
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
                                preciokebab = 3;
                                contprecios += 3;
                                break;
                            case 2:
                                kebab = "Durum";
                                preciokebab = 4;
                                contprecios += 4;
                                break;
                            case 3:
                                kebab = "Lamhacun";
                                preciokebab = 5;
                                contprecios += 5;
                                break;
                            case 4:
                                kebab = "Shawarma";
                                preciokebab = 5;
                                contprecios += 5;
                                break;
                            case 5:
                                kebab = "Gyros";
                                preciokebab = 5;
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
                lanzarSiguiente(c,arraylistcomida);
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
            if (txtCantidad.getText().toString().equals("") || Integer.valueOf(txtCantidad.getText().toString())<1){
                txtCantidad.setText("1");
            }
            int cantidad = Integer.valueOf(txtCantidad.getText().toString());
            Comida comida = new Comida();

            comida.setTipoKebab(kebab);
            comida.setPrecioKebab(preciokebab);
            comida.setTipoCarne(carne);
            comida.setPrecioCarne(preciocarne);
            comida.setTipoTamaño(tamaño);
            comida.setPrecioTamaño(preciotamaño);
            comida.setPrecioTotalComida(contprecios);
            comida.setCantidad(cantidad);
            arraylistcomida.add(comida);

            cmbTipo_kebab.setSelection(0);
            cmbTipo_carne.setSelection(0);
            cmbTipo_tamaño.setSelection(0);
            txtCantidad.setHint("Cantidad");

        } else {

            Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                    Toast.LENGTH_LONG).show();
        }


    }
    public void lanzarSiguiente(Cliente c, ArrayList<Comida> a){
        if (arraylistcomida.size() != 0) {

        Intent i = new Intent(this,PantallaTresMenuBebida.class);
        i.putExtra("cliente",c);
        i.putExtra("comida",a);
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



