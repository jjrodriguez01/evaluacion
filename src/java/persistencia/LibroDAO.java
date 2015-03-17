/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LibroDTO;

/**
 *
 * @author Sena
 */
public class LibroDAO {
    
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
            mensaje = "Error " + sqle.getMessage();
        }
        return mensaje;
    }
    
    public String cambiarEstado(int idLibro, byte nuevoEstado, Connection cnn){
        try{
        ps=cnn.prepareStatement("UPDATE libros set estado = ? WHERE idlibro = ?");
        ps.setByte(1, nuevoEstado);
        ps.setInt(2, idLibro);
        rtdo = ps.executeUpdate();
            if (rtdo > 0) {
                mensaje = "Se cambio el estado del libro";
            }else{
                mensaje = "No se pudo cambiar el estado";
            }
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error " + sqle.getMessage();
        }
        return mensaje;
    }
}
