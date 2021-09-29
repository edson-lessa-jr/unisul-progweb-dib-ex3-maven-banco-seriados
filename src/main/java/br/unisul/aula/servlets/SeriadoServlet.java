package br.unisul.aula.servlets;

import br.unisul.aula.banco.CrudDoBanco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.dtos.SeriadoDTO;
import br.unisul.aula.entidades.Seriado;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SeriadoServlet", value = "/seriado")
public class SeriadoServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final CrudDoBanco<Seriado> banco = new SeriadoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seriado> seriadoList = banco.findAll();

        // CONVERSÃO PARA DTO
        List<SeriadoDTO> seriadoDTOS = new ArrayList<>();
        for (Seriado seriado : seriadoList) {
            SeriadoDTO dto = new SeriadoDTO(seriado);
            seriadoDTOS.add(dto);
        }


        String seriadoJson = gson.toJson(seriadoDTOS);

        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(seriadoJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        Seriado seriado = seriadoDTO.converterParaSeriado();
        banco.insert(seriado);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        Seriado seriado = seriadoDTO.converterParaSeriado();
        banco.update(seriado);

    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        banco.remove(seriadoDTO.getId());
    }

}
