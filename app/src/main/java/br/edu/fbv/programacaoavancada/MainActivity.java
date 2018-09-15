package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import model.Pessoa;
import requisicao.ServiceMongo;

public class MainActivity extends AppCompatActivity  {

    //activ representa uma aplicação da tela
    //para cada resulução uma imagem expecificas drawble

    public  Button botaoapimongo ;
    public TextView textResultmongo;

    public Button botaolista ;
    public Button botaocard ;

    public List<Pessoa>pessoaslista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoapimongo = findViewById(R.id.buttonapi);
        textResultmongo = findViewById(R.id.textViewMongo);
        botaolista = findViewById(R.id.buttonLista);
        botaocard= findViewById(R.id.buttoncard);

        botaocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card = new Intent(MainActivity.this, CardsActivity.class);
                startActivity(card);

            }
        });



        botaoapimongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent listaServicos = new Intent(MainActivity.this, ListServiceActivity.class);
                startActivity(listaServicos);
                /**
                ServiceMongo apimongo = new ServiceMongo();


                try {


                    textResultmongo.setText(apimongo.execute().get().toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //textResultmongo = apimongo.;
               // apimongo.execute(textResultmongo.getText().toString());

**/


            }
        });



        Button opções = (Button) findViewById(R.id.menu_bola);
        opções.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirFormulario = new Intent(MainActivity.this, OpcoesMenuActivity.class);
                startActivity(abrirFormulario);
            }
        });
    }
}
