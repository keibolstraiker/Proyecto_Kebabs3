package com.alumno.proyecto_kebabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by adminportatil on 12/02/2017.
 */

public class PantallaSeisMantenimiento extends AppCompatActivity {


    private Button btnClientes;
    private Button btnComidas;
    private Button btnBebidas;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mantenimiento_main);

        btnClientes = (Button) findViewById(R.id.btnClientes);
        btnComidas = (Button) findViewById(R.id.btnComidas);
        btnBebidas = (Button) findViewById(R.id.btnBebidas);
        btnSalir = (Button) findViewById(R.id.btnSalir);


        btnClientes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                lanzarLayout(1);
            }
        });
        btnComidas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                lanzarLayout(2);
            }
        });
        btnBebidas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                lanzarLayout(3);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               finish();
            }
        });

    }
    public void lanzarLayout(int posicion){
        if (posicion ==1){
            setContentView(R.layout.layout_mantenimiento_clientes);
        }else if (posicion ==2){
            setContentView(R.layout.layout_mantenimiento_comidas);
        }else if (posicion == 3){
            setContentView(R.layout.layout_mantenimiento_bebidas);
        }else{
            Toast.makeText(getApplicationContext(), "No ha seleccionado nada de lo debido",
                    Toast.LENGTH_LONG).show();
        }
    }
}