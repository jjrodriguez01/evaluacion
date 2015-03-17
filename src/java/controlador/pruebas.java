/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import persistencia.*;
/**
 *
 * @author jeisson
 */
public class pruebas {
    public static void main(String args[]){
 UsuariosDTO usus = new UsuariosDTO();
 Fachada f = new Fachada(); 
 usus= f.getUsuario(1016036010);

    }
}
