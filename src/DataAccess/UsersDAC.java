package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAC {
    private Connection conn;

    public UserDAC(String dbPath) throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM HJ_USERS WHERE hj_username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String password = rs.getString("hj_password");
            return new User(username, password);
        } else {
            return null;
        }
    }

    public void close() throws SQLException {
        conn.close();
    }
}

