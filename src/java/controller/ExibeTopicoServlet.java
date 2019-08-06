package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.services.TopicoServices;

@WebServlet("/exibeTopico")
public class ExibeTopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicoId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("topico", TopicoServices.recuperaTopico(topicoId));
        request.getRequestDispatcher("exibe-topico.jsp").forward(request, response);
    }

}
