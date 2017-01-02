package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class PantallaUnoLogin extends AppCompatActivity {

    private Button salir;
    private Button siguiente;
    private TextView nom;
    private TextView dir;
    private TextView tel;
    ArrayList <String> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_uno_login);

        nom = (TextView) findViewById(R.id.txtNombre);
        dir = (TextView) findViewById(R.id.txtDireccion);
        tel = (TextView) findViewById(R.id.txtTelefono);
        siguiente = (Button) findViewById(R.id.btnSiguiente3);
        salir = (Button) findViewById(R.id.btnSalir);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                    if (nom.getText().length() > 0) {
                        if (dir.getText().length() > 0) {
                            if (tel != null && !tel.equals("")) {

                                datos.add(nom.getText().toString());
                                datos.add(dir.getText().toString());
                                datos.add(tel.getText().toString());

                                //Gari aquí hay un problema ya que estás haciendo "add" a datos y
                                // es un metodo de arraylist y datos es un array normal de Strings
                                //todavía no se como fucionan los arrayList lo tengo que mirar si no corregiría esto.
                                //de echo ahora no me sale el array datos, creo que te lo he pisado de alguna manera,
                                // tenemos que quedar para hacer esto

                                //LanzarActividadDos(datos);

                            } else {
                               tel.setError("Debes introducir un teléfono");
                            }

                        } else {
                            dir.setError("Debes introducir una dirección");
                        }
                    } else {
                        nom.setError("Debes introducir un nombre");
                    }

                }

        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                finish();
            }
        });
    }
public void LanzarActividadDos(ArrayList<String> datos){

    Intent i = new Intent(this,PantallaDosMenuComida.class);
    i.putExtra("datos",datos);
    startActivityForResult(i,1);

}
}
