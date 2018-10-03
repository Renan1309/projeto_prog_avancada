package model;

public class Servicos {
    private String servico;
    private int img;

    public Servicos(String servico, int img) {
        this.servico = servico;
        this.img = img;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
