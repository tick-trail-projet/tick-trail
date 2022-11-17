package user;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

import database.Mysql;

public class User extends Mysql implements UserInterface {

    // 4-8 character password requiring numbers and alphabets of both cases
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

    // 4-32 character password requiring at least 3 out of 4 (uppercase
    // and lowercase letters, numbers & special characters) and at-most
    // 2 equal consecutive chars.
    private static final String COMPLEX_PASSWORD_REGEX = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|"
            + "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" + "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|"
            + "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})"
            + "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" + "{8,32}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(COMPLEX_PASSWORD_REGEX);

    public User() {
        super();
    }

    public void create(String name, String surname, int phone, String email, String adress, String city) {
        if (exist(email) == true) {
            super.runQuery(
                    "INSERT INTO `users`(`name`, `surname`, `phone`, `email`, `adress`, `city`) VALUES ('" + name
                            + "','" + surname + "','" + phone + "','" + email + "','" + adress + "','" + city + "')");
        }
    }

    public boolean exist(String email) {
        Map<String, Object> user = super.getSingleQuery("SELECT * FROM users WHERE users.email = \"" + email + "\"");
        if (!user.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Object> get(String email) {
        if (exist(email) == true) {
            Map<String, Object> user = super.getSingleQuery(
                    "SELECT * FROM users WHERE users.email = \"" + email + "\"");
            return user;
        } else {
            return Collections.emptyMap();
        }
    }

    public void login(String email, String password) {

    }

    public void logout(String id) {
        System.out.println("test");
    }

    public static void main(String[] args) {
        System.out.println(new User().get("dd"));
    }
}
