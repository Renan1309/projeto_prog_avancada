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

import br.edu.fbv.programacaoavancada.FeedbackActivity;
import model.Opiniao;

public class OpiniaoPost extends AsyncTask<Opiniao, Void , String> {

    Opiniao opiniaorecebida = new Opiniao();

    public OpiniaoPost(FeedbackActivity feedbackActivity, Opiniao opiniao) {
       opiniaorecebida = opiniao ;
    }

    @Override
    protected String doInBackground(Opiniao... opiniaos) {
        String urlmongo = "https://vast-hollows-56426.herokuapp.com/opiniao";
        //String urlmongo = "http://192.168.15.9:8080/opiniao";

        JSONObject postDataParams = new JSONObject();



        try {
            postDataParams.put("nome" ,opiniaorecebida.getNome());
            postDataParams.put("opiniao" ,opiniaorecebida.getOpiniao());
            postDataParams.put("nota" , opiniaorecebida.getNota());



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
