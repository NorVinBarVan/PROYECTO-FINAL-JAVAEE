/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelos.Empleados;


public class serIngresoEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String nit = request.getParameter("nit");
        String edad = request.getParameter("edad");
        String salario = request.getParameter("salario");
        String cargo = request.getParameter("Cargo");
        
        if("".equals(codigo) || "".equals(nombre) || "".equals(nit) || "".equals(edad) || "".equals(salario)||"".equals(cargo) ){
            response.sendRedirect("errorDatos.xhtml");
        }else{
            int nit1 = Integer.parseInt(nit);
            int edad1 = Integer.parseInt(edad);
            float salario1 = Float.parseFloat(salario);
            
          Conexion emple = new Conexion();
          Empleados otro = new Empleados(codigo, nombre, nit1, edad1, salario1, cargo, null);
          emple.ingresarEmpleado(otro);
          emple.cerrarConexion();
          response.sendRedirect("avisoIngreso.xhtml");
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
            Logger.getLogger(serIngresoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(serIngresoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
