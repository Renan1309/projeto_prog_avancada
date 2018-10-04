package requisicao;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Opiniao;


public class OpiniaoGet extends AsyncTask<Void, Void , List<Opiniao>> {
    @Override
    protected  List<Opiniao> doInBackground( Void ... voids) {
        String urlmongo = "https://vast-hollows-56426.herokuapp.com/opiniao";
       // String urlmongo = "http:// 192.168.43.130:8080/opiniao";
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
        List<Opiniao> listaopiniao = new ArrayList<Opiniao>();
        String jsonfinal = resultMongo.toString();
        try {


            JSONArray jsonArray = new JSONArray(jsonfinal);

            JSONObject opinioesObject = jsonArray.getJSONObject(0);
            for (int j = 0; j < jsonArray.length(); j++) {
                Opiniao opiniao = new Opiniao();
                JSONObject finalObject = jsonArray.getJSONObject(j);
                // JSONObject jsonObject = jsonArray.getJSONObject(j);

                opiniao.setId(finalObject.getString("_id"));
                opiniao.setNome(finalObject.getString("nome"));
                opiniao.setOpiniao(finalObject.getString("opiniao"));
                opiniao.setNota(finalObject.getString("nota"));

                listaopiniao.add(opiniao);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listaopiniao;
    }

    protected void onPostExecute(ArrayList<Opiniao> opiniao) {
        super.onPostExecute(opiniao);


        // recuparaDados.recuperaDados(s);


    }
}
