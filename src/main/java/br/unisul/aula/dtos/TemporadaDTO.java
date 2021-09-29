package br.unisul.aula.dtos;

import br.unisul.aula.entidades.Seriado;
import br.unisul.aula.entidades.Temporada;

public class TemporadaDTO {
    private Long id;
    private Integer numero;
    private String descricao;
    private Long seriadoId;
    private String nomeSeriado;


    public TemporadaDTO(Temporada temporada) {
        this.id = temporada.getId();
        this.numero = temporada.getNumero();
        this.descricao = temporada.getDescricao();
        this.seriadoId = temporada.getSeriado().getId();
        this.nomeSeriado = temporada.getSeriado().getNome();
    }

    public TemporadaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Long getSeriadoId() {
        return seriadoId;
    }

    public void setSeriadoId(Long seriadoId) {
        this.seriadoId = seriadoId;
    }

    public String getNomeSeriado() {
        return nomeSeriado;
    }

    public void setNomeSeriado(String nomeSeriado) {
        this.nomeSeriado = nomeSeriado;
    }

    public Temporada converterParaTemporada(Seriado seriado) {
        Temporada temporada = new Temporada();
        temporada.setId(this.id);
        temporada.setNumero(this.numero);
        temporada.setDescricao(this.descricao);
        temporada.setSeriado(seriado);
        return temporada;
    }
}
