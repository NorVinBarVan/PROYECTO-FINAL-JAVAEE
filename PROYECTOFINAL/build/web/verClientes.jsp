<%-- 
    Document   : verClientes
    Created on : 20-nov-2015, 0:42:29
    Author     : usuario
--%>

<%@page import="modelos.Clientes"%>
<%@page import="modelos.Solicitudes"%>
<%@page import="java.util.LinkedList"%>
<%@page import="controladores.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="gray" text ="white">
        <a href ="paginaInicial.xhtml" style="color: white">VOLVER AL MENU</a>
    <center><h1>LISTADO DE CLIENTES</h1></center>
    <center><table border = 1 style ="background-color: teal">
            <tr>
                <td>DPI</td>
                <td>NOMBRE</td>
                <td>TELEFONO</td>
                <td>EDAD</td>
            </tr>
            <%
                Conexion verDatos = new Conexion();
                LinkedList<Clientes> lista =  verDatos.obtenerClientes();
                
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ lista.get(i).getNumero()+"</td>");
                   out.println("<td>"+ lista.get(i).getNombre()+"</td>");
                   out.println("<td>"+ lista.get(i).getTelefono()+"</td>");
                   out.println("<td>"+ lista.get(i).getEdad()+"</td>");
                   out.println("</tr>");
               }                   
            %>
        </table></center>
    </body>
</html>
