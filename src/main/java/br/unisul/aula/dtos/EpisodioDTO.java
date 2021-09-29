package br.unisul.aula.dtos;

import br.unisul.aula.entidades.Episodio;
import br.unisul.aula.entidades.Temporada;

public class EpisodioDTO {
    private Long idEpisodio;
    private String nomeEpisodio;
    private Integer numeroEpisodio;
    private Integer numeroTemporada;
    private String descricaoTemporada;
    private Long seriadoId;
    private String nomeSeriado;


    public EpisodioDTO(Episodio episodio) {
        this.idEpisodio = episodio.getId();
        this.nomeEpisodio = episodio.getNome();
        this.numeroEpisodio = episodio.getNumero();
        this.numeroTemporada = episodio.getTemporada().getNumero();
        this.descricaoTemporada = episodio.getTemporada().getDescricao();
        this.seriadoId = episodio.getTemporada().getId();
        this.nomeSeriado = episodio.getTemporada().getSeriado().getNome();
    }
    public EpisodioDTO() {
    }

    public Long getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Long idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public String getDescricaoTemporada() {
        return descricaoTemporada;
    }

    public void setDescricaoTemporada(String descricaoTemporada) {
        this.descricaoTemporada = descricaoTemporada;
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

    @Override
    public String toString() {
        return "EpisodioDTO{" +
                "idEpisodio=" + idEpisodio +
                ", nomeEpisodio='" + nomeEpisodio + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", numeroTemporada=" + numeroTemporada +
                ", descricaoTemporada='" + descricaoTemporada + '\'' +
                ", nomeSeriado='" + nomeSeriado + '\'' +
                '}';
    }

    public Episodio converterParaEpisodio(Temporada temporada) {
        Episodio episodio = new Episodio();
        episodio.setId(this.getIdEpisodio());
        episodio.setNome(this.getNomeEpisodio());
        episodio.setNumero(this.getNumeroEpisodio());
        episodio.setTemporada(temporada);
        return null;
    }
}
