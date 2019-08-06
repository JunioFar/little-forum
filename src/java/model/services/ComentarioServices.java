package model.services;

import java.util.List;
import model.actors.Comentario;
import model.daos.ComentarioDAO;

public class ComentarioServices {
    
    private static final int COMENTARIO_PONTOS = 3;
    
    private static ComentarioDAO getComentarioDAO(){
        return new ComentarioDAO();
    }

    public static List<Comentario> recuperaComentarios(int id) {
        return getComentarioDAO().recuperaComentarios(id);
    }

    public static void inserirComentario(int topicoId, String comentario, String login) {
        getComentarioDAO().inserirComentario(criaComentario(topicoId, comentario,  login));
        adicionarPontos(login);
    }
    
    private static Comentario criaComentario(int topicoId, String comentario, String login){
        return new Comentario(topicoId, comentario, login);
    }
    
    private static void adicionarPontos(String login){
        UsuarioServices.adicionarPontos(login, COMENTARIO_PONTOS);
    }
    
}
