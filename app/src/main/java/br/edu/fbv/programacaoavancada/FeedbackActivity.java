package br.edu.fbv.programacaoavancada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import model.Opiniao;
import requisicao.OpiniaoPost;


public class FeedbackActivity extends AppCompatActivity {
    Button enviarfeed;
    EditText nomefeed;
    EditText opiniaofeed;
    EditText notafeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Toolbar toolbar = (Toolbar)  findViewById(R.id.segundotoolbar);
        toolbar.setTitle("Prog Avançada");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nomefeed = findViewById(R.id.nome_feed);
        opiniaofeed = findViewById(R.id.opiniao_feed);
        notafeed = findViewById(R.id.nota_feed);
        enviarfeed = findViewById(R.id.buttonEnviaFeed);



        enviarfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
    }

    public  void enviar(){
        Opiniao opiniao = new Opiniao();
        // pessoa.setNome((nome_formulario.getText().toString()));
        opiniao.setNome((nomefeed.getText().toString()));
        opiniao.setOpiniao((opiniaofeed.getText().toString()));
        opiniao.setNota((notafeed.getText().toString()));

        OpiniaoPost opiniaoPost = new OpiniaoPost(this,opiniao);
        opiniaoPost.execute();
    }
}
