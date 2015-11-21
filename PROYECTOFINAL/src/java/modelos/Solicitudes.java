
package modelos;

import java.sql.Date;

public class Solicitudes {
    private int numero;
    private Date fecha;
    private float precio;
    private String codP;
    private String codE;
    private int dpi;

    public Solicitudes(int numero, Date fecha, float precio, String codP, String codE, int dpi) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.codP = codP;
        this.codE = codE;
        this.dpi = dpi;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCodP() {
        return codP;
    }

    public void setCodP(String codP) {
        this.codP = codP;
    }

    public String getCodE() {
        return codE;
    }

    public void setCodE(String codE) {
        this.codE = codE;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }
}
