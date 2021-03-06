/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.UsuariosDTO;
import persistencia.Fachada;
/**
 *
 * @author jeisson
 */
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuariosDTO udto = null;
        Fachada facade = new Fachada();
        if (request.getParameter("rusu")!=null) {
            udto = new UsuariosDTO();
            udto.setIdUser(Long.parseLong(request.getParameter("id")));
            udto.setNombreCompleto(request.getParameter("nombres"));
            udto.setEmail(request.getParameter("email"));
            udto.setUserName(request.getParameter("usu"));
            udto.setPass(request.getParameter("pass"));
            String msj = facade.registrarUsuario(udto);
            response.sendRedirect("index.jsp?registrado="+msj);
        }else if(request.getParameter("Ingresar")!=null){
            String password = request.getParameter("pass");
            String usuario = request.getParameter("usu");
            boolean siExiste = facade.validarUsu(usuario, password);
            response.sendRedirect("index.jsp?k="+siExiste);

            if (siExiste == true) {
                long iduser = facade.existeUsuario(usuario, password);
                if (iduser != 0) {
                    HttpSession sesion = request.getSession();
                    udto = new UsuariosDTO();
                    udto = facade.getUsuario(iduser);
                    sesion.setAttribute("usuario", udto);
                    response.sendRedirect("paginas/inicio.jsp");
                }
            }
                else{
                    response.sendRedirect("index.jsp?desautorizado=Usuario o contraseña invalidos"
                    + siExiste);
                }
            }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
