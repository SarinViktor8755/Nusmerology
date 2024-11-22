package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Service {

    public static Integer LICHNOST = 1;
    public static Integer DUCHOVNOST = 2;
    public static Integer FINANS = 3;
    public static Integer ZDOROVIE = 4;
    public static Integer OTNOSHENIE = 5;
    public static Integer MISSION_DUSHI = 6;

    public static int[] calculate_success_code() {
        int[] cods = {10, 20, 30, 40};
        return cods;
    }

    public static Calendar StringToCalendar(String date_b) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = sdf.parse(date_b);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            return cal;
        } catch (ParseException e) {
            return null;
        }

    }


    static public int reduce_number_to_single_digit(int in, int to) {
        if (in <= to) return in;
        int result = in;
        while (result > to) {
            //    System.out.println(result +" > " + to);
            List<Integer> numbers = Arrays
                    .stream(String.valueOf(result).split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            //    System.out.println(numbers);
            result = numbers.stream().mapToInt(Integer::intValue).sum();
            // System.out.println(result);
        }
        //  System.out.println("..." + result);
        // System.out.println();
        //  if(result>to) reduce_number_to_single_digit(result,to);
        return result;
    }

    static public HashMap<Integer, Integer> calck_number_(String birthday, int raz) {
        HashMap<Integer, Integer> nomera = new HashMap<>();

        Calendar calendar = Service.StringToCalendar(birthday);

        nomera.put(LICHNOST, 1);
        nomera.put(DUCHOVNOST, 2);
        nomera.put(FINANS, 3);

        nomera.put(OTNOSHENIE, 4);
        nomera.put(ZDOROVIE, 5);
        nomera.put(MISSION_DUSHI, 6);
        //   System.out.println("1");
        int lig = Service.reduce_number_to_single_digit(calendar.get(Calendar.DAY_OF_MONTH), raz);
        int duh = Service.reduce_number_to_single_digit(calendar.get(Calendar.MONTH) + 1, raz);
        int finans = Service.reduce_number_to_single_digit(calendar.get(Calendar.YEAR), raz);
        //   System.out.println("2");
        int otnoh = Service.reduce_number_to_single_digit(lig + duh + finans, raz);
        //   System.out.println("3");
        int zdor = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh, raz);
        int missia_duh = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh + zdor, raz);
        //System.out.println("3");
        nomera.put(LICHNOST, lig);
        nomera.put(DUCHOVNOST, duh);
        nomera.put(FINANS, finans);
        //  System.out.println("4");
        nomera.put(OTNOSHENIE, otnoh);
        nomera.put(ZDOROVIE, zdor);
        nomera.put(MISSION_DUSHI, missia_duh);
        // System.out.println("5");

        nomera.put(11, Service.reduce_number_to_single_digit(lig + duh, raz));
        nomera.put(12, Service.reduce_number_to_single_digit(duh + finans, raz));
        nomera.put(13, Service.reduce_number_to_single_digit(zdor + lig, raz));
        nomera.put(14, Service.reduce_number_to_single_digit(finans + otnoh, raz));
        nomera.put(15, Service.reduce_number_to_single_digit(otnoh + zdor, raz));

        nomera.put(71, Service.reduce_number_to_single_digit(lig + nomera.get(11), raz));
        nomera.put(72, Service.reduce_number_to_single_digit(duh + nomera.get(11), raz));
        nomera.put(73, Service.reduce_number_to_single_digit(nomera.get(2) + nomera.get(12), raz));/////////
        nomera.put(74, Service.reduce_number_to_single_digit(finans + nomera.get(12), raz));
        nomera.put(75, Service.reduce_number_to_single_digit(lig + nomera.get(13), raz));

        nomera.put(76, Service.reduce_number_to_single_digit(zdor + nomera.get(15), raz));
        nomera.put(77, Service.reduce_number_to_single_digit(zdor + nomera.get(13), raz));
        nomera.put(78, Service.reduce_number_to_single_digit(otnoh + nomera.get(15), raz));
        nomera.put(79, Service.reduce_number_to_single_digit(otnoh + nomera.get(14), raz));
        nomera.put(80, Service.reduce_number_to_single_digit(finans + nomera.get(14), raz));

        nomera.put(91, Service.reduce_number_to_single_digit(nomera.get(11) + nomera.get(12), raz));
        nomera.put(92, Service.reduce_number_to_single_digit(nomera.get(11) + nomera.get(13), raz));
        nomera.put(93, Service.reduce_number_to_single_digit(nomera.get(12) + nomera.get(14), raz));
        nomera.put(94, Service.reduce_number_to_single_digit(nomera.get(13) + nomera.get(15), raz));
        nomera.put(95, Service.reduce_number_to_single_digit(nomera.get(15) + nomera.get(14), raz));
        //   System.out.println("!!!!!!!!!!!");
//        for (Integer key : nomera.keySet()) {
//            System.out.println(key + "=" + nomera.get(key));
//        }


        return nomera;
    }


}
