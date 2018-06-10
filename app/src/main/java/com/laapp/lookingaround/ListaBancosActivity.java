package com.laapp.lookingaround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListaBancosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bancos);

        String[] bancos = {"Santander","Itau", "Bradesco"};
        ListView listaBancos = findViewById(R.id.lista_bancos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bancos);
        listaBancos.setAdapter(adapter);
    }
}
