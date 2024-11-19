package org.example.users;

import java.io.File;
import java.io.IOException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Array_of_responses {

    static final String FILE_ANSER = "array_of_responses.txt";




    public static String getWord(int pos) throws IOException {
        System.out.println("POS  " + pos);
        String word = "";
        int i = 0;
        Scanner sc = new Scanner(new File(FILE_ANSER));
        while (i != pos) {
            try {
                i++;
                sc.next();
                if (i == pos) {
                    word = sc.next();

                }
            } catch (NoSuchElementException e) {
                word = "";
            }
        }
        return word;
    }


}
