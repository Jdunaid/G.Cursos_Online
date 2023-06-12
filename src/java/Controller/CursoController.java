/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import DAO.CursoDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author LIGIA
 */
@WebServlet(name = "CursoController", urlPatterns = {"/CursoController"})
public class CursoController extends HttpServlet {

    
   private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/curso.jsp";
    private static String LIST_Curso = "/listCurso.jsp";
    private CursoDAO dao;
    private String codigo;

    public CursoController() {
        super();
        dao = new CursoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            dao.deleteCurso(codigo);
            forward = LIST_Curso;
            request.setAttribute("curso", dao.getAllCurso());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Curso curso = dao.getCursoBycodigo(codigo);
            request.setAttribute("curso", curso);
        } else if (action.equalsIgnoreCase("listCurso")){
            forward = LIST_Curso;
            request.setAttribute("users", dao.getAllCurso());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Curso curso= new Curso();
     
       curso.setnome(request.getParameter("nome"));
     
        curso.setarea(request.getParameter("area"));
        try {
            Date duracao=null;
            String teste = request.getParameter("duracao");
            System.out.println(teste);
            if(request.getParameter("duracao")!=null){
                duracao = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("duracao"));
            }
            else{
                duracao = null;
            }
                
            curso.setduracao(duracao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        curso.setcadeira(request.getParameter("cadeira"));
              curso.setvideoaula(request.getParameter("videoaula"));
        String codigo = request.getParameter("codigo");
        if(codigo== null || codigo.isEmpty())
        {
            dao.addCurso(curso);
        }
        else
        {
           
            curso.setcodigo(Integer.parseInt(codigo));
            dao.updateCurso(curso);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_Curso);
        request.setAttribute("Curso", dao.getAllCurso());
        view.forward(request, response);
    }
  }

