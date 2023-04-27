
import java.sql.*;

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

    public ResultSet getTareasUsuario(String nombreUsuario) {
        String consulta
                = "SELECT texto, estado, fechaInicio, fechaFin from tarea WHERE idUsuario IN "
                + "(SELECT idUsuario FROM usuario WHERE nombre =  ?  );";
        ResultSet resultado = null;
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return resultado;
    }

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

            if (Hash.calcularHash(contraseña).equals(contraseñaBD)) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }

        return true;
    }

    public boolean crearUsuario(String nombreUsuario, String contraseña, String correo, String fechaNacimiento) {
        String consulta = "INSERT INTO usuario ( nombre, contrasena, correo, fechaNacimiento ) values (?, ?, ?, ?);";
        int resultado = 0;
        String newContraseña = Hash.calcularHash(this.contraseña);

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

    public String getTipoUsuario(String nombreUsuario) {
        String consulta = "SELECT tipoUsuario FROM usuario WHERE nombre = ?;";
        ResultSet resultado = null;
        String tipoUsuario = "";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://192.168.109.08:3306/proyectofinal", this.usuario, this.contraseña); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();
            
            if ( resultado.next() ) {
                tipoUsuario = resultado.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode()
                    + "\nSLQState: " + e.getSQLState()
                    + "\nMensaje: " + e.getMessage());
        }
        
        return tipoUsuario;
    }
}
