
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import BusinessLogic.Entities.User;
import DataAccess.UserDAC;
import Framework.AppConfiguration;
import UserInterface.CoordenadasGUI;
import UserInterface.Login;


public class App {

    public static String encriptarContraseña(String hjcontraseña) {
        try {
            // Obtener instancia de MessageDigest con algoritmo MD5
            MessageDigest hjmd = MessageDigest.getInstance("MD5");

            // Convertir contraseña a bytes y pasarla al MessageDigest
            hjmd.update(hjcontraseña.getBytes());

            // Obtener la suma de verificación resultante como matriz de bytes
            byte[] hjdigest = hjmd.digest();

            // Convertir la matriz de bytes a formato hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hjdigest) {
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
        //Establezco conexion con la base de datos
        AppConfiguration.load("config.properties");
        System.out.println(AppConfiguration.getDBName());
        System.out.println(AppConfiguration.getDBPathConnection());

        // Encriptando Contraseñas
        String hjpassword1 = "1754242632";
        String hjhashedPassword1 = encriptarContraseña(hjpassword1);
        System.out.println("Contraseña encriptada: " + hjhashedPassword1);
        String hjpassword2 = "1721138988";
        String hjhashedPassword2 = encriptarContraseña(hjpassword2);
        System.out.println("Contraseña encriptada: " + hjhashedPassword2);
        String hjpassword3 = "1234";
        String hjhashedPassword3 = encriptarContraseña(hjpassword3);
        System.out.println("Contraseña encriptada: " + hjhashedPassword3);

        UserDAC hjuserDAC = new UserDAC(AppConfiguration.getDBPathConnection());
        List<User> userList = hjuserDAC.getAllUsers();

        // Iterar sobre la lista de usuarios y mostrar los nombres de usuario y contraseñas
        for (User hjuser : userList) {
            String username = hjuser.getHj_username();
            String password = hjuser.getHj_password();
            System.out.println("Usuario: " + username + ", Contraseña encriptada: " + password);
        }
        // Crear y hacer visible la pantalla de login
        // Login login = new Login();
        // login.setVisible(true);

        CoordenadasGUI cor = new CoordenadasGUI();
        cor.setVisible(true);














    }
}
