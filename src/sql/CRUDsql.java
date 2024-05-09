package sql;

// Importaciones de Objetos
import GetSet.Variables;

//Importaciones de UI
import javax.swing.JOptionPane;

// Importaciones para SQL
import java.sql.Connection;
import java.sql.ResultSet;

//Notece que de esta clase extiende de la conexion con PostgreSQL
public class CRUDsql extends ConexionSql {

    // Declaración de Objetos necesarios para el CRUD
    java.sql.Statement st;
    ResultSet rs;
    Variables variables = new Variables();

    public void insertar(String nombre, String apellido, String puesto) {
        try {
            // Iniciar la conexión
            Connection conexion = conectar();
            st = conexion.createStatement();
            // Armar el Query SQL Con los datos pasados por parámetro
            String sql = "insert into empleados( nombre, apellido, puesto ) "
                    + "values ( '" + nombre + "','" + apellido + "','" + puesto 
                    + "');";
            //Ejecutar
            st.execute(sql);
            // Si todo resultó mostrar mensaje y cerrar la conexión
            JOptionPane.showMessageDialog(
                    null, 
                    "El registro se guardo correctamente");
            st.close();
            conexion.close();
        } catch (Exception e) {
            //Si ocurre un error mostrarlo
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage());
        }
    }

    public void mostrar(String idEmplado) {
        try {
            // Iniciar la conexión
            Connection conexion = conectar();
            st = conexion.createStatement();
            // Armar el Query SQL Con los datos pasados por parámetro
            String sql = "select * from empleados where id_empleado = '" + idEmplado + "';";
            //Ejecutar
            rs = st.executeQuery(sql);
            if (rs.next()) {
                variables.setId_empleado(rs.getString("id_empleado"));
                variables.setNombre(rs.getString("nombre"));
                variables.setApellido(rs.getString("apellido"));
                variables.setPuesto(rs.getString("puesto"));
            } else {
                variables.setId_empleado("");
                variables.setNombre("");
                variables.setApellido("");
                variables.setPuesto("");
                JOptionPane.showMessageDialog(
                        null,
                        "No se encontro ningun registro",
                        "Error de busqueda",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            //Si ocurre un error mostrarlo
            JOptionPane.showMessageDialog(
                    null,
                    "Error en el sistema de busqueda",
                    "Error de busqueda",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void actualizar(
            String nombre, 
            String apellido, 
            String puesto, 
            String idEmpleado
    ) {
        try {
            // Iniciar la conexión
            Connection conexion = conectar();
            st = conexion.createStatement();
            // Armar el Query SQL Con los datos pasados por parámetro
            String sql = "update empleados set "
                    + "nombre='"+ nombre +"', "
                    + "apellido='"+ apellido +"', "
                    + "puesto='"+ puesto +"' "
                    + "where id_empleado='"+ idEmpleado 
                    +"';";
            //Ejecutar
            st.executeUpdate(sql);
            // Si todo resultó mostrar mensaje y cerrar la conexión
            JOptionPane.showMessageDialog(
                    null, 
                    "El registro se actualizo", 
                    "Exito", 
                    JOptionPane.INFORMATION_MESSAGE
            );
            st.close();
            conexion.close();
        } catch (Exception e) {
            //Si ocurre un error mostrarlo
            JOptionPane.showMessageDialog(
                    null, 
                    "Error al actualizar: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    public void eliminar(String idEmpleado){
         try {
             // Iniciar la conexión
            Connection conexion = conectar();
            st = conexion.createStatement();
            // Armar el Query SQL Con los datos pasados por parámetro
            String sql = "delete from empleados "
                    + "where id_empleado='"+ idEmpleado 
                    +"';";
            //Ejecutar
            st.executeUpdate(sql);
            // Si todo resultó mostrar mensaje y cerrar la conexión
            JOptionPane.showMessageDialog(
                    null, 
                    "Registro Elimindo conrrectamente", 
                    "Eliminar", 
                    JOptionPane.INFORMATION_MESSAGE
            );
            st.close();
            conexion.close();
        } catch (Exception e) {
            //Si ocurre un error mostrarlo
            JOptionPane.showMessageDialog(
                    null, 
                    "Error al eliminar registro", 
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
