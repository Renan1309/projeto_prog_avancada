package Intefaces;

import model.Opiniao;

public interface FeedbackInterface {

    interface FeedbackView{
        void enviadoFeedSucesso();

    }

    interface FeedbackPresenter{

        void enviarFeedback(Opiniao opiniao);


    }
}
