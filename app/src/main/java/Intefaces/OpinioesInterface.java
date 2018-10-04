package Intefaces;

import java.util.List;

import model.Opiniao;

public interface OpinioesInterface {

    interface OpinioesView{

        void exibirOpinioes(List<Opiniao> opiniaos);

    }

    interface  OpinioesPresenter{

        void obterOpinioes();
    }
}
