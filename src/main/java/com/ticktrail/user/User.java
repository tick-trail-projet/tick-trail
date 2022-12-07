package com.ticktrail.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.ticktrail.database.Mysql;
import com.ticktrail.database.Storage;

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

    public void create(String name, String password, String surname, String phone, String email, String adress,
            String city) {
        if (exist(email) == false) {
            super.runQuery(
                    "INSERT INTO `users`(`name`, `password`, `surname`, `phone`, `email`, `adress`, `city`, `token`) VALUES ('"
                            + name
                            + "','" + password
                            + "','" + surname + "','" + phone + "','" + email + "','" + adress + "','" + city + "','"
                            + generateToken() + "')");
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

    public Map<String, Object> getWithToken() throws IOException {
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
        String token = storage.read_file();
        Map<String, Object> user = super.getSingleQuery(
                "SELECT * FROM users WHERE users.token = \"" + token + "\"");
        return user;
    }

    public void login(String email) throws IOException {
        if (exist(email)) {
            Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
            storage.write_file(get(email).get("token").toString());
        }
    }

    public boolean isLogin() throws IOException {
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
        String token = storage.read_file();
        Map<String, Object> user = super.getSingleQuery(
                "SELECT users.token FROM users WHERE users.token = \"" + token + "\"");
        return user.isEmpty() ? false : true;
    }

    public void logout() throws IOException {
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
        storage.clear_file();
    }

    public String generateToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static void main(String[] args) {
        System.out.println(new User().get("dd"));
    }
}
