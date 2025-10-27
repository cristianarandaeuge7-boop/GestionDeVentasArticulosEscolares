import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/libreria?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "root";
        String contraseña = "sigloXX1.";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ¡Importante!
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
        }
    }
}
