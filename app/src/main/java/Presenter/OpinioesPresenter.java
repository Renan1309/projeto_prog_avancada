package Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Intefaces.OpinioesInterface;
import Intefaces.OpinioesInterface.OpinioesView;
import model.Opiniao;
import requisicao.OpiniaoGet;

public class OpinioesPresenter implements OpinioesInterface.OpinioesPresenter {

    private OpinioesView view;

    public OpinioesPresenter(OpinioesView view){

        this.view = view;

    }

    @Override
    public void obterOpinioes() {
         List<Opiniao> Opinioes  = new ArrayList<>();

        OpiniaoGet opiniaoGet = new OpiniaoGet();

        try {
            Opinioes = (ArrayList<Opiniao>) opiniaoGet.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        view.exibirOpinioes(Opinioes);
    }
}
