/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class serEditarSolicitudes extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String num = request.getParameter("num");
        String fecha = request.getParameter("fecha");
        String codP = request.getParameter("codP");
        String codE = request.getParameter("codV");
        
        Conexion mostrar = new Conexion();
        
        if("".equals(num) && "".equals(fecha) && "".equals(codP) && "".equals(codE)){
            response.sendRedirect("vistaEditarSolicitud.xhtml");
        }else{
            try {
                if(mostrar.existeRegistro(num, "numero_id", "Solicitud")==true){
                    if(!"".equals(fecha)){
                       Date fechas = Date.valueOf(fecha);
                       mostrar.editarFechaSolicitud(fechas, num);
                       response.sendRedirect("aviso1.xhtml");
                    }
                    
                    if(!"".equals(codP)){
                       if(mostrar.existeRegistro(codP, "codigo_Paquete", "Paquete_V")==true){
                          mostrar.editarSolicitud("codigo_Paq", codP, num);
                          float precios = mostrar.obtenerPrecio(codP);
                          mostrar.editarSolicitud("precio", Float.toString(precios), num);
                       } else{
                       response.sendRedirect("avisoNoExiste.xhtml");
                       }
                    }
                    if(!"".equals(codE)){
                      if(mostrar.existeRegistro(codE, "codigo_Empleado", "Empleado")==true){
                         mostrar.editarSolicitud("codigo_Ven", codE, num);
                      }else{
                       response.sendRedirect("avisoNoExiste.xhtml");
                      }  
                    }
                }else{
                  response.sendRedirect("avisoNoExiste.xhtml");
                }
            } catch (SQLException ex) {
                Logger.getLogger(serEditarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
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
