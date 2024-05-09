package sql;

//Importaciones de UI
import javax.swing.JOptionPane;

// Importaciones para SQL
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSql {
    // Declaración de todos los datos necesarios para la conexión
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5433/Empleado";
    String usuario = "postgres";
    String contrasena = "24681012";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            //Petición de conexión a la base de datos
            conn = DriverManager.getConnection(url,usuario,contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
}
