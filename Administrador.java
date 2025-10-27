// Archivo: Administrador.java
public class Administrador extends Usuario {

    public Administrador(String usuario, String contraseña) {
        super(usuario, contraseña, "Administrador");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- Menú Administrador ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Consultar stock");
        System.out.println("3. Generar reporte");
        System.out.println("0. Salir");
    }

    public void generarReporte() {
        System.out.println("Generando reporte de ventas...");
    }
}
