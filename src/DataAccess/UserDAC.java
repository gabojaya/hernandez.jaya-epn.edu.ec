package DataAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.User;

public class UserDAC extends SQLiteDataHelper {

    public UserDAC(String dbPathConnection) {
        super(dbPathConnection);
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM HJ_USERS;";
        ResultSet rs = getResultSet(sql);
        List<User> users = new ArrayList<>();

        while (rs.next()) {
            String username = rs.getString("hj_username");
            String password = rs.getString("hj_password");
            User user = new User(username, password);
            users.add(user);
        }

        return users;
    }
}
