package model.services;

import java.util.List;
import model.actors.Topico;
import model.daos.TopicoDAO;

public class TopicoServices {
    
    private static final int TOPICO_PONTOS = 10;
    
    private static TopicoDAO getTopicoDAO(){
        return new TopicoDAO();
    }

    public static List<Topico> recuperaTopicos() {
        return getTopicoDAO().recuperaTopicos();
    }

    public static Topico recuperaTopico(int topicoId) {
        return getTopicoDAO().recuperaTopico(topicoId);
    }

    public static void inserirTopico(String titulo, String conteudo, String login) {
        getTopicoDAO().inserirTopico(criaTopico(titulo, conteudo, login));
        adicionarPontos(login);
    }
    
    private static Topico criaTopico(String titulo, String conteudo, String login){
        return new Topico(titulo, conteudo, login);
    }
    
    private static void adicionarPontos(String login){
        UsuarioServices.adicionarPontos(login, TOPICO_PONTOS);
    }
    
}
