/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class serEditarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String codigoM = request.getParameter("codigoM");
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String nit = request.getParameter("nit");
        String edad = request.getParameter("edad");
        String salario = request.getParameter("salario");
        String cargo = request.getParameter("cargo");
        
      if("".equals(codigo) && "".equals(nombre) && "".equals(nit) && "".equals(salario) && "".equals(edad) && "".equals(cargo) && "".equals(codigoM)){
          response.sendRedirect("vistaEditarEmpleado");
      }else{
          
          Conexion editar = new Conexion();
           if(!"".equals(codigo))  editar.editarEmpleado("codigo_Empleado", codigo, codigoM);
           if(!"".equals(nombre)) editar.editarEmpleado("nombre", nombre, codigoM);
           if(!"".equals(nit)) editar.editarEmpleado("nit", nit, codigoM);
           if(!"".equals(edad))editar.editarEmpleado("edad", edad, codigoM);
           if(!"".equals(salario))editar.editarEmpleado("salario", salario, codigoM);
           if(cargo != null) editar.editarEmpleado("cargo", cargo, codigoM);
         editar.cerrarConexion();
         response.sendRedirect("aviso1.xhtml");
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
