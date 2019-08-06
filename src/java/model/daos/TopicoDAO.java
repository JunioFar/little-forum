package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.actors.Topico;

public class TopicoDAO {
    
    private final Connection con;
    
    public TopicoDAO(){
        this.con = ConnectionFactory.getConnection();
    }

    public List<Topico> recuperaTopicos() {
        List<Topico> topicos = new ArrayList<>();
        String sql = "SELECT * FROM topico ORDER BY id_topico DESC;";
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                Topico t = criaTopico(rs);
                topicos.add(t);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Nao foi possivel recuperar Topicos", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        
        return topicos;
    }
    
    public Topico recuperaTopico(int topicoId) {
        Topico topico = null;
        String sql = "SELECT * FROM topico WHERE id_topico = ?;";
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, topicoId);
            rs = stm.executeQuery();
            if(rs.next()){
                topico = criaTopico(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Nao foi possivel recuperar Topico", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        
        return topico;
    }
    
    public void inserirTopico(Topico topico) {
        String sql = "INSERT INTO topico (titulo, conteudo, login) VALUES (?, ?, ?);";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, topico.getTitulo());
            stm.setString(2, topico.getConteudo());
            stm.setString(3, topico.getLogin());
            
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Nao foi possivel inserir Topico", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }

    private Topico criaTopico(ResultSet rs) throws SQLException {
        return new Topico(rs.getInt("id_topico"), 
                rs.getString("titulo"),
                rs.getString("conteudo"),
                rs.getString("login")
        );
    }
    
}
