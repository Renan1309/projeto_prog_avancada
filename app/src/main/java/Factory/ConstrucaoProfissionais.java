package Factory;

import Intefaces.CriarHumano;
import model.Humano;
import model.Pessoa;

public class ConstrucaoProfissionais implements CriarHumano {
    @Override
    public Humano criarhumano() {
        return  new Pessoa();
    }
}
