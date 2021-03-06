package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import adapter.AdapterListServicos;
import adapter.AdapterTrabalhador;
import model.Servicos;

public class ListServiceActivity extends AppCompatActivity {

    private ListView listView ;
    private List<Servicos> servicoslistados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_service2);

        Toolbar toolbar = (Toolbar)  findViewById(R.id.segundotoolbar);
        toolbar.setTitle("Prog Avançada");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list_servico_oferecido);

        this.listservicos();

      AdapterListServicos adapterservicos = new AdapterListServicos(servicoslistados, this);
      listView.setAdapter(adapterservicos);

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


              switch (position){
                  case 0:
                      Intent Intent = new Intent(ListServiceActivity.this ,ListProfissionalActivity.class);
                      Intent.putExtra("profissao", "Arquiteto");
                      startActivity(Intent);

                      break;

                  case 1:
                      Intent eletricista = new Intent(ListServiceActivity.this ,ListProfissionalActivity.class);
                      eletricista.putExtra("profissao", "Eletricista");
                      startActivity(eletricista);

                      break;

                  case 2:
                      Intent pedreiro = new Intent(ListServiceActivity.this ,ListProfissionalActivity.class);
                      pedreiro.putExtra("profissao", "Pedreiro");
                      startActivity(pedreiro);

                      break;

                  case 3:
                      Intent pintor = new Intent(ListServiceActivity.this ,ListProfissionalActivity.class);
                      pintor.putExtra("profissao", "Pintor");
                      startActivity(pintor);

                      break;
              }
              }





      });

    }

    public  void listservicos(){

        Servicos servicos = new Servicos("Arquiteto",R.drawable.arquiteto);
        this.servicoslistados.add(servicos);

        servicos = new Servicos("Eletricista",R.drawable.eletricista);
        this.servicoslistados.add(servicos);

        servicos = new Servicos("Pedreiro",R.drawable.pedreiro);
        this.servicoslistados.add(servicos);

        servicos = new Servicos("Pintor",R.drawable.pintor);
        this.servicoslistados.add(servicos);
/*
        servicos = new Servicos("Engenheiro",R.drawable.engenheiro);
        this.servicoslistados.add(servicos);

        servicos = new Servicos("Encanador",R.drawable.encanador);
        this.servicoslistados.add(servicos);


        //servicos = new Servicos("Pedreiro",R.drawable.arquiteto);
*/
    }
}
