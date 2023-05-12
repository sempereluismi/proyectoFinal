
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author a22luismsg
 */
public class DAO {

    private String usuario;
    private String contraseña;

    public DAO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Coge las tareas para ponerlas en la lista de tareas
     */
    public ArrayList getTareasUsuario(String nombreUsuario) {
        String consulta
                = "SELECT texto, estado, fechaInicio, idTarea from tarea WHERE idUsuario IN "
                + "(SELECT idUsuario FROM usuario WHERE nombre =  ?  ) ORDER BY estado DESC;";
        ResultSet resultado = null;
        ArrayList<Tarea> tareas = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();

            while (resultado.next()) {
                tareas.add(new Tarea(resultado.getString(1), resultado.getString(2),
                        resultado.getString(3), resultado.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        return tareas;
    }

    /**
     * Sirve para que los usuarios puedan iniciar sesion si han creado su cuenta
     */
    public boolean inicioSesión(String nombreUsuario, String contraseña) {

        String consulta
                = "SELECT contrasena FROM usuario WHERE nombre = ?";
        ResultSet resultado = null;
        String contraseñaBD = "";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                contraseñaBD = resultado.getString(1);
            } else {
                return false;
            }

            return (Hash.calcularHash(contraseña).equals(contraseñaBD));

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return true;
    }

    /**
     * Sirve para indicar la creación de una nueva entrada en la tabla usuario.
     */
    public boolean crearUsuario(String nombreUsuario, String contraseña, String correo, String fechaNacimiento) {
        String consulta = "INSERT INTO usuario ( nombre, contrasena, correo, fechaNacimiento ) values (?, ?, ?, ?);";
        int resultado = 0;
        String newContraseña = Hash.calcularHash(contraseña);

        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            ps.setString(2, newContraseña);
            ps.setString(3, correo);
            ps.setString(4, fechaNacimiento);

            resultado = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return (resultado == 1);
    }

    /**
     * Sirve para saber si el usuario es normal o administrador.
     */
    public String getTipoUsuario(String nombreUsuario) {
        String consulta = "SELECT tipoUsuario FROM usuario WHERE nombre = ?;";
        ResultSet resultado = null;
        String tipoUsuario = "";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                tipoUsuario = resultado.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return tipoUsuario;
    }

    /**
     * Comprueba el ID del usuario.
     */
    public int getIdUsuario(String nombreUsuario) {
        String consulta = "SELECT idUsuario FROM usuario WHERE nombre = ?;";
        ResultSet resultado = null;
        int idUsuario = 0;
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                idUsuario = resultado.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return idUsuario;
    }

    /**
     * Manda un mensaje de error en caso de que se intente crear un usuario que ya exista en la base de datos.
     */
    private boolean comprobarTextoRepetido(String nombreUsuario, String texto) {
        String idUsuario = Integer.toString(getIdUsuario(nombreUsuario));
        String consulta = "SELECT texto FROM tarea WHERE idUsuario = ?;";
        ResultSet resultado = null;
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, idUsuario);
            resultado = ps.executeQuery();

            while (resultado.next()) {
                if (resultado.getString(1).equals(texto)) {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return true;
    }

    /**
     * Añade una tarea nueva que el usuario cree a su lista de tareas.
     */
    public boolean insertTarea(String nombreUsuario, String texto) {
        String idUsuario = Integer.toString(getIdUsuario(nombreUsuario));
        String consulta = "INSERT INTO tarea ( idUsuario, texto, fechaInicio ) values (?, ?, now());";
        int resultado = 0;
        String newContraseña = Hash.calcularHash(contraseña);

        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, idUsuario);
            ps.setString(2, texto);
            if (comprobarTextoRepetido(nombreUsuario, texto)) {
                resultado = ps.executeUpdate();
            } else {
                resultado = 0;
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        return (resultado == 1);
    }

    /**
     * Cambia el estado de las tareas de activa a hecha y viceversa.
     */
    public void cambiarEstado(String idTarea, String estado) {
        String consulta = "UPDATE tarea SET estado = ? WHERE idTarea = ?;";
        int resultado = 0;
        String newContraseña = Hash.calcularHash(contraseña);

        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, estado);
            ps.setString(2, idTarea);

            resultado = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
    }

    /**
     * Elimina las tareas del usuario que este seleccione.
     */
    public boolean eliminarTarea(String idTarea) {
        String consulta = "DELETE FROM tarea WHERE idTarea = ?;";
        int resultado = 0;
        String newContraseña = Hash.calcularHash(contraseña);

        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, idTarea);

            resultado = ps.executeUpdate();
            System.out.println(resultado);
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        
        return (resultado == 1);
    }

}
