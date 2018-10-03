package model;

import Intefaces.CalculoImposto;

public class CalculoimpostoTecnicos implements CalculoImposto {
    @Override
    public double calculaSalarioComImposto(String profissão, double valor) {
        return valor *0.15;
    }
}
