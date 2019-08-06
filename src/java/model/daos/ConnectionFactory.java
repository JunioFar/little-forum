package model.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/coursera?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Nao foi possivel iniciar o acesso ao banco ", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Nao foi possivel fechar a conexao", ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm){
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Nao foi possivel fechar o Statement", ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Nao foi possivel fechar o ResultSet", ex);
            }
        }
        closeConnection(con, stm);
    }
    
}
