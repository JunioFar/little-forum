package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.actors.Comentario;

public class ComentarioDAO {
    
    private final Connection con;
    
    public ComentarioDAO(){
        con = ConnectionFactory.getConnection();
    }

    public List<Comentario> recuperaComentarios(int id) {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentario WHERE id_topico = ?;";
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while(rs.next()){
                Comentario c = criarComentario(rs);
                comentarios.add(c);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Nao foi possivel recuperar Comentarios", ex);
        }finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        return comentarios;
    }
    
    public void inserirComentario(Comentario comentario) {
        String sql = "INSERT INTO comentario (comentario, login, id_topico) VALUES (?, ?, ?);";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, comentario.getComentario());
            stm.setString(2, comentario.getLogin());
            stm.setInt(3, comentario.getTopicoId());
            
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Nao foi possivel inserir Comentario", ex);
        }finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    private Comentario criarComentario(ResultSet rs) throws SQLException {
        return new Comentario(rs.getInt("id_comentario"),
                rs.getInt("id_topico"),
                rs.getString("comentario"),
                rs.getString("login")
        );
    }
}
