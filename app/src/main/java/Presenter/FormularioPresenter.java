package Presenter;

import Factory.ConstrucaoProfissionais;
import Intefaces.FormularioInterface;
import model.Pessoa;
import requisicao.PostService;

public class FormularioPresenter implements FormularioInterface.FormularioPresenter {


    @Override
    public void enviardados(Pessoa pessoa) {




        PostService postService = new PostService( pessoa);
        postService.execute();
    }
}
