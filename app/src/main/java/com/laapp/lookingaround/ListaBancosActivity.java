package com.laapp.lookingaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.laapp.lookingaround.dao.BancoDAO;
import com.laapp.lookingaround.model.Banco;

import java.util.List;


public class ListaBancosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bancos);

        BancoDAO dao = new BancoDAO(this);
        List<Banco> bancos = dao.buscaBancos();
        dao.close();

        ListView listaBancos = findViewById(R.id.lista_bancos);
        ArrayAdapter<Banco> adapter = new ArrayAdapter<Banco>(this, android.R.layout.simple_list_item_1, bancos);
        listaBancos.setAdapter(adapter);

        Button novoBanco = findViewById(R.id.novo_banco);
        novoBanco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentFormulario = new Intent(ListaBancosActivity.this, FormularioActivity.class);
                startActivity(intentFormulario);
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_bancos, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
