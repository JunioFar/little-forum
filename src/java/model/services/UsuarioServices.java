package model.services;

import java.util.List;
import model.actors.Usuario;
import model.daos.UsuarioDAO;

public class UsuarioServices {
    
    private static UsuarioDAO getUsuarioDAO(){
        return new UsuarioDAO();
    }

    public static void criarUsuario(String login, String nome, String email, String senha) {
        getUsuarioDAO().inserirUsuario(criaUsuario(login, nome, email, senha));
    }
    
    public static Usuario recuperaUsuario(String login, String senha) {
        return getUsuarioDAO().recuperaUsuario(login, senha);
    }
    
    public static List<Usuario> recuperaRanking() {
        return getUsuarioDAO().recuperaRanking();
    }
    
    public static void adicionarPontos(String login, int pontos) {
        getUsuarioDAO().adicionarPontos(login, pontos);
    }

    private static Usuario criaUsuario(String login, String nome, String email, String senha) {
        return new Usuario(login, nome, email, senha);
    }

}
