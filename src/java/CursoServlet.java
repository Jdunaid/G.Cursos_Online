/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LIGIA
 */


public class CursoServlet extends HttpServlet {
  
    private List<Curso> cursos;

    @Override
    public void init() throws ServletException {
        cursos = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listarCursos(request, response);
                break;
            case "showForm":
                exibirFormulario(request, response);
                break;
            case "edit":
                exibirFormularioEdicao(request, response);
                break;
            case "delete":
                excluirCurso(request, response);
                break;
            default:
                listarCursos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                criarCurso(request, response);
                break;
            case "update":
                atualizarCurso(request, response);
                break;
            default:
                listarCursos(request, response);
        }
    }

    private void listarCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cursos", cursos);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void exibirFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    private void exibirFormularioEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));

        if (index >= 0 && index < cursos.size()) {
            Curso curso = cursos.get(index);
            request.setAttribute("curso", curso);
            request.setAttribute("index", index);
            request.getRequestDispatcher("form.jsp").forward(request, response);
        } else {
            listarCursos(request, response);
        }
    }

    private void criarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String curso = request.getParameter("curso");
        String area = request.getParameter("area");
        int aula = Integer.parseInt(request.getParameter("aula"));
        int duracao = Integer.parseInt(request.getParameter("duracao"));
        int cadeira = Integer.parseInt(request.getParameter("cadeira"));
        int videoaula = Integer.parseInt(request.getParameter("videoaula"));

        Curso novoCurso = new Curso(nome, curso, area, aula, duracao, cadeira, videoaula);
        cursos.add(novoCurso);

        listarCursos(request, response);
    }

    private void atualizarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));

        if (index >= 0 && index < cursos.size()) {
            Curso curso = cursos.get(index);

            curso.setNome(request.getParameter("nome"));
            curso.setCurso(request.getParameter("curso"));
            curso.setArea(request.getParameter("area"));
            curso.setAula(Integer.parseInt(request.getParameter("aula")));
            curso.setDuracao(Integer.parseInt(request.getParameter("duracao")));
            curso.setCadeira(request.getParameter("cadeira"));
            curso.setVideoaula(Integer.parseInt(request.getParameter("videoaula")));
        }

        listarCursos(request, response);
    }

    private void excluirCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));

        if (index >= 0 && index < cursos.size()) {
            cursos.remove(index);
        }

        listarCursos(request, response);
    }
}