// Archivo: Cliente.java
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(int idCliente, String nombre, String apellido, String dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDni() {
        return dni;
    }
}
