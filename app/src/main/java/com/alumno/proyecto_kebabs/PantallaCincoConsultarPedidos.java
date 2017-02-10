package com.alumno.proyecto_kebabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by adminportatil on 10/02/2017.
 */

public class PantallaCincoConsultarPedidos  extends AppCompatActivity{

    private Button volver;
    private ListView listado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cinco_consultar_pedidos);

        listado = (ListView) findViewById (R.id.listListado);
        volver = (Button) findViewById (R.id.btnSalir);
    }
}