// Archivo: SistemaGestion.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemaGestion {
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar(Usuario usuario) {
        int opcion;
        do {
            usuario.mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (usuario instanceof Administrador admin) {
                switch (opcion) {
                    case 1 -> registrarProducto();
                    case 2 -> mostrarStock();
                    case 3 -> admin.generarReporte();
                    case 0 -> System.out.println("Cerrando sesión...");
                    default -> System.out.println("Opción no válida.");
                }
            } else if (usuario instanceof Vendedor vendedor) {
                switch (opcion) {
                    case 1 -> realizarVenta(vendedor);
                    case 2 -> mostrarStock();
                    case 0 -> System.out.println("Cerrando sesión...");
                    default -> System.out.println("Opción no válida.");
                }
            }
        } while (opcion != 0);
    }

    private void registrarProducto() {
    System.out.print("Nombre del producto: ");
    String nombre = scanner.nextLine();
    System.out.print("Categoría: ");
    String categoria = scanner.nextLine();
    System.out.print("Precio: ");
    double precio = scanner.nextDouble();
    System.out.print("Stock inicial: ");
    int stock = scanner.nextInt();
    scanner.nextLine();

    String sql = "INSERT INTO producto (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ps.setString(2, categoria);
        ps.setDouble(3, precio);
        ps.setInt(4, stock);
        ps.executeUpdate();

        System.out.println("✅ Producto guardado correctamente en la base de datos.");

    } catch (SQLException e) {
        System.out.println("❌ Error al registrar producto: " + e.getMessage());
    }
}


    private void mostrarStock() {
    String sql = "SELECT * FROM producto";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        System.out.println("\n--- Lista de productos ---");
        while (rs.next()) {
            System.out.println("[" + rs.getInt("idProducto") + "] "
                    + rs.getString("nombre") + " - $" + rs.getDouble("precio")
                    + " (Stock: " + rs.getInt("stock") + ")");
        }

    } catch (SQLException e) {
        System.out.println("❌ Error al consultar productos: " + e.getMessage());
    }
}


    private void realizarVenta(Vendedor vendedor) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos disponibles para la venta.");
            return;
        }

        mostrarStock();
        System.out.print("Ingrese el ID del producto a vender: ");
        int id = scanner.nextInt();
        System.out.print("Cantidad a vender: ");
        int cantidad = scanner.nextInt();

        if (id <= 0 || id > listaProductos.size()) {
            System.out.println("ID inválido.");
            return;
        }

        Producto p = listaProductos.get(id - 1);
        vendedor.realizarVenta(p, cantidad);

        Venta v = new Venta((int) (Math.random() * 1000), new Date(), p.getPrecio() * cantidad);
        v.emitirComprobante();
    }
}
