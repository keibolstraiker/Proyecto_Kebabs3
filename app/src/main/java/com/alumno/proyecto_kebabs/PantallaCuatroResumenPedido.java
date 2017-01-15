package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class PantallaCuatroResumenPedido extends AppCompatActivity {

    private TextView resumen;
    private Button realizar;
    private Button atras;


    ArrayList<String> datos;
    ArrayList<String> arraylistcomida;
    ArrayList<String> arraylistbebida;

    String texto;
    int totalpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();

        datos = extras.getStringArrayList("datos");
        arraylistcomida = extras.getStringArrayList("comida");
        arraylistbebida = extras.getStringArrayList("bebida");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_cuatro_resumen_pedido);

        resumen = (TextView) findViewById(R.id.lblResumen);
        realizar = (Button) findViewById(R.id.btnRealizar);
        atras = (Button) findViewById(R.id.btnAtras);


        mostrarDatos();
        mostrarComida();
        mostrarBebida();
        calculartotal();
        comprobarregalo();

        resumen.setMovementMethod(new ScrollingMovementMethod());
        resumen.setText(texto);

        realizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarRealizar();
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAtras();
            }
        });
    }

       public void mostrarDatos(){
        texto = "DATOS CLIENTE:\n\n";

        for(int i=0;i<=(datos.size()-1);i++){ //Se recorre el arraylist de los datos y se muestra en el TextView.
            texto +=  datos.get(i) + "\n";

        }
    }
    public void mostrarComida(){
        texto += "\n PARA COMER:\n\n";
        int cont1 = 0, cont2 = 0;
        for(int i=0;i<=(arraylistcomida.size()-2);i++) { // Se recorre el arraylist de la comida. Como sabemos el orden en el que se han almacenado los datos, podemos mostrarlos como queramos.

            if(cont2 < 6){
                if (cont1 < 2) {
                    texto += arraylistcomida.get(i) + "  ";
                    cont1++;
                    cont2++;
                } else {
                    texto += "\n" + arraylistcomida.get(i) + "  ";
                    cont1=1;
                    cont2++;
                }
            }else{
                texto += "\n\n" + arraylistcomida.get(i) + "  ";
                cont1=1;
                cont2=1;
            }
        }
        texto +="\nTOTAL COMIDA:  " + arraylistcomida.get(arraylistcomida.size()-1) + "€\n\n";
    }
    public void mostrarBebida(){  //// Se recorre el arraylist de la bebida. Como sabemos el orden en el que se han almacenado los datos, podemos mostrarlos como queramos.
        texto += "PARA BEBER:\n\n";
        int cont=0, cont2=0;
        for(int i=0;i<=(arraylistbebida.size()-2);i++) {

            if (cont < 3) {
                if (cont2 == 0) {
                    texto += arraylistbebida.get(i) + "  X ";
                    cont++;
                    cont2++;
                }
                else if (cont2 == 1){
                    texto += arraylistbebida.get(i) + "  ";
                    cont++;
                    cont2++;
                }
                else{
                    texto += arraylistbebida.get(i) + "€";
                    cont++;
                }
            }
            else{
                texto += "\n" + arraylistbebida.get(i) + "  X ";
                cont = 1;
                cont2 = 1;
            }
        }
        texto +="\nTOTAL BEBIDA:  " + arraylistbebida.get(arraylistbebida.size()-1) + "€\n\n";
    }

    public void calculartotal(){

        totalpedido = Integer.valueOf(arraylistcomida.get(arraylistcomida.size()-1)) + Integer.valueOf(arraylistbebida.get(arraylistbebida.size()-1));
        texto += "TOTAL PEDIDO:    " + totalpedido + "€\n\n";
    }

    public void comprobarregalo(){

        if (totalpedido > 23 && totalpedido < 33)
            texto += "¡Ehorabuena! Como su pedido supera los 23€ se lleva un peluche del muñeco de Android de regalo.\n\n";

        if (totalpedido > 33)
            texto += "¡Ehorabuena! Como su pedido supera los 33€ le regalamos un peluche del muñeco de Android y un vale para comer en el comedor de Cebanc.\n\n";
    }
    public void lanzarRealizar(){
        Toast.makeText(getApplicationContext(), "SU PEDIDO HA SIDO REALIZARDO CORRECTAMENTE, UN REPARTIDOR VA DE CAMINO A SU DIRECCIÓN",
                Toast.LENGTH_LONG).show();
    }
    public void lanzarAtras(){
        finish();
    }
}