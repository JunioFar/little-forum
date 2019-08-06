package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.actors.Usuario;

public class UsuarioDAO {
    
    private final Connection con;
    
    public UsuarioDAO(){
        this.con = ConnectionFactory.getConnection();
    }

    public void inserirUsuario(Usuario u) {
        String sql = "INSERT INTO usuario (login, nome, email, senha, pontos) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getNome());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getSenha());
            stm.setInt(5, u.getPontos());
            stm.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir Usuario", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }

    public Usuario recuperaUsuario(String login, String senha) {
        Usuario user = null;
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?;";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, senha);
            rs = stm.executeQuery();
            if(rs.next()){
                user = criarUsuario(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar Usuario", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        
        return user;
    }
    
    public List<Usuario> recuperaRanking() {
        List<Usuario> ranking = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                Usuario u = criarUsuario(rs);
                ranking.add(u);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar Ranking", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        
        return ranking;
    }
    
    public void adicionarPontos(String login, int pontos) {
        String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
        System.out.println("PONTOS = "+ pontos);
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir Pontos", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    private Usuario criarUsuario(ResultSet rs) throws SQLException{
        return new Usuario(rs.getString("login"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"),
                rs.getInt("pontos")
        );
    }

}
