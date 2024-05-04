package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/JaimeTAP";
    String usuario = "postgres";
    String contrasena = "1234";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario,contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
}
