package br.edu.fbv.programacaoavancada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcoesMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_menu);

        Button opções = (Button) findViewById(R.id.acessarCep);
        opções.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent capturacep = new Intent(OpcoesMenuActivity.this, CepActivity.class);
                startActivity(capturacep);
            }
        });

        Button curriculo = (Button) findViewById(R.id.acessarCurriculo);
        curriculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizaCurriculo = new Intent(OpcoesMenuActivity.this , CurriculoActivity.class);
                startActivity(visualizaCurriculo);
            }
        });
    }
    }

