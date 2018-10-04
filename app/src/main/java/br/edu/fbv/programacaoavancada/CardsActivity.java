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

import Intefaces.ListCardinterface;
import adapter.AdapterAtividades;
import model.AtividadesListadas;
import Presenter.ListCardPresenter;

public class CardsActivity extends AppCompatActivity implements ListCardinterface.ListCardView {

    private RecyclerView recyclerAtividades ;

    private AdapterAtividades adapter;
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

        ListCardinterface.ListCardPresenter presenter = new ListCardPresenter(this);

        recyclerAtividades = findViewById(R.id.recyclerAtividades);

        adapter = new AdapterAtividades();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAtividades.setLayoutManager(layoutManager);

        presenter.obterAtividadesListadas();

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

                              Intent toolbar= new Intent(CardsActivity.this,OpinioesActivity.class);
                              startActivity(toolbar);
                              break;
                          case  3:
                              //Intent calculo= new Intent(CardsActivity.this,ListServiceActivity.class);
                              Intent calculo= new Intent(CardsActivity.this,ImpostoActivity.class);
                              startActivity(calculo);
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
/*
    public void atividadeslistadas() {
        AtividadesListadas atividadesListadas = new AtividadesListadas("Serviços" ,"Venha conhecer os nosso serviços","#precisouAchou" ,R.drawable.servicos);
        this.atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Feedback" ,"Diga sua opinião sobre a aplicação","Ajude a melhorar a plataforma" ,R.drawable.feedback);
        this.atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Test" ,"Card teste","card teste" ,R.drawable.prestadoresservico);
        this.atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Calcule seu lucro" , "Contas","veja o seu lucro ja com os impostos", R.drawable.taxas);
        this.atividadeslistadas.add(atividadesListadas);
    }
*/
    @Override
    public void exibiCard(List<AtividadesListadas> atividadesListadas) {
        //adapter.s

        adapter.lista(atividadesListadas);
    }
}
