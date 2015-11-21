
<%@page import="controladores.Conexion"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelos.Paquetes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="brown" text ="white">
         <a href ="paginaInicial.xhtml" style="color: white">VOLVER AL MENU</a>
         <center><h1>LISTADO DE PAQUETES VACACIONALES</h1></center>
         <center><table border = 1 style ="background-color: lightseagreen">
            <tr>
                <td>CODIGO</td>
                <td>NOMBRE</td>
                <td>DESCRIPCION</td>
                <td>DESTINO</td>
                <td>PRECIO</td>
                <td>FECHA</td>
            </tr>
            <%
                Conexion verDatos = new Conexion();
                LinkedList<Paquetes> lista =  verDatos.obtenerPaquetes();
                
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ lista.get(i).getCodigoPaquete()+"</td>");
                   out.println("<td>"+ lista.get(i).getNombre()+"</td>");
                   out.println("<td>"+ lista.get(i).getDescripcion()+"</td>");
                   out.println("<td>"+ lista.get(i).getDestino()+"</td>");
                   out.println("<td>"+ lista.get(i).getPrecio()+"</td>");
                   out.println("<td>"+ lista.get(i).getFecha()+"</td>");
                   out.println("</tr>");
               }                   
            %>
             </table></ceter>
    </body>
</html>
