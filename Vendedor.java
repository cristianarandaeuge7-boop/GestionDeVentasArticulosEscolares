// Archivo: Vendedor.java
public class Vendedor extends Usuario {

    public Vendedor(String usuario, String contraseña) {
        super(usuario, contraseña, "Vendedor");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- Menú Vendedor ---");
        System.out.println("1. Realizar venta");
        System.out.println("2. Consultar stock");
        System.out.println("0. Salir");
    }

    public void realizarVenta(Producto p, int cantidad) {
        try {
            p.actualizarStock(cantidad);
            System.out.println("Venta realizada correctamente. Nuevo stock: " + p.getStock());
        } catch (Exception e) {
            System.out.println("Error en la venta: " + e.getMessage());
        }
    }
}
