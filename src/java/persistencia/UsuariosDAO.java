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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.UsuariosDTO;
//import static controlador.Conectar.getConnection;
/**
 *
 * @author Sena
 */
public class UsuariosDAO {
    
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String mensaje = "";
    private int rtdo;
    
    public synchronized String insertarUsuario(UsuariosDTO usu, Connection cnn){
        try{
        ps = cnn.prepareStatement("INSERT INTO usuarios ( iduser, NombreCompleto, email," 
               + " userName, pass) VALUES (?, ?, ?, ?, md5(?))");
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
    
    public boolean validarUsuario(String user, String pass, Connection cnn){
        boolean existe = false;
        try{
        ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE userName = ? "
                + " AND pass= ?;");
        ps.setString(1, user);
        ps.setString(2, pass);
        result = ps.executeQuery();
        if (result!=null){
            while(result.next()){
            existe = true;
            }
        }  
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error " + sqle.getMessage();
        }
        return existe;
    }
    public long usuarioValido(String user, String pass, Connection cnn){
        long id = 0;
        try{
        ps = cnn.prepareStatement("SELECT idUser FROM usuarios WHERE userName = ?"
                + " AND pass= ?;");
        ps.setString(1, user);
        ps.setString(2, pass);
        result = ps.executeQuery();
        if (result!=null){
            while(result.next()){
            id = result.getLong("iduser");
            }
        }  
        }catch(SQLException sqle){
            mensaje = "Ha ocurrido un error " + sqle.getMessage();
        }
        return id;
    }
    
    public UsuariosDTO listarUno(long id, Connection cnn){
        UsuariosDTO usuario = new UsuariosDTO();
        try {
            
            ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE idUser = ?;");
            ps.setLong(1, id);
            result = ps.executeQuery();
            while(result.next()){
                usuario.setIdUser(result.getLong("idUser"));
                usuario.setNombreCompleto(result.getString("nombreCompleto"));
                usuario.setEmail(result.getString("email"));
                usuario.setUserName(result.getString("userName"));
                usuario.setPass(result.getString("pass"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
}
