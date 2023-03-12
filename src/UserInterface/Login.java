package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JFrame {
    private JTextField tfUser;
    private JPasswordField pfPassword;
    private JLabel lbUser;
    private JLabel lbPassword;
    private JButton btnLogin;
    
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 150);
        
        
        lbUser = new JLabel("User:");
        tfUser = new JTextField(17);
        lbPassword = new JLabel("Password:");
        pfPassword = new JPasswordField(14);
        btnLogin = new JButton("Ingresar");
        
        JPanel panel = new JPanel();
        panel.add(lbUser);
        panel.add(tfUser);
        panel.add(lbPassword);
        panel.add(pfPassword);
        panel.add(btnLogin);
        
        getContentPane().add(panel);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUser.getText();
                String password = new String(pfPassword.getPassword());
                
                // Encripta la contraseña ingresada
                String encryptedPassword = encryptPassword(password);
                
                // Conecta a la base de datos y verifica el usuario y la contraseña
                try {
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
                    String query = "SELECT password FROM users WHERE username = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, user);
                    ResultSet rs = stmt.executeQuery();
                    
                    if (rs.next()) {
                        String storedPassword = rs.getString("password");
                        String encryptedStoredPassword = encryptPassword(storedPassword);
                        
                        if (encryptedPassword.equals(encryptedStoredPassword)) {
                            JOptionPane.showMessageDialog(null, "Login successful");
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect username or password");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    }
                    
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
