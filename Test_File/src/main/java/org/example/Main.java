package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 22; j++) {
                int num = (i * 100) + j;
                String fileName = "text/" + num + ".txt";
                File file = new File(fileName);
                //  System.out.println("Does file exist? " + file.exists());
                if (!file.exists()) System.out.println("NOT_FILE " + file);
            }
        }
    }
}