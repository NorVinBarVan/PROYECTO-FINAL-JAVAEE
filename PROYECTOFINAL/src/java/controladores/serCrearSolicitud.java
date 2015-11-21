
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
import modelos.Solicitudes;


public class serCrearSolicitud extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String dpi = request.getParameter("dpi");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String edad = request.getParameter("edad");
        String fecha = request.getParameter("fecha");
        String codP = request.getParameter("codP");
        String codV = request.getParameter("codV");
        Conexion ultima = new Conexion();
        if("".equals(dpi) || "".equals(nombre) || "".equals(telefono) || "".equals(edad) || "".equals(fecha) || "".equals(codP) || "".equals(codV)){
          response.sendRedirect("vistaCrearSolicitud.xhtml");
        }else{
            int id = Integer.parseInt(dpi);
            int edades = Integer.parseInt(edad);
            int telefonos = Integer.parseInt(telefono);
            
            ultima.insertarCliente(id, nombre, telefonos, edades);
            
            Date dates = Date.valueOf(fecha);
            float precios = ultima.obtenerPrecio(codP);
            try {
                if(ultima.existeRegistro(codP, "codigo_Paquete", "Paquete_V") == false || ultima.existeRegistro(codV, "codigo_Empleado", "Empleado")==false){
                  response.sendRedirect("avisoNoExiste.xhtml");
                }else{
                  Solicitudes nueva = new Solicitudes(0, dates, precios, codP, codV, id);
                  ultima.crearSolicitud(nueva);
                  response.sendRedirect("avisoIngreso.xhtml");
                }
            } catch (SQLException ex) {
                Logger.getLogger(serCrearSolicitud.class.getName()).log(Level.SEVERE, null, ex);
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
