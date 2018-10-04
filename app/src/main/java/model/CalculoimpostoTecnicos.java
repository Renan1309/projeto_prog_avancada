package model;

import Intefaces.CalculoImposto;

public class CalculoimpostoTecnicos implements CalculoImposto {
    private Double valor;

    @Override
    public double calculaSalarioComImposto(String profissão, double valor) {

        this.valor =  valor - (valor*0.15 );
        return this.valor;
    }
}
