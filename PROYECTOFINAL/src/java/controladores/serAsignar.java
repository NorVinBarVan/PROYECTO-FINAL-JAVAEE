
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

public class serAsignar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String empleado = request.getParameter("emp");
        String agencia = request.getParameter("suc");
        Conexion ver = new Conexion();
        
        if("".equals(empleado) || "".equals(agencia)){
         response.sendRedirect("vistaAsignar.xhtml");
        }else{
          if(ver.existeRegistro(empleado, "codigo_Empleado", "Empleado")==true && ver.existeRegistro(agencia, "codigo_Sucursal", "Sucursal")==true){
              String cargo = ver.verCargo(empleado);
              String llave = ver.verLlave(empleado);
              
              if(null != cargo)switch (cargo) {
                  case "Administrador":
                      // VER SI ES ADMINISTRADOR
                      int ad = ver.verNoAdministradores(agencia);
                      if(ad == 0){
                          if(llave == null || "".equals(llave)){
                              ver.operarNoEmpleados(agencia, "+", "no_Administradores");
                              ver.editarEmpleado("codigo_Agencia", agencia, empleado);
                          }else{
                              ver.operarNoEmpleados(llave, "-", "no_Administradores");
                              ver.editarEmpleado("codigo_Agencia", agencia, empleado);
                          }
                           response.sendRedirect("asignado.xhtml");
                      }else{
                          response.sendRedirect("yaAd.xhtml");
                      }    break;
                  case "Vendedor":
                      //VER SI ES VENDEDOR
                      //SEPARADOR DE CODIGO
                      int ven = ver.verNoVendedores(agencia);
                      if(ven < 8){
                          if(llave == null || "".equals(llave)){
                              ver.operarNoEmpleados(agencia, "+", "no_Vendedores");
                              ver.editarEmpleado("codigo_Agencia", agencia, empleado);
                          }else{
                              ver.operarNoEmpleados(llave, "-", "no_Vendedores");
                              ver.editarEmpleado("codigo_Agencia", agencia, empleado);
                          }   
                          response.sendRedirect("asignado.xhtml");
                      }else{
                          response.sendRedirect("yaVen.xhtml");
                 }    break;
              }
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
            Logger.getLogger(serAsignar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(serAsignar.class.getName()).log(Level.SEVERE, null, ex);
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
