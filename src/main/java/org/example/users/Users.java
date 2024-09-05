package org.example.users;

import java.util.HashMap;

public class Users {
    private static HashMap<Long, User> users = new HashMap<>();

    static public User fine_user(Long id_user) {
        User user = users.get(id_user);
        if (user == null) {
            users.put(id_user, new User());
            user = users.get(id_user);
        }
        return user;
    }

    public static HashMap<Long, User> getUsers() {
        return users;
    }

}
