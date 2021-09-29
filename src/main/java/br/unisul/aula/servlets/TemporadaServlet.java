package br.unisul.aula.servlets;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.dtos.TemporadaDTO;
import br.unisul.aula.entidades.Seriado;
import br.unisul.aula.entidades.Temporada;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TemporadaServlet", value = "/TemporadaServlet")
public class TemporadaServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final CrudDoBanco<Temporada> banco = new TemporadaImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Temporada> temporadaList = banco.findAll();
        List<TemporadaDTO> dtos = new ArrayList<>();
        for (int i = 0; i < temporadaList.size(); i++) {
            TemporadaDTO dto = new TemporadaDTO(temporadaList.get(i));
            dtos.add(dto);
        }
        String temporadaJson = gson.toJson(dtos);
        response.getWriter().println(temporadaJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        TemporadaDTO temporadaDTO = gson.fromJson(reader, TemporadaDTO.class);
        CrudDoBanco<Seriado> seriadoBanco = new SeriadoImpl();
        Seriado seriado = seriadoBanco.findById(temporadaDTO.getSeriadoId());
        Temporada temporada = temporadaDTO.converterParaTemporada(seriado);
        banco.insert(temporada);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        TemporadaDTO temporadaDTO = gson.fromJson(reader, TemporadaDTO.class);
        CrudDoBanco<Seriado> seriadoBanco = new SeriadoImpl();
        Seriado seriado = seriadoBanco.findById(temporadaDTO.getSeriadoId());
        Temporada temporada = temporadaDTO.converterParaTemporada(seriado);
        System.out.println(temporada);
        banco.update(temporada);

    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        TemporadaDTO temporadaDTO = gson.fromJson(reader, TemporadaDTO.class);
        banco.remove(temporadaDTO.getId());
    }

}
