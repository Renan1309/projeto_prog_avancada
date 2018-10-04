package br.edu.fbv.programacaoavancada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import model.CalculoNaactivity;

public class ImpostoActivity extends AppCompatActivity {
    EditText nomeprofissao ;
    EditText valorservico;
    TextView resultadocalculo;

    Button calcularbutton;

    String profissao;
    Double valor;
    String stringdouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imposto);
        Toolbar toolbarx = (Toolbar) findViewById(R.id.segundotoolbar);
        toolbarx.setTitle(R.string.Servicos); // tava dando erro aqui fui procurar no git
        setSupportActionBar(toolbarx);//funcionar em versões anteriores

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        nomeprofissao = findViewById(R.id.profissaodigitada);
        valorservico = findViewById(R.id.valoratendimento);
        resultadocalculo = findViewById(R.id.resultadocalculo);
        calcularbutton = findViewById(R.id.calcularbotton);







        calcularbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibircalculo();
            }
        });



    }


    public void exibircalculo(){
        profissao =nomeprofissao.getText().toString();
        valor = Double.parseDouble( valorservico.getText().toString() );

        CalculoNaactivity calculoNaactivity = new CalculoNaactivity(profissao,valor);



        stringdouble= Double.toString(calculoNaactivity.calcularvalorrecebido());
        resultadocalculo.setText( stringdouble);

    }
}
