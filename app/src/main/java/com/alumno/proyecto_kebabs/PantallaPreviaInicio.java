package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;




public class PantallaPreviaInicio extends AppCompatActivity{


    private TextView telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_previa_inicio);
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);

        telefono = (TextView) findViewById(R.id.lblTelefono);

        telefono.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("Tln:943455768"));
                //startActivity(intent);

            }


        });
    }

}


