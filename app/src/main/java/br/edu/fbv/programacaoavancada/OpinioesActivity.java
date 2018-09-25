package br.edu.fbv.programacaoavancada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import adapter.AdapterAtividades;
import adapter.AdapterOpinioes;
import model.Opiniao;
import model.Pessoa;
import requisicao.OpiniaoGet;


public class OpinioesActivity extends AppCompatActivity {

    private RecyclerView recyclerOpiniao ;

    private List<Opiniao> Opinioes  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinioes);

        OpiniaoGet opiniaoGet = new OpiniaoGet();

        try {
            Opinioes = (ArrayList<Opiniao>) opiniaoGet.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toolbar toolbarx = (Toolbar) findViewById(R.id.segundotoolbar);
        toolbarx.setTitle("Prog Avançada"); // tava dando erro aqui fui procurar no git
        setSupportActionBar(toolbarx);//funcionar em versões anteriores

        recyclerOpiniao = findViewById(R.id.recyclerOpinioes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerOpiniao.setLayoutManager(layoutManager);

        //this.atividadeslistadas(); CHAMAR API AQUI
        AdapterOpinioes adapter = new AdapterOpinioes(Opinioes);
        recyclerOpiniao.setAdapter(adapter);



    }
}
