package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class PantallaPresentacion extends AppCompatActivity {


    private Button pulsar;
    private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_presentacion);


        pulsar = (Button) findViewById(R.id.btnPulsar);
        siguiente = (Button) findViewById(R.id.btnSiguiente0);

        pulsar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarMapa();
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarSiguiente();
            }
        });

    }
    public void lanzarMapa(){
        Uri uri = Uri.parse("http://www.google.es/maps/place/cebanc/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void lanzarSiguiente(){
        Intent i = new Intent(this,PantallaUnoLogin.class);

        startActivity(i);
        }
}