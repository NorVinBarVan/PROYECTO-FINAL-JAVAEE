
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

public class serEditarPaquete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String codigoO = request.getParameter("codigoO");
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        String precio = request.getParameter("precio");
        String fecha = request.getParameter("fecha");
        
        Conexion nueva = new Conexion();
        
       if("".equals(codigoO) && "".equals(codigo) && "".equals(nombre) && "".equals(descripcion) &&  "".equals(destino) && "".equals(precio) && "".equals(fecha)) {
         response.sendRedirect("vistaEditarPaquete.xhtml");
       }else{
       
        if(nueva.existeRegistro(codigoO, "codigo_Paquete", "Paquete_V")== true){
           if(!"".equals(codigo)) nueva.editarPaquetes("codigo_Paquete", codigo, codigoO);
           if(!"".equals(nombre)) nueva.editarPaquetes("nombre", nombre, codigoO);
           if(!"".equals(descripcion)) nueva.editarPaquetes("descripcion", descripcion, codigoO);
           if(!"".equals(destino)) nueva.editarPaquetes("destino", destino, codigoO);
           if(!"".equals(fecha)) {
               Date fechas = Date.valueOf(fecha);
               nueva.editarFechaPaquete(fechas, codigoO);
           }
           if(!"".equals(precio)) nueva.editarPaquetes("precio", precio, codigoO);
           nueva.cerrarConexion();
           response.sendRedirect("aviso1.xhtml");
        }else{
          response.sendRedirect("avisoNoExiste.xhtml");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(serEditarPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(serEditarPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
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
