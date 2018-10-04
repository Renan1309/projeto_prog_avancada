package Presenter;

import java.util.ArrayList;
import java.util.List;

import Intefaces.ListCardinterface;
import br.edu.fbv.programacaoavancada.R;
import model.AtividadesListadas;

public class ListCardPresenter implements ListCardinterface.ListCardPresenter {
    private ListCardinterface.ListCardView view ;

    public  ListCardPresenter(ListCardinterface.ListCardView view){
        this.view =view;
    }





    @Override
    public void obterAtividadesListadas() {
      final List<AtividadesListadas> atividadeslistadas  = new ArrayList<>();

        AtividadesListadas atividadesListadas = new AtividadesListadas("Servicos" ,"Venha conhecer os nosso serviços","#precisouAchou" , R.drawable.servicos);
        atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Feedback" ,"Diga sua opinião sobre a aplicação","Ajude a melhorar a plataforma" ,R.drawable.feedback);
        atividadeslistadas.add(atividadesListadas);


        atividadesListadas = new AtividadesListadas( "Opiniões","Veja a Opinão dos usuários","..." ,R.drawable.prestadoresservico);
        atividadeslistadas.add(atividadesListadas);

        atividadesListadas = new AtividadesListadas("Calcule seu lucro" , "Contas","veja o seu lucro ja com os impostos ", R.drawable.taxas);
        atividadeslistadas.add(atividadesListadas);

        view.exibiCard(atividadeslistadas);

    }
}
