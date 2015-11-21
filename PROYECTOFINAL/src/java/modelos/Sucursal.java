

package modelos;

public class Sucursal {
    
    private  int codigo_Sucursal;
    private  String nombre;
    private  String direccion;
    private  String departamento;
    private  int telefono;
    private int numAd;
    private int numVen;

    public void setCodigo_Sucursal(int codigo_Sucursal) {
        this.codigo_Sucursal = codigo_Sucursal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNumAd(int numAd) {
        this.numAd = numAd;
    }

    public void setNumVen(int numVen) {
        this.numVen = numVen;
    }
 
    public int getCodigo_Sucursal() {
        return codigo_Sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getNumAd() {
        return numAd;
    }

    public int getNumVen() {
        return numVen;
    }
    
    public Sucursal (int cod, String nombre, String dir, String depto, int telefono, int noAd, int noVen){
        this.codigo_Sucursal = cod;
        this.nombre = nombre;
        this.direccion = dir;
        this.departamento = depto;
        this.telefono = telefono;   
        this.numAd = noAd;
        this.numVen = noVen;
    }
    
}
