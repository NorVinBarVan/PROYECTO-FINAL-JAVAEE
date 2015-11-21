
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Paquetes;

public class serIngresoPaquete extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String desc = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        String precio = request.getParameter("precio");
        String fecha = request.getParameter("fecha");
        
       if("".equals(codigo) || "".equals(nombre) || "".equals(desc) || "".equals(destino) || "".equals(precio) || "".equals(fecha)) {
         response.sendRedirect("vistaIngresarPaquete.xhtml");
       }else{
           float precios = Float.parseFloat(precio);
           Date fecha2 = Date.valueOf(fecha);
           
          Conexion otroP = new Conexion();
          Paquetes nuevo = new Paquetes(codigo, nombre, desc, destino, precios, fecha2);
          
          if(otroP.existeRegistro(codigo, "codigo_Paquete", "Paquete_V")==true){
              response.sendRedirect("avisoExiste.xhtml");
          }else{
             otroP.ingresarPaquete(nuevo);
             response.sendRedirect("avisoIngreso.xhtml");
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
            Logger.getLogger(serIngresoPaquete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(serIngresoPaquete.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(serIngresoPaquete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(serIngresoPaquete.class.getName()).log(Level.SEVERE, null, ex);
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
