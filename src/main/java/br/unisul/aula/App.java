package br.unisul.aula;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.entidades.Seriado;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Seriado seriado = new Seriado();
        seriado.setNome("Teste");
        seriado.setDescricao("Teste");
        seriado.setDataLancamento(LocalDate.now());
        CrudDoBanco<Seriado> banco = new SeriadoImpl();
        banco.insert(seriado);
        System.out.println(banco.findAll());
    }
}
