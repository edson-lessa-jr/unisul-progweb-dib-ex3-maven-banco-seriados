package br.unisul.aula;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.entidades.Seriado;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Seriado seriado = new Seriado();
        seriado.setNome("Teste1");
        seriado.setDescricao("Teste1");
        seriado.setDataLancamento(LocalDate.now());
        CrudDoBanco<Seriado> banco = new SeriadoImpl();
        banco.insert(seriado);
        System.out.println(banco.findAll());
        Seriado seriado1 = banco.findById(new Long(1));
        System.out.println(seriado1);
        seriado1.setDescricao("Novo teste");
        banco.update(seriado1);
        System.out.println(banco.findAll());
        banco.remove(seriado1);
        System.out.println(banco.findAll());



    }
}
