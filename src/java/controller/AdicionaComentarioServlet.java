package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.services.ComentarioServices;
import model.services.TopicoServices;

@WebServlet("/adicionaComentario")
public class AdicionaComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getSession().getAttribute("usuario");
        String comentario = request.getParameter("comentario");
        int topicoId = Integer.parseInt(request.getParameter("topicoId"));
        
        ComentarioServices.inserirComentario(topicoId, comentario, login);
        
        request.setAttribute("topico", TopicoServices.recuperaTopico(topicoId));
        request.getRequestDispatcher("exibe-topico.jsp").forward(request, response);
    }

}
