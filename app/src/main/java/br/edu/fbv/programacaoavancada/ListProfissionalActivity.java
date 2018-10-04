package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Intefaces.ListProfissinalInterface;
import Presenter.ListProfissionalPresenter;
import adapter.AdapterTrabalhador;
import model.Pessoa;
import requisicao.ServiceMongo;

public class ListProfissionalActivity extends AppCompatActivity implements ListProfissinalInterface.ListProfissionalView {

    private ListView listView ;
    private  ArrayAdapter <String> adapter ;
    //private ArrayList<String> arrayList;

    private ArrayList<Pessoa> execute;
    private AdapterTrabalhador adapterTrabalhador;
    private  String profissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profissional);

        Toolbar toolbar = (Toolbar)  findViewById(R.id.segundotoolbar);
        toolbar.setTitle("Prog Avançada");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent profissaorecebida = getIntent();
        profissao = profissaorecebida.getStringExtra("profissao");

        adapterTrabalhador = new AdapterTrabalhador();

        ListProfissinalInterface.ListProfissionalPresenter presenter = new ListProfissionalPresenter(this);
        presenter.obterListaProfissionais(this.profissao);


        /*
        tirei pelo presenter
         ServiceMongo apimongo = new ServiceMongo();
        */
        //ServiceMongo apimongo = ServiceMongo.getInstancia();

     //  ArrayList<Pessoa> execute = null;
        /*
        tirei pro presenter
       try {
            execute = (ArrayList<Pessoa>) apimongo.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/


        listView = (ListView) findViewById(R.id.listprofissional);


        listView.setAdapter(adapterTrabalhador);

        final ArrayList<Pessoa> finalExecute = execute;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //arrayList.get(position);
                Pessoa pessoalista = finalExecute.get(position);

                Intent enviarpessoa = new Intent(ListProfissionalActivity.this ,ProfissionalActivity.class);

                enviarpessoa.putExtra("pessoa" , (Serializable) finalExecute.get(position));

                startActivity(enviarpessoa);

               // Toast.makeText(getApplicationContext(), pessoalista.getNome().toString()+"+"+pessoalista.getTelefone().toString(), Toast.LENGTH_SHORT).show();



            }
        });


    }


    @Override
    public void exibirListaProfissionais(List<Pessoa> pessoas) {
        this.execute = (ArrayList<Pessoa>) pessoas;
        adapterTrabalhador.lista(pessoas , ListProfissionalActivity.this );
    }
}

