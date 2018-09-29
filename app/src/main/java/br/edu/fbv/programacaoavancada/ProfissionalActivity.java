package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import model.Pessoa;

public class ProfissionalActivity extends AppCompatActivity {

    TextView nome ;
    TextView profissao;
    TextView telefone;
    TextView email;

    Button ligar;
    Button enviar_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);

        Toolbar toolbar = (Toolbar)  findViewById(R.id.toolbar);
        toolbar.setTitle("Prog Avançada");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        nome =  findViewById(R.id.nomeprofissional);
        profissao =  findViewById(R.id.profissaoprofissional);
        telefone =  findViewById(R.id.telprofissional);
        email =  findViewById(R.id.emailprofissional);
        ligar = findViewById(R.id.tele_icon);


        nome.setText(pessoa.getNome());
        profissao.setText(pessoa.getProfissao());
        telefone.setText(pessoa.getTelefone());
        email.setText(pessoa.getSite());





      ligar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //EditText campoTelefone = (EditText) findViewById(R.id.edTelefone);


              String telefone = pessoa.getTelefone().toString();

              Uri uri = Uri.parse("tel:"+telefone);
              Intent intent = new Intent(Intent.ACTION_DIAL,uri);
              startActivity(intent);
          }
      });




    }
}
