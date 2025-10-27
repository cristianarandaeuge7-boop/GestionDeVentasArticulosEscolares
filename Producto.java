// Archivo: Producto.java
public class Producto {
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    public Producto(int idProducto, String nombre, String categoria, double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public void actualizarStock(int cantidadVendida) throws Exception {
        if (cantidadVendida > stock) {
            throw new Exception("Stock insuficiente para el producto: " + nombre);
        }
        stock -= cantidadVendida;
    }

    public String getCategoria() { return categoria; }

    public void mostrarInfo() {
        System.out.println("[" + idProducto + "] " + nombre + " - $" + precio + " (Stock: " + stock + ", Categoría: " + categoria + ")");
    }
}
