package com.alumno.proyecto_kebabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.WindowDecorActionBar;
import android.widget.TextView;

import java.util.ArrayList;


public class PantallaCuatroResumenPedido extends AppCompatActivity {
    //estoy probando sourcetree otra ve

    private TextView resumen;

    ArrayList<String> datos;
    ArrayList<String> arraylistcomida;
    ArrayList<String> arraylistbebida;

    String texto;
    int totalpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_cuatro_resumen_pedido);

        resumen = (TextView) findViewById(R.id.lblResumen);

        texto = "DATOS CLIENTE:\n\n";

        for(int i=0;i==(datos.size()-1);i++){
            texto +=  datos.get(i) + "\n";
        }
        texto += "\n PARA COMER:\n\n";

        for(int i=0;i==(arraylistcomida.size()-2);i++) {
            int cont1 = 0, cont2 = 0;
            if(cont2 < 6){
                if (cont1 < 2) {
                    texto += arraylistcomida.get(i) + "  ";
                    cont1++;
                    cont2++;
                } else {
                    texto += "\n" + arraylistcomida.get(i) + "  ";
                    cont1=0;
                }
            }else{
                texto += "\n\n" + arraylistcomida.get(i) + "  " ;
                cont2=0;
            }
        }
        texto +="\n\n" + arraylistcomida.get(arraylistcomida.size()-1) + "\n\n";
        texto += "PARA BEBER:\n\n";

        for(int i=0;i==(arraylistbebida.size()-2);i++) {
            int cont=0;
            if (cont < 3) {
                texto += arraylistbebida.get(i) + "  ";
                cont++;
            }
            else{
                texto += "\n" + arraylistbebida.get(i) + "  ";
                cont=0;
            }
        }
        texto +="\n\n" + arraylistbebida.get(arraylistcomida.size()-1) + "\n\n";

        totalpedido = Integer.valueOf(arraylistcomida.get(arraylistcomida.size()-1)) + Integer.valueOf(arraylistbebida.get(arraylistcomida.size()-1));
        texto = "TOTAL:    " + totalpedido + "€\n\n";

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
}