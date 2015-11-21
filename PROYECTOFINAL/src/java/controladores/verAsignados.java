
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Empleados;
import modelos.Sucursal;

public class verAsignados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String codigo = request.getParameter("codigo");
        Conexion otra = new Conexion();
        if("".equals(codigo)){
         response.sendRedirect("vistaGrupo.xhtml");
        }else{
        if(otra.existeRegistro(codigo, "codigo_Sucursal", "Sucursal")==true){
             Conexion verDatos = new Conexion();
                LinkedList<Sucursal> lista =  verDatos.mirarSucursal(codigo);
                 out.println("<html>");
                 out.println("<body bgcolor ='gray' text = 'white'>");
                 out.println("<a href ='paginaInicial.xhtml' style ='color:white'>VOLVER AL MENU</a>");
                out.println("<center><h1> DATOS DE AGENCIA</h1></center>");
                out.println("<center>");
                 out.println("<table border = 1 style = 'background-color: brown'>");
                 out.println("<tr>");
                  out.println("<td>");
                  out.println("<h4>CODIGO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>NOMBRE</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>DIRECCION</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>DEPARTAMENTO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>TELEFONO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>NUM ADMINISTRADORES</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>NUM VENDEDORES</h4>");
                   out.println("</td>");
                    out.println("</tr>");
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ lista.get(i).getCodigo_Sucursal()+"</td>");
                   out.println("<td>"+ lista.get(i).getNombre()+"</td>");
                   out.println("<td>"+ lista.get(i).getDireccion()+"</td>");
                   out.println("<td>"+ lista.get(i).getDepartamento()+"</td>");
                   out.println("<td>"+ lista.get(i).getTelefono()+"</td>");
                   out.println("<td>"+ lista.get(i).getNumAd()+"</td>");
                   out.println("<td>"+ lista.get(i).getNumVen()+"</td>");
                   out.println("</tr>");
               }                   
            out.println("</table>");
            out.println("</center>");
            out.println("</br>");
            
                Conexion verDato = new Conexion();
                LinkedList<Empleados> listas =  verDato.mirarEmpleados(codigo);
                
                 out.println("<center><h1> DATOS DE EMPLEADOS</h1></center>");
                 out.println("<center><table border = 1 style = 'background-color: brown'><center>");
                 out.println("<tr>");
                  out.println("<td>");
                  out.println("<h4>CODIGO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>NOMBRE</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>NIT</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>EDAD</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>SALARIO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>CARGO</h4>");
                   out.println("</td>");
                   out.println("<td>");
                  out.println("<h4>CODIGO DE AGENCIA</h4>");
                   out.println("</td>");
                    out.println("</tr>");
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ listas.get(i).getCodigo_Empleado()+"</td>");
                   out.println("<td>"+ listas.get(i).getNombre()+"</td>");
                   out.println("<td>"+ listas.get(i).getNit()+"</td>");
                   out.println("<td>"+ listas.get(i).getEdad()+"</td>");
                   out.println("<td>"+ listas.get(i).getSalario()+"</td>");
                   out.println("<td>"+ listas.get(i).getCargo()+"</td>");
                   out.println("<td>"+ listas.get(i).getCodigo_Agencia()+"</td>");
                   out.println("</tr>");
               }
               out.println("</table>");
               out.println("</br>");
               out.println("</body>");
               out.println("</html>");
        }else{
        response.sendRedirect("avisoNoExiste.xhtml");
        }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verAsignados.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(verAsignados.class.getName()).log(Level.SEVERE, null, ex);
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
