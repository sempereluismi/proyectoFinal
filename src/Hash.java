import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author a22luismsg
 */
public class Hash {
    public static String calcularHash(String password) {
        byte[] salt = "DAW1".getBytes(StandardCharsets.UTF_8);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 512);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            // Conversión a cadena hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Non existe o algoritmo");
        } catch (InvalidKeySpecException e) {
            System.out.println("Erro coa clave");
            e.printStackTrace();
        }
        return null;
    }
}
