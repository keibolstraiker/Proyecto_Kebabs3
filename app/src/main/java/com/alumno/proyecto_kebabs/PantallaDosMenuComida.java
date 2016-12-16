package com.alumno.proyecto_kebabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class PantallaDosMenuComida extends AppCompatActivity {
    private Spinner cmbTamaño;
    private TextView lblPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla_dos_menu_comida);




        ArrayAdapter<CharSequence> adaptador =
                ArrayAdapter.createFromResource
                        (this, R.array.tamaño, android.R.layout.simple_spinner_item);
        cmbTamaño = (Spinner) findViewById (R.id.cmbTamaño);
        lblPedido = (TextView) findViewById (R.id.lblPedido);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbTamaño.setAdapter(adaptador);


        cmbTamaño.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        if       (position==0) {
                            lblMensaje.setText("Que tal?");
                        }else if (position==1){
                            lblMensaje.setText("Zer moduz?");
                        }

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        lblMensaje.setText("Selecciona algun idioma");
                    }
                });
    }

}
}
