
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import BusinessLogic.Entities.User;
import DataAccess.UserDAC;
import Framework.AppConfiguration;
import UserInterface.Login;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {

    public static String encriptarContraseña(String contraseña) {
        try {
            // Obtener instancia de MessageDigest con algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convertir contraseña a bytes y pasarla al MessageDigest
            md.update(contraseña.getBytes());

            // Obtener la suma de verificación resultante como matriz de bytes
            byte[] digest = md.digest();

            // Convertir la matriz de bytes a formato hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b & 0xff));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción si el algoritmo no está disponible
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        AppConfiguration.load("config.properties");
        System.out.println(AppConfiguration.getDBName());
        System.out.println(AppConfiguration.getDBPathConnection());

        // Encriptando Contraseñas
        String password1 = "1754242632";
        String hashedPassword1 = encriptarContraseña(password1);
        System.out.println("Contraseña encriptada: " + hashedPassword1);
        String password2 = "2205783218";
        String hashedPassword2 = encriptarContraseña(password2);
        System.out.println("Contraseña encriptada: " + hashedPassword2);
        String password3 = "1234";
        String hashedPassword3 = encriptarContraseña(password3);
        System.out.println("Contraseña encriptada: " + hashedPassword3);

        UserDAC userDAC = new UserDAC(AppConfiguration.getDBPathConnection());
        List<User> userList = userDAC.getAllUsers();

        // Iterar sobre la lista de usuarios y mostrar los nombres de usuario y
        // contraseñas
        for (User user : userList) {
            String username = user.getHj_username();
            String password = user.getHj_password();
            System.out.println("Username: " + username + ", Password: " + password);
        }
        // Crear y hacer visible la pantalla de login
        Login login = new Login();
        login.setVisible(true);
    }
}
