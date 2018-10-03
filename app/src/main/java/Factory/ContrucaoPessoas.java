package Factory;

import Intefaces.CriarHumano;
import model.Cliente;
import model.Humano;


public class ContrucaoPessoas  implements CriarHumano{
    @Override
    public Humano criarhumano() {
        return new Cliente();
    }
}
