package requisicao;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.edu.fbv.programacaoavancada.FormularioActivity;
import model.Pessoa;

public class PostService extends AsyncTask<Pessoa, Void, String> {

    Pessoa pessoaRecebida = new Pessoa();

    public PostService(FormularioActivity formularioActivity, Pessoa pessoa) {
        pessoaRecebida = pessoa ;
    }

    @Override
    protected String doInBackground(Pessoa... pessoas) {
        //String urlmongo = "https://vast-hollows-56426.herokuapp.com/cadastro";
        String urlmongo = "http://192.168.15.9:8080/cadastro";

        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("nome" ,pessoaRecebida.getNome());
            postDataParams.put("profissao" ,pessoaRecebida.getProfissao());
            postDataParams.put("telefone" ,pessoaRecebida.getTelefone());
            postDataParams.put("site" ,pessoaRecebida.getSite());


        } catch (JSONException e) {
            e.printStackTrace();
        }



        try {
            URL url = new URL(urlmongo);
            HttpURLConnection result = (HttpURLConnection) url.openConnection();


            result.setRequestMethod("POST");
            result.setRequestProperty("Content-type", "application/json");
            result.setRequestProperty("Accept", "application/json");
            result.setDoOutput(true);

            PrintStream printStream =
                    new PrintStream(result.getOutputStream());
            printStream.println(postDataParams);
            result.connect();

            String jsonDeResposta =
                    new Scanner(result.getInputStream()).next();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}

/**
 postDataParams.put("nome" ,"Testevgvhgsd");
 postDataParams.put("profissao" ,"Testefdsgds");
 postDataParams.put("telefone" ,"77777778989898535");
 postDataParams.put("site" ,"Teste");
 */