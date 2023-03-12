package BusinessLogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import BusinessLogic.Entities.User;
import DataAccess.UserDAC;

public class UserBL {
    private UserDAC userDAC;

    public UserBL(UserDAC userDAC) {
        this.userDAC = userDAC;
    }

    public boolean validateUser(String username, String password) throws SQLException {
        User user = userDAC.getUserByUsername(username);

        if (user == null) {
            return false;
        }

        String encryptedPassword = encryptPassword(password);

        return encryptedPassword.equals(user.getPassword());
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
}

