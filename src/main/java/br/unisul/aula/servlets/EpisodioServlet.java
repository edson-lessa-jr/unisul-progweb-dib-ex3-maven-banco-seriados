package br.unisul.aula.servlets;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.dtos.InfoEpisodioBasicoDTO;
import br.unisul.aula.entidades.Episodio;
import br.unisul.aula.entidades.Temporada;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EpisodioServlet", value = "/episodio")
public class EpisodioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CrudDoBanco<Episodio> banco = new EpisodioImpl();
        List<Episodio> episodioList = banco.findAll();
        List<InfoEpisodioBasicoDTO> dtos = new ArrayList<>();

        for (Episodio episodio: episodioList){
            InfoEpisodioBasicoDTO dto = new InfoEpisodioBasicoDTO(episodio);
            dtos.add(dto);
        }

        Gson gson = new Gson();
        String episiodioJson = gson.toJson(dtos);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(episiodioJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        InfoEpisodioBasicoDTO dto = gson.fromJson(reader, InfoEpisodioBasicoDTO.class);
        CrudDoBanco<Temporada> bancoT = new TemporadaImpl();
        Temporada temporada = ((TemporadaImpl) bancoT)
                .buscaPorNumeroESeriado(dto.getNumeroTemporada(), dto.getNomeSeriado());
        Episodio episodio = dto.converterParaEpisodio(temporada);
        CrudDoBanco<Episodio> banco = new EpisodioImpl();
        banco.insert(episodio);
    }
}
