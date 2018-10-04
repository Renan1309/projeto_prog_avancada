package Intefaces;

import model.Pessoa;

public interface FormularioInterface {

    interface  FormularioView{
        void  exibirMsgEnviado ();

    }

    interface  FormularioPresenter{
        void enviardados(Pessoa pessoa);


    }
}
