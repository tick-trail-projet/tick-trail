package com.ticktrail.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserInterface {
    public void create(String name, String password, String surname, String phone, String email, String adress,
            String city);

    public Map<String, Object> get(String email);

    public boolean exist(String email);

    public void login(String email) throws IOException;

    public void logout() throws IOException;
}
