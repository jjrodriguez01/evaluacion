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

/**
 *
 * @author jeisson
 */
public class PrestamoDAO {
    
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String mensaje = "";
    private int rtdo;
    
    public String insertarPrestamo(long iduser, int idlibro, String fechavencida, Connection cnn){
        
        try{
        ps = cnn.prepareStatement("INSERT INTO prestamos VALUES(?,?,?,?)");
        ps.setLong(1, iduser);
        ps.setInt(2,idlibro);
        ps.setString(3, fechavencida);
        ps.setByte(4, (byte)0);
        rtdo = ps.executeUpdate();
            if (rtdo > 0) {
                mensaje = "Se inserto el prestamo";
            }else{
                mensaje = "No se inserto el prestamo";
            }
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error "+sqle.getMessage();
        }
        return mensaje;
    }
}
