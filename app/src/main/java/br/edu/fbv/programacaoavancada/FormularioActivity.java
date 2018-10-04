package br.edu.fbv.programacaoavancada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Factory.ConstrucaoProfissionais;
import Factory.ContrucaoPessoas;
import Intefaces.FormularioInterface;
import Presenter.FormularioPresenter;
import model.Pessoa;
import requisicao.PostService;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.FormularioView {
    Button bottonEnviarForm ;
    EditText nome_formulario ;
    EditText profissao_formulario;
    EditText telefone_formulario;
    EditText site_formulario;

    FormularioInterface.FormularioPresenter presenter = new FormularioPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.segundotoolbar);
        toolbar.setTitle("Formulário"); // tava dando erro aqui fui procurar no git
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        bottonEnviarForm =  findViewById(R.id.buttonEnviaForm);
        nome_formulario = findViewById(R.id.nome_formulario);
        profissao_formulario = findViewById(R.id.profissao_formulario);
        telefone_formulario = findViewById(R.id.telefone_formulario);
        site_formulario = findViewById(R.id.site_formulario);



        bottonEnviarForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviardados();
                exibirMsgEnviado();
            }
        });

    }

    public void enviardados(){
        ConstrucaoProfissionais FabricaPessoa = new  ConstrucaoProfissionais();
        // Pessoa pessoa = new Pessoa();
        Pessoa pessoa = (Pessoa) FabricaPessoa.criarhumano();
        pessoa.setNome((nome_formulario.getText().toString()));
        pessoa.setProfissao(profissao_formulario.getText().toString());
        pessoa.setTelefone(telefone_formulario.getText().toString());
        pessoa.setSite(site_formulario.getText().toString());

        presenter.enviardados(pessoa);


    }


    @Override
    public void exibirMsgEnviado() {
        Toast.makeText(getApplicationContext(), "Dados Enviados", Toast.LENGTH_SHORT).show();
    }
}
