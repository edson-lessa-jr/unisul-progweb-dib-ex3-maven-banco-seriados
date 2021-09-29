package br.unisul.aula.servlets;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.dtos.EpisodioDTO;
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

    private final Gson gson = new Gson();
    private final CrudDoBanco<Episodio> banco = new EpisodioImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        InfoEpisodioBasicoDTO dto = gson.fromJson(reader, InfoEpisodioBasicoDTO.class);
        CrudDoBanco<Temporada> bancoT = new TemporadaImpl();
        Temporada temporada = ((TemporadaImpl) bancoT)
                .buscaPorNumeroESeriado(dto.getNumeroTemporada(), dto.getNomeSeriado());
        Episodio episodio = dto.converterParaEpisodio(temporada);
        banco.insert(episodio);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        EpisodioDTO episodioDTO= gson.fromJson(reader, EpisodioDTO.class);
        CrudDoBanco<Temporada> temporadaBanco = new TemporadaImpl();
        Temporada temporada = ((TemporadaImpl) temporadaBanco).buscaPorNumeroESeriado(episodioDTO.getNumeroTemporada(), episodioDTO.getSeriadoId());
        Episodio episodio = episodioDTO.converterParaEpisodio(temporada);
        banco.update(episodio);

    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        EpisodioDTO episodioDTO = gson.fromJson(reader, EpisodioDTO.class);
        banco.remove(episodioDTO.getIdEpisodio());
    }
}
