
package modelos;

import java.sql.Date;

public class Paquetes {
    private String codigoPaquete;
    private String nombre;
    private String descripcion;
    private String destino;
    private float precio;
    private Date fecha;


    public Paquetes(String codigoPaquete, String nombre, String descripcion, String destino, float precio, Date fecha) {
        this.codigoPaquete = codigoPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(String codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
