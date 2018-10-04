package Intefaces;

import java.util.List;

import model.Pessoa;

public interface ListProfissinalInterface {

    interface ListProfissionalView{
        void exibirListaProfissionais(List<Pessoa> pessoas);

    }

    interface ListProfissionalPresenter{

        void obterListaProfissionais (String profissao);
    }
}
