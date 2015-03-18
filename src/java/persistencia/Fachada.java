
package persistencia;
import controlador.Conectar;
import java.sql.Connection;
import modelo.UsuariosDTO;
import java.util.List;
/**
 *
 * @author jeisson
 */
public class Fachada {
    
    UsuariosDAO udao;
    MultaDAO multadao;
    PrestamoDAO prestamodao;
    LibroDAO librodao;
    Connection conexion;
    
    public Fachada() {
        udao = new UsuariosDAO();
        multadao = new MultaDAO();
        prestamodao = new PrestamoDAO();
        librodao = new LibroDAO();
        conexion = Conectar.getConnection();
    }
    
    public String registrarUsuario(UsuariosDTO udto){
        return udao.insertarUsuario(udto, conexion);
    }
    public boolean validarUsu(String user, String pass){
        return udao.validarUsuario(user, pass, conexion);
    }
    public long existeUsuario(String user, String pass){
        return udao.usuarioValido(user, pass, conexion);
    }
    public UsuariosDTO getUsuario(long id){
        return udao.listarUno(id, conexion);
    }
    
    public boolean usuarioMultado(long id){
        return udao.listarConMulta(id, conexion);
    }
    
    public List<UsuariosDTO> listarUsuarios(){
        return udao.listarTodo(conexion);
    }
    
    public boolean estaMultado(Long id){
        return udao.listarConMulta(id, conexion);
    }
    
    public int tieneCupo(long id){
        return udao.cantPrestamos(id, conexion);
    }
}
