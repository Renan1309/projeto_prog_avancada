package br.edu.fbv.programacaoavancada;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        ServiceMongo apimongo = new ServiceMongo();

       ArrayList<Pessoa> execute = null;
        try {
            execute = (ArrayList<Pessoa>) apimongo.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        listView = (ListView) findViewById(R.id.listservice);
       // List<Pessoa> pessoas = todosOsCursos();

        /**
         listView = (ListView) findViewById(R.id.listservice);

         arrayList = new ArrayList<>();

         adapter = new AdapterProfissional(this ,0 , arrayList);

         listView.setAdapter(adapter);

         adapter.notifyDataSetChanged();
         */
        AdapterTrabalhador adapterTrabalhador = new AdapterTrabalhador(execute, this);
        listView.setAdapter(adapterTrabalhador);



    }


/**
    private List<Pessoa> todosOsCursos() {
        return new ArrayList<>(Arrays.asList(
                new Pessoa("989898A", "Jvbava", "fsdfsd", "fwegsgg", "wwwggg"),
                new Pessoa("989898Ad3", "Jfeava", "fsdfsd", "fwegsgg", "wwwggg"),
                new Pessoa("89897afg", "Javmjja", "fsdfsd", "fwegsgg", "wwwggg")
        ));
    }
*/
}
