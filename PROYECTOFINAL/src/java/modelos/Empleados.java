
package modelos;

public class Empleados {
    private String codigo_Empleado;
    private String nombre;
    private int nit;
    private int edad;
    private float salario;
    private String cargo;
    private String codigo_Agencia;

    public Empleados(String codigo_Empleado, String nombre, int nit, int edad, float salario,String cargo, String codigo_Agencia) {
        this.codigo_Empleado = codigo_Empleado;
        this.nombre = nombre;
        this.nit = nit;
        this.edad = edad;
        this.salario = salario;
        this.cargo = cargo;
        this.codigo_Agencia = codigo_Agencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleados(String cargo) {
        this.cargo = cargo;
    }

    public String getCodigo_Empleado() {
        return codigo_Empleado;
    }

    public void setCodigo_Empleado(String codigo_Empleado) {
        this.codigo_Empleado = codigo_Empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCodigo_Agencia() {
        return codigo_Agencia;
    }

    public void setCodigo_Agencia(String codigo_Agencia) {
        this.codigo_Agencia = codigo_Agencia;
    }
}
