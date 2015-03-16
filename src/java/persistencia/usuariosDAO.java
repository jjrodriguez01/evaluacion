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
import modelo.usuariosDTO;
import static controlador.Conectar.getConnection;
/**
 *
 * @author Sena
 */
public class usuariosDAO {
    
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String mensaje = "";
    private int rtdo;
    
    public synchronized String insertarUsuario(usuariosDTO usu, Connection cnn){
        try{
        ps = cnn.prepareStatement("INSERT INTO usuarios ( idUser, NombreCompleto, email," 
               + "userName, pass) VALUES (?, ?, ?, ?, md5(?) ");
        ps.setLong(1, usu.getIdUser());
        ps.setString(2, usu.getNombreCompleto());
        ps.setString(3, usu.getEmail());
        ps.setString(4, usu.getUserName());
        ps.setString(5, usu.getPass());
        rtdo = ps.executeUpdate();
            if (rtdo>0) {
                mensaje = "Se inserto el usuario";
            }
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error"+ sqle.getMessage();
        }
        return mensaje;
    }
    
}
