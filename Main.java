// Archivo: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaGestion sistema = new SistemaGestion();

        System.out.println("=== SISTEMA DE GESTIÓN DE VENTAS ===");
        System.out.print("Ingrese usuario: ");
        String user = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String pass = scanner.nextLine();

        Usuario usuario;

        // Simulación simple de login
        if (user.equals("admin") && pass.equals("123")) {
            usuario = new Administrador(user, pass);
        } else if (user.equals("vendedor") && pass.equals("123")) {
            usuario = new Vendedor(user, pass);
        } else {
            System.out.println("Credenciales incorrectas. Saliendo...");
            scanner.close();
            return;
        }

        sistema.iniciar(usuario);
        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
