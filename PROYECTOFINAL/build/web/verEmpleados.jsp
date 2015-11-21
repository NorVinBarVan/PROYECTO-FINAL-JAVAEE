<%@page import="controladores.Conexion"%>
<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "modelos.Sucursal"%> 
<%@ page import = "modelos.Empleados"%> 
<%@ page import = "controladores.Conexion"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="brown" text ="white">
         <a href ="paginaInicial.xhtml" style="color: white">VOLVER AL MENU</a>
         <center><h1>LISTADO DE EMPLEADOS DE EXPOTOUR INGRESADOS</h1></center>
         <center><table border = 1 style ="background-color: lightseagreen">
            <tr>
                <td>CODIGO</td>
                <td>NOMBRE</td>
                <td>NIT</td>
                <td>EDAD</td>
                <td>SALARIO</td>
                <td>CARGO</td>
                <td>CODIGO SUCURSAL</td>
            </tr>
            <%
                Conexion verDatos = new Conexion();
                LinkedList<Empleados> lista =  verDatos.obtenerEmpleados();
                
               for (int i=0; i< lista.size(); i++){
                   out.println("<tr>");
                   out.println("<td>"+ lista.get(i).getCodigo_Empleado()+"</td>");
                   out.println("<td>"+ lista.get(i).getNombre()+"</td>");
                   out.println("<td>"+ lista.get(i).getNit()+"</td>");
                   out.println("<td>"+ lista.get(i).getEdad()+"</td>");
                   out.println("<td>"+ lista.get(i).getSalario()+"</td>");
                   out.println("<td>"+ lista.get(i).getCargo()+"</td>");
                   out.println("<td>"+ lista.get(i).getCodigo_Agencia()+"</td>");
                   out.println("</tr>");
               }                   
            %>
             </table></center>
    </body>
</html>
