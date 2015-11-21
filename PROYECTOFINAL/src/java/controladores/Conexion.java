
package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Clientes;
import modelos.Empleados;
import modelos.Paquetes;
import modelos.Solicitudes;
import modelos.Sucursal;

public class Conexion {
    
    public String classfor = "oracle.jdbc.driver.OracleDriver";
    public String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public String usuario = "EXPOTOUR";
    public String clave = "proyectojava";
    
    private Connection conn = null;
    private Statement consulta = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private LinkedList<Sucursal> agencias;
    
    public Conexion (){
        try{
           Class.forName(classfor);
           conn = DriverManager.getConnection(url, usuario, clave);
           consulta = conn.createStatement();
           agencias = new LinkedList<>();
        }catch(SQLException e){
           e.printStackTrace();
        }catch(ClassNotFoundException el){
           el.printStackTrace();
        }
    }
    
    public void ingresarAgencia (Sucursal agencias) throws SQLException{
        try {
            pr = conn.prepareStatement("INSERT INTO Sucursal (nombre, direccion, departamento, telefono, no_Administradores, no_Vendedores) VALUES (?,?,?,?,?,?)");
            pr.setString(1, agencias.getNombre());
            pr.setString(2, agencias.getDireccion());
            pr.setString(3, agencias.getDepartamento());
            pr.setInt(4, agencias.getTelefono());
            pr.setInt(5, agencias.getNumAd());
            pr.setInt(6, agencias.getNumVen());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
          pr.close();
        }
    }
    
    public LinkedList<Sucursal> obtenerAgencias(){
         LinkedList<Sucursal> mostrar = new LinkedList<Sucursal>();
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT * FROM Sucursal");
           
            while (rs.next()){
              Sucursal nuevo;
                nuevo = new Sucursal(rs.getInt("codigo_Sucursal"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("departamento"), rs.getInt("telefono"), rs.getInt("no_Administradores"), rs.getInt("no_Vendedores"));
                mostrar.add(nuevo);
            }
            rs.close();
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return mostrar;
    }
    
    public void cerrarConexion (){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void editarAgencia(String campo, String valor, String id){
       String actualizar;
       if("telefono".equals(campo)){
       actualizar = "UPDATE Sucursal SET "+campo+" = "+valor+" WHERE codigo_Sucursal ="+id;
       }else {
       actualizar = "UPDATE Sucursal SET "+campo+" = '"+valor+"' WHERE codigo_Sucursal ="+id;
       }
        try {
            pr = conn.prepareStatement(actualizar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarAgencia(String id) throws SQLException{
      String eliminar = "DELETE FROM Sucursal WHERE codigo_Sucursal ="+id;
        try {
            pr = conn.prepareStatement(eliminar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          pr.close();
        }
    }
    
    public void ingresarEmpleado(Empleados nuevo) throws SQLException{
        try {
            pr = conn.prepareStatement("INSERT INTO Empleado(codigo_Empleado, nombre, nit, edad, salario, cargo, codigo_Agencia) VALUES(?,?,?,?,?,?,NULL)");
            pr.setString(1, nuevo.getCodigo_Empleado());
            pr.setString(2, nuevo.getNombre());
            pr.setInt(3, nuevo.getNit());
            pr.setInt(4, nuevo.getEdad());
            pr.setFloat(5, nuevo.getSalario());
            pr.setString(6, nuevo.getCargo());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          pr.close();
        }   
    }
    
    public LinkedList<Empleados> obtenerEmpleados(){
        LinkedList<Empleados> lista1 = new LinkedList<>();
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT * FROM Empleado");
            
            while(rs.next()){
               Empleados nuevo;
                nuevo = new Empleados(rs.getString("codigo_Empleado"), rs.getString("nombre"), rs.getInt("nit"), rs.getInt("edad"), rs.getFloat("salario"), rs.getString("cargo"), rs.getString("codigo_Agencia"));
                lista1.add(nuevo);
            }
            rs.close();
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista1;
    }
    
    public void editarEmpleado(String campo, String valor, String id){
        String actualizar;
        if("codigo_Empleado".equals(campo) || "cargo".equals(campo) || "nombre".equals(campo)){
         actualizar = "UPDATE Empleado SET "+campo+" = '"+valor+"' WHERE codigo_Empleado = '"+id+"'";
        }else{
         actualizar = "UPDATE Empleado SET "+campo+" = "+valor+" WHERE codigo_Empleado ='"+id+"'";
        }
        try {
            pr = conn.prepareStatement(actualizar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public boolean existeRegistro(String dato, String campo, String table) throws SQLException{
     boolean respuesta= false;
    consulta = conn.createStatement();
    rs = consulta.executeQuery("SELECT * FROM "+table);
    
    while(rs.next()){
       if(dato.equals(rs.getString(campo))){
       respuesta =true;
       }
    }
    return respuesta;
    }
    
    public void eliminarEmpleado(String dato) throws SQLException{
      String eliminar = "DELETE FROM Empleado WHERE codigo_Empleado ='"+dato+"'";
        try {
            pr = conn.prepareStatement(eliminar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          pr.close();
        }
    }
    
    public void ingresarPaquete(Paquetes paquete){
        try {
            pr = conn.prepareStatement("INSERT INTO Paquete_V(codigo_Paquete, descripcion, destino, precio, fecha, nombre) VALUES(?,?,?,?,?,?)");
            pr.setString(1, paquete.getCodigoPaquete());
            pr.setString(2, paquete.getDescripcion());
            pr.setString(3, paquete.getDestino());
            pr.setFloat(4, paquete.getPrecio());
            pr.setDate(5,  paquete.getFecha());
            pr.setString(6, paquete.getNombre());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public LinkedList<Paquetes> obtenerPaquetes(){
        LinkedList<Paquetes> lista2 = new LinkedList<>();
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT * FROM Paquete_V");
            
            while(rs.next()){
               Paquetes nuevo;
                nuevo = new Paquetes(rs.getString("codigo_Paquete"), rs.getString("nombre"),rs.getString("descripcion"), rs.getString("destino"), rs.getFloat("precio"), rs.getDate("fecha"));
                lista2.add(nuevo);
            }
            rs.close();
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista2;
    }
     
     public void editarPaquetes(String campo, String valor, String id){
         String sentencia;
         if("precio".equals(campo)){
          sentencia = "UPDATE Paquete_V SET "+campo+"="+valor+" WHERE codigo_Paquete = '"+id+"'";
         }
         else{
           sentencia = "UPDATE Paquete_V SET "+campo+" = '"+valor+"' WHERE codigo_Paquete = '"+id+"'";
         }
        try {
            pr = conn.prepareStatement(sentencia);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }      
}
     
     public void editarFechaPaquete(Date fecha, String id){
         String sentencia = "UPDATE Paquete_V SET fecha = ? WHERE codigo_Paquete = '"+id+"'";
        try {
            pr = conn.prepareStatement(sentencia);
            pr.setDate(1, fecha);
             pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void eliminarPaquete(String dato) throws SQLException{
        String eliminar = "DELETE FROM Paquete_V  WHERE codigo_Paquete ='"+dato+"'";
        try {
            pr = conn.prepareStatement(eliminar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          pr.close();
        }
         
     }
     
     public void crearSolicitud(Solicitudes primera){
        String Sentencia = "INSERT INTO Solicitud(fecha_creacion, precio, codigo_Paq, codigo_Ven, dpi_Cliente) VALUES (?,?,?,?,?)";
        try {
            pr = conn.prepareStatement(Sentencia);
            pr.setDate(1, primera.getFecha());
            pr.setFloat(2, primera.getPrecio());
            pr.setString(3, primera.getCodP());
            pr.setString(4, primera.getCodE());
            pr.setInt(5, primera.getDpi());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
     
     }
     
     public void insertarCliente(int dpi, String nombre, int telefono, int edad){
       String sentencia = "INSERT INTO Cliente (dpi, nombre, telefono, edad) VALUES (?,?,?,?)";
        try {
            pr = conn.prepareStatement(sentencia);
            pr.setInt(1, dpi);
            pr.setString(2, nombre);
            pr.setInt(3, telefono);
            pr.setInt(4, edad);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public float obtenerPrecio (String id){
         
        float resultado=0;
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT precio FROM Paquete_V WHERE codigo_Paquete = '"+id+"'");
            
            while(rs.next()){
            resultado = rs.getFloat("precio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     return resultado;
     }
     
     
     public LinkedList<Solicitudes> obtenerSolicitudes(){
        LinkedList<Solicitudes> lista3 = new LinkedList<>();
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT * FROM Solicitud");
            
            while(rs.next()){
               Solicitudes nuevo;
                nuevo = new Solicitudes(rs.getInt("numero_id"), rs.getDate("fecha_creacion"),rs.getFloat("precio"), rs.getString("codigo_Paq"), rs.getString("codigo_Ven"), rs.getInt("dpi_Cliente"));
                lista3.add(nuevo);
            }
            rs.close();
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista3;
     }
     
     
     public LinkedList<Clientes> obtenerClientes(){
      LinkedList<Clientes> lista3 = new LinkedList<>();
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT * FROM Cliente");
            
            while(rs.next()){
               Clientes nuevo;
                nuevo = new Clientes(rs.getInt("dpi"), rs.getString("nombre"),rs.getInt("telefono"), rs.getInt("edad"));
                lista3.add(nuevo);
            }
            rs.close();
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista3;
     
     }
     
     public void editarSolicitud(String campo, String valor, String id){
         String sentencia;
         if("precio".equals(campo)){
          sentencia = "UPDATE Solicitud SET "+campo+" = "+valor+" WHERE numero_id = "+id;
         }else{
          sentencia = "UPDATE Solicitud SET "+campo+" = '"+valor+"' WHERE numero_id = "+id;
         }
        try {
            pr = conn.prepareStatement(sentencia);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void editarFechaSolicitud(Date fecha, String id){
         String sentencia = "UPDATE Solicitud SET fecha_creacion = ? WHERE numero_id = "+id;
        try {
            pr = conn.prepareStatement(sentencia);
            pr.setDate(1, fecha);
             pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
      public void eliminarSolicitud(String dato) throws SQLException{
        
           String eliminar = "DELETE FROM Solicitud  WHERE numero_id = "+dato;
        try {
            pr = conn.prepareStatement(eliminar);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          pr.close();
        }
      }
      
      public String verCargo(String id){
         String cargo = null;
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT cargo FROM Empleado WHERE codigo_Empleado = '"+id+"'");
            
            while(rs.next()){
            cargo = rs.getString("cargo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
      }
      
       public int verNoVendedores(String id){
         int numero=0;
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT no_Vendedores FROM Sucursal WHERE codigo_Sucursal = "+id);
            
            while(rs.next()){
            numero = rs.getInt("no_Vendedores");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
      }
       
        public int verNoAdministradores(String id){
         int numero=0;
        try {
            consulta = conn.createStatement();
            rs = consulta.executeQuery("SELECT no_Administradores FROM Sucursal WHERE codigo_Sucursal = "+id);
            
            while(rs.next()){
            numero = rs.getInt("no_Administradores");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
      }
        
        public void operarNoEmpleados(String id, String op, String campo) throws SQLException{
          String sentencia = "UPDATE Sucursal SET "+campo+" = "+campo+" "+op+" 1 WHERE codigo_Sucursal = "+id; 
         pr = conn.prepareStatement(sentencia);
         pr.executeUpdate();
        }
        
        public String verLlave(String id) throws SQLException{
          String llave = null;
            
        String sentencia = "SELECT codigo_Agencia FROM Empleado WHERE codigo_Empleado = '"+id+"'";
        consulta = conn.createStatement();
        rs = consulta.executeQuery(sentencia);
        
        while(rs.next()){
           llave = rs.getString("codigo_Agencia");
        }
        return llave;
        }
        
        
        public LinkedList<Sucursal> mirarSucursal(String id) throws SQLException{
         LinkedList<Sucursal> otro = new LinkedList<Sucursal>();
         String Sentencia = "SELECT * FROM Sucursal WHERE codigo_Sucursal = "+id;
         consulta = conn.createStatement();
         rs = consulta.executeQuery(Sentencia);
         
         while(rs.next()){
           otro.add(new Sucursal (rs.getInt("codigo_Sucursal"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("departamento"), rs.getInt("telefono"), rs.getInt("no_Administradores"), rs.getInt("no_Vendedores")));
         }
         return otro;
        }
        
        public LinkedList <Empleados> mirarEmpleados (String id) throws SQLException{
        
        LinkedList<Empleados> otro = new LinkedList<Empleados>();
         String Sentencia = "SELECT * FROM Empleado WHERE codigo_Agencia = "+id;
         consulta = conn.createStatement();
         rs = consulta.executeQuery(Sentencia);
         
         while(rs.next()){
           otro.add(new Empleados (rs.getString("codigo_Empleado"), rs.getString("nombre"), rs.getInt("nit"), rs.getInt("edad"), rs.getFloat("salario"), rs.getString("cargo"), rs.getString("codigo_Agencia")));
         }
         return otro;
        }
   
}