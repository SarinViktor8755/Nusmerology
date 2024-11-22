package org.example.users;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Array_of_responses {

    static final String FILE_ANSER = "asssets/array_of_responses.txt";

    public static void main(String[] args) {
        System.out.println(read_file(101));

    }


    public static String getWord(int pos) throws IOException {
        pos--;
        System.out.println("POS  " + (1 + pos));
        try (Stream lines = Files.lines(Paths.get(FILE_ANSER))) {
            String extractedLine = (String) lines.skip(pos).findFirst().get();
            return extractedLine;
        }

    }


    public static String read_file(int pos) {
        System.out.println("FINE_FILE :: " + pos + ".txt");
        Scanner scanner = null;

        // scanner = new Scanner(new File("asssets/" + pos + ".txt"));
        String str = null;
        try {
            str = Files.readString(new File("text/" + pos + ".txt").toPath());


            // Printing the string
            System.out.println(str);
            return str;
        } catch (IOException e) {
            return "FILE_NOT_FOUND : " +  "text/" + pos + ".txt";
        }

    }


}
