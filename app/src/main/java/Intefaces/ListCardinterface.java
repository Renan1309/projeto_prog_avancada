package Intefaces;

import java.util.List;

import model.AtividadesListadas;

public interface ListCardinterface {

    interface ListCardView {
        void exibiCard(List<AtividadesListadas> atividadesListadas);
    }

    interface ListCardPresenter{
       // void setView(ListCardView view);

        void obterAtividadesListadas();
    }
}
