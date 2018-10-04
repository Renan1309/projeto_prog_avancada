package br.edu.fbv.programacaoavancada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Intefaces.OpinioesInterface;
import Presenter.OpinioesPresenter;
import adapter.AdapterAtividades;
import adapter.AdapterListOpinioes;
import adapter.AdapterOpinioes;
import model.Opiniao;
import model.Pessoa;
import requisicao.OpiniaoGet;


public class OpinioesActivity extends AppCompatActivity implements OpinioesInterface.OpinioesView {

    private RecyclerView recyclerOpiniao ;
    private ListView listView ;
    private  AdapterOpinioes adapterOpinioes;
    private List<Opiniao> Opinioes  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinioes);
        Toolbar toolbarx = (Toolbar) findViewById(R.id.segundotoolbar);
        toolbarx.setTitle(R.string.Servicos); // tava dando erro aqui fui procurar no git
        setSupportActionBar(toolbarx);//funcionar em versões anteriores

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerOpiniao = findViewById(R.id.recyclerOpinioes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerOpiniao.setLayoutManager(layoutManager);

        //this.atividadeslistadas(); CHAMAR API AQUI
        adapterOpinioes = new AdapterOpinioes();

        OpinioesInterface.OpinioesPresenter presenter = new OpinioesPresenter(this);
        presenter.obterOpinioes();


        recyclerOpiniao.setAdapter(adapterOpinioes);



    }

    @Override
    public void exibirOpinioes(List<Opiniao> opiniaos) {
        this.Opinioes = opiniaos;
        adapterOpinioes.AdapterOpinioes(opiniaos);



    }
}


/**
 OpiniaoGet opiniaoGet = new OpiniaoGet();

 try {
 Opinioes = (ArrayList<Opiniao>) opiniaoGet.execute().get();
 } catch (ExecutionException e) {
 e.printStackTrace();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }

 */