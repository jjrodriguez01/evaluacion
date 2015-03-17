/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import modelo.UsuariosDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeisson
 */
public class UsuariosDAOTest {
    
    public UsuariosDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarUsuario method, of class UsuariosDAO.
     */
    @Test
    public void testInsertarUsuario() {
        System.out.println("insertarUsuario");
        UsuariosDTO usu = null;
        Connection cnn = null;
        UsuariosDAO instance = new UsuariosDAO();
        String expResult = "";
        String result = instance.insertarUsuario(usu, cnn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarUsuario method, of class UsuariosDAO.
     */
    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        String user = "";
        String pass = "";
        Connection cnn = null;
        UsuariosDAO instance = new UsuariosDAO();
        boolean expResult = false;
        boolean result = instance.validarUsuario(user, pass, cnn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usuarioValido method, of class UsuariosDAO.
     */
    @Test
    public void testUsuarioValido() {
        System.out.println("usuarioValido");
        String user = "";
        String pass = "";
        Connection cnn = null;
        UsuariosDAO instance = new UsuariosDAO();
        long expResult = 0L;
        long result = instance.usuarioValido(user, pass, cnn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUno method, of class UsuariosDAO.
     */
    @Test
    public void testListarUno() {
        System.out.println("listarUno");
        long id = 1016036010;
        Connection cnn = null;
        UsuariosDAO instance = new UsuariosDAO();
        UsuariosDTO expResult = null;
        UsuariosDTO result = instance.listarUno(id, cnn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
