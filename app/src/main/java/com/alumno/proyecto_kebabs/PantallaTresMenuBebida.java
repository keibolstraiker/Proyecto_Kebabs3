package com.alumno.proyecto_kebabs;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;


public class PantallaTresMenuBebida extends AppCompatActivity {

    private EditText cantidad;

    private Button btnSiguiente3;
    private Button btnSalir3;
    private Button btnAñadir2;
    private Spinner cmbBebida;

    String tipobebida;

    int precio,cant,cont;

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

                        obtenerBebida(position);
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
                cant =Integer.parseInt(cantidad.getText().toString());

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
    public void obtenerBebida(int pos){
        SentenciadorSQL usdbh = new SentenciadorSQL(this, "DBKebabs", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        Cursor cursor3 = db.rawQuery(" SELECT * FROM Bebidas", null);
        if (cursor3.moveToFirst()) {
            cont=1;
            while (cont<=pos){
                tipobebida = cursor3.getString(1);
                precio = cursor3.getInt(2);
                cont++;
                cursor3.moveToNext();
            }
        }
        if (pos == 0)
            tipobebida = null;
        db.close();
    }

}
