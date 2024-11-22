package org.example.users;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Save_to_disk {
    static String users_file = "asssets/users_kist.txt";

    public static void save_to_disk_users() {
        StringBuilder sb = new StringBuilder();
        Users.getUsers().forEach((key, value) -> sb.append(key + "," + value.getEtap() +","+value.getDate_birth() + "\n"));
        String fileName = users_file;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void load_to_disk_points_for_users() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(users_file));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line

                User user = new User();

                String[] split_l = line.split(",");
                user.setEtap(Integer.valueOf(split_l[1]));
                user.setDate_birth(String.valueOf(split_l[2]));
                Users.getUsers().put(Long.valueOf(split_l[0]),user);
                //  System.out.println("!!" + split_l[2]);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void load_to_disk_points_for_users1() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("https://docs.google.com/spreadsheets/d/1IgKUyj7ua7S2hRyJKEs_8UTQIBBL683JVlKa7CW9_xY/edit?usp=sharing"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line

//                User user = new User();
//
//                String[] split_l = line.split(",");
//                user.setEtap(Integer.valueOf(split_l[1]));
//                user.setDate_birth(String.valueOf(split_l[2]));
//                Users.getUsers().put(Long.valueOf(split_l[0]),user);
//                //  System.out.println("!!" + split_l[2]);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
