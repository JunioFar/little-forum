package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.services.TopicoServices;

@WebServlet("/criarTopico")
public class CriarTopicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getSession().getAttribute("usuario");
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        
        TopicoServices.inserirTopico(titulo, conteudo, login);
        
        response.sendRedirect("recuperaTopicos");
    }

}
