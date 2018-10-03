package model;

import Intefaces.CalculoImposto;

public class CalculoimpostoGraduados implements CalculoImposto {

    @Override
    public double calculaSalarioComImposto(String profissão, double valor) {

            double valorfinal = valor*0.25;
            return valorfinal ;


    }
}
