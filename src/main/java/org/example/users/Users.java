package org.example.users;

import java.util.HashMap;

public class Users {
    private static HashMap<Long, User> users = new HashMap<>();
    public static Long[] admin_array = {299695014L,857455521L};

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

    public static boolean isAdmin(Long id_user){
        for (Long id : admin_array) {
            if (id_user.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static String getNameuser(){
        StringBuilder sb = new StringBuilder();
        return "";
    }

}
