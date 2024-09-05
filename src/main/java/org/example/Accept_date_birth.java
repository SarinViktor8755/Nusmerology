package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Accept_date_birth {
    static String get_date(String strDate) {
        final List<String> dateFormats = Arrays.asList("dd-MM-yyyy", "MM-dd-yyyy", "MM/dd/yyyy", "dd/MM/yyyy", "dd.MM.yy", "dd.MM.yyyy", "dd MM yy", "dd MM YYyy", "dd_MM_yy", "dd/MM/yyyy","dd,MM,yy","dd.MM.yyyy");
        SimpleDateFormat sdf;
        //Наш формат
        final String RU_FORMAT = "dd.MM.yyyy";
        String output = "-";
        //Пробегаем по всем паттернам
        for (String format : dateFormats) {
            sdf = new SimpleDateFormat(format, new Locale("ru"));
            //не пытаться анализировать даты, которые не совпадают с форматом
            sdf.setLenient(false);
            try {
                if (sdf.parse(strDate) != null) {
                    Date date = sdf.parse(strDate);
                    sdf.applyPattern(RU_FORMAT);
                    //Accept_date_birth.currect_date_birth(sdf.format(date));
                    return currect_date_birth(sdf.format(date));
                }
                break;
            } catch (ParseException|NullPointerException e) {
                // e.printStackTrace();
            }
        }
        return "";
    }

    static private String currect_date_birth(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(strDate, formatter);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        //  System.out.println(period.getYears() + " !!!");      // 4
        if (period.getYears() > 100) {
            while (period.getYears() > 100) {
                startDate = startDate.plusYears(100);
                period = Period.between(startDate, endDate);
                //  System.out.println("+");
            }
        }
//        System.out.println(period.getYears() + " ---");
//        System.out.println(startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));


        return startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }




    static public int[] get_10_ches(String ches) throws ParseException {
        int[] arr = new int[3];
        String[] ps = ches.split(Pattern.quote("."));
        try {


            for (int i = 0; i < ps.length; i++) {
                System.out.println(ps[i]);
              //  arr[i] = reduce_number_to_single_digit(Integer.valueOf(ps[i]));
            }
        } catch (NumberFormatException e) {
            for (int i = 0; i < arr.length; i++) {

                arr[i] = 0;
            }
            return arr;
        }
        return arr;
    }
}

