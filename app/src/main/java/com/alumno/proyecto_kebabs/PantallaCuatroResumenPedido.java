package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


import java.util.ArrayList;


public class PantallaCuatroResumenPedido extends AppCompatActivity {

    private TextView resumen;


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


        mostrarDatos();
        mostrarComida();
        mostrarBebida();
        calculartotal();
        comprobarregalo();

        resumen.setMovementMethod(new ScrollingMovementMethod());
        resumen.setText(texto);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==3 && resultCode==RESULT_OK){
            datos = data.getExtras().getStringArrayList("datos");
            arraylistcomida = data.getExtras().getStringArrayList("comida");
            arraylistbebida = data.getExtras().getStringArrayList("bebida");
        }
    }
    public void mostrarDatos(){
        texto = "DATOS CLIENTE:\n\n";

        for(int i=0;i<=(datos.size()-1);i++){
            texto +=  datos.get(i) + "\n";

        }
    }
    public void mostrarComida(){
        texto += "\n PARA COMER:\n\n";
        int cont1 = 0, cont2 = 0;
        for(int i=0;i<=(arraylistcomida.size()-2);i++) {

            if(cont2 < 6){
                if (cont1 < 2) {
                    texto += arraylistcomida.get(i) + "  ";
                    if (cont1 == 1)
                        texto +="€";
                    cont1++;
                    cont2++;
                } else {
                    texto += "\n";
                    cont1=0;
                }
            }else{
                texto += "\n\n";
                cont2=0;
            }
        }
        texto +="\n\n" + arraylistcomida.get(arraylistcomida.size()-1) + "\n\n";
    }
    public void mostrarBebida(){
        texto += "PARA BEBER:\n\n";
        int cont=0;
        for(int i=0;i<=(arraylistbebida.size()-2);i++) {

            if (cont < 3) {
                texto += arraylistbebida.get(i) + "  ";
                if (cont == 0)
                    texto += " botella(s) de ";
                if (cont == 2)
                    texto += "€";
                cont++;
            }
            else{
                texto += "\n";
                cont=0;
            }
        }
        texto +="\n\n" + arraylistbebida.get(arraylistbebida.size()-1) + "\n\n";
    }

    public void calculartotal(){

        totalpedido = Integer.valueOf(arraylistcomida.get(arraylistcomida.size()-1)) + Integer.valueOf(arraylistbebida.get(arraylistbebida.size()-1));
        texto += "TOTAL:    " + totalpedido + "€\n\n";
    }

    public void comprobarregalo(){

        if (totalpedido > 23 && totalpedido < 33)
            texto += "¡Ehorabuena! Como su pedido supera los 23€ se lleva un peluche del muñeco de Android de regalo.\n\n";

        if (totalpedido > 33)
            texto += "¡Ehorabuena! Como su pedido supera los 33€ le regalamos un peluche del muñeco de Android y un vale para comer en el comedor de Cebanc.\n\n";
    }

}