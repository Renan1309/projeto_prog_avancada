package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import adapter.AdapterProfissional;
import adapter.AdapterTrabalhador;
import model.Pessoa;
import requisicao.ServiceMongo;

public class ListServiceActivity extends AppCompatActivity {

    private ListView listView ;
    private  ArrayAdapter <String> adapter ;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_service);

        Toolbar toolbar = (Toolbar)  findViewById(R.id.segundotoolbar);
        toolbar.setTitle("Prog Avançada");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         ServiceMongo apimongo = new ServiceMongo();
        //ServiceMongo apimongo = ServiceMongo.getInstancia();

       ArrayList<Pessoa> execute = null;
        try {
            execute = (ArrayList<Pessoa>) apimongo.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        listView = (ListView) findViewById(R.id.listservice);

        AdapterTrabalhador adapterTrabalhador = new AdapterTrabalhador(execute, this);
        listView.setAdapter(adapterTrabalhador);

        final ArrayList<Pessoa> finalExecute = execute;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //arrayList.get(position);
                Pessoa pessoalista = finalExecute.get(position);

                Intent enviarpessoa = new Intent(ListServiceActivity.this ,ProfissionalActivity.class);

                enviarpessoa.putExtra("pessoa" , (Serializable) finalExecute.get(position));

                startActivity(enviarpessoa);

               // Toast.makeText(getApplicationContext(), pessoalista.getNome().toString()+"+"+pessoalista.getTelefone().toString(), Toast.LENGTH_SHORT).show();



            }
        });


    }



}

