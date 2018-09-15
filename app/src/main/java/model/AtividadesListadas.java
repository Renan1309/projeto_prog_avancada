package model;

public class AtividadesListadas {
    private  String titulo;
    private  String titulo1;
    private  String titulo2;
    private  int imagem;

    public AtividadesListadas(String titulo, String titulo1, String titulo2, int imagem) {
        this.titulo = titulo;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
