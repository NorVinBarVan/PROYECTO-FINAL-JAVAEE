
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class serEditarAgencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try{
        String id = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String dire = request.getParameter("direccion");
        String depto = request.getParameter("departamento");
        String telefono = request.getParameter("telefono");
        
        if("".equals(id)){
            response.sendRedirect("editarAgencia.xhtml");
        }else {
        
        if("".equals(nombre) && "".equals(dire) && "".equals(depto) && "".equals(telefono)){
           response.sendRedirect("editarAgencia.xhtml");
        }else{
            Conexion update = new Conexion();
            if(!"".equals(nombre)) update.editarAgencia("nombre", nombre, id);
            if(!"".equals(dire)) update.editarAgencia("direccion", dire, id);
            if(!"".equals(depto)) update.editarAgencia("departamento", depto, id);
            if(!"".equals(telefono)) update.editarAgencia("telefono", telefono, id);
            update.cerrarConexion();
            response.sendRedirect("aviso1.xhtml");
        }
        }
        }finally{
         out.close();
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
