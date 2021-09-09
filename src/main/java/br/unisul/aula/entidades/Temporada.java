package br.unisul.aula.entidades;

public class Temporada {

    private Long id;
    private int numero;
    private String descricao;

    private Seriado seriado;

    public Temporada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Seriado getSeriado() {
        return seriado;
    }

    public void setSeriado(Seriado seriado) {
        this.seriado = seriado;
    }
}
