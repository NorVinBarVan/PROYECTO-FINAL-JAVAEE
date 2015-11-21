
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Sucursal;

public class ingresoAgencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String depto = request.getParameter("departamento");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            
            if(!"".equals(nombre) && !"".equals(direccion) && !"".equals(depto) && !"".equals(request.getParameter("telefono"))){
            
                 Sucursal nuevaSucursal = new Sucursal(0, nombre, direccion, depto, telefono, 0, 0);
            
                 Conexion nuevaConexion = new Conexion();
                 nuevaConexion.ingresarAgencia(nuevaSucursal);
                 nuevaConexion.cerrarConexion();
                 response.sendRedirect("avisoIngreso.xhtml");
                
            }else {
             response.sendRedirect("vistaIngresoAgencia.xhtml");
            }
        }   catch (SQLException ex) {
            Logger.getLogger(ingresoAgencia.class.getName()).log(Level.SEVERE, null, ex);
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
