package model;

import Intefaces.CalculoImposto;

public class CalculoNaactivity {

    private String profissao ;
    private Double valor;
    private CalculoImposto tipodecalculo;


    public CalculoNaactivity(String profissao , double valor){
        this.profissao = profissao;
       this.valor = valor;

        if(profissao.equals("arquiteto")){
            tipodecalculo = new CalculoimpostoGraduados();
        }else {
            tipodecalculo = new CalculoimpostoTecnicos();
        }



        }



    public double calcularvalorrecebido() {
        return tipodecalculo.calculaSalarioComImposto(this.profissao , this.valor);

    }





    }

