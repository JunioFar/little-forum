package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.actors.Usuario;
import model.services.UsuarioServices;

@WebServlet("/fazerLogin")
public class FazerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario user = UsuarioServices.recuperaUsuario(login,senha);
        
        if(user == null){
            request.setAttribute("errorMessage", "Usuario ou Senha invalidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            request.getSession().setAttribute("usuario", user.getLogin());
            response.sendRedirect("recuperaTopicos");
        }
    }
}
