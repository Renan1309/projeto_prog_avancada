package Presenter;

import Intefaces.FeedbackInterface;
import model.Opiniao;
import requisicao.OpiniaoPost;

public class FeedbackPresenter implements FeedbackInterface.FeedbackPresenter {

    @Override
    public void enviarFeedback(Opiniao opiniao) {

        OpiniaoPost opiniaoPost = new OpiniaoPost(opiniao);
        opiniaoPost.execute();
    }
}
