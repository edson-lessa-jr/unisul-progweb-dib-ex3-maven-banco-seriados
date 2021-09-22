package br.unisul.aula.entidades;

import javax.persistence.*;

@Entity
@Table(name = "tb_temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private int numero;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "seriado_id", nullable = false)
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

    @Override
    public String toString() {
        return "Temporada{" +
                "id=" + id +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", seriado=" + seriado +
                '}';
    }
}
