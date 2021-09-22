package br.unisul.aula;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.entidades.Episodio;
import br.unisul.aula.entidades.Seriado;
import br.unisul.aula.entidades.Temporada;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Seriado seriado = new Seriado();
        seriado.setNome("Teste1");
        seriado.setDescricao("Teste1");
        seriado.setDataLancamento(LocalDate.now());
        CrudDoBanco<Seriado> seriadoBanco = new SeriadoImpl();
        seriadoBanco.insert(seriado);
        Temporada temporada = new Temporada();
        temporada.setNumero(1);
        temporada.setDescricao("Teste");
        temporada.setSeriado(seriado);
        CrudDoBanco<Temporada> temporadaBanco = new TemporadaImpl();
        temporadaBanco.insert(temporada);
        System.out.println(temporadaBanco.findAll());

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setResumo("Teste teste");
        episodio.setNome("Teste");
        episodio.setTemporada(temporada);

        CrudDoBanco<Episodio> episodioDoBanco = new EpisodioImpl();
        episodioDoBanco.insert(episodio);


        System.out.println(episodioDoBanco.findAll());

        System.out.println(seriadoBanco.findAll());
        Seriado seriado1 = seriadoBanco.findById(new Long(2));
        System.out.println(seriado1);
        seriado1.setDescricao("Novo teste");
        seriadoBanco.update(seriado1);
        System.out.println(seriadoBanco.findAll());
        seriadoBanco.remove(seriado1);
        System.out.println(seriadoBanco.findAll());



    }
}
