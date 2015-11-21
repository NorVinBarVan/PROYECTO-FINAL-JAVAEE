<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "modelos.Sucursal"%> 
<%@ page import = "controladores.Conexion"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="green" text ="white">
        <a href ="paginaInicial.xhtml" style ="color: white">VOLVER AL MENU</a>
    <center><h1>LISTADO DE AGENCIAS</h1></center>
    <center><table border = 1 style="background-color: #045491">
            <tr>
                <td>CODIGO</td>
                <td>NOMBRE</td>
                <td>DIRECCION</td>
                <td>DEPARTAMENTO</td>
                <td>TELEFONO</td>
                <td>No. Ad</td>
                <td>No. Vendedores</td>
            </tr>
            <%
                Conexion verDatos = new Conexion();
                LinkedList<Sucursal> lista =  verDatos.obtenerAgencias();
                
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
            %>
        </table></center>
    </body>
</html>
