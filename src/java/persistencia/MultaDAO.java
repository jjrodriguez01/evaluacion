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
public class MultaDAO {
    
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String mensaje = "";
    private int rtdo;
    
    public String insertarMulta(int idPrestamo, String fechaMulta, int valorTotal, String fechaPago, Connection cnn){
        try{
        ps = cnn.prepareStatement("INSERT INTO multas VALUES (?,?,?,?)");
        ps.setInt(1, idPrestamo);
        ps.setString(2, fechaMulta);
        ps.setInt(3, valorTotal);
        ps.setString(4, fechaPago);
        rtdo= ps.executeUpdate();
            if (rtdo > 0) {
                mensaje = "Se inserto la multa";
            }else{
                mensaje = "No se pudo insertar la multa";
            }
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error "+ sqle.getMessage();
        }
        return mensaje;
    }
}
