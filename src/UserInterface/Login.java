package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import BusinessLogic.Entities.User;
import DataAccess.UserDAC;
import Framework.AppConfiguration;

public class Login extends JFrame {
    private JTextField hjUser;
    private JPasswordField hjPassword;
    private JLabel hjUserLogin;
    private JLabel hjPasswordLogin;
    private JButton hjLogin;

    private int hjIntentos = 0;
    private final int hjMaxIntentos = 3;
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 150);

        hjUserLogin = new JLabel("Usuario:");
        hjUser = new JTextField(17);
        hjPasswordLogin = new JLabel("Contraseña:");
        hjPassword = new JPasswordField(14);
        hjLogin = new JButton("Ingresar");

        JPanel panel = new JPanel();
        panel.add(hjUserLogin);
        panel.add(hjUser);
        panel.add(hjPasswordLogin);
        panel.add(hjPassword);
        panel.add(hjLogin);

        getContentPane().add(panel);

        hjLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hjIntentosRestantes = 2;
                String user = hjUser.getText();
                String password = new String(hjPassword.getPassword());

                // Encripta la contraseña ingresada
                String encryptedPassword = encriptarContraseña(password);

                // Verifica el usuario y la contraseña usando la clase DataAccess
                UserDAC userDAC = new UserDAC(AppConfiguration.getDBPathConnection());
                List<User> userList = null;
                try {
                    userList = userDAC.getAllUsers();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                // Busca el usuario en la lista de usuarios y compara las contraseñas
                boolean hjUserFound = false;
                for (User retrievedUser : userList) {
                    if (retrievedUser.getHj_username().equals(user)) {
                        String retrievedPassword = retrievedUser.getHj_password();
                        

                        if (encryptedPassword.equals(retrievedPassword)) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
                            hjIntentos = 0;
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta."+" Quedan "+(hjIntentosRestantes-hjIntentos)+" intentos");
                            hjIntentos++;
                        }
                        hjUserFound = true;
                        break;
                    }
                }

                if (!hjUserFound) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta."+" Quedan "+(hjIntentosRestantes-hjIntentos)+" intentos");
                    
                    hjIntentos++;
                }
                if (hjIntentos >= hjMaxIntentos) {
                    JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos. Saliendo de la aplicación.");
                    System.exit(0);
                }
            }
        });

    }

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

}
