package model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Pessoa implements Serializable {
   private String id;
    private String nome ;
    private String profissao;
    private String telefone;
    private String site;

    /*
    public Pessoa(String id, String nome, String profissao, String telefone, String site) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.telefone = telefone;
        this.site = site;
    }
    */


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }



    public String toString() {

        return "Id:" + getId()
                + "\nTrabalhador: " + getNome()
                + "\nProfissao: " + getProfissao()
                + "\nTelefone: " + getTelefone()
                + "\nSite: " + getSite();

    }

}

