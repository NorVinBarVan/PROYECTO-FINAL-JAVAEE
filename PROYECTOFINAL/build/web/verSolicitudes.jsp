
<%@page import="java.util.LinkedList"%>
<%@page import="modelos.Solicitudes"%>
<%@page import="modelos.Paquetes"%>
<%@page import="controladores.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="brown" text ="white">
        <a href ="paginaInicial.xhtml" style="color: white">VOLVER AL MENU</a>
         <center><h1>LISTADO DE SOLICITUDES DE COMPRA</h1></center>
         <center><table border = 1 style ="background-color: lightseagreen">
            <tr>
                <td>NUMERO</td>
                <td>FECHA</td>
                <td>TOTAL</td>
                <td>CODIGO PAQUETE</td>
                <td>CODIGO VENDEDOR</td>
                <td>DPI CLIENTE</td>
            </tr>
            <%
                Conexion verDatos = new Conexion();
                LinkedList<Solicitudes> lista =  verDatos.obtenerSolicitudes();
                
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ lista.get(i).getNumero()+"</td>");
                   out.println("<td>"+ lista.get(i).getFecha()+"</td>");
                   out.println("<td>"+ lista.get(i).getPrecio()+"</td>");
                   out.println("<td>"+ lista.get(i).getCodP()+"</td>");
                   out.println("<td>"+ lista.get(i).getCodE()+"</td>");
                   out.println("<td>"+ lista.get(i).getDpi()+"</td>");
                   out.println("</tr>");
               }                   
            %>
             </table></center>
    </body>
</html>
