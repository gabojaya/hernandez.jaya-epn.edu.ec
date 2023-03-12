package BusinessLogic;
import java.sql.SQLException;
import java.util.List;

import BusinessLogic.Entities.User;
import DataAccess.UserDAC;

public class UserBL {
    private UserDAC userDAC;

    public UserBL(UserDAC userDAC) {
        this.userDAC = userDAC;
    }

    public boolean login(String username, String password) {
        try {
            List<User> users = userDAC.getAllUsers();
            for (User user : users) {
                if (user.getHj_username().equals(username) && user.getHj_password().equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(">> (error) UserBL.login() "+ e.getMessage());
        }

        return false;
    }
}
