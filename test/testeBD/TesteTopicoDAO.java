package testeBD;

import java.util.List;
import model.actors.Topico;
import model.daos.TopicoDAO;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TesteTopicoDAO {
    
    JdbcDatabaseTester jdt;
    TopicoDAO topicoDAO;
    
    @Before
    public void setUp() throws Exception{
        jdt = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost/coursera?useTimezone=true&serverTimezone=UTC","root","");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/testeBD/inicio.xml"));
        jdt.onSetup();
        topicoDAO = new TopicoDAO();
    }
    
    @Test
    public void recuperaTodosTopicos() throws Exception{
        List<Topico> ranking = topicoDAO.recuperaTopicos();
        
        assertEquals(2, ranking.size());
    }
    
    @Test
    public void recuperaTopico() throws Exception{
        Topico t = topicoDAO.recuperaTopico(1);
        
        assertEquals("joao", t.getLogin());
    }
    
    @Test
    public void inserirNovoUsuario() throws Exception{
        Topico t = new Topico(3, "Nova no pedaço", "Cheguei para fazer companhia pro Joao Solitario", "maria");
        
        topicoDAO.inserirTopico(t);
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/testeBD/verifica-topico.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
