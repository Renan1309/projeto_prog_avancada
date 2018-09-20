package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.AdapterAtividades;
import model.AtividadesListadas;

public class CardsActivity extends AppCompatActivity {

    private RecyclerView recyclerAtividades ;

    private List<AtividadesListadas> atividadeslistadas  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

       // toolbar = (Toolbar) v.findViewById(R.id.toolbar);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
            //recebe xml e covert em view

        Toolbar toolbarx = (Toolbar) findViewById(R.id.segundotoolbar);
        toolbarx.setTitle("Prog Avançada"); // tava dando erro aqui fui procurar no git
        setSupportActionBar(toolbarx);//funcionar em versões anteriores



        recyclerAtividades = findViewById(R.id.recyclerAtividades);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAtividades.setLayoutManager(layoutManager);
       // recyclerAtividades.setAdapter();
        this.atividadeslistadas();
        AdapterAtividades adapter = new AdapterAtividades(atividadeslistadas);
        recyclerAtividades.setAdapter(adapter);

      recyclerAtividades.addOnItemTouchListener(
              new RecyclerItemClickListener(
                      getApplicationContext(),
                      recyclerAtividades, new RecyclerItemClickListener.OnItemClickListener() {
                  @Override
                  public void onItemClick(View view, int position) {
                      switch(position) {
                          case 0:
                              //Perguntar aso prof se é pra jogar dentro de uma função as Intents
                              Toast.makeText(getApplicationContext(), "Acessando lista de serviços", Toast.LENGTH_SHORT).show();
                              Intent listaServicos = new Intent(CardsActivity.this, ListServiceActivity.class);
                              startActivity(listaServicos);
                              break;
                          case 1:
                              Toast.makeText(getApplicationContext(), "Click feedback", Toast.LENGTH_SHORT).show();
                              Intent activityfeedback = new Intent(CardsActivity.this,FeedbackActivity.class);
                              startActivity(activityfeedback);
                              break;
                          case 2 :
                              Toast.makeText(getApplicationContext(), "Card teste", Toast.LENGTH_SHORT).show();

                              Intent toolbar= new Intent(CardsActivity.this,ProfissionalActivity.class);
                              startActivity(toolbar);
                              break;
                          default:

                      }
                  }

                  @Override
                  public void onLongItemClick(View view, int position) {

                  }

                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                  }
              }
              )
      );


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent formulario = new Intent(CardsActivity.this, FormularioActivity.class);
                startActivity(formulario);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void atividadeslistadas() {
        AtividadesListadas atividadesListadas = new AtividadesListadas("Serviços" ,"Venha conhecer os nosso serviços","#precisouAchou" ,R.drawable.servicos);
        this.atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Feedback" ,"Diga sua opinião sobre a aplicação","Ajude a melhorar a plataforma" ,R.drawable.feedback);
        this.atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Test" ,"Card teste","card teste" ,R.drawable.prestadoresservico);
        this.atividadeslistadas.add(atividadesListadas);
    }
}
