package testeBD;

import java.util.List;
import model.actors.Comentario;
import model.daos.ComentarioDAO;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TesteComentarioDAO {
    
    JdbcDatabaseTester jdt;
    ComentarioDAO comentarioDAO;
    
    @Before
    public void setUp() throws Exception{
        jdt = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost/coursera?useTimezone=true&serverTimezone=UTC","root","");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/testeBD/inicio.xml"));
        jdt.onSetup();
        comentarioDAO = new ComentarioDAO();
    }
    
    @Test
    public void testaRecuperaComentario(){
        List<Comentario> c = comentarioDAO.recuperaComentarios(2);
        assertEquals(3, c.size());
    }
    
    @Test
    public void testaInsereComentario() throws Exception{
        Comentario c = new Comentario(4, 2, "Que bom Maria, fico feliz =)", "joao");
        
        comentarioDAO.inserirComentario(c);
        
        
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/testeBD/verifica-comentario.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
}
