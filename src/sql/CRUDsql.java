package sql;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class CRUDsql {
    ConexionSql conn = new ConexionSql();
    
    public void insertar( String nombre, String apellido, String puesto ){
        try {
            Connection conexion = conn.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "insert into empleados( nombre, apellido, puesto ) values ( '"+ nombre +"','"+ apellido +"','"+ puesto +"' )";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
