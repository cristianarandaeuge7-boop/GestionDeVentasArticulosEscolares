// Archivo: Venta.java
import java.util.Date;

public class Venta {
    private int idVenta;
    private Date fecha;
    private double total;

    public Venta(int idVenta, Date fecha, double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }

    public void aplicarDescuento(double porcentaje) {
        total -= (total * porcentaje / 100);
    }

    public void emitirComprobante() {
        System.out.println("Comprobante emitido por $" + total + " en fecha " + fecha + " (ID Venta: " + idVenta + ")");
    }
}
