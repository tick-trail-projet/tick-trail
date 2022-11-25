package com.ticktrail.user;

import java.util.List;
import java.util.Map;

public interface UserInterface {
    public void create(String name, String surname, int phone, String email, String adress, String city);

    public Map<String, Object> get(String email);

    public boolean exist(String email);

    public void login(String email, String password);

    public void logout(String id);
}
