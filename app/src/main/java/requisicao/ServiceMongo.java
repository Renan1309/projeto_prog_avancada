package requisicao;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;


import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class ServiceMongo extends AsyncTask<Void, Void , List<Pessoa>> {


    @Override
    protected List<Pessoa> doInBackground(Void... voids) {

        //String urlmongo = "https://vast-hollows-56426.herokuapp.com/cadastro";
        String urlmongo = "http://192.168.15.9:8080/cadastro";
        InputStream inputStream = null;

        InputStreamReader inputStreamReader = null;
        StringBuffer resultMongo = null;

        StringBuffer finalapi = null;


        try {
            URL url = new URL(urlmongo);
            HttpURLConnection result = (HttpURLConnection) url.openConnection();

            //aqui os dados vem em Bytes
            inputStream = result.getInputStream();

            inputStreamReader = new InputStreamReader(inputStream);
            //fazer leitura dos caracteres
            BufferedReader reader = new BufferedReader((inputStreamReader));
            String linha = "";
            resultMongo = new StringBuffer();
            finalapi = new StringBuffer();
            while ((linha = reader.readLine()) != null) {
                resultMongo.append(linha);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Pessoa> listapessoas = new ArrayList<Pessoa>();
        String jsonfinal = resultMongo.toString();
        try {


            JSONArray jsonArray = new JSONArray(jsonfinal);

            JSONObject parentObject = jsonArray.getJSONObject(0);
            for (int j = 0; j < jsonArray.length(); j++) {
                Pessoa pessoa = new Pessoa();
                JSONObject finalObject = jsonArray.getJSONObject(j);
               // JSONObject jsonObject = jsonArray.getJSONObject(j);

                pessoa.setId(finalObject.getString("_id"));
                pessoa.setNome(finalObject.getString("nome"));
                pessoa.setProfissao(finalObject.getString("profissao"));
                pessoa.setTelefone(finalObject.getString("telefone"));
                pessoa.setSite(finalObject.getString("site"));
                listapessoas.add(pessoa);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listapessoas;

    }



    protected void onPostExecute(ArrayList<Pessoa> pessoas) {
        super.onPostExecute(pessoas);


        // recuparaDados.recuperaDados(s);


    }


/**
    private Pessoa Pegartrabalhador(JSONObject obj) throws JSONException {

        String id = obj.getString("id");
        String nome = obj.getString("nome");
        String profissao = obj.getString("profissao");
        String telefone = obj.getString("telefone");
        String site = obj.getString("site");

        //return new Pessoa (id, nome, telefone, site);
    }

 pessoa.setId(jsonObject.getString("_id"));
 pessoa.setNome(jsonObject.getString("nome"));
 pessoa.setProfissao(jsonObject.getString("profissao"));
 pessoa.setTelefone(jsonObject.getString("telefone"));
 pessoa.setSite(jsonObject.getString("site"));
 listapessoas.add(pessoa);

 */





}
