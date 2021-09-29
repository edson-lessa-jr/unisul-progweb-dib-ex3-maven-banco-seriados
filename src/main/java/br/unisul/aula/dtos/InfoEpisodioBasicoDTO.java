package br.unisul.aula.dtos;

import br.unisul.aula.entidades.Episodio;
import br.unisul.aula.entidades.Temporada;

public class InfoEpisodioBasicoDTO {
      private Long id;
      private Integer numero;
      private String nome;
      private String resumo;
      private Integer numeroTemporada;
      private String nomeSeriado;

    public InfoEpisodioBasicoDTO() {
    }

    public InfoEpisodioBasicoDTO(Episodio episodio) {
        this.id = episodio.getId();
        this.numero = episodio.getNumero();
        this.nome = episodio.getNome();
        this.resumo = episodio.getResumo();
        this.numeroTemporada = episodio.getTemporada().getNumero();
        this.nomeSeriado = episodio.getTemporada().getSeriado().getNome();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public String getNomeSeriado() {
        return nomeSeriado;
    }

    public void setNomeSeriado(String nomeSeriado) {
        this.nomeSeriado = nomeSeriado;
    }

    public Episodio converterParaEpisodio(Temporada temporada) {
        Episodio episodio = new Episodio();
         episodio.setNumero(this.numero);
         episodio.setNome(this.nome);
         episodio.setResumo(this.resumo);
         episodio.setTemporada(temporada);
        return episodio;
    }
}
