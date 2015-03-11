/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.libroDTO;

/**
 *
 * @author Sena
 */
public class libroDAO {
    
    private String mensaje="";
    private PreparedStatement ps = null;
    private ResultSet  rs = null;
    private int rtdo;
    public String eliminarLibro(int idlibro, Connection cnn){
        try{
        ps = cnn.prepareStatement("DELETE FROM libros WHERE idlibro=?;");
                ps.setInt(1, idlibro);
                rtdo = ps.executeUpdate();
            if (rtdo>0) {
                
            }
        }catch(SQLException sqle){
            
        }
        return mensaje;
    }
}
