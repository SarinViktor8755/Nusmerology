package org.example.users;

import java.util.HashMap;
import java.util.Map;

public class Users {

    public static Integer ETAP_NOTH_DATE = 0;
    public static Integer ETAP_IN_MAIN_MENU = 1;
    public static Integer ETAP_ENTER_DB_PARTNER = 2;



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

    public static void print_users(){

        for (Map.Entry<Long, User> entry : users.entrySet()) {
            Long key = entry.getKey(); // Ключ (ID пользователя)
            User user = entry.getValue(); // Значение (объект User)
            System.out.println("User ID: " + key + ", Name: " + user);
        }
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
