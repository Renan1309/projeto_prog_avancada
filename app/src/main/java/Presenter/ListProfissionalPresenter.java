package Presenter;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import Intefaces.ListProfissinalInterface;
import model.Pessoa;
import requisicao.ServiceMongo;

public class ListProfissionalPresenter implements ListProfissinalInterface.ListProfissionalPresenter {
    private ListProfissinalInterface.ListProfissionalView view ;

    public ListProfissionalPresenter(ListProfissinalInterface.ListProfissionalView view){
        this.view = view;
    }

    @Override
    public void obterListaProfissionais() {
        ServiceMongo apimongo = new ServiceMongo();

        ArrayList<Pessoa> Pessoas = null;

        try {
            Pessoas = (ArrayList<Pessoa>) apimongo.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        view.exibirListaProfissionais(Pessoas);
    }
}
