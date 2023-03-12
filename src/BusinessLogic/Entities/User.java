package BusinessLogic.Entities;

public class User {
    private String hj_username;
    private String hj_password;

    public User(String hj_username, String hj_password) {
        this.hj_username = hj_username;
        this.hj_password = hj_password;
    }

    public String getHj_username() {
        return hj_username;
    }

    public String getHj_password() {
        return hj_password;
    }
}

