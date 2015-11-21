
package modelos;

public class Clientes {
    private int numero;
    private String nombre;
    private int telefono;
    private int edad;

    public Clientes(int numero, String nombre, int telefono, int edad) {
        this.numero = numero;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
