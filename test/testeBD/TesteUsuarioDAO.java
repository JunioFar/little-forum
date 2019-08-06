/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeBD;

import java.util.List;
import model.actors.Usuario;
import model.daos.UsuarioDAO;
import model.services.UsuarioServices;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TesteUsuarioDAO {
    
    JdbcDatabaseTester jdt;
    UsuarioDAO usuarioDAO;
    @Before
    public void setUp() throws Exception{
        jdt = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost/coursera?useTimezone=true&serverTimezone=UTC","root","");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/testeBD/inicio.xml"));
        jdt.onSetup();
        usuarioDAO = new UsuarioDAO();
    }
    
    @Test
    public void testaRecuperaUsuario(){
        Usuario joao = usuarioDAO.recuperaUsuario("joao", "1234"); 
        assertEquals("joao", joao.getLogin());
    }
   
    @Test
    public void inserirNovoUsuario() throws Exception{
        Usuario u = new Usuario("amanda","Amanda Formiga","formiga@teste.com","1234",26);
        
        usuarioDAO.inserirUsuario(u);
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/testeBD/verifica.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void recuperaRanking() throws Exception{
        List<Usuario> ranking = usuarioDAO.recuperaRanking();
        
        assertEquals(2, ranking.size());
        assertEquals("maria", ranking.get(0).getLogin());
                
    }
    
    @Test
    public void adicionaPontos() throws Exception{
        usuarioDAO.adicionarPontos("joao", 20);
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/testeBD/verifica-pontos.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
