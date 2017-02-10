package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PantallaTresMenuBebida extends AppCompatActivity {


    private EditText cantidad;

    private Button btnSiguiente3;
    private Button btnSalir3;
    private Button btnAñadir2;
    private Spinner cmbBebida;

    String tipobebida;

    int precio,cant,contprecios = 0;


    ArrayList<Bebida> arraylistbebida = new ArrayList<>();


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

        cmbBebida = (Spinner) findViewById(R.id.cmbBebida);

        cantidad = (EditText)  findViewById (R.id.edtCantidad);


        btnSiguiente3 = (Button) findViewById(R.id.btnSiguiente3);
        btnSalir3 = (Button) findViewById(R.id.btnSalir);
        btnAñadir2 = (Button) findViewById(R.id.btnAñadir2);

        ArrayAdapter<CharSequence> adaptadorBebida =
                new ArrayAdapter
                        (this, R.layout.spinner_item, spinnerBebida());

        adaptadorBebida.setDropDownViewResource(
                R.layout.spinner_dropdown_item);
        cmbBebida.setAdapter(adaptadorBebida);

        cmbBebida.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {// el parametro posición se va a posicionar en el item del array exacto del spiner  el cual pinche el usuario

                        switch (position) {
                            case 0:
                                tipobebida = null;
                                break;
                            case 1:
                                tipobebida = "CocaCola";
                                precio = 2;
                                contprecios += 2;
                                break;
                            case 2:
                                tipobebida = "Naranja";
                                precio = 2;
                                contprecios += 2;
                                break;
                            case 3:
                                tipobebida = "Limon";
                                precio = 2;
                                contprecios += 2;
                                break;
                            case 4:
                                tipobebida = "Nestea";
                                precio = 3;
                                contprecios += 3;
                                break;
                            case 5:
                                tipobebida = "Cerveza";
                                precio = 3;
                                contprecios += 3;
                                break;
                            case 6:
                                tipobebida = "Agua";
                                precio = 1;
                                contprecios += 1;
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                                Toast.LENGTH_LONG).show();
                    }
                });

        btnAñadir2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                añadirBebidas();
            }
        });

        btnSiguiente3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                lanzarSiguiente(c,arraylistcomida,arraylistbebida);
            }
        });

        btnSalir3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               lanzarSalir();
            }
        });
    }

        public void añadirBebidas (){

            if ( tipobebida != null) {
                if (cantidad.getText().toString().equals("") || Integer.valueOf(cantidad.getText().toString())<1){
                    cantidad.setText("1");
                }

                Bebida bebida = new Bebida(tipobebida, precio, cant);
                arraylistbebida.add(bebida);

                cmbBebida.setSelection(0);
                cantidad.setHint("Cantidad");
            }else{

                Toast.makeText(getApplicationContext(), "Por favor, debe seleccionar una opción",
                        Toast.LENGTH_LONG).show();
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
    public ArrayList<String> spinnerBebida(){

        SentenciadorSQL usdbh =
                new SentenciadorSQL(this, "DBKebabs", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM Bebidas", null);
        ArrayList<String> spinner4 = new ArrayList<>();
        spinner4.add("Seleccione una opción");
        if (cursor.moveToFirst()) {
            do {
                spinner4.add(cursor.getString(1) + "    + " + String.valueOf(cursor.getInt(2))+" €");
            } while (cursor.moveToNext());
        }
        db.close();
        return spinner4;
    }

}
